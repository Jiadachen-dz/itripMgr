package cn.bdqn.itrip.service;

import cn.bdqn.itrip.pojo.User;

public interface UserService {
    /**
     * 通过UserCode查找用户（登录）getUserByUserCode
     * @return
     */
    User login(String userCode,String password);

    /**
     * 通过异步请求 验证 邮箱或手机是否已被注册
     * @param userCode  邮箱或手机
     * @return
     */
    User findUserByUserCode(String userCode);

    /**
     * 注册
     * @param userCode  手机号/邮箱
     * @param nickName  昵称
     * @param password  密码
     * @return  返回数据库受影响行数
     */
    int register(String userCode,String nickName,String password);

    /**
     * 激活帐号（修改用户状态）
     * @param userCode  邮箱或手机
     * @return
     */
    int updateStatus(String userCode);
}
