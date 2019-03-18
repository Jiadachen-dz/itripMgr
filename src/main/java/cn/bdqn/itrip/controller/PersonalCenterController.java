package cn.bdqn.itrip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 个人中心(订单查询)控制器
 */
@Controller
@RequestMapping(value = "/personalCenter")
public class PersonalCenterController {

    /**
     * 跳转到个人中心页面
     * /personalCenter/jumpPersonalCenter
     * @return
     */
    @RequestMapping(value = "/jumpPersonalCenter")
    private String jumpPersonalCenter(){
        return "personal-center";
    }


}
