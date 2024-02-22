/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.IKieuThietKeRepo;
import DAO.KieuThietKeRepo;
import Models.KieuThietKe;
import ViewModels.KieuThietKeViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xuan Anh
 */
public class KieuTKservice implements IKieuThietKeservice{
    IKieuThietKeRepo  iKieuThietKeRepo;
    List<KieuThietKeViewModel> lstKieuThietKeView;
    public KieuTKservice(){
        iKieuThietKeRepo = new KieuThietKeRepo();
    }

    @Override
    public String insert(KieuThietKeViewModel ktk) {
        iKieuThietKeRepo.insert(new KieuThietKe(ktk.getMa_ThietKe(),ktk.getMota_ThietKe(),ktk.getTrang_thai()));
       
        
       return "Thêm mới thành công";
    }

    @Override
    public String update(KieuThietKeViewModel ktk) {
        KieuThietKe ktk1 = new KieuThietKe();
        ktk1.setMota_ThietKe(ktk.getMota_ThietKe());
        ktk1.setTrang_thai(ktk.getTrang_thai());
                        ktk1.setMa_ThietKe(ktk.getMa_ThietKe());
           if (iKieuThietKeRepo.update(ktk1)){
            
            return "Sửa thành công";
        }
        return "Sửa thất bại";             
    }

    @Override
    public String delete(String Ma_KieuTK) {
        if (iKieuThietKeRepo.delete(Ma_KieuTK)) {
            return "Xóa thành công";
        }
        return "Xóa thất bại"; 
    }

    @Override
    public KieuThietKeViewModel selectByID_KTK(String maLSP) {
      KieuThietKeViewModel ktkvm = null;
        for (KieuThietKeViewModel x : lstKieuThietKeView){
            if (x.getMa_ThietKe().equals(maLSP)){
                ktkvm  = x;
                break;
            }
        }
        return ktkvm ;  
    }

    @Override
    public List<KieuThietKeViewModel> getData_Timkiem(String motaTK) {
        if (iKieuThietKeRepo.selectByKey( motaTK).isEmpty()) { // Truyền tham số dienThoai
            return new ArrayList<>();
        }
        lstKieuThietKeView= new ArrayList<>();
        int stt = 1;
        for (KieuThietKe x : iKieuThietKeRepo.selectByKey(motaTK)){ // Truyền tham số dienThoai
           KieuThietKeViewModel y = new KieuThietKeViewModel();
            y.setStt(stt);
            y.setId(x.getId());
            y.setMa_ThietKe(x.getMa_ThietKe());
            y.setMota_ThietKe(x.getMota_ThietKe());
            y.setTrang_thai(x.getTrang_thai());
            y.setTenTrangThai(x.getTrang_thai() ? "Kiểu mới" : "Kiểu  cũ");
            lstKieuThietKeView.add(y);
            stt++;
            
        }
        return lstKieuThietKeView; 
    }

    @Override
    public List<KieuThietKeViewModel> getData_LocTrangThai(boolean TrangThai) {
        if (iKieuThietKeRepo.selectByTrangThai(TrangThai).isEmpty()) { // Truyền tham số dienThoai
            return new ArrayList<>();
        }
        lstKieuThietKeView= new ArrayList<>();
        int stt = 1;
        for (KieuThietKe x : iKieuThietKeRepo.selectByTrangThai(TrangThai)){ // Truyền tham số dienThoai
           KieuThietKeViewModel y = new KieuThietKeViewModel();
            y.setStt(stt);
            y.setId(x.getId());
            y.setMa_ThietKe(x.getMa_ThietKe());
            y.setMota_ThietKe(x.getMota_ThietKe());
            y.setTrang_thai(x.getTrang_thai());
            y.setTenTrangThai(x.getTrang_thai() ? "Kiểu mới" : "Kiểu  cũ");
            lstKieuThietKeView.add(y);
            stt++;
            
        }
        return lstKieuThietKeView;
    }
    
}
