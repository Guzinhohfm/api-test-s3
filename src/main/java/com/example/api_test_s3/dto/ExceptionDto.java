package com.example.api_test_s3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionDto {

    public String erro;

    public int statusCode;

    public String detalhes;

    public String caminho;


}
