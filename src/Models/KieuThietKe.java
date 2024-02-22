/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Xuan Anh
 */
public class KieuThietKe {
    private int id;
    private String ma_ThietKe;
    private String mota_ThietKe;
    private Boolean trang_thai;
    
    public KieuThietKe(){
}

    public KieuThietKe( String ma_ThietKe, String mota_ThietKe, Boolean trang_thai) {
        
        this.ma_ThietKe = ma_ThietKe;
        this.mota_ThietKe = mota_ThietKe;
        this.trang_thai = trang_thai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMa_ThietKe() {
        return ma_ThietKe;
    }

    public void setMa_ThietKe(String ma_ThietKe) {
        this.ma_ThietKe = ma_ThietKe;
    }

    public String getMota_ThietKe() {
        return mota_ThietKe;
    }

    public void setMota_ThietKe(String mota_ThietKe) {
        this.mota_ThietKe = mota_ThietKe;
    }

    public Boolean getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(Boolean trang_thai) {
        this.trang_thai = trang_thai;
    }
    
}
