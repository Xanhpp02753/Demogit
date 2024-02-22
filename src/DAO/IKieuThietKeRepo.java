/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Models.KieuThietKe;
import java.util.List;

/**
 *
 * @author Xuan Anh
 */
public interface IKieuThietKeRepo {
   public boolean insert(KieuThietKe KTK);
    public boolean update(KieuThietKe KTK);
    public boolean delete(String MaKieuTK);
    public KieuThietKe selectByID(String MaKieuTK);
    public List<KieuThietKe> selectBySQL(String sql, Object... args);
    public List<KieuThietKe> selectByKey( String motaTK);
    public List<KieuThietKe> selectByTrangThai(Boolean trangThai); 
}
