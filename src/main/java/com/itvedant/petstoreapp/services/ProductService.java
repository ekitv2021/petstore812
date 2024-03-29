package com.itvedant.petstoreapp.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.petstoreapp.entities.Product;
import com.itvedant.petstoreapp.repositories.ProductRepository;

//@service will work same as that of @component annotation
@Service
public class ProductService {
   
    @Autowired
    private ProductRepository productRepository;

    //create
    public Product addProduct(Product newProduct){   
        //create insert query because the id value will be null
        //this id will be auto generated by the database
        return this.productRepository.save(newProduct);
    }

    //read all
    public Iterable<Product> getAll(){
        return this.productRepository.findAll();
    }

    //read one
    public Product getProduct(Integer id){
        //findById will return the Product if the record
        //is found in the product corresponding to the id,
        //or else it will return null
        return this.productRepository.findById(id).orElse(null);
    }

    public String deleteProduct(Integer id){
        this.productRepository.deleteById(id);
        return "Product Deleted";
    }
    
    public Product updateProduct(Integer id, Product prod){    
        //we will have to first set the id of the Product object
        //so that it is not null and repository will create
        //the update query
        prod.setId(id);    
        return this.productRepository.save(prod);
    }        
}

