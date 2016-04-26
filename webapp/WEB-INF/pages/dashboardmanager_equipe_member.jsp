<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tiles:insertDefinition name="DashboardMangerTemplate">
    <tiles:putAttribute name="body">
	
    <!-- Matter -->
    <div class="matter">
      <div class="container">
        <!--WI_CLIENTS_TABLE-->
        <!--WI_CLIENTS_SEARCH-->
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
	              
	              <a class="form-group" href ="${pageContext.request.contextPath}/dashboard/team/${equipe.id_equipe}/member/add"> 
	              	<button href="" class="btn btn-success" > 

			                          <i class="icon-plus"></i> <spring:message code="application.header.add.team"/>
	              	 </button>
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
	                      <th  colspan="2" class="footable-visible footable-last-column" style="width: 25px; text-align: center; font-size: 14px;" data-hide="phone"> <label class="pick"></label> </th>
	                    </tr>
	                  </thead>
	                  <tbody>
                  			<c:forEach items="${members}" var="m" >
		                    <tr>
		                      <td class="footable-visible"> ${m.nom} ${m.prenom} </td>
		                      <td class="footable-visible"> ${m.email}</td>
		                      <td class="footable-visible"> ${m.tel} </td>
		                    
		                      <td>
		                       <div align="center">
 				                   <span>
				                       <button title="" data-original-title="" class="btn btn-xs btn-danger ajax-delete-record" data-popconfirm-yes="<spring:message code="application.crud.yes"/>" data-popconfirm-no="<spring:message code="application.crud.no"/>" 
				                        data-popconfirm-title="<spring:message code="application.crud.delete"/>" data-popconfirm-placement="left" data-mysql-record-id="1" 
				                        onclick="location.href = '${pageContext.request.contextPath}/dashboard/team/${equipe.id_equipe}/member/delete/${m.id_u}';"> <i class="icon-trash"></i> </button>
				                   </span>
				                  
				                    
								</div> 
		                      </td>
		                    </tr>
		                 </c:forEach>
	                  </tbody>
	                </table>
	                <div class="widget-foot">
								<div class="bns-info-div pull-left" style="max-width:350px; margin-top:8px;">
								Information:
								<button class="btn btn-xs btn-danger tooltips" title="" data-original-title="<spring:message code="application.fotter.table.info.delete"/>">
								<i class="icon-trash"></i>
								</button>
								</div>
								<ul class="pagination pull-right"> </ul>
								<div class="clearfix"></div>
				    </div>
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
			                          <h2> Aucun Member n'est trouvé. </h2>
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