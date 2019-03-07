package cn.bdqn.itrip.pojo;

import java.util.Date;
import java.util.List;

/**
 * 酒店类
 */
public class Hotel {
    private Integer id;                 //编号
    private String hotelName;           //酒店名称
    private Integer countryId;          //酒店所在国家
    private Integer provinceId;         //酒店所在省份
    private Integer cityId;             //酒店所在城市
    private String address;             //酒店地址
    private String hotLine;             //酒店热线
    private String details;             //酒店详细信息
    private Integer hotelType;          //酒店类型
    private Integer hotelLevel;         //酒店级别
    private String facilities;          //酒店设施
    private String hotelPolicy;         //酒店政策
    private Integer isGroupPurchase;    //是否支持团购
    private Integer createdBy;          //创建人
    private Date creationDate;          //创建时间
    private Integer modifiedBy;         //修改人
    private Date modifyDate;            //修改时间
    private String imgSrc;              //酒店图片路径

    /**
     * 房间类型集合
     */
    private List<RoomType> roomTypes;
    /**
     * 最低价房间
     */
    private Double minPriceRoom;
    public Hotel() {
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", hotelName='" + hotelName + '\'' +
                ", countryId=" + countryId +
                ", provinceId=" + provinceId +
                ", cityId=" + cityId +
                ", address='" + address + '\'' +
                ", hotLine='" + hotLine + '\'' +
                ", details='" + details + '\'' +
                ", hotelType=" + hotelType +
                ", hotelLevel=" + hotelLevel +
                ", facilities='" + facilities + '\'' +
                ", hotelPolicy='" + hotelPolicy + '\'' +
                ", isGroupPurchase=" + isGroupPurchase +
                ", createdBy=" + createdBy +
                ", creationDate=" + creationDate +
                ", modifiedBy=" + modifiedBy +
                ", modifyDate=" + modifyDate +
                ", imgSrc='" + imgSrc + '\'' +
                '}';
    }

    public Double getMinPriceRoom() {
        return minPriceRoom;
    }

    public void setMinPriceRoom(Double minPriceRoom) {
        this.minPriceRoom = minPriceRoom;
    }

    public List<RoomType> getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(List<RoomType> roomTypes) {
        this.roomTypes = roomTypes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHotLine() {
        return hotLine;
    }

    public void setHotLine(String hotLine) {
        this.hotLine = hotLine;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getHotelType() {
        return hotelType;
    }

    public void setHotelType(Integer hotelType) {
        this.hotelType = hotelType;
    }

    public Integer getHotelLevel() {
        return hotelLevel;
    }

    public void setHotelLevel(Integer hotelLevel) {
        this.hotelLevel = hotelLevel;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public String getHotelPolicy() {
        return hotelPolicy;
    }

    public void setHotelPolicy(String hotelPolicy) {
        this.hotelPolicy = hotelPolicy;
    }

    public Integer getIsGroupPurchase() {
        return isGroupPurchase;
    }

    public void setIsGroupPurchase(Integer isGroupPurchase) {
        this.isGroupPurchase = isGroupPurchase;
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

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
}
