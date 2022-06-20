package com.uas.perawatan;

/**
 * Hello world!
 *
 */

public class App {
    public static void main(String[] args) {
        System.out.println("===========================================PROSES INISIALISASI============================================");
        System.out.println();
        DAO dao = DAO.getConnection();
        Daftar jadwal = new Daftar();
        Pengunjung illegal = new Pengunjung("test",21,"di mana saja");
        Pendaftaran pelayanan = new Pendaftaran("Andi");
        Perawat suster = new Perawat("Siti");
        Pemeriksa dokter = new Pemeriksa(1,"Budi", "Organ Dalam", "A123");
        Pengunjung pasien = pelayanan.registrasi();
        pelayanan.mengaturJadwal(pasien, dokter, suster, jadwal);
        System.out.println("===========================================PROSES UJI COBA PASIEN DAN JADWAL ILLEGAL============================================");
        System.out.println();
        suster.screening(illegal, jadwal);
        dokter.memeriksa(illegal, jadwal);
        System.out.println("===========================================PROSES UJI COBA PASIEN DAN JADWAL ILLEGAL BERHASIL============================================");
        System.out.println();
        System.out.println("===========================================PROSES SCREENING SUSTER============================================");
        System.out.println();
        suster.screening(pasien, jadwal);
        System.out.println("===========================================PROSES SCREENING SUTER BERHASIL============================================");
        System.out.println();
        System.out.println("===========================================PROSES PEMERIKSAAN DOKTER============================================");
        System.out.println();
        int x = pasien.getLevelPenyakit();
        for(int i = 0; i <= x; i++) {
            dokter.memeriksa(pasien, jadwal);
            dokter.cekStatus(pasien, jadwal);
        }
        System.out.println("===========================================PROSES PEMERIKSAAN DOKTER BERHASIL============================================");
        System.out.println();
        dao.getPengunjungSembuh();
    }
}
