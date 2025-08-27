package com.example.api_test_s3.model;

import com.example.api_test_s3.dto.ArquivoDto;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Data
public class Arquivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String nome;

    public MultipartFile conteudo;

    public Arquivo(ArquivoDto arquivoDto) {
        this.nome = arquivoDto.getNome();
        this.conteudo = arquivoDto.getConteudo();
    }

}
