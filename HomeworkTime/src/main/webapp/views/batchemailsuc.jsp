<%@ page trimDirectiveWhitespaces="true"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="inc/head.jsp"%>
<title>邮件服务后台</title>
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
                     <h3>邮件发送报告</h3>
                 </div>
                      <div class="col-md-10">
                    <table class="table table-bordered table-hover table-condensed margin-top-15">
                      <tr>
                          <th class="active">#</th>
                          <th class="active">名字</th>
                          <th class="active">Email</th>
                          <th class="active">状态</th>
                      </tr>
                      <c:forEach var="result" items="${resultlist}">
                          <tr>
                              <td>${result.id}</td>
                              <td>${result.name}</td>
                              <td>${result.email}</td>
                              <!--<td>${result.status}</td>-->
                              <td>
                             <c:choose>
                            <c:when test="${result.status=='true'}">成功</c:when>
                               <c:otherwise>失败</c:otherwise>
                            </c:choose>
                            </td>
                          </tr>
                      </c:forEach>
                  </table>
                      </div>
                  </div>
            </div>
        </div>
</body>
</html>
