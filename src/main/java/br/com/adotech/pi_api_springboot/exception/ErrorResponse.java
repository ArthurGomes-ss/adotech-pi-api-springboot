package br.com.adotech.pi_api_springboot.exception;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class ErrorResponse {

    private String message;
    private Integer status;

}
