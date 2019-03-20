package cn.bdqn.itrip.dao;

import cn.bdqn.itrip.pojo.Order;
import cn.bdqn.itrip.pojo.RoomType;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    /**
     *
     * @param id 房间id
     * @return房间信息列表
     */
    RoomType getRoomInfo(@Param(value = "id") Integer id);


    /**
     *
     * @param order 订单表
     * @return保存订单信息
     */
    int addOrder(Order order);
}