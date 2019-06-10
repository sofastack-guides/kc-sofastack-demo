package io.sofastack.balance.manage.impl;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
;
import io.sofastack.balance.manage.mapper.BalanceMngMapper;
import io.sofastack.balance.manage.facade.BalanceMngFacade;
import io.sofastack.balance.manage.type.Balance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yuanyuan
 * @since 2019/6/10
 */
@Service
@Component
@SofaService(interfaceType = BalanceMngFacade.class, bindings = { @SofaServiceBinding(bindingType = "bolt")})
public class BalanceMngImpl implements BalanceMngFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(BalanceMngImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Resource
    private BalanceMngMapper balanceMngMapper;

    @Override
    public void createUser(String userName){
        Balance balance = balanceMngMapper.isExistUser(userName);
        if (balance == null){
            balanceMngMapper.createUser(userName);
        }
    }

    @Override
    public int queryBalance(String userName){
        Balance balance = balanceMngMapper.queryBalance(userName);
        return balance.getBalance();
    }

    @Override
    public void minusBalance(String userName, double amount) {
        balanceMngMapper.minusBalance(userName, amount);
    }
}
