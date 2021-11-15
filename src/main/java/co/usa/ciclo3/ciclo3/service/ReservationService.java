/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.CategoryModel;
import co.usa.ciclo3.ciclo3.model.ReservationModel;
import co.usa.ciclo3.ciclo3.repository.CategoryRepository;
import co.usa.ciclo3.ciclo3.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Felipe Rueda
 */
@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<ReservationModel> getAll(){
        return reservationRepository.getAll();
    }
    
    public Optional<ReservationModel> getReservationModel(int id){
        return reservationRepository.getReservationModel(id);
    }
    
    public ReservationModel save(ReservationModel r){
        if(r.getId()==null){
            return reservationRepository.save(r);
        } else{
            Optional<ReservationModel> caux=reservationRepository.getReservationModel(r.getId());
            if(caux.isEmpty()){
                return reservationRepository.save(r);
            } else {
                return r;
            }
        }
    }
    
}
