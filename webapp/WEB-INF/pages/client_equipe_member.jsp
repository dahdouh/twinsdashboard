<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<tiles:insertDefinition name="ClientTemplate">
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
	                   <li><h2> <spring:message code="application.header.table.team.member"/> </h2></li>
	                 </ul>
	                 <!--WI_PAGINATION-->
	                <div class="clearfix"></div>
	            </div>
	            
            <c:choose>
			 <c:when test="${not empty members}">
	                <table class="footable table table-bordered table-hover default footable-loaded">
	                  <thead>
	                    <tr>
	                      <th class="footable-visible">  <spring:message code="application.user.name"/></th>
	                      <th class="footable-visible" data-hide="phone"><spring:message code="application.user.email"/></th>
 						  <th class="footable-visible" data-hide="phone"><spring:message code="application.user.tel"/></th>
	                    </tr>
	                  </thead>
	                  <tbody>
                  			<c:forEach items="${members}" var="m" >
		                    <tr>
		                      <td class="footable-visible"> ${m.nom} ${m.prenom} </td>
		                      <td class="footable-visible"> ${m.email}</td>
		                      <td class="footable-visible"> ${m.tel} </td>
		                   
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
			                          <h2> Il n'existe des membres pour l'instant. </h2>
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