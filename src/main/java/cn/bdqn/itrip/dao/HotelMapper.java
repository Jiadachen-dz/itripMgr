package cn.bdqn.itrip.dao;

import cn.bdqn.itrip.pojo.Hotel;

import java.util.List;

public interface HotelMapper {



    /**
     *
     * @return酒店所有信息
     */
    List<Hotel> getHotelAll ();

    /**
     *
     * @param hotel 酒店表
     * @return 酒店条件搜索
     */
    Hotel getHotel (Hotel hotel);

}
