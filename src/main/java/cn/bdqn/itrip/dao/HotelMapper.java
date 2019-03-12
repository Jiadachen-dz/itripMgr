package cn.bdqn.itrip.dao;

import cn.bdqn.itrip.pojo.Country;
import cn.bdqn.itrip.pojo.Hotel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HotelMapper {


    /**
     *
     * @param hotelLevel
     * @param hotelName
     * @param countryId
     * @param startRow 起始行数
     * @param pageSize 页面容量
     * @return分页查询按照特定条件显示出筛选的酒店
     */

    List<Hotel> getHotelList(@Param(value = "hotelLevel") Integer hotelLevel,
                             @Param(value = "hotelName") String hotelName,
                             @Param(value = "countryId" ) Integer countryId,
                             @Param(value = "startRow") Integer startRow,
                             @Param(value = "pageSize") Integer pageSize
                   );

    /**
     *
     * @param hotelLevel
     * @param hotelName
     * @param countryId
     * @return按照特定条件显示出筛选的酒店显示多少条记录
     */
    int count(@Param(value = "hotelLevel") Integer hotelLevel,
              @Param(value = "hotelName") String hotelName,
              @Param(value = "countryId" ) Integer countryId);

    /**
     *
     * @return遍历国家拿到id
     */
    List<Country> getCountryList();


}
