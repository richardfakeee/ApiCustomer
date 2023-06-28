package pe.cibertec.ecommerce.ApiCustomer.controller;

import jakarta.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.ecommerce.ApiCustomer.entity.Customer;
import pe.cibertec.ecommerce.ApiCustomer.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    
    @Autowired
    CustomerService customerService;
    
    
    @GetMapping("/findAll")
    public  ResponseEntity<List<Customer>> findAll(){
         return new ResponseEntity<>(customerService.findAll(),HttpStatus.OK);
        
    }
    
    @GetMapping("/findAll/page/{page}/size/{size}")
    public  ResponseEntity<Page<Customer>> findAll(@PathVariable int page, @PathVariable int size){
         return new ResponseEntity<>(customerService.findAll(page, size),HttpStatus.OK);
        
    }
    
    @GetMapping("/findByNameContaining/name/{name}/page/{page}/size/{size}")
    public  ResponseEntity<Page<Customer>> findByNameContaining(@PathVariable String name, @PathVariable int page, @PathVariable int size){
         return new ResponseEntity<>(customerService.findByNameContaining(name,page, size),HttpStatus.OK);
        
    }
    
    @GetMapping("/findById/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id){
        return new ResponseEntity<>(customerService.findById(id),HttpStatus.OK);
    }
    
    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<Customer> findByEmail(@PathVariable String email){
        return new ResponseEntity<>(customerService.findByEmail(email),HttpStatus.OK);
    }
    
    @GetMapping("/findByPhone")
    public ResponseEntity<Customer> findByPhone(@RequestParam String phone){
        //return customerService.findByPhone(phone);
        return new ResponseEntity<>(customerService.findByPhone(phone),HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Customer> add(@Valid @RequestBody Customer customer){
        return new ResponseEntity<>(customerService.add(customer),HttpStatus.CREATED);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id,@RequestBody Customer customer){
        
        return new ResponseEntity<>(customerService.update(id, customer),HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        customerService.delete(id);
    }
    
   
}
