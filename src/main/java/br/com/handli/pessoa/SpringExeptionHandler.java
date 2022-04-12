package br.com.handli.pessoa;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //especificar o que acontece no controller
public class SpringExeptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)

    
    public ResponseEntity<?> getUser(MethodArgumentNotValidException error){
        FieldError fielderror = error.getFieldErrors().stream().collect(Collectors.toList()).get(0);
        Map<String, String> response = new HashMap<>();
        response.put("error", fielderror.getDefaultMessage());
        response.put("timestamp", LocalDateTime.now().toString());
        
        return ResponseEntity.badRequest().body(response);
    }
}
