package com.uas.perawatan;

public class Pemeriksa {
    private int idPemeriksa;
    private String nama;
    private String spesialis;
    private String ruangan;

    public Pemeriksa(int idPemeriksa, String nama, String spesialis, String ruangan) {
        this.idPemeriksa = idPemeriksa;
        this.nama = nama;
        this.spesialis = spesialis;
        this.ruangan = ruangan;
    }

    public void memeriksa(Pengunjung pengunjung, Daftar daftar){
        if(daftar.getPengunjung().equals(pengunjung) && daftar.getStatusScreening()) {
            if(pengunjung.getLevelPenyakit() <= 0) {
                pengunjung.setStatus(true);
                DAO.getConnection().updateStatusPasien(daftar);
            }
            else if(pengunjung.getLevelPenyakit() > 0){
                int newLevel = pengunjung.getLevelPenyakit() - 1;
                pengunjung.setLevelPenyakit(newLevel);
            }
        }else{
            System.out.println("ANDA HARUS MELAKUKAN PROSES PENDAFTARAN TERLEBIH DAHULU DI BAGIAN PELAYANAN");
        }
    }

    public void cekStatus(Pengunjung pasien, Daftar jadwal){
        if(pasien.getStatus()){
            System.out.println("Selamat Pasien Anda Sudah Sembuh dan Sehat");
            System.out.println("Status Pasien Berhasil Diubah");
        }
        else{
            System.out.println("Pasien Anda Masih Sakit");
        }
    }

    public int getIdPemeriksa() {
        return idPemeriksa;
    }

    public void setIdPemeriksa(int idPemeriksa) {
        this.idPemeriksa = idPemeriksa;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSpesialis() {
        return spesialis;
    }

    public void setSpesialis(String spesialis) {
        this.spesialis = spesialis;
    }

    public String getRuangan() {
        return ruangan;
    }

    public void setRuangan(String ruangan) {
        this.ruangan = ruangan;
    }
}
