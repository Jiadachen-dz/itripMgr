package cn.bdqn.itrip.service.impl;

import cn.bdqn.itrip.dao.HotelMapper;
import cn.bdqn.itrip.pojo.Country;
import cn.bdqn.itrip.pojo.Hotel;
import cn.bdqn.itrip.service.HotelService;
import cn.bdqn.itrip.utils.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HotelServiceImol implements HotelService {
    @Resource
    private HotelMapper hotelMapper;


    @Override
    public PageBean<Hotel> findHotelList(Integer hotelLevel, String hotelName, Integer countryId, Integer pageIndex, Integer pageSize) {
        PageBean<Hotel> pageBean = new PageBean<Hotel>();
        //查询总数量
        int count = hotelMapper.count(hotelLevel, hotelName, countryId);
        pageBean.setTotalCount(count);
        pageBean.setPageSize(pageSize);
        pageBean.setPageIndex(pageIndex);


        if (count > 0) {
            List<Hotel> hotelList = hotelMapper.getHotelList(hotelLevel, hotelName, countryId, pageBean.getStartRow(), pageSize);
            pageBean.setList(hotelList);
        }
        return pageBean;
    }

    @Override
    public List<Country> findCountryList() {
        return hotelMapper.getCountryList();
    }


}