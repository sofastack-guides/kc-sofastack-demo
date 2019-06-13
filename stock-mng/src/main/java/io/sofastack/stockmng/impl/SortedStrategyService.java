package io.sofastack.stockmng.impl;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import io.sofastack.dynamic.facade.StrategyService;
import io.sofastack.stockmng.facade.StockMngFacade;
import io.sofastack.stockmng.model.OrderInfo;
import io.sofastack.stockmng.model.ProductInfo;
import io.sofastack.stockmng.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: guolei.sgl (guolei.sgl@antfin.com) 2019/6/12 9:10 PM
 * @since:
 **/
@Service
public class SortedStrategyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SortedStrategyService.class);

    @SofaReference
    private StrategyService strategyService;

    @SofaReference(interfaceType = StockMngFacade.class, uniqueId = "${service.unique.id}", binding = @SofaReferenceBinding(bindingType = "bolt"))
    private StockMngFacade stockMngFacade;

    public List<ProductInfo> getSorted(String userName) {
        LOGGER.info("userName = " + userName);
        List<ProductInfo> result = new ArrayList<>();
        try{
            Map<ProductInfo, Integer> map = new HashMap<>();
            String strategy = strategyService.strategy();
            // 按照个人订单认读排序
            if (strategy.equals("goods")) {
                List<ProductInfo> products = stockMngFacade.query(userName);
                List<OrderInfo> orders = stockMngFacade.queryOrderByUserName(userName);
                if (orders.size() == 0) {
                    result = products;
                } else {
                    for (ProductInfo productInfo : products) {
                        int currentCount = 0;
                        for (OrderInfo orderInfo : orders) {
                            if (orderInfo.getProductCode().equals(productInfo.getProductCode())) {
                                currentCount += orderInfo.getCount();
                            }
                        }
                        map.put(productInfo, currentCount);
                    }
                    result = CommonUtil.sorted(map);
                }
            }
        }catch (Throwable t){
            t.printStackTrace();
           result =  stockMngFacade.query(userName);
        }
        return result;
    }
}
