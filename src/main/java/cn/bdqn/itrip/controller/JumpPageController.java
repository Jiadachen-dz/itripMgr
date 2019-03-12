package cn.bdqn.itrip.controller;

import cn.bdqn.itrip.utils.SendEmail;
import cn.bdqn.itrip.utils.UuidUtils;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Calendar;

@Controller
@RequestMapping(value = "/jump")
public class JumpPageController {
    @Resource
    JavaMailSender jms;

    //跳转到首页
    @RequestMapping(value = "/jumpHome")
    private String jumpHome(){
        return "index";
    }

    //跳转到酒店页面
    @RequestMapping(value = "/jumpHotel")
    private String jumpHotel(){
        return "booking";
    }

    //跳转到联系页面
    @RequestMapping(value = "/jumpContact")
    private String jumpContact(){
        return "contact";
    }

    //跳转到旅游页面
    @RequestMapping(value = "/jumpDestination")
    private String jumpDestination(){
        return "destination";
    }

    //跳转到机票页面
    @RequestMapping(value = "/jumpPayment")
    private String jumpPayment(){
        return "payment";
    }

    //跳转到机票搜索页面
    @RequestMapping(value = "/jumpSearch")
    private String jumpSearch(){
        return "search";
    }

    //跳转到登录界面
    @RequestMapping(value = "/jumpLogin")
    private String jumpLogin(){
        return "login";
    }

    //跳转到注册页面
    @RequestMapping(value = "/jumpRegister")
    private String jumpRegister(){
        return "register";
    }
    //跳转到激活页面
    @RequestMapping(value = "/jumpActivation")
    private String jumpActivation(){
        return "activation";
    }



    //跳转到激活页面（登录成功后的激活）
    @RequestMapping(value = "/jumpReActivation")
    private String jumpReActivation(@RequestParam(value = "userCode",required = false) String userCode,
                                    HttpSession session){
        if (userCode!="" && userCode!=null){
            //为注册用户生成激活码
            String activeCode = UuidUtils.randomUUID()+ Calendar.getInstance().getTimeInMillis();
            session.setAttribute(userCode,activeCode);
            //发送邮箱
            SendEmail.send(userCode,activeCode,jms);
        }
        return "activation";
    }

    //跳转到房间页面
    @RequestMapping(value = "/jumpRooms")
    private String jumpRooms(){
        return "rooms";
    }

    //跳转到订单页面
    @RequestMapping(value = "/jumpReservation")
    private String jumpReservation(){
        return "reservation";
    }
}
