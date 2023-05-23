package site.leui.chat_example.chat.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import site.leui.chat_example.chat.dto.ChatRoom;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Repository
public class ChatRepository {
    private final Map<String, ChatRoom> chatRooms;

//    @PostConstruct
//    private void init() {
//        chatRooms = new HashMap<>();
//    }


    public void save(String roomId, ChatRoom chatRoom) {
        chatRooms.put(roomId, chatRoom);
    }

    public ChatRoom findById(String roomId) {
        return chatRooms.get(roomId);
    }

    public List<ChatRoom> findAll() {
        return new ArrayList<>(chatRooms.values());
    }

}