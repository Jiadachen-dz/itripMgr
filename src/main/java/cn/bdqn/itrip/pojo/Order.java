package cn.bdqn.itrip.pojo;

import java.util.Date;

/**
 * 订单类
 */
public class Order {
    private Integer id;                 //编号
    private Integer userId;             //用户id
    private Integer orderType;          //订单类型(0-旅游产品 1-酒店产品 2-机票产品)
    private String orderNo;             //订单编号
    private String tradeNo;             //交易编号*
    private Integer roomId;             //房间id
    private Integer hotelId;             //酒店id
    private Integer count;              //预定房间数量
    private Long bookingDays;           //预定天数
    private String checkInDate;         //入住日期
    private String checkOutDate;        //退房日期
    private Integer orderStatus;        //订单状态(0-待支付 1-已取消 2-支付成功 3-已消费)
    private Double payAmount;           //支付金额
    private String noticePhone;         //联系电话
    private String linkUserName;        //联系人姓名
    private Integer createdBy;          //创建人
    private Date creationDate;          //创建时间
    private Integer modifiedBy;         //修改人
    private Date modifyDate;            //修改时间

    private String orderStatusName;     //订单状态名
    public Order() {
    }

    public Order(Integer userId, Integer orderType, String orderNo, String tradeNo, Integer roomId, Integer hotelId, Integer count, Long bookingDays, String checkInDate, String checkOutDate, Integer orderStatus, Double payAmount, String noticePhone, String linkUserName) {
        this.userId = userId;
        this.orderType = orderType;
        this.orderNo = orderNo;
        this.tradeNo = tradeNo;
        this.roomId = roomId;
        this.hotelId = hotelId;
        this.count = count;
        this.bookingDays = bookingDays;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.orderStatus = orderStatus;
        this.payAmount = payAmount;
        this.noticePhone = noticePhone;
        this.linkUserName = linkUserName;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderStatusName() {
        return orderStatusName;
    }

    public void setOrderStatusName(String orderStatusName) {
        this.orderStatusName = orderStatusName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Long getBookingDays() {
        return bookingDays;
    }

    public void setBookingDays(Long bookingDays) {
        this.bookingDays = bookingDays;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
    }

    public String getNoticePhone() {
        return noticePhone;
    }

    public void setNoticePhone(String noticePhone) {
        this.noticePhone = noticePhone;
    }


    public String getLinkUserName() {
        return linkUserName;
    }

    public void setLinkUserName(String linkUserName) {
        this.linkUserName = linkUserName;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderType=" + orderType +
                ", orderNo='" + orderNo + '\'' +
                ", tradeNo='" + tradeNo + '\'' +
                ", roomId=" + roomId +
                ", count=" + count +
                ", bookingDays=" + bookingDays +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", orderStatus=" + orderStatus +
                ", payAmount=" + payAmount +
                ", noticePhone='" + noticePhone + '\'' +
                ", linkUserName='" + linkUserName + '\'' +
                ", createdBy=" + createdBy +
                ", creationDate=" + creationDate +
                ", modifiedBy=" + modifiedBy +
                ", modifyDate=" + modifyDate +
                '}';
    }
}
