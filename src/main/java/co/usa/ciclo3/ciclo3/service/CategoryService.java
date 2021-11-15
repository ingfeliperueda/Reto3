/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.CategoryModel;
import co.usa.ciclo3.ciclo3.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Felipe Rueda
 */
@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<CategoryModel> getAll(){
        return categoryRepository.getAll();
    }
    
    public Optional<CategoryModel> getCategoryModel(int id){
        return categoryRepository.getCategoryModel(id);
    }
    
    public CategoryModel save(CategoryModel c){
        if(c.getId()==null){
            return categoryRepository.save(c);
        } else{
            Optional<CategoryModel> caux=categoryRepository.getCategoryModel(c.getId());
            if(caux.isEmpty()){
                return categoryRepository.save(c);
            } else {
                return c;
            }
        }
    }
}
