package io.sofastack.stockmng.facade;

import io.sofastack.stockmng.type.ProductInfo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author yuanyuan
 * @since 2019/6/10
 */
public interface StockMngFacade {

    /**
     * 查询商品信息
     *
     */
    List<ProductInfo> query(String userName);


    /**
     *
     * 购买商品
     */
    void purchase(String userName, String productCode, int count);

    /**
     * 减少商品库存
     *
     * @param productCode 商品码
     * @param count 减少数目
     */
    //void minusStock(String productCode, int count);
}
