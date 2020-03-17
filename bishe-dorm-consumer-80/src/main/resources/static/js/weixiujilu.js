$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "/student/chaxun",
        dataType: "json", //返回数据类型
        success: function(result){
            formatJsonToSeries(result);//对数据进行处理
        }
    });
});
//动态表格
function formatJsonToSeries(result){
    console.log(result);
    var jsodata=result.data;
    console.log(jsodata);
    var weixiutable=document.getElementById("weixiutable");
    // console.log(queqintable);
    var ta="<tr>" +
        "<th>维修地址</th>" +
        "<th>维修信息</th>" +
        "<th>维修状态</th>" +
        "<th>维修费用</th>" +
        "<th>联系电话</th>" +
        "<th>报修时间</th>" +
        "</tr>";

    for (var i=0;i<jsodata.length;i++){
        ta+="<tr>" +
            // "<td>"+new Date(jsodata[i].data).format("yyyy-MM-dd")+"</td>"+
            // "<td>"+jsodata[i].data+"</td>"+
            "<td>"+jsodata[i].addre+"</td>"+
            "<td>"+jsodata[i].obj+"</td>"+
            "<td>"+jsodata[i].status+"</td>"+
            "<td>"+jsodata[i].cost+"</td>"+
            "<td>"+jsodata[i].phone+"</td>"+
            "<td>"+new Date(jsodata[i].create_time).format("yyyy-MM-dd")+"</td>"+
            "</tr>"
    }
    weixiutable.innerHTML=ta;

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
/*
/!*修改密码*!/
    function mian() {
        var elem1 = document.getElementById("foot");
        var elem2 = document.getElementById("eyea");
        elem1.className = "bacl show"
        elem2.className = "back show";

    }

function md() {
    var elem1 = document.getElementById("eyea");
    var elem2 = document.getElementById("foot");
    elem1.className = "back hide";
    elem2.className = "bacl hide"
}

/!*上传头像*!/
function avatar() {
    var elem1 = document.getElementById("foot");
    var elem3= document.getElementById("eyeb");
    elem1.className = "bacl show"
    elem3.className="avatar show";
}
function shang() {
    var elem1 = document.getElementById("foot");
    var elem3= document.getElementById("eyeb");
    elem1.className = "bacl hide"
    elem3.className="avatar hide";
}
function pho() {
    var formdata=new FormData();
    formdata.append("photo",$("#changehead").get(0).files[0]);//添加图片信息的参数
    console.log(formdata);
    $.ajax({
        type: "post",
        url: "/student/pic",
        cache:false,
        processData: false, // 告诉jQuery不要去处理发送的数据
        contentType: false, // 告诉jQuery不要去设置Content-Type请求头
        data: formdata,
        dataType: "json", //返回数据类型
        success: function(result){
            console.log(result);
            if(1 == result.state){
                $.ajax({
                    type: "get",
                    url: "/sion",
                    dataType: "json", //返回数据类型
                    success: function(result){
                        console.log(result.message);
                    }
                });
                shang();
                console.log(result);
                //修改成功
                alert(result.message);
                document.getElementById("photoImg1").src=result.data;
                document.getElementById("photoImg2").src=result.data;
            } else{
                console.log(result);
                alert(result.message);
            }
        }
    });
}

function xiu(){
    var elem3=document.getElementById("subBtn");
    console.log(elem3);
    var data = $("#form").serialize();//序列化，将表单数据组装
    console.log(data);
    $.ajax({
        type: "post",
        url: "/student/password",
        data: data,
        dataType: "json", //返回数据类型
        success: function(result){
            console.log(result);
            if(1 == result.state){
                console.log(result);
                //修改成功
                alert(result.message+"将跳转到登录页面");
                window.setTimeout(doUpdate(),10000);
            } else{
                console.log(result);
                $("input[name='oldPassword']").val("");//清空验证码输入框
                $("input[name='newPassword1']").val("");//清空验证码输入框
                $("input[name='newPassword2']").val("");//清空验证码输入框
                //输出错误信息
                var sp=document.getElementById("err");
                sp.innerText=result.message;
            }
        }
    });
}
//密码修改成功到登录页面
function doUpdate() {
    window.location.href="/dorm";
}
*/
