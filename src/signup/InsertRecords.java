package signup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertRecords {
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:D://MMT/Assignment1/Chat Application/Data.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insert(String name, String user_name,String email,String password,String gender,String phonenumber,String ip_addr,String port,Boolean status) {
        String sql = "INSERT INTO usersinfo(name,user_name,email,password,gender,phonenumber,ip_addr,port,status) VALUES(?,?,?,?,?,?,?,?,?)";
        //System.out.println("ok");
        try{
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, user_name);
            pstmt.setString(3, email);
            pstmt.setString(4, password);
            pstmt.setString(5, gender);
            pstmt.setString(6, phonenumber);
            pstmt.setString(7, ip_addr);
            pstmt.setString(8, port);
            pstmt.setBoolean(9, status.booleanValue());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

//    public static void main(String[] args) {
//// name,user_name,email,password,gender,phonenumber,ip_addr,port,status) VALUES(?,?,?,?,?,?,?,?,?)";
//        InsertRecords app = new InsertRecords();
//        // insert three new rows
//        app.insert("Lucy", "lucky","abasc@gmail.com","123123","Other","0162728374","198.1.21.22","2144",Boolean.TRUE);
//        app.insert("Daniel", "daniel","abcbc@gmail.com","12a31a23","Male","0167238374","198.1.21.10","2234",Boolean.TRUE);
//        app.insert("Bamm", "binbam","binbam@gmail.com","qwqwqw","Other","0163338374","198.1.33.2","3334",Boolean.FALSE);
//
//    }
}