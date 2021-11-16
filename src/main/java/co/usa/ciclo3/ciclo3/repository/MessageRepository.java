/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.MachineModel;
import co.usa.ciclo3.ciclo3.model.MessageModel;
import co.usa.ciclo3.ciclo3.repository.crud.MachineCrudRepository;
import co.usa.ciclo3.ciclo3.repository.crud.MessageCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Felipe Rueda
 */
@Repository
public class MessageRepository {
    
    @Autowired
    private MessageCrudRepository messageCrudRepository;
    
    public List<MessageModel> getAll(){
        return (List<MessageModel>) messageCrudRepository.findAll();
    }
    
    public Optional<MessageModel> getMessageModel(int id){
        return messageCrudRepository.findById(id);
    }
    
    public MessageModel save(MessageModel e){
        return messageCrudRepository.save(e);
    }
    
    public void delete(MessageModel e){
        messageCrudRepository.delete(e);
    }
}
