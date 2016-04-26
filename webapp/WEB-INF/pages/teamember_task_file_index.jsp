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
	  
	  <security:authorize ifAllGranted="ROLE_DASHBOARD_MANAGER"> 
	  
      <div class="navbar navbar-default" role="navigation">
        
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only"> Toggle Navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
          </div>
          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">			
              <div class="navbar-form navbar-left form-small"> 
	              
	              <a class="form-group" href ="${pageContext.request.contextPath}/teamember/task/${idT}/file/add"> 
	              	<button href="" class="btn btn-success" >  <i class="icon-plus"></i> <spring:message code="application.header.add.dashboardmanager.project"/></button>
	              </a>
              </div>
            
          </div>
         </div>
       </div>
       
       </security:authorize>
<!--       WI_CLIENTS_SEARCH END -->
      
        <c:if test="${not empty succesMessage}">
			    <div class="isa_success"><i class="fa fa-check"></i>${succesMessage}.</div>
	    </c:if>
         
        <div class="navbar navbar-default" role="navigation">
		 <!--WI_CLIENTS_SEARCH START-->        
		<div class="container-fluid">
		          <div class="navbar-header">
		            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only"> Toggle Navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
		          </div>
		          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">			             
		              
		              <div class="navbar-form navbar-left form-small"> 
			              
			              <a class="form-group" href ="${pageContext.request.contextPath}/teamember/task/${idT}/file/add"> 
			              	<button href="" class="btn btn-primary" >  <i class="icon-upload-alt"></i> <spring:message code="application.header.add.dashboardmanager.project.file"/></button>
			              </a>
		              </div>

		          </div>
		          <!-- /.navbar-collapse -->
		        </div>
		        <!-- /.container-fluid -->
		  </div>
		  <!--WI_CLIENTS_SEARCH END-->  
          
          <div class="col-md-12">
            <div class="widget">
              <div class="widget-content">
              		            
              <c:choose>
					 	<c:when test="${not empty files}">
					 		<div class="widget-foot">
				                 <ul class="">
				                   <li><h2> <spring:message code="application.header.table.file"/> </h2></li>
				                 </ul>
			                	<div class="clearfix"></div>
			             	</div>
			            
			                <table class="footable table table-bordered table-hover default footable-loaded">
			                  <thead>
			                    <tr>
			                      <th class="footable-visible">  <spring:message code="application.file.name"/></th>
			                      <th class="footable-visible" data-hide="phone"><spring:message code="application.file.url"/></th>
			                      <th class="footable-visible"><spring:message code="application.file.content"/></th>
			                      <th class="footable-visible"><spring:message code="application.file.attachementdate"/></th>
			                      <th  colspan="2" class="footable-visible footable-last-column" style="width: 25px; text-align: center; font-size: 14px;" data-hide="phone"> <label class="pick"></label> </th>
			                    </tr>
			                  </thead>
			                  <tbody>
		                  			<c:forEach items="${files}" var="c" >
				                    <tr>
				                      <td class="footable-visible"> ${c.nom}</td>
				                      <td class="footable-visible">
				                      			 <a href="${c.url}"  target="_blank"> ${c.url} </a>
				                      </td>
				                      <td class="footable-visible">
				                      	   <a href="${pageContext.request.contextPath}/teamember/file/download/${c.id_attachement}">
												<spring:message code="application.file.download"/>
												<img src="<c:url value="/images/icons/download.png"/>"   alt="Twins Outsourcing" />
											</a>
				                      </td>
				                      <td class="footable-visible"><fmt:formatDate value="${c.date_attachement}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
				                       
					                  <td class="tr-link-excluded footable-visible footable-last-column"> 
					                       <span>
					                        <button title="" data-original-title="" class="btn btn-xs btn-info" 
					                        onclick="location.href = '${pageContext.request.contextPath}/teamember/task/${idT}/file/update/${c.id_attachement}';"> <i class="icon-edit"></i> </button>
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
					                          <h2> Aucun attachement n'est trouvé. </h2>
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