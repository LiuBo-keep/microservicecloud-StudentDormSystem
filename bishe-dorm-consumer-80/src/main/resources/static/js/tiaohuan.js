$(function () {
    $("#quedin").click(function () {
        var data=$("#tiaohuan-main-form").serialize();
        // alert(data);
        var index=data.indexOf("=");
        // alert(index);
        var xuehao=data.substring(index+1);
        // alert(xuehao);
        $.ajax({
            type: "get",
            url: "/teacher/get/"+xuehao,
            data: data,
            dataType: "json", //返回数据类型
            success: function(result){
                //保存失败
                if (result.state==0){
                    alert("操作失败！");
                } else {
                    //保存成功
                    // alert(result.state);
                    console.log(result.message+"==="+result.data.sn);
                    var sn=document.getElementById("tiaosn");
                    var username=document.getElementById("tiaousername");
                    var sex=document.getElementById("tiaosex");
                    var sushe=document.getElementById("tiaosushe");
                    var bed=document.getElementById("tiaobed");
                    sn.innerText=result.data.sn;
                    username.innerText=result.data.username;
                    sex.innerText=result.data.sex;
                    sushe.innerText=result.data.sushe;
                    bed.innerText=result.data.bed;
                    var qiana=document.getElementById("tiaoa");
                    qiana.className="tiaohuan hide";
                    var qianb=document.getElementById("tiaob");
                    qianb.className="tiaohuan show"
                }
            }
        });
    });
});
//调换寝室
$(function () {
    $("#quedingqianchu").click(function () {
        var dat=$("#tiaohuan-nei-form").serialize();
        // alert(dat);
        $.ajax({
            type: "post",
            url: "/teacher/tiao",
            data: dat,
            dataType: "json", //返回数据类型
            success: function(result){
                //保存失败
                if (result.state==0){
                    alert("操作失败！");
                } else {
                    //保存成功
                    alert(result.message);
                    var qiana=document.getElementById("tiaoa");
                    qiana.className="tiaohuan show";
                    var qianb=document.getElementById("tiaob");
                    qianb.className="tiaohuan hide"
                    $("input[name='xuehao']").val("");//清空验证码输入框
                }
            }
        });
    });
});
//返回上页
$(function () {
    $("#back").click(function () {
        var qiana=document.getElementById("tiaoa");
        qiana.className="tiaohuan show";
        var qianb=document.getElementById("tiaob");
        qianb.className="tiaohuan hide"
        $("input[name='xuehao']").val("");//清空验证码输入框
    });
});
