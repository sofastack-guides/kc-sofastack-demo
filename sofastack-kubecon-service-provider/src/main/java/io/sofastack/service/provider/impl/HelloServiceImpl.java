package io.sofastack.service.provider.impl;

import io.sofastack.service.facade.HelloService;

/**
 * @author: guolei.sgl (guolei.sgl@antfin.com) 2019/5/27 5:55 PM
 * @since:
 **/
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello() {
        return "hello sofastack";
    }
}
