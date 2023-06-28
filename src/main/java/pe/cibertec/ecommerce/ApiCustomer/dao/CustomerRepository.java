package pe.cibertec.ecommerce.ApiCustomer.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.cibertec.ecommerce.ApiCustomer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
    Customer findByEmail(String email);
    
    //@Query ("select c from customer where c.phone=?1 and c.email=?2")
    //Customer findByPhone(String phone, String email);
    
    @Query("select c from Customer c where c.phone = ?1")
    Customer findByPhone(String phone);
    
    Page<Customer> findByNameContaining(String name,Pageable pageable);
}
