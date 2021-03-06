<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
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
          
          <div class="col-md-12">
            <div class="widget">
              <div class="widget-content">
              	
              	<div class="widget-foot">
	                 <!--WI_PAGINATION-->
	                 <ul class="">
	                   <li><h2> <spring:message code="application.header.table.task"/> </h2></li>
	                 </ul>
	                 <!--WI_PAGINATION-->
	                <div class="clearfix"></div>
	            </div>
	            
              <c:choose>
			 <c:when test="${not empty tasks}">
	                <table class="footable table table-bordered table-hover default footable-loaded">
	                  <thead>
	                    <tr>
			              <th class="footable-visible">  <spring:message code="application.task.name"/></th>
			              <th class="footable-visible" data-hide="phone"><spring:message code="application.sprint"/></th>
			              <th class="footable-visible"><spring:message code="application.task.startdate"/></th>
			              <th class="footable-visible"><spring:message code="application.task.enddate"/></th>
			              <th class="footable-visible" data-hide="phone"><spring:message code="application.task.startdateeffective"/></th>
			              <th class="footable-visible" data-hide="phone"><spring:message code="application.task.enddateeffective"/></th>
			              <th class="footable-visible"><spring:message code="application.task.estimation"/></th>
			              <th class="footable-visible"><spring:message code="application.task.priority"/></th>
			              <th class="footable-visible"><spring:message code="application.task.status"/></th>
			              <th class="footable-visible" data-hide="phone"><spring:message code="application.task.respect"/></th>	                      
	                      <th  colspan="2" class="footable-visible footable-last-column" style="width: 25px; text-align: center; font-size: 14px;" data-hide="phone"> <label class="pick"></label> </th> 
	                    </tr>
	                  </thead>
	                  <tbody>
                  			<c:forEach items="${tasks}" var="c" >
		                    <tr>
		                      		  <td class="footable-visible"> ${c['0'].nom}</td>
				                      <td class="footable-visible">${c['0'].sprint.nom}</td>
				                      <td class="footable-visible"><fmt:formatDate value="${c['0'].date_debut}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
				                      <td class="footable-visible"><fmt:formatDate value="${c['0'].date_fin}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
				                      <td class="footable-visible"><fmt:formatDate value="${c['0'].date_debut_effective}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
				                      <td class="footable-visible"><fmt:formatDate value="${c['0'].date_fin_effective}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
				                       <td class="footable-visible">${c['0'].estimation}</td>
				                      <td class="footable-visible">${c['0'].priorite}</td>
				                      <td class="footable-visible">
				                      		<c:if test="${c['0'].statut.libelle == 'In Progress'}" >
				                      			<span id="bns-status-badge" class="label label-purple">${c['0'].statut.libelle}</span>
				                      		</c:if>
				                      		<c:if test="${c['0'].statut.libelle == 'Completed'}" >
				                      			<span id="bns-status-badge" class="label label-danger">${c['0'].statut.libelle}</span>
				                      		</c:if>
				                      		<c:if test="${c['0'].statut.libelle == 'Pending'}" >
				                      			<span id="bns-status-badge" class="label label-warning">${c['0'].statut.libelle}</span>
				                      		</c:if>
				                      </td>
				                      
				                         
<%-- 				                      <fmt:formatDate value="${c.date_debut_effective}" pattern="yyyy-MM-dd hh:mm:ss" var="date_debut_effective"/> --%>
<%-- 				                      <fmt:formatDate value="${c.date_fin_effective}" pattern="yyyy-MM-dd hh:mm:ss" var="date_fin_effective"/> --%>
				                      
<%-- 				                      <fmt:parseNumber --%>
<%--   				                        value="${ date_debut / (1000*60*60*24) }"  --%>
<%--   									    integerOnly="true" var="dsss" scope="page"/>   --%>
									
<%-- 									<fmt:parseNumber --%>
<%-- 									    value="${ c.date_fin / (1000*60*60*24) }" --%>
<%-- 									    integerOnly="true" var="date_fin" scope="page"/> --%>
									    
<%-- 									 <fmt:parseNumber --%>
<%-- 									    value="${ c.date_debut_effective / (1000*60*60*24) }" --%>
<%-- 									    integerOnly="true" var="date_debut_effective" scope="page"/> --%>
									
<%-- 									<fmt:parseNumber --%>
<%-- 									    value="${ c.date_fin_effective) / (1000*60*60*24) }" --%>
<%-- 									    integerOnly="true" var="date_fin_effective)" scope="page"/>    --%>
				                      
				                      
				                      <td class="footable-visible"> 
				                      		<c:if test="${c['1'] >= c['2'] }" >
				                      			<label class="icone_green"></label>
				                      		</c:if> 
				                      		<c:if test="${c['1'] <= c['2'] }" >
				                      			<label class="icone_red"></label>
				                      		</c:if> 

<%-- 										 <p> ${c['1']}</p> --%>
<%-- 										   <h2> ${c['2']}  </h2> --%>
										  
											
				                      </td>
				                      
				                      <td class="tr-link-excluded footable-visible footable-last-column"> 
				                       <span>
				                        <button title="" data-original-title="" class="btn btn-xs btn-success" 
				                        onclick="location.href = '${pageContext.request.contextPath}/teamember/${c['0'].sprint.id_sprint}/task/update/${c['0'].id_task}';"> <i class="icon-edit"></i> </button>
				                       </span>
				                   
				                      <span>
								            <button title="" data-original-title="" class="btn btn-xs btn-info"
								               onclick="location.href = '${pageContext.request.contextPath}/teamember/task/${c['0'].id_task}/file';"> 
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
			                          <h2> Aucun Projet n'est trouv�. </h2>
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
            </div>
          </div>
        </div>
        <!--WI_CLIENTS_TABLE-->
        <!--WI_NOTIFICATION-->
        
        <!--WI_NOTIFICATION-->
      </div>
    <!-- Matter ends -->

    </tiles:putAttribute>
</tiles:insertDefinition>