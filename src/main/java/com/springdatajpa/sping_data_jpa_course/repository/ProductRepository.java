package com.springdatajpa.sping_data_jpa_course.repository;

import com.springdatajpa.sping_data_jpa_course.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //The findByName Method return the found product entry by using
    //its name as search criteria. if no product entry is found, it returns null
    public Product findByName(String name);

    //Returns an Optional which contains the found product entry
    //by using its id as search criteria. If no product entry is found,
    //this method returns an  empty Oaptional
    Optional<Product> findById(Long id);

    //Returns the found list of product entries whose name or description
    //is given as a method parameters. If no product is found, this method
    //returns an empty list.
    List<Product> findByNameOrDescription(String name, String description);


    //Returns the found list of product entries whose name and description
    //is given as a method parameters. If no product is found, this method
    //returns an empty list.
    List<Product> findByNameAndDescription(String name, String description);

    //Return the distinct product entry whose name is given as a method parameter
    //If no product entry is found, this method returns null
    Product findDistinctByName(String name);

    //Return the products whose price is greater than given
    // price as method parameter.
    List<Product> findByPriceGreaterThan(BigDecimal price);

    //Return the products whose price is less than given
    // price as method parameter.
    List<Product> findByPriceLessThan(BigDecimal price);

    //Returns the filtered product records that matches the given test
    List<Product> findByNameContaining(String name);

    //Returns products based on SQL like condition
    List<Product> findByNameLike(String name);


    //Returns products whose price is between start price and end price
    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

    //Returns products whose date is between start date and end date
    List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);

    //Returns list of products based on multiple values
    List<Product> findByNameIn(List<String> names);

    //Returns list of products based on limited values
    List<Product> findFirst2ByOrderByNameAsc();

    //Returns list of products based on limited values
    List<Product> findTop2ByOrderByPriceDesc();
}
