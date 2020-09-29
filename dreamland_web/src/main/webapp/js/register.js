/**
 *
 * Description: 注册js
 * @author: zr
 * @date 2020/9/27
 */



/**
 *
 * Description: 检查手机号的正确可用性
 * @param null
 * @return
 * @throws
 * @date 2020/9/27
 */
var v = 0;
var flag2 = false;
function checkPhone() {
    var phone = $("#phone").val();
    //查找替换空白字符，g 为全局匹配，不会在第一个匹配完成后就停止
    phone = phone.replace(/^\s+|\s+$/g,"");
    if(phone == ""){
        $("#phone_span").text("请输入手机号码！");
        $("#phone_ok").text("");
        //根据内容增加高度
        increaseHeight();
        flag2 = false;
        return flag2;
    }
    //电话号码的正则表达式
    var exp = /^1[3|4|5|6|7][0-9]\d{8}$/;
    if(!exp.test(phone)){
        $("#phone_span").text("手机号码非法，请重新输入");
        $("#phone_ok").text("");
        var hgt = $("#register_left").height();
        //根据内容增加高度
        increaseHeight();
        flag2 = false;
        return flag2;
    }else{
        console.log("手机号验证正确···"+'${ctx}')
        //号码正确，发送异步请求验证是否存在
        $.ajax({
            type: 'post',
            url: 'checkPhone',
            data: {"phone":phone},
            sync: false,
            dataType: 'json',
            success: function (data) {
                var val = data['message'];
                if(val == "success"){
                    $("#phone_span").text("");
                    $("#reg_span").text("");
                    $("#phone_ok").text("√").css("color","green");
                    var content = $("#phone_ok").text();
                    if(content == "√"){
                        //根据内容减少高度
                        reduceHeight();
                    }
                    flag2 = true;
                }else{
                    $("#phone_span").text("该手机号已经注册");
                    $("#phone_ok").text("");
                    var hgt = $("#register_left").height();
                    //根据内容增加高度
                    increaseHeight();
                    flag2 = false;
                }
            }
        });
    }
    return flag2;
}

/**
 *
 * Description: 根据内容增加高度
 * @param null
 * @return
 * @throws
 * @date 2020/9/27
 */
function increaseHeight() {
    var hgt = $("#register_left").height();
    if(v == 0){
        $("#register_left").height(hgt + 30);
        $("#register_right").height(hgt + 30);
        v++;
    }


}

/**
 *
 * Description: 根据内容减少高度
 * @param null
 * @return
 * @throws
 * @date 2020/9/27
 */
function reduceHeight() {
    var content = $("#phone_ok").text();
    if(content == "√") {
        var hgt = $("#register_left").height();
        if (v == 0) {
            $("#register_left").height(hgt - 30);
            $("#register_right").height(hgt - 30);
            v = 0;
        }

    }
}

/**
 *
 * Description: 验证码的校验
 * @param null
 * @return
 * @throws
 * @date 2020/9/27
 */
var flag_c = false;
function checkCode() {
    //获取输入的验证码
    var code = $("#code").val();
    code = code.replace("/^\s+|\s$/g","");
    if(code == ""){
        $("#code_span").text("请输入验证码！").css("color","red");
        flag_c = false;
        return flag_c;
    }else {
        $.ajax({
           type: 'post',
           sync: false,
           url: 'checkCode',
           data: {"code":code},
           dataType: 'json',
           success: function (data) {
                var val = data.message;
                if(val == "success"){
                    $("#code_span").text("");
                    $("#code_ok").text("√").css("color","green");
                    $("#reg_span").text("");
                    flag_c = true;
                }else {
                    $("#code_span").text("验证码错误！").css("color","red");
                    flag_c = false;
                }
           }
        });
        return flag_c;
    }
}

/**
 *
 * Description: 检查是否勾选用户协议
 * @param null
 * @return
 * @throws
 * @date 2020/9/27
 */
function checkProtocol() {
    if($("#protocol").prop("checked")){
        $("#reg_span").text("");
        return true;
    }else {
        return false;
    }
}

/**
 *
 * Description: 检查邮箱格式是否正确
 * @param null
 * @return
 * @throws
 * @date 2020/9/27
 */
