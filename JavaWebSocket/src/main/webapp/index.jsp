<%@ page language="java" pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <title>webscoket测试</title>
    <script type="text/javascript" src="<%=path%>/framework/jquery.min.js"></script>
    <style type="text/css">
    .nowPosition{
    	background-color: red;
    }
    .moveArea{
    	color: yellow;
    }
    </style>
</head>
<body>
    Welcome<br/><input id="text" type="text"/>
    <button onclick="send()">发送消息</button>
    <hr/>
    
    
    <input type="button" value="查看当前位置" onclick="seeNowPosition()"/>
    <input type="button" value="查看可移动范围" onclick="seeMoveArea()"/>
    <br>
 	移动至:
 	X:<input id="x" type="text"/>
 	Y:<input id="y" type="text"/>
    <input type="button" value="移动" onclick="move()"/>
    
    
    <hr>
    <button onclick="closeWebSocket()">关闭WebSocket连接</button>
    <hr/>
    <div id="message"></div>
    <table border="1">
    	<%for(int i=-5;i<=5;i++){ %>
    	<tr>
    		<%for(int j=-5;j<=5;j++){ %>
    		<td id="<%=j %>_<%=i %>" onclick="move2('<%=j%>','<%=i%>')" style="cursor: pointer;"><%=j %>,<%=i %></td>
    		<%} %>
    	</tr>
    	<%} %>
    </table>
    <table id="tb" class="altrowstable">
		<th align="center"  colspan="9">实时信息监控</th>
	</table>
</body>

<script type="text/javascript">
	var handle="";//当前执行谁的标志
    var websocket = null;
    //判断当前浏览器是否支持WebSocket
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://localhost:8080/JavaWebSocket/websocket");
    }
    else {
        alert('当前浏览器 Not support websocket')
    }

    //连接发生错误的回调方法
    websocket.onerror = function () {
        setMessageInnerHTML("WebSocket连接发生错误");
    };

    //连接成功建立的回调方法
    websocket.onopen = function () {
        setMessageInnerHTML("WebSocket连接成功");
    }

    //接收到消息的回调方法
    websocket.onmessage = function (event) {
   		var json;
    	//console.log(event);
    	//console.log(handle);
    	if(handle=="seeNowPosition"){
    		$("td").removeClass("nowPosition");
    		json=eval('(' + event.data + ')');
    		//console.log("#"+json.x+"_"+json.y);
    		$("#"+json.x+"_"+json.y).addClass("nowPosition");
    	}else if(handle=="seeMoveArea"){
    		$("td").removeClass("moveArea");
    		json=eval('(' + event.data + ')');
    		for (var i = 0; i < json.length; i++) {
				var posi = json[i];
				//console.log(posi);
	    		$("#"+posi.x+"_"+posi.y).addClass("moveArea");
			}
    	}else if(handle=="move"){
    		$("td").removeClass("nowPosition");
    		json=eval('(' + event.data + ')');
    		$("#"+json.x+"_"+json.y).addClass("nowPosition");
    	}
    	else{
	        setMessageInnerHTML(event.data);
    	}
    	handle="";//这里归零
    }

    //连接关闭的回调方法
    websocket.onclose = function () {
        setMessageInnerHTML("WebSocket连接关闭");
    }

    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function () {
        closeWebSocket();
    }

    //将消息显示在网页上
    function setMessageInnerHTML(innerHTML) {
    	var msg=innerHTML.split(" - ")
		var table=document.getElementById("tb");
		var row;
		row=table.insertRow(1);
		for(var i=0;i<msg.length;i++){
			 var cell = row.insertCell(i);
		 	 cell.appendChild(document.createTextNode(msg[i]));
		}
		if(table.rows.length>50){
			table.deleteRow(table.rows.length-1);
		}
      //  document.getElementById('message').innerHTML += innerHTML + '<br/>';
    }

    //关闭WebSocket连接
    function closeWebSocket() {
        websocket.close();
    }

    //发送消息
    function send() {
        var message = document.getElementById('text').value;
        websocket.send(message);
    }
    function move(){
    	var x=$("#x").val();
    	var y=$("#y").val();
    	websocket.send("/move:"+x+','+y);
    	handle="move";
    }
    function move2(x,y){
    	websocket.send("/move:"+x+','+y);
    	handle="move";
    }
    function seeMoveArea(){
    	websocket.send("/movearea:");
    	handle="seeMoveArea";
    }
    function seeNowPosition(){
    	websocket.send("/nowPosition:");
    	handle="seeNowPosition"; 
    }
</script>
</html>