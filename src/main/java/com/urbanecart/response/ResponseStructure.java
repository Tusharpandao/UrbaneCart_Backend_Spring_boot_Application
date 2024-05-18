package com.urbanecart.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseStructure<T> {
	private String message;
	private T data;
	private int status;
	
	@SuppressWarnings("unchecked")
	public ResponseStructure(String message, List<? extends Object> dataList, int status) {
	    this.message = message;
	    this.data = (T) dataList;
	    this.status = status;
	}

}
