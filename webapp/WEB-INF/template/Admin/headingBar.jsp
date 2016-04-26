<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	
	<!--WI_CLIENTS_SEARCH-->
      <div class="navbar navbar-default" role="navigation">
        
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only"> Toggle Navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
          </div>
          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <form class="navbar-form navbar-left form-small" action="http://localhost/crm/admin/clients/search-clients" method="post">
              <div class="form-group">
                <input class="form-control" name="client_id" placeholder="Client ID" type="text">
              </div>
              <div class="form-group">
                <!--select2.js pulldown-->
                <div id="s2id_clients-list" class="select2-container"><a href="javascript:void(0)" class="select2-choice select2-default" tabindex="-1">	 <span id="select2-chosen-1" class="select2-chosen">Company Name</span><abbr class="select2-search-choice-close"></abbr>	  <span class="select2-arrow" role="presentation"><b role="presentation"></b></span></a><label for="s2id_autogen1" class="select2-offscreen"></label><input id="s2id_autogen1" aria-labelledby="select2-chosen-1" class="select2-focusser	select2-offscreen" aria-haspopup="true" role="button" type="text"><div class="select2-drop select2-display-none select2-with-searchbox">	<div class="select2-search">		  <label for="s2id_autogen1_search" class="select2-offscreen"></label>		<input placeholder="" id="s2id_autogen1_search" aria-owns="select2-results-1" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false" class="select2-input" role="combobox" aria-expanded="true" aria-autocomplete="list" type="text">	 </div>	 <ul id="select2-results-1" class="select2-results" role="listbox">	  </ul></div></div><select class="select2-offscreen" title="" tabindex="-1" id="clients-list" data-placeholder="Company Name" name="client_name">
                  <option selected="selected"></option>
                  <option value="Oncf">Oncf</option>
                </select>
              </div>
              <div class="form-group">
                <!--select2.js pulldown-->
                <div id="s2id_users-email-list" class="select2-container"><a href="javascript:void(0)" class="select2-choice select2-default" tabindex="-1">	 <span id="select2-chosen-2" class="select2-chosen">Email</span><abbr class="select2-search-choice-close"></abbr>	  <span class="select2-arrow" role="presentation"><b role="presentation"></b></span></a><label for="s2id_autogen2" class="select2-offscreen"></label><input id="s2id_autogen2" aria-labelledby="select2-chosen-2" class="select2-focusser	select2-offscreen" aria-haspopup="true" role="button" type="text"><div class="select2-drop select2-display-none select2-with-searchbox">	<div class="select2-search">		  <label for="s2id_autogen2_search" class="select2-offscreen"></label>		<input placeholder="" id="s2id_autogen2_search" aria-owns="select2-results-2" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false" class="select2-input" role="combobox" aria-expanded="true" aria-autocomplete="list" type="text">	 </div>	 <ul id="select2-results-2" class="select2-results" role="listbox">	  </ul></div></div><select class="select2-offscreen" title="" tabindex="-1" id="users-email-list" data-placeholder="Email" name="client_email">
                  <option selected="selected"></option>
                  <option value="oncf.ma@gmail.com">oncf.ma@gmail.com</option>
                </select>
              </div>
              <div class="form-group">
                <button type="submit" class="btn btn-primary"> Search Clients</button>
              </div>
              <div class="form-group">
                <button href="" class="btn btn-success" data-toggle="modal">
                <!--permissions--> 
                <i class="icon-plus"></i> Add New Client</button>
              </div>
            </form>
          </div>
          <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
      </div>
      <!--WI_CLIENTS_SEARCH END-->
					    
	<!--WI_ADD_NEW_CLIENT_MODAL-->
	<div class="row">
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
	          </div>
	          <div class="modal-footer">
	            <button type="button" class="btn btn-default" data-dismiss="modal" aria-hidden="true"> Close</button>
	            <input class="btn btn-primary" value="Add New Client" id="" name="submit" type="submit">
	            
	          </div>
	        </div>
	      </form>
	    </div>
	</div>
	<!--WI_ADD_NEW_CLIENT_MODAL-->
					<!--  WI_HEADING_BAR -->