package com.vrs.globalExceptionHandeller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandeller {
	
	@ExceptionHandler(exception = RuntimeException.class)
	public Map<String,Object>handellExceptions(RuntimeException e){
		Map<String,Object>map=new HashMap<>();
		map.put("timeStamp",LocalDate.now());
		map.put("msg", e.getLocalizedMessage());
		map.put("status",HttpStatus.BAD_REQUEST);
		return map;
		
		
	}
	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	public Map<String,Object>handellValidatorExceptions(MethodArgumentNotValidException e){
		Map<String,Object>map=new HashMap<>();
		List<FieldError>list=e.getBindingResult().getFieldErrors();
		map.put("timeStamp",LocalDate.now());
//		map.put("msg", e.getLocalizedMessage());
		map.put("status",e.getStatusCode());
		list.forEach(s->{
			map.put(s.getField(),s.getDefaultMessage());
		});
		return map;
		
		
	}
	
	

}
