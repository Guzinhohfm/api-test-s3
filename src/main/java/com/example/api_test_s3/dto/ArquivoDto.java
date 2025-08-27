package com.example.api_test_s3.dto;

import com.example.api_test_s3.model.Arquivo;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Data
public class ArquivoDto {

    public String nome;

    public MultipartFile conteudo;
}
