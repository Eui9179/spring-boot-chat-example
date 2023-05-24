package site.leui.chat_example.chat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
@Getter
@AllArgsConstructor
@Builder
public class ChatRoom {
    private String roomId;
    private String name;

    public static ChatRoom of(String name) {
        return ChatRoom.builder()
                .name(name)
                .roomId(UUID.randomUUID().toString())
                .build();
    }
}
