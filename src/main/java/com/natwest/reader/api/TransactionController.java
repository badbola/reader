package com.natwest.reader.api;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natwest.reader.request.TransactionCreateRequest;
import com.natwest.reader.service.TransactionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


/**
 * @author Divyanshu Singh on 26-03-2022
 */

@RequiredArgsConstructor
//@Api(tags = "Transaction Apis")
@RestController
@Validated
@Slf4j
@RequestMapping(value = "/api/v0/readTransaction")
public class TransactionController {

	private final TransactionService transactionService;

	@PostMapping()
	public ResponseEntity<String> createTransaction(TransactionCreateRequest request) throws Exception {

		log.info("Received request to encrypt and process transaction");

		return ResponseEntity.ok(transactionService.readAndEncryptTransaction(request));

	}
}
