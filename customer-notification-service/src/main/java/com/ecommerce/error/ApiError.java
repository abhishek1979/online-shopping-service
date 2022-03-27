package com.ecommerce.error;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApiError {

	private String errorCode;
	private String errorDescription;
	private LocalDateTime timestamp;

}
