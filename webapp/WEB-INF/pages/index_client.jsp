<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
 
<tiles:insertDefinition name="ClientTemplate">
    <tiles:putAttribute name="body">
 
        <!--WI_STATS_TOP-->
        <div class="row">
          <!--my projects-->
          <div class="col-lg-3 col-sm-6 col-xs-12 url-link" data-link="http://localhost/crm/admin/myprojects">
            <div class="box-content dashboard-top-stats display-table no-border">
              <div class="col-xs-5 display-cell no-padding"> <i class="icon-folder-open dashboard-top-stats-icon bg-info"></i> </div>
              <div class="col-xs-7 display-cell no-padding">
                <div class="dashboard-top-stats-heading">My Projects</div>
                <div class="dashboard-top-stats-value">0</div>
              </div>
              <div class="clearfix"></div>
            </div>
          </div>
          <!--my projects-->
          <!--tickets-->
          <div class="col-lg-3 col-sm-6 col-xs-12 url-link" data-link="http://localhost/crm/admin/tickets/list/open">
            <div class="box-content dashboard-top-stats display-table no-border">
              <div class="col-xs-5 display-cell no-padding"> <i class="icon-file-text dashboard-top-stats-icon bg-warning"></i> </div>
              <div class="col-xs-7 display-cell no-padding">
                <div class="dashboard-top-stats-heading">Support Tickets</div>
                <div class="dashboard-top-stats-value">0</div>
              </div>
              <div class="clearfix"></div>
            </div>
          </div>
          <!--tickets end-->
          <!--bugs-->
          <div class="col-lg-3 col-sm-6 col-xs-12 url-link" data-link="http://localhost/crm/admin/bugs">
            <div class="box-content dashboard-top-stats display-table no-border">
              <div class="col-xs-5 display-cell no-padding"> <i class="icon-bug dashboard-top-stats-icon bg-purple"></i> </div>
              <div class="col-xs-7 display-cell no-padding">
                <div class="dashboard-top-stats-heading">Pending Bugs</div>
                <div class="dashboard-top-stats-value">0</div>
              </div>
              <div class="clearfix"></div>
            </div>
          </div>
          <!--bugs end-->
          <div class="col-lg-3"></div>
        </div>
        
      
 
 
 
    </tiles:putAttribute>
</tiles:insertDefinition>