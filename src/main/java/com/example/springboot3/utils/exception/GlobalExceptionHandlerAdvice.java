package com.example.springboot3.utils.exception;

import com.example.springboot3.utils.Result;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tools.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {
    // 处理 @RequestBody 参数校验失败（使用 @Valid 或 @Validated 时都可能抛出此异常）
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        ObjectMapper objectMapper = new ObjectMapper();
        String error_string = objectMapper.writeValueAsString(errors);
        return Result.error(error_string);
    }

    // 处理 @RequestParam / @PathVariable 校验失败（类级别 @Validated 时抛出）
    @ExceptionHandler(ConstraintViolationException.class)
    /*ResponseEntity<Map<String, Object>>*/
    public Result<Map<String, Object>> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, Object> errors = new HashMap<>();
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            String propertyPath = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            errors.put(propertyPath, message);
        }
        /*ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);*/
        ObjectMapper objectMapper = new ObjectMapper();
        String error_string = objectMapper.writeValueAsString(errors);
        return Result.error(error_string);
    }
}
