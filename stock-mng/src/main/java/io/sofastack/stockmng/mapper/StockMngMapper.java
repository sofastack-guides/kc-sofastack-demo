package io.sofastack.stockmng.mapper;

import io.sofastack.balance.manage.type.Balance;
import io.sofastack.balance.manage.type.Order;
import io.sofastack.stockmng.type.ProductInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.LinkedList;
import java.util.List;

@Mapper
public interface StockMngMapper {
    @Select("select stock_tb.product_code as productCode, name, price, sum(count) as ownedCount\n" +
            "from stock_tb left outer join (select product_code, count from order_tb where user_name = #{userName}) as user_orders\n" +
            "                         on stock_tb.product_code = user_orders.product_code\n" +
            "group by stock_tb.product_code;")
    List<ProductInfo> query(@Param("userName") String userName);

    @Select("select price from stock_tb where product_code = #{productCode}")
    Integer queryProductPrice(@Param("productCode") String productCode);

    @Insert("insert into order_tb (user_name, product_code, count) values (#{userName}, #{productCode}, #{count})")
    void purchase(@Param("userName") String userName, @Param("productCode") String productCode, @Param("count") int count);

    @Select("select * from balance_tb where user_name = #{userName}")
    Balance userExists(@Param("userName") String userName);
}
