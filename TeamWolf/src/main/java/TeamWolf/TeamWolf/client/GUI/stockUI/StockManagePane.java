package TeamWolf.TeamWolf.client.GUI.stockUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import TeamWolf.TeamWolf.client.BL.applicationBL.forStock.StockApplicationController;
import TeamWolf.TeamWolf.client.BL.goodsBL.GoodsBLController;
import TeamWolf.TeamWolf.client.BL.stockBL.StockBLController;
import TeamWolf.TeamWolf.client.vo.GoodsListVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.TypeListVO;
import TeamWolf.TeamWolf.client.vo.TypeVO;
import TeamWolf.TeamWolf.client.vo.UserVO;

public class StockManagePane extends JPanel implements TreeModelListener {

    static int CurrentTypeNum;
    String IP;
    String operator;
    StockBLController sbcontroller;
	GoodsBLController gbcontroller;
   
	DefaultMutableTreeNode root=new DefaultMutableTreeNode("商品");
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
    JPanel ITMP;
    JPanel DTMP;
    JPanel setWLP;
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
	JLabel delGN;
	JTextField delGNTF;
	JButton delGoods;
	JLabel updGN;
	JLabel updGIP;
	JLabel updGEP;
	JTextField updGNTF;
	JTextField updGIPTF;
	JTextField updGEPTF;
	JButton updGoods;
	JLabel ITMGIL;
	JLabel ITMAmount;
	JTextField ITMGITF;
	JTextField ITMAmountTF;
	JButton toITM;
	JLabel DTMGIL;
	JLabel DTMAmount;
	JTextField DTMGITF;
	JTextField DTMGAmountTF;
	JButton toDTM;
	JLabel setWLGI;
	JLabel setWLGWL;
	JTextField setWLGITF;
	JTextField setWLGWLTF;
	JButton toSetWL;
	
	JScrollPane SGContainer;
	JPanel SOP;
	JTextArea shoPane;
	JTextField numberTF;
	JTextField nameTF;
	JTextField modelTF;
	JButton finGoods;
	JButton refreshGoods;
		
	
    public StockManagePane(String iP, UserVO user) {
		// TODO Auto-generated constructor stub
    	this.IP=iP;
    	sbcontroller=new StockBLController(iP);
    	gbcontroller=new GoodsBLController(iP);
    	operator=user.workID;
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
		
		
		initialRoot();
		stockStruct=new JTree(root);
		treeModel=(DefaultTreeModel) stockStruct.getModel();
		stockStruct.setEditable(false);
		stockStruct.addMouseListener(new MouseHandle());
		SSContainer=new JScrollPane(stockStruct);
		SSContainer.setVisible(true);
		SSContainer.setBounds(25, 25, 300, 445);
	}
    
    private void initialRoot() {
		// TODO Auto-generated method stub
    	TypeListVO typelist=sbcontroller.shoAllType();
    	ArrayList<TypeVO> tl=typelist.typeL;
    	GoodsListVO goodsList=gbcontroller.shoGoods();
    	ArrayList<GoodsVO> gl=goodsList.gList;
    	ArrayList<DefaultMutableTreeNode> tnl=new ArrayList<DefaultMutableTreeNode>();
    	for(TypeVO t:tl){
    		int tNum=Integer.parseInt(t.getNumber());
    		if(tNum>CurrentTypeNum)
    			CurrentTypeNum=tNum;
    		
    		if(t.getParentNum()==null){
    			DefaultMutableTreeNode tn=new DefaultMutableTreeNode("T "+t.getNumber()+" "+t.getName());
    			root.add(tn);
    			tnl.add(tn);
    		}
    		else{
    			DefaultMutableTreeNode tn=new DefaultMutableTreeNode("T "+t.getNumber()+" "+t.getName());
    			for(DefaultMutableTreeNode ptn:tnl){
    				if(ptn.toString().equals("T "+t.getParentNum()+" "+t.getParent())){
    					ptn.add(tn);
    				}
    			}
    			tnl.add(tn);
    		}
    	}
    	
    	for(GoodsVO g:gl){
    		
    		DefaultMutableTreeNode tn=new DefaultMutableTreeNode("G "+g.getNumber()+" "+g.getName()+" "+g.getModel());
    		for(DefaultMutableTreeNode ptn:tnl){
				if(ptn.toString().equals("T "+g.getParentNum()+" "+g.getParent())){
					ptn.add(tn);
				}
			}
			tnl.add(tn);
    	}
    	
    	//System.out.println(CurrentTypeNum);
		
	}

