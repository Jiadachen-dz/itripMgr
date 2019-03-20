package cn.bdqn.itrip.dao;

import cn.bdqn.itrip.pojo.Hotel;
import cn.bdqn.itrip.pojo.RoomType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomsMapper {
    /**
     * 通过酒店id查酒店的所有房间(分页查询)
     * @param hotelId  酒店id
     * @param startRow   起始行
     * @param pageSize   页面容量
     * @return    返回酒店房间集合
     */
    List<RoomType> getRoomTypeByHotelId(@Param("hotelId") Integer hotelId,
                                        @Param(value = "startRow") Integer startRow,
                                        @Param(value = "pageSize") Integer pageSize);

    /**
     * 通过该酒店id查找该酒店房间的总数
     * @param hotelId  酒店id
     * @return  返回该酒店总房间数
     */
    int count(@Param("hotelId") Integer hotelId);

    /**
     * 通过酒店id查找酒店信息
     * @param id  酒店id
     * @return
     */
    Hotel getHotelByhotelId(@Param("id") Integer id);
}
