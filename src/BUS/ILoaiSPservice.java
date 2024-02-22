/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BUS;

import ViewModels.LoaiSPViewModel;
import java.util.List;

/**
 *
 * @author Xuan Anh
 */
public interface ILoaiSPservice {
    String insert(LoaiSPViewModel lsp);
    String update(LoaiSPViewModel lsp);
    String delete(String Ma_LoaiSP);
    
    LoaiSPViewModel selectByID_LSP(String maLSP);
    public List<LoaiSPViewModel> getData_Timkiem( String tenDM);
     List<LoaiSPViewModel> getData_LocTrangThai(boolean TrangThai);
}
