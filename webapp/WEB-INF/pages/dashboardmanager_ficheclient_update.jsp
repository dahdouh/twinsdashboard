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
      <form:form  modelAttribute="ficheclient" method="post" action="${pageContext.request.contextPath}/dashboard/fiche/update/${ficheclient.id_ficheClient}">
        <div class="modal-content">
          <div class="modal-header">
            <!--full screen icon - custom.js-->
            <button type="button" class="full-screen-modal close" aria-hidden="true"><i class="icon-fullscreen"></i></button>
            <!--full screen icon - custom.js-->
            <h4 class="modal-title">  <spring:message code="application.header.add.dashboardmanager.ficheclient"/> </h4>
          </div>
          <div class="modal-body">
          
           <div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> <spring:message code="application.ficheprojet.contactFirstName"/> <span class="required_field">*</span></label>
              <div class="col-lg-12">
               <form:input class="form-control" path="prenomContact" />
               <label class="jquery-validation-error" for="clients_company_name"> <form:errors path="prenomContact" cssClass="error" /> </label>
              </div>
            </div>
          	
          	<div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> <spring:message code="application.ficheprojet.contactLastName"/>  <span class="required_field">*</span></label>
             <div class="col-lg-12">
               <form:input class="form-control" path="nomContact" />
               <label class="jquery-validation-error" for="clients_company_name"> <form:errors path="nomContact" cssClass="error" /> </label>
              </div>
            </div>
            
            <div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> <spring:message code="application.ficheprojet.contactEmail"/> <span class="required_field">*</span> </label>
              <div class="col-lg-12">
               <form:input class="form-control" path="emailContact" />
               <label class="jquery-validation-error" for="clients_company_name"> <form:errors path="emailContact" cssClass="error" /> </label>
              </div>
            </div>
            
            <div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> <spring:message code="application.ficheprojet.contactTel1"/>  <span class="required_field">*</span></label>
              <div class="col-lg-12">
               <form:input class="form-control" path="telephone_1" />
               <label class="jquery-validation-error" for="clients_company_name"> <form:errors path="telephone_1" cssClass="error" /> </label>
              </div>
            </div>
            <div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> <spring:message code="application.ficheprojet.contactTel2"/></label>
              <div class="col-lg-12">
               <form:input class="form-control" path="telephone_2" />
               <label class="jquery-validation-error" for="clients_company_name"> <form:errors path="telephone_2" cssClass="error" /> </label>
              </div>
            </div>
            <div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> <spring:message code="application.ficheprojet.contactAdress"/> <span class="required_field">*</span> </label>
             <div class="col-lg-12">
               <form:input class="form-control" path="adresse" />
               <label class="jquery-validation-error" for="clients_company_name"> <form:errors path="adresse" cssClass="error" /> </label>
              </div>
            </div>
            <div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> <spring:message code="application.ficheprojet.contactWebSite"/> </label>
             <div class="col-lg-12">
               <form:input class="form-control" path="siteweb" />
               <label class="jquery-validation-error" for="clients_company_name"> <form:errors path="siteweb" cssClass="error" /> </label>
              </div>
            </div>
            
            <div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> <spring:message code="application.header.table.client"/> <span class="required_field">*</span> </label>
               <div class="col-lg-12">       
			      <div class="navbar navbar-default" style="background:#fff; border:0px; margin:0px;" role="navigation">

			 				<select class="custom-select" name="id_client">
				                    		<c:forEach var="crt" items="${clients}">
												<option value="${crt.id_u}"> <c:out value="${crt.societe}" /> </option>
											</c:forEach>																
							</select>
							

			      </div>
  				
              </div>
            </div>

          </div>
          <div class="modal-footer">
<%--             <button type="button" class="btn btn-default" data-dismiss="modal" aria-hidden="true"> <spring:message code="application.crud.reset"/></button> --%>
            <input class="btn btn-default" value="<spring:message code="application.crud.reset"/>" id="" name="reset" type="reset">
            <input class="btn btn-primary" value=" <spring:message code="application.crud.update"/>" id="" name="submit" type="submit">
            
          </div>
        </div>
      </form:form>
    </div>
</div>

    </div> 
    </tiles:putAttribute>
</tiles:insertDefinition>