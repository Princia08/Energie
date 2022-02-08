package Interface;

import java.awt.BorderLayout;
import java.awt.Label;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import appareil.Appareil;

public class MonInterface extends JFrame {

	private JPanel contentPane;
	Maison ma;
	Vector listAppareil;
	PlaceObject po;
	JTable table;
	public PlaceObject getPo()
	{
		return po;
	}
	public void addDragListener()
	{
		po=new PlaceObject();
		this.add(po,0);
		
		if(ma==null) {
			ma=new Maison();
			
			this.add(ma,1);
		}
		
		MoseDragedListner temp=new MoseDragedListner(this,po,ma);
		
		po.addMouseMotionListener(temp);
		po.addMouseListener(temp);
		this.repaint();
		
	}
	public void addTable()
	{
		Object[] tabStr=listAppareil.toArray();
		Object[][]donneesObj=new Object[tabStr.length][5];
		String[] s={"Label","Puissance","Quantite","Total jour","Total nuit"};
		System.out.println(tabStr.length);
		for(int i=0;i<tabStr.length;i++)
		{
			donneesObj[i][0]=((Appareil)tabStr[i]).getLabel();
			donneesObj[i][1]=((Appareil)tabStr[i]).getPuissance();
			donneesObj[i][2]=((Appareil)tabStr[i]).getQuantite();
			donneesObj[i][3]=((Appareil)tabStr[i]).getTotalJour();
			donneesObj[i][4]=((Appareil)tabStr[i]).getTotalNuit();
		}
		
		this.remove(table);
		table = new JTable(donneesObj,s);
		table.getTableHeader().setBounds(700, 10, 400, 20);
		table.setBounds(700, 30, 400, 200);
		add(table.getTableHeader());
		//System.out.println("ok");
		
		setSize(1200,800);
		
		add(table);
	}
	public MonInterface() {
		listAppareil=new Vector();
		/*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 935, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);*/
		
		setSize(800,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		addDragListener();
		setVisible(true);
		table=new JTable();
	}
	
	public void addAppareil(Appareil appareil)
	{
		listAppareil.addElement(appareil);
		addTable();
		table.repaint();
		repaint();
	}
}
