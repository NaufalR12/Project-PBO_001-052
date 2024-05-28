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
/**
 *
 * @author HP
 */
public class controllerPembayaran {
    pembayaran frame;
    dataservisimplement impldatas;
    List<datas> dp;

    public controllerPembayaran(pembayaran frame) {
        this.frame = frame;
        
        impldatas = new datasDAO();
        dp = impldatas.getAll();
    }
    
    public void isiPembayaran(){
        dp=impldatas.selectpembayaran();
        modeltabeldataservis mps = new modeltabeldataservis(dp);
        frame.getTabelPembayaran().setModel(mps);
    }
    
    public void bayarLunas(int id_servis){
        dp=impldatas.bayar(id_servis);
        modeltabeldataservis mps = new modeltabeldataservis(dp);
        frame.getTabelPembayaran().setModel(mps);
    }
    
    public void Reset(){
        frame.getjTxtID().setText("");
        frame.getjTxtTotal().setText("");
        frame.getjTxtBayar().setText("");
        frame.getjTxtKembalian().setText("");
        
    }
}
