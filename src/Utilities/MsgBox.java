/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.awt.Component;
import javax.swing.JOptionPane;

public class MsgBox {
    public static void alert(Component parent, String message){
        JOptionPane.showMessageDialog(parent, message, "Hệ thống quản lý bán hàng", JOptionPane.INFORMATION_MESSAGE);
    }  
    /*  VD1: thông báo đăng nhập thành công
        MsgBox.alert(this, "Đăng nhập thành công");
    */
    
    public static boolean confirm(Component parent, String message) {
        int result = JOptionPane.showConfirmDialog(parent, message, 
                "Hệ thống quản lý bán hàng", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }
    /*  VD2: xác nhận 
        MsgBox.confirm(this, "Bạn có muốn không?");
    */
    
    public static String prompt(Component parent, String message){
        return JOptionPane.showInputDialog(parent, message,
                "Hệ thống quản lý bán hàng", JOptionPane.INFORMATION_MESSAGE);      
    }
}