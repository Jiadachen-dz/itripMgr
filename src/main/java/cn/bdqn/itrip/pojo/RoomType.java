package cn.bdqn.itrip.pojo;

import java.util.Date;

/**
 * 房型类
 */
public class RoomType {
    private Integer id;                 //编号
    private Integer hotelId;            //酒店编号
    private Integer roomBedTypeId;      //房间床型
    private Integer isHavingBreakfast;  //是否有早餐
    private Integer payType;            //支付类型 1-在线付 2-到店付 3-不限
    private Integer isBook;             //是否预定
    private Integer isCancel;           //是否取消
    private Integer isTimelyResponse;   //是否及时确认
    private Integer createdBy;          //创建人
    private Integer modifiedBy;         //修改人
    private String roomTitle;           //房间标题
    private Double roomPrice;           //房间价格
    private Double satisfaction;        //满意度
    private Date creationDate;          //创建时间
    private Date modifyDate;            //修改时间

    /**
     * 酒店
     */
    private Hotel hotel;
    public RoomType() {
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getRoomBedTypeId() {
        return roomBedTypeId;
    }

    public void setRoomBedTypeId(Integer roomBedTypeId) {
        this.roomBedTypeId = roomBedTypeId;
    }

    public Integer getIsHavingBreakfast() {
        return isHavingBreakfast;
    }

    public void setIsHavingBreakfast(Integer isHavingBreakfast) {
        this.isHavingBreakfast = isHavingBreakfast;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getIsBook() {
        return isBook;
    }

    public void setIsBook(Integer isBook) {
        this.isBook = isBook;
    }

    public Integer getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(Integer isCancel) {
        this.isCancel = isCancel;
    }

    public Integer getIsTimelyResponse() {
        return isTimelyResponse;
    }

    public void setIsTimelyResponse(Integer isTimelyResponse) {
        this.isTimelyResponse = isTimelyResponse;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getRoomTitle() {
        return roomTitle;
    }

    public void setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
    }

    public Double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(Double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public Double getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(Double satisfaction) {
        this.satisfaction = satisfaction;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public String toString() {
        return "RoomType{" +
                "id=" + id +
                ", hotelId=" + hotelId +
                ", roomBedTypeId=" + roomBedTypeId +
                ", isHavingBreakfast=" + isHavingBreakfast +
                ", payType=" + payType +
                ", isBook=" + isBook +
                ", isCancel=" + isCancel +
                ", isTimelyResponse=" + isTimelyResponse +
                ", createdBy=" + createdBy +
                ", modifiedBy=" + modifiedBy +
                ", roomTitle='" + roomTitle + '\'' +
                ", roomPrice=" + roomPrice +
                ", satisfaction=" + satisfaction +
                ", creationDate=" + creationDate +
                ", modifyDate=" + modifyDate +
                '}';
    }
}
