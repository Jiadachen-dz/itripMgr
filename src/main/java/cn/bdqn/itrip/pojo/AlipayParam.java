package cn.bdqn.itrip.pojo;

/**
 * 支付参数
 */
public class AlipayParam{
    private String orderId;     //订单编号
    private String orderName;   //订单名称
    private Double amount;      //金额

    public AlipayParam() {
    }

    public AlipayParam(String orderId, String orderName, Double amount) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "AlipayParam{" +
                "orderId='" + orderId + '\'' +
                ", orderName='" + orderName + '\'' +
                ", amount=" + amount +
                '}';
    }
}
