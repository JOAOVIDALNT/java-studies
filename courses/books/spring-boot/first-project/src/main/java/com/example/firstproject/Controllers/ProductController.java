package com.example.firstproject.Controllers;

import com.example.firstproject.Models.ProductModel;
import com.example.firstproject.Repositories.ProductRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Controller
public class ProductController {

    @Autowired
    ProductRepository productRepository;

//    @GetMapping("/products")
//    public ResponseEntity<List<ProductModel>> getAllProducts() {
//        return new ResponseEntity<List<ProductModel>>(productRepository.findAll(), HttpStatus.OK);
//    }
    // HATEOAS GET ALL
    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        List<ProductModel> productsList = productRepository.findAll();

        if(!productsList.isEmpty()) {
            for(ProductModel product : productsList) {
                UUID id = product.getIdProduct();
                product.add(linkTo(methodOn(ProductController.class).getOneProduct(id)).withSelfRel());
            }
        }
        return new ResponseEntity<List<ProductModel>>(productsList, HttpStatus.OK);
    }

//    @GetMapping("/products/{id}")
//    public ResponseEntity<ProductModel> getOneProduct(@PathVariable(value = "id") UUID id) {
//        Optional<ProductModel> productO = productRepository.findById(id);
//
//        if(productO.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<ProductModel>(productO.get(), HttpStatus.OK);
//    }
    // HATEOAS GET BY ID
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductModel> getOneProduct(@PathVariable(value = "id") UUID id) {
        Optional<ProductModel> productO = productRepository.findById(id);
        if (productO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productO.get().add(linkTo(methodOn(ProductController.class).getAllProducts()).withRel("Products List"));
        return new ResponseEntity<ProductModel>(productO.get(), HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Validated ProductModel product) {
        return new ResponseEntity<ProductModel>(productRepository.save(product), HttpStatus.CREATED);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductModel> updateProduct(@PathVariable(value = "id") UUID id, @RequestBody @Validated ProductModel product) {
        Optional<ProductModel> productO = productRepository.findById(id);

        if(productO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        product.setIdProduct(productO.get().getIdProduct());
        return new ResponseEntity<ProductModel>(productRepository.save(product), HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") UUID id) {
        Optional<ProductModel> productO = productRepository.findById(id);
        if (productO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productRepository.delete(productO.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
