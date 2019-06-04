package io.sofastack.stockmng.facade;

/**
 * @author xuanbei
 * @since 2019/6/3
 */
public interface StockMngFacade {
    /**
     * 根据商品名获取库存
     *
     * @param productName 商品名
     */
    int getStock(String productName);

    /**
     * 增加商品库存
     *
     * @param productName 商品名
     * @param amount 增加数目
     */
    void addStock(String productName, int amount);

    /**
     * 减少商品库存
     *
     * @param productName 商品名
     * @param amount 减少数目
     */
    void minusStock(String productName, int amount);
}
