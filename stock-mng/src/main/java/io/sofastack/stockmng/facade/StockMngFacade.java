package io.sofastack.stockmng.facade;

import java.math.BigDecimal;

/**
 * @author xuanbei
 * @since 2019/6/3
 */
public interface StockMngFacade {

    /**
     * 获取商品价格
     *
     * @param productCode 商品码
     */
    BigDecimal getPrice(String productCode);

    /**
     * 减少商品库存
     *
     * @param productCode 商品码
     * @param count 减少数目
     */
    void minusStock(String productCode, int count);
}
