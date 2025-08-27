package com.example.api_test_s3.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;

@Data
@Configuration
public class AwsConfig {

    @Value("${aws.accessKeyId}")
    private String accessKeyId;
    @Value("${aws.secretKey}")
    private String secretKeyId;
    @Value("${aws.region}")
    public String region;

    @Cacheable("awsCreds")
    public AwsBasicCredentials getCredentials(){
        return AwsBasicCredentials.create(accessKeyId,secretKeyId);
    }
}
