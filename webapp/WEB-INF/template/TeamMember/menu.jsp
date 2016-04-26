<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!--SIDE MENU - ONLOAD -->
<div class="sidebar-dropdown"><a href="#">Dashboard <i class="icon-list-ul"></i></a></div>
<ul id="nav" class="main-nav">
  <div class="nav_logo"> <img src="<c:url value="/images/logo/logo_twins.png"/>"   alt="Twins Outsourcing" style="width:90%; height:100%;" /> </div>
  <!--ADMIN PLUS MENU-->
  <li class="nav_alternative">
    
    <ul class="nav_alternative_controls" tabindex="-1" data-reactid=".1.0.1.0">
      <li class="url-link " data-link="${pageContext.request.contextPath}/teamember/project"><i class="icon-folder-open"></i></li>
      <li class="url-link " data-link="${pageContext.request.contextPath}/teamember/event"><i class="icon-lightbulb"></i></li>
      <li class="url-link " data-link="${pageContext.request.contextPath}/teamember/myTask"><i class="icon-list-ul"></i></li>
    </ul>
  </li>
  <!--ADMIN PLUS MENU-->
  
    <!--STAFF PLUS MENU-->
  
  <!--STAFF PLUS MENU--
  
  
  <!--DASHBOARD-->
<%--   <li> <a href="${pageContext.request.contextPath}/dashboard/" class="open"> <i class="icon-home"></i> Dashboard<span class="pull-right"></span></a> </li> --%>
  <!--DASHBOARD END-->
  <!--ALL PROJECTS--> 
  
  <!--PROJECT START-->
    <li> 
    	<a href="${pageContext.request.contextPath}/teamember/project/"> <i class="icon-folder-open-alt"></i> <spring:message code="application.dashboardmanager.project"/> <span class="pull-right"></span>
    	<label class="label label-info pull-right"> <c:out value='${sessionScope["count_projet_teamember"]}' /> </label>
    	</a> 
    </li>
  <!--PROJECT END-->
  
  <!--EVENT-->
  
  <li> 
    	<a href="${pageContext.request.contextPath}/teamember/event"> <i class="icon-lightbulb"></i> <spring:message code="application.dashboardmanager.event"/> <span class="pull-right"></span>
    	<label class="label label-danger pull-right"> <c:out value='${sessionScope["count_event_teamember"]}' /> </label>
    	</a> 
    </li>
    <li> 
    	<a href="${pageContext.request.contextPath}/teamember/myTask"> <i class="icon-lightbulb"></i> <spring:message code="application.header.Mytasks"/> <span class="pull-right"></span>
    	<label class="label label-warning pull-right"> <c:out value='${sessionScope["count_task_teamember"]}' /> </label>
    	</a> 
    </li>
  <!--EVENT END-->

</ul>