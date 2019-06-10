/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package io.sofastack.stockmng.controller.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import io.sofastack.balance.manage.facade.BalanceMngFacade;
import io.sofastack.balance.manage.type.Balance;
import io.sofastack.stockmng.controller.BookStoreController;
import io.sofastack.stockmng.facade.StockMngFacade;
import io.sofastack.stockmng.type.BalanceOnly;
import io.sofastack.stockmng.type.ProductInfo;
import io.sofastack.stockmng.type.Success;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author yuanyuan
 * @Since 2019/6/10
 */
@Controller
public class BookStoreControllerImpl implements BookStoreController {

    @SofaReference(interfaceType = StockMngFacade.class, binding = @SofaReferenceBinding(bindingType = "bolt"))
    private StockMngFacade stockMngFacade;

    @SofaReference(interfaceType = BalanceMngFacade.class, binding = @SofaReferenceBinding(bindingType = "bolt"))
    private BalanceMngFacade balanceMngFacade;

    @Override
    public List<ProductInfo> query(String body) {
        JSONObject obj = JSON.parseObject(body);
        String userName = obj.getString("userName");
        List<ProductInfo> productInfos = stockMngFacade.query(userName);
        return productInfos;
    }

    @Override
    public Success purchase(String body) {

        JSONObject obj = JSON.parseObject(body);
        String userName = obj.getString("userName");
        String productCode = obj.getString("productCode");
        int count = obj.getInteger("count");

        return purchase(userName, productCode, count);
    }

    public Success purchase(String userName, String productCode, int count) {
        stockMngFacade.purchase(userName, productCode, count);
        Success success = new Success();
        success.setSuccess("true");
        return success;
    }

    @Override
    public Success createUser(@RequestBody String body){
        JSONObject obj = JSON.parseObject(body);
        String userName = obj.getString("userName");
        balanceMngFacade.createUser(userName);
        Success success = new Success();
        success.setSuccess("true");
        return success;
    }

    @Override
    public BalanceOnly queryBalance(@RequestBody String body){
        JSONObject obj = JSON.parseObject(body);
        String userName = obj.getString("userName");
        BalanceOnly balance = new BalanceOnly();
        balance.setBalance((balanceMngFacade.queryBalance(userName)));
        return balance;
    }
}