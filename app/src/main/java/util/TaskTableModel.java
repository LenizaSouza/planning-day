/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import model.Task;

/**
 *
 * @author bouso
 */
public class TaskTableModel extends AbstractTableModel {

    String[] columns = {"Prioridade(S/N)", "Nome", "Descrição", "Prazo", "Tarefa Concluida", "Editar", "Ecluir"};
    List<Task> tasks = new ArrayList();

    @Override
    public int getRowCount() {
        return tasks.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }
    
    public boolean isCellEditable(int rowIndex, int columnIndex){       
        return columnIndex == 4;
    }
    
     @Override
     public Class<?> getColumnClass (int columnIndex){
        if(tasks.isEmpty()){
             return Object.class;
        }
        return this.getValueAt(0, columnIndex).getClass();
    }

   @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
         
            case 0:
                try {
                    System.out.println("Colum: " + columnIndex);
                    System.out.println("tasks: "+tasks.size());
                    System.out.println(tasks.get(rowIndex).getPriority());
                    if (tasks.get(rowIndex).getPriority() == null) {
                        return "";
                    }
                    return tasks.get(rowIndex).getPriority(); 
                } catch(Exception e) {
                    System.out.println("");
                }
                               
            case 1:
                if(tasks.get(rowIndex).getName() == null){
                    return "";
                }
                return tasks.get(rowIndex).getName();
            case 2:
                if(tasks.get(rowIndex).getDescription() == null) {
                    return "";   
                }
                return tasks.get(rowIndex).getDescription();
            case 3:
                if(tasks.get(rowIndex).getDeadline() == null){
                    return "";
                }
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                return dateFormat.format (tasks.get(rowIndex).getDeadline());
            case 4:
                return tasks.get(rowIndex).isCompleted();
            case 5:
                return "";
            case 6:
                return "";
            default:
                return "Dados não encontrados";
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
        tasks.get(rowIndex). setIsCompleted((boolean) aValue);
    }   
    
    public String[] getColumns() {
        return columns;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }     
}
