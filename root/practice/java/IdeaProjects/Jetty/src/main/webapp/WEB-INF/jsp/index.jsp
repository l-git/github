<%--
  Created by IntelliJ IDEA.
  User: Galapagos
  Date: 2016/4/27
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

    <%--<script src="http://code.jquery.com/jquery-1.9.0.js"></script>
    <script src="http://code.jquery.com/jquery-migrate-1.4.0.js"></script>--%>
    <script src="/static/js/jquery/jquery-1.9.0.js"></script>
    <script src="/static/js/jquery/jquery-migrate-1.4.0.js"></script>

    <script src="/static/js/md5.js"></script>


</head>
<body>
<h1>index</h1><br>
<div>
<form>
    <input type="text" name="username" />
    <input type="password" name="password" />
    <input type="button" value="Sign In" id="signIn" />
    <input type="button" value="Sign Up" id="signUp" />
</form>
</div>
<div id="msg"></div>


<script>

    $("#signIn").click(function(){
       signIn();
    });

    $("#signUp").click(function(){
        signUp();
    });

    function signUp(){
        var username=$("input[name=username]").val();
        var password=$("input[name=password]").val();
        password=md5(password);
        $.ajax({
           url:'/sign/signUp',
            type:'post',
            dataType:'json',
            data:{username:username,password:password},
            success:function(data,status,jqXHR){
                alert(data.msg);
                /*if(data.success){
                    var nonce=data.nonce;
                    var response=md5(nonce+password);
                    $.ajax({
                        url:'/sign/signInPost',
                        type:'post',
                        dataType:'json',
                        success:function(data,status,jxXhr){
                            if(data.success){
                                location.href="/welcome/welcome";
                            }else{
                                $("#msg").html(data.msg);
                            }
                        }
                    });
                }else{
                    $("#msg").html(data.msg);
                }*/
            }
        });

    }

    function signIn(){
        var username=$("input[name=username]").val();
        var password=$("input[name=password]").val();
        password=md5(password);
        $.ajax({
            url:'/sign/signIn',
            type:'get',
            dataType:'json',
            async:false,
            success:function(data,status,jqXHQ){
                if(data.success){
                 var nonce=data.nonce;
                    /*var username=data.username;*/
                 var response=md5(nonce+password);
                 $.ajax({
                 url:'/sign/signInPost',
                 type:'post',
                     data:{username:username,nonce:nonce,response:response},
                 dataType:'json',
                 success:function(data,status,jxXhr){
                 if(data.success){
                 location.href="/welcome/welcome";
                 }else{
                 $("#msg").html(data.msg);
                 }
                 }
                 });
                 }else{
                 $("#msg").html(data.msg);
                 }
            }
        });
    }
</script>
</body>
</html>
