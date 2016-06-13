<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="header.jsp" %>
<%@ include file="topbar.jsp" %>

<div class="ch-container">

<%@ include file="menu.jsp" %>
<div id="content" class="col-lg-10 col-sm-10">
            <!-- content starts -->
<div class="row">
    <div class="col-md-3 col-sm-3 col-xs-6">
        <a data-toggle="tooltip" title="6 new members." class="well top-block" href="#">
            <i class="glyphicon glyphicon-user blue"></i>

            <div>在校师生</div>
            <div>507</div>
        </a>
    </div>

    <div class="col-md-3 col-sm-3 col-xs-6">
        <a data-toggle="tooltip" title="4 new pro members." class="well top-block" href="#">
            <i class="glyphicon glyphicon-star green"></i>

            <div>收获点赞</div>
            <div>228</div>
        </a>
    </div>

    <div class="col-md-3 col-sm-3 col-xs-6">
        <a data-toggle="tooltip" title="反馈的总共次数" class="well top-block" href="#">
            <i class="glyphicon glyphicon-edit yellow"></i>

            <div>反馈数量</div>
            <div>13320</div>
        </a>
    </div>

    <div class="col-md-3 col-sm-3 col-xs-6">
        <a data-toggle="tooltip" title="12 new messages." class="well top-block" href="#">
            <i class="glyphicon glyphicon-envelope red"></i>

            <div>我的邮件</div>
            <div>25</div>
        </a>
    </div>
</div>

<div class="row">
    <div class="box col-md-12">
        <div class="box-inner">
            <div class="box-header well">
                <h2><i class="glyphicon glyphicon-info-sign"></i> 系统介绍 </h2>

                <div class="box-icon">
                    <a href="#" class="btn btn-setting btn-round btn-default"><i
                            class="glyphicon glyphicon-cog"></i></a>
                    <a href="#" class="btn btn-minimize btn-round btn-default"><i
                            class="glyphicon glyphicon-chevron-up"></i></a>
                    <a href="#" class="btn btn-close btn-round btn-default"><i
                            class="glyphicon glyphicon-remove"></i></a>
                </div>
            </div>
            <div class="box-content row">
                <div class="col-lg-11 col-md-12">
                    <h1>教师教学反馈系统<br>
                        <small>教师教学反馈平台充分利用互联网络B/S管理系统模式，以网络为平台，为各个学校教务系统的管理提供一个平台，帮助学校管理教务系统，用一个帐号解决学校教务教学管理，并且学校可以自由选择学校需要的教务管理系统，灵活地定制符合学校自己实际情况的教务系统。</small>
                    </h1>

                </div>
            </div>
        </div>
    </div>
</div>


    <!-- content ends -->
    </div><!--/#content.col-md-0-->
</div><!--/fluid-row-->


    <%@ include file="footer-bar.jsp" %>

</div><!--/.fluid-container-->

<!-- external javascript -->

<script src="/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- library for cookie management -->
<script src="/js/jquery.cookie.js"></script>
<!-- calender plugin -->
<script src='/bower_components/moment/min/moment.min.js'></script>
<script src='/bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
<!-- data table plugin -->
<script src='/js/jquery.dataTables.min.js'></script>

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

<%@ include file="footer.jsp" %>