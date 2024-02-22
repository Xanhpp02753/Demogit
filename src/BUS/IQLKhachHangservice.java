/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BUS;

import Models.KhachHang;
import ViewModels.KhachHangViewModel;
import java.util.List;

/**
 *
 * @author Xuan Anh
 */
public interface IQLKhachHangservice {//Đầu tiên
       
 
    String insert(KhachHangViewModel kh);
    String update(KhachHangViewModel kh);
    String delete(String Ma_KH);

    KhachHangViewModel selectById_KH(String maKH);
    public List<KhachHangViewModel> getData_TimKiem( String dienThoai);
   // public List<KhachHangViewModel> getData_All();
    List<KhachHangViewModel> getData_LocGioiTinh(boolean GioiTinh);
     List<KhachHangViewModel> getData_LocTrangThai(boolean TrangThai);
}
