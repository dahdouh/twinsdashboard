<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<script src="<c:url value="/js/chart.js"/>" type="text/javascript"></script>

<script type="text/javascript">
$(function () {
    $('.widget-content').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: '<spring:message code="application.header.chart.projects"/>'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    }
                }
            }
        },
        series: [{
            type: 'pie',
            name: 'project',
            point: {
                events: {
                    click: function(e) {
                        location.href = e.point.url;
                        e.preventDefault();
                    }
                }
            },
           
            data: [
			  <c:forEach items="${projects}" var="p" varStatus="loop">
                   {
                	   name: '<c:out value="${p.nom}" /> <br/> deadline: <fmt:formatDate value="${p.date_creation}" pattern="yyyy-MM-dd hh:mm:ss"/> ', 
                	   y:  1, 
                	   url: '${pageContext.request.contextPath}/client/progress/${p.id_projet}'
                   }<c:if test="${!loop.last}">,</c:if>
                   
                   </c:forEach>
               ],
               showInLegend: {
                   enabled: true,
               }
           
        }]
    });
});


		</script>
		
<tiles:insertDefinition name="ClientTemplate">
    <tiles:putAttribute name="body">
 	
	<div class="matter">
      <div class="container">
       <div class="col-md-12">
            <div class="widget">
              <div class="widget-content">
              
              </div>
            </div>
          </div>    
      </div>
    </div>
   
    </tiles:putAttribute>
</tiles:insertDefinition>
<!-- HIGH CHART START  -->
<script src="<c:url value="/js/highcharts.js"/>" type="text/javascript"></script>
<script src="<c:url value="/js/exporting.js"/>" type="text/javascript"></script>
<!-- HIGH CHART END -->