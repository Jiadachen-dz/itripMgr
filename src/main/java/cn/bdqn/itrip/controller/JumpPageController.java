package cn.bdqn.itrip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/jump")
public class JumpPageController {
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
}
