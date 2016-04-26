<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
 
<tiles:insertDefinition name="DashboardMangerTemplate">
    <tiles:putAttribute name="body">
	
    <!-- Matter -->
    <div class="matter">
    
    	<div class="container">
        <div class="row">
        
            <!---------------------------------------------------   COMMON PROJECT MENU --------------------------------------------------->
            <!----------------------------------------------------------------------------------------------------------------------------->
          <!--WI_SPRINT_NAV_CONTENT-->
          <div class="col-lg-3">
            <!--WI_MAIN_NAVIGATION-->
			<div class="row">
			  <!--WI_PROJECT_MENU-->
			  <div class="col-lg-12 project-menu">
			    <div class="box side-menu-main">
			      <div class="box-head-dark"><i class="icon-list"></i> <spring:message code="application.bashboardmanager.task.menu"/></div>
			      <div class="box-content">
			        <ul>
			          <li> 
			
			          	  <a class="" href="${pageContext.request.contextPath}/dashboard/${sprint.projet.id_projet}/sprint/${sprint.id_sprint}/detail"> <spring:message code="application.bashboardmanager.project.detail"/></a>
			          </li>

			          <li>     
			            <a class="" href="${pageContext.request.contextPath}/dashboard/${sprint.id_sprint}/task/"><spring:message code="application.bashboardmanager.project.tasks"/></a>
			          </li>
			
			          <li> 
			          	 <a class="" href="${pageContext.request.contextPath}/dashboard/${sprint.id_sprint}/file/"> <spring:message code="application.bashboardmanager.project.Files"/></a>
			          </li>
			           
			        </ul>
			      </div>
			    </div>
			  </div>
			  <!--WI_PROJECT_MENU-->
			  <!--WI_MY_TASKS-->
			  <div class="col-lg-12">
			    <div class="split-info-panel project">
			      <div class="split-info-panel-header bg-info"> <span class="split-panel-heading"> <spring:message code="application.bashboardmanager.project.tasks"/></span> </div>
			      <ul class="split-info-panel-footer">
			        <li class="border-right url-link" data-link="${pageContext.request.contextPath}/dashboard/${sprint.id_sprint}/task/completed/">
			          <div class="text-count">${CountTasksCompleted}</div>
			          <div class="text-description text-muted"> <spring:message code="application.status.completed"/></div>
			        </li>
			        <li class="border-right url-link" data-link="${pageContext.request.contextPath}/dashboard/${sprint.id_sprint}/task/inprogress/">
			          <div class="text-count">${CountTasksInprogress}</div>
			          <div class="text-description text-muted"><spring:message code="application.status.inprogress"/></div>
			        </li>
			        <li class="url-link" data-link="${pageContext.request.contextPath}/dashboard/${sprint.id_sprint}/task/pending/">
			          <div class="text-count"> ${CountTasksPending} </div>
			          <div class="text-description text-muted"> <spring:message code="application.status.pending"/></div>
			        </li>
			      </ul>
			    </div>
			  </div>
			  <!--WI_MY_TASKS-->
			</div>
			<!--WI_PROJECT_MENU-->
          </div>
          
          <!---------------------------------------------------   BODY PROJECT  --------------------------------------------------->
          <!----------------------------------------------------------------------------------------------------------------------------->
          
          
          <!--WI_PROJECT_NAV_CONTENT-->
          <div class="col-lg-9">
            <div class="widget">
              <div class="widget-content-project">
              
                
                <!-----------------------------------------------CONTENT CHANGES------------------------------------------------------------------>
		       
		      		<div class="modal-dialog">
      <form:form  modelAttribute="file" method="post" action="${pageContext.request.contextPath}/dashboard/${sprint.id_sprint}/file/add" enctype="multipart/form-data">
        <div class="modal-content">
          <div class="modal-header">
            <!--full screen icon - custom.js-->
            <button type="button" class="full-screen-modal close" aria-hidden="true"><i class="icon-fullscreen"></i></button>
            <!--full screen icon - custom.js-->
            <h4 class="modal-title">  <spring:message code="application.header.add.dashboardmanager.project.task"/> </h4>
          </div>
          <div class="modal-body">
          
           <div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> <spring:message code="application.file.name"/> <span class="required_field">*</span></label>
              <div class="col-lg-12">
               <form:input class="form-control" path="nom" />
               <label class="jquery-validation-error" for="clients_company_name"> <form:errors path="nom" cssClass="error" /> </label>
              </div>
            </div>
            
            <div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> <spring:message code="application.file.url"/> </label>
              <div class="col-lg-12">
               <form:input class="form-control" path="url" />
               <label class="jquery-validation-error" for="clients_company_name"> <form:errors path="url" cssClass="error" /> </label>
              </div>
            </div>
          	
          	<div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> <spring:message code="application.file.content"/>  <span class="required_field">*</span></label>
             <div class="col-lg-12">
               <input type="file" name="f" id="f" >
               <label class="jquery-validation-error" for="clients_company_name"> ${errorFileEmpty }</label>
              </div>
            </div>
            
            <div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> <spring:message code="application.file.attachementdate"/> <span class="required_field">*</span> </label>
              <div class="col-lg-12">
               <form:input class="form-control pickadate" path="date_attachement" required="true"/>
               <label class="jquery-validation-error" for="clients_company_name"> <form:errors path="date_attachement" cssClass="error" /> </label>
              </div>
            </div> 
            

          </div>
          <div class="modal-footer">
<%--             <button type="button" class="btn btn-default" data-dismiss="modal" aria-hidden="true"> <spring:message code="application.crud.reset"/></button> --%>
            <input class="btn btn-default" value="<spring:message code="application.crud.reset"/>" id="" name="reset" type="reset">
            <input class="btn btn-primary" value=" <spring:message code="application.crud.add"/>" id="" name="submit" type="submit">
            
          </div>
        </div>
      </form:form>
    </div>

		        <!-----------------------------------------------END CONTENT CHANGES------------------------------------------------------------------>
		          
		           
		           
		           </div>
		          </div>
		        </div>
		       </div>
       
    
    </div>

   </div> 
  </div>
    </tiles:putAttribute>
</tiles:insertDefinition>