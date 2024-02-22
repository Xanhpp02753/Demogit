/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ILoaiSPRepo;
import DAO.LoaiSPRepo;
import Models.LoaiSP;
import ViewModels.LoaiSPViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xuan Anh
 */
public class LoaiSPservice implements ILoaiSPservice{
    ILoaiSPRepo iLoaiSPRepo;
    List<LoaiSPViewModel> lstLoaiSPView;
    public LoaiSPservice(){
        iLoaiSPRepo =  new LoaiSPRepo();
    }

    @Override
    public String insert(LoaiSPViewModel lsp) {
       iLoaiSPRepo.insert(new LoaiSP(lsp.getMa_LoaiSP(),lsp.getTen_DM(),lsp.getTrang_thai()));
       return "Thêm mới thành công";
    }

    @Override
    public String update(LoaiSPViewModel lsp) {
         LoaiSP lsp1 = new LoaiSP();
        lsp1.setTen_DM(lsp.getTen_DM());
        lsp1.setTrang_thai(lsp.getTrang_thai());
        lsp1.setMa_LoaiSP(lsp.getMa_LoaiSP());
        if (iLoaiSPRepo.update(lsp1)){
            
            return "Sửa thành công";
        }
        return "Sửa thất bại";
    }

    @Override
    public String delete(String Ma_LoaiSP) {
          if (iLoaiSPRepo.delete(Ma_LoaiSP)) {
            return "Xóa thành công";
        }
        return "Xóa thất bại";
    }

    @Override
    public LoaiSPViewModel selectByID_LSP(String maLSP) {
        LoaiSPViewModel lspvm = null;
        for (LoaiSPViewModel x : lstLoaiSPView){
            if (x.getMa_LoaiSP().equals(maLSP)){
                lspvm = x;
                break;
            }
        }
        return lspvm;
    }

    @Override
    public List<LoaiSPViewModel> getData_Timkiem(String tenDM) {
          if (iLoaiSPRepo.selectByKey( tenDM).isEmpty()) { // Truyền tham số dienThoai
            return new ArrayList<>();
        }
        lstLoaiSPView= new ArrayList<>();
        int stt = 1;
        for (LoaiSP x : iLoaiSPRepo.selectByKey(tenDM)){ // Truyền tham số dienThoai
           LoaiSPViewModel y = new LoaiSPViewModel();
            y.setStt(stt);
            y.setId(x.getId());
            y.setMa_LoaiSP(x.getMa_LoaiSP());
            y.setTen_DM(x.getTen_DM());
            y.setTrang_thai(x.getTrang_thai());
            y.setTenTrangThai(x.getTrang_thai() ? "Loại mới" : "Loại cũ");
            lstLoaiSPView.add(y);
            stt++;
            
        }
        return lstLoaiSPView; 
    }

    @Override
    public List<LoaiSPViewModel> getData_LocTrangThai(boolean TrangThai) {
     if (iLoaiSPRepo.selectByTrangThai(TrangThai).isEmpty()) { // Truyền tham số dienThoai
            return new ArrayList<>();
        }
        lstLoaiSPView = new ArrayList<>();
        int stt = 1;
        for (LoaiSP x : iLoaiSPRepo.selectByTrangThai(TrangThai)){ // Truyền tham số dienThoai
           LoaiSPViewModel y = new LoaiSPViewModel();
           
            y.setStt(stt);
            y.setId(x.getId());
            y.setMa_LoaiSP(x.getMa_LoaiSP());
            y.setTen_DM(x.getTen_DM());
            y.setTrang_thai(x.getTrang_thai());
            y.setTenTrangThai(x.getTrang_thai() ? "Loại mới" : " loại cũ");
            lstLoaiSPView.add(y);
            stt++;
            
        }
        return lstLoaiSPView;
    }
    
}
