package cn.bdqn.itrip.service;

import cn.bdqn.itrip.pojo.Country;
import cn.bdqn.itrip.pojo.Hotel;
import cn.bdqn.itrip.utils.PageBean;

import java.util.List;

public interface HotelService {


    /**
     *
     * @return分页查询按照特定条件显示出筛选的酒店
     */
    PageBean<Hotel> findHotelList(Integer hotelLevel, String hotelName, Integer countryId, Integer pageIndex, Integer pageSize);

    /**
     *
     *
     * @return 遍历国家获得id
     */
    List<Country> findCountryList();

}

