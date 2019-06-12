package io.sofastack.stockmng.model;

import java.math.BigDecimal;

public class ProductInfo {

    private String  productCode;
    private BigDecimal price;
    private String  name;
    private Integer ownedCount;
    private Integer stockCount;
    private String description;

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOwnedCount() {
        return ownedCount;
    }

    public void setOwnedCount(Integer ownedCount) {
        this.ownedCount = ownedCount;
    }
}
