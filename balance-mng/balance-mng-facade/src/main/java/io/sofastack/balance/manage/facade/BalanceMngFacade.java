package io.sofastack.balance.manage.facade;

/**
 * @author yuanyuan
 * @since 2019/6/10
 */
public interface BalanceMngFacade {

    /**
     *
     * 添加一条用户记录
     */

    void createUser(String userName);


    /**
     * 返回用户余额
     *
     */
    int queryBalance(String userName);



    /**
     * 减少用户余额
     *
     * @param userName 用户名
     * @param amount 减少数目
     */
    void minusBalance(String userName, double amount);
}
