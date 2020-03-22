package com.madeovercode.transferwiser.rest;

import com.madeovercode.transferwiser.model.reponse.ProfileData;
import com.madeovercode.transferwiser.rest.config.RestConfigProps;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestConsumer {
    private static final Logger log = LogManager.getLogger(RestConsumer.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RestConfigProps restConfigProps;

    public void getProfileData(){
        ProfileData[] profileData =
                restTemplate.getForObject(
                        restConfigProps.getBaseUrl().concat("profiles"),
                        ProfileData[].class);
        if(null != profileData) {
            log.info(profileData[0].getId());
        }
    }
}
