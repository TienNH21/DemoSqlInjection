package repositories;

import utils.DBContext;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.NhanVien;

public class NhanVienRepository {
    private Connection conn;
    
    public NhanVienRepository()
    {
        try {
            this.conn = DBContext.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public NhanVien login1(String email, String password)
    {
        String sql = "SELECT * FROM NhanVien "
            + " WHERE TenDangNhap = '" + email
            + "' AND MatKhau = '" + password + "'";
        
        try {
            Statement ps = this.conn.createStatement();
            ps.execute(sql);
            ResultSet rs = ps.getResultSet();
            if (rs.next() == true) {
                int id = rs.getInt("ID");
                String username = rs.getString("TenDangNhap");
                String pwd = rs.getString("MatKhau");
                return new NhanVien(id, username, pwd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public List<NhanVien> findAll()
    {
        List<NhanVien> result = new ArrayList<>();
        
        String sql = "SELECT * FROM NhanVien";
        
        try {
            Statement ps = this.conn.createStatement();
            ps.execute(sql);
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                int id = rs.getInt("ID");
                String ten = rs.getString("Ten");
                String ma = rs.getString("Ma");
                int trangThai = rs.getInt("TrangThai");
                String username = rs.getString("TenDangNhap");
                String pwd = rs.getString("MatKhau");
                
                result.add(new NhanVien(id, ten, ma, username, pwd, trangThai));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }
    
    public List<NhanVien> findByMa(String keyword)
    {
        List<NhanVien> result = new ArrayList<>();
        
        String sql = "SELECT * FROM NhanVien WHERE Ma LIKE '%" + keyword + "%'";
        System.out.println(sql);
        System.out.println("---------------------");
        try {
            Statement ps = this.conn.createStatement();
            ps.execute(sql);
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                int id = rs.getInt("ID");
                String ten = rs.getString("Ten");
                String ma = rs.getString("Ma");
                int trangThai = rs.getInt("TrangThai");
                String username = rs.getString("TenDangNhap");
                String pwd = rs.getString("MatKhau");
                
                result.add(new NhanVien(id, ten, ma, username, pwd, trangThai));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }
}
