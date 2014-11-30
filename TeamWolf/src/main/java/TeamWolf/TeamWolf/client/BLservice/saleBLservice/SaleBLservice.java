package TeamWolf.TeamWolf.client.BLservice.saleBLservice;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.ApplicationVO;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.ImportRejectListVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
import TeamWolf.TeamWolf.client.vo.SaleRejectListVO;




public interface SaleBLservice {
	
	/**
	 * ��ӿͻ�
	 * @param cvo
	 * @return
	 */
	public int addCustomer (CustomerVO cvo);
	
	/**
	 * ɾ��ͻ�
	 * @param name
	 * @param num
	 * @return
	 */
	public int delCustomer (String name, String num);
	
	/**
	 * �޸Ŀͻ�
	 * @param cvo
	 * @return
	 */
	public int modCustomer (CustomerVO cvo);
	
	/**
	 * ���ҿͻ�
	 * @param keyWord
	 * @param number
	 * @return
	 */
	public ArrayList<CustomerVO> findCustomer (String keyWord, String number);
	
	/**
	 * ���������
	 * @param ivo
	 * @return
	 */
	public int createImport (ImportListVO ivo);
	
	/**
	 * ��������˻���
	 * @param evo
	 * @return
	 */
	public int createImportReject (ImportRejectListVO irvo);
	
	/**
	 * �������۵�
	 * @param svo
	 * @return
	 */
	public int createSale (SaleListVO svo);
	
	/**
	 * ���������˻���
	 * @param rvo
	 * @return
	 */
	public int createSaleReject (SaleRejectListVO srvo);
	
	/**
	 * ��ȡ�ֿ���
	 * @return
	 */
	public ArrayList<String> getStock ();
	
	/**
	 * ��ʾ����
	 * @param num
	 * @return
	 */
	public ArrayList<ApplicationVO> show (String num);
	
	/**
	 * �ύ����
	 * @param avo
	 * @return
	 */
	public int submit (ApplicationVO avo);
	
	/**
	 * 获取当前日期
	 * @return
	 */
	public String getPresentDate();

	public ArrayList<ImportListVO> getImportList();
	
	public ArrayList<SaleListVO> getSaleList();

}
