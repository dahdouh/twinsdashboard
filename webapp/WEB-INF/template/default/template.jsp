<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en"><!--HEAD - ONLOAD--><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title><spring:message code="application.title"/></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="author" content="">
<!--Define our base-->
<link rel="stylesheet" href="<c:url value="/css/all-vendors.css"/>" type="text/css" media="screen" title="default" />
<link rel="stylesheet" href="<c:url value="/css/style.css"/>" type="text/css" media="screen" title="default" />
<link rel="stylesheet" href="<c:url value="/css/responsive.css"/>" type="text/css" media="screen" title="default" />
<link rel="stylesheet" href="<c:url value="/css/font-awesome.css"/>" type="text/css" media="screen" title="default" />
<!-- SELECT START -->
<link rel="stylesheet" href="<c:url value="/css/select.css"/>" type="text/css" media="screen" title="default" />
<script src="<c:url value="/js/select.js"/>" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $(".custom-select").each(function(){
            $(this).wrap("<span class='select-wrapper'></span>");
            $(this).after("<span class='holder'></span>");
        });
        $(".custom-select").change(function(){
            var selectedOption = $(this).find(":selected").text();
            $(this).next(".holder").text(selectedOption);
        }).trigger('change');
    })
</script>
<!-- SELECT END -->


<!-- HTML5 Support for IE -->
<!--[if lt IE 9]>
  <script src="js/html5shim.js"></script>
  <![endif]-->
<!-- Favicon -->
<link rel="shortcut icon" href="images/favicon/favicon.ico">
<style>.cke{visibility:hidden;}</style></head>

<!--HEAD - ONLOAD-->
<body>
<!--HEADER SECTION - ONLOAD-->
<!-- REQUIRED - Jquery -->
<script src="<c:url value="/js/jquery_003.js"/>" type="text/javascript"></script>
<!-- REQUIRED - Jquery -->



<!-- FORMBUILDER.JS-->
<!--bns notes: call this just after jquery.js , as it re-include jquery again for dependencies sake
calling it at the end will break things-->

<!-- FORMBUILDER.JS-->

<!-- SELECT2 -load this to avoid delayed change -->
<script src="<c:url value="/js/jquery_005.js"/>" type="text/javascript"></script>

<!-- SELECT2 - Jquery -->
<!--HEADER SECTION - ONLOAD-->
<!--HEADER SECTION - ONLOAD-->

<!--HEADER SECTION - ONLOAD-->
<!--HEADER SECTION - ONLOAD-->

<!--HEADER SECTION - ONLOAD-->
<!-- Main content starts -->
<!--FLOT CHART-->
<script src="<c:url value="/js/jquery.js"/>" type="text/javascript"></script>
<script src="<c:url value="/js/jquery_006.js"/>" type="text/javascript"></script>
<script src="<c:url value="/js/jquery_004.js"/>" type="text/javascript"></script>

<div class="content">
<!-- WI_HEADING_BAR -->
<!-- 			         <div class="form-group" style="padding:12px 0px;"> -->
<!-- 			              <div class="col-lg-12"> <a class="btn btn-default" href="#myModal" data-toggle="modal">Forgotten Password</a> -->
<!-- 			              	 <input class="btn btn-info btn-lg" name="submit" value="Sign In" type="submit"> -->
<!-- 			              </div> -->
<!-- 					    </div> -->
				    
<!-- 				   	  <div class="row"> -->
<!-- 						  <div id="myModal" class="modal fade login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"> -->
<!-- 						    <div class="modal-dialog"> -->
<!-- 						    <form novalidate="novalidate" class="form-horizontal" action="http://localhost/crm/admin/login/reminder" method="post" id="ResetPassword"> -->
<!-- 						      <div class="modal-content"> -->
<!-- 						        <div class="modal-header"> -->
<!-- 						          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button> -->
<!-- 						          <h4 class="modal-title"> -->
<!-- 						            Reset My Password</h4> -->
<!-- 						        </div> -->
<!-- 						        <div class="modal-body"> -->
<!-- 						          Email -->
<!-- 						          <div class="form-group" style="margin-bottom:10px;"> -->
<!-- 						            <label class="control-label col-lg-12" for="inputEmail"> -->
<!-- 						            Email</label> -->
<!-- 						            <div class="col-lg-12"> -->
<!-- 						              <input class="form-control" id="my_emailaddress" placeholder="Your Email Address" name="my_emailaddress" autocomplete="off" type="text"> -->
<!-- 						            </div> -->
<!-- 						          </div> -->
<!-- 						        </div> -->
<!-- 						        <div class="modal-footer"> -->
<!-- 						          <button type="button" class="btn btn-default" data-dismiss="modal" aria-hidden="true"> -->
<!-- 						          Close</button> -->
<!-- 						          <input name="action" value="reminder" type="hidden"> -->
<!-- 						          <input class="btn btn-primary" value="Reset Password" id="" name="submit" type="submit"> -->
						          
<!-- 						        </div> -->
<!-- 						      </div> -->
<!-- 						      </form></div> -->
						    
<!-- 						  </div> -->
<!-- 						</div> -->
					<!--  WI_HEADING_BAR -->
	 <div class="sidebar">
	 		 <tiles:insertAttribute name="menu" />
	 </div>
	 
	   <div class="mainbar">
		    <!----------------------COMMON PAGE HEADING--------------------------------->
		    <div class="page-head">
		    	<tiles:insertAttribute name="header" />
		    </div>
		    <!-- Matter -->
		    <div class="matter">
			        <tiles:insertAttribute name="headingBar" />
			        <!--Body content-->
			        <div class="container">
			        	<tiles:insertAttribute name="body" />
			        </div>
		    
		    </div>
		    <!-- Matter ends -->
		 </div>
		 <!-- Mainbar ends -->
