define(function(require) {
    var $ = require('jquery'),
        ui = require('jquery-ui'),
        validator = require('modules/form/validator'),
        util = require('modules/form/util'),
        modalFactory = require('modules/modalFactory');

    // 初始化表单验证module
    (function() {
        var form = $('.form-register');
        validator = new validator(form);
        validator.form.on('submit-success', function(e, data) {
            var content;
            if(data.code === 200) {
                content = '注册成功，3秒后页面自动刷新！';
                setTimeout(function() {
                    window.location.reload();
                }, 3000);
            } else {
                content = '注册失败，请重试！';
            }
            new modalFactory({
                title: '注册',
                content: content
            });
        });
    })();

    // 初始化营业日期日历
    (function() {
        var domCalendar = $('#form_calendar');
        domCalendar.datepicker({
            dateFormat: 'yy-mm-dd'
        });
    })();


    // 选择长期的时候禁止"营业期限"input
    (function() {
        var domNoExpire = $('#noexpire');
        domNoExpire.on('click', function() {
            var box = $(this),
                input = box.parent().prev(),
                name = 'companyBussinessPeriod';

            if(box.get(0).checked) {
                box.attr('name', name);
                input.attr({
                    'name': '',
                    'readonly': true,
                });
            } else {
                box.attr('name', '')
                input.attr({
                    'name': name,
                    'readonly': false
                });
            }
        });
    })();

    // HTML5上传
    (function() {

        $('.h5upload').on('click', function() {
            $(this).next().trigger('click');
        });

        function uploadImage(input, file) {
            var formData = new FormData();
            formData.append('applyScanPic', file);
            util.sendAjax('post', '/merchant/upload', formData, function(data) {
                input.parent().find('[type="hidden"]').val(data.data);
                validator.showMsg(input.attr('id'), 'succed');
            }, {
                xhr: function() {
                    var xhr = new window.XMLHttpRequest(),
                        con = input.next(),
                        progress = con.find('figcaption'),
                        img = con.find('img');

                    img.css('opacity', 0.4);
                    xhr.upload.addEventListener('progress', function(e) {
                        if(e.lengthComputable) {
                             var percentComplete = Math.round(e.loaded / e.total * 100)+'%';
                             progress.html(percentComplete);
                          }
                    }, false);
                    xhr.upload.addEventListener('load', function(e) {
                        progress.html('');
                        img.css('opacity', 1);
                    }, false);
                    return xhr;
                },
                processData: false,
                contentType: false
            });
        }

        function previewImage(input, file) {
            var reader = new FileReader();
            reader.readAsDataURL(file);

            reader.onload = function(e) {
                var url = e.target.result;
                input.next()
                     .show()
                     .find('img')
                     .attr('src', url);
                uploadImage(input, file);
            }
        }

        function selectFile(input, file) {
            var size = Math.floor(file.size/1024),
                name = file.name;

            if(size > 4096) {
                validator.showMsg(input.attr('id'), 'failed', '-106');
                return;
            }
            previewImage(input, file);
        }

        $('[type="file"]').on('change', function(e) {
            selectFile($(this), e.target.files[0]);
        });

    })();

});
