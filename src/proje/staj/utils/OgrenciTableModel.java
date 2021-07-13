/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje.staj.utils;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import proje.staj.db.Ogrenci;

/**
 *
 * @author Zeynepnida
 */
public class OgrenciTableModel extends DefaultTableModel {

    private List<Ogrenci> list = new ArrayList<>();
    public OgrenciTableModel(ArrayList<Ogrenci> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        if (this.list == null) {
            return 0;
        }
        return this.list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "TC";
            case 1:
                return "ADI";
            case 2:
                return "SOYİSİM";
            case 3:
                return "OKUL";
            case 4:
                return "BÖLÜM";
            default:
                return "";
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        if (row < 0 || row >= this.list.size()) {
            return null;
        }
        Ogrenci ogrenci = this.list.get(row);

        switch (column) {
            case 0:
                return ogrenci.getTc();
            case 1:
                return ogrenci.getAd();
            case 2:
                return ogrenci.getSoyad();
            case 3:
                return ogrenci.getOkul().getAdi();
            case 4:
                return ogrenci.getBolum().getAdi();
            default:
                return "";

        }
    }

    public Ogrenci getOgrenci(int selectedRow) {
        return this.list.get(selectedRow);
    }
}
