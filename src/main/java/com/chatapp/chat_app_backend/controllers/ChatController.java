package com.chatapp.chat_app_backend.controllers;


import com.chatapp.chat_app_backend.entities.Message;
import com.chatapp.chat_app_backend.reopsitories.RoomReopsitory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {


    private RoomReopsitory roomReopsitory;

    public ChatController (RoomReopsitory roomReopsitory){
        this.roomReopsitory = roomReopsitory;
    }

    @MessageMapping("/sendMessage/{roomId}")
    public Message sendMessage(){

    }

}
