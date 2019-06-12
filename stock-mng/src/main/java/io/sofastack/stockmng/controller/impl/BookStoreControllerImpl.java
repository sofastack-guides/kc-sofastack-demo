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
import io.sofastack.stockmng.controller.BookStoreController;
import io.sofastack.stockmng.facade.StockMngFacade;
import io.sofastack.stockmng.model.BalanceResponse;
import io.sofastack.stockmng.model.ProductInfo;
import io.sofastack.stockmng.model.Success;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author yuanyuan
 * @Since 2019/6/10
 */
@Controller
public class BookStoreControllerImpl implements BookStoreController {

    @SofaReference(interfaceType = StockMngFacade.class, uniqueId = "${service.unique.id}", binding = @SofaReferenceBinding(bindingType = "bolt"))
    private StockMngFacade stockMngFacade;

    @SofaReference(interfaceType = BalanceMngFacade.class, uniqueId = "${service.unique.id}", binding = @SofaReferenceBinding(bindingType = "bolt"))
    private BalanceMngFacade balanceMngFacade;

    @Override
    public List<ProductInfo> query(String body) {
        JSONObject obj = JSON.parseObject(body);
        String userName = obj.getString("userName");
        return stockMngFacade.query(userName);
    }

    @Override
    public List<ProductInfo> querySorted(String body) {
        //TODO(guolei.sgl): SOFA 动态模块
        JSONObject obj = JSON.parseObject(body);
        String userName = obj.getString("userName");
        return stockMngFacade.query(userName);
    }

    @Override
    public Success purchase(String body) {

        JSONObject obj = JSON.parseObject(body);
        String userName = obj.getString("userName");
        String productCode = obj.getString("productCode");
        int count = obj.getInteger("count");

        stockMngFacade.purchase(userName, productCode, count);
        Success success = new Success();
        success.setSuccess("true");
        return success;
    }

    @Override
    public Success createUser(@RequestBody String body) {
        JSONObject obj = JSON.parseObject(body);
        String userName = obj.getString("userName");
        balanceMngFacade.createUser(userName);
        Success success = new Success();
        success.setSuccess("true");
        return success;
    }

    @Override
    public BalanceResponse queryBalance(@RequestBody String body) {
        JSONObject obj = JSON.parseObject(body);
        String userName = obj.getString("userName");
        BalanceResponse balance = new BalanceResponse();
        balance.setBalance((balanceMngFacade.queryBalance(userName)));
        return balance;
    }
}