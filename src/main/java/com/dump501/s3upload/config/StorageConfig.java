package com.dump501.s3upload.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;

@Configuration
public class StorageConfig {
    @Value("${cloud.aws.region.static}")
    private String  region;

    @Bean
    public S3Presigner s3Presigner(){
        return S3Presigner.create();
    }
}
