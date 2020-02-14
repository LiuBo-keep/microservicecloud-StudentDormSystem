 $(function(){
        $("#vcodeImg").click(function(){
            this.src="Login/get_cpacha?vl=4&w=129&h=38&t="+new Date().getTime();
        });

        //登录
        $("#submitBtn").click(function(){
            var data = $("#form").serialize();//序列化，将表单数据组装
            // alert(data);
            $.ajax({
                type: "post",
                url: "/login",
                data: data,
                dataType: "json", //返回数据类型
                success: function(result){
                    if(1 == result.state){
                        $.ajax({
                            type: "get",
                            url: "/sion",
                            dataType: "json", //返回数据类型
                            success: function(result){
                                console.log(result.message);
                                window.parent.location.href="index";
                            }
                        });
                    } else{
                        alert(result.message);
                        $("#vcodeImg").click();//切换验证码
                        $("input[name='vcode']").val("");//清空验证码输入框
                    }
                }
            });
        });
    });