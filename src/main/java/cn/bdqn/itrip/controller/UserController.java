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
        if (user != null) {
            //帐号未激活
            if (user.getStatus() != 1) {
                request.setAttribute("msg", "该帐号尚未激活!");
            } else {
                session.setAttribute("loginUser", user);
//            System.out.println((User)session.getAttribute("loginUser"));
                return "index";
            }
        } else {
            //登录失败
            request.setAttribute("msg", "用户名或密码不正确！");
        }


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
    public Object findUserByUserCode(@RequestParam(value = "userCode",required = false) String userCode,
                                     @RequestParam(value = "phone_userCode",required = false) String phone_userCode,
                                     HttpServletRequest request){
        System.out.println("验证邮箱/手机是否已被注册！");
        Map<String,Object> map = new HashMap<String,Object>();
        if (userCode!=null){
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
        }else {
            if (phone_userCode==null || "".equals(phone_userCode.trim())){
                map.put("phone_userCode","empty");
                return ToJsonUtil.toJson(map);
            }
            User user = userService.findUserByUserCode(userCode);
            if (user!=null){
                map.put("phone_userCode","exist");
//            request.setAttribute("tips","该用户可用");
            }else {
                map.put("phone_userCode","noExist");
            }
        }

//        request.setAttribute("tips","该用户已被注册，请更换用户");
//        System.out.println(map.get("userCode"));
        System.out.println(ToJsonUtil.toJson(map));
        return ToJsonUtil.toJson(map);
    }

    /**
     * 邮箱注册
     * @param userCode  邮箱
     * @param nickName  昵称
     * @param password  密码
     * @param request
     * @return
     */
    @RequestMapping(value = "doRegister.html")
    public String doRegister(@RequestParam("userCode") String userCode,
                           @RequestParam("nickName") String nickName,
                           @RequestParam("password") String password,
                           HttpServletRequest request,
                             HttpSession session){
        System.out.println(userCode+nickName+password);
            //MD5加密（密码加密）
            String passwordMd5 = EncryptionUtil.md5Encryption(password);
            int count = userService.register(userCode, nickName, passwordMd5);
            if (count>0){
                //为注册用户生成激活码
                String activeCode = UuidUtils.randomUUID()+ Calendar.getInstance().getTimeInMillis();
                session.setAttribute(userCode,activeCode);
                //发送邮箱
                SendEmail.send(userCode,activeCode,jms);
                request.setAttribute("msg","注册成功，请激活账号！");
                return "activation";
            }
            request.setAttribute("msg","注册失败,请重新注册！");
            return "register";
        }

    /**
     * 手机注册
     * @param phone_userCode  手机号
     * @param phone_nickName  昵称
     * @param phone_password  密码
     * @param request
     * @param session
     * @return
     */
    @RequestMapping(value = "doRegisterByPhone.html")
    public String doRegisterByPhone(@RequestParam("phone_userCode") String phone_userCode,
                             @RequestParam("phone_nickName") String phone_nickName,
                             @RequestParam("phone_password") String phone_password,
                             HttpServletRequest request,
                             HttpSession session){
        System.out.println("phone_userCode的值"+phone_userCode);
        String phone=phone_userCode;
        String nickName=phone_nickName;
        String password=phone_password;
        //MD5加密（密码加密）
        String passwordMd5 = EncryptionUtil.md5Encryption(password);
        int count = userService.register(phone, nickName, passwordMd5);
        if (count>0){
            //为注册用户生成验证码
            String activeCode = null;

            session.setAttribute(phone,activeCode);
            //发送验证码
            request.setAttribute("phone_msg","注册成功，请激活账号！");
            return "activation";
        }
        request.setAttribute("phone_msg","注册失败,请重新注册！");
        return "register";
    }
    /**
     * 异步验证帐号是否已激活
     * @param userCode   页面输入的帐号
     * @return
     */
    @RequestMapping(value = "/findActivation.json")
    @ResponseBody
    public Object findActivation(@RequestParam("userCode") String userCode){
        Map<String,Object> map = new HashMap<String,Object>();
        if (userCode==null || "".equals(userCode.trim())){
            map.put("userCode","empty");
            return ToJsonUtil.toJson(map);
        }
        User user = userService.findUserByUserCode(userCode);
        if (user!=null){     //判断用户是否存在
            if (user.getStatus()==1){     //已激活
                map.put("userCode","activated");
            }else {     //未激活
                map.put("userCode","notActive");
            }
        }else {
            map.put("userCode","noExist");
        }
        System.out.println(map.get("userCode"));
        System.out.println(ToJsonUtil.toJson(map));
        return ToJsonUtil.toJson(map);
    }

    /**
     * 激活帐号
     * @param userCode     用户
     * @param activationCode  页面输入的激活码
     * @param request
     * @return
     */
    @RequestMapping(value = "doActivateAccount.html")
    public String doActivateAccount(@RequestParam("userCode") String userCode,
                                  @RequestParam("activationCode")String activationCode,
                                    HttpServletRequest request,HttpSession session){

        Map<String,Object> map = new HashMap<String,Object>();

        //判断激活码是否正确
        System.out.println(activationCode);
        String activeCode = (String) session.getAttribute(userCode);
        System.out.println("验证激活码："+activeCode);
        if (activationCode.equals(activeCode)){
            //激活
            int count = userService.updateStatus(userCode);
            if (count>0){
                request.setAttribute("atMsg","激活成功！");
                return "login";
            }
            //激活失败
            request.setAttribute("atMsg","激活失败，激活码有误！");
            return "activation";
        }
        //激活失败
        request.setAttribute("atMsg","激活有误！");
        return "activation";
    }

}
