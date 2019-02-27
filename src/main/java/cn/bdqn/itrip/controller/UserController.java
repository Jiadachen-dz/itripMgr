package cn.bdqn.itrip.controller;

import cn.bdqn.itrip.pojo.User;
import cn.bdqn.itrip.service.UserService;
import cn.bdqn.itrip.utils.EncryptionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 登录
     * @param userCode  邮箱或者手机
     * @param password   密码
     * @param session
     * @param request
     * @return
     */
    @RequestMapping(value = "/doLogin.html")
    private String doLogin(@RequestParam("userCode") String userCode,
                           @RequestParam("password") String password,
                           HttpSession session, HttpServletRequest request){
        //给密码加密（md5加密）调用加密工具类
        String passwordTemp = EncryptionUtil.md5Encryption(password);
        User user = userService.login(userCode,passwordTemp);
        //登录成功
        if (user!=null){
            session.setAttribute("loginUser",user);
//            System.out.println((User)session.getAttribute("loginUser"));
                System.out.println("11111111");
                return "index";
            }
            //登录失败
            System.out.println("222222");
            request.setAttribute("msg","用户名或密码不正确！");
            return "login";
    }

    /**
     * 注销
     * @param request
     * @param session
     * @return
     */
    @RequestMapping(value = "logout.html")
    public String logout(HttpServletRequest request,HttpSession session){
        //移出session中的值
        session.removeAttribute("loginUser");
        request.setAttribute("msg","注销成功!");
        return "login";
    }

    /**
     * 注册
     * @param userCode  邮箱/手机
     * @param nickname  昵称
     * @param password  密码
     * @param request
     * @return
     */
    @RequestMapping(value = "doRegister.html")
    public String doRegister(@RequestParam("userCode") String userCode,
                           @RequestParam("nickname") String nickname,
                           @RequestParam("password") String password,
                           @RequestParam("agreement") String agreement,
                           HttpServletRequest request){
            //MD5加密（密码加密）
            String passwordMd5 = EncryptionUtil.md5Encryption(password);
            int count = userService.register(userCode, nickname, passwordMd5);
            if (count>0){
                request.setAttribute("msg","注册成功，请登录！");
                System.out.println("注册成功!");
                return "login";
            }
            request.setAttribute("msg","注册失败,请重新注册！");
            System.out.println("注册失败!");
            return "register";

    }
}
