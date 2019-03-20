package cn.bdqn.itrip.pojo;

/**
 * 原始库存类
 */
public class RawStock {
    private Integer id;             //编号
    private Integer productType;    //商品类型(0-旅游产品 1-酒店产品 2-机票产品)
    private Integer productId;      //商品id
    private Integer stock;          //库存

    public RawStock() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "RawStock{" +
                "id=" + id +
                ", productType=" + productType +
                ", productId=" + productId +
                ", stock=" + stock +
                '}';
    }
}
