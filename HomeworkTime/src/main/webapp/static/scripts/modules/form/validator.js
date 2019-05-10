define(['jquery', 'modules/form/util'], function($, util) {

    var regPattern = util.regPattern;

    var Validator = function(form, ajaxOptions) {

        this.selector = {
            'parent-group': '.form-group',
            'msg-icon': '.glyphicon',
            'error-msg': '.error-msg'
        };

        this.msgClassMap = {
            feedback: 'has-feedback',
            success: 'has-success',
            error: 'has-error',
            iconOk: 'glyphicon-ok',
            iconError: 'glyphicon-remove'
        };
        this.validateFields = {};
        this.form = form;
        this.btnSubmit = $('[type="submit"]', this.form);
        this.ajaxOptions = ajaxOptions || {};

        this.init();
    };

    Validator.prototype.getAllValidateFields = function() {
        var i,
            fields = $('[data-validation]', this.form);

        this.fields = fields;

        for(i = 0, len = fields.length; i < len; i++) {
            var field = $(fields[i]),
                id = field.attr('id'),
                options = field.data('validation').split('|');

            var group = field.parents(this.selector['parent-group']),
                icon = group.find(this.selector['msg-icon']),
                msg = group.find(this.selector['error-msg']);

            this.validateFields[id] = {
                field: field,
                options: options,
                group: group,
                icon: icon,
                msg: msg,
                pending: false,
                passed: undefined,
                afterSubmit: false
            };

        }
    };

    Validator.prototype.cleanup = function(id, field) {
        field.pending = false;
        if(field.afterSubmit) {
            this.beforeSubmit();
            field.afterSubmit = false;
        }
        field.field.trigger(id+'-event', field.passed);
        field.options = field.field.data('validation').split('|');
    };

    // 显示验证信息
    Validator.prototype.showMsg = function(id, result, code) {
        var field = this.validateFields[id],
            group = field.group,
            icon = field.icon,
            cmap = this.msgClassMap;

        // group.addClass(cmap['feedback']);
        if(result === 'succed') {
            group.removeClass(cmap['error']).addClass(cmap['success']);
            icon.removeClass(cmap['iconError']).addClass(cmap['iconOk']);
            field.passed = true;
        } else if(result === 'failed') {
            field.msg.html(util.errorMsg[code]);
            group.removeClass(cmap['success']).addClass(cmap['error']);
            icon.removeClass(cmap['iconOk']).addClass(cmap['iconError']);
            field.passed = false;
        }

        this.cleanup(id, field);
    };

    // 浏览器端验证
    Validator.prototype.clientCheck = function(id, type) {
        var item = this.validateFields[id],
            field = item.field,
            val = $.trim(field.val()),
            result;

        result = regPattern[type].test(val);
        if(field.data('require') === 'empty' && val === '') { // 特殊处理可以为空的情况
            result = true;
        }
        if(result) {
            this.checkField(id);
        } else {
            this.showMsg(id, 'failed', field.data('code'));
            item.passed = false;
        }
    };

    // 服务器端验证
    Validator.prototype.remoteCheck = function(id) {
        var self = this,
            item = this.validateFields[id],
            field = item.field,
            url = field.data('async'),
            val = $.trim(field.val()),
            data = field.data('attr')+'='+val;

        item.pending = true;

        $.ajax({
            url: url,
            type: 'post',
            data: data,
            dataType: 'json',
            success: function(data) {
                if(data.code === 0) {
                    self.checkField(id);
                } else {
                    self.showMsg(id, 'failed'/*, data.code*/);
                }
            },
            error: function() { }
        });
    };

    Validator.prototype.checkField = function(id) {
        var self = this,
            checkfield = this.validateFields[id],
            checklist = checkfield.options;

        if(checklist.length <= 0) {
            this.showMsg(id, 'succed');
            return;
        }

        var type = checklist.shift();
        if(type === 'async') {
            self.remoteCheck(id);
        } else {
            self.clientCheck(id, type);
        }
    };

    Validator.prototype.beforeSubmit = function() {
        var canSubmit = true;
        for(var id in this.validateFields) {
            var field = this.validateFields[id];
            if((typeof field.passed === 'undefined' && !field.pending) || field.field.is(':focus')) {
                field.afterSubmit = true;
                field.field.trigger('blur');
                canSubmit = false;
            } else if(field.pending) {
                field.afterSubmit = true;
                canSubmit = false;
            } else if(!field.passed) canSubmit = false;
        }
        if(canSubmit) this.submitForm();
    };

    Validator.prototype.submitForm = function() {
        var self = this;
        var data = (this.ajaxOptions.isFormData ? new FormData(this.form.get(0)) : this.form.serialize());


        var options = {
            type:'post',
            url: this.form.attr('action'),
            data: data,
            success: function(data) {
                self.form.trigger('submit-success', data);     // 注册成功后trigger success event
            },
            error: function() {
                self.form.trigger('submit-failed', data);    // 注册失败后trigger failed event
            }
        };

        $.extend(options, this.ajaxOptions);
        var xhr = $.ajax(options);
    };

    Validator.prototype.bindEvents = function() {
        var self = this;
        this.form.on('submit', function(e) {
            e.preventDefault();
            self.beforeSubmit();
        });
        this.fields.on('blur', function() {
            var id = $(this).attr('id');
            self.checkField(id);
        });
        this.form.on('keydown', function(e) {
            if(e.keyCode === 13) {
                self.beforeSubmit();
            }
        });
    };

    Validator.prototype.getFields = function() {
        return this.validateFields;
    };

    Validator.prototype.getForm = function() {
        return this.form;
    };

    Validator.prototype.init = function() {
        this.getAllValidateFields();
        this.bindEvents();
    };

    return Validator;
});
