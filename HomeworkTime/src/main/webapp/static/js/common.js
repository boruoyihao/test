$.ajaxSetup({
    beforeSend:function(){
        if($("#J_masking")[0]){
            var $_jm = $("#J_masking");
            var html = $('<div class="masking-inner" id="J_masking_inner"><div class="spinner"><div class="rect1"></div><div class="rect2"></div><div class="rect3"></div><div class="rect4"></div><div class="rect5"></div><span class="txt">加载中...</span></div></div>').css({
                left:$_jm.position().left,
                top:$_jm.position().top-15,
                height:$("body").height(),
                width:$("#J_masking").width()+15,
                'border-radius':'3px'
            });
            $("#J_masking_inner").remove();
            $("body").append(html);
        }
    },
    error:function(){
        alert("出错了");
        $("#J_masking_inner").remove();
    }
});
var Cash = {};
Cash.dateFormat= {
    getDate:function(v){
        if(typeof v == "undefined"){
            return "";
        }
        var date = new Date(Number(v));
        var d = date.getDate();
        var m = date.getMonth() + 1;
        var y = date.getFullYear();
        var h = date.getHours();
        var u = date.getMinutes();
        var s = date.getSeconds();
        return {"y": y,"m":(m<=9 ? '0' + m : m),"d":(d <= 9 ? '0' + d : d),"h":(h<=9 ? '0' + h : h),"u":(u<=9 ? '0' + u : u),"s":(s<=9 ? '0' + s : s)};
    },
    getYM:function(v){
        var date = Cash.dateFormat.getDate(v);
        return (date.y+"").substr(2)+"/"+date.m;
    },
    getMD:function(v){
        var date = Cash.dateFormat.getDate(v);
        return date.m+"/"+date.d;
    },
    getYMD:function(v){
        var date = Cash.dateFormat.getDate(v);
        return date.y+"-"+date.m+"-"+date.d;
    },
    addDate:function(v,n){
        if(typeof v == "undefined"){
            return "";
        }
        if(typeof n == "undefined"){
            n = 0;
        }
        var date = new Date((new Date(v)).getTime()+n*24*60*60*1000);
        var d = date.getDate();
        var m = date.getMonth() + 1;
        var y = date.getFullYear();
        return y+"-"+(m+1<=9 ? "0"+m:m)+"-"+(d <= 9 ? "0" + d : d);
    }
}

Cash.createTable = {
    init:function(options){
        var tempId = 'J_'+(new Date()).getTime();
        $.ajax({
            type: 'get',
            url: options.url,
            data: {startDate:options.startDate,endDate:options.endDate},
            dataType:'html',
            success: function(data){
                $("#J_masking_inner").remove();
                data = eval('('+data+')');
                var html = [];
                var orderId = [];
                html.push('<table class="table table-bordered"><tr>');
                for(var i=0;i<data.meta.length;i++){
                    orderId.push(data.meta[i].id);
                    html.push('<th>'+data.meta[i].name+'</th>');
                }
                html.push('</tr>');
                for(var j=0;j<data.data.length;j++){
                    html.push('<tr>');
                    for(var k=0;k<orderId.length;k++){
                        html.push('<td>'+(data.data[j][orderId[k]]||data.meta[k]["defaultValue"])+'</td>');
                    }
                    html.push('</tr>');
                }
                html.push('</table>');
                html = html.join('');
                $('#'+tempId).remove();
                $('#'+options.id).html(html);
            }
        })
    }
}
Cash.createPie = {
    init:function(options){
        var tempId = 'J_'+(new Date()).getTime();
        $.ajax({
            type: 'get',
            url: options.url,
            data: {startDate:options.startDate,endDate:options.endDate},
            dataType:'html',
            success: function(data){
                data = eval('('+data+')');
                var aryData = [];
                for(var j=0;j<data.data.length;j++){
                    var item = {
                        value:data.data[j][data.meta[1].id],
                        name:data.data[j][data.meta[0].id]
                    }
                    aryData.push(item);
                }
                var myChart = echarts.init(document.getElementById(options.id));
                var option = {
                    tooltip : {
                        trigger : 'item',
                        formatter : "{a} <br/>{b} : {d}%"
                    },
                    toolbox : {
                        show : false
                    },
                    animation:true,
                    series : [ {
                        name : '比例',
                        type : 'pie',
                        radius : '99%',
                        center: ['50%', '50%'],
                        itemStyle : {
                            normal : {
                                label:{
                                    textStyle : {
                                        fontFamily : "微软雅黑"
                                    },
                                    position:'inner',
                                    formatter : "{b}"
                                },
                                labelLine:{
                                    show : false
                                }
                            }
                        },
                        data : aryData
                    } ]
                }
                myChart.setOption(option);
                $('#'+tempId).remove();
            }
        })
    }
}

