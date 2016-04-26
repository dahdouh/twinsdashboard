<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
 
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
		          	  <!------------------------------------PROJECT-DETAILS-END--------------------------------------------------->
		          
		                
		                <div class="clearfix"></div>
		                <!-----------------------------------------------TABS-FILES------------------------------------------------------------------>
	
		            
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
			              
			              <a class="form-group" href ="${pageContext.request.contextPath}/dashboard/${sprint.id_sprint}/task/add"> 
			              	<button href="" class="btn btn-primary" >  <i class="icon-check"></i> <spring:message code="application.header.add.dashboardmanager.project.task"/></button>
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
		          
		          <!------------------------------------ 		    List of Tasks ---------------------------------------->
		          <div class="col-md-12">
		            <div class="widget">
		              <div class="widget-content">

		              <c:choose>
					 	<c:when test="${not empty tasks}">
					 		<div class="widget-foot">
				                 <ul class="">
				                   <li><h2> <spring:message code="application.header.table.task"/> </h2></li>
				                 </ul>
			                	<div class="clearfix"></div>
			             	</div>
			            
			                <table class="footable table table-bordered table-hover default footable-loaded">
			                  <thead>
			                    <tr>
			                      <th class="footable-visible">  <spring:message code="application.task.name"/></th>
			                      <th class="footable-visible" data-hide="phone"><spring:message code="application.task.desc"/></th>
			                      <th class="footable-visible"><spring:message code="application.task.startdate"/></th>
			                      <th class="footable-visible"><spring:message code="application.task.enddate"/></th>
			                      <th class="footable-visible"><spring:message code="application.task.responsible"/></th>
			                      <th class="footable-visible"><spring:message code="application.task.estimation"/></th>
			                      <th class="footable-visible"><spring:message code="application.task.priority"/></th>
			                      <th class="footable-visible"><spring:message code="application.task.status"/></th>
			                      <th  colspan="2" class="footable-visible footable-last-column" style="width: 25px; text-align: center; font-size: 14px;" data-hide="phone"> <label class="pick"></label> </th>
			                    </tr>
			                  </thead>
			                  <tbody>
		                  			<c:forEach items="${tasks}" var="c" >
				                    <tr>
				                      <td class="footable-visible"> ${c.nom}</td>
				                      <td class="footable-visible">${c.desc}</td>
				                      <td class="footable-visible"><fmt:formatDate value="${c.date_debut}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
				                      <td class="footable-visible"><fmt:formatDate value="${c.date_fin}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
				                      <td class="footable-visible">${c.responsable.nom} ${c.responsable.prenom}</td>
				                       <td class="footable-visible">${c.estimation}</td>
				                      <td class="footable-visible">${c.priorite}</td>
				                      <td class="footable-visible">
				                      		<c:if test="${c.statut.libelle == 'In Progress'}" >
				                      			<span id="bns-status-badge" class="label label-purple">${c.statut.libelle}</span>
				                      		</c:if>
				                      		<c:if test="${c.statut.libelle == 'Completed'}" >
				                      			<span id="bns-status-badge" class="label label-danger">${c.statut.libelle}</span>
				                      		</c:if>
				                      		<c:if test="${c.statut.libelle == 'Pending'}" >
				                      			<span id="bns-status-badge" class="label label-warning">${c.statut.libelle}</span>
				                      		</c:if>
				                      </td>
				                       
				                      <td class="tr-link-excluded footable-visible footable-last-column"> 
				                       <span>
				                        <button title="" data-original-title="" class="btn btn-xs btn-info" 
				                        onclick="location.href = '${pageContext.request.contextPath}/dashboard/${c.sprint.id_sprint}/task/update/${c.id_task}';"> <i class="icon-edit"></i> </button>
				                       </span>
				                       
				                      <span>
				                       <button title="" data-original-title="" class="btn btn-xs btn-danger ajax-delete-record" data-popconfirm-yes="<spring:message code="application.crud.yes"/>" data-popconfirm-no="<spring:message code="application.crud.no"/>" 
				                        data-popconfirm-title="<spring:message code="application.crud.delete"/>" data-popconfirm-placement="left" data-mysql-record-id="1" 
				                        onclick="location.href = '${pageContext.request.contextPath}/dashboard/${c.sprint.id_sprint}/task/delete/${c.id_task}';"> <i class="icon-trash"></i> </button>
				                      </span>
				                      
				                      <span>
								            <button title="" data-original-title="" class="btn btn-xs btn-info"
								               onclick="location.href = '${pageContext.request.contextPath}/dashboard/${c.sprint.id_sprint}/file/task/${c.id_task}';"> 
								               <i class="icon-hand-right"></i> <spring:message code="application.header.view.dashboardmanager.file"/>
								            </button>
								      </span> 
				                        
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
					                          <h2> Aucun Tâches n'est trouvé. </h2>
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
								<button class="btn btn-xs btn-danger tooltips" title="" data-original-title="<spring:message code="application.fotter.table.info.delete"/>">
								<i class="icon-trash"></i>
								</button>
								<button class="btn btn-xs btn-info tooltips" title=""  data-original-title="<spring:message code="application.fotter.table.info.edit"/>">
								<i class="icon-edit"></i>
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
		       </div>
       
    
    </div>

   </div> 
  </div>
    </tiles:putAttribute>
</tiles:insertDefinition>