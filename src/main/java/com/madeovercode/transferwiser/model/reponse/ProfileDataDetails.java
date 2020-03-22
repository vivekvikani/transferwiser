package com.madeovercode.transferwiser.model.reponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfileDataDetails {

    String firstName;
    String lastName;
    String dateOfBirth;
    String phoneNumber;
    String avatarLink;
    String occupation;
    int primaryAddress;
}
