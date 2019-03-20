package cn.bdqn.itrip.service;

import cn.bdqn.itrip.pojo.RawStock;
import cn.bdqn.itrip.pojo.RealTimeStock;

import java.util.Date;

public interface StockService {
    /**
     * 根据房间id和记录日期查找实时库存
     * @param roomId 房间id
     * @param recordDate 记录日期
     * @return
     */
    RealTimeStock findRealTimeStock(Integer roomId, Date recordDate);

    /**
     * 保存实时库存
     * @param realTimeStock
     * @return
     */
    int saveRealTimeStock(RealTimeStock realTimeStock);

    /**
     * 根据商品类型和商品id查找原始库存
     * @param productType 商品类型
     * @param productId 商品id
     * @return
     */
    RawStock findRawStock(Integer productType, Integer productId);

    /**
     * 更新实时库存
     * @param roomId 房间id
     * @param recordDate 记录日期
     * @param roomNum 房间数量
     * @return
     */
    int updateRealTimeStock(Integer roomId, Date recordDate, Integer roomNum);
}
