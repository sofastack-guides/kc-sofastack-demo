/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package io.sofastack.stockmng.controller.impl;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import io.sofastack.balance.manage.facade.BalanceMngFacade;
import io.sofastack.stockmng.controller.BookStoreController;
import io.sofastack.stockmng.facade.StockMngFacade;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;

/**
 *
 * @author lorne.cl
 */
@Controller
public class BookStoreControllerImpl implements BookStoreController {

    @SofaReference(interfaceType = StockMngFacade.class,binding = @SofaReferenceBinding(bindingType = "bolt"))
    private StockMngFacade stockMngFacade;

    @SofaReference(interfaceType = BalanceMngFacade.class,binding = @SofaReferenceBinding(bindingType = "bolt"))
    private BalanceMngFacade balanceMngFacade;

    @Override
    public String purchase(String userName, String productCode, int count) {

        BigDecimal price = stockMngFacade.getPrice(productCode);
        stockMngFacade.minusStock(productCode, count);
        balanceMngFacade.minusBalance(userName, price.doubleValue() * count);

        return "OK";
    }
}