package io.sofastack.stockmng.type;

public class ProductInfo {

    private String  productCode;
    private int     price;
    private String  name;
    private Integer ownedCount;

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
