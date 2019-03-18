package cn.bdqn.itrip.pojo;


import java.util.Date;

/**
 * 住客类
 */
public class Guest {
    private Integer id;         //编号
    private String guestName;   //住客姓名
    private String idCard;      //身份证
    private String guestPhone;  //住客手机
    private Integer userId;     //用户id
    private Integer createdBy;  //创建人
    private Date creationDate;  //创建时间
    private Integer modifiedBy; //修改人
    private Date modifyDate;    //修改时间

    public Guest() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getGuestPhone() {
        return guestPhone;
    }

    public void setGuestPhone(String guestPhone) {
        this.guestPhone = guestPhone;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        return "Guest{" +
                "id=" + id +
                ", guestName='" + guestName + '\'' +
                ", idCard='" + idCard + '\'' +
                ", guestPhone='" + guestPhone + '\'' +
                ", userId=" + userId +
                ", createdBy=" + createdBy +
                ", creationDate=" + creationDate +
                ", modifiedBy=" + modifiedBy +
                ", modifyDate=" + modifyDate +
                '}';
    }
}
