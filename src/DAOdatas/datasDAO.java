/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOdatas;

import java.sql.*;
import java.util.*;
import koneksi.konektor;
import model.*;
import DAOImplement.dataservisimplement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author HP
 */
public class datasDAO implements dataservisimplement {

    Connection connection;

    final String select = "SELECT ds.*, s.keterangan "
            + "FROM data_servis ds "
            + "JOIN status s ON ds.id_status = s.id_status "
            + "WHERE ds.id_status = '2'";
    final String insert = "Insert into data_servis(nama_pelanggan, tanggal, no_telepon, jenis_device, nama_device, jenis_servis, deskripsi, total_biaya, id_status) VALUES(?,?,?,?,?,?,?,?,?);";
    final String selectHistory = "SELECT ds.*, s.keterangan "
            + "FROM data_servis ds "
            + "JOIN status s ON ds.id_status = s.id_status "
            + "WHERE ds.id_status = '1'";
    final String update = "UPDATE data_servis set nama_pelanggan=?, tanggal =?, no_telepon=?, jenis_device=?, nama_device=?, jenis_servis=?, deskripsi=?, total_biaya=?, id_status=? where id_servis=?; ";
    final String selectPembayaran = "SELECT ds.*, s.keterangan "
            + "FROM data_servis ds "
            + "JOIN status s ON ds.id_status = s.id_status "
            + "WHERE ds.id_status = '2'";

    public datasDAO() {
        connection = konektor.connection();
    }

    @Override
    public void insert(datas s) {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, s.getNama_pelanggan());
            java.util.Date utilDate = s.getTanggal();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            statement.setDate(2, sqlDate);
            statement.setString(3, s.getNo_telepon());
            statement.setString(4, s.getJenis_device());
            statement.setString(5, s.getNama_device());
            statement.setString(6, s.getJenis_servis());
            statement.setString(7, s.getDeskripsi());
            statement.setDouble(8, s.getTotal_biaya());
            statement.setInt(9, s.getId_status());

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                s.setId_status(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(datas s) {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, s.getNama_pelanggan());
            java.util.Date utilDate = s.getTanggal();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            statement.setDate(2, sqlDate);
            statement.setString(3, s.getNo_telepon());
            statement.setString(4, s.getJenis_device());
            statement.setString(5, s.getNama_device());
            statement.setString(6, s.getJenis_servis());
            statement.setString(7, s.getDeskripsi());
            statement.setDouble(8, s.getTotal_biaya());
            statement.setInt(9, s.getId_status());
            statement.setInt(10, s.getId_servis());

            statement.executeUpdate();

        } catch (SQLException ex) {
            
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();

            }
        }
    }

    @Override
    public void delete(Integer id_servis) {
        PreparedStatement statement = null;

        try {
            // Prepare the SQL DELETE statement
            String deleteSQL = "DELETE FROM data_servis WHERE id_servis = ?";
            statement = connection.prepareStatement(deleteSQL);
            statement.setInt(1, id_servis);

            // Execute the DELETE statement
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<datas> getAll() {
        List<datas> dp = null;
        try {
            dp = new ArrayList<datas>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                datas p = new datas();
                p.setId_servis(rs.getInt("id_servis"));
                p.setNama_pelanggan(rs.getString("nama_pelanggan"));
                p.setTanggal(rs.getDate("tanggal"));
                p.setNo_telepon(rs.getString("no_telepon"));
                p.setJenis_device(rs.getString("jenis_device"));
                p.setNama_device(rs.getString("nama_device"));
                p.setJenis_servis(rs.getString("jenis_servis"));
                p.setDeskripsi(rs.getString("deskripsi"));
                p.setTotal_biaya(rs.getDouble("total_biaya"));
                p.setId_status(rs.getInt("id_status"));
                p.setKeterangan(rs.getString("keterangan"));
                dp.add(p);
            }
        } catch (SQLException ex) {

            Logger.getLogger(datasDAO.class.getName()).log(Level.SEVERE, null, ex
            );
        }

        return dp;
    }

    @Override
        public List<datas> selecthistory(String jenisServis, String jenisDevice) {
        List<datas> dp = new ArrayList<>();
        StringBuilder query = new StringBuilder(selectHistory);

        if (!"Semua".equals(jenisServis) && !"Semua".equals(jenisDevice)) {
            query.append(" AND ds.jenis_servis = ? AND ds.jenis_device = ?");
        } else if (!"Semua".equals(jenisServis)) {
            query.append(" AND ds.jenis_servis = ?");
        } else if (!"Semua".equals(jenisDevice)) {
            query.append(" AND ds.jenis_device = ?");
        }

        try (PreparedStatement st = connection.prepareStatement(query.toString())) {
            int paramIndex = 1;
            if (!"Semua".equals(jenisServis)) {
                st.setString(paramIndex++, jenisServis);
            }
            if (!"Semua".equals(jenisDevice)) {
                st.setString(paramIndex++, jenisDevice);
            }
            
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                datas p = new datas();
                p.setId_servis(rs.getInt("id_servis"));
                p.setNama_pelanggan(rs.getString("nama_pelanggan"));
                p.setTanggal(rs.getDate("tanggal"));
                p.setNo_telepon(rs.getString("no_telepon"));
                p.setJenis_device(rs.getString("jenis_device"));
                p.setNama_device(rs.getString("nama_device"));
                p.setJenis_servis(rs.getString("jenis_servis"));
                p.setDeskripsi(rs.getString("deskripsi"));
                p.setTotal_biaya(rs.getDouble("total_biaya"));
                p.setId_status(rs.getInt("id_status"));
                p.setKeterangan(rs.getString("keterangan"));
                dp.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(datasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dp;
    }



    @Override
    public List<datas> selectpembayaran() {
        List<datas> dp = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(selectPembayaran);
            while (rs.next()) {
                datas p = new datas();
                p.setId_servis(rs.getInt("id_servis"));
                p.setNama_pelanggan(rs.getString("nama_pelanggan"));
                p.setTanggal(rs.getDate("tanggal"));
                p.setNo_telepon(rs.getString("no_telepon"));
                p.setJenis_device(rs.getString("jenis_device"));
                p.setNama_device(rs.getString("nama_device"));
                p.setJenis_servis(rs.getString("jenis_servis"));
                p.setDeskripsi(rs.getString("deskripsi"));
                p.setTotal_biaya(rs.getDouble("total_biaya"));
                p.setId_status(rs.getInt("id_status"));
                p.setKeterangan(rs.getString("keterangan"));
                dp.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(datasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dp;
    }

    @Override
    public List<datas> bayar(int id_servis) {
        PreparedStatement statement = null;
        try {
            String updateStatus = "UPDATE data_servis SET id_status = 1 WHERE id_servis = ?";
            statement = connection.prepareStatement(updateStatus);
            statement.setInt(1, id_servis);
            statement.executeUpdate();

            // Mengambil data yang diperbarui
            return selectpembayaran();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public int count() {
        int count = 0;
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            // Query untuk menghitung jumlah baris dengan id_status = 2
            String countQuery = "SELECT COUNT(*) AS count FROM data_servis WHERE id_status = 1";
            statement = connection.prepareStatement(countQuery);
            rs = statement.executeQuery();

            if (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException ex) {
            Logger.getLogger(datasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return count;
    }

}
