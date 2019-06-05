/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package io.sofastack.stockmng.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author lorne.cl
 */
@RequestMapping("/api")
public interface BookStoreController {

    /**
     * 购买
     * @param userName
     * @param productCode
     * @param count
     * @return
     */
    @RequestMapping("/purchase")
    @ResponseBody
    String purchase(@RequestParam("userName") String userName, @RequestParam("productCode") String productCode, @RequestParam("count") int count);
}