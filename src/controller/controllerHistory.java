package controller;

import java.util.List;
import DAOdatas.datasDAO;
import DAOImplement.dataservisimplement;
import model.datas;
import view.history;
import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author HP
 */
public class controllerHistory {

    history frame;
    dataservisimplement impldatas;
    List<datas> dp;

    public controllerHistory(history frame) {
        this.frame = frame;
        impldatas = new datasDAO();
        dp = impldatas.getAll();
    }

     public void isiHistory() {
        String jenisServis = frame.getjCBServis().getSelectedItem().toString();
        String jenisDevice = frame.getjCBDevice().getSelectedItem().toString();
        List<datas> dataHistory = impldatas.selecthistory(jenisServis, jenisDevice);
        
        DefaultTableModel model = (DefaultTableModel) frame.getTabelHistory().getModel();
        model.setRowCount(0);
        
        for (datas data : dataHistory) {
            model.addRow(new Object[]{
                data.getId_servis(), data.getNama_pelanggan(), data.getTanggal(),
                data.getNo_telepon(), data.getJenis_device(), data.getNama_device(),
                data.getJenis_servis(), data.getDeskripsi(), data.getTotal_biaya(), data.getKeterangan()
            });
        }
        
        frame.getjTxtJumlah().setText(String.valueOf(dataHistory.size()));
    }
}
