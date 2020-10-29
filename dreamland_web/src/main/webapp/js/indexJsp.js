/**
 *
 * Description: 帖子点赞或踩
 * @param id 文章id
 * @param cont 赞或者踩的标志，1为赞，-1为踩
 * @return
 * @throws
 * @date 2020/10/29
 */
function upvote_click(id,cont) {
    $.ajax({
        type: 'post',
        url: 'upvote',
        data: {"id":id,"upvote":cont},
        dataType: 'json',
        success: function(data){
            var up = data["data"];
            if(up == "success"){
                //cont为-1代表踩，1代表赞
                if(cont == -1){
                    //踩成功
                    var num = $("#down_"+id).val();
                    //更新隐藏的踩数
                    $("#down_"+id).text(parseInt(num) + cont);
                }else{
                    //更新页面赞的数据
                    var value = parseInt($("#"+id).val()) + cont;
                    $("#"+id).text(value);
                    $("#up_"+id).text(value);
                }
            }else if(up == "done"){
                alert("已点赞！")
            }else if(up == "down"){
                alert("已踩！")
            }else{
                window.location.href = "login.jsp";
            }
        }
    });
}