	public void initialButton(){
    	
    	addType=new JButton("增加分类");
    	addType.setVisible(true);
    	addType.setBounds(260, 340, 100, 28);
    	addType.addActionListener(new ActionListener(){
    		
    		public void actionPerformed(ActionEvent Event){
    			
    			int newTN=CurrentTypeNum+1;
    			String addTypeNum=""+newTN;
    			while(addTypeNum.length()<4){
    				addTypeNum="0"+addTypeNum;
    			}
    			String addTypeName=addTName.getText();
    			String pI=addTParent.getText();
    			DefaultMutableTreeNode parentNode=null;
    			DefaultMutableTreeNode newNode=new DefaultMutableTreeNode("T "+addTypeNum+" "+addTypeName);
    			newNode.setAllowsChildren(true);
    			TreePath parentPath=stockStruct.getSelectionPath();
    			if(parentPath!=null){		
    			    
    				parentNode=(DefaultMutableTreeNode)(parentPath.getLastPathComponent());
    				int result=0;
    				if(parentNode.toString().equals("商品")){
    				    result=sbcontroller.addType(new TypeVO(null, null, addTypeNum, addTypeName));	
    				}
    				else{
    				    String[] pInfo=pI.split(" ");
    				    if(pInfo[1].equals("0000")){
    				    	result=1000;  //错误类型:特价包不能由库存管理人员由编辑
    				    }
    				    else
    				        result=sbcontroller.addType(new TypeVO(pInfo[1], pInfo[2], addTypeNum, addTypeName));
    				}
    				if(result==0){
    			      treeModel.insertNodeInto(newNode, parentNode, parentNode.getChildCount());
    			      stockStruct.scrollPathToVisible(new TreePath(newNode.getPath()));
    			      addTName.setText("");
    			      CurrentTypeNum++;
    			      MainPane.Infomation=MainPane.Infomation+MainPane.getPresentTime()+" 添加了分类  "+newNode.toString()+"\n";
    				}
    				else{
    					System.out.println(result); //弹窗报错:根据result数值
    				}
    			}
    		}
			
    	});
    	
    	delType=new JButton("删除分类");
    	delType.setVisible(true);
    	delType.setBounds(260, 340, 100, 28);
    	delType.addActionListener(new ActionListener(){
    		
    		public void actionPerformed(ActionEvent Event){
    			
    			TreePath treePath=stockStruct.getSelectionPath();
    			if(treePath!=null){
    			  DefaultMutableTreeNode selectionNode=(DefaultMutableTreeNode)treePath.getLastPathComponent();   				
    			  if(selectionNode.toString().substring(0, 1).equals("T")){
    				TreeNode parent=(TreeNode)selectionNode.getParent();
    				if(parent!=null){
    				    int result=0;
    					TypeVO todel=null;
    				    String[] typeInfo=selectionNode.toString().split(" ");
    					if(parent.toString().equals("商品")){
    				        todel=new TypeVO(null, null, typeInfo[1], typeInfo[2]);
    				    }
    					else{
    						String[] parentInfo=parent.toString().split(" ");
    						todel=new TypeVO(parentInfo[1], parentInfo[2], typeInfo[1], typeInfo[2]);
    					}
    					
    					if(todel.getParentNum()!=null&&todel.getParentNum().equals("0000")){
    						result=1000;   ///错误类型:特价包不能由库存管理人员由编辑
    					}
    					else{
    						result=sbcontroller.delType(todel);
    					}
    					if(result==0){
    				     if(selectionNode.isLeaf()){    					    
    						treeModel.removeNodeFromParent(selectionNode);
    						delTInfo.setText("");
    						MainPane.Infomation=MainPane.Infomation+MainPane.getPresentTime()+" 删除了分类  "+selectionNode.toString()+"\n";
    				     }
    					}
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
    				DefaultMutableTreeNode parent=(DefaultMutableTreeNode)selectionNode.getParent();
    				String[] typeInfo=selectionNode.toString().split(" ");
    				if(parent!=null){
    				    int result=0;
    					TypeVO toUpd=null;
    					if(parent.toString().equals("商品")){
    				    	toUpd=new TypeVO(null, null, typeInfo[1], updTNewName.getText());
    				    }
    					else{
    						String[] parentInfo=parent.toString().split(" ");
    						toUpd=new TypeVO(parentInfo[1], parentInfo[2], typeInfo[1], updTNewName.getText());
    						if(parentInfo[1].equals("0000")){
        						result=1000;
        					}
    					}
    					if(result==0){
    						result=sbcontroller.updType(toUpd);
    					}
    					if(result==0){
    					    selectionNode.setUserObject("T "+typeInfo[1]+" "+updTNewName.getText());
    				        treeModel.reload();
    				        stockStruct.scrollPathToVisible(new TreePath(selectionNode.getPath()));
    				        updTInfo.setText("");
        			        updTNewName.setText("");
        			        MainPane.Infomation=MainPane.Infomation+MainPane.getPresentTime()+" 更新了分类  "+selectionNode.toString()+"\n";
    					}
    				}
    			}
    			
    		}
    	});
    	
    	addGoods=new JButton("增加商品");
    	addGoods.setVisible(true);
    	addGoods.setBounds(260, 340, 100, 28);
    	addGoods.addActionListener(new ActionListener(){
    		
    		public void actionPerformed(ActionEvent Event){
    			
    			String addGoodsName=addGNTF.getText();
    			String addGoodsModel=addGMTF.getText();
    			String addGoodsIP=addGIPTF.getText();
    			String addGoodsEP=addGEPTF.getText();
    			
    			DefaultMutableTreeNode parentNode=null;
    			
    			TreePath parentPath=stockStruct.getSelectionPath();
    			if(parentPath!=null){		
    			    
    				parentNode=(DefaultMutableTreeNode)(parentPath.getLastPathComponent());
    				if(!parentNode.toString().equals("商品")){
    				int GoodsNum=0;
    				int NOC=parentNode.getChildCount();
    				for(int i=0;i<NOC;i++){
    					String[] cInfo=((TreeNode)parentNode.getChildAt(i)).toString().split(" ");
    					int num=Integer.parseInt(cInfo[1].substring(4));
    			        //System.out.println(cInfo[1].substring(4));
    					if(num>GoodsNum)
    						GoodsNum=num;
    				}
    				String GNum=""+(GoodsNum+1);
    				while(GNum.length()<4){
    					GNum="0"+GNum;
    				}
    				int result=0;
    				String[] parentInfo=addGPTF.getText().split(" ");
    				if(parentInfo[1].equals("0000")){
    					result=1000;
    				}
    				else{
    					GoodsVO toadd=new GoodsVO(parentInfo[1], parentInfo[2], parentInfo[1]+GNum, addGoodsName, addGoodsModel, "0", addGoodsIP, addGoodsEP, "0", "0", "0");
    					if(toadd.isPackSuccess()==0){
    					      result=gbcontroller.addGoods(toadd);
    					}
    					else
    						  result=10001;
    				}
    				if(result==0){
    					DefaultMutableTreeNode newNode=new DefaultMutableTreeNode("G "+parentInfo[1]+GNum+" "+addGoodsName+" "+addGoodsModel);
    	    			newNode.setAllowsChildren(false);
    	    			treeModel.insertNodeInto(newNode, parentNode, parentNode.getChildCount());
      			        stockStruct.scrollPathToVisible(new TreePath(newNode.getPath()));
      			        addGNTF.setText("");
      			        addGMTF.setText("");
      			        addGIPTF.setText("");
      			        addGEPTF.setText("");
      			      MainPane.Infomation=MainPane.Infomation+MainPane.getPresentTime()+" 添加了商品  "+newNode.toString()+"\n";
    				}
    				else{
    					//弹窗
    				}
    				}
    			}
    		}
    	});
    	
    	delGoods=new JButton("删除商品");
    	delGoods.setVisible(true);
    	delGoods.setBounds(260, 340, 100, 28);
    	delGoods.addActionListener(new ActionListener(){
    		
    		public void actionPerformed(ActionEvent Event){
    			
    			TreePath treePath=stockStruct.getSelectionPath();
    			if(treePath!=null){
    			  DefaultMutableTreeNode selectionNode=(DefaultMutableTreeNode)treePath.getLastPathComponent();
    			  if(selectionNode.toString().substring(0, 1).equals("G")){ 
    				TreeNode parent=(TreeNode)selectionNode.getParent();
    				if(parent!=null){
    				    int result=0;
    					GoodsVO todel=null;
    				    String[] GoodsInfo=selectionNode.toString().split(" ");
    				    String[] pInfo=parent.toString().split(" ");
    				   
    				    todel=new GoodsVO(pInfo[1], pInfo[2], GoodsInfo[1], GoodsInfo[2], GoodsInfo[3], null, null, null, null, null, null);
    					    					
    					if(todel.getParentNum().equals("0000")){
    						result=1000;   ///错误类型:特价包不能由库存管理人员由编辑
    					}
    					else{
    						result=gbcontroller.delGoods(todel);
    					}
    					if(result==0){
    				     if(selectionNode.isLeaf()){
    				    	MainPane.Infomation=MainPane.Infomation+MainPane.getPresentTime()+" 删除了商品  "+delGNTF.getText()+"\n";
    						treeModel.removeNodeFromParent(selectionNode);
    						delGNTF.setText("");    						
    				     }
    					}
    					else
    						System.out.println(result);
    				}
    			  }
    			}   		
    		}
    	});
    	
    	
    	
    	updGoods=new JButton("修改商品");
    	updGoods.setVisible(true);
    	updGoods.setBounds(260, 340, 100, 28);
    	updGoods.addActionListener(new ActionListener(){
    		
			public void actionPerformed(ActionEvent Event) {
				// TODO Auto-generated method stub
				String Info=updGNTF.getText();
				String[] uInfo=Info.split(" ");
				int result=0;
				
				//System.out.println(updGIPTF.getText()+updGEPTF.getText());
				TreeNode select=(TreeNode)stockStruct.getSelectionPath().getLastPathComponent();
				TreeNode parent=select.getParent();
				String[] PInfo=parent.toString().split(" ");
				GoodsVO toUpd=new GoodsVO(PInfo[1], PInfo[2], uInfo[1], uInfo[2], uInfo[3], null, updGIPTF.getText(), updGEPTF.getText(), null, null, null);
				
				//System.out.println(PInfo[1]+" "+PInfo[2]);
				
				if(toUpd.isPackSuccess()==0)
				    result=gbcontroller.updGoods(toUpd);
				else
					result=10001;
				
				if(result==0){
					MainPane.Infomation=MainPane.Infomation+MainPane.getPresentTime()+" 更新了商品   "+updGNTF.getText()+"\n";
					updGIPTF.setText("");
					updGEPTF.setText("");          //弹窗：成功
				}
				else{
					System.out.println(result);   //弹窗：失败
				}
			}
    	});
    	
        toITM=new JButton("报溢");
        toITM.setVisible(true);
        toITM.setBounds(260, 340, 100, 28);
        toITM.addActionListener(new ActionListener(){
        	
        	public void actionPerformed(ActionEvent e){
        		
        		String[] gInfo=ITMGITF.getText().split(" ");
        		String amount=ITMAmountTF.getText();
        		int result;
        		GoodsVO toIncrease=new GoodsVO(null, null, gInfo[1], gInfo[2], gInfo[3], amount, null, null, null, null, null);
        		
        		result=gbcontroller.increaseToMatch(toIncrease, operator);
        		
        		if(result==0){
        			 MainPane.Infomation=MainPane.Infomation+MainPane.getPresentTime()+" 报溢了商品  "+ITMGITF.getText()+"\n";
        		     ITMAmountTF.setText("");
        		}
        		else{
        			//弹窗报错
        		}
        	}
        });
    	
        toDTM=new JButton("报损");
        toDTM.setVisible(true);
        toDTM.setBounds(260, 340, 100, 28);
    	toDTM.addActionListener(new ActionListener(){
    		
    		public void actionPerformed(ActionEvent e){
    			
    			String[] gInfo=DTMGITF.getText().split(" ");
        		String amount=DTMGAmountTF.getText();
        		int result;
        		GoodsVO toDecrease=new GoodsVO(null, null, gInfo[1], gInfo[2], gInfo[3], amount, null, null, null, null, null);
        		
        		result=gbcontroller.decreaseToMatch(toDecrease, operator);
        		
        		if(result==0){
        			 MainPane.Infomation=MainPane.Infomation+MainPane.getPresentTime()+" 报损了商品  "+DTMGITF.getText()+"\n";
        		     DTMGAmountTF.setText("");
        		}
        		else{
        			//弹窗报错
        		}
    		}
    	});
        
    	toSetWL=new JButton("确定");
    	toSetWL.setVisible(true);
    	toSetWL.setBounds(260, 340, 100, 28);
    	toSetWL.addActionListener(new ActionListener(){
    		
    		public void actionPerformed(ActionEvent e){
    			
    			String[] gInfo=setWLGITF.getText().split(" ");
        		String warningLine=setWLGWLTF.getText();
        		int result;
        		GoodsVO toSetWL=new GoodsVO(null, null, gInfo[1], gInfo[2], gInfo[3], null, null, null, null, null, warningLine);
        		
        		result=gbcontroller.setWaringLine(toSetWL);
        		
        		if(result==0){
        			 MainPane.Infomation=MainPane.Infomation+MainPane.getPresentTime()+setWLGITF.getText()+"设置了警戒值"+setWLGWLTF.getText()+"\n";
        		     setWLGWLTF.setText("");
        		}
        		else{
        			//弹窗报错
        		}
    		}
    	});
    	
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
    	
    	addGP=new JLabel("商品父类");
    	addGP.setVisible(true);
    	addGP.setFont(new Font("黑体", Font.BOLD, 14));
    	addGP.setBounds(120, 30, 80, 30);
    	addGN=new JLabel("商品名称");
    	addGN.setVisible(true);
    	addGN.setFont(new Font("黑体", Font.BOLD, 14));
    	addGN.setBounds(120, 80, 80, 30);
    	addGM=new JLabel("商品型号");
    	addGM.setVisible(true);
    	addGM.setFont(new Font("黑体", Font.BOLD, 14));
    	addGM.setBounds(120, 130, 80, 30);
    	addGIP=new JLabel("商品进价");
    	addGIP.setVisible(true);
    	addGIP.setFont(new Font("黑体", Font.BOLD, 14));
    	addGIP.setBounds(120, 180, 80, 30);
    	addGEP=new JLabel("商品售价");
    	addGEP.setVisible(true);
    	addGEP.setFont(new Font("黑体", Font.BOLD, 14));
    	addGEP.setBounds(120, 230, 80, 30);
    	
    	addGPTF=new JTextField();
    	addGPTF.setVisible(true);
    	addGPTF.setBounds(210, 30, 250, 30);
    	addGPTF.setEditable(false);
    	addGNTF=new JTextField();
    	addGNTF.setVisible(true);
    	addGNTF.setBounds(210, 80, 250, 30);
    	addGMTF=new JTextField();
    	addGMTF.setVisible(true);
    	addGMTF.setBounds(210, 130, 250, 30);
    	addGIPTF=new JTextField();
    	addGIPTF.setVisible(true);
    	addGIPTF.setBounds(210, 180, 250, 30);
    	addGEPTF=new JTextField();
    	addGEPTF.setVisible(true);
    	addGEPTF.setBounds(210, 230, 250, 30);
    	
    	delGN=new JLabel("商品信息");
    	delGN.setVisible(true);
    	delGN.setFont(new Font("黑体", Font.BOLD, 14));
    	delGN.setBounds(120, 80, 80, 30);
    	
    	delGNTF=new JTextField();
    	delGNTF.setVisible(true);
    	delGNTF.setBounds(210, 80, 250, 30);
    	delGNTF.setEditable(false);
    	
    	updGN=new JLabel("商品信息");
    	updGN.setVisible(true);
    	updGN.setFont(new Font("黑体", Font.BOLD, 14));
    	updGN.setBounds(120, 80, 80, 30);
    	
    	updGIP=new JLabel("新进货价");
    	updGIP.setVisible(true);
    	updGIP.setFont(new Font("黑体", Font.BOLD, 14));
    	updGIP.setBounds(120, 130, 80, 30);
    	
    	updGEP=new JLabel("新销售价");
    	updGEP.setVisible(true);
    	updGEP.setFont(new Font("黑体", Font.BOLD, 14));
    	updGEP.setBounds(120, 180, 80, 30);
    	
    	updGNTF=new JTextField();
    	updGNTF.setVisible(true);
    	updGNTF.setBounds(210, 80, 250, 30);
    	updGNTF.setEditable(false);    	
    	updGIPTF=new JTextField();
    	updGIPTF.setVisible(true);
    	updGIPTF.setBounds(210, 130, 250, 30);    	    
    	updGEPTF=new JTextField();
    	updGEPTF.setVisible(true);
    	updGEPTF.setBounds(210, 180, 250, 30);    	
    	
    	shoPane=new JTextArea();
    	SGContainer=new JScrollPane(shoPane);
    	SOP=new JPanel();
    	SOP.setLayout(new GridLayout());
    	JLabel numberL=new JLabel("编号");
    	numberTF=new JTextField();
    	//numberTF.setBounds(5, 5, 40, 25);
    	JLabel nameL=new JLabel("名称");
    	nameTF=new JTextField();
    	//nameTF.setBounds(50, 5, 40, 25);
    	JLabel modelL=new JLabel("型号");
    	modelTF=new JTextField();
    	//nameTF.setBounds(95, 5, 40, 25);
    	finGoods=new JButton("查找");
    	//finGoods.setBounds(140, 5, 40, 25);
    	finGoods.addActionListener(new ActionListener(){
    		
    		public void actionPerformed(ActionEvent Event){
    			
    			String number=numberTF.getText();
    			String name=nameTF.getText();
    			String model=modelTF.getText();
    			String result="";
    			
    			if(number.equals("")){
    				GoodsVO tofin=new GoodsVO(null, null, null, name, model, null, null, null, null, null, null);
    				ArrayList<GoodsVO> finded=gbcontroller.dimFinGoods(tofin);
    				if(finded!=null){
    				  for(GoodsVO g: finded){
    				 	  result=result+g.getInfo()+"\n";
    				  }
    				}
    				else{
    					//弹窗：找不到
    				}
    			}
    			else{
    				GoodsVO tofin=new GoodsVO(null, null, number, null, null, null, null, null, null, null, null);
    				GoodsVO finded=gbcontroller.finGoods(tofin);
    				if(finded!=null)
    				   result=finded.getInfo()+"\n";
    				else{
    					//弹窗：找不到
    				}
    			}
    			
    			numberTF.setText("");
    			nameTF.setText("");
    			modelTF.setText("");
    			shoPane.setText(result);
    		}
    	});
    	refreshGoods=new JButton("所有");
    	//refreshGoods.setBounds(185, 5, 40, 25);
    	refreshGoods.addActionListener(new ActionListener(){
    		
    		public void actionPerformed(ActionEvent Event){
    			
    			String result="";
    			
    			GoodsListVO gl=gbcontroller.shoGoods();
    			ArrayList<GoodsVO> agl=gl.gList;
    			
    			for(GoodsVO g: agl){
    				
    				result=result+g.getInfo()+"\n";
    			}
    			
    			shoPane.setText(result);
    		}
    	});
    	SOP.add(numberTF);
    	SOP.add(numberL);    	
    	SOP.add(nameTF);
    	SOP.add(nameL);
    	SOP.add(modelTF);
    	SOP.add(modelL);
    	SOP.add(finGoods);
    	SOP.add(refreshGoods);
    	
    	ITMGIL=new JLabel("商品信息");
    	ITMGIL.setVisible(true);
    	ITMGIL.setFont(new Font("黑体", Font.BOLD, 14));
    	ITMGIL.setBounds(120, 80, 80, 30);    	
    	ITMAmount=new JLabel("报溢数量");
    	ITMAmount.setVisible(true);
    	ITMAmount.setFont(new Font("黑体", Font.BOLD, 14));
    	ITMAmount.setBounds(120, 130, 80, 30);
      	ITMGITF=new JTextField();
      	ITMGITF.setVisible(true);
      	ITMGITF.setBounds(210, 80, 250, 30);
      	ITMGITF.setEditable(false);    	
    	ITMAmountTF=new JTextField();
    	ITMAmountTF.setVisible(true);
    	ITMAmountTF.setBounds(210, 130, 250, 30);
    	
    	DTMGIL=new JLabel("商品信息");
    	DTMGIL.setVisible(true);
    	DTMGIL.setFont(new Font("黑体", Font.BOLD, 14));
    	DTMGIL.setBounds(120, 80, 80, 30);    	
    	DTMAmount=new JLabel("报损数量");
    	DTMAmount.setVisible(true);
    	DTMAmount.setFont(new Font("黑体", Font.BOLD, 14));
    	DTMAmount.setBounds(120, 130, 80, 30);
      	DTMGITF=new JTextField();
      	DTMGITF.setVisible(true);
      	DTMGITF.setBounds(210, 80, 250, 30);
      	DTMGITF.setEditable(false);    	
    	DTMGAmountTF=new JTextField();
    	DTMGAmountTF.setVisible(true);
    	DTMGAmountTF.setBounds(210, 130, 250, 30);
    	
    	setWLGI=new JLabel("商品信息");
    	setWLGI.setVisible(true);
    	setWLGI.setFont(new Font("黑体", Font.BOLD, 14));
    	setWLGI.setBounds(120, 80, 80, 30);    	
    	setWLGWL=new JLabel("警戒数值");
    	setWLGWL.setVisible(true);
    	setWLGWL.setFont(new Font("黑体", Font.BOLD, 14));
    	setWLGWL.setBounds(120, 130, 80, 30);
      	setWLGITF=new JTextField();
      	setWLGITF.setVisible(true);
      	setWLGITF.setBounds(210, 80, 250, 30);
      	setWLGITF.setEditable(false);    	
    	setWLGWLTF=new JTextField();
    	setWLGWLTF.setVisible(true);
    	setWLGWLTF.setBounds(210, 130, 250, 30);
     
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
        addGoodsP.add(addGP);
        addGoodsP.add(addGN);
        addGoodsP.add(addGM);
        addGoodsP.add(addGEP);
        addGoodsP.add(addGIP);
        addGoodsP.add(addGPTF);
        addGoodsP.add(addGNTF);
        addGoodsP.add(addGMTF);
        addGoodsP.add(addGIPTF);
        addGoodsP.add(addGEPTF);
        delGoodsP=new JPanel();
        delGoodsP.setLayout(null);
        delGoodsP.add(delGN);
        delGoodsP.add(delGoods);
        delGoodsP.add(delGNTF);
        updGoodsP=new JPanel();
        updGoodsP.setLayout(null);
        updGoodsP.add(updGoods);
        updGoodsP.add(updGN);
        updGoodsP.add(updGIP);
        updGoodsP.add(updGEP);
        updGoodsP.add(updGIPTF);
        updGoodsP.add(updGEPTF);
        updGoodsP.add(updGNTF);
        shoGoodsP=new JPanel();
        shoGoodsP.setLayout(new BorderLayout());
        shoGoodsP.add(SGContainer, BorderLayout.CENTER);
        shoGoodsP.add(SOP, BorderLayout.SOUTH);
        ITMP=new JPanel();
        ITMP.setLayout(null);
        ITMP.add(ITMGIL);
        ITMP.add(ITMAmountTF);
        ITMP.add(ITMGITF);
        ITMP.add(ITMAmount);
        ITMP.add(toITM);
        DTMP=new JPanel();
        DTMP.setLayout(null);
        DTMP.add(DTMGIL);
        DTMP.add(DTMGITF);
        DTMP.add(DTMAmount);
        DTMP.add(toDTM);
        DTMP.add(DTMGAmountTF);
        setWLP=new JPanel();
        setWLP.setLayout(null);
        setWLP.add(setWLGI);
        setWLP.add(setWLGITF);
        setWLP.add(setWLGWL);
        setWLP.add(setWLGWLTF);
        setWLP.add(toSetWL);
        goodsOpr.addTab("增加商品", addGoodsP);
        goodsOpr.addTab("删除商品", delGoodsP);
        goodsOpr.addTab("修改商品", updGoodsP);
        goodsOpr.addTab("显示商品", shoGoodsP);
        goodsOpr.addTab("商品报溢", ITMP);
        goodsOpr.addTab("商品报损", DTMP);
        goodsOpr.addTab("设警戒值", setWLP);
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
				 
				 if(nodeName.substring(0, 1).equals("T")||nodeName.substring(0, 2).equals("商品")){
					 
					 addTParent.setText(nodeName);
					 delTInfo.setText(nodeName);
					 updTInfo.setText(nodeName);
					 addGPTF.setText(nodeName);
				 }
				 else if(nodeName.substring(0, 1).equals("G")){
					 
					 delGNTF.setText(nodeName);
					 updGNTF.setText(nodeName);
					 ITMGITF.setText(nodeName);
					 DTMGITF.setText(nodeName);
					 setWLGITF.setText(nodeName);
				 }
			}catch(NullPointerException ne){
				
			}
		}
	}
	
	
}
