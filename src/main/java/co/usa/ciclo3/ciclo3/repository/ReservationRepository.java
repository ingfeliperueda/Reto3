/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.CategoryModel;
import co.usa.ciclo3.ciclo3.model.ReservationModel;
import co.usa.ciclo3.ciclo3.repository.crud.CategoryCrudRepository;
import co.usa.ciclo3.ciclo3.repository.crud.ReservationCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Felipe Rueda
 */
@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    
    public List<ReservationModel> getAll(){
        return (List<ReservationModel>) reservationCrudRepository.findAll();
    }
    
    public Optional<ReservationModel> getReservationModel(int id){
        return reservationCrudRepository.findById(id);
    }
    
    public ReservationModel save(ReservationModel r){
        return reservationCrudRepository.save(r);
    }
    
    public void delete(ReservationModel r){
        reservationCrudRepository.delete(r);
    }
}
