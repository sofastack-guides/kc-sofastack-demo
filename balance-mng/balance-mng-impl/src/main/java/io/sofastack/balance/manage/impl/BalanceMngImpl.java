package io.sofastack.balance.manage.impl;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import io.sofastack.balance.manage.facade.BalanceMngFacade;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xuanbei
 * @since 2019/6/3
 */
@Service
@SofaService(interfaceType = BalanceMngFacade.class,bindings = { @SofaServiceBinding(bindingType = "bolt")})
public class BalanceMngImpl implements BalanceMngFacade {
    private static final Map<String, Double> BALANCE_MNG = new ConcurrentHashMap<>();
    static {
        BALANCE_MNG.put("zhangsan", 1000.0);
        BALANCE_MNG.put("lisi", 600.0);
        BALANCE_MNG.put("wangwu", 600.0);
    }


    @Override
    public double getBalance(String userName) {
        return BALANCE_MNG.get(userName);
    }

    @Override
    public void addBalance(String userName, double amount) {
        Double originalAmount = BALANCE_MNG.get(userName);
        if (originalAmount == null) {
            throw new RuntimeException(userName + " is not exist.");
        }
        BALANCE_MNG.put(userName, originalAmount + amount);
    }

    @Override
    public void minusBlance(String userName, double amount) {
        Double originalAmount = BALANCE_MNG.get(userName);
        if (originalAmount == null) {
            throw new RuntimeException(userName + " is not exist.");
        }
        if (originalAmount < amount) {
            throw new RuntimeException("Insufficient balance.");
        }
        BALANCE_MNG.put(userName, originalAmount - amount);
    }
}