</div> <div class="clearfix"></div>
<!-- Content ends -->

<!-- Footer starts -->
<footer>
  <tiles:insertAttribute name="footer" />
</footer>
				 
<!-- Footer ends -->

<!--WI_IFRAME_MODAL-->
<!--JS_EDIT_TASK_MODAL-->
<script type="text/javascript">
$().ready(function() {
    //USED BY: WI_EDIT_NEW_TASK_MODAL
	//ACTIONS: validates the form and submits it
	//REQUIRES: jquery.validate.js
	$("#editTask").validate({
		rules: {
             tasks_text: "required",
			 tasks_milestones_id: "required",
			 tasks_start_date: "required",
			 tasks_end_date: "required",
			 tasks_assigned_to_id: "required"
		},
		messages: {
			tasks_text: "This field is required",
			tasks_milestones_id: "This field is required",
			tasks_start_date: "This field is required",
			tasks_end_date: "This field is required",
			tasks_assigned_to_id: "This field is required"
		},
		submitHandler: function(form) {
        //alert('form submitted');
		form.submit();
        }
	});
});
</script>
<!--JS_EDIT_TASK_MODAL-->
<!--JS_EDIT_TASK_MODAL-->
<script type="text/javascript">
$(document).ready(function(){
    //USED BY: WI_EDIT_TASK_MODAL
	//ACTIONS: dynamically add data into modal form
	//REQUIRES: jquery.js
	//ACTIONS-2: creates a pull down/select for each specified field (with preselected values)
    //REQUIRES-2: select2.js
		
    //---edit item link clicked-------
    $(".edit-task-modal").click(function(){
    
        //get variables from "edit link" data attributes
        var task_text_edit = $(this).attr("data-task-text");
		var task_start_date_edit = $(this).attr("data-task-start-date");
		var task_end_date_edit = $(this).attr("data-task-end-date");
		var task_id_edit = $(this).attr("data-task-id");
		var task_project_id_edit = $(this).attr("data-task-project-id");
		var task_events_id_edit = $(this).attr("data-task-events-id");
		var task_assigned_to_id_edit = $(this).attr("data-task-assigned-to-id");
		var task_milestone_id_edit = $(this).attr("data-task-milestone-id");
		var task_status_preselected = $(this).attr("data-task-status");

        //set modal input values dynamically
		$('#task_text_edit').val(task_text_edit);
		$('#task_start_date_edit').val(task_start_date_edit);
		$('#task_end_date_edit').val(task_end_date_edit);
		$('#task_id_edit').val(task_id_edit);
		$('#task_project_id_edit').val(task_project_id_edit);
		$('#task_events_id_edit').val(task_events_id_edit);
		$('#task_assigned_to_id_edit').val(task_assigned_to_id_edit);
		$('#task_milestone_id_edit').val(task_milestone_id_edit);

       //pre-select data in pull down lists
       $("#tasks-status-list-edit").select2().select2('val', task_status_preselected); 
  });
    
});
</script>
<!--JS_EDIT_TASK_MODAL-->

<!--------------------COMMON FOOTER JAVASCRIPT---------------------------->
<!-- REQUIRED - ALL VENDORS -->
<script src="<c:url value="/js/all-vendors.js"/>" type="text/javascript"></script>
<!-- REQUIRED - ALL VENDORS -->

<!--REQUIRED js_ckeditor - CKeditor-->
<script src="<c:url value="/js/ckeditor.js"/>" type="text/javascript"></script>


<!--REQUIRED js_ckeditor - CKeditor-->

<!-- CUSTOM - Datepicker (eternicode.github.io) -->
<script>
//USED BY: All date picking forms
$(document).ready(function(){
    $('.pickadate').datepicker({
       format: "yyyy-mm-dd",
       language: "lang",
       autoclose: true,
       todayHighlight: true
    });	
});
</script>
<!-- CUSTOM - Datepicker (eternicode.github.io) -->

<!-- REQUIRED js_noty - Noty Notification -->
<script src="<c:url value="/js/jquery_002.js"/>" type="text/javascript"></script>
<!-- REQUIRED js_noty - Noty Notification -->



<!-- MODAL-BACKDROP START-->
<script type="text/javascript">
	$('.modal').on('shown.bs.modal', function() {
	  $(this).css("z-index", parseInt($('.modal-backdrop').css('z-index')) + 1);
	});
	$('.modal').on('shown.bs.modal', function() {
		  //Make sure the modal and backdrop are siblings (changes the DOM)
		  $(this).before($('.modal-backdrop'));
		  //Make sure the z-index is higher than the backdrop
		  $(this).css("z-index", parseInt($('.modal-backdrop').css('z-index')) + 1);
		});
</script>
<!-- MODAL-BACKDROP END-->



<!--REQUIRED - footable.js -->

<script type="text/javascript">
	$(function () {
		$('.footable').footable();
	});
</script>
<!--REQUIRED - footable.js (included in all-vendors.js)-->


<!-- CUSTOM -->
<script src="<c:url value="/js/custom_002.js"/>" type="text/javascript"></script>

<!-- CUSTOM -->


<!-- CUSTOM GENERAL -->
<script src="<c:url value="/js/custom.js"/>" type="text/javascript"></script>
<!-- CUSTOM GENERAL -->
<!--------------------COMMON FOOTER JAVASCRIPT---------------------------->


</body>
</html>