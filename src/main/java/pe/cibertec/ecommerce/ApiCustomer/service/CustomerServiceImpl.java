package pe.cibertec.ecommerce.ApiCustomer.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.cibertec.ecommerce.ApiCustomer.dao.CustomerRepository;
import pe.cibertec.ecommerce.ApiCustomer.entity.Customer;
import pe.cibertec.ecommerce.ApiCustomer.exception.EntityNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Customer> findAll() {
        
        return (List<Customer>) customerRepository.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Page<Customer> findAll(int page,int size) {
       return customerRepository.findAll(PageRequest.of(page, size));
    }
    
    @Override
    @Transactional(readOnly = true)
    public Page<Customer> findByNameContaining(String name, int page, int size) {
        return customerRepository.findByNameContaining(name, PageRequest.of(page, size));
    }

    @Override
    @Transactional(readOnly = true)
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Not found customer with id: "+id.toString()));
    }
    
    @Override
    @Transactional(readOnly = true)
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email);//.orElse(null);  
    }

    @Override
    @Transactional(readOnly = true)
    public Customer findByPhone(String phone) {
        return customerRepository.findByPhone(phone);
    }

    @Override
    public Customer add(Customer customer) {
        return customerRepository.save(customer);
        
    }

    @Override
    public Customer update(Long id, Customer customer) {
        Customer customerDB = customerRepository.findById(id).get();
        customerDB.setName(customer.getName());
        customerDB.setEmail(customer.getEmail());
        customerDB.setPhone(customer.getPhone());
        return customerRepository.save(customerDB);
    }

    @Override
    public void delete(Long id) {
        Customer customerDB = customerRepository.findById(id).get();
        customerRepository.delete(customerDB);
    }

   

   
    
}
