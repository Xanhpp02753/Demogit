/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.IKhachHangRepo;
import DAO.KhachHangRepo;

import Models.KhachHang;
import ViewModels.KhachHangViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xuan Anh
 */
public class QLKhachHangService implements IQLKhachHangservice{ //thứ 2
     IKhachHangRepo iKhangHangRepo;
    
    List<KhachHangViewModel> lstKhachHangView;
    public QLKhachHangService(){
    iKhangHangRepo = new KhachHangRepo();
    }

  
   

    @Override
    public String update(KhachHangViewModel kh) {
        KhachHang kh1 = new KhachHang();
        
        kh1.setTen_KH(kh.getTen_KH());
        kh1.setGioi_tinh(kh.getGioi_tinh());
        kh1.setDienthoai(kh.getDienthoai());
        kh1.setDiaChi(kh.getDiaChi());
        kh1.setEmail(kh.getEmail());
        kh1.setTrang_thai(kh.getTrang_thai());
        
        kh1.setMa_KH(kh.getMa_KH());
        if (iKhangHangRepo.update(kh1)){
            return "Sửa thành công";
        }
        return "Sửa thất bại";
    }

    @Override
    public String delete(String Ma_KH) {
                if (iKhangHangRepo.delete(Ma_KH)) {
            return "Xóa thành công";
        }
        return "Xóa thất bại";
    }

  

    

    @Override
    public List<KhachHangViewModel> getData_TimKiem(String dienThoai) {
         if (iKhangHangRepo.selectByKey( dienThoai).isEmpty()) { // Truyền tham số dienThoai
            return new ArrayList<>();
        }
        lstKhachHangView = new ArrayList<>();
        int stt = 1;
        for (KhachHang x : iKhangHangRepo.selectByKey(dienThoai)){ // Truyền tham số dienThoai
           KhachHangViewModel y = new KhachHangViewModel();
            y.setStt(stt);
            y.setId(x.getId());
            y.setMa_KH(x.getMa_KH());
            y.setTen_KH(x.getTen_KH());
            y.setGioi_tinh(x.getGioi_tinh());
            y.setTenGioiTinh(x.getGioi_tinh() ? "Nam":"Nữ");
            y.setDienthoai(x.getDienthoai());
            y.setEmail(x.getEmail());
            y.setDiaChi(x.getDiaChi());
            y.setTrang_thai(x.getTrang_thai());
            y.setTenTrangThai(x.getTrang_thai() ? "Khách hàng mới" : "Khách lâu năm");
            lstKhachHangView.add(y);
            stt++;
            
        }
        return lstKhachHangView;
    }
    @Override
    public KhachHangViewModel selectById_KH(String maKH) {
        
        
        KhachHangViewModel khvm = null; // Khởi tạo đối tượng NhanVienViewModel để trả về
        for (KhachHangViewModel x : lstKhachHangView) { // Duyệt qua danh sách NhanVienViewModel đã có
            if (x.getMa_KH().equals(maKH)) { // Nếu tìm thấy mã nhân viên trùng khớp 
                khvm = x; // Gán đối tượng tìm được cho nvvm
                break; // Thoát khỏi vòng lặp
            }
        }
        return khvm;
    }

    @Override
    public String insert(KhachHangViewModel kh) {
    iKhangHangRepo.insert(new KhachHang( kh.getMa_KH(),kh.getTen_KH(),kh.getGioi_tinh(),kh.getDienthoai(),kh.getEmail(),kh.getDiaChi(),kh.getTrang_thai()));
        return "Thêm mới thành công";
    }

   // @Override
    //public List<KhachHangViewModel> getData_All() {
     //   if (iKhangHangRepo.selectAllSQL().isEmpty()) {
       //     return new ArrayList<>();
       // }
       // lstKhachHangView = new ArrayList<>();
       // int stt = 1;
       // for (KhachHang x : iKhangHangRepo.selectAllSQL()){
        //    KhachHangViewModel y = new KhachHangViewModel();
         //   y.setStt(stt);
          //  y.setId(x.getId());
           // y.setMa_KH(x.getMa_KH());
            //y.setTen_KH(x.getTen_KH());
          //  y.setGioi_tinh(x.getGioi_tinh());
           // y.setTenGioiTinh(x.getGioi_tinh() ? "Nam":"Nữ");
         //   y.setDienthoai(x.getDienthoai());
         //   y.setEmail(x.getEmail());
         //   y.setDiaChi(x.getDiaChi());
         //   y.setTrang_thai(x.getTrang_thai());
         ///   y.setTenTrangThai(x.getTrang_thai() ? "Khách hàng mới" : "Khách lâu năm");
           // lstKhachHangView.add(y);
          //  stt++;
        //}
        //return lstKhachHangView;
       
    //}

    @Override
    public List<KhachHangViewModel> getData_LocGioiTinh(boolean GioiTinh) {
        if (iKhangHangRepo.selectByGioiTinh(GioiTinh).isEmpty()) { // Truyền tham số dienThoai
            return new ArrayList<>();
        }
        lstKhachHangView = new ArrayList<>();
        int stt = 1;
        for (KhachHang x : iKhangHangRepo.selectByGioiTinh(GioiTinh)){ // Truyền tham số dienThoai
           KhachHangViewModel y = new KhachHangViewModel();
            y.setStt(stt);
            y.setId(x.getId());
            y.setMa_KH(x.getMa_KH());
            y.setTen_KH(x.getTen_KH());
            y.setGioi_tinh(x.getGioi_tinh());
            y.setTenGioiTinh(x.getGioi_tinh() ? "Nam":"Nữ");
            y.setDienthoai(x.getDienthoai());
            y.setEmail(x.getEmail());
            y.setDiaChi(x.getDiaChi());
            y.setTrang_thai(x.getTrang_thai());
            y.setTenTrangThai(x.getTrang_thai() ? "Khách hàng mới" : "Khách lâu năm");
            lstKhachHangView.add(y);
            stt++;
            
        }
        return lstKhachHangView;
    }

    @Override
    public List<KhachHangViewModel> getData_LocTrangThai(boolean TrangThai) {
        if (iKhangHangRepo.selectByTrangThai(TrangThai).isEmpty()) { // Truyền tham số dienThoai
            return new ArrayList<>();
        }
        lstKhachHangView = new ArrayList<>();
        int stt = 1;
        for (KhachHang x : iKhangHangRepo.selectByTrangThai(TrangThai)){ // Truyền tham số dienThoai
           KhachHangViewModel y = new KhachHangViewModel();
            y.setStt(stt);
            y.setId(x.getId());
            y.setMa_KH(x.getMa_KH());
            y.setTen_KH(x.getTen_KH());
            y.setGioi_tinh(x.getGioi_tinh());
            y.setTenGioiTinh(x.getGioi_tinh() ? "Nam":"Nữ");
            y.setDienthoai(x.getDienthoai());
            y.setEmail(x.getEmail());
            y.setDiaChi(x.getDiaChi());
            y.setTrang_thai(x.getTrang_thai());
            y.setTenTrangThai(x.getTrang_thai() ? "Khách hàng mới" : "Khách lâu năm");
            lstKhachHangView.add(y);
            stt++;
            
        }
        return lstKhachHangView;
    }
}

    

   
    



  
    

     
        



    

