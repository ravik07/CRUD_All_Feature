package com.crud.payloads;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorInfo {
	private String errorMessage;
	
	private Integer errorCode;
	
	private LocalDateTime timeStamp;

}
