
package pe.cibertec.ecommerce.ApiCustomer.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pe.cibertec.ecommerce.ApiCustomer.dto.ErrorResponseDto;


@RestControllerAdvice
public class GlobalExceptionHandler {
      
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleEntityNotFound(EntityNotFoundException ex){
        var status = HttpStatus.NOT_FOUND;
        var errorResponse = new ErrorResponseDto(status, ex.getMessage(), ex.toString());
        return new ResponseEntity<>(errorResponse,status);
    }
    
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleValidationExceptions(MethodArgumentNotValidException ex) {
        var status = HttpStatus.BAD_REQUEST;
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        
        var errorResponse= new ErrorResponseDto(status, errors, ex.toString());
        return new ResponseEntity<>(errorResponse,status) ;
    }
}
