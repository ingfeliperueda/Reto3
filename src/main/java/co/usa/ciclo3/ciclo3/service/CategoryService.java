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

    public CategoryModel update(CategoryModel c){
        if(c.getId()!=null){
            Optional<CategoryModel>g=categoryRepository.getCategoryModel(c.getId());
            if(!g.isEmpty()){
                if(c.getDescription()!=null){
                    g.get().setDescription(c.getDescription());
                }
                if(c.getName()!=null){
                    g.get().setName(c.getName());
                }
                return categoryRepository.save(g.get());
            }
        }
        return c;
    }
    public boolean delete(int id){
        Boolean d;
        d = getCategoryModel(id).map(categoria -> {
            categoryRepository.delete(categoria);
            return true;
        }).orElse(false);
        return d;
    }
}
