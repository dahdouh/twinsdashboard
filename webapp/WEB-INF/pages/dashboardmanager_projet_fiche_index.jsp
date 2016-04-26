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
			
			          	  <a class="" href="${pageContext.request.contextPath}/dashboard/${projet.ficheClient.id_ficheClient}/project/detail"> <spring:message code="application.bashboardmanager.project.detail"/></a>
			          </li>
			          <li>   
			              <a class="" href="${pageContext.request.contextPath}/dashboard/${projet.id_projet}/sprint/"> <spring:message code="application.bashboardmanager.project.sprints"/></a>
			          </li>
			          <li>     
			            <a class="" href="${pageContext.request.contextPath}/dashboard/${projet.id_projet}/task/all"><spring:message code="application.bashboardmanager.project.tasks"/></a>
			          </li>
			
			          <li>
			             <a class="" href="${pageContext.request.contextPath}/dashboard/${projet.id_projet}/team/all"> <spring:message code="application.bashboardmanager.project.teamproject"/></a>
			           </li>
			
			          <li> 
			          	 <a class="" href="${pageContext.request.contextPath}/dashboard/${projet.id_projet}/file/all"> <spring:message code="application.bashboardmanager.project.Files"/></a>
			          </li>
			          <li> 
			          	 <a class="" href="${pageContext.request.contextPath}/dashboard/${projet.id_projet}/event/all"> <spring:message code="application.bashboardmanager.project.event"/></a>
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
			        <li class="border-right url-link" data-link="${pageContext.request.contextPath}/dashboard/${projet.id_projet}/sprint/completed/">
			          <div class="text-count">${CountTasksCompleted}</div>
			          <div class="text-description text-muted"> <spring:message code="application.status.completed"/></div>
			        </li>
			        <li class="border-right url-link" data-link="${pageContext.request.contextPath}/dashboard/${projet.id_projet}/sprint/inprogress/">
			          <div class="text-count">${CountTasksInprogress}</div>
			          <div class="text-description text-muted"><spring:message code="application.status.inprogress"/></div>
			        </li>
			        <li class="url-link" data-link="${pageContext.request.contextPath}/dashboard/${projet.id_projet}/sprint/pending/">
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
                <!-----------------------------------------------TABS-FILES------------------------------------------------------------------>
                <div class="project-info-tabs">
                  <!--WI_FILES_NAVIGATION-->
                  <div class="row">
                   
		          <div class="col-lg-12">
		            <div class="widget" style="border:none;">
		            
		            <h2>
						<i class="icon-user"></i>
						${projet.ficheClient.client.societe} 
					</h2>
					<div class="project-spacer"></div>
					
		              <div class="widget-content widget-content-project">
		                <div class="project-info-tabs">
		                  
		                  <div class="res-project-summary" --="">
		                    <!--project head-->
		                    <div class="project-details">
		                      <!--WI_PROJECT_HEAD-->
		                      <div class="project-home">
		                        
		                        <div class="project-heading-left">
		                          <div class="col-xs-12 col-md-6">
		                          <span class="label label-default-dark label-projects" id="project-timer">
			                         ${datepassed}
    							
 		                           </span></div>
		                          <div class="col-xs-12 col-md-6">
		                          	<span class="label label-danger label-projects">
		                   				<i class="icon-warning-sign"></i>  
		                   				<fmt:formatDate value="${projet.date_creation}" pattern="yyyy-MM-dd hh:mm:ss"/>
		                   			</span></div>
		                          <div class="clearfix"></div>
		                        </div>
		                      </div>
		                      <!--WI_PROJECT_HEAD-->
		                      <div class="project-spacer"></div>
		                      <!--WI_PROJECT_CONTACTS-->
		                      <div class="project-home">
		                        <div class="project-home-split-right">
		                          <!--client main contact-->
		                          <div class="col-xs-6 project-users"> 
		                          <span>
										<img class="avatar-small image-boardered pull-left" src="<c:url value="/images/shared/default.png"/>"   alt="" />
								  </span>
		                          
		                            <div class="pull-left avatar-information"> 
		                            <span><span class="label label-purple"> <spring:message code="application.ficheprojet.main.contact"/></span></span> 
		                            <span>${projet.ficheClient.prenomContact} ${projet.ficheClient.nomContact} </span> 
		                            <span>Tel: ${projet.ficheClient.telephone_1}</span>
		                            <span>Email: ${projet.ficheClient.emailContact}</span>
		                             </div>
		                            <div class="clearfix"></div>
		                          </div>
		                          <!--client main contact end-->
		                          <!--team main contact-->
		                          <div class="col-xs-6 project-users">
		                           <span>
										<img class="avatar-small image-boardered pull-left" src="<c:url value="/images/shared/default.png"/>"   alt="" />
								  </span>
		                            <div class="pull-left avatar-information"> 
		                            		<span><span class="label label-info"> <spring:message code="application.ficheprojet.project.leader"/></span></span> 
		                            		<span>${projet.chefprojet.prenom} ${projet.chefprojet.nom}</span> 
		                            		<span>tel: ${projet.chefprojet.tel}</span> 
		                            		<span>Email: ${projet.chefprojet.email}</span> 
		                            </div>
		                            <div class="clearfix"></div>
		                          </div>
		                          <!--team main contact end-->
		                          <div class="clearfix"></div>
		                        </div>
		                      </div>
		                      <!--WI_PROJECT_CONTACTS-->
		                      <div class="project-spacer"></div>
		                      <!--WI_PROJECT_BRIEF-->
		                      <div id="project-brief">
		                        <h4><span class="allcaps"> <spring:message code="application.ficheprojet.project.brief"/></span></h4>
		                        ${projet.desc}</div>
		                      <!--WI_PROJECT_BRIEF-->
		                      <div class="project-spacer"></div>
		                      <!--WI_ADDITIONAL_PROJECT_DETAILS-->
		                      <div id="project-details"> <a class="divminimize divminimize-project-details" href="#"> <i class="icon-chevron-down"></i>
		                        <h4 style="display:inline-block;"><span class="allcaps"><spring:message code="application.ficheprojet.project.additional.details"/></span></h4>
		                        </a>
		                        <div class="toggle-div" style="display: block;">
		                          <!--project details list-->
		                          <div class="col-lg-12">
		                            
		                            <ul class="data-list project-addition-details">
		                             <c:if test="${not empty projet.ficheClient.siteweb}">
			                              <li>
			                                <label>URL:</label>
			                                <span>${projet.ficheClient.siteweb}</span>
			                              </li>
		                              </c:if>
		                              <c:if test="${not empty projet.ficheClient.telephone_2}">
			                              <li>
			                                <label>telephone 2 :</label>
			                                <span> ${projet.ficheClient.telephone_2} </span>
			                              </li>
      							      </c:if>

		                            </ul>
		                          </div>
		                          <!--project details list-->
		                          <!--wi_additional_project_details_notfound-->
		                          
		                          <!--wi_additional_project_details_notfound-->
		                        </div>
		                      </div>
		                      <!--WI_ADDITIONAL_PROJECT_DETAILS-->
		                      <div class="project-spacer"></div>
		                      <!--WI_EDIT_PROJECT_BUTTON-->
		                      
		                      <div id="project-details">
		                        
		                        <!--permissions-->
		                        <div class="col-lg-12" align="center">
		                          <a class="form-group" href="${pageContext.request.contextPath}/dashboard/project/update/${projet.id_projet}">
		                            <button class="btn btn-success btn-lg" href="${pageContext.request.contextPath}/dashboard/project/update/${projet.id_projet}" data-toggle="modal"><spring:message code="application.project.edit"/></button>
		                          </a>
		                        </div>
		                      </div>
		                      <!--WI_EDIT_PROJECT_BUTTON-->
		                    </div>
		                  </div>
		                </div>
		                <!--WI_TABS_NOTIFICATION-->
		                
		                <!--WI_TABS_NOTIFICATION-->
		              </div>
		            </div>
		          </div>
		          <!------------------------------------PROJECT-DETAILS-END--------------------------------------------------->
		          
		                
		                <div class="clearfix"></div>
		                <!-----------------------------------------------TABS-FILES------------------------------------------------------------------>
		              </div>
		            </div>
		          </div>
		        </div>
		       </div>
       
    
    </div>

   </div> 
  </div>
    </tiles:putAttribute>
</tiles:insertDefinition>