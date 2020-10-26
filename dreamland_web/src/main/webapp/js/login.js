/**
 *
 * Description: 登陆js
 * @author: zr
 * @date 2020/9/29
 */

/**
 *
 * Description: 检查用户名
 * @param null
 * @return
 * @throws
 * @date 2020/9/29
 */
function checkUserName() {
    var userName = $("#username").val();
    if("" == userName.trim()){
        $("#username_span").text("用户名不能为空").css("color","red");
        return false;
    }else {
        $("#username_span").text("");
        return true;
    }
}

/**
 *
 * Description: 登陆
 * @param null
 * @return
 * @throws
 * @date 2020/9/29
 */
function normal_login() {
    var sign = checkUserName() && checkPassword() && checkCode();
    if(sign){
        $("#normal_form").submit();
    }else {
        alert("请填写完整信息！");
    }
}

/**
 *
 * Description: 检查登陆号码
 * @param null
 * @return
 * @throws
 * @date 2020/9/30
 */
var flag3 = false;
function checkTelePhone(){
    var telePhone = $("#phone").val();
    //查找替换空白字符，g 为全局匹配，不会在第一个匹配完成后就停止
    telePhone = telePhone.replace(/^\s+|\s+$/g,"");
    if(telePhone == ""){
        $("#phone_span").text("请输入手机号码！");
        flag3 = false;
        return flag3;
    }
    //电话号码的正则表达式
    var exp = /^1[3|4|5|6|7][0-9]\d{8}$/;
    if(!exp.test(telePhone)){
        $("#phone_span").text("手机号码非法，请重新输入");
        flag3 = false;
        return flag3;
    }else {
        $.ajax({
            type: 'post',
            url: 'checkPhone',
            data: {"phone":telePhone},
            sync: false,
            dataType: 'json',
            success: function (data) {
                var val = data['message'];
                if(val == "success"){
                    $("#phone_span").text("该手机号没有注册");
                    flag3 = false;
                }else {
                    $("#phone_span").text("");
                    flag3 = true;
                }
            }
        });
        return flag3;
    }
}



/**
 *
 * Description: 密码框的键盘绑定事件
 * @param null
 * @return
 * @throws
 * @date 2020/9/29
 */
$(function () {
    $("#password").bind('keypress',function (event) {
        //点击了回车键，直接提交表单
        if(event.keyCode == 13){
            normal_login();
        }
    });
    $("#verifyCode").bind('keypress',function (event) {
        if(event.keyCode == 13){
            normal_login();
        }
    });
    $("#go").click(function (ev) {

        //获取输入的号码
        var telephone = $("#phone").val();
        if(telephone == ""){
            flag3 = true;
        }
        if(flag3){
            $("#phone_span").text("手机号码非法或者未注册！").css("color","red");
        }else {
            //发送短信给用户手机
            //隐藏发送验证码的按钮框
            $("#go").attr("disabled","disabled");
            $("#phone_span").text("");
            //调用倒计时60秒
            countDown(60);
            //发送请求
            $.ajax({
                type: 'post',
                url: 'sendSms',
                data: {'telephone':telephone},
                success: function (data) {
                    var sign = data.msg;
                    if(sign){
                        console.log("发送短信成功！");
                    }else {
                        alert("发送短信出错，请联系管理员")
                    }
                }
            });
        }
        var oEvent = ev || event;
        //阻止链接默认行为，没有停止冒泡
        oEvent.preventDefault();


    });
    //登陆按钮的绑定事件
    $("#phone_btn").click(function () {
        var logSign = checkTelePhone();
        var logSign_1 = checkVerifyCode();
        alert(logSign+""+logSign_1);
        if(logSign && logSign_1){
            $("phone_span").text("").css("color","red");
            $("#phone_form").submit();
        }else {
            alert("请输入手机号与6位验证码");
        }
    });

});

/**
 *
 * Description: 检查验证码是否为空
 * @param null
 * @return
 * @throws
 * @date 2020/10/13
 */
function checkVerifyCode() {
    var value = $("#verifyCode").val();
    if(value == null || value == ""){
        return false;
    }else {
        return true;
    }
}

/**
 *
 * Description: 获取验证码倒计时
 * @param null
 * @return
 * @throws
 * @date 2020/9/30
 */
function countDown(s) {
    if(s <= 0){
        $("#go").text("重新获取");
        $("#go").removeAttr("disabled");
        return;
    }
    $("#go").text(s + "秒后重新获取");
    //设置一个定时器，每隔一秒回调一次
    setTimeout("countDown("+(s - 1)+")",1000);
}




