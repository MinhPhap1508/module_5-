package com.example.connectfurama.repository;

import com.example.connectfurama.model.Customers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customers, Integer> {
@Query(value = "SELECT * FROM customers", nativeQuery = true)
    Page<Customers> findAll (Pageable pageable, String name);
    @Query(value = "SELECT * FROM customers  WHERE full_name like concat('%',:searchName,'%')",nativeQuery = true)
    Page<Customers> getAllCustomerByName(@Param("searchName") String searchName, Pageable pageable);

    @Query(value = "select  * from  customers where full_name like :searchName and customer_type_id like :idType", nativeQuery = true)
    Page<Customers> findCustomerByNameContainingAndCustomerTypeID(Pageable pageable, @Param(value = "searchName") String searchName, @Param(value = "idType") String idType);

}
