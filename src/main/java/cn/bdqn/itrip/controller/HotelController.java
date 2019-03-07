package cn.bdqn.itrip.controller;

import cn.bdqn.itrip.pojo.Hotel;
import cn.bdqn.itrip.service.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/hotel")
public class HotelController {
    @Resource
    private HotelService hotelService;

    /**
     *
     *
     * @param request 遍历出酒店页面信息
     * @return
     */
    @RequestMapping(value = "/getHostList")
    private String getHostList( HttpServletRequest request){
        List<Hotel> hotelList = hotelService.findHotelAll();
        request.setAttribute("hotelList",hotelList);

        return "booking";
    }

    @RequestMapping(value = "/findHost")
    private String findHost() {
        return "booking";
    }

}