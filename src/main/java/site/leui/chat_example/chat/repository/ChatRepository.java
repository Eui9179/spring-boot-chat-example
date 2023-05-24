package site.leui.chat_example.chat.repository;

import org.springframework.stereotype.Repository;
import site.leui.chat_example.chat.dto.ChatRoom;

import java.util.*;

@Repository
public class ChatRepository {

    private final Map<String, ChatRoom> chatRoomMap = new LinkedHashMap<>();

    public void save(ChatRoom chatRoom) {
        chatRoomMap.put(chatRoom.getRoomId(), chatRoom);
    }

    public ChatRoom findById(String roomId) {
        return chatRoomMap.get(roomId);
    }

    public List<ChatRoom> findAll() {
        List<ChatRoom> chatRooms = new ArrayList<>(chatRoomMap.values());
        Collections.reverse(chatRooms);
        return chatRooms;
    }
}
