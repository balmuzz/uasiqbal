/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;
import com.view.form_pemainbola;
import java.sql.SQLException;
/**
 *
 * @author Administrator
 */
public interface controlleraja {
    public void Simpan(form_pemainbola mhs) throws SQLException;         
    public void Ubah(form_pemainbola mhs) throws SQLException;
    public void Hapus(form_pemainbola mhs) throws SQLException;
    public void Tampil(form_pemainbola mhs) throws SQLException;
    public void Baru(form_pemainbola mhs);                               
    public void KlikTabel(form_pemainbola mhs) throws SQLException;
}

