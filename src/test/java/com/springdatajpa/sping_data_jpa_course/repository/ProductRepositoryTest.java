package com.springdatajpa.sping_data_jpa_course.repository;

import com.springdatajpa.sping_data_jpa_course.entity.Product;
import org.hibernate.dialect.SybaseASEDialect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.aot.hint.TypeReference.listOf;

@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
        //using the saveMethod entity in Jpa Repository
    void saveMethod() {
        //create product
        Product product = new Product();
        product.setName("product 1");
        product.setDescription("product 1 description");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");

        //save product
        Product savedObject = productRepository.save(product);

        //display product information
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());
    }

    @Test
        //using the updateMethod entity in Jpa Repository
    void updateUsingSaveMethod() {

        // find or retrieve an entity by id
        Long id = 1l;
        Product product = productRepository.findById(id).get();

        //update entity information
        Product product2 = new Product();
        product2.setName("product 23");
        product2.setDescription("product 22 description");
        product2.setSku("100ABCf");
        product2.setPrice(new BigDecimal(10550));
        product2.setActive(true);
        product2.setImageUrl("product12.png");
        //saved updated entity
        Product savedObject1 = productRepository.save(product2);
        System.out.println(savedObject1.getId());
        System.out.println(savedObject1.toString());

    }

    //using the findByIdMethod entity in Jpa Repository
    @Test
    void findByIdMethod() {
        Long id = 10L; //in real-time project, the id has come from the client

        Product product = productRepository.findById(id).get();
    }

    //using the saveAllMethod entity in Jpa Repository
    @Test
    void saveAllMethod() {
        Product product3 = new Product();
        product3.setName("product 3");
        product3.setDescription("product 3 description");
        product3.setSku("500ABCe");
        product3.setPrice(new BigDecimal(1003));
        product3.setActive(true);
        product3.setImageUrl("product3.png");


        Product product4 = new Product();
        product4.setName("product 4");
        product4.setDescription("product 4 description");
        product4.setSku("800ABCer");
        product4.setPrice(new BigDecimal(13003));
        product4.setActive(true);
        product4.setImageUrl("product4.png");

        productRepository.saveAll(List.of(product3, product4));
    }

    //using the findAllMethod entity in Jpa Repository
    @Test
    void findAllMethod() {

        List<Product> products = productRepository.findAll();

        products.forEach((p) -> {
            System.out.println(p.getName());
        });
    }

    //using the deleteByIdMethod entity in Jpa Repository
    @Test
    void deleteByIdMethod() {
        Long id = 1L; //in real-time project, the id has come from the client

        productRepository.deleteById(id);
    }

    //using the deleteMethod entity in Jpa Repository which delete an entity from the database table

    @Test
    void deleteMethod() {

        //find an entity by id
        Long id = 4L;
        Product product = productRepository.findById(id).get();

        //delete the entity
        productRepository.delete(product);
    }

    //using the deleteAllMethod entity in Jpa Repository which delete multiple an entities from the database table
    @Test
    void deleteAllMethod() {

        //productRepository.deleteAll();
        Product product3 = productRepository.findById(16L).get();
        Product product4 = productRepository.findById(17L).get();

        productRepository.deleteAll(List.of(product3, product4));

    }

    //using the countMethod entity in Jpa Repository
    @Test
    void countMethod() {
        long count = productRepository.count();
        System.out.println(count);
    }

    @Test
        //using the existsByIdMethod entity in Jpa Repository
    void existsByIdMethod() {
        Long id = 1L;
        boolean result = productRepository.existsById(id);
        System.out.println(result);
    }
}