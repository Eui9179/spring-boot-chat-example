package site.leui.chat_example.chat.repository;

import org.springframework.stereotype.Repository;
import site.leui.chat_example.chat.dto.ChatRoom;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class ChatRepository {

    private final Map<String, ChatRoom> chatRoomMap = new LinkedHashMap<>();

    @PostConstruct
    private void init() {
        for (int i = 0; i < 5; i++) {
            ChatRoom chatRoom = ChatRoom.of("test_" + i);
            chatRoomMap.put(chatRoom.getRoomId(), chatRoom);
        }
    }

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
