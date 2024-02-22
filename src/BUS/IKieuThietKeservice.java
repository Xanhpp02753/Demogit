/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BUS;

import ViewModels.KieuThietKeViewModel;
import java.util.List;

/**
 *
 * @author Xuan Anh
 */
public interface IKieuThietKeservice {
    String insert(KieuThietKeViewModel ktk);
    String update(KieuThietKeViewModel ktk);
    String delete(String Ma_KieuTK);
    
    KieuThietKeViewModel selectByID_KTK(String maLSP);
    public List<KieuThietKeViewModel> getData_Timkiem( String motaTK);
     List<KieuThietKeViewModel> getData_LocTrangThai(boolean TrangThai); 
}
