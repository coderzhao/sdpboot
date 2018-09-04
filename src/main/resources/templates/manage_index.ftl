
<html>
<head>
	<!--<script language="javascript" type="text/javascript" src="../index.js"></script>-->
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="keywords" content="jquery,ui,easy,easyui,web">
	<meta name="description" content="easyui help you build your web page easily!">
	<title>管理平台</title>

	<!--<link rel="stylesheet" type="text/css" href="http://www.jeasyui.net/Public/js/easyui/themes/default/easyui.css">-->
	<!--<link rel="stylesheet" type="text/css" href="http://www.jeasyui.net/Public/js/easyui/themes/icon.css">-->
	<!--<script type="text/javascript" src="http://www.jeasyui.net/Public/js/easyui/jquery.easyui.min.js"></script>-->
	<!---->
	<script language="javascript" type="text/javascript" src="/static/js/flpublic.js"></script>


	<link rel="stylesheet" type="text/css" href="/static/js/jquery/jquery-easyui-1.5.3/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/static/js/jquery/jquery-easyui-1.5.3/themes/icon.css">

	<script type="text/javascript" src="/static/js/jquery/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="/static/js/jquery/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/static/js/jquery/jquery-easyui-1.5.3/locale/easyui-lang-zh_CN.js"></script>
	<script>
		//增加一个tab，如果当前tab同标题的已存在， 则现实老的tab
		function addTab(title, url){
			if ($('#tt').tabs('exists', title)){
				$('#tt').tabs('select', title);
			} else {
				var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
				$('#tt').tabs('add',{
					title:title,
					content:content,
					closable:true
				});
			}
		}

		//增加"增加访客"页，需要传入参数
        function addGuestAddTab(title, url, param){
            if ($('#tt').tabs('exists', title)){
                $('#tt').tabs('select', title);

                var tab=$('#tt').tabs('getSelected');
                if (tab && tab.find('iframe').length > 0) {
                    var curTabWin = tab.find('iframe')[0].contentWindow;
                    curTabWin.initForm(param);
//					curTabWin.$("#userForm").form('load', param);
                }

            } else {
                var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
                $('#tt').tabs('add',{
                    title:title,
                    content:content,
                    closable:true
                });
                setTimeout(function(){
                    var tab=$('#tt').tabs('getSelected');
                    if (tab && tab.find('iframe').length > 0) {
                        var curTabWin = tab.find('iframe')[0].contentWindow;
                        curTabWin.initForm(param);
//					curTabWin.$("#userForm").form('load', param);
                    }
                },250);

            }
        }

        //增加"增加访客"页，需要传入快照页图片
        function addGuestAddTabBySnapshotImage(photo, snapshotId){
            var title = "增加访客";
            var url = "static/html/guest_add.html";
            if ($('#tt').tabs('exists', title)){
                $('#tt').tabs('select', title);

                var tab=$('#tt').tabs('getSelected');
                if (tab && tab.find('iframe').length > 0) {
                    var curTabWin = tab.find('iframe')[0].contentWindow;
                    curTabWin.initBySnapshot(photo, snapshotId);
//					curTabWin.$("#userForm").form('load', param);
                }

            } else {
                var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
                $('#tt').tabs('add',{
                    title:title,
                    content:content,
                    closable:true
                });
                setTimeout(function(){
                    var tab=$('#tt').tabs('getSelected');
                    if (tab && tab.find('iframe').length > 0) {
                        var curTabWin = tab.find('iframe')[0].contentWindow;
                        curTabWin.initBySnapshot(photo, snapshotId);
//					curTabWin.$("#userForm").form('load', param);
                    }
                },100);

            }
        }

