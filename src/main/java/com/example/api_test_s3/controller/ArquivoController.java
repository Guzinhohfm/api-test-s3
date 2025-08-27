package com.example.api_test_s3.controller;

import com.example.api_test_s3.dominios.middleware.GlobalExceptionHandler;
import com.example.api_test_s3.dto.ArquivoDto;
import com.example.api_test_s3.model.Arquivo;
import com.example.api_test_s3.service.S3Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/arquivo")
public class ArquivoController {

    @Autowired
    private S3Service s3Service;

    @PostMapping(consumes = {"multipart/form-data"})
    public boolean post(@ModelAttribute ArquivoDto arquivoDto) throws Exception {
        if (arquivoDto.getNome() == null) {
            throw new Exception("Zuou a porra toda");
        }
        var arquivo = new Arquivo(arquivoDto);

        log.info("O arquivo a ser salvo é: {}", arquivo.getNome());
        s3Service.UploadFile(arquivo.getNome(), arquivo.getConteudo());

        return true;
    }


}
