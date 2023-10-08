package com.chrisliu12138.chrisapiclientsdk;

import com.chrisliu12138.chrisapiclientsdk.client.ChrisApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "chrisapi.client")
@Data
@ComponentScan
public class ChrisApiClientConfig {

    /**
     * 用户授权名
     */
    private String accessKey;

    /**
     * 用户授权密钥
     */
    private String secretKey;

    @Bean
    public ChrisApiClient chrisApiClient(){
        return new ChrisApiClient(accessKey, secretKey);
    }
}
