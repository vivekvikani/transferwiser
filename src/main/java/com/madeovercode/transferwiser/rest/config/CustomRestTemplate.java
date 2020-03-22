package com.madeovercode.transferwiser.rest.config;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;

@Component
public class CustomRestTemplate {

    @Autowired
    RestConfigProps restConfigProps;

    @Bean
    public RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        ArrayList<ClientHttpRequestInterceptor> interceptorArrayList = new ArrayList<>();
        interceptorArrayList.add(new RestTemplateInterceptor());
        restTemplate.setInterceptors(interceptorArrayList);
        return restTemplate;
    }

    private class RestTemplateInterceptor implements ClientHttpRequestInterceptor {
        private HttpHeaders headers(){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set(HttpHeaders.AUTHORIZATION, "Bearer "+restConfigProps.getAuthenticationToken());
            httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            return httpHeaders;
        }

        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body,
                ClientHttpRequestExecution execution) throws IOException {
            request.getHeaders().addAll(headers());
            return execution.execute(request, body);
        }
    }
}