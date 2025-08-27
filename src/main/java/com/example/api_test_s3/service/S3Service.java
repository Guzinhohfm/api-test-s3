package com.example.api_test_s3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;

@Service
public class S3Service {

    private final S3Client s3Client;

    private final String bucketName = "guzinhohfm-bucket";

    public S3Service(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    public void UploadFile(String nome, MultipartFile file) throws IOException
    {
        PutObjectRequest putObjectRequest = PutObjectRequest.builder().bucket(bucketName).key(nome).build();

        s3Client.putObject(putObjectRequest, RequestBody.fromInputStream(file.getInputStream(), file.getSize()));
    }
}