//        function getTabWindow() {
//            var curTabWin = null;
//            var curTab = parent.$('#tt').tabs('getSelected');
//            if (curTab && curTab.find('iframe').length > 0) {
//                curTabWin = curTab.find('iframe')[0].contentWindow;
//            }
//            return curTabWin;
//        }

        //关闭当前选中的tab
        function closeCurTab(){
            var tab=$('#tt').tabs('getSelected');//获取当前选中tabs
            var index = $('#tt').tabs('getTabIndex',tab);//获取当前选中tabs的index
            $('#tt').tabs('close',index);//关闭对应index的tabs
        }

        //刷新访客列表,增加或者修改了访客信息后，返回访客列表时调用
        function refreshGuestListTab(){
            var title = '访客列表';
            if ($('#tt').tabs('exists', title)){
                $('#tt').tabs('select', title);

                //刷新访客列表
                var tab=$('#tt').tabs('getSelected');
                if (tab && tab.find('iframe').length > 0) {
                    curTabWin = tab.find('iframe')[0].contentWindow;
                    curTabWin.refreshList();
                }
            }
        }

        //打开访客历史记录tab，参数是访客的id，即guest表中的id
        function addGuestHistoryTab(param){
            var title = "访客进出记录";
            var url = "static/html/guest_history.html"
            if ($('#tt').tabs('exists', title)){
                $('#tt').tabs('select', title);

                var tab=$('#tt').tabs('getSelected');
                if (tab && tab.find('iframe').length > 0) {
                    var curTabWin = tab.find('iframe')[0].contentWindow;
                    curTabWin.initParam(param);
                }

            } else {
                var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
                $('#tt').tabs('add',{
                    title:title,
                    content:content,
                    closable:true
                });
                setTimeout(function(){
                    var tab=$('#tt').tabs('getSelected');
                    if (tab && tab.find('iframe').length > 0) {
                        var curTabWin = tab.find('iframe')[0].contentWindow;
                        curTabWin.initParam(param);
                    }
                },500);

            }
        }
        $(document).ready(function(){
        	$(".panel-title").eq(0).css("background","url(/static/img/icon1.png) no-repeat");
        	$(".panel-title").eq(1).css("background","url(/static/img/icon2.png) no-repeat");
        	$(".panel-title").eq(2).css("background","url(/static/img/icon3.png) no-repeat");
        	$(".panel-title").eq(3).css("background","url(/static/img/icon4.png) no-repeat");
        	$(".panel-title").eq(4).css("background","url(/static/img/icon5.png) no-repeat");
        	$(".panel-title").eq(5).css("background","url(/static/img/icon6.png) no-repeat");
        	$(".panel-title").eq(6).css("background","url(/static/img/icon7.png) no-repeat");
        	$(".panel-title").eq(7).css("background","url(/static/img/icon8.png) no-repeat");
        })
	</script>
	<style type="text/css">
		li{
			list-style-type: none;
		}
		.top_box{
			height: 60px !important;
			background-color: #1a2732;
			overflow-y: hidden;
		}
		.top_title{
			color: white;
		}
		.menudiv{
			 background-color: #2d4557;
			 border: none;
		}
		.panel-header{
			background-color: #2d4557;
			border: none;
			border-bottom: 1px solid #5b7a90;
			color:white;
		}
		.panel-title{
			padding-left: 40px;
			
		}
	    #tt{
	    	border:none; 
	    }
		/*#leftTreeItemUser .panel-title{
			background: url(img/icon1.png) no-repeat !important;
		}*/
	</style>
