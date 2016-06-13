<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../header.jsp" %>
<%@ include file="../topbar.jsp" %>

<div class="ch-container">
<%@ include file="../menu.jsp" %>
<div id="content" class="col-lg-10 col-sm-10">
 <!-- content starts -->
<div class="row">
    <div class="box col-md-6">
        <div class="box-inner">
            <div class="box-header well" data-original-title="">
                <h2><i class="glyphicon glyphicon-list-alt"></i>学生理解度评估</h2>
            </div>
            <div class="box-content">
                <div id="one" style="height: 300px; padding: 0px; position: relative;"></div>
            </div>
        </div>
    </div>

    <div class="box col-md-6">
        <div class="box-inner">
            <div class="box-header well" data-original-title="">
                <h2><i class="glyphicon glyphicon-list-alt"></i> 教师技能概览 </h2>
            </div>
            <div class="box-content">
                            <div id="two" style="height: 300px; padding: 0px; position: relative;"></div>
            </div>
        </div>
    </div>
</div>
    <!-- content ends -->
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
<script src="/js/echarts.min.js"></script>
<script type="text/javascript">

        var myChart = echarts.init(document.getElementById('one'));
        option = {
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                x: 'left',
                data:['理解并扩展','能够理解','理解一点点','完全不懂','煎熬']
            },
            series: [
                {
                    name:'访问来源',
                    type:'pie',
                    radius: ['50%', '70%'],
                    avoidLabelOverlap: false,
                    label: {
                        normal: {
                            show: false,
                            position: 'center'
                        },
                        emphasis: {
                            show: true,
                            textStyle: {
                                fontSize: '30',
                                fontWeight: 'bold'
                            }
                        }
                    },
                    labelLine: {
                        normal: {
                            show: false
                        }
                    },
                    data:[
                        {value:335, name:'理解并扩展'},
                        {value:310, name:'能够理解'},
                        {value:234, name:'理解一点点'},
                        {value:135, name:'完全不懂'},
                        {value:1548, name:'煎熬'}
                    ]
                }
            ]
        };


        myChart.setOption(option);


        var myChart2 = echarts.init(document.getElementById('two'));
        option = {
            title: {
                text: '技能树',
                subtext: '纯属虚构',
                x:'right',
                y:'bottom'
            },
            tooltip: {
                trigger: 'item',
                backgroundColor : 'rgba(0,0,250,0.2)'
            },
            legend: {
                data: (function (){
                    var list = [];
                    for (var i = 1; i <=28; i++) {
                        list.push(i + 2000);
                    }
                    return list;
                })()
            },
            visualMap: {
                color: ['red', 'yellow']
            },
            radar: {
               indicator : [
                   { text: '颜值', max: 1400},
                   { text: '教学风格', max: 400},
                   { text: '态度', max: 400},
                   { text: '性格', max: 400},
                   { text: '教学进度', max: 400}
                ]
            },
            series : (function (){
                var series = [];
                for (var i = 1; i <= 28; i++) {
                    series.push({
                        name:'（数据纯属虚构）',
                        type: 'radar',
                        symbol: 'none',
                        itemStyle: {
                            normal: {
                                lineStyle: {
                                  width:1
                                }
                            },
                            emphasis : {
                                areaStyle: {color:'rgba(0,250,0,0.3)'}
                            }
                        },
                        data:[
                          {
                            value:[
                                (40 - i) * 10,
                                (38 - i) * 4 + 60,
                                i * 5 + 10,
                                i * 9,
                                i * i /2
                            ],
                            name:i + 2000
                          }
                        ]
                    });
                }
                return series;
            })()
            }
        myChart2.setOption(option);

    </script>
<%@ include file="../footer.jsp" %>