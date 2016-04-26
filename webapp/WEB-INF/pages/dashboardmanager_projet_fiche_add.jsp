<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
 
<tiles:insertDefinition name="DashboardMangerTemplate">
    <tiles:putAttribute name="body">
	
    <!-- Matter -->
    <div class="matter">
    
    	<div class="row">
    <div class="modal-dialog">
      <form:form  modelAttribute="projet" method="post" action="${pageContext.request.contextPath}/dashboard/${projet.ficheClient.id_ficheClient}/project/add">
        <div class="modal-content">
          <div class="modal-header">
            <!--full screen icon - custom.js-->
            <button type="button" class="full-screen-modal close" aria-hidden="true"><i class="icon-fullscreen"></i></button>
            <!--full screen icon - custom.js-->
            <h4 class="modal-title">  <spring:message code="application.header.add.dashboardmanager.ficheclient"/> </h4>
          </div>
          <div class="modal-body">
          
           <div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> <spring:message code="application.project.name"/> <span class="required_field">*</span></label>
              <div class="col-lg-12">
               <form:input class="form-control" path="nom" />
               <label class="jquery-validation-error" for="clients_company_name"> <form:errors path="nom" cssClass="error" /> </label>
              </div>
            </div>
          	
          	<div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> <spring:message code="application.project.date"/>  <span class="required_field">*</span></label>
             <div class="col-lg-12">
               <form:input class="form-control pickadate" path="date_creation" />
               <label class="jquery-validation-error" for="clients_company_name"> <form:errors path="date_creation" cssClass="error" /> </label>
              </div>
            </div>
            
            <div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> <spring:message code="application.project.desc"/> <span class="required_field">*</span> </label>
              <div class="col-lg-12">
               <form:input class="form-control" path="desc" />
               <label class="jquery-validation-error" for="clients_company_name"> <form:errors path="desc" cssClass="error" /> </label>
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
</div>

    </div> 
    </tiles:putAttribute>
</tiles:insertDefinition>