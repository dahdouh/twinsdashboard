<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
				<!-- WI_HEADING_BAR -->
			         <div class="widget headerbar-widget">
			            <div class="pull-left dashboard-user-picture"><img src="<c:url value="/images/shared/default.png"/>"   alt="" /></div>
			            <div class="headerbar-project-title pull-left">
			              <h3><c:out value='${sessionScope["user_logged_in"].prenom} ${sessionScope["user_logged_in"].nom}' /> - <spring:message code="application.header.welcome"/> </h3>
			            </div>
			             <span style="float: right">
						    <a href="?lang=en"> <label class="pick-en"></label></a>    <a href="?lang=fr"><label class="pick-fr"></label></a>
						</span>
						
<!-- 						<div class="navbar navbar-default" style="display:table; float:right; width:5%; background:#fff; border:0px; margin:0px;" role="navigation"> -->

<!-- 			 				<select class="custom-select" name="utilisateur" > -->
<!-- 										<option value=""> <a href="?lang=en">en</a>  </option> -->
<!-- 										<option value=""> <a href="?lang=fr">fr</a> </option> -->
<!-- 							</select> -->
<!-- 			      		</div> -->
						
			            <div class="dashboard-user-group pull-right">
			              <label class="label label-default"><c:out value='${sessionScope["user_logged_in"].profil.titre} ' /></label>
			            </div>
			            <div class="clearfix"></div>
			          </div>
					<!--  WI_HEADING_BAR -->
					
					