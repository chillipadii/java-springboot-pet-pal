package sg.com.petpal.petpal.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import sg.com.petpal.petpal.exception.ChatMessageNotFoundException;
import sg.com.petpal.petpal.model.ChatMessage;
import sg.com.petpal.petpal.repository.ChatMessageRepository;

public class ChatMessageServiceImpl implements ChatMessageService {

    private ChatMessageRepository chatMessageRepository;

    public ChatMessageServiceImpl(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    @Override
    public List<ChatMessage> findAllChatMessage() {
        return chatMessageRepository.findAll();
    }

    @Override
    public ChatMessage findChatMessageById(UUID id) {
        return chatMessageRepository.findById(id).orElseThrow(() -> new ChatMessageNotFoundException(id));
    }

    @Override
    public ChatMessage createChatMessage(ChatMessage chatMessage) {
        return chatMessageRepository.save(chatMessage);
    }

    @Override
    public ChatMessage updateChatMessageById(UUID id, ChatMessage chatMessage) {
        ChatMessage chatMessageToUpdate = chatMessageRepository.findById(id).orElseThrow(() -> new ChatMessageNotFoundException(id));
        chatMessageToUpdate.setUpdatedTimestamp(LocalDateTime.now());
        chatMessageToUpdate.setMessage(chatMessage.getMessage());
        return chatMessageRepository.save(chatMessageToUpdate);
    }

    @Override
    public void deleteChatMessageById(UUID id) {
        chatMessageRepository.deleteById(id);
    }
    
}