Cash.createBar = {
    init:function(options){
        var tempId = 'J_'+(new Date()).getTime();
        $.ajax({
            type: 'get',
            url: options.url,
            data: {startDate:options.startDate,endDate:options.endDate},
            dataType:'html',
            success: function(data){
                data = eval('('+data+')');
                var xAxis = [{
                    type:'category',
                    data:[],
                    nameId:data.meta[0].id,
                    axisLabel : {
                        show : true,
                        formatter : function(value) {
                            return sortBankName(value);
                        }
                    }
                }];
                var legend = [];
                var series = [];
                for(var i=1;i<data.meta.length;i++){
                    legend.push(data.meta[i].name);
                    var seriesItem = {
                        name:data.meta[i].name,
                        type:'bar',
                        itemStyle : { normal: {label : {show: false}}},
                        stack: 'total',
                        barWidth: 40,
                        data:[],
                        nameId:data.meta[i].id
                    };
                    series.push(seriesItem);
                }
                for(var j=0;j<data.data.length;j++){
                    xAxis[0].data.push(data.data[j][xAxis[0].nameId]||0);
                    for(var k =0;k<series.length;k++){
                        series[k].data.push(data.data[j][series[k].nameId]||0);
                    }
                }
                var myChart = echarts.init(document.getElementById(options.id));
                var option = {
                    calculable : true,
                    grid: {y: 40, y2:30, x2:0,x:40},
                    tooltip : {
                        trigger: 'axis'
                    },
                    legend: {
                        data:legend
                    },
                    calculable : true,
                    yAxis : [
                        {
                            type : 'value',
                            splitArea : {show : true},
                            axisLabel : {
                                show : true,
                                formatter : function(value) {
                                    return value;
                                }
                            }
                        }
                    ],
                    xAxis : xAxis,
                    series : series
                };
                myChart.setOption(option);
                $('#'+tempId).remove();
            }
        })
    }
}
Cash.createLine = {
    init:function(options){
        var tempId = 'J_'+(new Date()).getTime();
        $.ajax({
            type: 'get',
            url: options.url,
            data: {startDate:options.startDate,endDate:options.endDate},
            dataType:'html',
            success: function(data){
                data = eval('('+data+')');
                var aryX = [];
                var legend = [];
                var series = [];
                for(var i=1;i<data.meta.length;i++){
                    legend.push(data.meta[i].name);
                    var itemSeries = {
                        name : data.meta[i].name,
                        nameId:data.meta[i].id,
                        symbol : 'none',
                        type : 'line',
                        data : []
                    }
                    series.push(itemSeries);
                }
                for(var j=0;j<data.data.length;j++){
                    aryX.push(data.data[j].date);
                    for(var k=0;k<series.length;k++){
                        series[k].data.push(data.data[j][series[k].nameId] || 0);
                    }
                }
                var myChart = echarts.init(document.getElementById(options.id));
                var option = {
                    grid:{
                        x:40,
                        x2:0,
                        y:30
                    },
                    tooltip : {
                        trigger : 'axis',
                        formatter : function(arr) {
                            var html = "日期:" +Cash.dateFormat.getYMD(arr[0][1]) + "<br/>";
                            for ( var i = 0; i < arr.length; i++) {
                                html += arr[i][0] + ":"+ accounting.formatNumber(arr[i][2]/100,2)  + "<br/>";
                            }
                            return html;
                        }
                    },
                    toolbox : {
                        show : true,
                        feature : {
                            mark : true,
                            saveAsImage : true
                        }
                    },
                    polar : {
                        splitLine : {
                            show : false
                        },
                        axisLine : {
                            show : false
                        }
                    },
                    calculable : true,
                    animation : false,
                    legend : {
                        data : legend,
                        padding:0
                    },
                    xAxis : [ {
                        type : 'category',
                        data : aryX,
                        axisLabel : {
                            show : true,
                            formatter : function(value) {
                                return Cash.dateFormat.getMD(value);
                            }
                        }
                    } ],
                    yAxis : [ {
                        type : 'value',
                        name : '金额万元',
                        splitArea : {
                            show : true
                        },
                        axisLabel : {
                            show : true,
                            formatter : function(value) {
                                return accounting.formatNumber(value/1000000);
                            }
                        }
                    } ],
                    series : series
                };
                myChart.setOption(option);
                $('#'+tempId).remove();
            }
        })
    }
}
