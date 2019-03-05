package cn.bdqn.itrip.controller;

import cn.bdqn.itrip.pojo.User;
import cn.bdqn.itrip.service.UserService;
import cn.bdqn.itrip.utils.EncryptionUtil;
import cn.bdqn.itrip.utils.SendEmail;
import cn.bdqn.itrip.utils.ToJsonUtil;
import cn.bdqn.itrip.utils.UuidUtils;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "user")
public class UserController {
    @Resource
    private UserService userService;

    @Resource
    JavaMailSender jms;

    /**
     * 登录
     * （登录前判断帐号是否激活，未激活则给出提示）
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
            //帐号未激活
            if (user.getStatus()!=1){
                request.setAttribute("statusMsg","该帐号尚未激活!");
            }
            session.setAttribute("loginUser",user);
//            System.out.println((User)session.getAttribute("loginUser"));
                return "index";
            }
            //登录失败
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
     * 异步验证手机/邮箱是否已被注册
     * @param userCode
     * @param request
     * @return
     */
    @RequestMapping(value = "/findUserByUserCode.json")
    @ResponseBody
    public Object findUserByUserCode(@RequestParam("userCode") String userCode,
                                     HttpServletRequest request){
        System.out.println("验证邮箱/手机是否已被注册！");
        Map<String,Object> map = new HashMap<String,Object>();
        if (userCode==null || "".equals(userCode.trim())){
            map.put("userCode","empty");
            return ToJsonUtil.toJson(map);
        }
        User user = userService.findUserByUserCode(userCode);
        if (user!=null){
            map.put("userCode","exist");
//            request.setAttribute("tips","该用户可用");
        }else {
            map.put("userCode","noExist");
        }
//        request.setAttribute("tips","该用户已被注册，请更换用户");
        System.out.println(map.get("userCode"));
        System.out.println(ToJsonUtil.toJson(map));
        return ToJsonUtil.toJson(map);
    }

    /**
     * 注册
     * @param userCode  邮箱/手机
     * @param nickName  昵称
     * @param password  密码
     * @param request
     * @return
     */
    @RequestMapping(value = "doRegister.html")
    public String doRegister(@RequestParam("userCode") String userCode,
                           @RequestParam("nickName") String nickName,
                           @RequestParam("password") String password,
                           HttpServletRequest request){
        System.out.println(userCode+nickName+password);
            //MD5加密（密码加密）
            String passwordMd5 = EncryptionUtil.md5Encryption(password);
            int count = userService.register(userCode, nickName, passwordMd5);
            if (count>0){
                //为注册用户生成激活码
                String activeCode = UuidUtils.randomUUID()+ Calendar.getInstance().getTimeInMillis();
                System.out.println("邮箱激活码："+activeCode);
                //发送邮箱
                SendEmail.send(userCode,activeCode,jms);
                request.setAttribute("msg","注册成功，请登录！");
                return "login";
            }
            request.setAttribute("msg","注册失败,请重新注册！");
            return "register";
        }

    /**
     * 激活帐号
     * @param userCode     用户
     * @param activationCode  页面输入的激活码
     * @param request
     * @return
     */
    @RequestMapping(value = "activateAccount.html")
    public String activateAccount(@RequestParam("userCode") String userCode,
                                  @RequestParam("activationCode")String activationCode,
                                    HttpServletRequest request){
        //判断激活码是否正确
        if (!activationCode.equals("activeCode")){
            request.setAttribute("msg","激活失败，激活码有误！");
            return "fail";
        }
        //激活
        int count = userService.updateStatus(userCode);
        if (count>0){
            request.setAttribute("msg","激活成功！");
            return "success";
        }
        //激活失败
        request.setAttribute("msg","激活失败！");
        return "fail";
    }

}
