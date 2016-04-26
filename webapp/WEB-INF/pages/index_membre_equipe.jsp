<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
 
<tiles:insertDefinition name="TeamMemberTemplate">
    <tiles:putAttribute name="body">
 
        <!--WI_STATS_TOP-->
        <div class="row">

          <!--my tasks-->
          <div class="col-lg-3 col-sm-6 col-xs-12 url-link" data-link="#">
            <div class="box-content dashboard-top-stats display-table no-border">
              <div class="col-xs-5 display-cell no-padding"> <i class="icon-list-ul dashboard-top-stats-icon bg-success"></i> </div>
              <div class="col-xs-7 display-cell no-padding">
                <div class="dashboard-top-stats-heading">My Open Tasks</div>
                <div class="dashboard-top-stats-value">0</div>
              </div>
              <div class="clearfix"></div>
            </div>
          </div>
          <!--my tasks end-->
          <!--TASK COMPLITED-->
          <div class="col-lg-3 col-sm-6 col-xs-12 url-link" data-link="#">
            <div class="box-content dashboard-top-stats display-table no-border">
              <div class="col-xs-5 display-cell no-padding"> <i class="icon-bug dashboard-top-stats-icon bg-purple"></i> </div>
              <div class="col-xs-7 display-cell no-padding">
                <div class="dashboard-top-stats-heading">Pending Bugs</div>
                <div class="dashboard-top-stats-value">0</div>
              </div>
              <div class="clearfix"></div>
            </div>
          </div>
          <!--TASK COMPLETED end-->
          
          <!--TASK IN PROGRESS-->
          <div class="col-lg-3 col-sm-6 col-xs-12 url-link" data-link="#">
            <div class="box-content dashboard-top-stats display-table no-border">
              <div class="col-xs-5 display-cell no-padding"> <i class="icon-bug dashboard-top-stats-icon bg-purple"></i> </div>
              <div class="col-xs-7 display-cell no-padding">
                <div class="dashboard-top-stats-heading"> In Proggress </div>
                <div class="dashboard-top-stats-value">0</div>
              </div>
              <div class="clearfix"></div>
            </div>
          </div>
          <!--TASK IN PROGRESS end-->
          <!--TASK PENDING-->
          <div class="col-lg-3 col-sm-6 col-xs-12 url-link" data-link="#">
            <div class="box-content dashboard-top-stats display-table no-border">
              <div class="col-xs-5 display-cell no-padding"> <i class="icon-bug dashboard-top-stats-icon bg-purple"></i> </div>
              <div class="col-xs-7 display-cell no-padding">
                <div class="dashboard-top-stats-heading">Pending Bugs</div>
                <div class="dashboard-top-stats-value">0</div>
              </div>
              <div class="clearfix"></div>
            </div>
          </div>
          <!--TASK PENDING end-->
          <div class="col-lg-3"></div>
        </div>
 
    </tiles:putAttribute>
</tiles:insertDefinition>