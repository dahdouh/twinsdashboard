<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<tiles:insertDefinition name="TeamMemberTemplate">
    <tiles:putAttribute name="body">
	
    <!-- Matter -->
    <div class="matter">
      <div class="container">
        <!--WI_CLIENTS_TABLE-->
        <!--WI_CLIENTS_SEARCH-->
      <c:if test="${not empty msgError}">
			<div class="isa_error"><i class="fa fa-times-circle"></i>${msgError}.</div>
	  </c:if> 
	        
        <c:if test="${not empty succesMessage}">
			    <div class="isa_success"><i class="fa fa-check"></i>${succesMessage}.</div>
	    </c:if>            
                
                <!-----------------------------------------------CONTENT CHANGES------------------------------------------------------------------>
		       
		      <div class="modal-dialog">
			      <form:form  modelAttribute="task" method="post" action="${pageContext.request.contextPath}/teamember/${task.sprint.id_sprint}/task/update/${task.id_task}">
			        <div class="modal-content">
			          <div class="modal-header">
			            <!--full screen icon - custom.js-->
			            <button type="button" class="full-screen-modal close" aria-hidden="true"><i class="icon-fullscreen"></i></button>
			            <!--full screen icon - custom.js-->
			            <h4 class="modal-title">  <spring:message code="application.header.update.dashboardmanager.project.task"/> </h4>
			          </div>
			          <div class="modal-body">	            
			          	
			          	<div class="form-group" style="margin-bottom:10px;">
			              <label class="control-label col-lg-12" style="width:150px;"> <spring:message code="application.task.startdateeffective"/>  <span class="required_field">*</span></label>
			             <div class="col-lg-12">
			               <form:input class="form-control pickadate" path="date_debut_effective"  required="true"/>
			               <label class="jquery-validation-error" for="clients_company_name"> <form:errors path="date_debut_effective" cssClass="error" /> </label>
			              </div>
			            </div>
			            
			            <div class="form-group" style="margin-bottom:10px;">
			              <label class="control-label col-lg-12" style="width:150px;"> <spring:message code="application.task.enddateeffective"/> <span class="required_field">*</span> </label>
			              <div class="col-lg-12">
			               <form:input class="form-control pickadate" path="date_fin_effective" required="true"/>
			               <label class="jquery-validation-error" for="clients_company_name"> <form:errors path="date_fin_effective" cssClass="error" /> </label>
			              </div>
			            </div> 
			            
			            			            
			            <div class="form-group" style="margin-bottom:10px;">
			              <label class="control-label col-lg-12" style="width:150px;"> <spring:message code="application.task.status"/> <span class="required_field">*</span></label>
			              <div class="col-lg-12">       
						      <div class="navbar navbar-default" style="background:#fff; border:0px; margin:0px;" role="navigation">
						 				<select class="custom-select" name="id_statut">
							                    		<c:forEach var="crt" items="${statuts}">
															<option value="${crt.id_statut}"> <c:out value="${crt.libelle}" /> </option>
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
		        <!-----------------------------------------------END CONTENT CHANGES------------------------------------------------------------------>
		          
		           
		           
		         
		        
        </div>
        <!--WI_CLIENTS_TABLE-->
        <!--WI_NOTIFICATION-->
        
        <!--WI_NOTIFICATION-->
      </div>
    <!-- Matter ends -->

    </tiles:putAttribute>
</tiles:insertDefinition>