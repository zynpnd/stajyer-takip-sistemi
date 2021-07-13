/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje.staj.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import proje.staj.db.Staj;

/**
 *
 * @author Zeynepnida
 */
public class StajTableModel extends DefaultTableModel {

    private List<Staj> list = new ArrayList<>();
    private SimpleDateFormat dtFormat=new SimpleDateFormat("dd.MM.yyyy");

    public StajTableModel(ArrayList<Staj> list) {
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
        return 7;
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
                return "STAJ BAŞLAMA TARİHİ";
            case 4:
                return "STAJ BİTİŞ TARİHİ ";
            case 5:
                return "STAJ GÜNÜ";
            case 6:
                return "BİRİM ADI";
            default:
                return "";

        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        if (row < 0 || row >= this.list.size()) {
            return null;
        }
        Staj staj = this.list.get(row);

        switch (column) {
            case 0:
                return staj.getOgrenci().getTc();
            case 1:
                return staj.getOgrenci().getAd();
            case 2:
                return staj.getOgrenci().getSoyad();
            case 3:
                return dtFormat.format(staj.getBaslama_tarihi());
            case 4:
                return dtFormat.format(staj.getBitis_tarihi());
            case 5:
                return staj.getStaj_gun();
            case 6:
                return staj.getBirim().getAdi();
            default:
                return "";

        }

    }

    public Staj getStaj(int selectedRow) {
        return this.list.get(selectedRow);
    }

}
