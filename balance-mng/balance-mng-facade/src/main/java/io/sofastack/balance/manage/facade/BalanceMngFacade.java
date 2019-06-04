package io.sofastack.balance.manage.facade;

/**
 * @author xuanbei
 * @since 2019/6/3
 */
public interface BalanceMngFacade {
    /**
     * 根据用户名获取余额
     *
     * @param userName 用户名
     */
    double getBalance(String userName);

    /**
     * 增加用户余额
     *
     * @param userName 用户名
     * @param amount 增加数目
     */
    void addBalance(String userName, double amount);

    /**
     * 减少用户余额
     *
     * @param userName 用户名
     * @param amount 减少数目
     */
    void minusBlance(String userName, double amount);
}
