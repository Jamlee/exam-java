<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../header.jsp" %>
<%@ include file="../topbar.jsp" %>

<div class="ch-container">
<%@ include file="../menu.jsp" %>
<div id="content" class="col-lg-10 col-sm-10">
 <!-- content starts -->
<div class="row">
    <div class="box col-md-12">
    <div class="box-inner">
    <div class="box-header well" data-original-title="">
        <h2><i class="glyphicon glyphicon-user"></i> 选课 </h2>
    </div>
    <div class="box-content">
    <table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
    <thead>
    <tr role="row">
        <th class="sorting_asc" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Username: activate to sort column descending" style="width: 142px;">课程名称</th>
        <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Date registered: activate to sort column ascending" style="width: 118px;">课时</th>
        <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Status: activate to sort column ascending" style="width: 65px;">学分</th>
        <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Status: activate to sort column ascending" style="width: 65px;">授课教师</th>
        <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Status: activate to sort column ascending" style="width: 65px;">选课</th>
        </tr>
    </thead>

    <tbody role="alert" aria-live="polite" aria-relevant="all">
    <c:forEach items="${courses}" var="value" >
        <tr>
                <td class=" sorting_1">${value.getName()}</td>
                <td class="center ">${value.getClassHour()}</td>
                <td class="center ">
                    <span class="label-default label label-success">${value.getScore()}</span>
                </td>
                <td>${value.getTeacherCourse().getTeacherProfile().getUser().getName()}</td>
                 <td class="center">
                            <a class="btn btn-success" href="#">
                                <i class="glyphicon glyphicon-zoom-in icon-white"></i>
                               选课
                            </a>
                            <a class="btn btn-info" href="#">
                                <i class="glyphicon glyphicon-edit icon-white"></i>
                                退选
                            </a>
                 </td>
            </tr>
    </c:forEach>
    </tbody></table>

    </div>
    </div>
    </div>
    <!--/span-->

    </div>
    <!-- content ends -->

<!-- the element begin from menu -->
</div><!--/#content.col-md-0-->
</div><!--/fluid-row-->

<%@ include file="../footer-bar.jsp" %>

<!-- the element begin from menu -->
</div><!--/.fluid-container-->

<!-- external javascript -->

<script src="/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- library for cookie management -->
<script src="/js/jquery.cookie.js"></script>
<!-- calender plugin -->
<script src='/bower_components/moment/min/moment.min.js'></script>
<script src='/bower_components/fullcalendar/dist/fullcalendar.min.js'></script>


<!-- select or dropdown enhancer -->
<script src="/bower_components/chosen/chosen.jquery.min.js"></script>
<!-- plugin for gallery image view -->
<script src="/bower_components/colorbox/jquery.colorbox-min.js"></script>
<!-- notification plugin -->
<script src="/js/jquery.noty.js"></script>
<!-- library for making tables responsive -->
<script src="/bower_components/responsive-tables/responsive-tables.js"></script>
<!-- tour plugin -->
<script src="/bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
<!-- star rating plugin -->
<script src="/js/jquery.raty.min.js"></script>
<!-- for iOS style toggle switch -->
<script src="/js/jquery.iphone.toggle.js"></script>
<!-- autogrowing textarea plugin -->
<script src="/js/jquery.autogrow-textarea.js"></script>
<!-- multiple file upload plugin -->
<script src="/js/jquery.uploadify-3.1.min.js"></script>
<!-- history.js for cross-browser state change on ajax -->
<script src="/js/jquery.history.js"></script>
<!-- application script for Charisma demo -->
<script src="/js/charisma.js"></script>

<%@ include file="../footer.jsp" %>