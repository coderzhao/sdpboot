<!DOCTYPE html>
<!-- saved from url=(0070)http://www.17sucai.com/preview/478923/2016-01-21/login-form/index.html -->
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <!--<meta name="keywords" content="jquery,ui,easy,easyui,web">-->
    <!--<meta name="description" content="easyui help you build your web page easily!">-->
    <!--<link rel="stylesheet" type="text/css" href="http://www.jeasyui.net/Public/js/easyui/themes/default/easyui.css">-->
    <!--<link rel="stylesheet" type="text/css" href="http://www.jeasyui.net/Public/js/easyui/themes/icon.css">-->

    <!--<script type="text/javascript" src="http://www.jeasyui.net/Public/js/easyui/jquery.easyui.min.js"></script>-->

    <script type="text/javascript" src="/static/js/jquery.min.js"></script>
    <script language="javascript" type="text/javascript" src="/static/js/flpublic.js"></script>
    <script language="javascript" type="text/javascript" src="/static/js/md5.js"></script>

    <script type="text/javascript">
        var requesturl = baseurl + "PreApiUser/dologin.do";
    </script>

    <title>用户登录</title>

    <link rel="stylesheet" href="/static/css/normalize.css">

    <style type="text/css">
        .btn { display: inline-block; *display: inline; *zoom: 1; padding: 4px 10px 4px; margin-bottom: 0; font-size: 13px; line-height: 18px; color: #333333; text-align: center;text-shadow: 0 1px 1px rgba(255, 255, 255, 0.75); vertical-align: middle; background-color: #f5f5f5; background-image: -moz-linear-gradient(top, #ffffff, #e6e6e6); background-image: -ms-linear-gradient(top, #ffffff, #e6e6e6); background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#ffffff), to(#e6e6e6)); background-image: -webkit-linear-gradient(top, #ffffff, #e6e6e6); background-image: -o-linear-gradient(top, #ffffff, #e6e6e6); background-image: linear-gradient(top, #ffffff, #e6e6e6); background-repeat: repeat-x; filter: progid:dximagetransform.microsoft.gradient(startColorstr=#ffffff, endColorstr=#e6e6e6, GradientType=0); border-color: #e6e6e6 #e6e6e6 #e6e6e6; border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25); border: 1px solid #e6e6e6; -webkit-border-radius: 4px; -moz-border-radius: 4px; border-radius: 4px; -webkit-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05); -moz-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05); box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05); cursor: pointer; *margin-left: .3em; }
        .btn:hover, .btn:active, .btn.active, .btn.disabled, .btn[disabled] { background-color: #e6e6e6; }
        .btn-large { padding: 9px 14px; font-size: 15px; line-height: normal; -webkit-border-radius: 5px; -moz-border-radius: 5px; border-radius: 5px; }
        .btn:hover { color: #333333; text-decoration: none; background-color: #e6e6e6; background-position: 0 -15px; -webkit-transition: background-position 0.1s linear; -moz-transition: background-position 0.1s linear; -ms-transition: background-position 0.1s linear; -o-transition: background-position 0.1s linear; transition: background-position 0.1s linear; }
        .btn-primary, .btn-primary:hover { text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25); color: #ffffff; }
        .btn-primary.active { color: rgba(255, 255, 255, 0.75); }
        .btn-primary { background-color: #4a77d4; background-image: -moz-linear-gradient(top, #6eb6de, #4a77d4); background-image: -ms-linear-gradient(top, #6eb6de, #4a77d4); background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#6eb6de), to(#4a77d4)); background-image: -webkit-linear-gradient(top, #6eb6de, #4a77d4); background-image: -o-linear-gradient(top, #6eb6de, #4a77d4); background-image: linear-gradient(top, #6eb6de, #4a77d4); background-repeat: repeat-x; filter: progid:dximagetransform.microsoft.gradient(startColorstr=#6eb6de, endColorstr=#4a77d4, GradientType=0);  border: 1px solid #3762bc; text-shadow: 1px 1px 1px rgba(0,0,0,0.4); box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.5); }
        .btn-primary:hover, .btn-primary:active, .btn-primary.active, .btn-primary.disabled, .btn-primary[disabled] { filter: none; background-color: #4a77d4; }
        .btn-block { width: 100%; display:block; }

        * { -webkit-box-sizing:border-box; -moz-box-sizing:border-box; -ms-box-sizing:border-box; -o-box-sizing:border-box; box-sizing:border-box; }

        html { width: 100%; height:100%; overflow:hidden; }

        body {
            width: 100%;
            height:100%;
            font-family: 'Open Sans', sans-serif;
            background: #092756;
            background: -moz-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%),-moz-linear-gradient(top,  rgba(57,173,219,.25) 0%, rgba(42,60,87,.4) 100%), -moz-linear-gradient(-45deg,  #670d10 0%, #092756 100%);
            background: -webkit-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), -webkit-linear-gradient(top,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), -webkit-linear-gradient(-45deg,  #670d10 0%,#092756 100%);
            background: -o-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), -o-linear-gradient(top,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), -o-linear-gradient(-45deg,  #670d10 0%,#092756 100%);
            background: -ms-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), -ms-linear-gradient(top,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), -ms-linear-gradient(-45deg,  #670d10 0%,#092756 100%);
            background: -webkit-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), linear-gradient(to bottom,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), linear-gradient(135deg,  #670d10 0%,#092756 100%);
            filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#3E1D6D', endColorstr='#092756',GradientType=1 );
        }
        .login {
            position: absolute;
            top: 50%;
            left: 50%;
            margin: -150px 0 0 -150px;
            width:300px;
            height:300px;
        }
        .login h1 { color: #fff; text-shadow: 0 0 10px rgba(0,0,0,0.3); letter-spacing:1px; text-align:center; }

        input {
            width: 100%;
            margin-bottom: 10px;
            background: rgba(0,0,0,0.3);
            border: none;
            outline: none;
            padding: 10px;
            font-size: 13px;
            color: #fff;
            text-shadow: 1px 1px 1px rgba(0,0,0,0.3);
            border: 1px solid rgba(0,0,0,0.3);
            border-radius: 4px;
            box-shadow: inset 0 -5px 45px rgba(100,100,100,0.2), 0 1px 1px rgba(255,255,255,0.2);
            -webkit-transition: box-shadow .5s ease;
            -moz-transition: box-shadow .5s ease;
            -o-transition: box-shadow .5s ease;
            -ms-transition: box-shadow .5s ease;
            transition: box-shadow .5s ease;
        }
        input:focus { box-shadow: inset 0 -5px 45px rgba(100,100,100,0.4), 0 1px 1px rgba(255,255,255,0.2); }

    </style>


    <!--<script src="./css/prefixfree.min.js"></script>-->


</head>

<body onkeydown="keyLogin();">

<div class="login">
    <form id='form1' action='' method="post">
        <input type="text" name="username" placeholder="用户名" required="required">
        <input type="password" name="password" placeholder="密码" required="required">
    </form>
    <input type="button" value="登录" class="btn btn-primary btn-block btn-large" onclick="reqlogin()">

    <!--<a href="/fl">登录</a>-->
</div>
<script>
    function keyLogin(){
        if (event.keyCode==13)  //回车键的键值为13
            reqlogin(); //调用登录按钮的登录事件
    }
    function reqlogin(){
        var params = {}; //先取得 datagrid 的查询参数
        var fields =$('#form1').serializeArray(); //自动序列化表单元素为JSON对象
        $.each( fields, function(i, field){
            if(field.name == "password"){
                params[field.name] = hex_md5(field.value);
//                params[field.name] = field.value;
            }else {
                params[field.name] = field.value; //设置查询参数
            }
        });
        $.get(requesturl, params, function (data){
                if(data.code == 0) {
                    document.cookie = "user_role_id="+data.user.roleId;
                    if(data.user.roleId == 3){
                        loginSuccessBaoAn()
                    }else if(data.user.roleId == 2){
                        loginSuccess();
                    }else if(data.user.roleId == 1){
                        loginSuccess();
                    }else{
                        alert("用户身份不正确");
                    }
                }else {
                    alert(data.msg);
                }
            });

    }
//管理员登录成功
    function loginSuccess(){
        var form1 = document.forms[0];//从0开始,即第一个表单开始
//        form1.action = baseurl;
//        form1.submit();
        window.location.href = baseurl+"manage_index";
    }

    //物业用户登陆成功
    function loginSuccessWuye(){
        var form1 = document.forms[0];//从0开始,即第一个表单开始
//        form1.action = baseurl;
//        form1.submit();
        window.location.href = baseurl;
    }

//    保安用户登录成功
    function loginSuccessBaoAn(){
        var form1 = document.forms[0];//从0开始,即第一个表单开始
        var main_url = baseurl + "video_index";
//        form1.action = main_url;
//        form1.actionInfo
//        form1.submit();
        window.location.href= main_url;
    }
</script>


</body></html>