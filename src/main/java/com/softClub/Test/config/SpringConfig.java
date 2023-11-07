package com.softClub.Test.config;

import com.softClub.Test.webclient.DailyCurrencyClient;
import com.softClub.Test.webclient.ResponseInterceptor;
import jakarta.xml.bind.Marshaller;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;

import java.util.HashMap;
import java.util.concurrent.Executor;

@Configuration
@ComponentScan("com.softClub.Test")
@EnableJpaRepositories("com.softClub.Test.repositories")
@EntityScan("com.softClub.Test.models")
@EnableWebMvc
@EnableAsync
@EnableScheduling
public class SpringConfig implements AsyncConfigurer {
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.initialize();
        threadPoolTaskExecutor.setCorePoolSize(1);
        return threadPoolTaskExecutor;
    }

    @Bean
    public Jaxb2Marshaller marshaller() throws Exception {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setMarshallerProperties(new HashMap<>() {{
            put(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        }});
        marshaller.setContextPaths(
                "com.softClub.Test.client.gen");
        marshaller.afterPropertiesSet();
        return marshaller;
    }


    @Bean
    public DailyCurrencyClient getClient(Jaxb2Marshaller marshaller) {
        DailyCurrencyClient client = new DailyCurrencyClient();
        client.setDefaultUri("https://www.cbr.ru/DailyInfoWebServ/DailyInfo.asmx");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        client.setInterceptors(new ClientInterceptor[]{new ResponseInterceptor(client)});
        return client;
    }
}
