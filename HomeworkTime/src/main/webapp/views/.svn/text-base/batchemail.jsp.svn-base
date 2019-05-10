<%@ page trimDirectiveWhitespaces="true"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="inc/head.jsp"%>
<title>邮件服务后台</title>
 <script type="text/javascript">
  $(function(){

    //1. 简单写法：
    $("#J_formaddmodel").validation();

    //.注册
    $("#submit1").on('click',function(event){
      // 2.最后要调用 valid()方法。
      //  valide(object,msg),提示信息显示，object位置后面增加提示信息。如不填object 则自动找最后一个button submit.
      //  valide(msg)
      if ($("#J_formaddmodel").valid(this,'填写信息不完整。')==false){
        return false;
      }
    });

  })
</script>
</head>
<body>
    <%@include file="inc/header.jsp"%>
    <div class="container container-full-width">
        <div class="row row-full-width margin-top-15">
            <div class="col-md-2">
                <%@ include file="inc/nav.jsp"%>
            </div>
            <div class="span10">
                 <div class="page-header">
                     <h3>批量发送邮件</h3>
                 </div>
                 
                 <div class="col-md-8" align="left">
                     <form id="J_formaddmodel" class="form-horizontal" action="email/batchemail" enctype="multipart/form-data" method="POST">
                    <div class="form-group">
                        <div class="col-sm-8">
                          <input type="file" name="file" id="file" class="form-control" check-type="required" required-message="请选择Excel或TXT文件">
                        </div>
                    </div>
                    <div class="form-group">
                         <label class="sr-only" for="emailInput">邮件标题</label>
                          <div class="col-sm-8">
                         <input
                            type="text" name="title" class="form-control" id="title" check-type="required" required-message="请输入邮件标题"
                            placeholder="邮件标题" value="${title}">
                           </div>

                    </div>
                    <div class="form-group">
                      <label class="sr-only" for="contentInput">邮件内容</label>
                      <div class="col-sm-8">
                        <textarea id="myEditor" name="content" style="width:800px;height:240px;" check-type="required" required-message="请输入邮件内容"></textarea>
                      </div>
                    </div>
                      <div class="controls">
                         <input type="submit" class="btn btn-primary" id="submit1" value="提交">
                     </div>
                    </form>
                    </div>
                   </div>
            </div>
        </div>
    <script type="text/javascript">
        //实例化编辑器
      //var ue = UE.getEditor('myEditor');
      var ue = UE.getEditor('myEditor', {
    toolbars: [
          ['fullscreen', 'source', 'undo', 'redo', 
          'bold',
          'indent',
          'italic',
          'underline',
          'strikethrough',
          'formatmatch', 
          'removeformat', 
        'time', 
        'date', 
        'link', //超链接
        'unlink', //取消链接
        'insertrow', //前插入行
        'insertcol', //前插入列'preview'
        'forecolor', //字体颜色
        'backcolor', //背景色
        'deleterow', //删除行
        'deletecol', //删除列
        'selectall', //全选
        ]
      ],
      autoHeightEnabled: true,
      autoFloatEnabled: true
  });
    </script>
</body>
</html>
