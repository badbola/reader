package com.natwest.reader.request;

import java.math.BigDecimal;

import lombok.Data;

/**
 * @author Divyanshu Singh on 26-03-2022
 */

@Data
public class TransactionCreateRequest {

    private String accountNumber;

    private String type;

    private BigDecimal amount;

    private String currency;

    private String accountForm;
}
