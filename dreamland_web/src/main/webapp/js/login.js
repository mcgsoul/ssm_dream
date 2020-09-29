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
})
