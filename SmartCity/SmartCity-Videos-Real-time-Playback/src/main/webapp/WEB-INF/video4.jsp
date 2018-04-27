<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head> 
<script type="text/javascript" src="js/flowplayer-3.2.8.min.js"></script> 
<title>RTMP Sample Player FlowPlayer</title> 
</head> 
<body>
    <h1>RTMP Sample Player FlowPlayer</h1> 
    <a   
         href="#" 
         style="display:block;width:520px;height:330px"   
         id="player">  
    </a>  
    <script> 
    flowplayer("player", "js/flowplayer-3.2.18.swf",{  
        clip: {  
          url: 'rtmp://node-3:1935/myapp/test1',
          provider: 'rtmp', 
          live: true,  
        },   
        plugins: {   
           rtmp: {   
             url: 'js/flowplayer.rtmp-3.2.8.swf',   
             netConnectionUrl: 'rtmp://node-3:1935/myapp/test1'
           }  
       }  
    }); 
    </script> 
    <p>
        Sample RTMP URL (Live) is "rtmp://node-3:1935/myapp/test1" 
    </p> 
</body>
</html>  