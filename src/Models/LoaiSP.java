/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Xuan Anh
 */
public class LoaiSP {
    private int id;
    private String ma_LoaiSP;
    private String ten_DM;
    private Boolean trang_thai;
    
    public LoaiSP() {
        
    }

    public LoaiSP( String ma_LoaiSP, String ten_DM, Boolean trang_thai) {
       
        this.ma_LoaiSP = ma_LoaiSP;
        this.ten_DM = ten_DM;
        this.trang_thai = trang_thai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMa_LoaiSP() {
        return ma_LoaiSP;
    }

    public void setMa_LoaiSP(String ma_LoaiSP) {
        this.ma_LoaiSP = ma_LoaiSP;
    }

    public String getTen_DM() {
        return ten_DM;
    }

    public void setTen_DM(String ten_DM) {
        this.ten_DM = ten_DM;
    }

    public Boolean getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(Boolean trang_thai) {
        this.trang_thai = trang_thai;
    }
    
}
