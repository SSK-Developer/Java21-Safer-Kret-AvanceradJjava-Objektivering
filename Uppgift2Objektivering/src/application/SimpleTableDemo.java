package application;

import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SimpleTableDemo extends JFrame {

	public static ParserHelper p = new ParserHelper();
	public static ArrayList<RowReaderBean> newCsvList = p.CSVrows;
	public static ArrayList<RowReaderBean> newJSONList = p.JSONrows;

	public SimpleTableDemo()
    {
        //headers for the table
        String[] columns = new String[] {
            "OrderDate", "Rep1", "Rep2", "Item", "Units", "UnitCost", "Total"
        };
         
        //actual data for the table in a 2d array
        Object[][] data = {
        		{"aaa", "Rep1", "Rep2", "Item", "Units", "UnitCost", "Total"}
        		};
        
        for(var item:newCsvList) {
        	System.out.println(newCsvList.size());
        }
        //create table with data
        JTable table = new JTable(data, columns);
         
        //add the table to the frame
        this.add(new JScrollPane(table));
         
        this.setTitle("File reader");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        this.pack();
        this.setVisible(true);
    }
     
    public static void main(String[] args) throws FileNotFoundException
    {
    	
   	 p.CSVmode();
   	 p.JSONmode();
    	for(var item: newJSONList) {
    		System.out.println(item);
    	}
    	/*
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SimpleTableDemo();
            }
        });
        */
    }   
}
