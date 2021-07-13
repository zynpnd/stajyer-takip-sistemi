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
import proje.staj.db.Devam;
import proje.staj.db.Staj;
import proje.staj.managers.DevamManager;

/**
 *
 * @author Zeynepnida
 */
public class DevamTableModel  extends DefaultTableModel{
     private List<Devam> list=new ArrayList<>();
    private Devam Staj;
    
   public DevamTableModel(ArrayList<Devam> list){
        this.list=list;
       
   } 

    public DevamTableModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     @Override
    public int getRowCount() {
        if(this.list==null)
            return 0;
        return this.list.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "STAJ ID";
            case 1: return "TARİH";
            case 2: return "DEVAM";
         
              default : return "";
         
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        if(row<0 || row>=this.list.size()){
            return null;
        }
        Devam devam=this.list.get(row);
        
        switch(column){
            
            case 0: return devam.getStaj().getId();
            case 1: return devam.getTarih();
            case 2: return devam.getDurum();
           
            default : return "";
         
        }
        
    }

    public Devam getOgrenci(int selectedRow) {
      return this.list.get(selectedRow);
    }
    
    
    public void setStaj(Staj selectedStaj) throws SQLException{
     //selectedStaj.setOgrenci(ogrenci);
     
        this.list=new DevamManager().getAllOgrenci(selectedStaj);
        this.fireTableDataChanged();
    }
}
