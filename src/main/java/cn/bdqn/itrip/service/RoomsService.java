package cn.bdqn.itrip.service;

import cn.bdqn.itrip.pojo.Hotel;
import cn.bdqn.itrip.pojo.RoomType;
import cn.bdqn.itrip.utils.PageBean;


public interface RoomsService {
    /**
     * 通过酒店id查酒店的房间(分页查询)
     * @param hotelId  酒店id
     * @param pageIndex  当前页码
     * @param pageSize  页面容量
     * @return
     */
    PageBean<RoomType> findRoomTypeByHotelId(Integer hotelId,Integer pageIndex, Integer pageSize);

    /**
     * 通过酒店id查找酒店信息
     * @param hotelId  酒店id
     * @return
     */
    Hotel findHotelByhotelId(Integer hotelId);
}
