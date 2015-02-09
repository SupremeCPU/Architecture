package edu.gwu.frame;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import edu.gwu.common.Util;
import edu.gwu.core.MainMemory;
import edu.gwu.core.Setting;
import edu.gwu.exception.IllegalMemoryAddressException;

public class MemoryPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1819976278005742885L;

	
	private JScrollPane js;
	private JTable table;
	
	private MainMemory memory = MainMemory.getInstance();
	
	public MemoryPanel(){
		TitledBorder nameTitle =new TitledBorder("Memory"); 	
		this.setBorder(nameTitle);
		
		this.setLayout(new BorderLayout());
		
		
		table = new JTable(Setting.MEM_WORD_LENGTH,2);
		String[] tableHeads = new String[] { "Address", "Binary Value"};
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setColumnIdentifiers(tableHeads);

		DefaultTableCellRenderer d = new DefaultTableCellRenderer();
		d.setHorizontalAlignment(JLabel.RIGHT);
		TableColumn col = table.getColumnModel().getColumn(0);
		table.getTableHeader().setResizingColumn(col);
		
		col.setWidth(60);
		col.setCellRenderer(d);
		//col = table.getColumnModel().getColumn(1);
		//table.getTableHeader().setResizingColumn(col);
		//col.setWidth(160);

		table.setEnabled(false);
		
		
		update();
		js = new JScrollPane(table);
				
		this.add(js,BorderLayout.CENTER);
	}
	
	public void update(){
		for(int i=0;i<Setting.MEM_WORD_LENGTH;i++){
			table.setValueAt(i, i, 0);
			try {
				table.setValueAt(Util.getBinaryStringFromBits(memory.read(i).getData()), i, 1);
			} catch (IllegalMemoryAddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
