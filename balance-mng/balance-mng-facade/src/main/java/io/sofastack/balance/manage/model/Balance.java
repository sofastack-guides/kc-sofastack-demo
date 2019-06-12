package io.sofastack.balance.manage.model;

/**
 * @author yuanyuan
 * @since 2019/6/10
 */
public class Balance {
    private int    id;
    private String userName;
    private Double balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
