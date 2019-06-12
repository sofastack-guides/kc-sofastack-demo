package io.sofastack.balance.manage.mapper;

import io.sofastack.balance.manage.model.Balance;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;

@Mapper
public interface BalanceMngMapper {
    @Select("select * from balance_tb where user_name = #{userName}")
    Balance userExists(@Param("userName") String userName);

    @Insert("insert into balance_tb (user_name, balance) values (#{userName}, 1000000)")
    void createUser(@Param("userName") String userName);

    @Select("select * from balance_tb where user_name = #{userName}")
    Balance queryBalance(@Param("userName") String userName);

    @Update("update balance_tb set balance = balance - #{amount} where user_name = #{userName}")
    void minusBalance(@Param("userName") String userName, @Param("amount") BigDecimal amount);
}
