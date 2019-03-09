package cn.bdqn.itrip.service;

import cn.bdqn.itrip.pojo.RoomType;
import cn.bdqn.itrip.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomsService {

    /**
     * 通过酒店id查酒店的房间
     * @param hotelId  酒店id
     * @return
     */
    List<RoomType> findRoomTypeByHotelId(Integer hotelId);

}
