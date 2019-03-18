package cn.bdqn.itrip.service;

import cn.bdqn.itrip.pojo.Guest;

import java.util.List;

public interface GuestService {
    /**
     * 新增住客
     * @param guest
     * @return
     */
    int addGuest(Guest guest);

    /**
     * 查找用户下的住客列表
     * @param userId 用户id
     * @return
     */
    List<Guest> findGuests(Integer userId);

    /**
     * 根据id查找的住客信息
     * @param id
     * @return
     */
    Guest findUniqueGuest(Integer id);
}
