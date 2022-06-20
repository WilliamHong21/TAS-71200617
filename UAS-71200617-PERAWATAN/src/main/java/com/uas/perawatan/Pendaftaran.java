package com.uas.perawatan;
import sun.security.util.Pem;

import java.util.Scanner;

public class Pendaftaran {

    private int idPendaftaran;
    private String nama;

    public Pendaftaran(String nama) {
        this.nama = nama;
    }

    public void mengaturJadwal(Pengunjung pengunjung,Pemeriksa pemeriksa, Perawat perawat, Daftar daftar) {
        if(!pengunjung.getStatus()) {
            daftar.setPengunjung(pengunjung);
            daftar.setPemeriksa(pemeriksa);
            daftar.setPerawat(perawat);
            daftar.setPendaftaran(this);
            daftar.setStatusDaftar(true);
            DAO.getConnection().inputJadwal(daftar);
            System.out.println("Data daftar berhasil disimpan");
        } else {
            System.out.println("pengunjung masih sehat");
        }

    }

    public Pengunjung registrasi(){
        Scanner inp = new Scanner(System.in);
        System.out.print("Rm: ");
        int rm = inp.nextInt();
        inp.nextLine();
        System.out.print("Nama: ");
        String nama = inp.nextLine();
        System.out.print("Usia: ");
        int usia = inp.nextInt();
        inp.nextLine();
        System.out.print("Alamat: ");
        String alamat = inp.nextLine();
        System.out.print("Penyakit: ");
        String penyakit = inp.nextLine();
        Pengunjung pengunjung = new Pengunjung(rm,nama, usia, alamat,penyakit);
        DAO.getConnection().inputPengunjung(pengunjung);
        pengunjung.setStatus(false);
        System.out.println("Data pengunjung berhasil disimpan!");
        return pengunjung;
    }

    public int getIdPendaftaran() {
        return idPendaftaran;
    }
}

