package com.project.demo.response;

import com.project.demo.exception.ErrorInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreLocationResponse {

    private String outcome;
    private BigDecimal amount;
    private ErrorInfo errorInfo;

    public static StoreLocationResponse fail(String outcome, final BigDecimal amount, final ErrorInfo errorMessage) {
        return new StoreLocationResponse(outcome, amount, errorMessage);
    }

    public static StoreLocationResponse of(String outcome, final BigDecimal amount, final ErrorInfo errorMessage) {
        return new StoreLocationResponse(outcome, amount, errorMessage);
    }
}
