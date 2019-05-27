package io.sofastack.service.consumer.controller;

import io.sofastack.service.facade.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: guolei.sgl (guolei.sgl@antfin.com) 2019/5/27 7:19 PM
 * @since:
 **/
@RestController
public class SimpleController {

    private HelloService helloService;

    @RequestMapping("hello")
    public String hello(){
        return helloService.hello();
    }
}
