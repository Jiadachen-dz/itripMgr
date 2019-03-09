package cn.bdqn.itrip.service.impl;

import cn.bdqn.itrip.dao.RoomsMapper;
import cn.bdqn.itrip.pojo.RoomType;
import cn.bdqn.itrip.service.RoomsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoomsServiceImpl implements RoomsService {

    @Resource
    private RoomsMapper roomsMapper;

    @Override
    public List<RoomType> findRoomTypeByHotelId(Integer hotelId) {
        return roomsMapper.getRoomTypeByHotelId(hotelId);
    }
}
