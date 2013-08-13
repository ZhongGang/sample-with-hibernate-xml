<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Examines Statistic Overview</title>
    <script type="text/javascript" src="/js/jquery/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="/js/highcharts/highcharts.js"></script>
    <script type="text/javascript">
        var categories = [];
        var data = [];
        var pieData = [];

        <c:forEach items="${result.items}" var="item">
        categories.push('${item.department}');
        data.push(${item.score});
        pieData.push(['${item.department}', ${item.score}]);
        </c:forEach>

        $(function () {
            $('#columnChartsContainer').highcharts({
                chart: {
                    type: 'column',
                    marginRight: 100,
                    marginBottom: 35
                },
                title: {
                    text: '部门考核成绩柱状图',
                    x: -20
                },
                xAxis: {
                    categories: categories
                },
                yAxis: {
                    min: 0,
                    max: 100,
                    title: {
                        text: '分值'
                    }
                },
                plotOptions: {
                    column: {
                        showInLegend: false,
                        pointPadding: 0.4,
                        borderWidth: 0
                    }
                },
                tooltip: {
                    useHTML: true,
                    headerFormat: '',
                    pointFormat: '{series.name}：<strong>{point.y}</strong>'
                },
                series: [
                    {
                        name: '得分',
                        data: data
                    }
                ]
            });

            $('#pieChartsContainer').highcharts({
                chart: {
                    plotBackgroundColor: null,
                    plotBorderWidth: null,
                    plotShadow: false
                },
                title: {
                    text: '部门考核成绩饼状图'
                },
                tooltip: {
                    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                },
                plotOptions: {
                    pie: {
                        allowPointSelect: true,
                        cursor: 'pointer',
                        dataLabels: {
                            enabled: true,
                            color: '#000000',
                            connectorColor: '#000000',
                            format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                        }
                    }
                },
                series: [
                    {
                        type: 'pie',
                        name: '比例',
                        data: pieData
                    }
                ]
            });
        });
    </script>
</head>
<body>
<h1>Examines Statistic Overview(VisitCount is ${sessionScope.visitCount})</h1>

<div id="columnChartsContainer" style="width:100%; height:300px;"></div>
<div id="pieChartsContainer" style="width:100%; height:300px;"></div>
</body>
</html>