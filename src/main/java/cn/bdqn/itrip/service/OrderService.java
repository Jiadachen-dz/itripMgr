package cn.bdqn.itrip.service;

import cn.bdqn.itrip.pojo.Order;
import cn.bdqn.itrip.utils.PageBean;

public interface OrderService {
    /**
     * 添加订单
     * @param order
     * @return
     */
    int addOrder(Order order);

    /**
     * 开启任务调度
     * @param orderId 订单编号
     * @return
     */
    int startQuartz(Integer orderId);

    /**
     * 结束任务调度
     * @param orderId 订单编号
     * @return
     */
    int endQuartz(Integer orderId);

    /**
     * 入店时间开始任务调度
     * @param orderId 订单编号
     * @return
     */
    int checkInDateStartQuartz(Integer orderId, Integer days);

    /**
     * 根据特定条件查找订单列表
     * @param order 订单信息
     * @return
     */
    PageBean<Order> findOrders(Order order, Integer pageSize, Integer pageIndex);

    /**
     * 根据特定条件查找订单记录数
     * @param order
     * @return
     */
    int queryOrdersCount(Order order);

    /**
     * 修改订单状态
     * @param id 订单编号
     * @return
     */
    int updateOrderStatus(Integer id, Integer orderStatus);

}
