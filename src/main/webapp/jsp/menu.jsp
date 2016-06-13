<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="row">
        <!-- left menu starts -->
        <div class="col-sm-2 col-lg-2">
            <div class="sidebar-nav">
                <div class="nav-canvas">
                    <div class="nav-sm nav nav-stacked">

                    </div>
                    <ul class="nav nav-pills nav-stacked main-menu">
                        <li class="nav-header">功能导航</li>
                        <li><a class="ajax-link" href="/"><i class="glyphicon glyphicon-home"></i><span>首页</span></a>
                        </li>

                        <sec:authorize access="hasRole('ROLE_STUDENT')">
                            <li><a class="ajax-link" href="/student/course"><i class="glyphicon glyphicon-eye-open"></i><span> 我的课程 </span></a>
                            </li>

                            <li><a class="ajax-link" href="/student/choose-course"><i class="glyphicon glyphicon-eye-open"></i><span> 选课管理 </span></a>
                            </li>


                             <li><a class="ajax-link" href="/unfinish.html"><i class="glyphicon glyphicon-eye-open"></i><span> 成绩查询</span></a>
                             </li>

                             <li><a class="ajax-link" href="/unfinish.html"><i class="glyphicon glyphicon-eye-open"></i><span> 个人资料</span></a>
                             </li>
                             <li class="nav-header hidden-md">附加功能</li>

                             <li><a class="ajax-link" href="/unfinish.html"><i class="glyphicon glyphicon-eye-open"></i><span> 寻找学妹</span></a>
                             </li>

                        </sec:authorize>

                        <sec:authorize access="hasRole('ROLE_TEACHER')">

                            <li><a class="ajax-link" href="/teacher/student"><i class="glyphicon glyphicon-eye-open"></i><span> 学生动态 </span></a>
                                                    </li>

                            <li><a class="ajax-link" href="/unfinish.html"><i class="glyphicon glyphicon-eye-open"></i><span> 课程管理 </span></a>
                            </li>

                             <li><a class="ajax-link" href="/teacher/motion-analysis"><i class="glyphicon glyphicon-eye-open"></i><span> 学生情绪分析 </span></a>
                             </li>
                             <li class="nav-header hidden-md">附加功能</li>

                              <li><a class="ajax-link" href="/unfinish.html"><i class="glyphicon glyphicon-eye-open"></i><span> 解决同学单身问题</span></a>
                              </li>
                         </sec:authorize>
                </div>
            </div>
        </div>
        <!--/span-->
        <!-- left menu ends -->

        <noscript>
            <div class="alert alert-block col-md-12">
                <h4 class="alert-heading">Warning!</h4>

                <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a>
                    enabled to use this site.</p>
            </div>
        </noscript>
