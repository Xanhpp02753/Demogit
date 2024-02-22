/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XDate {
    static SimpleDateFormat formater = new SimpleDateFormat();
    
    public static Date toDate(String date, String pattern){
        try {
            formater.applyPattern(pattern); // tự thiết lập định dạng
            return formater.parse(date);    // nhập dữ liệu 
        }
        catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    /*  khi chạy: để ép kiểu từ ký tự sang ngày tháng.
        String s = "01-09-1971" (dữ liệu)
        Date date = XDate.toDate(s, "dd-MM-yyyy"); (định dạng)
    */
    
    public static String toString(Date date, String pattern) {
        formater.applyPattern(pattern);
        return formater.format(date);
    }
    /*  khi chạy: để ép kiểu ngày tháng sang ký tự.
        Date now = new Date();
        String s = XDate.toString(now, "dd-MM-yyyy");
    */  
    
    public static Date now(){
        return new Date();
    }
    
    public static Date addDays(Date date, long days) {
        date.setTime(date.getTime() + days*24*60*60*1000);
        return date;
    }
    /*  khi chạy: thêm số ngày bất kỳ vào hệ thống.
        Date now = new Date();
        Date after = XDate.addDays(now, 10); bổ sung thêm 10 ngày
    */
    public static Date add(int days){
        Date now = XDate.now();
        now.setTime(now.getTime() + days*24*60*60*1000);
        return now;
    }
}
