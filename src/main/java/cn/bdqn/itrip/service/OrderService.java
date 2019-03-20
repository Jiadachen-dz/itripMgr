package cn.bdqn.itrip.service;

import cn.bdqn.itrip.pojo.Order;
import cn.bdqn.itrip.pojo.RoomType;


public interface OrderService {
    /**
     *
     * @param房间id
     * @return根据特定条件查找房间信息
     */

    RoomType findRoomInfo(Integer id);

    /**
     *
     * @param order 订单表
     * @return保存订单信息
     */
    int addOrder(Order order);
}

