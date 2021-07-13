/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje.staj.utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import proje.staj.db.Proje;
import proje.staj.forms.ProjeAra;

/**
 *
 * @author Zeynepnida
 */
public class ProjeTableModel extends DefaultTableModel {

    private List<Proje> list = new ArrayList<>();

    public ProjeTableModel(ArrayList<Proje> list) {
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
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "PROJE ADI";
            case 2:
                return "AÇIKLAMA";

            default:
                return "";

        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        if (row < 0 || row >= this.list.size()) {
            return null;
        }
        Proje proje = this.list.get(row);

        switch (column) {
            case 0:
                return proje.getId();
            case 1:
                return proje.getAdi();
            case 2:
                return proje.getAciklama();

            default:
                return "";

        }

    }

    public void addNewProje(Proje proje) {
        this.list.add(proje);
        this.fireTableDataChanged();
    }

    
    
    public Proje getProje(int selectedRow){
           return this.list.get(selectedRow);
        }

    public void removeProje(Proje proje) {
        this.list.remove(proje);
        this.fireTableDataChanged();
    }

    public void setList(ArrayList<Proje> projeList) {
       this.list=projeList;
       this.fireTableDataChanged();
    }
}
