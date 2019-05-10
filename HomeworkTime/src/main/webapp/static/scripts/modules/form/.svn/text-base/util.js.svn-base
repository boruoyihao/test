define(function() {
    var util = {};

    util.errorMsg = {
        '-100': '邮箱格式不正确',
        '-101': '小米ID格式不正确',
        '-102': '企业名称格式不正确',
        '-103': '营业执照注册号格式不正确',
        '-104': '法人身份证影印件不能为空',
        '-105': '营业执照影印件不能为空',
        '-106': '上传图片不能大于4M',
        '-107': '电话号码格式不正确'
    };

    util.formatDate = function(date) {
        var y = date.getFullYear(),
            m = (date.getMonth()+1).toString(),
            d = date.getDate().toString();

        if(m.length <= 1) m = '0'+m;
        if(d.length <= 1) d = '0'+d;

        return y+'-'+m+'-'+d;
    };

    util.sendAjax = function(type, url, queryData, cb, ajaxOptions) {
        var ajaxOptions = ajaxOptions || {};
        $.ajax($.extend({
            type: type,
            url: url,
            data: queryData,
            dataType: 'json',
            success: function(data) {
                if(cb) cb(data);
            },
            error: function() { }
        }, ajaxOptions));
    };

    util.regPattern = {
        empty: /^[\s\S]+$/,
        identity: /^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/,
        phone: /^(1[3,5,8,7]{1}[\d]{9})|(((400)-(\d{3})-(\d{4}))|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{3,7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)$/,
        chinese: /[\u4e00-\u9fa5]/,
        number: /^[1-9]\d*$/,
        email: /[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?/
    };

    return util;
});
