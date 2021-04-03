package io.sofastack.stockmng.mapper;

import io.sofastack.stockmng.model.ProductInfo;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface StockMngMapper {
    @Select(
        "select stock_tb.product_code as productCode, stock_tb.count as stockCount, name, price, sum(user_orders.count) as ownedCount, description\n" +
            "from stock_tb left outer join (select product_code, count from order_tb where user_name = #{userName}) as user_orders\n" +
            "                      on stock_tb.product_code = user_orders.product_code where stock_tb.user_name=#{userName} \n" +
            "group by productCode, stockCount, name, price, description;")
    List<ProductInfo> query(@Param("userName") String userName);

    @Select("select price from stock_tb where product_code = #{productCode} and user_name = #{userName}")
    BigDecimal queryProductPrice(@Param("productCode") String productCode, @Param("userName") String userName);

    @Select("select sum(1) from stock_tb where user_name = #{userName}")
    Integer getStockRecordCountForUserName(@Param("userName") String userName);

    @Insert(
        "insert into stock_tb (product_code, name, description, price, count, user_name) values (#{productCode}, "
            + "#{name}, #{description}, #{price}, #{count}, #{userName})")
    void insertStockRecord(@Param("productCode") String productCode, @Param("name") String name,
                           @Param("description") String description, @Param("price") BigDecimal price,
                           @Param("count") Integer count, @Param("userName") String userName);

    @Insert("insert into order_tb (user_name, product_code, count) values (#{userName}, #{productCode}, #{count})")
    int createOrder(@Param("userName") String userName, @Param("productCode") String productCode, @Param("count") int count);

    @Update("update stock_tb set count=count - #{count} where product_code=#{productCode} and user_name=#{userName}")
    int minusStockCount(@Param("userName") String userName, @Param("productCode") String productCode,
                         @Param("count") int count);
}
