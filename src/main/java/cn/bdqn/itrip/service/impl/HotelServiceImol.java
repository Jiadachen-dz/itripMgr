package cn.bdqn.itrip.service.impl;

import cn.bdqn.itrip.dao.HotelMapper;
import cn.bdqn.itrip.pojo.Hotel;
import cn.bdqn.itrip.service.HotelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class HotelServiceImol implements HotelService {
    @Resource
    private HotelMapper hotelMapper;

    @Override
    public List<Hotel> findHotelAll() {
        return hotelMapper.getHotelAll();
    }

    @Override
    public Hotel findHotel(Hotel hotel) {
        return hotelMapper.getHotel(hotel);
    }


}