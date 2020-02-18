$(function () {
    $("#dorm_b").click(function () {
        var dorm_a=document.getElementById("dorm_a");
        var dorm_c=document.getElementById("dorm_c");
        dorm_a.className="dorm hide";
        dorm_c.className="dorm_tianbackgroud show";
    });

    $("#dorm_black").click(function () {
        var dorm_a=document.getElementById("dorm_a");
        var dorm_c=document.getElementById("dorm_c");
        dorm_a.className="dorm show";
        dorm_c.className="dorm_tianbackgroud hide";
        $("input[name='dormId']").val("");
        $("input[name='dormType']").val("");
        $("input[name='dormMonitor']").val("");
        $("input[name='dormMonitorPhone']").val("");
    });

    $("#dorm_btu").click(function () {
        var data=$("#dorm_tian_form").serialize();
        $.ajax({
            type: "post",
            url: "/teacher/addDorm",
            data: data,
            dataType: "json", //返回数据类型
            success: function(result){
                if (0==result.state){
                    alert(result.message);
                } else {
                    alert(result.message);
                }
            }
        })
    });
});