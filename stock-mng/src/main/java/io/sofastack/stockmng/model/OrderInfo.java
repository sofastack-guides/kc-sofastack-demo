package io.sofastack.stockmng.model;

/**
 * @author: guolei.sgl (guolei.sgl@antfin.com) 2019/6/12 9:18 PM
 * @since:
 **/
public class OrderInfo {
    private int id;
    private String userName;
    private String productCode;
    private int count;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
