<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<tiles:insertDefinition name="DashboardMangerTemplate">
    <tiles:putAttribute name="body">
	
    <!-- Matter -->
<div class="matter">
    
  <div class="row">
      
	 <c:if test="${not empty succesMessage}">
			    <div class="isa_success"><i class="fa fa-check"></i>${succesMessage}.</div>
     </c:if>
	  
    <div class="modal-dialog">
      	
      	<div class="col-md-12">
            <div class="widget">
             <div class="widget-content">
	          <div class="modal-header">
	            <!--full screen icon - custom.js-->
	            <button type="button" class="full-screen-modal close" aria-hidden="true"><i class="icon-fullscreen"></i></button>
	            <!--full screen icon - custom.js-->
	            <h4 class="modal-title">  <spring:message code="application.header.invite.dashboardmanager.event"/> </h4>
	          </div>
	          
		      <c:if test="${not empty msgError}">
				<div class="isa_error"><i class="fa fa-times-circle"></i>${msgError}.</div>
		     </c:if>
	          
	          <form method="post"  action="${pageContext.request.contextPath}/dashboard/event/invite/${idE}">
	          <div class="modal-body">
	          
			             <c:choose>
						 <c:when test="${not empty users}">
				                <table class="table table-hover default footable-loaded">
				                  <thead>
				                    <tr>
				                      <th class="footable-visible">  <spring:message code="application.user.name"/></th>
				                      <th class="footable-visible" data-hide="phone"><spring:message code="application.user.tel"/></th>
			 						  <th class="footable-visible" data-hide="phone"><spring:message code="application.user.email"/></th>
			 						  <th  colspan="2" class="footable-visible footable-last-column" style="width: 25px; text-align: center; font-size: 14px;" data-hide="phone"> <i class="icon-reorder"></i> </th>
				                    </tr>
				                  </thead>
				                  <tbody>
			                  			<c:forEach items="${users}" var="m" >
					                    <tr>
					                      <td class="footable-visible"> ${m.nom} ${m.prenom}</td>
					                      <td class="footable-visible"> ${m.tel}</td>
					                      <td class="footable-visible">${m.email}</td>
					                    
					                      <td>
					                      
					                       <div align="center">
			 				                     <input type="checkbox" name="checkBox_invite_users" value="${m.id_u}">	
			 				                     							                    
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
						                          <h2> Aucun Utilisateur n'est trouvé. </h2>
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
				   <div class="modal-footer">
						            <input class="btn btn-default" value="<spring:message code="application.crud.reset"/>" id="" name="reset" type="reset">
						            <input class="btn btn-primary" value=" <spring:message code="application.header.invite.dashboardmanager.event"/>" id="" name="submit" type="submit">
					            
				   </div>
				   </form>
					    
              </div>
            </div>
          </div>
      
    </div>
  </div>
</div> 
    </tiles:putAttribute>
</tiles:insertDefinition>