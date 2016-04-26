<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
 
<tiles:insertDefinition name="DashboardMangerTemplate">
    <tiles:putAttribute name="body">
 
 		
    <!-- Matter -->
    <div class="matter">
      <div class="container">
      
      <c:if test="${not empty succesMessage}">
			    <div class="isa_success"><i class="fa fa-check"></i>${succesMessage}.</div>
				
      </c:if>
          
          <div class="col-md-12">
            <div class="widget">
              <div class="widget-content">
              	
              	<div class="widget-foot">
	                 <!--WI_PAGINATION-->
	                 
	                 <ul class="">
	                   <li><h2> <spring:message code="application.header.table.ficheclient"/> </h2></li>
	                 </ul>
	                                 
	                 
	                 <!--WI_PAGINATION-->
	                <div class="clearfix"></div>
	            </div>
	            
	            <div class="navbar-form navbar-left form-small"> 
			              <a class="form-group" href ="${pageContext.request.contextPath}/dashboard/fiche/add"> 
			              	<button href="" class="btn btn-success" >  <i class="icon-plus"></i> <spring:message code="application.header.add.dashboardmanager.ficheclient"/></button>
			              </a>
		         </div>
	            
              <c:choose>
			 <c:when test="${not empty fichesclient}">
		             
	                <table class="footable table table-bordered table-hover default footable-loaded">
	                  <thead>
	                    <tr>
	                      <th class="footable-visible">  <spring:message code="application.ficheprojet.contactName"/></th>
	                      <th class="footable-visible" data-hide="phone"><spring:message code="application.ficheprojet.contactEmail"/></th>
	                      <th class="footable-visible"><spring:message code="application.ficheprojet.contactTel1"/></th>
	                      <th class="footable-visible"><spring:message code="application.ficheprojet.contactTel2"/></th>
	                      <th class="footable-visible"><spring:message code="application.ficheprojet.contactAdress"/></th>
	                      <th class="footable-visible"><spring:message code="application.ficheprojet.contactWebSite"/></th>
	                      <th class="footable-visible"><spring:message code="application.header.table.client"/></th>
	                      <th class="footable-visible"><spring:message code="application.project"/></th>
	                      <th  colspan="2" class="footable-visible footable-last-column" style="width: 25px; text-align: center; font-size: 14px;" data-hide="phone"> <label class="pick"></label> </th>
	                    </tr>
	                  </thead>
	                  <tbody>
                  			<c:forEach items="${fichesclient}" var="c" >
		                    <tr>
		                      <td class="footable-visible"> ${c.nomContact} ${c.prenomContact} </td>
		                      <td class="footable-visible">${c.emailContact}</td>
		                      <td class="footable-visible">${c.telephone_1}</td>
		                      <td class="footable-visible">${c.telephone_2}</td>
		                      <td class="footable-visible">${c.adresse}</td>
		                      <td class="footable-visible">
		                      		 <a href="http://${c.siteweb}"> ${c.siteweb}</a>
		                      		 </td>
		                      
		                      <td class="footable-visible">${c.client.societe}</td>
		                      
		                      <td class="footable-visible">
		                      		
		                      		<c:choose> 
									  <c:when test="${empty c.projet}">
									    	   <span>
						                        	<button title="" data-original-title="" class="btn btn-xs btn-success"
						                        	onclick="location.href = '${pageContext.request.contextPath}/dashboard/${c.id_ficheClient}/project/add';"> 
						                        	   <i class="icon-plus"></i> <spring:message code="application.header.add.dashboardmanager.project"/>
						                        	 </button>
						                       </span>
									  </c:when>
									  <c:otherwise>
									     		<span>
						                        	<button title="" data-original-title="" class="btn btn-xs btn-primary"
						                        	 onclick="location.href = '${pageContext.request.contextPath}/dashboard/${c.id_ficheClient}/project/detail';"> 
						                        	   <i class="icon-info-sign"></i> <spring:message code="application.header.view.dashboardmanager.project"/>
						                        	 </button>
						                       	</span>
									  </c:otherwise>
								</c:choose>
		                      
		                      </td>
		                      
		                      <td class="tr-link-excluded footable-visible footable-last-column"><!--control buttons delete-->
		                         
		                         <span>
		                        	<button title="" data-original-title="" class="btn btn-xs btn-info" 
		                        	onclick="location.href = '${pageContext.request.contextPath}/dashboard/fiche/update/${c.id_ficheClient}';"> <i class="icon-edit"></i> </button>
			                      </span>
			                      <span>
			                       <button title="" data-original-title="" class="btn btn-xs btn-danger ajax-delete-record" data-popconfirm-yes="<spring:message code="application.crud.yes"/>" data-popconfirm-no="<spring:message code="application.crud.no"/>" 
			                        data-popconfirm-title="<spring:message code="application.crud.delete"/>" data-popconfirm-placement="left" data-mysql-record-id="1" 
			                        onclick="location.href = '${pageContext.request.contextPath}/dashboard/fiche/delete/${c.id_ficheClient}';"> <i class="icon-trash"></i> </button>
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
			                          <h2> Aucun Fiche Client n'est trouvé. </h2>
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
								<button class="btn btn-xs btn-info tooltips" title="" data-original-title="<spring:message code="application.fotter.table.info.edit"/>">
								<i class="icon-edit"></i>
								</button>
								</div>
								<ul class="pagination pull-right"> </ul>
								<div class="clearfix"></div>
						</div>	
              </div>
            </div>
          </div>
 	</div>
<!--  	Tasks END  -->
  </div>
  <!--  MATTER END  -->
  
 
 
    </tiles:putAttribute>
</tiles:insertDefinition>