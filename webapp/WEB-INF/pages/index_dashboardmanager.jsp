<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
 <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
 
<%--  <script src="<c:url value="/js/chart.js"/>" type="text/javascript"></script> --%>
 
 
 <script type="text/javascript">
// $(function () {
//     $('.chart-content-Pie').highcharts({
//         chart: {
//             type: 'pie',
//             options3d: {
//                 enabled: true,
//                 alpha: 45,
//                 beta: 0
//             }
//         },
//         title: {
//             text: '<spring:message code="application.header.chart.sprints"/>'
//         },
//         tooltip: {
//             pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
//         },
//         plotOptions: {
//             pie: {
//                 allowPointSelect: true,
//                 cursor: 'pointer',
//                 depth: 35,
//                 dataLabels: {
//                     enabled: true,
//                     format: '{point.name}'
//                 }
//             }
//         },
//         series: [{
//             type: 'pie',
//             name: 'Dashboardmanager ',
//             data: [
// 		    <c:if test="${CountSprintsCompleted != 0}" >
//                 {
//                     name: 'Sprints Completed',
//                     y: <c:out value="${CountSprintsCompleted}" />,
//                     color: '#FF45B1',
//                 },
//             </c:if>
//             <c:if test="${CountSprintsInprogress !=  0}" >
//                 {
//                     name: 'Sprints In progress',
//                     y: <c:out value="${CountSprintsInprogress}" />,
//                 },
//              </c:if>
//              <c:if test="${CountSprintsPending !=  0}" >
//                 {
//                     name: 'Sprints Pending',
//                     y: <c:out value="${CountSprintsPending}" />,
//                     color: '#f0ad4e',
//                     sliced: true,
//                     selected: true
//                 }
//               </c:if>
//             ]
//         }]
//     });
// });

$(function () {
    $('#container').highcharts({
        chart: {
            type: 'pie',
            options3d: {
                enabled: true,
                alpha: 45,
                beta: 0
            }
        },
        title: {
            text: '<spring:message code="application.header.table.dashboardmanager"/>'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.y:.1f}</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                depth: 35,
                dataLabels: {
                    enabled: true,
                    format: '{point.name}'
                }
            }
        },
        series: [{
            type: 'pie',
            name: 'Dashboard manager',
            data: [
                   {
                       name: ' <spring:message code="application.header.dashboardmanager.ficheclient"/> ',
                       y: <c:out value='${sessionScope["count_fiche"]}' />,
                   },
                   {
                       name: ' <spring:message code="application.dashboardmanager.event"/>',
                       y:  <c:out value='${sessionScope["count_event"]}' />,
                   },
                   {
                       name: ' <spring:message code="application.dashboardmanager.project"/> ',
                       y: <c:out value='${sessionScope["count_projet"]}' />,
                   },
                   {
                       name: ' <spring:message code="application.dashboardmanager.team"/>',
                       y: <c:out value='${sessionScope["count_team"]}' />,
                       sliced: true,
                       selected: true
                   }
            ]
        }]
    });
});


</script>
		
<tiles:insertDefinition name="DashboardMangerTemplate">
    <tiles:putAttribute name="body">
 
 		
    <!-- Matter -->
    <div class="matter">
      <div class="container"> 
      	<div class="row">
      	<security:authorize ifAllGranted="ROLE_DASHBOARD_MANAGER">
			<div class="col-lg-3 col-sm-6 col-xs-12 url-link" data-link="${pageContext.request.contextPath}/dashboard/fiche">
				<div class="box-content dashboard-top-stats display-table no-border">
					<div class="col-xs-5 display-cell no-padding">
						<i class="icon-file-text dashboard-top-stats-icon bg-info"></i>  
					</div>
					<div class="col-xs-7 display-cell no-padding">
					<div class="dashboard-top-stats-heading"> <spring:message code="application.header.dashboardmanager.ficheclient"/>  </div>
					<div class="dashboard-top-stats-value"> <c:out value='${sessionScope["count_fiche"]}' /> </div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
	  </security:authorize>
			
		 	<div class="col-lg-3 col-sm-6 col-xs-12 url-link" data-link="${pageContext.request.contextPath}/dashboard/project/">
				<div class="box-content dashboard-top-stats display-table no-border">
					<div class="col-xs-5 display-cell no-padding">
						<i class="icon-folder-open-alt dashboard-top-stats-icon bg-success"></i>
					</div>
					<div class="col-xs-7 display-cell no-padding">
					<div class="dashboard-top-stats-heading"> <spring:message code="application.dashboardmanager.project"/>   </div>
					<div class="dashboard-top-stats-value"> <c:out value='${sessionScope["count_projet"]}' /> </div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<div class="col-lg-3 col-sm-6 col-xs-12 url-link" data-link="${pageContext.request.contextPath}/dashboard/team">
				<div class="box-content dashboard-top-stats display-table no-border">
					<div class="col-xs-5 display-cell no-padding">
						<i class="icon-user dashboard-top-stats-icon bg-warning"></i>
					</div>
					<div class="col-xs-7 display-cell no-padding">
					<div class="dashboard-top-stats-heading">  <spring:message code="application.dashboardmanager.team"/> </div>
					<div class="dashboard-top-stats-value"> <c:out value='${sessionScope["count_team"]}' /> </div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<security:authorize ifAllGranted="ROLE_DASHBOARD_MANAGER">
			<div class="col-lg-3 col-sm-6 col-xs-12 url-link" data-link="${pageContext.request.contextPath}/dashboard/event">
				<div class="box-content dashboard-top-stats display-table no-border">
					<div class="col-xs-5 display-cell no-padding">
						<i class="icon-lightbulb dashboard-top-stats-icon bg-purple"></i>
					</div>
					<div class="col-xs-7 display-cell no-padding">
					<div class="dashboard-top-stats-heading">  <spring:message code="application.dashboardmanager.event"/> </div>
					<div class="dashboard-top-stats-value"> <c:out value='${sessionScope["count_event"]}' /> </div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			</security:authorize>
			
		 </div>
		 
	
		
		  <div class="col-lg-4" style="width:50%; height: 400px">
            <div id="container" style="width:100%; height: 400px"></div>
          </div>
		
