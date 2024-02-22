/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.KhachHang;

import Utilities.JdbcHelper;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Xuan Anh
 */
public class KhachHangRepo implements IKhachHangRepo{
private String INSERT_SQL = "INSERT INTO  KHACHHANG(MAKH,TEN_KH,GIOI_TINH,DIENTHOAI,EMAIL,DIACHI,TRANG_THAI) VALUES (?,?,?,?,?,?,?)";
private String UPDATE_SQL = "UPDATE KHACHHANG SET TEN_KH = ? , GIOI_TINH = ?, DIENTHOAI = ?,EMAIL=?,DIACHI=?,TRANG_THAI=? WHERE MAKH=?";
private String DELETE_SQL = "DELETE KHACHHANG WHERE MAKH = ?";


    @Override
    public boolean insert(KhachHang KH) {
        try {
            JdbcHelper.update(INSERT_SQL, 
                    KH.getMa_KH(), 
                    KH.getTen_KH(),
                    KH.getGioi_tinh(),
                    KH.getDienthoai(),
                    KH.getEmail(),
                    KH.getDiaChi(),
                    KH.getTrang_thai()
                    );
                    
            return true;
        } catch (Exception e) {
            return false;
        }
             
    }

    @Override
    public boolean update(KhachHang KH) {
        try {
            JdbcHelper.update(UPDATE_SQL,
                   KH.getTen_KH(),
                   KH.getGioi_tinh(),
                   KH.getDienthoai(),
                   KH.getDiaChi(),
                   KH.getEmail(),
                   KH.getTrang_thai(),
                    KH.getMa_KH()
                    );
            return  true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(String MaKH) {
          try {
            JdbcHelper.update(DELETE_SQL, MaKH);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public KhachHang selectById(String MaKH) {
          String SELECT_BY_ID_SQL = "SELECT * FROM KHACHHANG WHERE MAKH= ?";
        List<KhachHang> list = selectBySQL(SELECT_BY_ID_SQL, MaKH);      
        return !list.isEmpty() ? list.get(0) : null;    
    }

    @Override
    public List<KhachHang> selectBySQL(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try{
            ResultSet rs = null;
            try {
                
                rs = JdbcHelper.query(sql, args);
                while (rs.next()) {                
                    KhachHang entity = new KhachHang();
                    
                    entity.setId(rs.getInt("ID"));  
                    entity.setMa_KH(rs.getString("MAKH"));
                    entity.setTen_KH(rs.getString("Ten_KH"));
                    entity.setGioi_tinh(rs.getBoolean("GIOI_TINH"));
                    entity.setDienthoai(rs.getString("DIENTHOAI"));
                    entity.setEmail(rs.getString("EMAIL"));
                    entity.setDiaChi(rs.getString("DIACHI"));
                   
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
    public List<KhachHang> selectByKey(String dienThoai) {
         String SELECT_ALL_SQL = "SELECT * FROM KHACHHANG WHERE  DIENTHOAI LIKE ? ORDER BY id DESC ";
    return this.selectBySQL(SELECT_ALL_SQL, "%" + dienThoai + "%"); 
    }

   // @Override
    //public List<KhachHang> selectAllSQL() {
    //     String SELECT_ALL_SQL = "SELECT * FROM KHACHHANG";
     //   return this.selectBySQL(SELECT_ALL_SQL);
    //}

    @Override
    public List<KhachHang> selectByGioiTinh(Boolean gioiTinh) {
        String sql = "SELECT * FROM KHACHHANG WHERE GIOI_TINH = ?";
        return this.selectBySQL(sql, gioiTinh);
    }

    @Override
    public List<KhachHang> selectByTrangThai(Boolean trangThai) {
        String sql = "SELECT * FROM KHACHHANG WHERE TRANG_THAI = ?";
        return this.selectBySQL(sql, trangThai);
    }
        

   
   

    
   


}
    

   

    
    
           
                    
         
        
    
     
    
    

