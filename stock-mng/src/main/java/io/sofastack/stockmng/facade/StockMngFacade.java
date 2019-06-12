package io.sofastack.stockmng.facade;

import io.sofastack.stockmng.model.ProductInfo;

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
}
