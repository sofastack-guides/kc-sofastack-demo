package io.sofastack.stockmng.impl;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import io.sofastack.stockmng.facade.StockMngFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author xuanbei
 * @since 2019/6/3
 */
@Service
@SofaService(interfaceType = StockMngFacade.class,bindings = { @SofaServiceBinding(bindingType = "bolt")})
public class StockMngImpl implements StockMngFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(StockMngImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public BigDecimal getPrice(String productCode) {
        return new BigDecimal(10);
    }

    @Override
    public void minusStock(String productCode, int count) {
        LOGGER.info("minus stock begin ...");
        LOGGER.info("minus stock SQL: update stock_tb set count = count - {} where product_code = {}", count, productCode);

        jdbcTemplate.update("update stock_tb set count = count - ? where product_code = ?", new Object[] {count, productCode});
        LOGGER.info("minus stock end");
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
