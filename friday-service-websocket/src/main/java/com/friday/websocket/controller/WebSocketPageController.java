package com.friday.websocket.controller;

import com.friday.websocket.websocket.WebSocket;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Simon.z
 * @since: 2020-11-27
 */
@Controller
@RequestMapping("/websocket/*")
public class WebSocketPageController {

    @GetMapping("index")
    public String index(){
        return "index";
    }

    @GetMapping("get")
    public void getMessage(){
        WebSocket socket = new WebSocket();
        socket.sendMessage("你好，WebSocket!");
    }
}