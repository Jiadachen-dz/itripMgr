package cn.bdqn.itrip.service.impl;

import cn.bdqn.itrip.dao.StockMapper;
import cn.bdqn.itrip.pojo.RawStock;
import cn.bdqn.itrip.pojo.RealTimeStock;
import cn.bdqn.itrip.service.StockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class StockServiceImpl implements StockService {
    @Resource
    private StockMapper stockMapper;

    @Override
    public RealTimeStock findRealTimeStock(Integer roomId, Date recordDate) {
        return stockMapper.queryRealTimeStock(roomId,recordDate);
    }

    @Override
    public int saveRealTimeStock(RealTimeStock realTimeStock) {
        return stockMapper.saveRealTimeStock(realTimeStock);
    }

    @Override
    public RawStock findRawStock(Integer productType, Integer productId) {
        return stockMapper.queryRawStock(productType,productId);
    }

    @Override
    public int updateRealTimeStock(Integer roomId, Date recordDate, Integer roomNum) {
        return stockMapper.updateRealTimeStock(roomId,recordDate,roomNum);
    }
}
