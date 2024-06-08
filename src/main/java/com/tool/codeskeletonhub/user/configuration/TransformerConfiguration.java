package com.tool.codeskeletonhub.user.configuration;

import com.tool.codeskeletonhub.user.transformer.MapStructUserTransformer;
import com.tool.codeskeletonhub.user.transformer.UserTransformer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransformerConfiguration {

    @Bean
    public UserTransformer userTransformer() {
        return MapStructUserTransformer.INSTANCE;
    }
}
