<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
 
<tiles:insertDefinition name="AdminTemplate">
    <tiles:putAttribute name="body">
	
    <!-- Matter -->
    <div class="matter">
    
    	<div class="row">
    <div class="modal-dialog">
      <form:form  modelAttribute="chefprojet" method="post" action="${pageContext.request.contextPath}/admin/chefprojet/update/${chefprojet.id_u}">
        <div class="modal-content">
          <div class="modal-header">
            <!--full screen icon - custom.js-->
            <button type="button" class="full-screen-modal close" aria-hidden="true"><i class="icon-fullscreen"></i></button>
            <!--full screen icon - custom.js-->
            <h4 class="modal-title">  <spring:message code="application.header.update.chefprojet"/> </h4>
          </div>
          <div class="modal-body">
            <div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> <spring:message code="application.user.firstname"/></label>
              <div class="col-lg-12">
               <form:input class="form-control" path="prenom" />
               <label class="jquery-validation-error" for="clients_company_name"> <form:errors path="prenom" cssClass="error" /> </label>
              </div>
            </div>
            
            <div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> <spring:message code="application.user.lastname"/></label>
              <div class="col-lg-12">
               <form:input class="form-control" path="nom" />
               <label class="jquery-validation-error" for="clients_company_name"> <form:errors path="nom" cssClass="error" /> </label>
              </div>
            </div>
            
            <div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> <spring:message code="application.user.email"/> </label>
              <div class="col-lg-12">
               <form:input class="form-control" path="email" />
               <label class="jquery-validation-error" for="clients_company_name"> <form:errors path="email" cssClass="error" /> </label>
              </div>
            </div>
            <div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> <spring:message code="application.user.tel"/></label>
              <div class="col-lg-12">
               <form:input class="form-control" path="tel" />
               <label class="jquery-validation-error" for="clients_company_name"> <form:errors path="tel" cssClass="error" /> </label>
              </div>
            </div>
            <div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> <spring:message code="application.user.adress"/> </label>
             <div class="col-lg-12">
               <form:input class="form-control" path="adresse" />
               <label class="jquery-validation-error" for="clients_company_name"> <form:errors path="adresse" cssClass="error" /> </label>
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