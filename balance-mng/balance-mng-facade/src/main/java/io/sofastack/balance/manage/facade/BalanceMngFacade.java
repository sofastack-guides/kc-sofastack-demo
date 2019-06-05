package io.sofastack.balance.manage.facade;

/**
 * @author xuanbei
 * @since 2019/6/3
 */
public interface BalanceMngFacade {
    /**
     * 减少用户余额
     *
     * @param userName 用户名
     * @param amount 减少数目
     */
    void minusBalance(String userName, double amount);
}
