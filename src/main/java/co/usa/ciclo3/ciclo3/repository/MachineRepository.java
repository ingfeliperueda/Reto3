/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.CategoryModel;
import co.usa.ciclo3.ciclo3.model.MachineModel;
import co.usa.ciclo3.ciclo3.repository.crud.CategoryCrudRepository;
import co.usa.ciclo3.ciclo3.repository.crud.MachineCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Felipe Rueda
 */
@Repository
public class MachineRepository {
    
    @Autowired
    private MachineCrudRepository machineCrudRepository;
    
    public List<MachineModel> getAll(){
        return (List<MachineModel>) machineCrudRepository.findAll();
    }
    
    public Optional<MachineModel> getMachineModel(int id){
        return machineCrudRepository.findById(id);
    }
    
    public MachineModel save(MachineModel m){
        return machineCrudRepository.save(m);
    }
    
}
