package com.example.rajaampat.editProfile;

import java.io.File;

public class EditProfilModel {
    private String id, nama, telpon, ktp, tanggalLahir, tempatLahir, alamat, email, passpord;
    private File fileGambar;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelpon() {
        return telpon;
    }

    public void setTelpon(String telpon) {
        this.telpon = telpon;
    }

    public String getKtp() {
        return ktp;
    }

    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasspord() {
        return passpord;
    }

    public void setPasspord(String passpord) {
        this.passpord = passpord;
    }

    public File getFileGambar() {
        return fileGambar;
    }

    public void setFileGambar(File fileGambar) {
        this.fileGambar = fileGambar;
    }
}
