package cn.bdqn.itrip.controller;

import cn.bdqn.itrip.pojo.Order;
import cn.bdqn.itrip.pojo.RoomType;
import cn.bdqn.itrip.pojo.User;
import cn.bdqn.itrip.service.OrderService;
import cn.bdqn.itrip.service.StockService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
    @Resource
    private OrderService orderService;
    @Resource
    private StockService stockService;

    /**
     * 查询订单房间的信息  "reservation"
     * @param id
     * @param checkInDate  入住时间
     * @param checkOutDate   退房时间
     * @param request
     * @param session
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/findRoomInfo")
    private  String findOrderInfo(@RequestParam(value ="id" )Integer id,
                                  @RequestParam(value ="checkInDate",required = false) String  checkInDate,
                                  @RequestParam(value ="checkOutDate",required = false)String checkOutDate,
                                  HttpServletRequest request ,HttpSession session) throws ParseException {


        RoomType romInfo = orderService.findRoomInfo(id);
        // 订单随机数  获得当前日历时间毫秒数
        long orderNumber = Calendar.getInstance().getTimeInMillis();
        request.setAttribute("orderNumber",orderNumber);

        //传入时间格式转化为字符串,
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date _comeInDate = sdf.parse(checkInDate);
        Date _leaveDate = sdf.parse(checkOutDate);
        //入离时间差
        long days = (_leaveDate.getTime()-_comeInDate.getTime())/(24*60*60*1000);

        romInfo.setCreationDate(sdf.parse(checkInDate));
        romInfo.setModifyDate(sdf.parse(checkOutDate));

        session.setAttribute("romInfo",romInfo);
        request.setAttribute("days",days);



//        Calendar calendar = new GregorianCalendar();
//        Date recordDate;    //记录日期
//        int stock = 0;       //库存（如果预订是在一段时间内，则取库存最小的一天）
//        //遍历查询每天的库存，以及插入新的实时库存
//        for(int i = 0;i<days;i++) {
//            calendar.setTime(_comeInDate);
//            calendar.add(calendar.DATE, i); //把日期往后增加一天,整数  往后推,负数往前移动
//            recordDate = calendar.getTime(); //这个时间就是日期往后推一天的结果
//
            //1.根据入住时间去查询实时库存有没有今天的库存，如果没有，则插入数据，有则不用
//            RealTimeStock realTimeStock = stockService.findRealTimeStock(id, recordDate);
////            if (realTimeStock == null) {
//                RawStock rawStock = stockService.findRawStock(1, id);
//                stockService.saveRealTimeStock(new RealTimeStock(id, recordDate, rawStock.getStock()));
//                realTimeStock = stockService.findRealTimeStock(id, recordDate);
//            }
//            //2.入住当天默认为最小库存。如果过后的时间段库存更小，则拿最小库存
//            if (i == 0) {
//                stock = realTimeStock.getStock();
//            } else {
//                stock = realTimeStock.getStock() < stock ? realTimeStock.getStock() : stock;
//            }
//        }

        return "addOrder";
    }

    @RequestMapping(value = "/addOrder")
    private  String addOrder(@RequestParam(value ="days" )long days,
                             @RequestParam(value ="count" )Integer count,
                             @RequestParam(value ="linkUserName" )String linkUserName,
                             @RequestParam(value ="noticePhone" )String noticePhone,
                             @RequestParam(value ="orderStatus" )Integer orderStatus,
                             @RequestParam(value ="orderNumber" )String orderNumber,
                             HttpSession session, Model model){

        User user = (User) session.getAttribute("loginUser");
        RoomType room = (RoomType) session.getAttribute("romInfo");
        //预定天数（入住时间-退房时间）
        int day = new Long(days).intValue();

         Order order =new Order(user.getId(),room.getId(),count,day,orderStatus,room.getRoomPrice()*count,noticePhone,linkUserName,room.getCreationDate(),room.getModifyDate(),orderNumber);
        System.out.println("支付金额："+room.getRoomPrice()*count);
        int i = orderService.addOrder(order);
        if (i>0){
            //订单添加成功
//            session.setAttribute("price",room.getRoomPrice()*count);
            model.addAttribute("price",room.getRoomPrice()*count);
            model.addAttribute("orderNumber",orderNumber);
            return "alipayTest";
        }
        model.addAttribute("msg","下单失败！");
        return "addOrder";
    }

}




