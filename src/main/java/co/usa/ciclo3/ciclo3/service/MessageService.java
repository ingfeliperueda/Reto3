/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.CategoryModel;
import co.usa.ciclo3.ciclo3.model.MessageModel;
import co.usa.ciclo3.ciclo3.repository.CategoryRepository;
import co.usa.ciclo3.ciclo3.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Felipe Rueda
 */
@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;
    
    public List<MessageModel> getAll(){
        return messageRepository.getAll();
    }
    
    public Optional<MessageModel> getMessageModel(int id){
        return messageRepository.getMessageModel(id);
    }
    
    public MessageModel save(MessageModel e){
        if(e.getIdMessage()==null){
            return messageRepository.save(e);
        } else{
            Optional<MessageModel> caux=messageRepository.getMessageModel(e.getIdMessage());
            if(caux.isEmpty()){
                return messageRepository.save(e);
            } else {
                return e;
            }
        }
    }
    
}
