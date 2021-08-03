package com.example.demo.controller;

import com.example.demo.bean.Car;
import com.example.demo.bean.Ordertable;
import com.example.demo.service.ICarService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    private ICarService carService;
    @GetMapping("viewCar")
    public String viewCar(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.getAttribute("getusername");
        request.setAttribute("cars",carService.viewCar());
        return "viewCar";
    }
    @GetMapping("selectCar")
    public String selectCar(String carid,HttpServletRequest request){
        HttpSession session = request.getSession();
        session.getAttribute("getusername");
        session.setAttribute("carid", carid);
        System.out.println("select里面的carid:" + carid);
        request.setAttribute("carid", carid);
        request.setAttribute("cars",carService.selectCar(carid));
        request.setAttribute("price", carService.selectrentpricebyid(carid));
        //System.out.println(carid);
        return "selectCar";
    }

    @GetMapping("Pay")
    public String Pay(String carid, String begintime, String endtime, HttpServletRequest request) throws ParseException {
        HttpSession session = request.getSession();
        carid = (String) session.getAttribute("carid");//从session得到carid
        session.getAttribute("getusername");

        request.setAttribute("cars", carService.selectCar(carid));
        String userid = (String) session.getAttribute("getuserid");
        System.out.println("userid：" + userid);
        String username = (String) session.getAttribute("username");
        session.setAttribute("userid", userid);
        request.setAttribute("userid", userid);
        request.setAttribute("realname", username);
        request.setAttribute("begintime", begintime);
        request.setAttribute("endtime", endtime);
        System.out.println("endtime:" + endtime);
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        String time1 = begintime;
        String time2 = endtime;
        Date begin_date = ft.parse(time1);
        Date end_date = ft.parse(time2);
        session.setAttribute("begintime", begin_date);
        session.setAttribute("endtime", end_date);
        int day = (int) ((end_date.getTime() - begin_date.getTime()) / (1000 * 60 * 60 * 24));
        double rentprice = new Double(carService.selectrentpricebyid(carid));
        double deposit = new Double(carService.selectdepositbyid(carid));
        double money = rentprice * day;
        double total = money + deposit;
        session.setAttribute("total",total);
        System.out.println("money" + money);
        System.out.println("total" + total);
        request.setAttribute("money", money);
        request.setAttribute("total", total);
        return "Pay";
    }

    @GetMapping("addorder")
    public String addorder(@Param("username") String username, @Param("userid") String userid, @Param("carid") String carid, @Param("rentprice") Double rentprice, @Param("deposit") Double deposit, @Param("total") Double total1, @Param("begintime") Date begintime, @Param("endtime")Date endtime, HttpServletRequest request) {
        HttpSession session = request.getSession();
        total1= (Double) session.getAttribute("total");
//        total1=Double.parseDouble(total);
        System.out.println("addorder de total1"+total1);

        begintime = (Date) session.getAttribute("begintime");
        endtime= (Date) session.getAttribute("endtime");
        Ordertable o1 = new Ordertable();
        carid = (String) session.getAttribute("carid");
        request.setAttribute("carid", carid);
        Car selectcar=carService.selectCar(carid);
        String number=selectcar.getNumber();

        String type=selectcar.getType();

        String brand=selectcar.getBrand();

        String color=selectcar.getColor();

        String img=selectcar.getImg();

        rentprice=selectcar.getRentprice();
        System.out.println("rentprice"+rentprice);
        deposit=selectcar.getDeposit();
        System.out.println("carid:" + carid);
        int cid = Integer.parseInt(carid);
        System.out.println("cid:" + cid);
        userid = (String) session.getAttribute("userid");
        System.out.println("userid:" + userid);
        username = (String) session.getAttribute("username");
        request.setAttribute("username", username);
        o1.setBegintime(begintime);
        o1.setCarid(carid);
        o1.setEndtime(endtime);
        o1.setUserid(userid);
        o1.setUsername(username);
        System.out.println(o1.getBegintime());
        System.out.println(o1.getEndtime());
        System.out.println("o1的username:"+o1.getUsername());
        carService.addorder(username,userid,carid,number,type,brand,color,rentprice,deposit,total1,begintime,endtime,img);
        carService.changerent(carid);
        return "redirect:../selectOrder";
    }

    @GetMapping("manageviewCar")
    public String manageCar(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.getAttribute("getusername");
        request.setAttribute("cars",carService.manageviewCar());
        return "manageviewCar";
    }
    @GetMapping("deleteCar")
    public String deleteCar(String carid,HttpServletRequest request){
        HttpSession session = request.getSession();
        session.getAttribute("getusername");
    carService.deleteCar(carid);
    return "redirect:manageviewCar";
    }


    @GetMapping("modifyCar")
    public String modifyCar(String carid,HttpServletRequest request){
        HttpSession session = request.getSession();
        session.getAttribute("getusername");
        request.setAttribute("cars",carService.modifyCar(carid));
        return "modifyCar";
    }


    @GetMapping("updateCar")
    public String updateCar(Car car){
        carService.updateCar(car);
        return "redirect:manageviewCar";
    }


    @GetMapping("/addCar")
    public String addCar(Car car){
        carService.addCar(car);
        return "redirect:manageviewCar";
    }


    @GetMapping("/addCarPage")
    public String addCarPage(){
        return "addCar";
    }




}
