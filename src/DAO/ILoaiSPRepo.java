/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Models.LoaiSP;
import java.util.List;

/**
 *
 * @author Xuan Anh
 */
public interface ILoaiSPRepo {
    public boolean insert(LoaiSP LSP);
    public boolean update(LoaiSP LSP);
    public boolean delete(String MaLoaiSP);
    public LoaiSP selectByID(String MaLoaiSP);
    public List<LoaiSP> selectBySQL(String sql, Object... args);
    public List<LoaiSP> selectByKey( String tenDM);
    public List<LoaiSP> selectByTrangThai(Boolean trangThai);
}
