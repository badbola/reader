package com.natwest.reader.externalApiProcessor;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.natwest.reader.properties.NatwestTestProperties;
import com.natwest.reader.writerService.RequestType;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Divyanshu Singh on 26-03-2022
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class WriteServiceProcessor {

	private final NatwestTestProperties natwestTestProperties;

	public String saveEncryptedRequest(String encryptedRequest) {

		log.info("Received encrypted request for transaction");

		String url = natwestTestProperties.getWriteServiceUrl().concat(RequestType.SAVE_TRANSACTION.getRequestUri());

		return new RestTemplate().postForObject(url, encryptedRequest, String.class);

	}
}
