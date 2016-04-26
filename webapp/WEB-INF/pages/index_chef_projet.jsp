<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
 
<tiles:insertDefinition name="ProjectChiefTemplate">
    <tiles:putAttribute name="body">
 
 <div class="row">
  <div id="addNewClientModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <form novalidate="novalidate" class="form-horizontal" action="http://localhost/crm/admin/clients/add" method="post" id="addNewClient">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
            <!--full screen icon - custom.js-->
            <button type="button" class="full-screen-modal close" aria-hidden="true"><i class="icon-fullscreen"></i></button>
            <!--full screen icon - custom.js-->
            <h4 class="modal-title"> Add New Client</h4>
          </div>
          <div class="modal-body">
            <div class="col-lg-12 heading-modal"> Company Details</div>
            <div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> Company Name</label>
              <div class="col-lg-12">
                <input class="form-control" id="clients_company_name" name="clients_company_name" autocomplete="off" type="text">
              </div>
            </div>
            <div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> Address</label>
              <div class="col-lg-12">
                <input class="form-control" id="clients_address" name="clients_address" autocomplete="off" type="text">
              </div>
            </div>
            <div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> City </label>
              <div class="col-lg-12">
                <input class="form-control" id="clients_city" name="clients_city" autocomplete="off" type="text">
              </div>
            </div>
            <div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> State</label>
              <div class="col-lg-12">
                <input class="form-control" id="clients_state" name="clients_state" autocomplete="off" type="text">
              </div>
            </div>
            <div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> Zip/Post Code </label>
              <div class="col-lg-12">
                <input class="form-control" id="clients_zipcode" name="clients_zipcode" autocomplete="off" type="text">
              </div>
            </div>
            <div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> Country </label>
              <div class="col-lg-12">
                <input class="form-control" id="clients_country" name="clients_country" autocomplete="off" type="text">
              </div>
            </div>
            <div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> Website</label>
              <div class="col-lg-12">
                <input class="form-control" id="clients_website" name="clients_website" autocomplete="off" type="text">
              </div>
            </div>
            <div class="col-lg-12 heading-modal"> Main Contact</div>
            <div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> Full Name</label>
              <div class="col-lg-12">
                <input class="form-control" id="client_users_full_name" name="client_users_full_name" autocomplete="off" type="text">
              </div>
            </div>
            <div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> Job Title</label>
              <div class="col-lg-12">
                <input class="form-control" id="client_users_job_position_title" name="client_users_job_position_title" autocomplete="off" type="text">
              </div>
            </div>
            <div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> Telephone</label>
              <div class="col-lg-12">
                <input class="form-control" id="client_users_telephone" name="client_users_telephone" autocomplete="off" type="text">
              </div>
            </div>
            <div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> Email</label>
              <div class="col-lg-12">
                <input class="form-control" id="client_users_email" name="client_users_email" autocomplete="off" type="text">
              </div>
            </div>
            <div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> Password</label>
              <div class="col-lg-12">
                <input class="form-control" id="client_users_password" name="client_users_password" autocomplete="off" type="password">
              </div>
            </div>
            <div class="form-group" style="margin-bottom:10px;">
              <label class="control-label col-lg-12" style="width:150px;"> Password</label>
              <div class="col-lg-12">
                <input class="form-control" id="confirm_password" name="confirm_password" autocomplete="off" type="password">
              </div>
            </div>
            
            <!--WI_CLIENTS_OPTIONALFIELD10-->s
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal" aria-hidden="true"> Close</button>
            <input class="btn btn-primary" value="Add New Client" id="" name="submit" type="submit">
            
          </div>
        </div>
      </form>
    </div>
  </div>
</div>
 
 
 
    </tiles:putAttribute>
</tiles:insertDefinition>