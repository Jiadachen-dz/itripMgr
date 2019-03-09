package cn.bdqn.itrip.controller;

import cn.bdqn.itrip.pojo.RoomType;
import cn.bdqn.itrip.service.RoomsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/rooms")
public class RoomsController {
    @Resource
    private RoomsService roomsService;

    @RequestMapping(value = "/findRoomsByHotelId")
    private String findRoomsByHotelId(@RequestParam(value = "hotelId") Integer hotelId, Model model){
        System.out.println("11111111111");
        List<RoomType> roomTypeList = roomsService.findRoomTypeByHotelId(hotelId);
        model.addAttribute("rooms",roomTypeList);
        System.out.println(roomTypeList);
        if (roomTypeList!=null){
            return "rooms";
        }
        return "hotel";
    }
}
