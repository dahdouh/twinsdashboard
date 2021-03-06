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
          
          <!--WI_PROJECT_NAV_CONTENT-->
          <div class="col-lg-9">
            <div class="widget">
              <div class="widget-content-project">
                
                <!-----------------------------------------------CONTENT CHANGES------------------------------------------------------------------>
		       <!--WI_CLIENTS_SEARCH END-->     
		      <c:if test="${not empty msgError}">
					<div class="isa_error"><i class="fa fa-times-circle"></i>${msgError}.</div>
			  </c:if> 
		      <div class="navbar navbar-default" role="navigation">
		        
		        <div class="container-fluid">
		          <div class="navbar-header">
		            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only"> Toggle Navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
		          </div>
		          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">			             
		              
		              <div class="navbar-form navbar-left form-small"> 
			              
			              <a class="form-group" href ="${pageContext.request.contextPath}/dashboard/${idP}/sprint/add"> 
			              	<button href="" class="btn btn-primary" >  <i class="icon-folder-open"></i> <spring:message code="application.header.add.team"/></button>
			              </a>
		              </div>
		            
		          </div>
		          <!-- /.navbar-collapse -->
		        </div>
		        <!-- /.container-fluid -->
		      </div>
		      <!--WI_CLIENTS_SEARCH END-->
      
<!--       <div class="isa_info"><i class="fa fa-info-circle"></i>kljmljkmkmmmljmlj</div> -->
<!--       <div class="isa_warning"><i class="fa fa-warning"></i>Replace this text with your own text.</div> -->
<!--       <div class="isa_error"><i class="fa fa-times-circle"></i>Replace this text with your own text.</div> -->
      
		        <c:if test="${not empty succesMessage}">
					    <div class="isa_success"><i class="fa fa-check"></i>${succesMessage}.</div>
						
		
		        </c:if>
		          
		          <div class="col-md-12">
		            <div class="widget">
		              <div class="widget-content">
			            
		              <c:choose>
			 <c:when test="${not empty users}">
	                <table class="footable table table-bordered table-hover default footable-loaded">
	                  <thead>
	                    <tr>
	                      <th class="footable-visible">  <spring:message code="application.team.name"/></th>
	                      <th class="footable-visible" data-hide="phone"><spring:message code="application.team.desc"/></th>
 						  <th class="footable-visible" data-hide="phone"><spring:message code="application.team.datecreation"/></th>
 						  <th class="footable-visible" data-hide="phone"><spring:message code="application.team.datecreation"/></th>
	                      <th  colspan="2" class="footable-visible footable-last-column" style="width: 25px; text-align: center; font-size: 14px;" data-hide="phone"> <i class="icon-reorder"></i> </th>
	                    </tr>
	                  </thead>
	                  <tbody>
                  			<c:forEach items="${users}" var="m" >
		                    <tr>
		                      <td class="footable-visible"> <span class="label label-purple"> ${m.profil.titre} </span> </td>
		                      <td class="footable-visible"> ${m.nom} ${m.prenom}</td>
		                      <td class="footable-visible"> ${m.tel} </td>
		                      <td class="footable-visible"> ${m.email}  </td>
		                    
		                      <td>
		                       <div align="center">
 				                     				                       
				                    <span>
				                       <button title="" data-original-title="" class="btn btn-xs btn-danger ajax-delete-record" data-popconfirm-yes="<spring:message code="application.crud.yes"/>" data-popconfirm-no="<spring:message code="application.crud.no"/>" 
				                        data-popconfirm-title="<spring:message code="application.crud.delete"/>" data-popconfirm-placement="left" data-mysql-record-id="1" 
				                        onclick="location.href = '${pageContext.request.contextPath}/dashboard/team/memeber/delete/${m.id_u}';"> <i class="icon-trash"></i> </button>
				                   </span>
				                  
								</div> 
		                      </td>
		                    </tr>
		                 </c:forEach>
	                  </tbody>
	                </table>
                 </c:when>
	    
				<c:otherwise>
						
						<div style="padding-bottom:0px;">
			                <table class="table">
			                  <thead>
			                   
			                  </thead>
			                  <tbody>
			                    
			                    <tr>
			                      
			                      <td colspan="4"><div align="center">
			                          <p>&nbsp;</p>
			                          <p>&nbsp;</p>
			                          <h2> Aucun Membre n'est trouv�. </h2>
			                          <p>&nbsp;</p>
			                          <p>&nbsp;</p>
			                        </div></td>
			                    </tr>
			                    
			                  </tbody>
			                </table>
			            </div>			
										
			   </c:otherwise>
			</c:choose>
		                <div class="widget-foot">
								<div class="bns-info-div pull-left" style="max-width:350px; margin-top:8px;">
								Information:
								 
								<button class="btn btn-xs btn-danger tooltips" data-original-title="Delete" title="">
									<i class="icon-trash"></i>
								</button>
								</div>
								<ul class="pagination pull-right"> </ul>
								<div class="clearfix"></div>
				         </div>
		              </div>
		            </div>
		          </div>

		           <!-----------------------------------------------END CONTENT CHANGES------------------------------------------------------------------>
		          
		           
		           
		           </div>
		          </div>
		        </div>
          <!---------------------------------------------------   BODY PROJECT  --------------------------------------------------->
          <!----------------------------------------------------------------------------------------------------------------------------->
          
       
    
    </div>

   </div> 
  </div>
    </tiles:putAttribute>
</tiles:insertDefinition>