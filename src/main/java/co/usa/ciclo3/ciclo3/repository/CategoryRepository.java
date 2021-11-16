/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.CategoryModel;
import co.usa.ciclo3.ciclo3.repository.crud.CategoryCrudRepository;
import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Felipe Rueda
 */
@Repository
public class CategoryRepository {
    
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;
    
    public List<CategoryModel> getAll(){
        return (List<CategoryModel>) categoryCrudRepository.findAll();
    }
    
    public Optional<CategoryModel> getCategoryModel(int id){
        return categoryCrudRepository.findById(id);
    }
    
    public CategoryModel save(CategoryModel c){
        return categoryCrudRepository.save(c);
    }
    
    public void delete(CategoryModel c){
       categoryCrudRepository.delete(c);
    }
}
