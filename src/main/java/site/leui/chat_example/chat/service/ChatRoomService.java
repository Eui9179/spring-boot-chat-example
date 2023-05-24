package site.leui.chat_example.chat.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import site.leui.chat_example.chat.dto.ChatRoom;
import site.leui.chat_example.chat.repository.ChatRepository;

import java.util.*;

@RequiredArgsConstructor
@Slf4j
@Service
public class ChatRoomService {
    private final ChatRepository chatRepository;

    public List<ChatRoom> findAll() {
        return chatRepository.findAll();
    }

    public ChatRoom findRoomById(String roomId) {
        return chatRepository.findById(roomId);
    }

    public ChatRoom createRoom(String name) {
        ChatRoom chatRoom = ChatRoom.of(name);
        chatRepository.save(chatRoom);
        return chatRoom;
    }
}
