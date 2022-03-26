package com.natwest.reader.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Divyanshu Singh on 26-03-2022
 */

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "natwest.read")
public class NatwestTestProperties {

    private String writeServiceUrl;
}
