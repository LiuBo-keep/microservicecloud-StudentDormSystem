//第一次加载时
$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "/teacher/dorm",
        dataType: "json", //返回数据类型
        success: function(result){
            formatJsonToSeries(result);//对数据进行处理
        }
    });
});
//点击查询按钮时
$(function () {
    $("#dorm_but").click(function () {
        var data=$("#dorm_form").serialize();
        // alert(data);
        $.ajax({
            type: "post",
            url: "/teacher/dorm",
            data: data,
            dataType: "json", //返回数据类型
            success: function(result){
                formatJsonToSeries(result);
            }
        });
    });
});

//动态表格
function formatJsonToSeries(result){
    // console.log(result.data);
    var jsodata=result.data.items;
    // console.log(jsodata.length);
    var queqintable=document.getElementById("dorm_table");
    // console.log(queqintable);
    var ta="<tr>" +
        "<th>寝室号</th>" +
        "<th>寝室类型</th>" +
        "<th>寝室长</th>" +
        "<th>寝室长电话</th>" +
        "<th>操作</th>" +
        "</tr>";

    for (var i=0;i<jsodata.length;i++){
        ta+="<tr>" +
            "<td>"+jsodata[i].dormId+"</td>"+
            "<td>"+jsodata[i].dormType+"</td>"+
            "<td>"+jsodata[i].dormMonitor+"</td>"+
            "<td>"+jsodata[i].dormMonitorPhone+"</td>"+
            "<td><input id='xueshengguanli_up' type='button' value='修改'>&nbsp;<input id='xueshengguanli_del' type='button' value='删除'></td>"+
            "</tr>"
    }
    queqintable.innerHTML=ta;

    //记录总页数
    var total_count=document.getElementById("total_count");
    // console.log(result.data.total);
    total_count.innerText=result.data.total;

    //分页按钮
    console.log(result.data)
    var pageCount=result.data.pageCount;//总页数
    console.log("总页数"+pageCount);
    var pageCurrent=result.data.pageCurrent;//当前页码
    console.log("当前页码"+pageCurrent);
    if (null==pageCurrent){//如果第一次访问时,设置当前页为1
        pageCurrent=1;
        console.log("如果第一次访问时,设置当前页为"+pageCurrent);
    }
    var page_ul=document.getElementById("page_ul");
    console.log(page_ul);
    var lis="<li id=''><</li>";
    for (var j=1;j<=pageCount;j++){
        lis+="<li id=''>"+j+"</li>";
        if (j==pageCount){
            lis+="<li id=''>></li>"
        }
    }

    page_ul.innerHTML=lis;
}