<!-- 		<div class="col-lg-4"> -->
            
<!-- 	            <div class="dashboard-pinned-project dashboard-pinned-project-info url-link" data-link="http://localhost/crm/admin/project/2/view"> -->
	              
<!-- 	              <div class="dashboard-pinned-project-header bg-info"> <span class="project-client-name"><i class="icon-user"></i> -->
<!-- 	                Oncf -->
<!-- 	                </span> <span class="project-title"> -->
<!-- 	                Proj12 -->
<!-- 	                </span> <span class="project-progress"> -->
<!-- 	                <div class="progress active"> -->
<!-- 	                  <div role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width:0%" class="progress-bar"><span class="progress-text"></span></div> -->
<!-- 	                </div> -->
<!-- 	                </span> </div> -->
<!-- 	              <ul class="dashboard-pinned-project-footer"> -->
<!-- 	                <li class="border-right"> -->
<!-- 	                  <div class="text-count"> -->
<!-- 	                    0 -->
<!-- 	                    %</div> -->
<!-- 	                  <div class="text-description text-muted">Complete</div> -->
<!-- 	                </li> -->
<!-- 	                <li class="border-right"> -->
<!-- 	                  <div class="text-count"> -->
<!-- 	                    0 -->
<!-- 	                  </div> -->
<!-- 	                  <div class="text-description text-muted">My Tasks</div> -->
<!-- 	                </li> -->
<!-- 	                <li> -->
<!-- 	                  <div class="text-count"> -->
<!-- 	                    -34 -->
<!-- 	                  </div> -->
<!-- 	                  <div class="text-description text-muted">Days Due</div> -->
<!-- 	                </li> -->
<!-- 	              </ul> -->
<!--             </div> -->

<!--             <div class="dashboard-pinned-project dashboard-pinned-project-purple url-link" data-link="http://localhost/crm/admin/project/1/view"> -->
              
<!-- 	              <div class="dashboard-pinned-project-header bg-purple"> <span class="project-client-name"><i class="icon-user"></i> -->
<!-- 	                Oncf -->
<!-- 	                </span> <span class="project-title"> -->
<!-- 	                Projet1 -->
<!-- 	                </span> <span class="project-progress"> -->
<!-- 	                <div class="progress active progress-purple"> -->
<!-- 	                  <div role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width:0%" class="progress-bar"><span class="progress-text"></span></div> -->
<!-- 	                </div> -->
<!-- 	                </span> </div> -->
<!-- 	              <ul class="dashboard-pinned-project-footer"> -->
<!-- 	                <li class="border-right"> -->
<!-- 	                  <div class="text-count"> -->
<!-- 	                    0 -->
<!-- 	                    %</div> -->
<!-- 	                  <div class="text-description text-muted">Complete</div> -->
<!-- 	                </li> -->
<!-- 	                <li class="border-right"> -->
<!-- 	                  <div class="text-count"> -->
<!-- 	                    0 -->
<!-- 	                  </div> -->
<!-- 	                  <div class="text-description text-muted">Tasks</div> -->
<!-- 	                </li> -->
<!-- 	                <li> -->
<!-- 	                  <div class="text-count"> -->
<!-- 	                    -62 -->
<!-- 	                  </div> -->
<!-- 	                  <div class="text-description text-muted">Days Due</div> -->
<!-- 	                </li> -->
<!-- 	              </ul> -->
<!--             </div> -->


<!--           </div> -->
    
    </div>

    <!-- Matter ends -->
  
 
 
    </tiles:putAttribute>
</tiles:insertDefinition>

<!-- <!-- HIGH CHART START  --> -->
<%-- <script src="<c:url value="/js/highcharts.js"/>" type="text/javascript"></script> --%>
<%-- <script src="<c:url value="/js/exporting.js"/>" type="text/javascript"></script> --%>
<%-- <script src="<c:url value="/js/highcharts-3d.js"/>" type="text/javascript"></script> --%>
<!-- HIGH CHART END -->