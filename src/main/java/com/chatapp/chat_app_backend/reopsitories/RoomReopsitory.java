package com.chatapp.chat_app_backend.reopsitories;

import com.chatapp.chat_app_backend.entities.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomReopsitory extends MongoRepository<Room, String> {
    Room findRoomById(String roomId);
}
