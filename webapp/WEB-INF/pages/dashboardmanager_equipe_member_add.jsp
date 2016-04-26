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
	      <form:form  modelAttribute="member" method="post" action="${pageContext.request.contextPath}/dashboard/${idP}/team/${idE}/member/add">
					        <div class="modal-content">
					          <div class="modal-header">
					            <!--full screen icon - custom.js-->
					            <button type="button" class="full-screen-modal close" aria-hidden="true"><i class="icon-fullscreen"></i></button>
					            <!--full screen icon - custom.js-->
					            <h4 class="modal-title">  <spring:message code="application.header.add.team"/> </h4>
					          </div>
					          <div class="modal-body">
					           
					             <div class="form-group" style="margin-bottom:10px;">
					              <label class="control-label col-lg-12" style="width:150px;"> <spring:message code="application.team"/> <span class="required_field">*</span></label>
					              <div class="col-lg-12">
					                      
								      <div class="navbar navbar-default" style="background:#fff; border:0px; margin:0px;" role="navigation">
								 				<select class="custom-select" name="id_member">
									                    		<c:forEach var="crt" items="${users}">
																	<option value="${crt.id_u}"> <c:out value="${crt.nom} ${crt.prenom}" /> </option>
																</c:forEach>																
												</select>
								      </div>
								     
					              </div>
					            </div>
					            
					                
					
					          </div>
					          <div class="modal-footer">
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