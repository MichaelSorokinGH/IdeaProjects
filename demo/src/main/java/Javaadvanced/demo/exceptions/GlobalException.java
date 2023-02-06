package Javaadvanced.demo.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class GlobalException {
*/

/*    @Bean
    *//*public ErrorAttributes errorAttributes() {
        return (DefaultErrorAttributes) getErrorAttributes(webRequest, options) {
            return super.getErrorAttributes(webRequest, ErrorAttributeOptions.defaults()
                    .including(ErrorAttributeOptions.Include.MESSAGE));*//*
        }
    }


    @ExceptionHandler(CustomException.class)
    public void handleCustomException(HttpServletResponse response, CustomException ex) throws IOException{
        response.sendError(ex.getStatus().value(), ex.getMessage());

    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorMessage>handleMissingParams(MissingServletRequestParameterException ex) {
        String parameter = ex.getParameterName();
    }

}*/
