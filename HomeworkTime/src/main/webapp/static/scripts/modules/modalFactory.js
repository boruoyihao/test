define(function(require) {
    var $ = require('jquery'),
        hbs = require('handlebars'),
        tmpl = require('templates'),
        bs = require('bootstrap');

    var modalFactory = function(options) {
        this.options = $.extend({
            title: '...',
            content: '...',
            confirmAction: $.noop
        }, options);

        this.init();
    };

    modalFactory.prototype.render = function() {
        var op = this.options,
            data = {
                title: op.title,
                content: op.content
            },
            tpl = JIT['templates/modal/frame.hbs'](data);

        this.modal = $(tpl).modal();
    };

    modalFactory.prototype.bindEvents = function() {
        var self = this;
        this.modal.on('hidden.bs.modal', function(e) {
            $(this).remove();
        });
        this.modal.find('.btn-confirm').on('click', function(e) {
            self.options.confirmAction();
            self.modal.modal('hide');
        });
    };

    modalFactory.prototype.init = function() {
        this.render();
        this.bindEvents();
    };

    return modalFactory;
});
