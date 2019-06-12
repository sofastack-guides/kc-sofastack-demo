/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package io.sofastack.stockmng.controller;

import io.sofastack.stockmng.type.BalanceResponse;
import io.sofastack.stockmng.type.ProductInfo;
import io.sofastack.stockmng.type.Success;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author yuanyuan
 * @Since 2019/6/10
 */

@RequestMapping("/")
public interface BookStoreController {

    /**
     * 查询商品信息
     *
     */
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ResponseBody
    List<ProductInfo> query(@RequestBody String body);


    /**
     * 购买
     *
     */
    @RequestMapping(value = "/purchase", method = RequestMethod.POST)
    @ResponseBody
    Success purchase(@RequestBody String body);


    /**
     * BalanceMng的RPC代理为Web
     * 创建用户
     *
     */
    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    @ResponseBody
    Success createUser(@RequestBody String body);

    /**
     * BalanceMng的RPC代理为Web
     * 查询余额
     *
     */
    @RequestMapping(value = "/queryBalance", method = RequestMethod.POST)
    @ResponseBody
    BalanceResponse queryBalance(@RequestBody String body);


    /**
     * 查询排序
     * @return
     */
    @RequestMapping(value = "/querySort", method = RequestMethod.POST)
    @ResponseBody
    BalanceResponse querySort();
}