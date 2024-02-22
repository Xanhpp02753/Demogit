/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author Xuan Anh
 */
public class KhachHangViewModel { // Thứ 2
    
  private int stt;
    private int id;
    private String ma_KH;
    private String ten_KH;
    private Boolean gioi_tinh;
    private String tenGioiTinh;
    private String dienthoai;
    private String email;
    private String diaChi;
    private Boolean trang_thai;
    private String tenTrangThai;
    
    public KhachHangViewModel(){
    }

    public KhachHangViewModel(int stt, int id, String ma_KH, String ten_KH, Boolean gioi_tinh, String tenGioiTinh, String dienthoai, String email, String diaChi, Boolean trang_thai, String tenTrangThai) {
        this.stt = stt;
        this.id = id;
        this.ma_KH = ma_KH;
        this.ten_KH = ten_KH;
        this.gioi_tinh = gioi_tinh;
        this.tenGioiTinh = tenGioiTinh;
        this.dienthoai = dienthoai;
        this.email = email;
        this.diaChi = diaChi;
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

    public String getMa_KH() {
        return ma_KH;
    }

    public void setMa_KH(String ma_KH) {
        this.ma_KH = ma_KH;
    }

    public String getTen_KH() {
        return ten_KH;
    }

    public void setTen_KH(String ten_KH) {
        this.ten_KH = ten_KH;
    }

    public Boolean getGioi_tinh() {
        return gioi_tinh;
    }

    public void setGioi_tinh(Boolean gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public String getTenGioiTinh() {
        return tenGioiTinh;
    }

    public void setTenGioiTinh(String tenGioiTinh) {
        this.tenGioiTinh = tenGioiTinh;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
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
