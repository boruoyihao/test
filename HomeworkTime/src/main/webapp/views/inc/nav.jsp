<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul class="nav nav-pills nav-stacked " id="nav_cashpay_admin" role="tablist">
    <li role="presentation">
        <a href="javascript:;"><strong>邮件管理</strong></a>
        <ul class="nav nav-pills nav-stacked " role="tablist" style="margin-left:25px;margin-right: 25px;">
            <li <c:if test="${category=='batchemail'}">class="active"</c:if>><a href="email/batchemail">批量邮件发送</a></li>
        </ul>
    </li>
    
     <li role="presentation">
        <a href="javascript:;"><strong></strong></a>
        <ul class="nav nav-pills nav-stacked " role="tablist" style="margin-left:25px;margin-right: 25px;">
            <li <c:if test="${category=='addrole'}">class="active"</c:if>><a href="role/addrole"></a></li>
            <li <c:if test="${category=='queryrole'}">class="active"</c:if>><a href="role/queryrole"></a></li>
        </ul>
    </li>
</ul>
