/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.Date;
/**
 *
 * @author HP
 */
public class datas {
    private int id_servis;
    private String nama_pelanggan;
    private Date tanggal;
    private String no_telepon;
    private String jenis_device;
    private String nama_device;
    private String jenis_servis;
    private String deskripsi;
    private Double total_biaya;
    private int id_status;
    private String keterangan;

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public int getId_servis() {
        return id_servis;
    }

    public String getNama_pelanggan() {
        return nama_pelanggan;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public String getNo_telepon() {
        return no_telepon;
    }

    public String getJenis_device() {
        return jenis_device;
    }

    public String getNama_device() {
        return nama_device;
    }

    public String getJenis_servis() {
        return jenis_servis;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public Double getTotal_biaya() {
        return total_biaya;
    }

    public int getId_status() {
        return id_status;
    }

    public void setId_servis(int id_servis) {
        this.id_servis = id_servis;
    }

    public void setNama_pelanggan(String nama_pelanggan) {
        this.nama_pelanggan = nama_pelanggan;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public void setNo_telepon(String no_telepon) {
        this.no_telepon = no_telepon;
    }

    public void setJenis_device(String jenis_device) {
        this.jenis_device = jenis_device;
    }

    public void setNama_device(String nama_device) {
        this.nama_device = nama_device;
    }

    public void setJenis_servis(String jenis_servis) {
        this.jenis_servis = jenis_servis;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setTotal_biaya(Double total_biaya) {
        this.total_biaya = total_biaya;
    }

    public void setId_status(int id_status) {
        this.id_status = id_status;
    }
    
    
}
