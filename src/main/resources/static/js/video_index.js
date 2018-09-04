$(document).ready(function () {
    //载入声音文件
    $('<audio id="danger"><source src="/static/voice/danger.ogg" type="audio/ogg"> <source src="/static/voice/danger.mp3" type="audio/mpeg"></audio>').appendTo('body');
    $('<audio id="notice"><source src="/static/voice/notice.ogg" type="audio/ogg"> <source src="/static/voice/notice.mp3" type="audio/mpeg"></audio>').appendTo('body');
    $('<audio id="strange"><source src="/static/voice/strange.ogg" type="audio/ogg"> <source src="/static/voice/strange.mp3" type="audio/mpeg"></audio>').appendTo('body');
    /*=======================获取标题=========================*/
    var requestUrl = baseurl + "getHeadTitle";
    $.get(requestUrl, null, function (data) {
        if (data != null) {
            $("#headtitle").html(data);
        }
    });
    /*=======================获取Ipc列表，建立Websocket连接=========================*/
    $.ajax({
        url: baseurl + "getCameraList",
        type: 'POST',
        success: function (data) {
            ipCameraList = data;
            $.each(data, function (index, ipc) {
                //$("#ipc_list").append("<option id=" + ipc.id + " value=" + ipc.id + "," + ipc.cameraId + ">" + ipc.name + "</option>");
                $("#ipc_list").append("<option id=" + ipc.id + " value=" + ipc.address + ">" + ipc.name + "</option>");
            });
//                console.log(data[0].id);
            topic = data[0].address;
            connect(topic);
        }
    })
    loadRevealImgDiv();
    //設置各个div的宽高
    $(window).resize(function () {
        //当窗口大小发生变化时
        loadRevealImgDiv();
    });
    $("#camera").hide();
    $("#player").show();
});
/*================ 声明 ==================*/
var stompClient = null;
// var baseurl = "http://" + window.location.host + "/sdproperty/";
var baseurl = "http://" + window.location.host + "/";
var topic;
var ipCameraList;
//GrindPlayer
var serverIP = "rtmp://" + window.location.hostname + ":1935/livecam";
var flashvars = {
    src: serverIP
    , streamType: "live"
    , scaleMode: "letterbox"
    , bufferTime: 0
};
var params = {
    allowFullScreen: true
    , allowScriptAccess: "always"
    , bgcolor: "#000000"
};
var attrs = {
    name: "player"
};

/*================ 方法 ==================*/
function connect(mac) {
    if (mac.indexOf(":") === -1) {
        player();
        $("#camera").hide();
        $("#player").show();
    } else {
        $("#camera").show();
        $("#player").hide();
    }
    var socket = new SockJS('gee');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        // console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/' + mac, function (data) {
            var jsonData = JSON.parse(data.body);
            if (jsonData['scene'] !== undefined) {
                $("#camera").attr("src", "data:image;base64," + jsonData['scene']);
            } else {
                showResult(jsonData);
            }
        });
    }, function (message) {
        console.log(message);
        setTimeout("connect(topic)", 10000);
    });
}

function send() {
    stompClient.send("/app/index/registry", {}, JSON.stringify({'name': "jklsdafjklasdfjl"}));
    stompClient.send("/app/hello", {}, "hello world!");
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    console.log("Disconnected");
}

function reConnect() {
    topic = $("#ipc_list option:selected").val();
    disconnect();
    connect(topic);

}

function showResult(json) {
    var s = document.getElementById("table_id");
    var x = s.insertRow(0);  //将在第一行添加; firefox为－1， ie似乎为0

    //每行添加列, 共有1列
    var cell1 = x.insertCell(-1);
    var parentDiv = getGuestType(json['securityLevel']);
    var photo = "data:image;base64," + json['photo'];
    vhtml = parentDiv + '<div class="photographs">' +
        '<img src="' + photo + '"/></div>' +
        '<div class="information_text">' +
        checkUndefined(json['roleName'], json['securityLevel']) +
        //                    '<p>姓名：' + checkUndefined(json[i]['name']) + '</p>' +
        //                    '<p>编码：' + checkUndefined(json[i]['guestCode']) + '</p>' +
        //                    '<p>身份：' + checkUndefined(json[i]['roleName']) + '</p>' +
        //                    '<p>拍照时间：' + checkUndefined(json[i]['createTime']) + '</p>' +
        '</div>' +
        '</div>';
    cell1.innerHTML = vhtml;
    var t = s.rows.length
    var maxline = 5;
    if (t > maxline) {  //当table中行数超过最大行数时,删除最早的行
        for (var m = 0; m < t - maxline; m++) {
            s.deleteRow(s.rows.length - 1);
        }
    }
    loadRevealImgDiv();
}

function loadRevealImgDiv() {
    var photographs = $(".photographs").height();
    var information_box = $(".information_box").width();
    var top_img = $(".top_img").height();
    $(".photographs").css('width', photographs);
    $(".information_text").css("width", information_box - photographs - 35);
    $(".top_text").css("line-height", top_img + "px");
}

function getGuestType(guestCode) {
    switch (guestCode) {
        case 1:
//                $("#notice")[0].play();
            return "<div class='information_box'>";
            break;
        case 2:
//                $("#notice")[0].play();
            return "<div class='information_box_blue'>"
            break;
        case 3:
            $("#danger")[0].play();
            return "<div class='information_box_alert_red'>"
            break;
        case 4:
//                $("#notice")[0].play();
            return "<div class='information_box_blue'>"
            break;
        default:
//                $("#strange")[0].play();
            return "<div class='information_box_blue'>"
    }
}

function checkUndefined(role, level) {
    //role不为null时
    if (role) {
        //level不为null时
        if (level) {
            if (level == 1) {
                return '<div style="color: #00ee00;font-size:3vw">验证通过</div>'
            } else if (level == 3) {
                return '<div style="color: red;font-size:3vw">黑名单</div>'
            } else {
                return '<div style="color: #2c38ec;font-size:3vw">暂未识别</div>'
            }
        } else {
            console.log("level is null");
            return '<div style="color: #2c38ec;font-size:3vw">暂未识别</div>'
        }
    } else {
        console.log("role is null")
        return '<div style="color: #2c38ec;font-size:3vw">未知身份</div>'
    }
}

function player() {
    swfobject.embedSWF("/static/grindPlayer/GrindPlayer.swf", "player", "100%", "100%", "10.2", null, flashvars, params, attrs);
}
