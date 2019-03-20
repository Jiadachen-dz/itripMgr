package cn.bdqn.itrip.controller;

import cn.bdqn.itrip.pojo.Hotel;
import cn.bdqn.itrip.pojo.RoomType;
import cn.bdqn.itrip.service.RoomsService;
import cn.bdqn.itrip.utils.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/rooms")
public class RoomsController {
    @Resource
    private RoomsService roomsService;

    @RequestMapping(value = "/findRoomsByHotelId")
    private String findRoomsByHotelId(@RequestParam(value = "hotelId") Integer hotelId, Model model,
                                      @RequestParam(value = "pageIndex",required = false ,defaultValue = "1") Integer pageIndex,
                                      @RequestParam(value = "pageSize",required = false,defaultValue = "2") Integer pageSize){
        System.out.println("酒店id========="+hotelId);
        PageBean<RoomType> pageBean = roomsService.findRoomTypeByHotelId(hotelId, pageIndex, pageSize);
        if (pageBean!=null){
            //查酒店信息（需要酒店名字）
            Hotel hotel = roomsService.findHotelByhotelId(hotelId);
            model.addAttribute("hotel",hotel);
            model.addAttribute("pageBean",pageBean);
            model.addAttribute("hotelId",hotelId);
            System.out.println(pageBean);
            return "rooms";
        }
        return "hotel";
    }
}
