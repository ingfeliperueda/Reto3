/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.ClientModel;
import co.usa.ciclo3.ciclo3.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Felipe Rueda
 */
@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
    
    public List<ClientModel> getAll(){
        return clientRepository.getAll();
    }
    
    public Optional<ClientModel> getClientModel(int id){
        return clientRepository.getClientModel(id);
    }
    
    public ClientModel save(ClientModel l){
        if(l.getIdClient()==null){
            return clientRepository.save(l);
        } else{
            Optional<ClientModel> caux=clientRepository.getClientModel(l.getIdClient());
            if(caux.isEmpty()){
                return clientRepository.save(l);
            } else {
                return l;
            }
        }
    }
    
}
