package cn.bdqn.itrip.controller;

import cn.bdqn.itrip.service.StockService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping(value = "/stock")
public class StockController {
    @Resource
    private StockService stockService;


    @RequestMapping(value = "/toOrderFill")
    private String toOrderFill(  @RequestParam(value ="roomId" ) Integer  roomId,
                                 @RequestParam(value ="creationDate" )  Date recordDate ,
                                 @RequestParam(value ="creationDate" ) String  creationDate,
                                 @RequestParam(value ="modifyDate" )String modifyDate,
                                 HttpServletRequest request){


       return  "reservation";
    }




}
