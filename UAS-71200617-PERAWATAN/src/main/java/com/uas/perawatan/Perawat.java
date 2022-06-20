package com.uas.perawatan;

public class Perawat {
    private int idPerawat;
    private String nama;

    public Perawat(String nama) {
        this.nama = nama;
    }

    public void screening(Pengunjung pengunjung,Daftar daftar){
        if(daftar.getPerawat().equals(this) && daftar.getPengunjung().equals(pengunjung) && daftar.getStatusDaftar()){
            daftar.setStatusScreening(true);
            System.out.println("Proses Screening Perawat Berhasil!");
        }
        else{
            System.out.println("ANDA HARUS MELAKUKAN PROSES PENDAFTARAN TERLEBIH DAHULU DI BAGIAN PELAYANAN");
        }
    }

    public int getIdPerawat() {
        return idPerawat;
    }
}
