$(function () {
    $("#queqin").click(function () {
        var data=$("#queqinform").serialize();
        $.ajax({
            type: "post",
            url: "/teacher/queqin",
            data: data,
            dataType: "json", //返回数据类型
            success: function(result){
                //保存失败
                if (result.state==0){
                    alert(result.message);
                } else {
                    //保存成功
                    alert(result.message);
                    $("input[name='xuehao']").val("");//清空输入框
                    $("input[name='date']").val("");//清空输入框
                    $("input[name='remake']").val("");//清空输入框
                }
            }
        });
    });
});