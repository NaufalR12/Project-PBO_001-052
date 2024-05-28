/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import DAOdatas.datasDAO;
import DAOImplement.dataservisimplement;
import model.*;
import view.*;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.*;

/**
 *
 * @author HP
 */
public class datascontroller {

    registrasi frame;
    dataservisimplement impldatas;
    List<datas> dp;

    public datascontroller(registrasi frame) {
        this.frame = frame;

        impldatas = new datasDAO();
        dp = impldatas.getAll();
    }

    public void isitabel() {
        dp = impldatas.getAll();
        modeltabeldataservis mp = new modeltabeldataservis(dp);
        frame.getjTable1().setModel(mp);
    }

    public void insert() {
    String nama = frame.getBtnNama().getText();
    String tanggal = frame.getBtnTgl().getText();
    String nohp = frame.getBtnNomor().getText();
    String jenis_device = frame.getBtnJenisdevice().getSelectedItem().toString();
    String namaD = frame.getBtnNamaDevice().getText();
    String jenisS = frame.getBtnJenisservis().getSelectedItem().toString();
    String deskripsi = frame.getBtnDeskripsi().getText();
    String total = frame.getBtnTotal().getText();
    String idS = "2";

    // Cek apakah semua field sudah diisi
    if (nama.isEmpty() || tanggal.isEmpty() || nohp.isEmpty() || jenis_device.isEmpty() || namaD.isEmpty() || jenisS.isEmpty() || deskripsi.isEmpty() || total.isEmpty()) {
        JOptionPane.showMessageDialog(frame, "Harap isi semua field", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    try {
        Date tgl = dateFormat.parse(tanggal);
        
        // Cek apakah total biaya adalah angka yang valid
        double totalbiaya;
        try {
            totalbiaya = Double.parseDouble(total);
            if (totalbiaya <0) {
            JOptionPane.showMessageDialog(frame, "Jangan masukkan nilai negatif", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Total biaya harus berupa angka yang valid.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return; // Keluar dari metode jika total_biaya tidak valid
        }

        int IDS = Integer.parseInt(idS);

        datas ds = new datas();
        ds.setNama_pelanggan(nama);
        ds.setTanggal(tgl);
        ds.setNo_telepon(nohp);
        ds.setJenis_device(jenis_device);
        ds.setNama_device(namaD);
        ds.setJenis_servis(jenisS);
        ds.setDeskripsi(deskripsi);
        ds.setTotal_biaya(totalbiaya);
        ds.setId_status(IDS);

        impldatas.insert(ds);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");

        // Reset form fields setelah berhasil ditambahkan
        frame.getBtnID().setText("");
        frame.getBtnNama().setText("");
        frame.getBtnNomor().setText("");
        frame.getBtnNamaDevice().setText("");
        frame.getBtnTgl().setText("");
        frame.getBtnJenisdevice().setSelectedItem(null);
        frame.getBtnJenisservis().setSelectedItem(null); 
        frame.getBtnDeskripsi().setText("");
        frame.getBtnTotal().setText("");

    } catch (ParseException e) {
        JOptionPane.showMessageDialog(frame, "Format tanggal salah. Harap gunakan format dd-MM-yyyy", "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
}

    public void update() {
        String nama = frame.getBtnNama().getText();
        String tanggal = frame.getBtnTgl().getText();
        String nohp = frame.getBtnNomor().getText();
        String jenis_device = frame.getBtnJenisdevice().getSelectedItem().toString();
        String namaD = frame.getBtnNamaDevice().getText();
        String jenisS = frame.getBtnJenisservis().getSelectedItem().toString();
        String deskripsi = frame.getBtnDeskripsi().getText();
        String total = frame.getBtnTotal().getText();
        String id_servis = frame.getBtnID().getText();
        String idS = "2";

        if (nama.isEmpty() || tanggal.isEmpty() || nohp.isEmpty() || jenis_device.isEmpty() || namaD.isEmpty() || jenisS.isEmpty() || deskripsi.isEmpty() || total.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Harap isi semua field", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            Date tgl = dateFormat.parse(tanggal);
            
            int IDS = Integer.parseInt(idS);
            int id_Servis = Integer.parseInt(id_servis);
            
            double totalbiaya;
        try {
            totalbiaya = Double.parseDouble(total);
            if (totalbiaya <0) {
            JOptionPane.showMessageDialog(frame, "Jangan masukkan nilai negatif", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Total biaya harus berupa angka yang valid.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return; // Keluar dari metode jika total_biaya tidak valid
        }

            datas ds = new datas();
            ds.setNama_pelanggan(nama);
            ds.setTanggal(tgl);
            ds.setNo_telepon(nohp);
            ds.setJenis_device(jenis_device);
            ds.setNama_device(namaD);
            ds.setJenis_servis(jenisS);
            ds.setDeskripsi(deskripsi);
            ds.setTotal_biaya(totalbiaya);
            ds.setId_status(IDS);
            ds.setId_servis(id_Servis);
            impldatas.update(ds);
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");

            frame.getBtnID().setText("");
            frame.getBtnNama().setText("");
            frame.getBtnNomor().setText("");
            frame.getBtnNamaDevice().setText("");
            frame.getBtnTgl().setText("");
            frame.getBtnJenis().setSelectedItem(null);
            frame.getBtnJenisServis().setSelectedItem(null); 
            frame.getBtnDeskripsi().setText("");
            frame.getBtnNamaDevice().setText("");
            frame.getBtnStatus().setText("");
            frame.getBtnTotal().setText("");

        } catch (ParseException e) {
            JOptionPane.showMessageDialog(frame, "Format tanggal salah. Harap gunakan format dd-MM-yyyy", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void delete() {
        String id_servis = frame.getBtnID().getText();

        if (id_servis.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Harap isi ID Servis", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int id_Servis = Integer.parseInt(id_servis);
            impldatas.delete(id_Servis);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");

            frame.getBtnID().setText("");
            frame.getBtnNama().setText("");
            frame.getBtnNomor().setText("");
            frame.getBtnNamaDevice().setText("");
            frame.getBtnTgl().setText("");
            frame.getBtnJenis().setSelectedItem(null);
            frame.getBtnJenisServis().setSelectedItem(null); 
            frame.getBtnDeskripsi().setText("");
            frame.getBtnNamaDevice().setText("");
            frame.getBtnStatus().setText("");
            frame.getBtnTotal().setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Format ID salah. Harap gunakan format angka", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void reset() {
        frame.getBtnID().setText("");
        frame.getBtnNama().setText("");
        frame.getBtnNomor().setText("");
        frame.getBtnNamaDevice().setText("");
        frame.getBtnTgl().setText("");
        frame.getBtnJenis().setSelectedItem(null);
        frame.getBtnJenisServis().setSelectedItem(null); 
        frame.getBtnDeskripsi().setText("");
        frame.getBtnNamaDevice().setText("");
        frame.getBtnStatus().setText("");
        frame.getBtnTotal().setText("");
    }
}
