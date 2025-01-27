package com.chatapp.chat_app_backend.controllers;


import com.chatapp.chat_app_backend.entities.Message;
import com.chatapp.chat_app_backend.entities.Room;
import com.chatapp.chat_app_backend.reopsitories.RoomReopsitory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {

    private RoomReopsitory roomrepo;

    public RoomController(RoomReopsitory roomrepo){
        this.roomrepo = roomrepo;
    }


    // Creating room
    @PostMapping
    public ResponseEntity<?> createRoom(@RequestBody String roomId){
        if(roomrepo.findRoomById(roomId)!=null){
            // room exist
            return ResponseEntity.badRequest().body("Room already exists");
        }
        Room room  = new Room();
        room.setRoomId(roomId);
        Room savedRoom = roomrepo.save(room);
        return ResponseEntity.status(HttpStatus.CREATED).body(room);
    }


    // joining room

    @GetMapping("/{roomId}")
    public ResponseEntity<?> joinRoom(
            @PathVariable String roomId
        ){
        Room room  = roomrepo.findRoomById(roomId);
        if(room== null){
            return ResponseEntity.badRequest().body("Room not Found !!");
        }
        return ResponseEntity.ok(room);
    }

    // get messages of Room
    @GetMapping("/{roomId}/messages")
    public  ResponseEntity<List<Message>> getMessages(
            @PathVariable String roomId,
            @RequestParam(value= "page", defaultValue = "0",required = false)int page,
            @RequestParam(value= "size",defaultValue = "20", required = false)int size
    ){
          Room room = roomrepo.findRoomById(roomId);
          if(room == null){
              return ResponseEntity.badRequest().build();
          }

          // pagination
          List <Message> messages = room.getMessage();
          int start = Math.max(0,messages.size() -( page + 1 )* size );
          int end = Math.min(messages.size(), start+size);

          List<Message> paginatedMessages = messages.subList(start,end);
          return ResponseEntity.ok(paginatedMessages);

    }
}
