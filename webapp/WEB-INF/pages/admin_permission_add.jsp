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
      <form:form  modelAttribute="action" method="post" action="${pageContext.request.contextPath}/permission/add">
        <div class="modal-content">
          <div class="modal-header">
            <!--full screen icon - custom.js-->
            <button type="button" class="full-screen-modal close" aria-hidden="true"><i class="icon-fullscreen"></i></button>
            <!--full screen icon - custom.js-->
            <h4 class="modal-title">  <spring:message code="application.header.add.permission"/> </h4>
          </div>
          
          <div class="modal-body">
          
           <div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> <spring:message code="application.admin.permission.profil"/> </label>
             <div class="col-lg-12">

				<div class="navbar navbar-default" style="background:#fff; border:0px; margin:0px;" role="navigation">
							
							<form:select  class="custom-select" path="profil">
									   <form:options items="${profiles}" itemValue="id_profil" itemLabel="titre" />
							</form:select>
			 				 
			      </div>
              </div>
            </div><br/><br/>
            
            <div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> <spring:message code="application.admin.permission.action"/> </label>
             <div class="col-lg-12">
				<div class="navbar navbar-default" style="background:#fff; border:0px; margin:0px;" role="navigation">
							
							<form:select  class="custom-select" id="libaction" path="libelle">
									   <form:options items="${permessions}" />
							</form:select>
							 
			      </div>
              </div>
            </div><br/><br/>
                	
          	<div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> <spring:message code="application.admin.permission.description"/> </label>
             <div class="col-lg-12">
               <form:textarea path="desc" class="form-textarea" rows="5" cols="30" />
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