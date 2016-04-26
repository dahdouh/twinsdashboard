<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<script src="<c:url value="/js/chart.js"/>" type="text/javascript"></script>

<script type="text/javascript">
$(function () {
    $('#container').highcharts({
        chart: {
            type: 'column',
            margin: 75,
            options3d: {
                enabled: true,
                alpha: 10,
                beta: 25,
                depth: 70
            }
        },
        title: {
            text: 'Dashboard 3D'
        },
        subtitle: {
            text: ''
        },
        plotOptions: {
            column: {
                depth: 25
            }
        },
        xAxis: {
            categories:
            [
				'<spring:message code="application.admin.user.dashboardmanager"/>',
				'<spring:message code="application.admin.user.chefprojet"/> ',
				'<spring:message code="application.admin.user.memebreequipe"/>',
				'<spring:message code="application.admin.user.client"/>',
				'<spring:message code="application.header.table.account"/>',
				'<spring:message code="application.admin.permission"/>'
             ]
        },
        yAxis: {
            title: {
                text: null
            }
        },
        series: [{
            name: 'Admin Options',
            data: [
                   <c:out value='${sessionScope["count_dashboardmanager"]}' /> , 
                   <c:out value='${sessionScope["count_chefprojet"]}' />,
                   <c:out value='${sessionScope["count_membre_equipe"]}' />,
                   <c:out value='${sessionScope["count_client"]}' />, 
                   <c:out value='${sessionScope["count_account"]}' /> , 
                   <c:out value='${sessionScope["permission_account"]}' />]
        }]
    });
});
		</script>

<tiles:insertDefinition name="AdminTemplate">
    <tiles:putAttribute name="body">
	
    <!-- Matter -->
    <div class="matter">
      <div class="container"> 
      	<div class="row">
			<div class="col-lg-3 col-sm-6 col-xs-12 url-link" data-link="${pageContext.request.contextPath}/admin/dashboardmanager">
				<div class="box-content dashboard-top-stats display-table no-border">
					<div class="col-xs-5 display-cell no-padding">
						<i class="icon-user  dashboard-top-stats-icon bg-info"></i>
					</div>
					<div class="col-xs-7 display-cell no-padding">
					<div class="dashboard-top-stats-heading"> <spring:message code="application.admin.user.dashboardmanager"/>  </div>
					<div class="dashboard-top-stats-value"> <c:out value='${sessionScope["count_dashboardmanager"]}' /> </div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		 	<div class="col-lg-3 col-sm-6 col-xs-12 url-link" data-link="${pageContext.request.contextPath}/admin/chefprojet">
				<div class="box-content dashboard-top-stats display-table no-border">
					<div class="col-xs-5 display-cell no-padding">
						<i class="icon-user dashboard-top-stats-icon bg-success"></i>
					</div>
					<div class="col-xs-7 display-cell no-padding">
					<div class="dashboard-top-stats-heading"> <spring:message code="application.admin.user.chefprojet"/>   </div>
					<div class="dashboard-top-stats-value"> <c:out value='${sessionScope["count_chefprojet"]}' /> </div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<div class="col-lg-3 col-sm-6 col-xs-12 url-link" data-link="${pageContext.request.contextPath}/admin/teamember">
				<div class="box-content dashboard-top-stats display-table no-border">
					<div class="col-xs-5 display-cell no-padding">
						<i class="icon-user dashboard-top-stats-icon bg-warning"></i>
					</div>
					<div class="col-xs-7 display-cell no-padding">
					<div class="dashboard-top-stats-heading">  <spring:message code="application.admin.user.memebreequipe"/> </div>
					<div class="dashboard-top-stats-value"> <c:out value='${sessionScope["count_membre_equipe"]}' /> </div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<div class="col-lg-3 col-sm-6 col-xs-12 url-link" data-link="${pageContext.request.contextPath}/admin/client">
				<div class="box-content dashboard-top-stats display-table no-border">
					<div class="col-xs-5 display-cell no-padding">
						<i class="icon-user dashboard-top-stats-icon bg-purple"></i>
					</div>
					<div class="col-xs-7 display-cell no-padding">
					<div class="dashboard-top-stats-heading">  <spring:message code="application.admin.user.client"/> </div>
					<div class="dashboard-top-stats-value"> <c:out value='${sessionScope["count_client"]}' /> </div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			
			<div class="col-lg-3 col-sm-6 col-xs-12 url-link" data-link="${pageContext.request.contextPath}/compte/">
				<div class="box-content dashboard-top-stats display-table no-border">
					<div class="col-xs-5 display-cell no-padding">
						<i class="icon-cog dashboard-top-stats-icon bg-blue"></i>
					</div>
					<div class="col-xs-7 display-cell no-padding">
					<div class="dashboard-top-stats-heading"> <spring:message code="application.header.table.account"/>   </div>
					<div class="dashboard-top-stats-value"> <c:out value='${sessionScope["count_account"]}' /> </div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<div class="col-lg-3 col-sm-6 col-xs-12 url-link" data-link="${pageContext.request.contextPath}/permission/">
				<div class="box-content dashboard-top-stats display-table no-border">
					<div class="col-xs-5 display-cell no-padding">
						<i class="icon-group dashboard-top-stats-icon bg-danger"></i>
					</div>
					<div class="col-xs-7 display-cell no-padding">
					<div class="dashboard-top-stats-heading">  <spring:message code="application.admin.permission"/> </div>
					<div class="dashboard-top-stats-value"> <c:out value='${sessionScope["permission_account"]}' /> </div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		 </div>
		 
		 <div class="row">
		 	 <div id="container" style="height: 50%; 
	min-width: 40%px; 
	max-width: 60%;
	margin: 0 auto;">
		 
		     </div>
		     
		     <div id="container" style="height: 400px"></div>
		     
		     
		  </div>
    
      </div>  
    </div>

    <!-- Matter ends -->
 
    </tiles:putAttribute>
</tiles:insertDefinition>

<!-- HIGH CHART START  -->
<script src="<c:url value="/js/highcharts.js"/>" type="text/javascript"></script>
<script src="<c:url value="/js/exporting.js"/>" type="text/javascript"></script>
<script src="<c:url value="/js/highcharts-3d.js"/>" type="text/javascript"></script>
<!-- HIGH CHART END -->
