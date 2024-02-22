/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author Xuan Anh
 */
public class KieuThietKeViewModel {
    private int stt;
   private int id;
    private String ma_ThietKe;
    private String mota_ThietKe;
    private Boolean trang_thai;
    private String tenTrangThai;
    public KieuThietKeViewModel(){
        
    }

    public KieuThietKeViewModel(int stt, int id, String ma_ThietKe, String mota_ThietKe, Boolean trang_thai, String tenTrangThai) {
        this.stt = stt;
        this.id = id;
        this.ma_ThietKe = ma_ThietKe;
        this.mota_ThietKe = mota_ThietKe;
        this.trang_thai = trang_thai;
        this.tenTrangThai = tenTrangThai;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
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

    public String getTenTrangThai() {
        return tenTrangThai;
    }

    public void setTenTrangThai(String tenTrangThai) {
        this.tenTrangThai = tenTrangThai;
    }
    
}
