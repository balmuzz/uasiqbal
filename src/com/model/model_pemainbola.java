/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.controller.controlleraja;
import com.koneksi.koneksi;
import com.view.form_pemainbola;
import java.sql.Connection;
import java.sql.connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Administrator
 */
public class model_pemainbola implements controlleraja{
        String jk; 
    @Override
    public void Simpan(form_pemainbola mhs) throws SQLException {
        if(mhs.rblaki.isSelected()){
            jk = "Laki-laki";
        }
        else{
            jk = "Perempuan";
        }
        
        try {
           
            
            Connection con = koneksi.getKoneksi();
            String sql = "insert tblmahasiswa values(?,?,?,?)";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(1, mhs.tbl.getText());
            prepare.setString(2, mhs.txt2.getText());
            prepare.setString(3, jk);
            prepare.setString(4, (String) mhs.asb.getSelectedItem());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(mhs);
            mhs.setLebarKolom();
        }
    }

        public void Tampil(form_pemainbola mhs) {
            mhs.tblmodel.getDataVector().removeAllElements();
      mhs.tblmodel.fireTableDataChanged();
      try {
          Connection con = koneksi.getKoneksi();
          Statement stt = con.createStatement();
          String sql = "select * from nama_tabel_kamu order by NIM asc";
          ResultSet res = stt.executeQuery(sql);
          while(res.next())
          {
              Object[] ob= new Object[8];
              ob[0] = res.getString(1);
              ob[1] = res.getString(2);
              ob[2] = res.getString(3);
              ob[3] = res.getString(4);
               mhs.tblmodel.addRow(ob);
          } 
      } catch (Exception e) {
          System.out.println(e);
      }
    }

    @Override
    public void Ubah(form_pemainbola mhs) throws SQLException {
        if(mhs.rblaki.isSelected()){
            jk = "Laki-laki";
        }
        else{
            jk = "Perempuan";
        }
        
        try {
            Connection con = koneksi.getKoneksi();
            String sql = "update tblmahasiswa set Nama= ?, Jenis_Kelamin= ?, Jurusan= ? where NIM= ?";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(4, mhs.tbl.getText());
            prepare.setString(1, mhs.txt2.getText());
            prepare.setString(2, jk);
            prepare.setString(3, (String) mhs.asb.getSelectedItem());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(mhs);
            mhs.setLebarKolom();
            Baru(mhs);
        }
    }

    @Override
    public void Hapus(form_pemainbola mhs) throws SQLException {
         try {
            Connection con = koneksi.getKoneksi();
            String sql = "delete from tblmahasiswa where NIM= ?";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(1, mhs.tbl.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(mhs);
            mhs.setLebarKolom();
            Baru(mhs);
        }
    }
    


    @Override
    public void Baru(form_pemainbola mhs) {
        mhs.tbl.setText("");
        mhs.txt2.setText("");
        mhs.rblaki.setSelected(true);
        mhs.asb.setSelectedIndex(0);
    }
    

    @Override
    public void KlikTabel(form_pemainbola mhs) throws SQLException {
        try {
             int pilih = mhs.tabel.getSelectedRow();
             if (pilih == -1 ){    
                 return;
             }
             mhs.tbl.setText(mhs.tblmodel.getValueAt(pilih, 0).toString());
             mhs.txt2.setText(mhs.tblmodel.getValueAt(pilih, 1).toString());
             mhs.asb.setSelectedItem(mhs.tblmodel.getValueAt(pilih, 3).toString());
             jk = String.valueOf(mhs.tblmodel.getValueAt(pilih, 2));
             
                   
        } catch (Exception e) {
        }
        if(mhs.rblaki.getText().equals(jk)){
                  mhs.rblaki.setSelected(true);
             } 
        else{mhs.rbpr.setSelected(true);}
    }
    }

  