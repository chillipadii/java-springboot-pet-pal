package sg.com.petpal.petpal.service;

import java.util.List;
import java.util.UUID;

import sg.com.petpal.petpal.model.ChatMessage;

public interface ChatMessageService {

    List<ChatMessage> findAllChatMessage();

    ChatMessage findChatMessageById(UUID id);
    
    ChatMessage createChatMessage(ChatMessage chatMessage);
    
    ChatMessage updateChatMessageById(UUID id, ChatMessage chatMessage);

    void deleteChatMessageById(UUID id);
    
}
