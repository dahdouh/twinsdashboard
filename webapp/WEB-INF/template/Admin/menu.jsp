<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!--SIDE MENU - ONLOAD -->
<div class="sidebar-dropdown"><a href="#">Admin <i class="icon-list-ul"></i></a></div>
<ul id="nav" class="main-nav">
  <div class="nav_logo"> <img src="<c:url value="/images/logo/logo_twins.png"/>"   alt="Twins Outsourcing" style="width:90%; height:100%;" /> </div>
  <!--ADMIN PLUS MENU-->
  <li class="nav_alternative">
    
    <ul class="nav_alternative_controls" tabindex="-1" data-reactid=".1.0.1.0">
      <li class="url-link " data-link="${pageContext.request.contextPath}/admin/"><i class="icon-sitemap"></i></li>
      <li class="url-link " data-link="${pageContext.request.contextPath}/admin/dashboardmanager"><i class="icon-user"></i></li>
      <li class="url-link " data-link="${pageContext.request.contextPath}/compte/"><i class="icon-cog"></i> </li>
      <li class="url-link " data-link="${pageContext.request.contextPath}/permission/"><i class="icon-group"></i></li>
     </ul>
  </li>
  <!--ADMIN PLUS MENU-->
  
  
  <!--DASHBOARD-->
  <li> <a href="${pageContext.request.contextPath}/admin/" class="open"> <i class="icon-home"></i> Dashboard<span class="pull-right"></span></a> </li>
  <!--DASHBOARD END-->
  
   <!--USER START-->
  <li class="has_sub"> <a href="javascript:void(0)" class="">
	    <i class="icon-user"></i> <spring:message code="application.admin.user"/> <span class="pull-right"><i class="icon-chevron-right" style="font-size:12px"></i></span></a>
	    <ul>
	        <li>
	        	<a href="${pageContext.request.contextPath}/admin/dashboardmanager"> <spring:message code="application.admin.user.dashboardmanager"/>
	        	<label class="label label-success  pull-right"> <c:out value='${sessionScope["count_dashboardmanager"]}' /> </label></a>
	        </li>
	      <li>
	      		<a href="${pageContext.request.contextPath}/admin/chefprojet"> <spring:message code="application.admin.user.chefprojet"/>
	        	<label class="label label-warning  pull-right"> <c:out value='${sessionScope["count_chefprojet"]}' /> </label>
	        	</a>
	      </li>
	      <li>
	      		<a href="${pageContext.request.contextPath}/admin/teamember"> <spring:message code="application.admin.user.memebreequipe"/>
	        		<label class="label label-danger  pull-right"><c:out value='${sessionScope["count_membre_equipe"]}' /> </label>
	        	</a>
	      </li>
	      <li>
	      	<a href="${pageContext.request.contextPath}/admin/client">  <spring:message code="application.admin.user.client"/>
	        <label class="label label-info  pull-right"> <c:out value='${sessionScope["count_client"]}' /> </label></a>
	      </li>
	    </ul>
  </li>
  <!--USER END-->
  
  <!--ACCOUNT START-->
  <li>
	   <a href="${pageContext.request.contextPath}/compte/" class=""> 
		   	<i class="icon-cog"></i>  <spring:message code="application.admin.account"/>
		    <label class="label label-info  pull-right">  <c:out value='${sessionScope["count_account"]}' /> </label>
	    </a> 
  </li>
  <!--ACCOUNT END-->
    <!--PROFILS START-->
  <li>
	  	<a href="${pageContext.request.contextPath}/permission/" class="">
		    <i class="icon-group"></i> <spring:message code="application.admin.permission"/> 
		    <label class="label label-purple  pull-right"> <c:out value='${sessionScope["permission_account"]}' /> </label>
	    </a> 
   </li>
  <!--PROFILS END-->

</ul>