package TeamWolf.TeamWolf.client.GUI.stockUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class StockManagePane extends JPanel implements TreeModelListener {

    static String CurrentTypeNum;
	
	JTree stockStruct;
    DefaultTreeModel treeModel;
	JScrollPane SSContainer;
	JPanel oprArea;
	JTabbedPane opArea;
	JTabbedPane typeOpr;
	JTabbedPane goodsOpr;
	JPanel addTypeP;
    JPanel delTypeP;
    JPanel updTypeP;
    JPanel addGoodsP;
    JPanel delGoodsP;
    JPanel updGoodsP;
    JPanel shoGoodsP;
    JLabel addTPL;
    JLabel addTNL;
    JTextField addTParent;
    JTextField addTName;
    JLabel delTIL;
    JTextField delTInfo;
    JLabel updTIL;
    JLabel updNNL;
    JTextField updTInfo;
    JTextField updTNewName;
	JButton addType;
	JButton delType;
	JButton updType;
	JLabel addGP;
	JLabel addGN;
	JLabel addGM;
	JLabel addGIP;
	JLabel addGEP;
	JTextField addGPTF;
	JTextField addGNTF;
	JTextField addGMTF;
	JTextField addGIPTF;
	JTextField addGEPTF;
	JButton addGoods;
	JButton delGoods;
	JButton updGoods;
	JButton finGoods;
	JButton refreshGoods;
	
	
	public StockManagePane(){
		
		initialTree();
		initialButton();
		initialTextField();
		initialOprArea();		
		this.setLayout(null);
		this.setVisible(true);
		this.add(SSContainer);
		this.add(oprArea);
	}
	
    public void initialTree(){
		
		DefaultMutableTreeNode root=new DefaultMutableTreeNode("商品");
		DefaultMutableTreeNode leave=new DefaultMutableTreeNode("分类1");
		root.add(leave);
		leave=new DefaultMutableTreeNode("分类2");
		leave.setAllowsChildren(true);
		root.add(leave);
		leave=new DefaultMutableTreeNode("分类3");
		leave.setAllowsChildren(true);
		root.add(leave);
		leave=new DefaultMutableTreeNode("分类4");
		leave.setAllowsChildren(true);
		root.add(leave);
		leave=new DefaultMutableTreeNode("分类5");
		leave.setAllowsChildren(true);
		root.add(leave);
		stockStruct=new JTree(root);
		treeModel=(DefaultTreeModel) stockStruct.getModel();
		stockStruct.setEditable(false);
		stockStruct.addMouseListener(new MouseHandle());
		SSContainer=new JScrollPane(stockStruct);
		SSContainer.setVisible(true);
		SSContainer.setBounds(25, 25, 300, 445);
	}
    
    public void initialButton(){
    	
    	addType=new JButton("增加分类");
    	addType.setVisible(true);
    	addType.setBounds(260, 300, 100, 28);
    	addType.addActionListener(new ActionListener(){
    		
    		public void actionPerformed(ActionEvent Event){
    			DefaultMutableTreeNode parentNode=null;
    			DefaultMutableTreeNode newNode=new DefaultMutableTreeNode(addTName.getText());
    			newNode.setAllowsChildren(true);
    			TreePath parentPath=stockStruct.getSelectionPath();
    			if(parentPath!=null){
    			parentNode=(DefaultMutableTreeNode)(parentPath.getLastPathComponent());
    			treeModel.insertNodeInto(newNode, parentNode, parentNode.getChildCount());
    			stockStruct.scrollPathToVisible(new TreePath(newNode.getPath()));
    			}
    		}
    	});
    	
    	delType=new JButton("删除分类");
    	delType.setVisible(true);
    	delType.setBounds(260, 300, 100, 28);
    	delType.addActionListener(new ActionListener(){
    		
    		public void actionPerformed(ActionEvent Event){
    			
    			TreePath treePath=stockStruct.getSelectionPath();
    			if(treePath!=null){
    				DefaultMutableTreeNode selectionNode=(DefaultMutableTreeNode)treePath.getLastPathComponent();
    				
    				TreeNode parent=(TreeNode)selectionNode.getParent();
    				if(parent!=null){
    					
    				     if(selectionNode.isLeaf()){    					    
    						treeModel.removeNodeFromParent(selectionNode);
    				     }
    				}
    			}
    		}
    	});
    	
    	updType=new JButton("更新分类");
    	updType.setVisible(true);
    	updType.setBounds(260, 340, 100, 28);
    	updType.addActionListener(new ActionListener(){
    		
    		public void actionPerformed(ActionEvent Event){
    			
    			TreePath treePath=stockStruct.getSelectionPath();
    			if(treePath!=null){
    				DefaultMutableTreeNode selectionNode=(DefaultMutableTreeNode)treePath.getLastPathComponent();
    				int l=0;
    				DefaultMutableTreeNode parent=(DefaultMutableTreeNode)selectionNode.getParent();
    				if(parent!=null){
    				        
    					    for(;l<parent.getChildCount();l++){
    					    	if(parent.getChildAt(l).equals(selectionNode))
    					    		break;
    					    }
    						treeModel.removeNodeFromParent(selectionNode);
                               				     
    				}
    				
    				selectionNode=new DefaultMutableTreeNode("更新");
                    treeModel.insertNodeInto(selectionNode, parent, l);
    			}
    		}
    	});
    	
    	addGoods=new JButton("更新分类");
    	addGoods.setVisible(true);
    	addGoods.setBounds(260, 340, 100, 28);
    	
    }
    
    public void initialTextField(){
    	
    	addTNL=new JLabel("分类名称");
    	addTNL.setVisible(true);
    	addTNL.setFont(new Font("黑体", Font.BOLD, 14));
    	addTNL.setBounds(120, 150, 80, 30);
    	addTPL=new JLabel("父类信息");
    	addTPL.setFont(new Font("黑体", Font.BOLD, 14));
    	addTPL.setVisible(true);
    	addTPL.setBounds(120, 80, 80, 30);
    	addTParent=new JTextField();
    	addTParent.setVisible(true);
    	addTParent.setBounds(210, 80, 250, 30);
    	addTParent.setEditable(false);
    	addTName=new JTextField();
    	addTName.setVisible(true);
    	addTName.setBounds(210, 150, 250, 30);
    	
    	delTIL=new JLabel("分类信息");
    	delTIL.setVisible(true);
    	delTIL.setFont(new Font("黑体", Font.BOLD, 14));
    	delTIL.setBounds(120, 130, 80, 30);
    	delTInfo=new JTextField();
    	delTInfo.setVisible(true);
    	delTInfo.setBounds(210, 130, 250, 30);
    	delTInfo.setEditable(false);
    	
    	updNNL=new JLabel("新分类名");
    	updNNL.setVisible(true);
    	updNNL.setFont(new Font("黑体", Font.BOLD, 14));
    	updNNL.setBounds(120, 150, 80, 30);
    	updTIL=new JLabel("分类信息");
    	updTIL.setFont(new Font("黑体", Font.BOLD, 14));
    	updTIL.setVisible(true);
    	updTIL.setBounds(120, 80, 80, 30);
        updTInfo=new JTextField();
        updTInfo.setVisible(true);
        updTInfo.setBounds(210, 80, 250, 30);
        updTInfo.setEditable(false);
    	updTNewName=new JTextField();
    	updTNewName.setVisible(true);
    	updTNewName.setBounds(210, 150, 250, 30);
    	
    }
    
    public void initialOprArea(){
    	
    	oprArea=new JPanel();
    	//oprArea.setBackground(Color.GREEN);
    	oprArea.setLayout(new BorderLayout());
    	oprArea.setVisible(true);
    	oprArea.setBounds(350, 0, 600, 470);
    	opArea=new JTabbedPane(JTabbedPane.TOP , JTabbedPane.SCROLL_TAB_LAYOUT);
        typeOpr=new JTabbedPane();
        addTypeP=new JPanel();
        addTypeP.setLayout(null);
        addTypeP.add(addTPL);
        addTypeP.add(addTParent);
        addTypeP.add(addTName);
        addTypeP.add(addTNL);
        addTypeP.add(addType);
        delTypeP=new JPanel();
        delTypeP.setLayout(null);
        delTypeP.add(delType);
        delTypeP.add(delTIL);
        delTypeP.add(delTInfo);
        updTypeP=new JPanel();
        updTypeP.setLayout(null);
        updTypeP.add(updType); 
        updTypeP.add(updNNL);
        updTypeP.add(updTIL);
        updTypeP.add(updTInfo);
        updTypeP.add(updTNewName);
        typeOpr.addTab("增加分类", addTypeP);
        typeOpr.addTab("删除分类", delTypeP);
        typeOpr.addTab("修改分类", updTypeP);
        typeOpr.setEnabledAt(0, true);
        typeOpr.setEnabledAt(1, true);
        typeOpr.setEnabledAt(2, true);
        goodsOpr=new JTabbedPane();   
        addGoodsP=new JPanel();
        addGoodsP.setLayout(null);
        addGoodsP.add(addGoods);
        delGoodsP=new JPanel();
        delGoodsP.setLayout(null);
        updGoodsP=new JPanel();
        updGoodsP.setLayout(null);
        shoGoodsP=new JPanel();
        shoGoodsP.setLayout(null);
        goodsOpr.addTab("增加商品", addGoodsP);
        goodsOpr.addTab("删除商品", delGoodsP);
        goodsOpr.addTab("修改商品", updGoodsP);
        goodsOpr.addTab("显示商品", shoGoodsP);
        goodsOpr.setEnabledAt(0, true);
        goodsOpr.setEnabledAt(1, true);
        goodsOpr.setEnabledAt(2, true);
        goodsOpr.setEnabledAt(3, true);
    	opArea.addTab("商品分类管理", typeOpr);
    	opArea.addTab("商品管理", goodsOpr);
    	opArea.setEnabledAt(0, true);
    	opArea.setEnabledAt(1, true);
    	oprArea.add(opArea, BorderLayout.CENTER);
    }

	public void treeNodesChanged(TreeModelEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void treeNodesInserted(TreeModelEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void treeNodesRemoved(TreeModelEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void treeStructureChanged(TreeModelEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	class MouseHandle extends MouseAdapter{
		
		public void mousePressed(MouseEvent e){
			
			try{
				 JTree tree=(JTree)e.getSource();
				 int rowLocation=tree.getRowForLocation(e.getX(), e.getY());
				 TreePath treepath=tree.getPathForRow(rowLocation);
				 TreeNode treenode=(TreeNode)treepath.getLastPathComponent();
				 String nodeName=treenode.toString();
				 
				 if(nodeName.substring(0, 2).equals("分类")){
					 
					 addTParent.setText(treenode.getParent().toString());
					 delTInfo.setText(nodeName);
					 updTInfo.setText(nodeName);
				 }
				 else if(nodeName.substring(0, 2).equals("商品")){
					 
				 }
			}catch(NullPointerException ne){
				
			}
		}
	}
}
