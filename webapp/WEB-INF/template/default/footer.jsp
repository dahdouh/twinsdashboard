<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
    <div class="row">
      <div class="col-md-12">
        <!-- Powered By -->
        <p class="copy">Copyright  	&copy; 2015 karim DAHDOUH  | <a href="http://www.twinyourbusiness.com"> Twins Outsourcing  </a>  - All rights reserved.</p>
      </div>
    </div>
</div>

  <div id="modalIframe" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
          <!--full screen icon - custom.js-->
          <button type="button" class="full-screen-modal close" aria-hidden="true"><i class="icon-fullscreen"></i></button>
          <!--full screen icon - custom.js-->
          <h4 class="modal-title" id="modal-iframe-title"> Edit</h4>
          <div class="clearfix"></div>
        </div>
        <div class="modal-body">
<!--           <iframe class="slimScrollBarModal----" frameborder="0"></iframe> -->
			<div class="row">
				<div class="col-md-12">
				<table class="table">
				<tbody>
				<tr>
					<td>
						<strong> <spring:message code="application.user.firstname"/> </strong>
					</td>
					<td>
							<c:out value='${sessionScope["user_logged_in"].prenom}' />    	 
					</td>
				</tr>
				<tr>
					<td>
						<strong> <spring:message code="application.user.firstname"/> </strong>
					</td>
					<td>
 							<c:out value='${sessionScope["user_logged_in"].nom}' />    							 	 
					</td>
				</tr>
				<tr>
					<td>
						<strong> <spring:message code="application.user.tel"/> </strong>
					</td>
					<td>
							<c:out value='${sessionScope["user_logged_in"].tel}' />    	 
					</td>
				</tr>
				<tr>
					<td>
						<strong> <spring:message code="application.user.email"/> </strong>
					</td>
					<td>
							<c:out value='${sessionScope["user_logged_in"].email}' />    	 
					</td>
				</tr>
				<tr>
					<td>
						<strong> <spring:message code="application.user.adress"/> </strong>
					</td>
					<td>
							<c:out value='${sessionScope["user_logged_in"].adresse}' />    	 
					</td>
				</tr>
				<tr>
					<td>
						<strong> <spring:message code="application.admin.permission.profil"/> </strong>
					</td>
					<td>
							<c:out value='${sessionScope["user_logged_in"].profil.titre}' />    	 
					</td>
				</tr>
				<tr>
					<td>
						<strong> <spring:message code="label.compte.login"/> </strong>
					</td>
					<td>
							<c:out value='${sessionScope["user_logged_in"].compte.login}' />    	 
					</td>
				</tr>
				<tr>
					<td>
						<strong> <spring:message code="label.compte.password"/> </strong>
					</td>
					<td>
							[hidden]    	 
					</td>
				</tr>
				
				</tbody>
				</table>
				</div>
			</div>
          
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal" aria-hidden="true">Close</button>
          
        </div>
      </div>
    </div>
  </div>