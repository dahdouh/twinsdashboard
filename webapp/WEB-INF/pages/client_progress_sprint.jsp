<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<script src="<c:url value="/js/chart.js"/>" type="text/javascript"></script>

<script type="text/javascript">

$(function () {

    /**
     * Highcharts X-range series plugin
     */
    (function (H) {
        var defaultPlotOptions = H.getOptions().plotOptions,
            columnType = H.seriesTypes.column,
            each = H.each;

        defaultPlotOptions.xrange = H.merge(defaultPlotOptions.column, {});
        H.seriesTypes.xrange = H.extendClass(columnType, {
            type: 'xrange',
            parallelArrays: ['x', 'x2', 'y'],
            animate: H.seriesTypes.line.prototype.animate,

            /**
             * Borrow the column series metrics, but with swapped axes. This gives free access
             * to features like groupPadding, grouping, pointWidth etc.
             */  
            getColumnMetrics: function () {
                var metrics,
                    chart = this.chart,
                    swapAxes = function () {
                        each(chart.series, function (s) {
                            var xAxis = s.xAxis;
                            s.xAxis = s.yAxis;
                            s.yAxis = xAxis;
                        });
                    };

                swapAxes();

                this.yAxis.closestPointRange = 1;
                metrics = columnType.prototype.getColumnMetrics.call(this);

                swapAxes();
                
                return metrics;
            },
            translate: function () {
                columnType.prototype.translate.apply(this, arguments);
                var series = this,
                    xAxis = series.xAxis,
                    yAxis = series.yAxis,
                    metrics = series.columnMetrics;

                H.each(series.points, function (point) {
                    barWidth = xAxis.translate(H.pick(point.x2, point.x + (point.len || 0))) - point.plotX;
                    point.shapeArgs = {
                        x: point.plotX,
                        y: point.plotY + metrics.offset,
                        width: barWidth,
                        height: metrics.width
                    };
                    point.tooltipPos[0] += barWidth / 2;
                    point.tooltipPos[1] -= metrics.width / 2;
                });
            }
        });

        /**
         * Max x2 should be considered in xAxis extremes
         */
        H.wrap(H.Axis.prototype, 'getSeriesExtremes', function (proceed) {
            var axis = this,
                dataMax = Number.MIN_VALUE;

            proceed.call(this);
            if (this.isXAxis) {
                each(this.series, function (series) {
                    each(series.x2Data || [], function (val) {
                        if (val > dataMax) {
                            dataMax = val;
                        }
                    });
                });
                if (dataMax > Number.MIN_VALUE) {
                    axis.dataMax = dataMax;
                }
            }                
        });
    }(Highcharts));
    

    // THE CHART
    $('.chart-content').highcharts({
        chart: {
            type: 'xrange'
        },
        title: {
            text: '<spring:message code="application.header.chart.sprints"/> <c:out value="${projet}" />  '
        },
        xAxis: {
            type: 'datetime',
        },
        yAxis: {
            title: '',
            categories: [
				<c:forEach items="${sprints}" var="s" varStatus="loop">
				'<c:out value="${s.nom}" />'<c:if test="${!loop.last}">,</c:if>
			    </c:forEach>
                ],
            min: 0,
            max: <c:out value="${CountSprints - 1}" />
        },
        series: [{
            name: '<c:out value="${projet}" />',
            // pointPadding: 0,
            // groupPadding: 0,
             borderRadius: 5,
             pointWidth: 10,
            data: [
			<c:forEach items="${sprints}" var="s" varStatus="loop">
             {
                x: Date.UTC(<fmt:formatDate value="${s.date_debut}" pattern="yyyy"/>, <fmt:formatDate value="${s.date_debut}" pattern="MM"/>, <fmt:formatDate value="${s.date_debut}" pattern="dd"/>),
                x2: Date.UTC(<fmt:formatDate value="${s.date_fin}" pattern="yyyy"/>, <fmt:formatDate value="${s.date_fin}" pattern="MM"/>, <fmt:formatDate value="${s.date_fin}" pattern="dd"/>),
                y: ${loop.index}
            }<c:if test="${!loop.last}">,</c:if>
            </c:forEach>
            ]
        }]

    });
});

</script>

