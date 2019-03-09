package cn.bdqn.itrip.dao;

import cn.bdqn.itrip.pojo.Hotel;
import cn.bdqn.itrip.pojo.RoomType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomsMapper {
    /**
     * 通过酒店id查酒店的所有房间
     * @param hotelId  酒店id
     * @return
     */
    List<RoomType> getRoomTypeByHotelId(@Param("hotelId") Integer hotelId);

    /**
     * 通过酒店id查找酒店信息
     * @param hotelId  酒店id
     * @return
     */
    Hotel getHotelByhotelId(@Param("hotelId") Integer hotelId);
}
