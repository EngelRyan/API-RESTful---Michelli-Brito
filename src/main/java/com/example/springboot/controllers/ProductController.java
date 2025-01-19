package com.example.springboot.controllers;

import com.example.springboot.dtos.ProductRecordDto;
import com.example.springboot.models.ProductModel;
import com.example.springboot.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
public class ProductController {


    @Autowired
    private ProductRepository productRepository;


    @PostMapping("/products")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {

        var productModel = new ProductModel();

        //O BeanUtils.copyProperties é usado para converter o productRecordDto em um productModel de uma maneira mais simplificada
        BeanUtils.copyProperties(productRecordDto, productModel);  //argumentos = (o que vai ser convertido, no que vai converter)

        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> getAllProducts() {

        List<ProductModel> productsList = productRepository.findAll();

        if (!productsList.isEmpty()) {

            for (ProductModel product : productsList) {

                UUID id = product.getIdProduct();
                product.add(linkTo(methodOn(ProductController.class).getOneProduct(id)).withSelfRel());

                product.add(linkTo(methodOn(ProductController.class).updateProduct(id, null)).withRel("update"));

                product.add(linkTo(methodOn(ProductController.class).deleteProduct(id)).withRel("delete"));


            }
        }

        return ResponseEntity.status(HttpStatus.OK).body(productsList);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value="id") UUID id) {

        Optional<ProductModel> product = productRepository.findById(id);

        if(product.isEmpty()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");

        }
        product.get().add(linkTo(methodOn(ProductController.class).getAllProducts()).withRel("Product List"));
        return ResponseEntity.status(HttpStatus.OK).body(product.get());
    }

    @PutMapping("products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value="id") UUID id,
                                                @RequestBody @Valid ProductRecordDto productRecordDto) {
        Optional<ProductModel> product = productRepository.findById(id);

        if(product.isEmpty()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }

        var productModel = product.get();

        BeanUtils.copyProperties(productRecordDto, productModel);

        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
    }

    @DeleteMapping("products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value="id") UUID id) {

        Optional<ProductModel> product = productRepository.findById(id);

        if(product.isEmpty()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }

        productRepository.delete(product.get());

        return ResponseEntity.status(HttpStatus.OK).body("Product deleted.");
    }
}
