package io.sofastack.stockmng.impl;

import io.sofastack.stockmng.facade.StockMngFacade;
import io.sofastack.stockmng.mapper.StockMngMapper;
import io.sofastack.stockmng.model.ProductInfo;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author yuanyuan
 * @since 2019/6/10
 */
public class StockMngImpl implements StockMngFacade {
    @Resource
    private StockMngMapper stockMngMapper;

    @Override
    public List<ProductInfo> query(String userName) {
        Integer stockRecordCount = stockMngMapper.getStockRecordCountForUserName(userName);
        if (stockRecordCount == null) {
            initUser(userName);
        }

        return stockMngMapper.query(userName);
    }

    private void initUser(String userName) {
        for (int i = 0; i < 5; i++) {
            stockMngMapper.insertStockRecord(
                "0000" + (i + 1),
                DatabaseSeed.name[i],
                DatabaseSeed.description[i],
                DatabaseSeed.price[i],
                10000,
                userName
            );
        }
    }

    @Override
    public BigDecimal queryProductPrice(String productCode, String userName) {
        return stockMngMapper.queryProductPrice(productCode, userName);
    }

    @Override
    public boolean createOrder(String userName, String productCode, int count) {
        return stockMngMapper.createOrder(userName, productCode, count) > 0;
    }

    @Override
    public boolean minusStockCount(String userName, String productCode, int count) {
        return stockMngMapper.minusStockCount(userName, productCode, count) > 0;
    }
}
