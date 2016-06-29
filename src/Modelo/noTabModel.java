/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author andre
 */
public class noTabModel extends AbstractTableModel {

    private  List<List<String>> rows;
    private String headers[];

    public noTabModel(String cab[], List<List<String>> ll) {
    	headers = cab;
        rows = new ArrayList<List<String>>();
        for(int i = 0; i < ll.size(); i++){
        	rows.add(ll.get(i));
        }
    }
    
    public noTabModel(String cab[]) {
    	headers = cab;
        rows = new ArrayList<List<String>>();
    }
    
    public List<String> getRow(int row){
        return rows.get(row);
    }
    
    

    public void addItem(int idx, List<String> item) {
        rows.add(idx, item);
        fireTableRowsInserted(idx, idx);
    }

    public void removeItem(int idx) {
        rows.remove(idx);
        fireTableRowsDeleted(idx, idx);
    }
    
    public void updateItem(int idx){
        fireTableRowsUpdated(idx, idx);
    }
    
    public void addItens(int idx, List<List<String>> itens){
        for(int i = 0; i < idx; i++){
           addItem(i, itens.get(i));
        }
    }
    
    public void deleteAllRows(final noTabModel model) {
    for( int i = model.getRowCount() - 1; i >= 0; i-- ) {
        model.removeItem(i);
    }
    
   
}

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public String getColumnName(int column) {
        return headers[column];
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public Object getValueAt(int row, int column) {    	
        return rows.get(row).get(column);  
    }
    
    
}
