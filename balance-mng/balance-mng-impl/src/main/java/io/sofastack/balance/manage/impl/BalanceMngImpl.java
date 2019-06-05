package io.sofastack.balance.manage.impl;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import io.sofastack.balance.manage.facade.BalanceMngFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(BalanceMngImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void minusBalance(String userName, double amount) {
        LOGGER.info("minus balance begin ...");
        LOGGER.info("minus stock SQL: update balance_tb set balance = balance - {} where user_name = {}", amount, userName);

        jdbcTemplate.update("update balance_tb set balance = balance - ? where user_name = ?", new Object[] {amount, userName});
        LOGGER.info("minus balance end");
    }
}
