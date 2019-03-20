package cn.bdqn.itrip.pojo;

import java.util.Date;

/**
 * 实时库存类
 */
public class RealTimeStock {
    private Integer id;         //编号
    private Integer roomId;     //房间id
    private Date recordDate;    //记录日期
    private Integer stock;      //库存
    private Integer createdBy;  //创建者
    private Date creationDate;  //创建时间

    public RealTimeStock() {
    }

    public RealTimeStock(Integer roomId, Date recordDate, Integer stock) {
        this.roomId = roomId;
        this.recordDate = recordDate;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
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

    @Override
    public String toString() {
        return "RealTimeStock{" +
                "id=" + id +
                ", roomId=" + roomId +
                ", recordDate=" + recordDate +
                ", stock=" + stock +
                ", createdBy=" + createdBy +
                ", creationDate=" + creationDate +
                '}';
    }
}
