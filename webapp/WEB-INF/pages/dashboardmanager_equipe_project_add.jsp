<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tiles:insertDefinition name="DashboardMangerTemplate">
    <tiles:putAttribute name="body">
	
    <!-- Matter -->
    <div class="matter">
      <div class="container">
      
      
      <div class="row">
        
            <!---------------------------------------------------   COMMON PROJECT MENU --------------------------------------------------->
            <!----------------------------------------------------------------------------------------------------------------------------->
          <!--WI_PROJECT_NAV_CONTENT-->
          <div class="col-lg-3">
            <!--WI_MAIN_NAVIGATION-->
			<div class="row">
			  <!--WI_PROJECT_MENU-->
			  <div class="col-lg-12 project-menu">
			    <div class="box side-menu-main">
			      <div class="box-head-dark"><i class="icon-list"></i> <spring:message code="application.bashboardmanager.project.menu"/></div>
			      <div class="box-content">
			        <ul>
			          <li> 
			
			          	  <a class="" href="${pageContext.request.contextPath}/dashboard/${idF}/project/detail"> <spring:message code="application.bashboardmanager.project.detail"/></a>
			          </li>
			          <li>   
			              <a class="" href="${pageContext.request.contextPath}/dashboard/${idP}/sprint/"> <spring:message code="application.bashboardmanager.project.sprints"/></a>
			          </li>
			          <li>     
			            <a class="" href="${pageContext.request.contextPath}/dashboard/${idP}/task/all"><spring:message code="application.bashboardmanager.project.tasks"/></a>
			          </li>
			
			          <li>
			             <a class="" href="${pageContext.request.contextPath}/dashboard/${idP}/team/all"> <spring:message code="application.bashboardmanager.project.teamproject"/></a>
			           </li>
			
			          <li> 
			          	 <a class="" href="${pageContext.request.contextPath}/dashboard/${idP}/file/all"> <spring:message code="application.bashboardmanager.project.Files"/></a>
			          </li>
			          <li> 
			          	 <a class="" href="${pageContext.request.contextPath}/dashboard/${idP}/event/all"> <spring:message code="application.bashboardmanager.project.event"/></a>
			          </li>
			           
			        </ul>
			      </div>
			    </div>
			  </div>
			  <!--WI_PROJECT_MENU-->
			  <!--WI_MY_TASKS-->
			  <div class="col-lg-12">
			    <div class="split-info-panel project">
			      <div class="split-info-panel-header bg-info"> <span class="split-panel-heading"> <spring:message code="application.bashboardmanager.project.sprints"/></span> </div>
			      <ul class="split-info-panel-footer">
			        <li class="border-right url-link" data-link="${pageContext.request.contextPath}/dashboard/${idP}/sprint/completed/">
			          <div class="text-count">${CountTasksCompleted}</div>
			          <div class="text-description text-muted"> <spring:message code="application.status.completed"/></div>
			        </li>
			        <li class="border-right url-link" data-link="${pageContext.request.contextPath}/dashboard/${idP}/sprint/inprogress/">
			          <div class="text-count">${CountTasksInprogress}</div>
			          <div class="text-description text-muted"><spring:message code="application.status.inprogress"/></div>
			        </li>
			        <li class="url-link" data-link="${pageContext.request.contextPath}/dashboard/${idP}/sprint/pending/">
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
        
           
 		        
		        <div class="col-lg-9">
            <div class="widget">
              <div class="widget-content-project">
              
                
                <!-----------------------------------------------CONTENT CHANGES------------------------------------------------------------------>
		       
		      		<div class="modal-dialog">
					    <c:choose>
					      <c:when test="${not empty equipes}">  
					     <form:form  modelAttribute="projet" method="post" action="${pageContext.request.contextPath}/dashboard/${idP}/team/add">
					        <div class="modal-content">
					          <div class="modal-header">
					            <!--full screen icon - custom.js-->
					            <button type="button" class="full-screen-modal close" aria-hidden="true"><i class="icon-fullscreen"></i></button>
					            <!--full screen icon - custom.js-->
					            <h4 class="modal-title">  <spring:message code="application.header.add.dashboardmanager.team"/> </h4>
					          </div>
					          <div class="modal-body">
					           
					             <div class="form-group" style="margin-bottom:10px;">
					              <label class="control-label col-lg-12" style="width:150px;"> <spring:message code="application.team"/> <span class="required_field">*</span></label>
					              <div class="col-lg-12">
					                      
								      <div class="navbar navbar-default" style="background:#fff; border:0px; margin:0px;" role="navigation">
								 				<select class="custom-select" name="id_equipe">
									                    		<c:forEach var="crt" items="${equipes}">
																	<option value="${crt.id_equipe}"> <c:out value="${crt.nom}" /> </option>
																</c:forEach>																
												</select>
								      </div>
								     
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
				      
				      </c:when>
					    
								<c:otherwise>
										
										<div style="padding-bottom:0px;">
							                <table class="table">
							                   <tbody>
							                    
							                    <tr>
							                      
							                      <td colspan="4"><div align="center">
							                          <p>&nbsp;</p>
							                          <p>&nbsp;</p>
							                          <h2> Toutes les �quipes sont travaill�es sur le projet, veuillez ajouter une nouvelle �quippe. </h2>
							                          <p>&nbsp;</p>
							                          <p>&nbsp;</p>
							                        </div></td>
							                    </tr>
							                    
							                  </tbody>
							                </table>
							            </div>			
														
							   </c:otherwise>
							</c:choose>
					    </div>

		        <!-----------------------------------------------END CONTENT CHANGES------------------------------------------------------------------>
		          
		           
		           
		           </div>
		          </div>
		        </div>
          <!---------------------------------------------------   BODY PROJECT  --------------------------------------------------->
          <!----------------------------------------------------------------------------------------------------------------------------->
          
       
    
    </div>
 </div>
        <!--WI_CLIENTS_TABLE-->
        <!--WI_NOTIFICATION-->
        
        <!--WI_NOTIFICATION-->
      </div>
    <!-- Matter ends -->

    </tiles:putAttribute>
</tiles:insertDefinition>



<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> --%>
<%-- <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> --%>
<%-- <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %> --%>
 
<%-- <tiles:insertDefinition name="DashboardMangerTemplate"> --%>
<%--     <tiles:putAttribute name="body"> --%>
	
<!--     Matter -->
<!--     <div class="matter"> -->
    
<!--     	<div class="row"> -->
    
<!-- </div> -->

<!--     </div>  -->
<%--     </tiles:putAttribute> --%>
<%-- </tiles:insertDefinition> --%>