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
    
    public MachineModel update(MachineModel machine){
        if(machine.getId()!=null){
            Optional<MachineModel> e=machineRepository.getMachineModel(machine.getId());
            if(!e.isEmpty()){
                if(machine.getName()!=null){
                    e.get().setName(machine.getName());
                }
                if(machine.getBrand()!=null){
                    e.get().setBrand(machine.getBrand());
                }
                if(machine.getYear()!=null){
                    e.get().setYear(machine.getYear());
                }
                if(machine.getDescription()!=null){
                    e.get().setDescription(machine.getDescription());
                }
                if(machine.getCategory()!=null){
                    e.get().setCategory(machine.getCategory());
                }
                machineRepository.save(e.get());
                return e.get();
            }else{
                return machine;
            }
        }else{
            return machine;
        }
    }
    
    public boolean deleteMachine(int machineId) {
        Boolean aBoolean = getMachineModel(machineId).map(machine -> {
            machineRepository.delete(machine);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
