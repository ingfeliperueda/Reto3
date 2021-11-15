/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.ciclo3.controller;

import co.usa.ciclo3.ciclo3.model.MachineModel;
import co.usa.ciclo3.ciclo3.service.MachineService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Felipe Rueda
 */
@RestController
@RequestMapping("/api/Machine")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MachineController {
    
    @Autowired
    private MachineService machineService;
    
    @GetMapping("/all")
    public List<MachineModel> getMachines(){
        return machineService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<MachineModel> getMachine(@PathVariable("id") int id){
        return machineService.getMachineModel(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public MachineModel save(@RequestBody MachineModel m){
        return machineService.save(m);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public MachineModel update(@RequestBody MachineModel m) {
        return machineService.update(m);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int machineId) {
        return machineService.deleteMachine(machineId);
    } 
    
}
