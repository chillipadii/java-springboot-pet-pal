package sg.com.petpal.petpal.service;

import java.util.List;
import java.util.UUID;

import sg.com.petpal.petpal.model.ChatRoom;

public interface ChatRoomService {
    
    List<ChatRoom> findAllChatRooms();

    ChatRoom findChatRoomById(UUID id);

    ChatRoom createChatRoom(ChatRoom chatRoom);

    ChatRoom updateChatRoomById(UUID id, ChatRoom chatRoom);

    void deleteChatRoomById(UUID id);

}
