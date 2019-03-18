package cn.bdqn.itrip.controller;

import cn.bdqn.itrip.pojo.Country;
import cn.bdqn.itrip.pojo.Hotel;
import cn.bdqn.itrip.service.HotelService;
import cn.bdqn.itrip.utils.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
     * @param request
     * @param hotelLevel
     * @param hotelName
     * @param countryId
     * @return  按照特定条件显示出筛选的酒店
     */
    @RequestMapping(value = "/getHotelList")
    private String getHost(HttpServletRequest request,Model model,
                           @RequestParam(value = "hotelLevel",required = false) Integer hotelLevel,
                           @RequestParam(value = "hotelName",required = false) String hotelName,
                           @RequestParam(value = "countryId",required = false) Integer countryId,
                           @RequestParam(value = "pageIndex",required = false ,defaultValue = "1") Integer pageIndex,
                           @RequestParam(value = "pageSize",required = false,defaultValue = "8") Integer pageSize){

        PageBean<Hotel> pageBean = hotelService.findHotelList(hotelLevel, hotelName, countryId,pageIndex,pageSize);
        List<Country> countryList = hotelService.findCountryList();

        request.setAttribute("countryList",countryList);
        request.setAttribute("pageBean",pageBean);
        request.setAttribute("countryId",countryId);
        model.addAttribute("hotelLevel",hotelLevel);
        System.out.println("hotelLevel==="+hotelLevel);
        System.out.println(pageBean.getList());
        return "search";

    }



}
