package cn.bdqn.itrip.service.impl;

import cn.bdqn.itrip.dao.OrderMapper;
import cn.bdqn.itrip.pojo.Order;
import cn.bdqn.itrip.pojo.RoomType;
import cn.bdqn.itrip.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;


    @Override
    public RoomType findRoomInfo(Integer id) {
        return orderMapper.getRoomInfo(id);
    }

    @Override
    public int addOrder(Order order) {
        return orderMapper.addOrder(order);
    }
}
