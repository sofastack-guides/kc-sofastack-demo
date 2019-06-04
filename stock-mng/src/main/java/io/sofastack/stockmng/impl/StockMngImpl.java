package io.sofastack.stockmng.impl;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import io.sofastack.stockmng.facade.StockMngFacade;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xuanbei
 * @since 2019/6/3
 */
@Service
@SofaService(interfaceType = StockMngFacade.class,bindings = { @SofaServiceBinding(bindingType = "bolt")})
public class StockMngImpl implements StockMngFacade {
    private static final Map<String, Integer> STOCK_MNG = new ConcurrentHashMap<>();
    static {
        STOCK_MNG.put("The C Programming Language", 300);
        STOCK_MNG.put("Thinking in Java", 500);
        STOCK_MNG.put("C++ Primer", 200);
    }

    @Override
    public int getStock(String productName) {
        return STOCK_MNG.get(productName);
    }

    @Override
    public void addStock(String productName, int amount) {
        Integer originalAmount = STOCK_MNG.get(productName);
        if (originalAmount == null) {
            throw new RuntimeException(productName + " is not exist.");
        }
        STOCK_MNG.put(productName, originalAmount + amount);
    }

    @Override
    public void minusStock(String productName, int amount) {
        Integer originalAmount = STOCK_MNG.get(productName);
        if (originalAmount == null) {
            throw new RuntimeException(productName + " is not exist.");
        }
        if (originalAmount < amount) {
            throw new RuntimeException("Insufficient stock.");
        }
        STOCK_MNG.put(productName, originalAmount - amount);
    }
}
