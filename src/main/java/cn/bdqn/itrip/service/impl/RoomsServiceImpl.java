package cn.bdqn.itrip.service.impl;

import cn.bdqn.itrip.dao.RoomsMapper;
import cn.bdqn.itrip.pojo.Hotel;
import cn.bdqn.itrip.pojo.RoomType;
import cn.bdqn.itrip.service.RoomsService;
import cn.bdqn.itrip.utils.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoomsServiceImpl implements RoomsService {

    @Resource
    private RoomsMapper roomsMapper;

    @Override
    public PageBean<RoomType> findRoomTypeByHotelId(Integer hotelId, Integer pageIndex, Integer pageSize) {
        PageBean<RoomType> pageBean = new PageBean<RoomType>();
        //查询总数量
        int count = roomsMapper.count(hotelId);
        pageBean.setTotalCount(count);
        pageBean.setPageSize(pageSize);
        pageBean.setPageIndex(pageIndex);
        if (count>0){
            List<RoomType> roomsList = roomsMapper.getRoomTypeByHotelId(hotelId, pageBean.getStartRow(), pageSize);
            pageBean.setList(roomsList);
        }
        return pageBean;
    }

    @Override
    public Hotel findHotelByhotelId(Integer hotelId) {
        return roomsMapper.getHotelByhotelId(hotelId);
    }
}
