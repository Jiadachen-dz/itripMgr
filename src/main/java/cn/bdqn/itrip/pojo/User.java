package cn.bdqn.itrip.pojo;

/**
 * 用户类
 */
public class User {
    private Integer id;         //编号
    private String userCode;    //用户名(邮箱或者手机)
    private String password;    //密码
    private String username;    //真实姓名
    private String nickname;    //昵称
    private String idCard;      //身份证
    private String mobile;      //手机
    private Integer status;     //激活状态

    public User() {
    }

    public User(String userCode, String password, String username, String nickname, String idCard, String mobile) {
        this.userCode = userCode;
        this.password = password;
        this.username = username;
        this.nickname = nickname;
        this.idCard = idCard;
        this.mobile = mobile;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userCode='" + userCode + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", idCard='" + idCard + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
