
function getCamerasList(){
	$.ajax({
		url: window.location.origin+'/v0/camera/',
		method: 'GET',
		success: function (returndata) {
			//console.log(returndata);
			for (var i = 0; i < returndata.length; i++) {
			    $("#camlist").append("<li>"+returndata[i].meta+": "+returndata[i].url+" ("+returndata[i].id+")<button class='camDelete' value='"+returndata[i].id+"'>Delete</button></li>");
			}
		},
		error: function (returndata) {
			console.log(JSON.parse(returndata.responseText));
		}
	});
}

$(document).ready(function(){
	getCamerasList();

	// Buttons handlers
	$('#play').click(function(){
		//console.log($("#streamPath").val());
		var vlc = document.getElementById("player");
		vlc.playlist.items.clear();
		var id = vlc.playlist.add($("#streamPath").val());
		vlc.playlist.playItem(id);
	});

	$('#camlist').on('click', '.camDelete', function() {
    //console.log("Deleting cam with id "+$(this).val());
		$.ajax({
			url: window.location.origin+'/v0/camera/'+$(this).val(),
			method: 'DELETE',
			success: function (returndata) {
				//console.log(returndata);
				$('#camlist').empty();
				getCamerasList();
			},
			error: function (returndata) {
				console.log(JSON.parse(returndata.responseText));
			}
		});
	});


	$('#start_tracking').click(function() {
		if ($("#streamPath").val().indexOf("v4l2://") !=-1) {
			var source = $("#streamPath").val().split("v4l2://")[1];
		} else if ($("#streamPath").val().indexOf("file://") !=-1) {
			var source = $("#streamPath").val().split("file://")[1];
		} else {
			var source = $("#streamPath").val();
		}
		console.log(source);
		$.ajax({
      url: window.location.origin+'/v0/camera/',
      method: 'POST',
      data: { detector: "detect1", meta: "cam1", url: source },
      success: function (returndata) {
        //console.log(returndata);
				$('#camlist').empty();
				getCamerasList();
      },
      error: function (returndata) {
        console.log(JSON.parse(returndata.responseText));
      }
    });
		var ws = new WebSocket("ws://"+window.location.host+"/v0/websocket/");
		ws.onopen = function() {
			ws.send("Hello, world");
		};
		ws.onmessage = function (evt) {
			var timestamp = new Date().toLocaleString();
			var parsedMessage = JSON.parse(evt.data);
			var frame = parsedMessage.frame;
			//var face = parsedMessage.face;
			var bbox = parsedMessage.bbox.split("[[")[1].split("]]")[0].split(",");
			var i = new Image();
			i.onload = function(){
				//console.log("height = "+i.height);
				var scale_factor = i.height/300;
				//console.log("scale_factor = "+scale_factor);
				var bbox_left = bbox[0]/scale_factor;
				var bbox_top = bbox[1]/scale_factor;
				var bbox_width = (bbox[2] - bbox[0])/scale_factor;
				var bbox_height = (bbox[3] - bbox[1])/scale_factor;
				var result = JSON.parse(parsedMessage.identify);
				for (var key in result.results){
					try {
						$("#notifications").prepend("<div class='person'><div class='img video'><img class='frame' src='data:image/jpeg;base64,"+frame+"'><div style='left: "+bbox_left+"px; top: "+bbox_top+"px; width: "+bbox_width+"px; height: "+bbox_height+"px; border:1px yellow solid; position:absolute;'></div></div><div class='img'><img class='thumbnail' src='"+result.results[key][0]['face']['thumbnail']+"'></div><div class='info'><p>"+timestamp+"</p><p>ID: "+result.results[key][0]['face']['id']+"</p><p>Confidence: "+result.results[key][0]['confidence']+"</p><p>Name: "+result.results[key][0]['face']['meta']+"</p><p>Person ID: "+result.results[key][0]['face']['person_id']+"</p></div></div>");
					} catch(e) {
						$("#notifications").prepend("<div class='person'><div class='img video'><img class='frame' src='data:image/jpeg;base64,"+frame+"'><div style='left: "+bbox_left+"px; top: "+bbox_top+"px; width: "+bbox_width+"px; height: "+bbox_height+"px; border:1px yellow solid; position:absolute;'></div></div><p>"+timestamp+"</p><p>Unknown person</p></div>");
						console.log(e);
						console.log(result);
					}
				}
			}
			i.src = "data:image/jpeg;base64,"+frame;
		};
	});
});
