/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connect.Connect;
import Model.KhachHang;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class KhachHangController {
    public List<KhachHang> getKhachHang(){
        String sql = "select * from KhachHang";
        List<KhachHang> lsp = new ArrayList<KhachHang>();
        try {
            Connection db = new Connect().connect(); 
            PreparedStatement prSt = db.prepareStatement(sql);
            
            ResultSet rs = prSt.executeQuery();
            while(rs.next()){
                KhachHang ob = new KhachHang();
                ob.setMaKH(rs.getString("MaKH"));
                ob.setTenKH(rs.getString("TenKH"));
                ob.setSDT(rs.getString("SĐT"));
                ob.setEmail(rs.getString("Email"));
                ob.setGioiTinh(rs.getString("GioiTinh"));
                ob.setDiaChi(rs.getString("DiaChi"));
                ob.setNgaySinh(rs.getString("NgaySinh"));
                lsp.add(ob);
            }
            prSt.close();
            db.close();
                   
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
        return lsp;
    }
    
    public boolean ThemKhachHang(KhachHang kh){
        String sql = "insert into KhachHang values(?,?,?,?,?,?,?)";
        try{
            Connection db = new Connect().connect(); 
            PreparedStatement prSt = db.prepareStatement(sql);
            prSt.setString(1, kh.getMaKH());
            prSt.setString(2, kh.getTenKH());
            prSt.setString(3, kh.getSDT());
            prSt.setString(4, kh.getEmail());
            prSt.setString(5, kh.getGioiTinh());
            prSt.setString(6, kh.getDiaChi());
            prSt.setString(7, kh.getNgaySinh());
            
            int r = prSt.executeUpdate();
            prSt.close();
            db.close();
            return r == 1;
                   
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
            return false;
        }
    }
    
    public boolean SuaKhachHang(KhachHang kh){
        String sql = "update KhachHang set TenKH = ?, SĐT = ?, Email = ?, GioiTinh = ?, DiaChi = ?, NgaySinh = ? where MaKH = ?)";
        try{
            Connection db = new Connect().connect(); 
            PreparedStatement prSt = db.prepareStatement(sql);
            prSt.setString(1, kh.getMaKH());
            prSt.setString(2, kh.getTenKH());
            prSt.setString(3, kh.getSDT());
            prSt.setString(4, kh.getEmail());
            prSt.setString(5, kh.getGioiTinh());
            prSt.setString(6, kh.getDiaChi());
            prSt.setString(7, kh.getNgaySinh());
            
            int r = prSt.executeUpdate();
            prSt.close();
            db.close();
            return r == 1;
                   
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
            return false;
        }
    }
    
    public boolean XoaKhachHang(KhachHang kh){
        String sql = "delete from KhachHang where MaKH = ? ";
        try{
            Connection db = new Connect().connect(); 
            PreparedStatement prSt = db.prepareStatement(sql);
            prSt.setString(1, kh.getMaKH());
            
            int r = prSt.executeUpdate();
            prSt.close();
            db.close();
            return r == 1;
                   
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
            return false;
        }
    }
    
    public List<KhachHang> TimKiemKhachHang(String TenSP){
        List<KhachHang> ltKH = new ArrayList<KhachHang>();
        String sql = "select * from KhachHang where TenSP like ? ";
        try{
            Connection db = new Connect().connect(); 
            PreparedStatement prSt = db.prepareStatement(sql);
            prSt.setString(1, "%"+ TenSP + "%" );
            ResultSet rs = prSt.executeQuery();
            while(rs.next()){
                KhachHang ob = new KhachHang();
                ob.setMaKH(rs.getString("MaKH"));
                ob.setTenKH(rs.getString("TenKH"));
                ob.setSDT(rs.getString("SDT"));
                ob.setEmail(rs.getString("Email"));
                ob.setGioiTinh(rs.getString("GioiTinh"));
                ob.setDiaChi(rs.getString("DiaChi"));
                ob.setNgaySinh(rs.getString("NgaySinh"));
                ltKH.add(ob);
            }
            prSt.close();
            db.close();
                  
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
        return ltKH;
    }
    
    
}
