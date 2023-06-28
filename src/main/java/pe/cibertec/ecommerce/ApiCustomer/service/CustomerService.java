package pe.cibertec.ecommerce.ApiCustomer.service;
import java.util.List;
import org.springframework.data.domain.Page;
import pe.cibertec.ecommerce.ApiCustomer.entity.Customer;
public interface CustomerService {
    public List<Customer> findAll();
    public Page<Customer> findAll(int page, int size);
    public Page<Customer> findByNameContaining(String name, int page,int size);
    public Customer findById(Long id);
    public Customer findByEmail(String email);
    public Customer findByPhone(String phone);
    public Customer add(Customer customer);
    public Customer update(Long id, Customer customer);
    public void delete(Long id);
    
}
