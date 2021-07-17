package com.saladereuniao.saladereuniao.controller;
import com.saladereuniao.saladereuniao.model.Room;
import com.saladereuniao.saladereuniao.repository.RoomRepository;
import com.saladereuniao.saladereuniao.exception.ResourceNotFound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

@RestController@CrossOrigin(origins = "http://localhost:4200") //porta padrao do Angular
@RequestMapping("/api/v1")
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/rooms/{id}")
    public List<Room> getAllRooms(){
        return roomRepository.findAll();
            }
            public ResponseEntity<Room>getRoomById(@PathVariable(value = "id")long roomId)
            throws ResourceNotFound{
        Room room=roomRepository.findById(roomId)
                .orElseThrow(()->new ResourceNotFound("Room Not Found"+ roomId));
        return ResponseEntity.ok().body(room);
         }
     @PostMapping("/rooms")
     public Room createRoom(@Valid @RequestBody Room room){
         final Room save = roomRepository.save(room);
         return save;
         }
         @PutMapping("/rooms/{id}")
     public ResponseEntity<Room>updateRoom (@PathVariable(value = "id")Long roomId,
                                            @Valid @RequestBody Room roomDetails)
             throws ResourceNotFound{
        Room room= roomRepository.findById (roomId)
                .orElseThrow(()->new ResourceNotFound("Room not found for this Id:" + roomId));
        room.setName(roomDetails.getName());
        room.setDate(roomDetails.getDate());
        room.setStartHour(roomDetails.getStartHour());
        room.setEndHour(roomDetails.getEndHour());
        final Room updateRoom= roomRepository.save(room);
        return ResponseEntity.ok(updateRoom);
     }
     @DeleteMapping("/rooms/{id}")
    public Map<String,Boolean>deleteRoom(@PathVariable(value = "id")Long roomId)
        throws ResourceNotFound{
        Room room = roomRepository.findById((roomId))
                .orElseThrow(()-> new ResourceNotFound("Room not found for this Id:" + roomId));
        roomRepository.delete(room);
        Map<String,Boolean>response =  new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

