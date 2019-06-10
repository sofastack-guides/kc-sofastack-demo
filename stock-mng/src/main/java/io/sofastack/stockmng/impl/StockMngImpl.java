package io.sofastack.stockmng.impl;

import ch.qos.logback.core.status.OnPrintStreamStatusListenerBase;
import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import io.sofastack.balance.manage.facade.BalanceMngFacade;
import io.sofastack.balance.manage.type.Balance;
import io.sofastack.stockmng.facade.StockMngFacade;
import io.sofastack.stockmng.mapper.StockMngMapper;
import io.sofastack.stockmng.type.ProductInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author yuanyuan
 * @since 2019/6/10
 */
@Service
@Component
@SofaService(interfaceType = StockMngFacade.class,bindings = { @SofaServiceBinding(bindingType = "bolt")})
public class StockMngImpl implements StockMngFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(StockMngImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Resource
    private StockMngMapper stockMngMapper;

    @SofaReference(interfaceType = BalanceMngFacade.class, binding = @SofaReferenceBinding(bindingType = "bolt"))
    private BalanceMngFacade balanceMngFacade;

    @Override
    public List<ProductInfo> query(String userName){
        List<ProductInfo> productInfos = stockMngMapper.query(userName);
        if (productInfos == null){
            throw new RuntimeException("userName is not exits");
        }
        return productInfos;
    }

    /**
     *
     * 购买商品
     */
    @Override
    public void purchase(String userName, String productCode, int count){
        Integer productPrice = stockMngMapper.queryProductPrice(productCode);
        if (productPrice == null){
            throw new RuntimeException("productCode is not exits");
        }
        balanceMngFacade.minusBalance(userName, productPrice * count);
        stockMngMapper.purchase(userName, productCode, count);
    }

/**
    @Override
    public void minusStock(String productCode, int count) {
        LOGGER.info("minus Stock begin ...");
        LOGGER.info("minus Stock SQL: update stock_tb set count = count - {} where product_code = {}", count, productCode);

        jdbcTemplate.update("update stock_tb set count = count - ? where product_code = ?", new Object[] {count, productCode});
        LOGGER.info("minus Stock end");
    }
 */

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
