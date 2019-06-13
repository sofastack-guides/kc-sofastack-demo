package io.sofastack.stockmng.facade;

import io.sofastack.stockmng.model.ProductInfo;
import org.apache.ibatis.annotations.Param;

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

    BigDecimal queryProductPrice(String productCode, String userName);

    boolean createOrder(String userName, String productCode, int count);

    boolean minusStockCount(String userName, String productCode, int count);
}
