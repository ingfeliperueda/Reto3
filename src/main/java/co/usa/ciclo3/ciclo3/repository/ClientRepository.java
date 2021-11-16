/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.CategoryModel;
import co.usa.ciclo3.ciclo3.model.ClientModel;
import co.usa.ciclo3.ciclo3.repository.crud.CategoryCrudRepository;
import co.usa.ciclo3.ciclo3.repository.crud.ClientCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Felipe Rueda
 */
@Repository
public class ClientRepository {
    
    @Autowired
    private ClientCrudRepository clientCrudRepository;
    
    public List<ClientModel> getAll(){
        return (List<ClientModel>) clientCrudRepository.findAll();
    }
    
    public Optional<ClientModel> getClientModel(int id){
        return clientCrudRepository.findById(id);
    }
    
    public ClientModel save(ClientModel l){
        return clientCrudRepository.save(l);
    }
    
    public void delete(ClientModel l){
       clientCrudRepository.delete(l);
    }
}
