package cn.bdqn.itrip.pojo;

/**
 * 支付订单参数
 */
public class AlipayOrderParam {
    private String out_trade_no;//商户订单号
    private String product_code;//销售产品码
    private Double total_amount;//总金额
    private String subject;//订单标题
    private String timeout_express;//该笔订单允许的最晚付款时间，逾期将关闭交易
    private String passback_params;//公共校验参数

    public AlipayOrderParam() {
    }

    public AlipayOrderParam(String out_trade_no, String product_code, Double total_amount, String subject, String timeout_express, String passback_params) {
        this.out_trade_no = out_trade_no;
        this.product_code = product_code;
        this.total_amount = total_amount;
        this.subject = subject;
        this.timeout_express = timeout_express;
        this.passback_params = passback_params;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public Double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Double total_amount) {
        this.total_amount = total_amount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTimeout_express() {
        return timeout_express;
    }

    public void setTimeout_express(String timeout_express) {
        this.timeout_express = timeout_express;
    }

    public String getPassback_params() {
        return passback_params;
    }

    public void setPassback_params(String passback_params) {
        this.passback_params = passback_params;
    }

    @Override
    public String toString() {
        return "AlipayOrderParam{" +
                "out_trade_no='" + out_trade_no + '\'' +
                ", product_code='" + product_code + '\'' +
                ", total_amount='" + total_amount + '\'' +
                ", subject='" + subject + '\'' +
                ", timeout_express='" + timeout_express + '\'' +
                ", passback_params='" + passback_params + '\'' +
                '}';
    }
}
