package pertemuanKeempatPBO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseCRUD {

    /**
     * @param args the command line arguments
     */
    Connection conn;
    Statement stmt;
    PreparedStatement pstmt = null;

    String driver = "org.postgresql.Driver";
    String koneksi = "jdbc:postgresql://localhost:5432/Perhotelan";
    String user = "postgres";
    String password = "123";
    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    BufferedReader input = new BufferedReader(inputStreamReader);

    public static void main(String[] args) {
        new DatabaseCRUD().menu();
    }

    public void tambah() throws Exception {
        Class.forName(driver);
        conn = DriverManager.getConnection(koneksi, user, password);
        conn.setAutoCommit(false);

        String sql = "INSERT INTO tamu VALUES(?,?,?,?)";
        pstmt = conn.prepareStatement(sql);
        int k = 0;
        boolean selesai = false;
        while (!selesai) {
            try {
                System.out.println("MASUKKAN DATA TAMU ");
                System.out.print("ID Tamu : ");
                int id_tamu = Integer.parseInt(input.readLine().trim());
                System.out.print("Nama : ");
                String nama = input.readLine().trim();
                System.out.print("Nomor Telp : ");
                String no_telp = input.readLine().trim();
                System.out.print("Alamat : ");
                String alamat = input.readLine().trim();

                pstmt.setInt(1, id_tamu);
                pstmt.setString(2, nama);
                pstmt.setString(3, no_telp);
                pstmt.setString(4, (alamat));
                int n = pstmt.executeUpdate();
                k = n + k;
                System.out.print("ketik 1 untuk melanjutkan ketik 2 untuk selesai ");
                int pilihan = Integer.parseInt(input.readLine().trim());
                if (pilihan == 1) {
                    selesai = false;
                }
                if (pilihan == 2) {
                    selesai = true;

                }

                System.out.println(k + " data sukses dalam  transaksi.");
                conn.commit();
                pstmt.close();
                conn.close();

            } catch (SQLException | IOException | NumberFormatException ex) {
                System.out.println("Terjadi kesalahan saat memasukkan data tamu: " + ex.getMessage());
                
                try {
                    if (conn != null) {
                        conn.rollback();
                    }
                } catch (SQLException e) {
                    System.out.println("Gagal melakukan rollback transaksi.");  
                }
            }
        }

    }

    public void tampil() throws Exception {

        
        Class.forName(driver);
        String sql = "SELECT * FROM tamu";
        conn = DriverManager.getConnection(koneksi, user, password);
        stmt = conn.createStatement();

        while (!conn.isClosed()) {
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(String.valueOf(rs.getObject(1)) + "|" + String.valueOf(rs.getObject(2)) + "|"
                        + String.valueOf(rs.getObject(3)) + "|" + String.valueOf(rs.getObject(4)));
            }
            conn.close();
        }
        stmt.close();
    }

    public void hapus() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(koneksi, user, password);
            conn.setAutoCommit(false);
            int k = 0;
            boolean selesai = false;
            while (!selesai) {
                System.out.print("Masukkan ID Tamu yang akan dihapus : ");
                int id_tamu = Integer.parseInt(input.readLine());

                String sql = "DELETE FROM tamu WHERE id_tamu = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, id_tamu);
                int rowsAffected = pstmt.executeUpdate();

                System.out.print("ketik 1 untuk melanjutkan ketik 2 untuk selesai ");
                int pilihan = Integer.parseInt(input.readLine().trim());
                if (pilihan == 1) {
                    selesai = false;
                }
                if (pilihan == 2) {
                    selesai = true;
                }
                k = rowsAffected + k;
            }
            System.out.println(k + " data sukses dihapus.");
            conn.commit();
            pstmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            System.out.println("Terjadi kesalahan saat memasukkan data tamu: " + ex.getMessage());
            ex.printStackTrace();
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e) {
                System.out.println("Gagal melakukan rollback transaksi.");
                e.printStackTrace();
            }
        }
    }

    public void update() {
        try {
            Class.forName(driver);
            String sql = "UPDATE tamu SET nama = ?, no_telp = ?, alamat = ? WHERE id_tamu = ?";
            conn = DriverManager.getConnection(koneksi, user, password);
            pstmt = conn.prepareStatement(sql);
            conn.setAutoCommit(false);
            int k = 0;
            boolean selesai = false;
            while (!selesai) {
                System.out.print("Masukkan ID Tamu yang akan diupdate: ");
                int id_tamu = Integer.parseInt(input.readLine().trim());
                System.out.print("Nama : ");
                String nama = input.readLine().trim();
                System.out.print("No Telp: ");
                String no_telp = input.readLine().trim();
                System.out.print("Alamat : ");
                String alamat = input.readLine().trim();

                pstmt.setString(1, nama);
                pstmt.setString(2, no_telp);
                pstmt.setString(3, alamat);
                pstmt.setInt(4, id_tamu);
                int n = pstmt.executeUpdate();
                k += n;
                System.out.print("ketik 1 untuk melanjutkan ketik 2 untuk selesai ");
                int pilihan = Integer.parseInt(input.readLine().trim());
                if (pilihan == 1) {
                    selesai = false;
                }
                if (pilihan == 2) {
                    selesai = true;
                }
            }
            System.out.println(k + " data sukses diupdate");
            conn.commit();
            pstmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            System.out.println("Terjadi kesalahan saat memasukkan data tamu: " + ex.getMessage());
            ex.printStackTrace();
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e) {
                System.out.println("Gagal melakukan rollback transaksi.");
                e.printStackTrace();
            }
        }
    }

    public void menu() {
        System.out.println("========= MENU UTAMA =========");
        System.out.println("1. Input Data");
        System.out.println("2. Tampil Data");
        System.out.println("3. Hapus Data");
        System.out.println("4. Update Data");
        System.out.println("0. keluar");
        System.out.print("PILIHAN> ");
        try {
            int pilihan = Integer.parseInt(input.readLine());
            switch (pilihan) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                {
                    try {
                        tambah();
                    } catch (Exception ex) {
                        Logger.getLogger(DatabaseCRUD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;

                case 2: {
                    try {
                        tampil();
                    } catch (Exception ex) {
                        Logger.getLogger(DatabaseCRUD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case 3:
                    hapus();
                    break;
                case 4:
                    update();
                    break;
                default:
                    System.out.println("Pilihan salah!");

            }
        }catch (IOException ex) {
            Logger.getLogger(DatabaseCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
