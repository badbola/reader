package com.natwest.reader.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.stereotype.Service;

import com.natwest.reader.externalApiProcessor.WriteServiceProcessor;
import com.natwest.reader.request.TransactionCreateRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Divyanshu Singh on 26-03-2022
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class TransactionService {

	private final WriteServiceProcessor writeServiceProcessor;

	public String readAndEncryptTransaction(TransactionCreateRequest request) throws Exception {

		log.info("Received request to encrypt and save: {}", request);
		if (request == null) {
			log.error("Cannot encrypt null request");
			throw new Exception("Null request cannot be encrypted");
		}

		String encryptedRequest = Base64.getEncoder()
				.encodeToString(request.toString().getBytes(StandardCharsets.UTF_8));

		return writeServiceProcessor.saveEncryptedRequest(encryptedRequest);
	}
}
