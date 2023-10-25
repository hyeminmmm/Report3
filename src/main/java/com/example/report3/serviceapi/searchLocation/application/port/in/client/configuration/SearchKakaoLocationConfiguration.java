package com.example.report3.serviceapi.searchLocation.application.port.in.client.configuration;

import com.squareup.okhttp.OkHttpClient;
import feign.*;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

public class SearchKakaoLocationConfiguration {
    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public Request.Options options() {
        return new Request.Options(2, TimeUnit.SECONDS, 3, TimeUnit.SECONDS, false);
    }

    @Bean
    public Retryer retryer() {
        return new Retryer.Default(1000, 5000, 3);
    }

   @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> requestTemplate.header("Content-Type", "application/json;charset=UTF-8");
    }
}
