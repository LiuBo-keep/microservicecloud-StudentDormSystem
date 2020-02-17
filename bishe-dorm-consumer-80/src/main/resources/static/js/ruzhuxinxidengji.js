/*修改密码*/
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

/*上传头像*/
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
