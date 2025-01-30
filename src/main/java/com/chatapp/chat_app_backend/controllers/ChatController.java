package com.chatapp.chat_app_backend.controllers;


import com.chatapp.chat_app_backend.entities.Message;
import com.chatapp.chat_app_backend.entities.Room;
import com.chatapp.chat_app_backend.playload.MessageRequest;
import com.chatapp.chat_app_backend.reopsitories.RoomReopsitory;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Controller
@CrossOrigin("http://localhost:3000")
public class ChatController {


    private RoomReopsitory roomReopsitory;

    public ChatController (RoomReopsitory roomReopsitory){
        this.roomReopsitory = roomReopsitory;
    }

    @MessageMapping("/sendMessage/{roomId}")
    @SendTo("/topic/room/{roomId}")
    public Message sendMessage(
            @DestinationVariable String roomId,
            @RequestBody MessageRequest request
    ) throws RuntimeException
    {
        Room room = roomReopsitory.findRoomById(request.getRoomId());

        Message message = new Message();
        message.setContent(request.getContent());
        message.setSender(request.getSender());
        message.setTimeStamp(LocalDateTime.now());

        if(room!=null){
            room.getMessage().add(message);
            roomReopsitory.save(room);
        }
        else{
            throw new RuntimeException("room not found !! ");
        }
        return message;
    }
}