var sign = false;
function checkEmail(){
    var email = $("#email").val();
    var exp = /^\w+@[a-zA-Z0-9]{2,10}(?:\.[a-z]{2,4}){1,3}$/;

    if(!exp.test(email)){
        $("#email_span").text("邮箱格式有误！请重新输入").css("color","red");
        //根据内容增加高度
        increaseHeight();
        return false;
    }else {
        $.ajax({
            type: 'post',
            url: 'checkEmail',
            sync: false,
            data: {'email':email},
            dataType: 'json',
            success: function (data) {
                var val = data.message;
                if(val == "success"){
                    $("#email_span").text("");
                    $("#email_ok").text("√").css("color","green");
                    $("reg_span").text("");
                    reduceHeight();
                    sign = true;
                }else {
                    $("#email_span").text("该邮箱已被注册，请重写输入").css("color","red");
                    //根据内容增加高度
                    increaseHeight();
                    sign = false;
                }
            }
        });
        return sign;
    }

}

/**
 *
 * Description: 检查密码是否合法
 * @param null
 * @return
 * @throws
 * @date 2020/9/27
 */
function checkPassword(){
    var password = $("#password").val();
    //密码至少包含 数字和英文，长度6-20
    var exp = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;
    if(!exp.test(password)){
        $("#password_span").text("密码至少包含 数字和英文，长度6-20!").css("color","red");
        //根据内容增加高度
        increaseHeight();
        return false;
    }else {
        $("#password_span").text("");
        $("#password_ok").text("√").css("color","green");
        $("reg_span").text("");
        reduceHeight();
        return true;
    }
}

/**
 *
 * Description: 检查昵称不能为空
 * @param null
 * @return
 * @throws
 * @date 2020/9/27
 */
function checkNickName(){
    var nickName = $("#nickName").val();
    if("" == nickName){
        $("#nickName_span").text("昵称不能为空!").css("color","red");
        //根据内容增加高度
        increaseHeight();
        return false;
    }else {
        $("#nickName_span").text("");
        $("#nickName_ok").text("√").css("color","green");
        $("reg_span").text("");
        reduceHeight();
        return true;
    }
}
/**
 *
 * Description: 注册提交校验
 * @param null
 * @return
 * @throws
 * @date 2020/9/27
 */
$(function () {
    $("#to_register").click(function () {
        if(!checkProtocol()){
            $("#protocol_span").text("请勾选\"阅读并接受梦幻家园网用户协议\"!").css("color","red");
            increaseHeight();
            return;
        }else {
            $("#protocol_span").text("");
            reduceHeight();
        }
       if(checkPhone() && checkPassword() && checkEmail()
           && checkNickName() && checkCode() && checkProtocol()){
           console.log("表单验证完成···");
           $("#registerForm").submit();
       }else {
           $("#reg_span").text("请将信息填写完整！").css("color","red");
           increaseHeight();
           return;
       }
    });
})

/**
 *
 * Description: 注册成功后查看邮件，跳转
 * @param message 邮箱信息
 * @return
 * @throws
 * @date 2020/9/29
 */
function lookEmail(message) {
    var arr = message.split(",");
    //获取到邮箱
    var email = arr[0];
    var emailTail = email.split("@")[1];
    //根据邮箱跳转到对应的客户端网站
    if("qq.com" == emailTail){
        //跳转到qq邮箱客户端
        location.href = "https://mail.qq.com";
        return;
    }else if("163.com" == emailTail){
        location.href = "https://mail.163.com";
        return;
    }else if("162.com" == emailTail){
        location.href = "https://mail.162.com";
        return;
    }else if("sina.com" == emailTail){
        location.href = "https://mail.sina.com.cn";
        return;
    }else if ("sohe" == emailTail){
        location.href = "https://mail.sohu.com";
        return;
    }
    alert("非常抱歉，检测到您的邮箱不是主流邮箱，请自行登陆查看！");
}

/**
 *
 * Description: 重新发送邮件
 * @param message 包含邮箱的信息
 * @return
 * @throws
 * @date 2020/9/29
 */
function reSendEmail(message) {
    var arr = message.split(",");
    //获取到邮箱、激活码
    var email = arr[0];
    var code = arr[1];
    var nickName = arr[2];
    $.ajax({
        type: 'post',
        url: 'reSendEmail',
        data: {'email':email,'code':code,'nickName':nickName},
        dataType: 'json',
        success: function (data) {
            var s = data.message;
            if(s == "success"){
                alert("发送成功！");
            }
        }
    });
}

/**
 *
 * Description: 重新注册，即跳转到注册页面
 * @param null
 * @return
 * @throws
 * @date 2020/9/29
 */
function reRegist() {
    location.href = '../register.jsp';
}

/**
 *
 * Description: 更换验证码
 * @param null
 * @return
 * @throws
 * @date 2020/9/29
 */
















