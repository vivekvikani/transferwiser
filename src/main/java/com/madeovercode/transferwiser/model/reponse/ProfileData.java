package com.madeovercode.transferwiser.model.reponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfileData {
    int id;
    String type;
    ProfileDataDetails profileDataDetails;
}