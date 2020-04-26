package cn.ignite.baseTest.ignite;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
	public static void main(String[] args) throws Exception {
		Connection conn = IgniteConnect.getConnect();
		try (Statement stmt = conn.createStatement()) {

			try (ResultSet rs = stmt
					.executeQuery("SELECT id " + " FROM City")) {

				while (rs.next())
					System.out.println(rs.getString(1));
			}
		}
	}
//	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//	    // TODO Auto-generated method stub
//	    //连接远程单节点ignite
//	    Class.forName("org.apache.ignite.IgniteJdbcDriver");
//	    Connection conn = DriverManager.getConnection("jdbc:ignite:thin://127.0.0.1:10800");        
//	    PreparedStatement ps = conn.prepareStatement("select s.*,i.* from staff s join internetcafe i on s.ID=i.STAFFID"
//	            +" union all "
//	            +"select s.*,p.TrackID,p.STAFFID,concat(concat(p.TAKEOFFNAME,','),p.FALLDOWNNAME) FLIGHTADD,p.FLIGHTDATE from staff s left join plane p on s.ID=p.STAFFID");
//	    long t1 = System.currentTimeMillis();
//	    ResultSet res=ps.executeQuery();
//	    long t2 = System.currentTimeMillis();
//	    long t3=t2-t1;
//	    float s=(float)t3/1000;
//	    System.out.println("执行时间："+s+"秒");
//	}
}
