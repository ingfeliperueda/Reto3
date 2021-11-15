/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.MachineModel;
import co.usa.ciclo3.ciclo3.repository.MachineRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Felipe Rueda
 */
@Service
public class MachineService {
    
    @Autowired
    private MachineRepository machineRepository;
    
    public List<MachineModel> getAll(){
        return machineRepository.getAll();
    }
    
    public Optional<MachineModel> getMachineModel(int id){
        return machineRepository.getMachineModel(id);
    }
    
    public MachineModel save(MachineModel m){
        if(m.getId()==null){
            return machineRepository.save(m);
        } else{
            Optional<MachineModel> caux=machineRepository.getMachineModel(m.getId());
            if(caux.isEmpty()){
                return machineRepository.save(m);
            } else {
                return m;
            }
        }
    }
    
}
