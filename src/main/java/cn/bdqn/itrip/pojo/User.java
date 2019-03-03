package cn.bdqn.itrip.pojo;

/**
 * 用户类
 */
public class User {
    private Integer id;         //编号
    private String userCode;    //用户名(邮箱或者手机)
    private String password;    //密码
    private String userName;    //真实姓名
    private String nickName;    //昵称
    private String idCard;      //身份证
    private String mobile;      //手机
    private Integer status;     //激活状态

    public User() {
    }

    public User(Integer id, String userCode, String password, String userName, String nickName, String idCard, String mobile, Integer status) {
        this.id = id;
        this.userCode = userCode;
        this.password = password;
        this.userName = userName;
        this.nickName = nickName;
        this.idCard = idCard;
        this.mobile = mobile;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userCode='" + userCode + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", idCard='" + idCard + '\'' +
                ", mobile='" + mobile + '\'' +
                ", status=" + status +
                '}';
    }
}
