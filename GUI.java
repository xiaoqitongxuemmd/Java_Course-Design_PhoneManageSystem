package PhoneStoreManageSystem;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.text.SimpleDateFormat;
public class GUI extends JFrame implements ActionListener{
	JFrame Jf1,Jf2,Jf3,Jf4,Jf5,Jf6,Jf7,Jf8,Jf9;
	JTextField Jtf1,Jtf2,Jtf3,Jtf4,Jtf5,Jtf6,Jtf7,Jtf8,Jtf9,Jtf10,Jtf11,Jtf12,Jtf13,Jtf14,Jtf15;
	JPasswordField Jpw1,Jpw2,Jpw3;
	JLabel Jl1,Jl2,Jl3,Jl4,Jl5,Jl6,Jl7,Jl8,Jl9,Jl10,Jl11,Jl12,Jl13,Jl14,Jl15,Jl16,Jl17,Jl18,Jl19,Jl20,Jl21,Jl22,Jl23,Jl24;
	JButton Jb1,Jb2,Jb3,Jb4,Jb5,Jb6,Jb7,Jb8,Jb9,Jb10,Jb11,Jb12,Jb13,Jb14,Jb15,Jb16,Jb17,Jb18,Jb19,Jb20,Jb21;
	ButtonGroup Jgroup1,Jgroup2,Jgroup3,Jgroup4,Jgroup5,Jgroup6,Jgroup7,Jgroup8;
	JRadioButton Jrb1,Jrb2,Jrb3,Jrb4,Jrb5,Jrb6,Jrb7,Jrb8,Jrb9,Jrb10,Jrb11,Jrb12,Jrb13,Jrb14,Jrb15,Jrb16,Jrb17,Jrb18,Jrb19,Jrb20,Jrb21,Jrb22,Jrb23,Jrb24,Jrb25;
	JTable Jt1;
	JComboBox Jcb1,Jcb2,Jcb3,Jcb4,Jcb5,Jcb6;
	JMenuItem Jmi1,Jmi2;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	String Time = df.format(new Date());
	String RegisterType="";
	String SeekType = "";
	String AddType = "";
	String DeleteType = "";
	String ChangeType = "";
	String IOType = "";
	String AllocateType = "";
	//登录界面
	public void disLoadUI(boolean Visible) {
		setLayout(new GridLayout(5,1));
		JPanel Jp1 = new JPanel(new GridLayout(1,2,30,30));
		Jp1.add(new JLabel("用户名:"));
		Jtf1 = new JTextField(20);
		Jp1.add(Jtf1);
		add(Jp1);
		JPanel Jp2 = new JPanel(new GridLayout(1,2,30,30));
		Jgroup1 = new ButtonGroup();
		Jrb1 = new JRadioButton("管理员");
		Jrb1.addActionListener(this);
		Jrb2 = new JRadioButton("用户");
		Jrb2.addActionListener(this);
		Jgroup1.add(Jrb1);
		Jgroup1.add(Jrb2);
		Jp2.add(Jrb1);
		Jp2.add(Jrb2);
		add(Jp2);
		JPanel Jp3 = new JPanel(new GridLayout(1,2,30,30));
		Jp3.add(new JLabel("密码:"));
		Jpw1 = new JPasswordField(20);
		Jp3.add(Jpw1);
		add(Jp3);
		Jl1 = new JLabel("");
		add(Jl1);
		JPanel Jp4 = new JPanel(new GridLayout(1,2,30,30));
		Jb1 = new JButton("注册");
		Jb1.addActionListener(this);
		Jb2 = new JButton("登录");
		Jb2.addActionListener(this);
		Jp4.add(Jb1);
		Jp4.add(Jb2);
		add(Jp4);
		setTitle("登录");
		setSize(300,200);
		setVisible(Visible);
		setLocation(450,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//主体界面
	public void disMainUI(boolean Visible) {
		Jf1 = new JFrame("手机仓库管理系统");
		Jf1.setLayout(new GridLayout(4,1));
		JMenuBar Jmb = new JMenuBar();
		JMenu Jm1 = new JMenu("基本业务");
		JMenu Jm2 = new JMenu("调拨业务");
		Jmi1 = new JMenuItem("出入库业务");
		Jmi1.addActionListener(this);
		Jmi2 = new JMenuItem("仓库及库存调拨");
		Jmi2.addActionListener(this);
		Jm1.add(Jmi1);
		Jm2.add(Jmi2);
		Jmb.add(Jm1);
		Jmb.add(Jm2);
		Jf1.setJMenuBar(Jmb);
		Jf1.add(Jl2);
		JLabel Jl3 = new JLabel("登录时间:"+Time);
		Jf1.add(Jl3);
		Jf1.add(new JLabel("请选择您要执行的操作"));
		JPanel Jp5 = new JPanel(new GridLayout(1,2,30,30));
		Jb3 = new JButton("查询");
		Jb3.addActionListener(this);
		Jb4 = new JButton("管理");
		Jb4.addActionListener(this);
		Jp5.add(Jb3);
		Jp5.add(Jb4);
		Jf1.add(Jp5);
		Jf1.setSize(300,200);
		Jf1.setVisible(Visible);
		Jf1.setLocation(450,300);
		Jf1.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//注册界面
	public void disRegister(boolean Visible) {
		Jf2 = new JFrame("注册");
		Jf2.setLayout(new GridLayout(6,1));
		JPanel Jp6 = new JPanel(new GridLayout(1,2,30,30));
		Jrb3 = new JRadioButton("管理员");
		Jrb3.addActionListener(this);
		Jrb4 = new JRadioButton("用户");
		Jrb4.addActionListener(this);
		Jgroup2 = new ButtonGroup();
		Jgroup2.add(Jrb3);
		Jgroup2.add(Jrb4);
		Jp6.add(Jrb3);
		Jp6.add(Jrb4);
		Jf2.add(Jp6);
		JPanel Jp7 = new JPanel(new GridLayout(1,2,30,30));
		Jp7.add(new JLabel("用户名:"));
		Jtf2 = new JTextField(20);
		Jp7.add(Jtf2);
		Jf2.add(Jp7);
		JPanel Jp8 = new JPanel(new GridLayout(1,2,30,30));
		Jp8.add(new JLabel("请输入密码:"));
		Jpw2 = new JPasswordField(20);
		Jp8.add(Jpw2);
		Jf2.add(Jp8);
		JPanel Jp9 = new JPanel(new GridLayout(1,2,30,30));
		Jp9.add(new JLabel("确认密码:"));
		Jpw3 = new JPasswordField(20);
		Jp9.add(Jpw3);
		Jf2.add(Jp9);
		Jl3 = new JLabel("");
		Jf2.add(Jl3);
		JPanel Jp10 = new JPanel(new GridLayout(1,2,30,30));
		Jp10.add(new JPanel());
		Jb5 = new JButton("注册");
		Jb5.addActionListener(this);
		Jp10.add(Jb5);
		Jf2.add(Jp10);
		Jf2.setSize(300,200);
		Jf2.setVisible(Visible);
		Jf2.setLocation(450,300);
		Jf2.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//查询界面
	public void disSeekUI(boolean Visible) {
		Jf3 = new JFrame("查询");
		Jf3.setLayout(new GridLayout(2,1));
		JPanel Jp1 = new JPanel(new GridLayout(6,1,20,20));
		Jp1.add(new JLabel("请选择查询的内容"));
		JPanel Jp2 = new JPanel(new GridLayout(1,5,20,20));
		Jrb5 = new JRadioButton("手机信息");
		Jrb5.addActionListener(this);
		Jrb6 = new JRadioButton("订单信息");
		Jrb6.addActionListener(this);
		Jrb7 = new JRadioButton("公司信息");
		Jrb7.addActionListener(this);
		Jrb8 = new JRadioButton("仓储信息");
		Jrb8.addActionListener(this);
		Jrb9 = new JRadioButton("手机定位");
		Jrb9.addActionListener(this);
		Jgroup3 = new ButtonGroup();
		Jgroup3.add(Jrb5);
		Jgroup3.add(Jrb6);
		Jgroup3.add(Jrb7);
		Jgroup3.add(Jrb8);
		Jgroup3.add(Jrb9);
		Jp2.add(Jrb5);
		Jp2.add(Jrb6);
		Jp2.add(Jrb7);
		Jp2.add(Jrb8);
		Jp2.add(Jrb9);
		Jp1.add(Jp2);
		Jp1.add(new JLabel("请选择筛选条件"));
		JPanel Jp3 = new JPanel(new GridLayout(1,2,30,30));
		Jl4 = new JLabel("首选条件:");
		Jp3.add(Jl4);
		Jcb1 = new JComboBox();
		Jp3.add(Jcb1);
		Jp1.add(Jp3);
		JPanel Jp4 = new JPanel(new GridLayout(1,2,30,30));
		Jl5 = new JLabel("次选条件:");
		Jp4.add(Jl5);
		Jtf3 = new JTextField("为空则查询符合首要条件的全部项目",30);
		Jp4.add(Jtf3);
		Jp1.add(Jp4);
		JPanel Jp5 = new JPanel(new GridLayout(1,2,30,30));
		Jb7 = new JButton("返回上一级");
		Jb7.addActionListener(this);
		Jp5.add(Jb7);
		Jb6 = new JButton("查询");
		Jb6.addActionListener(this);
		Jp5.add(Jb6);
		Jp1.add(Jp5);
		Jf3.add(Jp1);
		Jt1 = new JTable();
		Jf3.add(Jt1);
		Jf3.setSize(700,500);
		Jf3.setVisible(Visible);
		Jf3.setLocation(300,200);
		Jf3.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//管理主界面
	public void disManagerMainUI(boolean Visible) {
		Jf4 = new JFrame("管理");
		Jf4.setLayout(new GridLayout(5,1,30,30));
		Jf4.add(new JLabel("请选择需要进行的操作"));
		JPanel Jp1 = new JPanel(new GridLayout(1,3,30,30));
		Jp1.add(new JPanel());
		Jb8 = new JButton("添加信息");
		Jb8.addActionListener(this);
		Jp1.add(Jb8);
		Jp1.add(new JPanel());
		Jf4.add(Jp1);
		JPanel Jp2 = new JPanel(new GridLayout(1,3,30,30));
		Jp2.add(new JPanel());
		Jb9 = new JButton("删除信息");
		Jb9.addActionListener(this);
		Jp2.add(Jb9);
		Jp2.add(new JPanel());
		Jf4.add(Jp2);
		JPanel Jp3 = new JPanel(new GridLayout(1,3,30,30));
		Jp3.add(new JPanel());
		Jb10 = new JButton("修改信息");
		Jb10.addActionListener(this);
		Jp3.add(Jb10);
		Jp3.add(new JPanel());
		Jf4.add(Jp3);
		JPanel Jp4 = new JPanel(new GridLayout(1,3,30,30));
		Jp4.add(new JPanel());
		Jb11 = new JButton("返回上一级");
		Jb11.addActionListener(this);
		Jp4.add(Jb11);
		Jp4.add(new JPanel());
		Jf4.add(Jp4);
		Jf4.setSize(400,300);
		Jf4.setVisible(Visible);
		Jf4.setLocation(450,300);
		Jf4.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//添加信息界面
	public void disAddInfoUI(boolean Visible) {
		Jf5 = new JFrame("添加信息");
		Jf5.setLayout(new GridLayout(9,1,30,30));
		Jf5.add(new JLabel("请选择需要添加的信息类型:"));
		JPanel Jp1 = new JPanel(new GridLayout(1,4,30,30));
		Jrb10 = new JRadioButton("手机信息");
		Jrb10.addActionListener(this);
		Jp1.add(Jrb10);
		Jrb11 = new JRadioButton("订单信息");
		Jrb11.addActionListener(this);
		Jp1.add(Jrb11);
		Jrb12 = new JRadioButton("公司信息");
		Jrb12.addActionListener(this);
		Jp1.add(Jrb12);
		Jrb13 = new JRadioButton("仓储信息");
		Jrb13.addActionListener(this);
		Jp1.add(Jrb13);
		Jgroup4 = new ButtonGroup();
		Jgroup4.add(Jrb10);
		Jgroup4.add(Jrb11);
		Jgroup4.add(Jrb12);
		Jgroup4.add(Jrb13);
		Jf5.add(Jp1);
		JPanel Jp2 = new JPanel(new GridLayout(1,2,30,30));
		Jl6 = new JLabel("项目1:");
		Jp2.add(Jl6);
		Jcb2 = new JComboBox();
		Jp2.add(Jcb2);
		Jf5.add(Jp2);
		JPanel Jp3 = new JPanel(new GridLayout(1,2,30,30));
		Jl7 = new JLabel("项目2:");
		Jp3.add(Jl7);
		Jtf4 = new JTextField(30);
		Jp3.add(Jtf4);
		Jf5.add(Jp3);
		JPanel Jp4 = new JPanel(new GridLayout(1,2,30,30));
		Jl8 = new JLabel("项目3:");
		Jp4.add(Jl8);
		Jtf5 = new JTextField(30);
		Jp4.add(Jtf5);
		Jf5.add(Jp4);
		JPanel Jp5 = new JPanel(new GridLayout(1,2,30,30));
		Jl9 = new JLabel("项目4:");
		Jp5.add(Jl9);
		Jtf6 = new JTextField(30);
		Jp5.add(Jtf6);
		Jf5.add(Jp5);
		JPanel Jp6 = new JPanel(new GridLayout(1,2,30,30));
		Jl10 = new JLabel("项目5:");
		Jp6.add(Jl10);
		Jtf7 = new JTextField(30);
		Jp6.add(Jtf7);
		Jf5.add(Jp6);
		JPanel Jp7 = new JPanel(new GridLayout(1,2,30,30));
		Jl11 = new JLabel("项目6:");
		Jp7.add(Jl11);
		Jtf8 = new JTextField(30);
		Jp7.add(Jtf8);
		Jf5.add(Jp7);
		JPanel Jp8 = new JPanel(new GridLayout(1,2,30,30));
		Jb12 = new JButton("返回上一级");
		Jb12.addActionListener(this);
		Jp8.add(Jb12);
		Jb13 = new JButton("添加");
		Jb13.addActionListener(this);
		Jp8.add(Jb13);
		Jf5.add(Jp8);
		Jf5.setSize(500,550);
		Jf5.setVisible(Visible);
		Jf5.setLocation(300,200);
		Jf5.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//删除信息界面
	public void disDeleteInfoUI(boolean Visible) {
		Jf6 = new JFrame("删除信息");
		Jf6.setLayout(new GridLayout(5,1,30,30));
		Jf6.add(new JLabel("请选择需要删除的信息"));
		JPanel Jp1 = new JPanel(new GridLayout(1,4,30,30));
		Jrb14 = new JRadioButton("手机信息");
		Jrb14.addActionListener(this);
		Jp1.add(Jrb14);
		Jrb15 = new JRadioButton("订单信息");
		Jrb15.addActionListener(this);
		Jp1.add(Jrb15);
		Jrb16 = new JRadioButton("公司信息");
		Jrb16.addActionListener(this);
		Jp1.add(Jrb16);
		Jrb17 = new JRadioButton("仓储信息");
		Jrb17.addActionListener(this);
		Jp1.add(Jrb17);
		Jgroup4 = new ButtonGroup();
		Jgroup4.add(Jrb14);
		Jgroup4.add(Jrb15);
		Jgroup4.add(Jrb16);
		Jgroup4.add(Jrb17);
		Jf6.add(Jp1);
		JPanel Jp2 = new JPanel(new GridLayout(1,2,30,30));
		Jl12 = new JLabel("项目1:");
		Jp2.add(Jl12);
		Jcb3 = new JComboBox();
		Jp2.add(Jcb3);
		Jf6.add(Jp2);
		JPanel Jp3 = new JPanel(new GridLayout(1,2,30,30));
		Jl13 = new JLabel("项目2:");
		Jp3.add(Jl13);
		Jtf9 = new JTextField(30);
		Jp3.add(Jtf9);
		Jf6.add(Jp3);
		JPanel Jp4 = new JPanel(new GridLayout(1,2,30,30));
		Jb14 = new JButton("返回上一级");
		Jb14.addActionListener(this);
		Jp4.add(Jb14);
		Jb15 = new JButton("删除");
		Jb15.addActionListener(this);
		Jp4.add(Jb15);
		Jf6.add(Jp4);
		Jf6.setSize(500,300);
		Jf6.setVisible(Visible);
		Jf6.setLocation(300,200);
		Jf6.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//修改信息界面
	public void disChangeInfoUI(boolean Visible) {
		Jf7 = new JFrame("修改信息");
		Jf7.setLayout(new GridLayout(7,1,30,30));
		Jf7.add(new JLabel("请选择需要修改的信息类型:"));
		JPanel Jp1 = new JPanel(new GridLayout(1,4,30,30));
		Jrb18 = new JRadioButton("手机信息");
		Jrb18.addActionListener(this);
		Jp1.add(Jrb18);
		Jrb19 = new JRadioButton("订单信息");
		Jrb19.addActionListener(this);
		Jp1.add(Jrb19);
		Jrb20 = new JRadioButton("公司信息");
		Jrb20.addActionListener(this);
		Jp1.add(Jrb20);
		Jrb21 = new JRadioButton("仓储信息");
		Jrb21.addActionListener(this);
		Jp1.add(Jrb21);
		Jgroup6 = new ButtonGroup();
		Jgroup6.add(Jrb18);
		Jgroup6.add(Jrb19);
		Jgroup6.add(Jrb20);
		Jgroup6.add(Jrb21);
		Jf7.add(Jp1);
		JPanel Jp2 = new JPanel(new GridLayout(1,2,30,30));
		Jl14 = new JLabel("项目1:");
		Jp2.add(Jl14);
		Jcb4 = new JComboBox();
		Jp2.add(Jcb4);
		Jf7.add(Jp2);
		JPanel Jp3 = new JPanel(new GridLayout(1,2,30,30));
		Jl15 = new JLabel("项目2:");
		Jp3.add(Jl15);
		Jtf10 = new JTextField(30);
		Jp3.add(Jtf10);
		Jf7.add(Jp3);
		JPanel Jp4 = new JPanel(new GridLayout(1,2,30,30));
		Jl16 = new JLabel("项目3:");
		Jp4.add(Jl16);
		Jtf11 = new JTextField(30);
		Jp4.add(Jtf11);
		Jf7.add(Jp4);
		JPanel Jp5 = new JPanel(new GridLayout(1,2,30,30));
		Jl17 = new JLabel("项目4:");
		Jp5.add(Jl17);
		Jtf12 = new JTextField(30);
		Jp5.add(Jtf12);
		Jf7.add(Jp5);
		JPanel Jp6 = new JPanel(new GridLayout(1,2,30,30));
		Jb16 = new JButton("返回上一级");
		Jb16.addActionListener(this);
		Jp6.add(Jb16);
		Jb17 = new JButton("修改");
		Jb17.addActionListener(this);
		Jp6.add(Jb17);
		Jf7.add(Jp6);
		Jf7.setSize(500,400);
		Jf7.setVisible(Visible);
		Jf7.setLocation(300,200);
		Jf7.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//出入库界面
	public void disWarehouseUI(boolean Visible) {
		Jf8 = new JFrame("出入库业务");
		Jf8.setLayout(new GridLayout(7,1,30,30));
		Jf8.add(new JLabel("请选择出库还是入库"));
		JPanel Jp1 = new JPanel(new GridLayout(1,2,30,30));
		Jrb22 = new JRadioButton("入库");
		Jrb22.addActionListener(this);
		Jrb23 = new JRadioButton("出库");
		Jrb23.addActionListener(this);
		Jgroup7 = new ButtonGroup();
		Jgroup7.add(Jrb22);
		Jgroup7.add(Jrb23);
		Jp1.add(Jrb22);
		Jp1.add(Jrb23);
		Jf8.add(Jp1);
		JPanel Jp2 = new JPanel(new GridLayout(1,2,30,30));
		Jl18 = new JLabel("生产厂商");
		Jp2.add(Jl18);
		Jcb5 = new JComboBox();
		Jcb5.addItem("Apple");
		Jcb5.addItem("HuaWei");
		Jcb5.addItem("MI");
		Jp2.add(Jcb5);
		Jf8.add(Jp2);
		JPanel Jp3 = new JPanel(new GridLayout(1,2,30,30));
		Jl19 = new JLabel("手机型号");
		Jp3.add(Jl19);
		Jtf13 = new JTextField(20);
		Jp3.add(Jtf13);
		Jf8.add(Jp3);
		JPanel Jp4 = new JPanel(new GridLayout(1,2,30,30));
		Jl20 = new JLabel("手机数量");
		Jp4.add(Jl20);
		Jtf14 = new JTextField(20);
		Jp4.add(Jtf14);
		Jf8.add(Jp4);
		Jl21 = new JLabel();
		Jf8.add(Jl21);
		JPanel Jp5 = new JPanel(new GridLayout(1,2,30,30));
		Jb18 = new JButton("返回上一级");
		Jb18.addActionListener(this);
		Jp5.add(Jb18);
		Jb19 = new JButton("执行");
		Jb19.addActionListener(this);
		Jp5.add(Jb19);
		Jf8.add(Jp5);
		Jf8.setSize(300,400);
		Jf8.setVisible(Visible);
		Jf8.setLocation(300,300);
		Jf8.setDefaultCloseOperation(EXIT_ON_CLOSE);;
	}
	//调拨界面
	public void disAllocateUI(boolean Visible) {
		Jf9 = new JFrame("调拨");
		Jf9.setLayout(new GridLayout(6,1,30,30));
		Jf9.add(new JLabel("请选择调拨库存或调拨仓库"));
		JPanel Jp1 = new JPanel(new GridLayout(1,2,30,30));
		Jrb24 = new JRadioButton("调拨库存");
		Jrb24.addActionListener(this);
		Jrb25 = new JRadioButton("调拨仓库");
		Jrb25.addActionListener(this);
		Jgroup8 = new ButtonGroup();
		Jgroup8.add(Jrb24);
		Jgroup8.add(Jrb25);
		Jp1.add(Jrb24);
		Jp1.add(Jrb25);
		Jf9.add(Jp1);
		JPanel Jp2 = new JPanel(new GridLayout(1,2,30,30));
		Jl22 = new JLabel("货架");
		Jp2.add(Jl22);
		Jcb6 = new JComboBox();
		Jcb6.addItem("A");
		Jcb6.addItem("B");
		Jcb6.addItem("C");
		Jp2.add(Jcb6);
		Jf9.add(Jp2);
		JPanel Jp3 = new JPanel(new GridLayout(1,2,30,30));
		Jl23 = new JLabel("手机型号");
		Jp3.add(Jl23);
		Jtf15 = new JTextField(20);
		Jp3.add(Jtf15);
		Jf9.add(Jp3);
		Jl24 = new JLabel();
		Jf9.add(Jl24);
		JPanel Jp4 = new JPanel(new GridLayout(1,2,30,30));
		Jb20 = new JButton("返回上一级");
		Jb20.addActionListener(this);
		Jp4.add(Jb20);
		Jb21 = new JButton("执行");
		Jb21.addActionListener(this);
		Jp4.add(Jb21);
		Jf9.add(Jp4);
		Jf9.setSize(300,300);
		Jf9.setVisible(Visible);
		Jf9.setLocation(450,300);
		Jf9.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		Mysql ms1 = new Mysql();
		if(e.getSource()==Jrb1) {
			Jl2 = new JLabel("欢迎您: 管理员"+Jtf1.getText());
		}
		if(e.getSource()==Jrb2) {
			Jl2 = new JLabel("欢迎您: 用户"+Jtf1.getText());
		}
		if(e.getSource()==Jb1) {
			this.disRegister(true);
			this.setVisible(false);
		}
		if(e.getSource()==Jb2) {
			if(ms1.isMatch(Jtf1.getText(),String.valueOf(Jpw1.getPassword()))==0) {
				Jl1.setText("用户名不存在");
			}
			if(ms1.isMatch(Jtf1.getText(),String.valueOf(Jpw1.getPassword()))==1) {
				Jl1.setText("用户名与密码不匹配");
			}
			if(ms1.isMatch(Jtf1.getText(),String.valueOf(Jpw1.getPassword()))==2) {
				this.disMainUI(true);
				this.setVisible(false);
			}
		}
		if(e.getSource()==Jrb3) {
			RegisterType = "Admin";
		}
		if(e.getSource()==Jrb4) {
			RegisterType = "User";
		}
		if(e.getSource()==Jb5) {
			if(String.valueOf(Jpw2.getPassword()).equals(String.valueOf(Jpw3.getPassword()))) {
				if(ms1.addLoadMessage(RegisterType, Jtf2.getText(),String.valueOf(Jpw2.getPassword()))==1) {
					Jl3.setText("用户名重复");
				}
				else{
					Jf2.setVisible(false);
					this.setVisible(true);
				}
			}
			else {
				Jl3.setText("两次输入密码不一致");
			}
		}
		if(e.getSource()==Jrb5) {
			SeekType = "PhoneMessage";
			Jl4.setVisible(true);
			Jcb1.setVisible(true);
			Jl4.setText("生产厂商:");
			Jl5.setText("手机型号:");
			Jtf3.setText("为空则查询符合首要条件的全部项目");
			Jcb1.removeAllItems();
			Jcb1.addItem("Apple");
			Jcb1.addItem("HuaWei");
			Jcb1.addItem("MI");
		}
		if(e.getSource()==Jrb6) {
			SeekType = "ClientOrder";
			Jl4.setVisible(false);
			Jcb1.setVisible(false);
			Jtf3.setText("为空则查询符合首要条件的全部项目");
			Jl5.setText("订单号:");
		}
		if(e.getSource()==Jrb7) {
			SeekType = "FirmMessage";
			Jl4.setVisible(false);
			Jcb1.setVisible(false);
			Jtf3.setText("为空则查询符合首要条件的全部项目");
			Jl5.setText("公司名称:");
		}
		if(e.getSource()==Jrb8) {
			SeekType = "StoreMessage";
			Jl4.setVisible(true);
			Jcb1.setVisible(true);
			Jl4.setText("货架:");
			Jl5.setText("编号:");
			Jtf3.setText("为空则查询符合首要条件的全部项目");
			Jcb1.removeAllItems();
			Jcb1.addItem("A");
			Jcb1.addItem("B");
			Jcb1.addItem("C");
		}
		if(e.getSource()==Jrb9) {
			SeekType = "PhoneLocation";
			Jl4.setVisible(false);
			Jcb1.setVisible(false);
			Jtf3.setText("为空则查询符合首要条件的全部项目");
			Jl5.setText("手机型号:");
		}
		if(e.getSource()==Jb6) {
			if(SeekType.equals("PhoneMessage")) {
				if(Jtf3.getText().equals("")||Jtf3.getText().equals("为空则查询符合首要条件的全部项目")) {
					Jt1.setModel(ms1.seekPhoneMessageAll(Jcb1.getSelectedItem().toString()));	
				}
				else {
					Jt1.setModel(ms1.seekPhoneMessage(Jcb1.getSelectedItem().toString(),"'"+Jtf3.getText()+"'"));
				}
			}
			if(SeekType.equals("ClientOrder")) {
				if(Jtf3.getText().equals("")||Jtf3.getText().equals("为空则查询符合首要条件的全部项目")) {
					Jt1.setModel(ms1.seekClientOrderAll());	
				}
				else {
					Jt1.setModel(ms1.seekClientOrder("'"+Jtf3.getText()+"'"));
				}
			}
			if(SeekType.equals("FirmMessage")) {
				if(Jtf3.getText().equals("")||Jtf3.getText().equals("为空则查询符合首要条件的全部项目")) {
					Jt1.setModel(ms1.seekFirmMessageAll());	
				}
				else {
					Jt1.setModel(ms1.seekFirmMessage("'"+Jtf3.getText()+"'"));
				}
			}
			if(SeekType.equals("StoreMessage")) {
				if(Jtf3.getText().equals("")||Jtf3.getText().equals("为空则查询符合首要条件的全部项目")) {
					Jt1.setModel(ms1.seekStoreMessageAll(Jcb1.getSelectedItem().toString()));	
				}
				else {
					Jt1.setModel(ms1.seekStoreMessage(Jcb1.getSelectedItem().toString(),"'"+Jtf3.getText()+"'"));
				}
			}
			if(SeekType.equals("PhoneLocation")) {
				Jt1.setModel(ms1.seekPhoneLocation("'"+Jtf3.getText()+"'"));
			}
		}
		if(e.getSource()==Jb3) {
			this.disSeekUI(true);
			Jf1.setVisible(false);
		}
		if(e.getSource()==Jb7) {
			Jf3.setVisible(false);
			Jf1.setVisible(true);
		}
		if(e.getSource()==Jb4) {
			this.disManagerMainUI(true);
			Jf1.setVisible(false);
		}
		if(e.getSource()==Jb11) {
			Jf4.setVisible(false);
			Jf1.setVisible(true);
		}
		if(e.getSource()==Jb8) {
			this.disAddInfoUI(true);
			Jf4.setVisible(false);
		}
		if(e.getSource()==Jb12) {
			Jf5.setVisible(false);
			Jf4.setVisible(true);
		}
		if(e.getSource()==Jrb10) {
			AddType = "PhoneMessage";
			Jcb2.removeAllItems();
			Jcb2.addItem("Apple");
			Jcb2.addItem("HuaWei");
			Jcb2.addItem("MI");
			Jcb2.setVisible(true);
			Jl6.setVisible(true);
			Jl6.setText("生产厂商:");
			Jl7.setVisible(true);
			Jl7.setText("手机型号:");
			Jtf4.setVisible(true);
			Jtf4.setText("");
			Jl8.setVisible(true);
			Jl8.setText("手机数量:");
			Jtf5.setVisible(true);
			Jtf5.setText("");
			Jl9.setVisible(true);
			Jl9.setText("手机价格:");
			Jtf6.setVisible(true);
			Jtf6.setText("");
			Jl10.setVisible(false);
			Jtf7.setVisible(false);
			Jl11.setVisible(false);
			Jtf8.setVisible(false);
		}
		if(e.getSource()==Jrb11) {
			String Time1 = df.format(new Date());
			AddType = "ClientOrder";
			Jcb2.setVisible(false);
			Jl6.setVisible(false);
			Jl6.setText("生产厂商:");
			Jl7.setVisible(true);
			Jl7.setText("订单号:");
			Jtf4.setVisible(true);
			Jtf4.setText("");
			Jl8.setVisible(true);
			Jl8.setText("用户姓名:");
			Jtf5.setVisible(true);
			Jtf5.setText("");
			Jl9.setVisible(true);
			Jl9.setText("用户手机:");
			Jtf6.setVisible(true);
			Jtf6.setText("");
			Jl10.setVisible(true);
			Jl10.setText("用户地址:");
			Jtf7.setVisible(true);
			Jtf7.setText("");
			Jl11.setVisible(true);
			Jl11.setText("发货时间:");
			Jtf8.setVisible(true);
			Jtf8.setText("");
			Jtf8.setText(Time1);
		}
		if(e.getSource()==Jrb12) {
			AddType = "FirmMessage";
			Jcb2.setVisible(false);
			Jl6.setVisible(false);
			Jl6.setText("生产厂商:");
			Jl7.setVisible(true);
			Jl7.setText("公司名称:");
			Jtf4.setVisible(true);
			Jtf4.setText("");
			Jl8.setVisible(true);
			Jl8.setText("公司地址:");
			Jtf5.setVisible(true);
			Jtf5.setText("");
			Jl9.setVisible(true);
			Jl9.setText("联系人电话:");
			Jtf6.setVisible(true);
			Jtf6.setText("");
			Jl10.setVisible(true);
			Jl10.setText("公司结余");
			Jtf7.setVisible(true);
			Jtf7.setText("");
			Jl11.setVisible(false);
			Jtf8.setVisible(false);
		}
		if(e.getSource()==Jrb13) {
			AddType = "StoreMessage";
			Jcb2.removeAllItems();
			Jcb2.addItem("A");
			Jcb2.addItem("B");
			Jcb2.addItem("C");
			Jcb2.setVisible(true);
			Jl6.setVisible(true);
			Jl6.setText("货架:");
			Jl7.setVisible(true);
			Jl7.setText("编号:");
			Jtf4.setVisible(true);
			Jtf4.setText("");
			Jl8.setVisible(true);
			Jl8.setText("手机型号:");
			Jtf5.setVisible(true);
			Jtf5.setText("");
			Jl9.setVisible(false);
			Jtf6.setVisible(false);
			Jl10.setVisible(false);
			Jtf7.setVisible(false);
			Jl11.setVisible(false);
			Jtf8.setVisible(false);
		}
		if(e.getSource()==Jb13) {
			if(AddType.equals("PhoneMessage")) {
				String str = "'"+Jtf4.getText()+"','"+Jtf5.getText()+"','"+Jtf6.getText()+"'";
				ms1.addPhoneMessage(Jcb2.getSelectedItem().toString(), str);
			}
			if(AddType.equals("ClientOrder")) {
				String str = "'"+Jtf4.getText()+"','"+Jtf5.getText()+"','"+Jtf6.getText()+"','"+Jtf7.getText()+"','"+Jtf8.getText()+"'";
				ms1.addClientOrder(str);
			}
			if(AddType.equals("FirmMessage")) {
				String str = "'"+Jtf4.getText()+"','"+Jtf5.getText()+"','"+Jtf6.getText()+"','"+Jtf7.getText()+"'";
				ms1.addFirmMessage(str);
			}
			if(AddType.equals("StoreMessage")) {
				String str = "'"+Jtf4.getText()+"','"+Jtf5.getText()+"'";
				if(ms1.isExist(Jcb2.getSelectedItem().toString(), "'"+Jtf4.getText()+"'")==1) {
					Jl9.setVisible(true);
					Jl9.setText("该位置已有货物");
				}
				else {
					ms1.addStoreMessage(Jcb2.getSelectedItem().toString(), str);
				}	
			}
		}
		if(e.getSource()==Jb9) {
			this.disDeleteInfoUI(true);
			Jf4.setVisible(false);
		}
		if(e.getSource()==Jb14) {
			Jf6.setVisible(false);
			Jf4.setVisible(true);
		}
		if(e.getSource()==Jrb14) {
			DeleteType = "PhoneMessage";
			Jcb3.removeAllItems();
			Jcb3.addItem("Apple");
			Jcb3.addItem("HuaWei");
			Jcb3.addItem("MI");
			Jcb3.setVisible(true);
			Jl12.setVisible(true);
			Jl12.setText("生产厂商:");
			Jl13.setText("手机型号:");
			Jtf9.setText("");
		}
		if(e.getSource()==Jrb15) {
			DeleteType = "ClientOrder";
			Jcb3.setVisible(false);
			Jl12.setVisible(false);
			Jl12.setText("生产厂商:");
			Jl13.setText("订单号:");
			Jtf9.setText("");
		}
		if(e.getSource()==Jrb16) {
			DeleteType = "FirmMessage";
			Jcb3.setVisible(false);
			Jl12.setVisible(false);
			Jl12.setText("生产厂商:");
			Jl13.setText("公司名称:");
			Jtf9.setText("");
		}
		if(e.getSource()==Jrb17) {
			DeleteType = "StoreMessage";
			Jcb3.removeAllItems();
			Jcb3.addItem("A");
			Jcb3.addItem("B");
			Jcb3.addItem("C");
			Jcb3.setVisible(true);
			Jl12.setVisible(true);
			Jl12.setText("货架:");
			Jl13.setText("编号:");
			Jtf9.setText("");
		}
		if(e.getSource()==Jb15) {
			if(DeleteType.equals("PhoneMessage")) {
				String str = "'"+Jtf9.getText()+"'";
				ms1.deletePhoneMessage(Jcb3.getSelectedItem().toString(), str);
			}
			if(DeleteType.equals("ClientOrder")) {
				String str = "'"+Jtf9.getText()+"'";
				ms1.deleteClientOrder(str);
			}
			if(DeleteType.equals("FirmMessage")) {
				String str = "'"+Jtf9.getText()+"'";
				ms1.deleteFirmMessage(str);
			}
			if(DeleteType.equals("StoreMessage")) {
				String str = "'"+Jtf9.getText()+"'";
				ms1.deleteStoreMessage(Jcb3.getSelectedItem().toString(), str);
			}
		}
		if(e.getSource()==Jb10) {
			this.disChangeInfoUI(true);
			Jf4.setVisible(false);
		}
		if(e.getSource()==Jb16) {
			Jf7.setVisible(false);
			Jf4.setVisible(true);
		}
		if(e.getSource()==Jrb18) {
			ChangeType = "PhoneMessage";
			Jcb4.removeAllItems();
			Jcb4.addItem("Apple");
			Jcb4.addItem("HuaWei");
			Jcb4.addItem("MI");
			Jcb4.setVisible(true);
			Jl14.setText("生产厂商:");
			Jl14.setVisible(true);
			Jl15.setText("修改项:");
			Jl16.setText("手机型号:");
			Jl17.setText("修改内容:");
			Jtf10.setText("");
			Jtf11.setText("");
			Jtf12.setText("");
		}
		if(e.getSource()==Jrb19) {
			ChangeType = "ClientOrder";
			Jcb4.setVisible(false);
			Jl14.setText("生产厂商:");
			Jl14.setVisible(false);
			Jl15.setText("修改项:");
			Jl16.setText("订单号");
			Jl17.setText("修改内容:");
			Jtf10.setText("");
			Jtf11.setText("");
			Jtf12.setText("");
		}
		if(e.getSource()==Jrb20) {
			ChangeType = "FirmMessage";
			Jcb4.setVisible(false);
			Jl14.setText("生产厂商:");
			Jl14.setVisible(false);
			Jl15.setText("修改项:");
			Jl16.setText("公司名称:");
			Jl17.setText("修改内容:");
			Jtf10.setText("");
			Jtf11.setText("");
			Jtf12.setText("");
		}
		if(e.getSource()==Jrb21) {
			ChangeType = "StoreMessage";
			Jcb4.removeAllItems();
			Jcb4.addItem("A");
			Jcb4.addItem("B");
			Jcb4.addItem("C");
			Jcb4.setVisible(true);
			Jl14.setText("生产厂商:");
			Jl14.setVisible(true);
			Jl15.setText("修改项:");
			Jl16.setText("编号:");
			Jl17.setText("修改内容:");
			Jtf10.setText("");
			Jtf11.setText("");
			Jtf12.setText("");
		}
		if(e.getSource()==Jb17) {
			if(ChangeType.equals("PhoneMessage")) {
				ms1.changePhoneMessage(Jcb4.getSelectedItem().toString(),Jtf10.getText(),"'"+Jtf11.getText()+"'","'"+Jtf12.getText()+"'");
			}
			if(ChangeType.equals("ClientOrder")) {
				ms1.changeClientOrder("'"+Jtf11.getText()+"'",Jtf10.getText(),"'"+Jtf12.getText()+"'");
			}
			if(ChangeType.equals("FirmMessage")) {
				ms1.changeFirmMessage("'"+Jtf11.getText()+"'",Jtf10.getText(),"'"+Jtf12.getText()+"'");
			}
			if(ChangeType.equals("StoreMessage")) {
				ms1.changeStoreMessage(Jcb4.getSelectedItem().toString(),Jtf10.getText(),"'"+Jtf11.getText()+"'","'"+Jtf12.getText()+"'");
			}
		}
		if(e.getSource()==Jmi1) {
			this.disWarehouseUI(true);
			Jf1.setVisible(false);
		}
		if(e.getSource()==Jb18) {
			Jf8.setVisible(false);
			Jf1.setVisible(true);
		}
		if(e.getSource()==Jrb22) {
			IOType = "Input";
		}
		if(e.getSource()==Jrb23) {
			IOType = "Output";
		}
		if(e.getSource()==Jb19) {
			if(IOType.equals("Input")) {
				int flag = ms1.warehousing(Jcb5.getSelectedItem().toString(),Jtf13.getText(), Jtf14.getText());
				if(flag == 0) {
					Jl21.setText("入库失败，请先完善手机信息");
				}
				else {
					Jl21.setText("入库成功");
				}
			}
			if(IOType.equals("Output")) {
				int flag = ms1.ex_warehousing(Jcb5.getSelectedItem().toString(),Jtf13.getText(), Jtf14.getText());
				if(flag == 0) {
					Jl21.setText("出库失败，未找到相关信息");
				}
				else if(flag == 1) {
					Jl21.setText("出库失败，库存不足");
				}
				else {
					Jl21.setText("出库成功");
				}
			}
		}
		if(e.getSource()==Jmi2) {
			this.disAllocateUI(true);
			Jf1.setVisible(false);
		}
		if(e.getSource()==Jb20) {
			Jf9.setVisible(false);
			Jf1.setVisible(true);
		}
		if(e.getSource()==Jrb24) {
			AllocateType = "Stock";
			Jcb6.setVisible(false);
			Jl22.setVisible(false);
		}
		if(e.getSource()==Jrb25) {
			AllocateType = "Store";
			Jcb6.setVisible(true);
			Jl22.setVisible(true);
		}
		if(e.getSource()==Jb21) {
			String str = "";
			if(AllocateType.equals("Stock")) {
				str = ms1.allocateStock("'"+Jtf15.getText()+"'");
				if(str.equals("")) {
					Jl24.setText("未查到相关信息");
				}
				else {
					Jl24.setText("库存位置为："+str);
				}
			}
			if(AllocateType.equals("Store")) {
				str = ms1.allocateStore(Jcb6.getSelectedItem().toString(), Jtf15.getText());
				if(str.equals("仓库已满，请切换仓库")) {
					Jl24.setText("仓库已满，请切换仓库");
				}
				else {
					Jl24.setText("库存位置为："+str);
				}
			}
		}
	}
	public static void main(String[] args) {
		GUI g = new GUI();
		g.disLoadUI(true);
	}
}
