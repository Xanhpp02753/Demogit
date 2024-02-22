/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.KieuThietKe;
import Utilities.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xuan Anh
 */
public class KieuThietKeRepo implements IKieuThietKeRepo{
   private String INSERT_SQL = "INSERT INTO KIEU_THIETKE(MA_THIETKE,MOTA_THIETKE,TRANG_THAI) VALUES (?,?,?)";
private String UPDATE_SQL = "UPDATE KIEU_THIETKE SET MOTA_THIETKE = N'gọn' , TRANG_THAI = 0  WHERE MA_THIETKE = 'MTK001'";
private String DELETE_SQL = "DELETE KIEU_THIETKE WHERE MA_THIETKE = ?"; 

    @Override
    public boolean insert(KieuThietKe KTK) {
        try {
            JdbcHelper.update(INSERT_SQL,
                    KTK.getMa_ThietKe(),
                   KTK.getMota_ThietKe(),
                   KTK.getTrang_thai()
                   
                  
                    );
            return  true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean update(KieuThietKe KTK) {
        try {
            JdbcHelper.update(UPDATE_SQL,
                  
                   KTK.getMota_ThietKe(),
                   KTK.getTrang_thai(),
                    KTK.getMa_ThietKe()
                    );
            return  true;
        } catch (Exception e) {
            return false;
        } 
    }
    @Override
    public boolean delete(String MaKieuTK) {
        try {
            JdbcHelper.update(DELETE_SQL, MaKieuTK);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public KieuThietKe selectByID(String MaKieuTK) {
        String SELECT_BY_ID_SQL = "SELECT * FROM KIEU_THIETKE WHERE MA_THIETKE=?";
     List<KieuThietKe> list = selectBySQL(SELECT_BY_ID_SQL, MaKieuTK);
     return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public List<KieuThietKe> selectBySQL(String sql, Object... args) {
        List<KieuThietKe> list = new ArrayList<>();
        try{
            ResultSet rs = null;
            try {
                
                rs = JdbcHelper.query(sql, args);
                while (rs.next()) {                
                    KieuThietKe entity = new KieuThietKe();
                    
                    entity.setId(rs.getInt("ID"));  
                    entity.setMa_ThietKe(rs.getString("MA_THIETKE"));
                    entity.setMota_ThietKe(rs.getString("MOTA_THIETKE"));
                    
                   
                    entity.setTrang_thai(rs.getBoolean("TRANG_THAI"));
                    
                    list.add(entity);
                }                  
            }
            finally{
                rs.getStatement().getConnection().close();
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<KieuThietKe> selectByKey(String motaTK) {
       String SELECT_ALL_SQL = "SELECT * FROM KIEU_THIETKE WHERE MOTA_THIETKE LIKE ? ORDER BY id DESC ";
        return this.selectBySQL(SELECT_ALL_SQL, "%" + motaTK + "%"); 
    }

    @Override
    public List<KieuThietKe> selectByTrangThai(Boolean trangThai) {
         String sql = "SELECT * FROM KIEU_THIETKE WHERE TRANG_THAI = ?";
        return this.selectBySQL(sql, trangThai);
    }
    
}
