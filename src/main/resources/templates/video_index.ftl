<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>智慧小区</title>
   <#-- <!--[if lte IE 9]><script>window.location.href='browser.html'</script><![endif]&ndash;&gt;-->
    <link rel="stylesheet" href="/static/css/video_push.css"/>
    <script type="text/javascript" src="/static/js/jquery.min.js"></script>
    <script src="/static/js/sockjs-0.3.4.js"></script>
    <script src="/static/js/stomp.js"></script>
    <script type="text/javascript" src="/static/js/video_index.js"></script>
    <script type="text/javascript" src="/static/grindPlayer/grindPlayer.js"></script>
</head>
<body>

<div class="main">
    <div class="top_img">
        <div id="headtitle" class="top_text">智慧小区</div>
    </div>
    <div class="xian"></div>
    <div class="left_box">
        <div class="title_font">视频预览</div>
        <div class="seatch">
            <div class="left_input">
                <div class="left_font">摄像头列表</div>
                <div class="right_select">
                    <select class="select_box" id="ipc_list" onchange="reConnect()">

                    </select>
                </div>
                <div class="right_input"></div>
            </div>
            <div class="preview_img">
                <div id="player">
                    <embed src=/static/grindPlayer/GrindPlayer.swf type=application/x-shockwave-flash wmode="transparent" quality="high" ;> </embed>
                </div>
                <img id="camera" src="" style="border-radius: 15px;" height="100%" width="100%" />
            </div>
        </div>
    </div>
    <div class="right_information">
        <table id="table_id">
        </table>
    </div>
</div>
</body>

</html>