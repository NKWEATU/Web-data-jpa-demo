package com.springdatajpa.sping_data_jpa_course.repository;

import com.springdatajpa.sping_data_jpa_course.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class QueryMethodsTest {

    @Autowired
    private ProductRepository productRepository;

    //Query method code to check findByName
    @Test
    void findByNameMethod(){

        Product product = productRepository.findByName("product 3");

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    //Query method code to check findById
    @Test
    void findByIdMethod(){

        Product product = productRepository.findById(1L).get();
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    //Query method code to check findByNameOrDescription
    @Test
    void findByNameOrDescriptionMethod(){

        List<Product> products = productRepository.findByNameOrDescription("product 1",
                "product 1 description");
            products.forEach((p)->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    //Query method code to check findByNameAndDescription
    @Test
    void findByNameAndDescriptionMethod(){

        List<Product> products = productRepository.findByNameAndDescription("product 1",
                "product 1 description");
        products.forEach((p)->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    //Query method code to check findDistinctByNameMethod
    @Test
    void findDistinctByNameMethod(){

        Product product = productRepository.findDistinctByName("product 1");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    //Query method code to check findByPriceGreaterThan
    @Test
    void findByPriceGreaterThanMethod() {
        List<Product> products = productRepository.findByPriceGreaterThan(
                new BigDecimal(100));
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }
        //Query method code to check findByLessThan
        @Test
        void findByPriceLessThanMethod(){

            List<Product> products= productRepository.findByPriceLessThan(
                    new BigDecimal(2000));
            products.forEach((p)->{
                System.out.println(p.getId());
                System.out.println(p.getName());
            });
        }


    //Query method code to check findByNameContaining
    @Test
        void findByNameContainingMethod(){
        List<Product> products = productRepository.findByNameContaining("product 1");
        products.forEach((p)->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    //Query method code to check findByNameLike
    @Test
    void findByNameLikeMethod(){

        List<Product> products = productRepository.findByNameLike("product 3");
        products.forEach((p)->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    //Query method code to check findByPriceBetween
    @Test
    void findByPriceBetweenMethod(){
        List<Product> products = productRepository.findByPriceBetween(new BigDecimal(100),
                new BigDecimal(30000));
        products.forEach((p)->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    //Query method code to check findByDateCreatedBetween
    @Test
    void findByDateCreatedBetweenMethod(){

        //start date
        LocalDateTime startDate = LocalDateTime.of(2024, 8, 15, 16, 15, (int) 55.914648);

        //end date
        LocalDateTime endStart = LocalDateTime.of(2024, 8, 15, 16, 43, (int) 51.689087);

        List<Product> products = productRepository.findByDateCreatedBetween(startDate, endStart);
        products.forEach((p)->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    //Query method code to check findByNameIn
    @Test
    void findByNameInMethod(){

        List<Product> products = productRepository.findByNameIn(List.of("product 3", "product 4", "product 1"));
        products.forEach((p)->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    //Query method code to check findFirst2ByOrderByNamesAsc (ASC means Ascending order)
    @Test
    void findFirst2ByOrderByNameAscMethod(){
        List<Product> products = productRepository.findFirst2ByOrderByNameAsc();
        products.forEach((p)->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    //Query method code to check findTop2ByOrderByPriceDesc (DSC means Ascending order)
    @Test
    void findTop2ByOrderByPriceDescMethod(){
        List<Product> products = productRepository.findTop2ByOrderByPriceDesc();
        products.forEach((p)->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });

    }
}


