package com.netsdevs.loans.dto;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import java.util.Map;

@ConfigurationProperties(prefix = "loans")
@Getter @Setter
@ConfigurationPropertiesScan
@SpringBootApplication
public class LoansContactInfoDto {

    private String message;
    private Map<String, String> contactDetails;
    private List<String> onCallSupport;

}
