/* =========================================================
 * bootstrap-validation.js
 * Original Idea: http:/www.newkou.org (Copyright 2012 Stefan Petre)
 * Updated by(https://github.com/FateSheep/Validation-for-Bootstrap)
 * =========================================================
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================= */
! function($) {
    $.fn.validation = function(options) {
        return this.each(function() {
            globalOptions = $.extend({}, $.fn.validation.defaults, options);
            validationForm(this)
        });
    };
    $.fn.validation.defaults = {
        validRules: [{
            name: 'required',
            validate: function(value) {
                return ($.trim(value) == '');
            },
            defaultMsg: '请输入内容'
        }, {
            name: 'number',
            validate: function(value) {
                if(! value) return false;
                return (!/^[0-9]\d*$/.test(value));
            },
            defaultMsg: '请输入数字'
        }, {
            name: 'mail',
            validate: function(value) {
                return (!/^[a-zA-Z0-9]{1}([\._a-zA-Z0-9-]+)(\.[_a-zA-Z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+){1,3}$/.test(value));
            },
            defaultMsg: '请输入邮箱地址'
        }, {
            name: 'char',
            validate: function(value) {
                return (!/^[a-z\_\-A-Z]*$/.test(value));
            },
            defaultMsg: '请输入英文字符'
        }, {
            name: 'chinese',
            validate: function(value) {
                return (!/^[\u4e00-\u9fff]$/.test(value));
            },
            defaultMsg: '请输入汉字'
        }, {
            name: 'maxLength',
            validate: function(value) {
                var lengthValue = $(this).attr("lengthValue");
                return $.trim(value).length > lengthValue;
            },
            defaultMsg: '输入内容达到上限'
        }, {
            name: 'selectRequired',
            validate: function(value) {
                var val = $(this).val();
                return val == 0;
            },
            defaultMsg: '请选择内容'
        }, {
            name: 'maxNumber',
            validate: function(value) {
                if(! value) return false;
                var maxValue = $(this).attr("maxValue");
                return +value > +maxValue;
            },
            defaultMsg: '输入值过大'
        }, {
            name: 'minNumber',
            validate: function(value) {
                if(! value) return false;
                var minValue = $(this).attr("minValue");
                return +value < +minValue;
            },
            defaultMsg: '输入值过小'
        }]
    };

    var formState = false,
        fieldState = false,
        wFocus = false,
        globalOptions = {};

    var validateField = function(field, valid) { //
        var el = $(field),
            error = false,
            errorMsg = '';
        for (i = 0; i < valid.length; i++) {
            var x = true,
                flag = valid[i],
                msg = (el.attr(flag + '-message') == undefined) ? null : el.attr(flag + '-message');;
            if (flag.substr(0, 1) == '!') {
                x = false;
                flag = flag.substr(1, flag.length - 1);
            }

            var rules = globalOptions.validRules;
            for (j = 0; j < rules.length; j++) {
                var rule = rules[j];
                if (flag == rule.name) {
                    if (rule.validate.call(field, el.val()) == x) {
                        error = true;
                        errorMsg = (msg == null) ? rule.defaultMsg : msg;
                        break;
                    }
                }
            }

            if (error) {
                break;
            }
        }

        var controls = el.parents('.controls'),
            controlGroup = el.parents('.control-group'),
            errorEl = controls.children('.help-block, .help-inline');

        if (error) {
            if (!controlGroup.hasClass('error')) {
                if (errorEl.length > 0) {
                    var help = errorEl.text();
                    controls.data('help-message', help);
                    errorEl.text(errorMsg);
                } else {
                    controls.append('<span class="help-inline">' + errorMsg + '</span>');
                }
                controlGroup.addClass('error');
            }
        } else {
            if (fieldState) {
                if (errorEl.length > 0) {
                    var help = controls.data('help-message');
                    if (help == undefined) {
                        errorEl.remove();
                    } else {
                        errorEl.text(help);
                    }
                }
                controlGroup.removeClass('error');
            } else {
                if (errorEl.length > 0) {
                    var help = errorEl.text();
                    controls.data('help-message', help);
                }
            }
        }
        return !error;
    };

    var validationForm = function(obj) { //
        $(obj).submit(function() { //
            if (formState) { //
                //return false;
            }
            formState = true;
            var validationError = false;
            $('input, textarea ,select', this).each(function() {
                var el = $(this),
                    valid = (el.attr('check-type') == undefined) ? null : el.attr('check-type').split(' ');
                if (valid != null && valid.length > 0) {
                    if (!validateField(this, valid)) {
                        if (wFocus == false) {
                            scrollTo(0, el[0].offsetTop - 50);
                            wFocus = true;
                        }

                        validationError = true;
                    }
                }
            });

            wFocus = false;
            fieldState = true;

            if (validationError) {
                formState = false;

                $('input, textarea,select').each(function() {
                    var el = $(this),
                        valid = (el.attr('check-type') == undefined) ? null : el.attr('check-type').split(' ');
                    if (valid != null && valid.length > 0) {
                        el.focus(function() { //
                            var controls = el.parents('.controls'),
                                controlGroup = el.parents('.control-group'),
                                errorEl = controls.children('.help-block, .help-inline');
                            if (errorEl.length > 0) {
                                var help = controls.data('help-message');
                                if (help == undefined) {
                                    errorEl.remove();
                                } else {
                                    errorEl.text(help);
                                }
                            }
                            controlGroup.removeClass('error');
                        });

                        el.blur(function() { //
                            validateField(this, valid);
                        });

                        el.change(function(event) {
                            validateField(this, valid);
                        });

                    }
                });

                return false;
            }

            return true;
        });


    };
}(window.jQuery);
