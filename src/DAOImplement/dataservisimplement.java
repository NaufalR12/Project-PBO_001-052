/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImplement;

import java.util.List;
import model.*;

/**
 *
 * @author HP
 */
public interface dataservisimplement {

    public void insert(datas s);

    public void update(datas s);

    public void delete(Integer id_servis);
    public List<datas> selecthistory(String jenis_servis, String jenis_device);
    public List<datas> selectpembayaran();
    public List<datas> bayar(int id_servis);

    public List<datas> getAll();
    public int count();
}
