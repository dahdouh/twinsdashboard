<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--SIDE MENU - ONLOAD -->
<div class="sidebar-dropdown"><a href="#">Dashboard <i class="icon-list-ul"></i></a></div>
<ul id="nav" class="main-nav">
  <div class="nav_logo"> <img src="<c:url value="/images/logo/logo_twins.png"/>"   alt="Twins Outsourcing" style="width:50%; height:100%;" /> </div>
  <!--ADMIN PLUS MENU-->
  <li class="nav_alternative">
    
    <ul class="nav_alternative_controls" tabindex="-1" data-reactid=".1.0.1.0">
      <li class="url-link " data-link="http://localhost/crm/admin/quotationforms/list"><i class="icon-file-text"></i></li>
      <li class="url-link " data-link="http://localhost/crm/admin/alltasks"><i class="icon-list-ul"></i> </li>
      <li class="url-link " data-link="http://localhost/crm/admin/timers/view/all"><i class="icon-time"></i></li>
      <li class="url-link " data-link="http://localhost/crm/admin/groups/list"><i class="icon-sitemap"></i></li>
      <li class="url-link " data-link="http://localhost/crm/admin/settings/general"><i class="icon-wrench"></i></li>
    </ul>
  </li>
  <!--ADMIN PLUS MENU-->
  
    <!--STAFF PLUS MENU-->
  
  <!--STAFF PLUS MENU--
  
  
  <!--DASHBOARD-->
  <li> <a href="http://localhost/crm/admin/home" class="open"> <i class="icon-home"></i> Dashboard<span class="pull-right"></span></a> </li>
  <!--DASHBOARD END-->
  <!--MY PROJECTS-->
  <li> <a href="http://localhost/crm/admin/myprojects" class=""> <i class="icon-folder-open-alt"></i> My Projects
    <label class="label label-info  pull-right"> 0 </label>
    </a> </li>
  <!--MY PROJECTS END-->
  <!--ALL PROJECTS-->
  <li> 
  <!--permissions--> 
 <a href="http://localhost/crm/admin/projects/list" class="">
    
    <i class="icon-folder-open"></i> All Projects
    <label class="label label-success  pull-right"> 0 </label>
    </a> </li>
  <!--ALL PROJECTS END-->
    <!--ALL CLIENTS-->
  <li>
  <!--permissions-->  
  <a href="http://localhost/crm/admin/clients/list" class="">
    
    <i class="icon-user"></i> Clients
    <label class="label label-purple  pull-right"> 0 </label>
    </a> </li>
  <!--ALL CLIENTS END-->
  <!--INVOICES-->
  <li class="has_sub"> <a href="javascript:void(0)" class="">
  <!--permissions--> 
    <i class="icon-list-alt"></i> Invoices<span class="pull-right"><i class="icon-chevron-right" style="font-size:12px"></i></span></a>
    <ul>
      <li><a href="http://localhost/crm/admin/allinvoices/view">Manage Invoices</a></li>
      <li><a href="http://localhost/crm/admin/invoiceitems/view">Manager Invoice Items</a></li>
    </ul>
  </li>
  <!--INVOICES END-->

  <!--TICKETS-->
  <li class="has_sub"> <a href="javascript:void(0)" class="">
    <!--permissions-->   
    <i class="icon-file-text"></i> Support Tickets<span class="pull-right"><i class="icon-chevron-right" style="font-size:12px"></i></span></a>
    <ul>
      <li>
<!--permissions-->         
        <a href="http://localhost/crm/admin/tickets/new"> Create New Ticket</a></li>
      <li><a href="http://localhost/crm/admin/tickets/list/new">New
        <label class="label label-success  pull-right">
        0
        </label>
        </a></li>
      <li><a href="http://localhost/crm/admin/tickets/list/answered"> Answered
        <label class="label label-warning  pull-right">
        0
        </label>
        </a></li>
      <li><a href="http://localhost/crm/admin/tickets/list/client-replied"> Client Replied
        <label class="label label-danger  pull-right">
        0
        </label>
        </a></li>
      <li><a href="http://localhost/crm/admin/tickets/list/open"> Open
        <label class="label label-info  pull-right">
        0
        </label>
        </a></li>
      <li><a href="http://localhost/crm/admin/tickets/list/closed-tickets"> Closed
        <label class="label label-default  pull-right">
        0
        </label>
        </a></li>
    </ul>
  </li>
  <!--TICKETS END-->
    <!--PAYMENTS-->
  <li>
  <!--permissions-->    
    <a href="http://localhost/crm/admin/allpayments/all" class=""> <i class="icon-credit-card"></i> Payments</a> </li>
  <!--PAYMENTS END-->
  <!--QUOTATIONS-->
  <li>
    <!--permissions-->      
    <a href="http://localhost/crm/admin/quotations/list" class=""> <i class="icon-paste"></i> Quotations
    <label class="label label-success  pull-right"> 0 </label>
    </a></li>
  <!--QUOTATIONS-->
   <!--QUOTATION FORM-->
  <li>
  <!--permissions-->    
    <a href="http://localhost/crm/admin/quotationforms/list" class=""> <i class="icon-paste"></i> Quotation Forms
    <label class="label label-success  pull-right"> 1 </label>
    </a></li>
  <!--QUOTATION FORMS-->
  <!--BUGS-->
  <li>
    <!--permissions-->        
   <a href="http://localhost/crm/admin/bugs/list" class=""> <i class="icon-bug"></i> Bug Tracker
    <label class="label label-warning  pull-right"> 0 </label>
    </a></li>
  <!--BUGS-->
  <!--TEAM-->
  <li>
<a href="http://localhost/crm/admin/team" class=""> <i class="icon-group"></i> Team Members</a> </li>
  <!--TEAM-->
</ul>