package com.example.api_test_s3.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class S3Config {

    private final AwsConfig awsConfig;

    public S3Config(AwsConfig awsConfig) { // Spring injeta aqui
        this.awsConfig = awsConfig;
    }

    @Bean
    public S3Client s3Client(){
        var awsCreds = awsConfig.getCredentials();

        return S3Client.
                builder().
                region(Region.US_EAST_1).
                credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .build();
    }
}