</head>
  <!-- easyui-layout 可分上下左右中五部分，中间的是必须的，支持href，这样就可以不用iframe了 -->
  <body class="easyui-layout" id="mainBody">
		<!-- 上 -->
		<div class="top_box" region="north" split="false" style="height:40px;text-align: center;" border="false">
			<h1 class="top_title">欢迎光临管理平台</h1>
			<br>
		</div>

		<!-- 左-->
		<div region="west" class="menudiv" split="true" title="系统菜单" style="width:200px;overflow:hidden;">
			<div id="menuDiv" class="easyui-accordion" fit="false" data-options="border:false,animate:true" border="false" animate="true">

				<div  id="leftTreeItemUser" title="用户管理" style="overflow:hidden;">
					<ul>
						<li id="sd_user_list" style="cursor: pointer;"
							onclick="addTab('用户列表','/static/html/user_list.html')" >用户列表</li>
					</ul>
				</div>
				<div id="leftTreeItemDoor" title="门岗管理" style="overflow:hidden;">
					<ul>
						<li id="sd_door_list" style="cursor: pointer;"
							onclick="addTab('门岗列表','/static/html/door_list.html')" >门岗列表</li>
					</ul>
				</div>
				<div id="leftTreeItemIpc"  title="ipc管理" style="overflow:hidden;">
					<ul>
						<li id="sd_ipc_list" style="cursor: pointer;"
							onclick="addTab('ipc列表','/static/html/ipc_list.html')" >ipc列表</li>
					</ul>
				</div>
				<div id="leftTreeItemDoorLock" title="门禁管理" style="overflow:hidden;">
					<ul>
						<li id="sd_door_lock_list" style="cursor: pointer;"
							onclick="addTab('门禁列表','/static/html/door_lock_list.html')" >门禁列表</li>
					</ul>
				</div>
				<div title="访客管理" style="overflow:hidden;">
					<!--<ul>-->
						<!--<li id="sd_guest_owner_list" style="cursor: pointer;"-->
							<!--onclick="addTab('业主列表','/static/html/guest_owner_list.html')" >业主列表</li>-->
					<!--</ul>-->
					<ul>
						<li id="sd_guest_list" style="cursor: pointer;"
							onclick="addTab('访客列表','/static/html/guest_list.html')" >访客列表</li>
					</ul>
					<ul>
						<li id="sd_guest_role" style="cursor: pointer;"
							onclick="addTab('访客类型管理','/static/html/guest_role_list.html')" >访客类型管理</li>
					</ul>
					<ul>
						<li id="sd_guest_record" style="cursor: pointer;"
							onclick="addTab('访客操作记录','/static/html/guest_operation_record_list.html')" >访客操作记录</li>
					</ul>
				</div>
				<div title="实时监控" style="overflow:hidden;">
					<#--<ul>-->
						<#--<li id="sd_snapshot_live" style="cursor: pointer;"-->
							<#--onclick="addTab('实时监控','/static/html/livestream---delete.html')" >实时监控</li>-->
					<#--</ul>-->
					<ul>
						<li id="sd_snapshot_list" style="cursor: pointer;"
							onclick="addTab('快照列表','/static/html/snapshot_list.html')" >快照列表</li>
					</ul>
				</div>
				<div id="leftTreeItemSys" title="系统设置" style="overflow:hidden;">
					<ul>
						<li id="sd_setting" style="cursor: pointer;"
							onclick="addTab('系统设置','/static/html/setting_list.html')" >系统设置</li>
					</ul>

				</div>
			</div>
		</div>

		<!-- 中 -->
		<div id="tt" region="center" class="easyui-tabs" style="width:400px;height:250px;">
			<div title="首页" href="/static/html/blank.html">
			</div>
		</div>

		<div id="MyPopWindow" modal="true" shadow="false" minimizable="false" cache="false" maximizable="false" collapsible="false" resizable="false" style="margin: 0px;padding: 0px;overflow: auto;"></div>

  <script>
      function ddisplay() {
          user_role_id = getCookie("user_role_id");
          if ( user_role_id == "2") {
              //1为系统管理员，2为物业操作员
              $("#menuDiv").accordion('remove','用户管理');
              $("#menuDiv").accordion('remove','门岗管理');
              $("#menuDiv").accordion('remove','ipc管理');
              $("#menuDiv").accordion('remove','门禁管理');
              $("#menuDiv").accordion('remove','系统设置');
          } else {
          }
      }
      setTimeout(function(){
          ddisplay();
      },100);

      //循环得到相应的值
      function getCookie(cname)
      {
          var ss = document.cookie;
          var name = cname + "=";
          var ca = document.cookie.split(';');
          for(var i=0; i<ca.length; i++)
          {
              var c = ca[i].trim();
              if (c.indexOf(name)==0)
                  return c.substring(name.length,c.length);
          }
          return "";
      }
  </script>
  </body>
</html>
