package TeamWolf.TeamWolf.client.GUI.tableInquireUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import TeamWolf.TeamWolf.client.GUI.messageUI.MessageFrame;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExpertListener implements ActionListener{
	
	Date date;
	Calendar c;
	JTable table;
	String type;
	final static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd hh-mm-ss");
	
	public ExpertListener(JTable table, String type){
		date = new Date();
		this.table = table;
		this.type = type;
	}
	
	public void actionPerformed(ActionEvent e1) {
		c = Calendar.getInstance();
		date = c.getTime();
		String file = sdf.format(date) + ".xls";
		try {  
            OutputStream out = new FileOutputStream(file);  
            TableModel model = table.getModel();  
            WritableWorkbook wwb = Workbook.createWorkbook(out);  
            // 创建字表，并写入数据  
            WritableSheet ws = wwb.createSheet(type, 0);  
            // 添加标题  
            for (int i = 0; i < model.getColumnCount(); i++) {  
                jxl.write.Label labelN = new jxl.write.Label(i, 0, model.getColumnName(i));  
                try {  
                    ws.addCell(labelN);  
                } catch (RowsExceededException e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                } catch (WriteException e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                }
            }
            // 添加列  
            for (int i = 0; i < model.getColumnCount(); i++) {
                for (int j = 1; j <= model.getRowCount(); j++) {
                	jxl.write.Label labelN = null;
                	if(model.getValueAt(j - 1, i) != null)
                		labelN = new jxl.write.Label(i, j, model.getValueAt(j - 1, i).toString());  
                    try {
                    	if(labelN != null)
                    		ws.addCell(labelN);
                    } catch (RowsExceededException e) {  
                        e.printStackTrace();  
                    } catch (WriteException e) {  
                        e.printStackTrace();  
                    }
                }
            }
            wwb.write();  
            try {  
                wwb.close();
                out.close();
                new MessageFrame(0);
            } catch (WriteException e) {  
                e.printStackTrace();  
            }  
        } catch (FileNotFoundException e) {  
            JOptionPane.showMessageDialog(null, "导入数据前请关闭工作表");  
        } catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
    } 
}