<script type="text/javascript">
$(function () {
    $('.chart-content-Pie').highcharts({
        chart: {
            type: 'pie',
            options3d: {
                enabled: true,
                alpha: 45,
                beta: 0
            }
        },
        title: {
            text: '<spring:message code="application.header.chart.sprints"/>'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
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
            name: 'Sprint Progress',
            data: [
		    <c:if test="${CountSprintsCompleted != 0}" >
                {
                    name: 'Sprints Completed',
                    y: <c:out value="${CountSprintsCompleted}" />,
                    color: '#FF45B1',
                },
            </c:if>
            <c:if test="${CountSprintsInprogress !=  0}" >
                {
                    name: 'Sprints In progress',
                    y: <c:out value="${CountSprintsInprogress}" />,
                },
             </c:if>
             <c:if test="${CountSprintsPending !=  0}" >
                {
                    name: 'Sprints Pending',
                    y: <c:out value="${CountSprintsPending}" />,
                    color: '#f0ad4e',
                    sliced: true,
                    selected: true
                }
              </c:if>
            ]
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
            
              <div class="widget-foot">
	                 <!--WI_PAGINATION-->
	                 <ul class="">
	                   <li><h2> <spring:message code="application.header.table.sprint"/> </h2></li>
	                 </ul>
	                 <!--WI_PAGINATION-->
	                <div class="clearfix"></div>
	            </div>
              <c:choose>
			  <c:when test="${not empty sprints}">
	                <table class="footable table table-bordered table-hover default footable-loaded" style="  font-size: 1em;">
	                  <thead>
	                    <tr>
	                      <th class="footable-visible">  <spring:message code="application.sprint.name"/></th>
	                      <th class="footable-visible" data-hide="phone"><spring:message code="application.sprint.beginningdate"/></th>
	                      <th class="footable-visible"><spring:message code="application.sprint.endate"/></th>
	                       <th class="footable-visible"><spring:message code="application.sprint.status"/></th>
	                    </tr>
	                  </thead>
	                  <tbody>
                  			<c:forEach items="${sprints}" var="c" >
		                    <tr>
		                      <td class="footable-visible"> 
		                      		${c.nom}
		                      </td>
		                      <td class="footable-visible">
		                      		<fmt:formatDate value="${c.date_debut}" pattern="yyyy-MM-dd"/>
		                      </td>
		                      <td class="footable-visible">
		                      			<fmt:formatDate value="${c.date_fin}" pattern="yyyy-MM-dd"/>
		                      </td>
		                      <td class="footable-visible">
				                      		<c:if test="${c.statut.libelle == 'In Progress'}" >
				                      			<span id="bns-status-badge" class="label label-purple">${c.statut.libelle}</span>
				                      		</c:if>
				                      		<c:if test="${c.statut.libelle == 'Completed'}" >
				                      			<span id="bns-status-badge" class="label label-danger">${c.statut.libelle}</span>
				                      		</c:if>
				                      		<c:if test="${c.statut.libelle == 'Pending'}" >
				                      			<span id="bns-status-badge" class="label label-warning">${c.statut.libelle}</span>
				                      		</c:if>
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
			                          <h2> Aucun Module n'est trouvé. </h2>
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
        <c:choose>
		  <c:when test="${not empty sprints}">
	        <div class="col-md-12">
	             <div class="widget-content">
	             	  <div class="chart-content" style="float:left; width:60%; margin-right:2%; border-color: rgba(0, 0, 0, 0) #cccccc; border-style: solid; border-width: 1px 1px 1px 1px; "> </div>
					   <div class="chart-content-Pie" style="float:left; width:38%; border-radius: 3px; border-color: rgba(0, 0, 0, 0) #cccccc;  border-style: solid; border-width: 1px 1px 1px 1px ;"> </div>
					   
	              </div>
	        </div>
        </c:when>
       </c:choose> 

          
          
              
          
        </div>    
      </div>
   
    </tiles:putAttribute>
</tiles:insertDefinition>
<!-- HIGH CHART START  -->
<script src="<c:url value="/js/highcharts.js"/>" type="text/javascript"></script>
<script src="<c:url value="/js/exporting.js"/>" type="text/javascript"></script>
<script src="<c:url value="/js/highcharts-3d.js"/>" type="text/javascript"></script>
<!-- HIGH CHART END -->