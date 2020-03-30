$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "/teacher/list",
        dataType: "json", //返回数据类型
        success: function(result){
            formatJsonToSeries(result);//对数据进行处理
        }
    });
});

//动态表格
function formatJsonToSeries(result){
    var jsodata=result.data;
    console.log(jsodata);
    var weixiutable=document.getElementById("weixiutable");
    // console.log(queqintable);
    var ta="<tr>" +
        "<th>学号</th>" +
        "<th>寝室</th>" +
        "<th>维修物品</th>" +
        "<th>联系电话</th>" +
        "<th>维修状态</th>" +
        "<th>报修时间</th>" +
        "<th>操作</th>" +
        "</tr>";

    for (var i=0;i<jsodata.items.length;i++){
        var sn=jsodata.items[i].sn;
        var date=new Date(jsodata.items[i].create_time).format("yyyy-MM-dd");
        ta+="<tr>" +
            "<td>"+sn+"</td>"+
            "<td>"+jsodata.items[i].addre+"</td>"+
            "<td>"+jsodata.items[i].obj+"</td>"+
            "<td>"+jsodata.items[i].phone+"</td>"+
            "<td>"+jsodata.items[i].status+"</td>"+
            "<td>"+new Date(jsodata.items[i].create_time).format("yyyy-MM-dd")+"</td>"+
            "<td><input onclick='sushewei(\"+sn+\")' type='button' value='报修' style='width: 80px;position: relative;left: 25px'></td>"+
            "</tr>"
    }
    weixiutable.innerHTML=ta;

    //记录总页数
    var total_count=document.getElementById("total_count");
    //console.log(result.data.total);
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

function page(){

}

//转换时间格式方法
Date.prototype.format = function(fmt) {
    var o = {
        "M+" : this.getMonth()+1,                 //月份
        "d+" : this.getDate(),                    //日
        "h+" : this.getHours(),                   //小时
        "m+" : this.getMinutes(),                 //分
        "s+" : this.getSeconds(),                 //秒
        "q+" : Math.floor((this.getMonth()+3)/3), //季度
        "S"  : this.getMilliseconds()             //毫秒
    };
    if(/(y+)/.test(fmt)) {
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
    }
    for(var k in o) {
        if(new RegExp("("+ k +")").test(fmt)){
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
        }
    }
    return fmt;
}

function sushewei(msg) {
    //alert(msg);
    var sushe=document.getElementById("sushew");
    var susheww=document.getElementById("susheww");
    sushe.className="meweixiu hide";
    susheww.className="susheback ";
}
