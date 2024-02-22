/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import Models.LoaiSP;
import Utilities.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xuan Anh
 */
public class LoaiSPRepo implements ILoaiSPRepo {
private String INSERT_SQL = "INSERT INTO LOAI_SANPHAM(MA_LOAISP,TENDM,TRANG_THAI) VALUES (?,?,?)";
private String UPDATE_SQL = "UPDATE LOAI_SANPHAM SET TENDM = ? , TRANG_THAI = ? WHERE MA_LOAISP = ?";
private String DELETE_SQL = "DELETE LOAI_SANPHAM WHERE MA_LOAISP = ?";

    @Override
    public boolean insert(LoaiSP LSP) {
        try {
            JdbcHelper.update(INSERT_SQL,
                    LSP.getMa_LoaiSP(),
                   LSP.getTen_DM(),
                   LSP.getTrang_thai()
                   
                  
                    );
            return  true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean update(LoaiSP LSP) {
        try {
            JdbcHelper.update(UPDATE_SQL,
                   LSP.getTen_DM(),
                   LSP.getTrang_thai(),
                   
                   LSP.getMa_LoaiSP()
                    );
            return  true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean delete(String MaLoaiSP) {
         try {
            JdbcHelper.update(DELETE_SQL, MaLoaiSP);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public LoaiSP selectByID(String MaLoaiSP) {
     String SELECT_BY_ID_SQL = "SELECT * FROM LOAI_SANPHAM WHERE MA_LOAISP=?";
     List<LoaiSP> list = selectBySQL(SELECT_BY_ID_SQL, MaLoaiSP);
     return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public List<LoaiSP> selectBySQL(String sql, Object... args) {
        List<LoaiSP> list = new ArrayList<>();
        try{
            ResultSet rs = null;
            try {
                
                rs = JdbcHelper.query(sql, args);
                while (rs.next()) {                
                    LoaiSP entity = new LoaiSP();
                    
                    entity.setId(rs.getInt("ID"));  
                    entity.setMa_LoaiSP(rs.getString("MA_LOAISP"));
                    entity.setTen_DM(rs.getString("TENDM"));
                    
                   
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
    public List<LoaiSP> selectByKey(String tenDM) {
        String SELECT_ALL_SQL = "SELECT * FROM LOAI_SANPHAM WHERE TENDM LIKE ? ORDER BY id DESC ";
        return this.selectBySQL(SELECT_ALL_SQL, "%" + tenDM + "%");
    }

    @Override
    public List<LoaiSP> selectByTrangThai(Boolean trangThai) {
        String sql = "SELECT * FROM LOAI_SANPHAM WHERE TRANG_THAI = ?";
        return this.selectBySQL(sql, trangThai);
    }

    
    
}
