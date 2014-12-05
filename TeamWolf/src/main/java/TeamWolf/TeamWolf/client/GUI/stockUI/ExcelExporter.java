package TeamWolf.TeamWolf.client.GUI.stockUI;

import java.awt.event.*;  
import java.io.*;  
import javax.swing.*;  
import javax.swing.table.*;  
import jxl.*;  
import jxl.write.*;  
import jxl.write.biff.RowsExceededException;  
/** 
 * 
 * @author Administrator 
 */  
public class ExcelExporter {  
    public ExcelExporter() {  
    }  
    public void exportTable(JTable table, File file) throws IOException {  
        try {  
            OutputStream out = new FileOutputStream(file);  
            TableModel model = table.getModel();  
            WritableWorkbook wwb = Workbook.createWorkbook(out);  
            // 创建字表，并写入数据  
            WritableSheet ws = wwb.createSheet("库存表单", 0);  
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
                    jxl.write.Label labelN = new jxl.write.Label(i, j, model.getValueAt(j - 1, i).toString());  
                    try {  
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
            } catch (WriteException e) {  
                e.printStackTrace();  
            }  
        } catch (FileNotFoundException e) {  
            JOptionPane.showMessageDialog(null, "导入数据前关闭工作表");  
        }  
    }  
    public static void main(String[] args) {  
        String[][] data = {  
            {"中文", "$1275.00"},  
            {"Pets", "$125.00"},  
            {"Electronics", "$2533.00"},  
            {"Mensware", "$497.00"}  
        };  
        String[] headers = {"Department", "Daily Revenue"};  
        JFrame frame = new JFrame("JTable to Excel Hack");  
        DefaultTableModel model = new DefaultTableModel(data, headers);  
        final JTable table = new JTable(model);  
        JScrollPane scroll = new JScrollPane(table);  
        JButton export = new JButton("Export");  
        export.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent evt) {  
                try {  
                    ExcelExporter exp = new ExcelExporter();  
                    exp.exportTable(table, new File("results.xls"));  
                } catch (IOException ex) {  
                    System.out.println(ex.getMessage());  
                    ex.printStackTrace();  
                }  
            }  
        });  
        frame.getContentPane().add("Center", scroll);  
        frame.getContentPane().add("South", export);  
        frame.pack();  
        frame.setVisible(true);  
    }  
}  
