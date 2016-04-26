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
      <li class="url-link " data-link="${pageContext.request.contextPath}/dashboard/"><i class="icon-sitemap"></i></li>
      <security:authorize ifAllGranted="ROLE_DASHBOARD_MANAGER">
      	<li class="url-link " data-link="${pageContext.request.contextPath}/dashboard/fiche"><i class="icon-file-text"></i></li>
      </security:authorize>
      <li class="url-link " data-link="${pageContext.request.contextPath}/dashboard/project/"><i class="icon-list-ul"></i> </li>
      <li class="url-link " data-link="${pageContext.request.contextPath}/dashboard/team"><i class="icon-user"></i></li>
      <security:authorize ifAllGranted="ROLE_DASHBOARD_MANAGER">
      	<li class="url-link " data-link="${pageContext.request.contextPath}/dashboard/event"><i class="icon-lightbulb"></i></li>
      </security:authorize>
    </ul>
  </li>
  <!--ADMIN PLUS MENU-->
  
    <!--STAFF PLUS MENU-->
  
  <!--STAFF PLUS MENU--
  
  
  <!--DASHBOARD-->
  <li> <a href="${pageContext.request.contextPath}/dashboard/" class="open"> <i class="icon-home"></i> Dashboard<span class="pull-right"></span></a> </li>
  <!--DASHBOARD END-->
  <!--ALL PROJECTS-->
  <li> 
   <security:authorize ifAllGranted="ROLE_DASHBOARD_MANAGER">
	  <!--PROJECT START-->
	  <li class="has_sub"> <a href="javascript:void(0)" class="">
		     <i class="fa fa-file-text-o"></i> <spring:message code="application.header.dashboardmanager.ficheclient"/> <span class="pull-right"><i class="icon-chevron-right" style="font-size:12px"></i></span></a>
		    <ul>
		        <li>
	 	        	<a href="${pageContext.request.contextPath}/dashboard/fiche/add"> <i class="icon-plus-sign"></i> <spring:message code="application.header.add.dashboardmanager.ficheclient"/></a>
	 	        </li>
		      <li>
		      		<a href="${pageContext.request.contextPath}/dashboard/fiche"> <i class="icon-list"></i><spring:message code="application.dashboardmanager.allficheclient"/>
		        	<label class="label label-info pull-right"> <c:out value='${sessionScope["count_fiche"]}' /> </label>
		        	</a>
		      </li>
		    </ul>
  </li>
  </security:authorize>
  <!--PROJECT END-->
  <security:authorize ifAllGranted="ROLE_DASHBOARD_MANAGER">
  <!--PROJECT START-->
  <li class="has_sub"> <a href="javascript:void(0)" class="">
	    <i class="icon-folder-open-alt"></i> <spring:message code="application.dashboardmanager.project"/> <span class="pull-right"><i class="icon-chevron-right" style="font-size:12px"></i></span></a>
	    <ul>
	        <li>
 	        	<a href="${pageContext.request.contextPath}/dashboard/project/add"> <i class="icon-plus-sign"></i><spring:message code="application.header.add.dashboardmanager.project"/></a>
 	        </li>
	      <li>
	      		<a href="${pageContext.request.contextPath}/dashboard/project/"> <i class="icon-list"></i><spring:message code="application.dashboardmanager.allproject"/>
	        	<label class="label label-success pull-right"> <c:out value='${sessionScope["count_projet"]}' /> </label>
	        	</a>
	      </li>
	    </ul>
  </li>
  <!--PROJECT END-->
</security:authorize>

<security:authorize ifAllGranted="ROLE_CHEF_PROJET">
  <!--PROJECT START-->
    <li> 
    	<a href="${pageContext.request.contextPath}/dashboard/project/"> <i class="icon-folder-open-alt"></i> <spring:message code="application.dashboardmanager.allproject"/> <span class="pull-right"></span>
    	<label class="label label-info pull-right"> <c:out value='${sessionScope["count_projet"]}' /> </label>
    	</a> 
    </li>
  <!--PROJECT END-->
</security:authorize>
  <!--TEAM-->
  <li class="has_sub"> <a href="javascript:void(0)" class="">
	    <i class="icon-user"></i> <spring:message code="application.dashboardmanager.team"/> <span class="pull-right"><i class="icon-chevron-right" style="font-size:12px"></i></span></a>
	    <ul>
	        <li>
 	        	<a href="${pageContext.request.contextPath}/dashboard/team/add"> <i class="icon-plus-sign"></i><spring:message code="application.header.add.dashboardmanager.team"/></a>
 	        </li>
	      <li>
	      		<a href="${pageContext.request.contextPath}/dashboard/team"> <i class="icon-list"></i><spring:message code="application.dashboardmanager.allteam"/>
	        	<label class="label label-warning pull-right"> <c:out value='${sessionScope["count_team"]}' /> </label>
	        	</a>
	      </li>
	    </ul>
  </li>
  <!--TEAM END-->
  
 <security:authorize ifAllGranted="ROLE_DASHBOARD_MANAGER">
  <!--EVENT-->
  <li class="has_sub"> <a href="javascript:void(0)" class="">
	    <i class=" icon-lightbulb"></i> <spring:message code="application.dashboardmanager.event"/> <span class="pull-right"> <i class="icon-chevron-right" style="font-size:12px"></i></span></a>
	    <ul>
	        <li>
 	        	<a href="${pageContext.request.contextPath}/dashboard/event/add"> <i class="icon-bullhorn"></i><spring:message code="application.header.add.dashboardmanager.event"/></a>
 	        </li>
	      <li>
	      		<a href="${pageContext.request.contextPath}/dashboard/event"> <i class="icon-list"></i><spring:message code="application.dashboardmanager.allevent"/>
	        	<label class="label label-danger pull-right"> <c:out value='${sessionScope["count_event"]}' /> </label>
	        	</a>
	      </li>
	    </ul>
  </li>
  <!--EVENT END-->
 </security:authorize>

</ul>