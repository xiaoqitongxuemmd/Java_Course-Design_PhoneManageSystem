//数据库编程
package PhoneStoreManageSystem;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class Mysql {
	String JDriver = "com.mysql.cj.jdbc.Driver";
	String conURL = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	String User = "root";
	String Pass = "xiaoqitongxuemmd";
	Connection con;
	Statement s;
	PreparedStatement ps;
	DefaultTableModel dtm;
	public void init() {
		try {
			Class.forName(JDriver);
		}
		catch(java.lang.ClassNotFoundException e) {
			System.out.println("ForName:"+e.getMessage());
		}
		try {
			con = DriverManager.getConnection(conURL,User,Pass);
			s = con.createStatement();
			//创建手机信息、客户信息、用户信息、仓储信息数据库
			s.execute("create database PhoneMessage");
			s.execute("create database PersonMessage");
			s.execute("create database LoadMessage");
			s.execute("create database StoreMessage");
			//为四个数据库创建数据表以及数据项
			//切换至PhoneMessage数据库
			s.execute("use PhoneMessage");
			String query1 = "create table Apple ("
					+ "PhoneModel char(20),"
					+ "Num char(10),"
					+ "Price char(10)"
					+ ")";
			s.execute(query1);
			String query2 = "create table HuaWei ("
					+ "PhoneModel char(20),"
					+ "Num char(10),"
					+ "Price char(10)"
					+ ")";
			s.execute(query2);
			String query3 = "create table MI ("
					+ "PhoneModel char(20),"
					+ "Num char(10),"
					+ "Price char(10)"
					+ ")";
			s.execute(query3);
			//切换至PersonMessage数据库
			s.execute("use PersonMessage");
			String query4 = "create table ClientOrder ("
					+ "OrderNum char(20),"
					+ "Name char(10),"
					+ "TeleNum char(20),"
					+ "Address char(30),"
					+ "DeliveryTime char(30)"
					+ ")";
			s.execute(query4);
			String query5 = "create table FirmMessage ("
					+ "Name char(20),"
					+ "Address char(30),"
					+ "TeleNum char(20),"
					+ "Balance char(20)"
					+ ")";
			s.execute(query5);
			//切换至LoadMessage数据库
			s.execute("use LoadMessage");
			String query6 = "create table Admin ("
					+ "Id char(20),"
					+ "Pw char(20)"
					+ ")";
			s.execute(query6);
			String query7 = "create table User ("
					+ "Id char(20),"
					+ "Pw char(20)"
					+ ")";
			s.execute(query7);
			//切换至StoreMessage数据库
			s.execute("use StoreMessage");
			String query8 = "create table A ("
					+ "Num char(10),"
					+ "PhoneModel char(20)"
					+ ")";
			s.execute(query8);
			String query9 = "create table B ("
					+ "Num char(10),"
					+ "PhoneModel char(20)"
					+ ")";
			s.execute(query9);
			String query10 = "create table C ("
					+ "Num char(10),"
					+ "PhoneModel char(20)"
					+ ")";
			s.execute(query10);
			s.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException:"+e.getMessage());
		}
	}
	//查询手机信息
	public DefaultTableModel seekPhoneMessage(String Firm,String PhoneModel) {
		String[] str = {"0","0","0"};
		String[] str1 = {"手机型号","手机数量","手机价格"};
		DefaultTableModel m = new DefaultTableModel(str1,0);
		try {
			con = DriverManager.getConnection(conURL,User,Pass);
			s = con.createStatement();
			s.execute("use PhoneMessage");
			String query1 = "select * from "+Firm+" where PhoneModel = "+PhoneModel;
			ResultSet rs = s.executeQuery(query1);
			while(rs.next()) {
				str[0] = rs.getString("PhoneModel");
				str[1] = rs.getString("Num");
				str[2] = rs.getString("Price");
				m.addRow(str);
			}
			s.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.print("SQLException:"+e.getMessage());
		}
		return m;
	}
	//查询全部手机信息
	public DefaultTableModel seekPhoneMessageAll(String Firm) {
		String[] str = {"0","0","0"};
		String[] str1 = {"手机型号","手机数量","手机价格"};
		DefaultTableModel m = new DefaultTableModel(str1,0);
		try {
			con = DriverManager.getConnection(conURL,User,Pass);
			s = con.createStatement();
			s.execute("use PhoneMessage");
			String query1 = "select * from "+Firm;
			ResultSet rs = s.executeQuery(query1);
			while(rs.next()) {
				str[0] = rs.getString("PhoneModel");
				str[1] = rs.getString("Num");
				str[2] = rs.getString("Price");
				m.addRow(str);
			}
			s.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.print("SQLException:"+e.getMessage());
		}
		return m;
	}
	//通过订单号查询用户订单数据
	public DefaultTableModel seekClientOrder(String OrderNum) {
		String[] str = {"0","0","0","0","0"};
		String[] str1 = {"订单号","姓名","手机号","地址","发货时间"};
		DefaultTableModel m = new DefaultTableModel(str1,0);
		try {
			con = DriverManager.getConnection(conURL,User,Pass);
			s = con.createStatement();
			s.execute("use PersonMessage");
			String query1 = "select * from ClientOrder where OrderNum="+OrderNum;
			ResultSet rs = s.executeQuery(query1);
			while(rs.next()) {
				str[0] = rs.getString("OrderNum");
				str[1] = rs.getString("Name");
				str[2] = rs.getString("TeleNum");
				str[3] = rs.getString("Address");
				str[4] = rs.getString("DeliveryTime");
				m.addRow(str);
			}
			s.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException:"+e.getMessage());
		}
		return m;
	}
	//查询全部订单
	public DefaultTableModel seekClientOrderAll() {
		String[] str = {"0","0","0","0","0"};
		String[] str1 = {"订单号","姓名","手机号","地址","发货时间"};
		DefaultTableModel m = new DefaultTableModel(str1,0);
		try {
			con = DriverManager.getConnection(conURL,User,Pass);
			s = con.createStatement();
			s.execute("use PersonMessage");
			String query1 = "select * from ClientOrder";
			ResultSet rs = s.executeQuery(query1);
			while(rs.next()) {
				str[0] = rs.getString("OrderNum");
				str[1] = rs.getString("Name");
				str[2] = rs.getString("TeleNum");
				str[3] = rs.getString("Address");
				str[4] = rs.getString("DeliveryTime");
				m.addRow(str);
			}
			s.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException:"+e.getMessage());
		}
		return m;
	}
	//通过公司名称查询公司信息
	public DefaultTableModel seekFirmMessage(String Name) {
		String[] str = {"0","0","0","0"};
		String[] str1 = {"姓名","地址","公司电话","结余"};
		DefaultTableModel m = new DefaultTableModel(str1,0);
		try {
			con = DriverManager.getConnection(conURL,User,Pass);
			s = con.createStatement();
			s.execute("use PersonMessage");
			String query1 = "select * from FirmMessage where Name="+Name;
			ResultSet rs = s.executeQuery(query1);
			while(rs.next()) {
				str[0] = rs.getString("Name");
				str[1] = rs.getString("Address");
				str[2] = rs.getString("TeleNum");
				str[3] = rs.getString("Balance");
				m.addRow(str);
			}
			s.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException:"+e.getMessage());
		}
		return m;
	}
	//查询全部公司
	public DefaultTableModel seekFirmMessageAll() {
		String[] str = {"0","0","0","0"};
		String[] str1 = {"姓名","地址","公司电话","结余"};
		DefaultTableModel m = new DefaultTableModel(str1,0);
		try {
			con = DriverManager.getConnection(conURL,User,Pass);
			s = con.createStatement();
			s.execute("use PersonMessage");
			String query1 = "select * from FirmMessage";
			ResultSet rs = s.executeQuery(query1);
			while(rs.next()) {
				str[0] = rs.getString("Name");
				str[1] = rs.getString("Address");
				str[2] = rs.getString("TeleNum");
				str[3] = rs.getString("Balance");
				m.addRow(str);
			}
			s.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException:"+e.getMessage());
		}
		return m;
	}
	//查询仓库储存信息
	public DefaultTableModel seekStoreMessage(String Shelf,String Num) {
		String[] str = {"0","0"};
		String[] str1 = {"编号","手机型号"};
		DefaultTableModel m = new DefaultTableModel(str1,0);
		try {
			con = DriverManager.getConnection(conURL,User,Pass);
			s = con.createStatement();
			s.execute("use StoreMessage");
			String query1 = "select * from "+Shelf+" where Num="+Num;
			ResultSet rs = s.executeQuery(query1);
			while(rs.next()) {
				str[0] = rs.getString("Num");
				str[1] = rs.getString("PhoneModel");
				m.addRow(str);
			}
			s.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException:"+e.getMessage());
		}
		return m;
	}
	//查询全部仓储信息
	public DefaultTableModel seekStoreMessageAll(String Shelf) {
		String[] str = {"0","0"};
		String[] str1 = {"编号","手机型号"};
		DefaultTableModel m = new DefaultTableModel(str1,0);
		try {
			con = DriverManager.getConnection(conURL,User,Pass);
			s = con.createStatement();
			s.execute("use StoreMessage");
			String query1 = "select * from "+Shelf;
			ResultSet rs = s.executeQuery(query1);
			while(rs.next()) {
				str[0] = rs.getString("Num");
				str[1] = rs.getString("PhoneModel");
				m.addRow(str);
			}
			s.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException:"+e.getMessage());
		}
		return m;
	}
	//通过手机型号查询仓库储存位置
	public DefaultTableModel seekPhoneLocation(String PhoneModel) {
		String[] str = {"0"};
		String[] str1 = {"编号"};
		DefaultTableModel m = new DefaultTableModel(str1,0);
		try {
			con = DriverManager.getConnection(conURL,User,Pass);
			s = con.createStatement();
			s.execute("use StoreMessage");
			String query1 = "select * from A where PhoneModel="+PhoneModel;
			ResultSet rs1 = s.executeQuery(query1);
			while(rs1.next()) {
				str[0] = "A"+rs1.getString("Num");
				m.addRow(str);
			}
			String query2 = "select * from B where PhoneModel="+PhoneModel;
			ResultSet rs2 = s.executeQuery(query2);
			while(rs2.next()) {
				str[0] = "B"+rs2.getString("Num");
				m.addRow(str);
			}
			String query3 = "select * from C where PhoneModel="+PhoneModel;
			ResultSet rs3 = s.executeQuery(query3);
			while(rs3.next()) {
				str[0] = "C"+rs3.getString("Num");
				m.addRow(str);
			}
			s.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException:"+e.getMessage());
		}
		return m;
	}
	//添加手机信息
	public void addPhoneMessage(String Firm,String str) {
		try {
			con = DriverManager.getConnection(conURL,User,Pass);
			s = con.createStatement();
			s.execute("use PhoneMessage");
			String r1 = "insert into "+Firm+" values("+str+")";
			s.executeUpdate(r1);
			s.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException:"+e.getMessage());
		}
	}
	//添加订单信息
	public void addClientOrder(String str) {
		try {
			con = DriverManager.getConnection(conURL,User,Pass);
			s = con.createStatement();
			s.execute("use PersonMessage");
			String r1 = "insert into ClientOrder values("+str+")";
			s.executeUpdate(r1);
			s.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.print("SQLException:"+e.getMessage());
		}
	}
	//添加公司信息
	public void addFirmMessage(String str) {
		try {
			con = DriverManager.getConnection(conURL,User,Pass);
			s = con.createStatement();
			s.execute("use PersonMessage");
			String r1 = "insert into FirmMessage values("+str+")";
			s.executeUpdate(r1);
			s.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException:"+e.getMessage());
		}
	}
	//添加货物储存信息
	public void addStoreMessage(String Shelf,String str) {
		try {
			con = DriverManager.getConnection(conURL,User,Pass);
			s = con.createStatement();
			s.execute("use StoreMessage");
			String r1 = "insert into "+Shelf+" values("+str+")";
			s.executeUpdate(r1);
			s.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException:"+e.getMessage());
		}
	}
	//删除手机信息
	public void deletePhoneMessage(String Firm,String PhoneModel) {
		try {
			con = DriverManager.getConnection(conURL,User,Pass);
			s = con.createStatement();
			s.execute("use PhoneMessage");
			String r1 = "delete from "+Firm+" where PhoneModel="+PhoneModel;
			s.executeUpdate(r1);
			s.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException:"+e.getMessage());
		}
	}
	//删除订单信息
	public void deleteClientOrder(String OrderNum) {
		try {
			con = DriverManager.getConnection(conURL,User,Pass);
			s = con.createStatement();
			s.execute("use PersonMessage");
			String r1 = "delete from ClientOrder where OrderNum="+OrderNum;
			s.executeUpdate(r1);
			s.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException:"+e.getMessage());
		}
	}
	//删除公司信息
	public void deleteFirmMessage(String Name) {
		try {
			con = DriverManager.getConnection(conURL,User,Pass);
			s = con.createStatement();
			s.execute("use PersonMessage");
			String r1 = "delete from FirmMessage where Name="+Name;
			s.executeUpdate(r1);
			s.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException:"+e.getMessage());
		}
	}
	//删除仓储信息
	public void deleteStoreMessage(String Shelf,String Num) {
		try {
			con = DriverManager.getConnection(conURL,User,Pass);
			s = con.createStatement();
			s.execute("use StoreMessage");
			String r1 = "delete from "+Shelf+" where Num="+Num;
			s.executeUpdate(r1);
			s.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException:"+e.getMessage());
		}
	}
	//修改手机信息
	public void changePhoneMessage(String Firm,String Item,String PhoneModel,String New) {
		try {
			con = DriverManager.getConnection(conURL,User,Pass);
			s = con.createStatement();
			s.execute("use PhoneMessage");
			String r1 = "update "+Firm+" set "+Item+"="+New+" where PhoneModel="+PhoneModel;
			s.executeUpdate(r1);
			s.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException:"+e.getMessage());
		}
	}
	//修改订单数据
	public void changeClientOrder(String OrderNum,String Item,String New) {
		try {
			con = DriverManager.getConnection(conURL,User,Pass);
			s = con.createStatement();
			s.execute("use PersonMessage");
			String r1 = "update ClientOrder set "+Item+"="+New+" where OrderNum="+OrderNum;
			s.executeUpdate(r1);
			s.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException:"+e.getMessage());
		}
	}
	//修改公司数据
	public void changeFirmMessage(String Name,String Item,String New) {
		try {
			con = DriverManager.getConnection(conURL,User,Pass);
			s = con.createStatement();
			s.execute("use PersonMessage");
			String r1 = "update FirmMessage set "+Item+"="+New+" where Name="+Name;
			s.executeUpdate(r1);
			s.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException:"+e.getMessage());
		}
	}
	//修改仓储数据
	public void changeStoreMessage(String Shelf,String Num,String Item,String New) {
		try {
			con = DriverManager.getConnection(conURL,User,Pass);
			s = con.createStatement();
			s.execute("use StoreMessage");
			String r1 = "update "+Shelf+" set "+Item+"="+New+" where Num="+Num;
			s.executeUpdate(r1);
			s.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException:"+e.getMessage());
		}
	}
	//入库查重
	public int isExist(String Shelf,String Num) {
		int flag = 0;
		try {
			con = DriverManager.getConnection(conURL,User,Pass);
			s = con.createStatement();
			s.execute("use StoreMessage");
			String query = "select Num="+Num+"from "+Shelf;
			ResultSet rs = s.executeQuery(query);
			while(rs.next()) {
				if (rs.getInt("Num="+Num)==1) {
					flag = 1;
					break;
				}
			}
			s.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException:"+e.getMessage());
		}
		return flag;
	}
	//新增用户 flag==1 用户名重复未能成功创建  flag==0 成功创建
	public int addLoadMessage(String type,String Id,String Pw) {
		int flag = 0;
		try {
			con = DriverManager.getConnection(conURL,User,Pass);
			s = con.createStatement();
			s.execute("use LoadMessage");
			String query1 = "select Id from Admin";
			ResultSet rs1 = s.executeQuery(query1);
			while(rs1.next()) {
				if(rs1.getString("Id").equals(Id)) {
					flag = 1;
				}
			}
			String query2 = "select Id from User";
			ResultSet rs2 = s.executeQuery(query2);
			while(rs2.next()) {
				if(rs2.getString("Id").equals(Id)) {
					flag = 1;
					break;
				}
			}
			if(flag == 0) {
				String r1 = "insert into "+type+" values('"+Id+"','"+Pw+"')"; 
				s.executeUpdate(r1);
			}
			s.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException:"+e.getMessage());
		}
		return flag;
	}
	//注销用户
	public void deleteLoadMessage(String type,String Id) {
		try {
			con = DriverManager.getConnection(conURL,User,Pass);
			s = con.createStatement();
			s.execute("use LoadMessage");
			String r1 = "Delete from "+type+" where Id="+Id;
			s.executeUpdate(r1);
			s.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException:"+e.getMessage());
		}
	}
	//修改密码
	public void changePw(String type,String Id,String Pw) {
		try {
			con = DriverManager.getConnection(conURL,User,Pass);
			s = con.createStatement();
			s.execute("use LoadMessage");
			String r1 = "Update "+type+" set Pw="+Pw+" where Id="+Id;
			s.executeUpdate(r1);
			s.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException:"+e.getMessage());
		}
	}
	//用户名与密码匹配函数 flag==0 用户不存在 flag==1 密码不正确 flag==2 登录成功
	public int isMatch(String Id,String Pw) {
		int flag = 0;
		try {
			con = DriverManager.getConnection(conURL,User,Pass);
			s = con.createStatement();
			s.execute("use LoadMessage");
			String query1 = "select Id = '"+Id+"' from Admin";
			ResultSet rs1 = s.executeQuery(query1);
			while(rs1.next()) {
				if(rs1.getInt("id = '"+Id+"'")==1) {
					flag = 1;
					String query2 = "select Pw from Admin where Id = '"+Id+"'";
					ResultSet rs2 = s.executeQuery(query2);
					while(rs2.next()) {
						if(rs2.getString("Pw").equals(Pw)) {
							flag = 2;
							break;
						}
					}
					break;
				}
			}
			if(flag == 0) {
				String query3 = "select Id = '"+Id+"' from User";
				ResultSet rs3 = s.executeQuery(query3);
				while(rs3.next()) {
					if(rs3.getInt("id = '"+Id+"'")==1) {
						flag = 1;
						String query4 = "select Pw from User where Id = '"+Id+"'";
						ResultSet rs4 = s.executeQuery(query4);
						while(rs4.next()) {
							if(rs4.getString("Pw").equals(Pw)) {
								flag = 2;
								break;
							}
						}
						break;
					}
				}
			}
			s.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException:"+e.getMessage());
		}
		return flag;
	}
	public static void main(String[] args) {
		Mysql m = new Mysql();
		//m.init();
	}
}
