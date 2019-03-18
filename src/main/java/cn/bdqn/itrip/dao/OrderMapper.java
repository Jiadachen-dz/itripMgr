package cn.bdqn.itrip.dao;

import cn.bdqn.itrip.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    /**
     * 保存订单
     * @param order
     * @return
     */
    int saveOrder(Order order);

    /**
     * 根据特定条件查询订单列表
     * @param orderNo 订单号
     * @param linkUserName 旅客
     * @param checkInDate 入住日期
     * @param checkOutDate 离开日期
     * @param orderStatus 订单状态
     * @param pageSize 页面容量
     * @param startRow 起始行
     * @return
     */
    List<Order> queryOrders(@Param(value = "userId") Integer userId, @Param(value = "orderNo") String orderNo, @Param(value = "linkUserName") String linkUserName, @Param(value = "checkInDate") String checkInDate, @Param(value = "checkOutDate") String checkOutDate, @Param(value = "orderStatus") Integer orderStatus, @Param(value = "pageSize") Integer pageSize, @Param(value = "startRow") Integer startRow);

    /**
     * 根据特定条件查询订单记录数
     * @param order
     * @return
     */
    int queryOrdersCount(Order order);

    /**
     * 修改订单状态
     * @param id 订单编号
     * @return
     */
    int modifyOrderStatus(@Param(value = "id") Integer id, @Param(value = "orderStatus") Integer orderStatus);
}
