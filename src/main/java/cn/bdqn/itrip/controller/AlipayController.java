package cn.bdqn.itrip.controller;

import cn.bdqn.itrip.pojo.AlipayParam;
import cn.bdqn.itrip.service.AlipayService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 支付控制器
 */
@RestController
@RequestMapping(value = "/alipay")
public class AlipayController {
    @Resource
    private AlipayService alipayService;

    //1.申请付款
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String alipay(AlipayParam alipayParam, BindingResult result) {
        return alipayService.alipay(alipayParam);
    }

    //2.a1lipay支持同步返回地址
    @RequestMapping(value = "/getReturnUrlInfo", method = RequestMethod.GET)
    public String alipayReturnUrlInfo(HttpServletRequest request) {
        return alipayService.synchronous(request);
    }

    //3.alipay异步通知调用地址
    @RequestMapping(value = "/getNotifyUrlInfo", method = RequestMethod.POST)
    public void alipayNotifyUrlInfo(HttpServletRequest request, HttpServletResponse response) {
        alipayService.notify(request, response);
    }

}
