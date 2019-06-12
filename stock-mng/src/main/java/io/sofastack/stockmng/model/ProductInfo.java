package io.sofastack.stockmng.model;

public class ProductInfo {

    private String  productCode;
    private int     price;
    private String  name;
    private Integer ownedCount;
    private String description;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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
