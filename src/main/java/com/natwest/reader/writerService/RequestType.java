package com.natwest.reader.writerService;

import org.springframework.http.HttpMethod;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Divyanshu Singh on 26-03-2022
 */

@Getter
@RequiredArgsConstructor
public enum RequestType {

    SAVE_TRANSACTION(HttpMethod.POST,"/api/saveTransaction");

    private final HttpMethod method;
    private final String requestUri;

}
