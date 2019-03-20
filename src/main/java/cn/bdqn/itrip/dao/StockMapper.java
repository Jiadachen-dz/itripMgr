package cn.bdqn.itrip.dao;

import cn.bdqn.itrip.pojo.RawStock;
import cn.bdqn.itrip.pojo.RealTimeStock;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface StockMapper {

    /**
     * @param roomId     房间id
     * @param recordDate 登记入住时间
     * @return 查询出实时库存
     */
    RealTimeStock queryRealTimeStock(Integer roomId, Date recordDate);

    /**
     * @param realTimeStock 实时库存表
     * @return 保存实时库存
     */
    int saveRealTimeStock(RealTimeStock realTimeStock);

    /**
     * @param roomId     房间id
     * @param recordDate 登记入住时间
     * @param roomNum    房间数量
     * @return 修改实时库存数量
     */
    int updateRealTimeStock(Integer roomId, Date recordDate, Integer roomNum);

    /**
     * 根据商品类型和商品id查询原始库存
     *
     * @param productType 商品类型
     * @param productId   商品id
     * @return
     */
    RawStock queryRawStock(@Param(value = "productType") Integer productType, @Param(value = "productId") Integer productId);
}
