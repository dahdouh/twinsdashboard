<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<h2 class="pull-left responsive-heading-title"><i class="icon-home"></i>
    
    			              <c:out value='${sessionScope["user_logged_in"].profil.titre}' /> </h3>
</h2>
  <!-- menu -->
  <div class="heading-menu pull-right responsive-heading-tabs">
    <ul>
      <!--WI_ACCOUNT-->
      <li>
        <div class="btn-group dropup"> 
        	<a class="iframeModal" data-toggle="modal" data-modal-window-title="<spring:message code="application.admin.permission.profil"/>" 
        		data-src="" data-height="350" data-width="100%" 
        		data-target="#modalIframe"> 
        		<i class="icon-gears"></i> <span> <spring:message code="application.header.account"/> </span>
            </a> 
        </div>
         
      </li>
      <!--WI_ACCOUNT-->

      <!--WI_LOGOUT-->
      <li>
        <div class="btn-group dropup"> 
        	<a class="" href="<c:url value="/logout" />" > 
        		<i class="icon-off"></i> <span><span><spring:message code="application.header.logout"/></span>
        	</a> 
        </div>
      </li>
      <!--WI_LOGOUT-->
    </ul>
  </div>
  <div class="clearfix"></div>