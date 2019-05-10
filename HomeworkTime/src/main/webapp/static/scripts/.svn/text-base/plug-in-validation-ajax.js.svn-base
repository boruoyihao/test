(function($){
    $.fn.ajaxValidation = function(options){
        options = $.extend({
            url:"",
            formId:"",
            filedId:"",
            filedParentId:"",
            exclude:"",
            msg:"已经存在",
            msg1:"不能包含汉字",
            allowChinese:true,
            name:""
        }, options);
    var $form = $("#"+options.formId);
    var $filed = $("#"+options.filedId);
    var $filedParent = $("#"+options.filedParentId);
    if($filed.attr("readonly") || ( options.exclude ? ($("#"+options.exclude).val().length>0) : false )){
        return;
    }
    var stt,flag = false;
    function showErrorMsg(){
        $filedParent.addClass("error");
        $filedParent.find(".help-inline").remove();
        if($.trim($filed.val()).length<=0){
            $filedParent.find(".controls").append("<span class='help-inline'>输入内容</span>");
        }else if(escape($.trim($filed.val())).indexOf("%u")!=-1 && ! options.allowChinese){
            $filedParent.find(".controls").append("<span class='help-inline'>"+options.msg1+"</span>");
        }else{
            $filedParent.find(".controls").append("<span class='help-inline'>"+options.msg+"</span>");
        }

    }
    function hideErrorMsg(){
        $filedParent.removeClass("error");
        $filedParent.find(".help-inline").remove();
    }
    $filed.bind('input propertychange blur', function() {
        clearTimeout(stt);
        flag = false;
        var val = $.trim($filed.val());
        if(val.length<=0){
            hideErrorMsg();
            return;
        }else if(escape(val).indexOf("%u")!=-1 && ! options.allowChinese){
            showErrorMsg();
            return;
        }
        stt = setTimeout(function(){
            $.get(options.url+"?"+options.name+"="+val,null,
                    function(data,status) {
                        if(data == 'EXIST') {
                            showErrorMsg();
                        }else{
                            hideErrorMsg();
                            flag = true;
                        }
                    });
        },300);
    });
    $filed.blur();
    $form.submit(function(){
        if(flag){
            hideErrorMsg();
            return true;
        }else{
            showErrorMsg();
            return false;
        }
    });
    }
}(window.jQuery))
