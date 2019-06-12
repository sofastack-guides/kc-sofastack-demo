package io.sofastack.stockmng.model;

import java.math.BigDecimal;

public class BalanceResponse {

    private BigDecimal balance;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
