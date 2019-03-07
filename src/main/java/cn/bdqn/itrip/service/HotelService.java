package cn.bdqn.itrip.service;

import cn.bdqn.itrip.pojo.Hotel;

import java.util.List;

public interface HotelService {

    /**
     *
     * @return 返回需要查找的酒店
     */

    List<Hotel> findHotelAll();


    Hotel findHotel(Hotel hotel);

}

