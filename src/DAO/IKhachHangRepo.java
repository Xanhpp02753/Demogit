/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Models.KhachHang;
import java.util.List;

/**
 *
 * @author Xuan Anh
 */
public interface IKhachHangRepo {
 public boolean insert(KhachHang KH);
    public boolean update(KhachHang KH);
    public boolean delete(String MaKH);
    
    public KhachHang selectById(String MaKH);
    public List<KhachHang> selectBySQL(String sql, Object... args);
    //public List<KhachHang> selectAllSQL();
    public List<KhachHang> selectByKey( String dienThoai);
    public List<KhachHang> selectByGioiTinh(Boolean gioiTinh);
    public List<KhachHang> selectByTrangThai(Boolean trangThai);
    
 

   
}
