package com.uas.perawatan;

import java.sql.*;

public class DAO {
    private final String url = "jdbc:sqlite:perawatan.db";
    private Connection conn = null;

    public DAO(){

        try {
            conn = DriverManager.getConnection(url);
        }catch (Exception e){
            System.out.println("Koneksi gagal");
        }
    }

    public static DAO getConnection(){
        return new DAO();
    }

    public Pemeriksa getPemeriksaByID(int id) {
        String sql = "SELECT * FROM pemeriksa WHERE idDokter = " + id;
        String nama = "";
        String spesialis = "";
        String ruangan = "";
        try(Statement stat = conn.createStatement()){
            ResultSet result =  stat.executeQuery(sql);
            while (result.next()){
                nama = result.getString("nama");
                spesialis = result.getString("spesialis");
                ruangan = result.getString("ruangan");
            }
            Pemeriksa pemeriksa = new Pemeriksa(1,nama, spesialis, ruangan);
            return pemeriksa;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }finally {
            if (conn != null) {
                try {
                    conn.close(); // <-- This is important
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public Perawat getPerawatByID(int id){
        String sql = "SELECT * FROM perawat WHERE idPerawat = " + id;
        String nama = "";
        try(Statement stat = conn.createStatement()){
            ResultSet result =  stat.executeQuery(sql);
            while (result.next()){
                nama = result.getString("nama");
            }
            Perawat perawat = new Perawat(nama);
            return perawat;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }finally {
            if (conn != null) {
                try {
                    conn.close(); // <-- This is important
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void inputPengunjung(Pengunjung pengunjung) {
        String sql = "INSERT INTO pengunjung (rm, nama, usia, alamat) VALUES (" + pengunjung.getRm() + ", '" + pengunjung.getNama() + "', " + pengunjung.getUsia() + ", '" + pengunjung.getAlamat() + "')";
        try {
            conn.createStatement().execute(sql);
            System.out.println("Insert berhasil");
        } catch (SQLException e) {
            System.out.println("Insert gagal");
            System.out.println(e.getMessage());
        }finally {
            if (conn != null) {
                try {
                    conn.close(); // <-- This is important
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void inputJadwal(Daftar daftar) {
        int status = daftar.getPengunjung().getStatus() ? 1 : 0;
        String sql = "INSERT INTO jadwal VALUES (" + daftar.getIdPemeriksaan() + ", " + daftar.getPengunjung().getRm() + ", " + daftar.getPemeriksa().getIdPemeriksa() + ", " + daftar.getPerawat().getIdPerawat() + ", " + daftar.getPendaftaran().getIdPendaftaran() + ", " + status + ")";
        try {
            conn.createStatement().execute(sql);
            System.out.println("Insert berhasil");
        } catch (SQLException e) {
            System.out.println("Insert gagal");
            System.out.println(e.getMessage());
        }finally {
            if (conn != null) {
                try {
                    conn.close(); // <-- This is important
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public Pendaftaran getPendaftaranByID(int id) {
        String sql = "SELECT * FROM pendaftaran WHERE idPendaftaran = " + id;
        String nama = "";
        try(Statement stat = conn.createStatement()){
            ResultSet result =  stat.executeQuery(sql);
            while (result.next()){
                nama = result.getString("nama");
            }
            Pendaftaran pelayanan = new Pendaftaran(nama);
            return pelayanan;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }finally {
            if (conn != null) {
                try {
                    conn.close(); // <-- This is important
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void getPengunjungSembuh() {
        String sql = "SELECT rm FROM daftar WHERE status = 1";
        try(Statement stat = conn.createStatement()){
            ResultSet result =  stat.executeQuery(sql);
            while (result.next()){
                System.out.println("Pengunjung dengan ID " + result.getInt("rm") + " telah sembuh");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            if (conn != null) {
                try {
                    conn.close(); // <-- This is important
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void updateStatusPasien(Daftar jadwal) {
        String sql = "UPDATE daftar SET status = 1 WHERE idPendaftaran = " + jadwal.getIdPemeriksaan();
        try(Statement stat = conn.createStatement()){
            stat.execute(sql);
            System.out.println("Update berhasil");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            if (conn != null) {
                try {
                    conn.close(); // <-- This is important
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void createTablePasien(){
        String sql = "CREATE TABLE IF NOT EXISTS pengunjung (rm INTEGER PRIMARY KEY, nama VARCHAR(255), usia INTEGER, alamat VARCHAR(255))";
        try {
            conn.createStatement().execute(sql);
            System.out.println("Tabel pengunjung berhasil dibuat");
        } catch (Exception e) {
            System.out.println("Tabel pengunjung gagal dibuat");
        }
    }

    public void createTableJadwal(){
        String sql = "CREATE TABLE IF NOT EXISTS daftar (idPemeriksaan INTEGER PRIMARY KEY, rm INTEGER, idDokter INTEGER, idSuster INTEGER, idPelayanan INTEGER, status INETEGER)";
        try {
            conn.createStatement().execute(sql);
            System.out.println("Tabel jadwal berhasil dibuat");
        } catch (Exception e) {
            System.out.println("Tabel jadwal gagal dibuat");
        }
    }
}
