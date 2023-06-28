
package pe.cibertec.ecommerce.ApiCustomer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.Date;
import lombok.Data;


@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min = 4, max = 100)
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,unique = true)
    @NotEmpty
    @Size(min = 4, max = 100)
    @Email
    private String email;
    @Column(nullable = false)
    @NotEmpty
    @Size(min = 4, max = 100)
    private String phone;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    
}
