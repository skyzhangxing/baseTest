package cn.ignite.baseTest.ignite;

import java.util.Arrays;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;

public class Test {
	public static void main(String[] args) throws Exception {

		TcpDiscoverySpi spi = new TcpDiscoverySpi();
		TcpDiscoveryVmIpFinder ipFinder = new TcpDiscoveryVmIpFinder();
		// 设置预定义IP地址，注意端口或者端口范围是可选的。
		ipFinder.setAddresses(Arrays.asList("192.168.0.101:47500..47509"));
		spi.setIpFinder(ipFinder);
		IgniteConfiguration cfg = new IgniteConfiguration();
		cfg.setDiscoverySpi(spi);
		// 启动集群
		Ignite ignite = Ignition.start(cfg);

		System.out.println("start........................................................");

	}
	// Connection conn = IgniteConnect.getConnect();
	// try (Statement stmt = conn.createStatement()) {
	//
	// try (ResultSet rs = stmt
	// .executeQuery("SELECT id " + " FROM City")) {
	//
	// while (rs.next())
	// System.out.println(rs.getString(1));
	// }
	// }
	/**
	*
	 */
	// System.out.println("ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
	// TcpDiscoverySpi spi = new TcpDiscoverySpi();
	// TcpDiscoveryVmIpFinder ipFinder = new TcpDiscoveryVmIpFinder();
	// ipFinder.setAddresses(Arrays.asList("127.0.0.1:47500..47509"));
	//
	// spi.setIpFinder(ipFinder);
	// IgniteConfiguration cfg = new IgniteConfiguration();
	// cfg.setDiscoverySpi(spi);
	// cfg.setClientMode(true);
	// Ignition.setClientMode(true);
	// Ignite ignite = Ignition.start(cfg);
	//
	// CacheConfiguration ccfg = new CacheConfiguration();
	// ccfg.setName("SQL_PUBLIC_STAFF");
	// IgniteCache cache = ignite.getOrCreateCache(ccfg);
	//
	// // Creating City table.
	// cache.query(new SqlFieldsQuery("CREATE TABLE City " +
	// "(id int primary key, name varchar, region
	// varchar)").setSchema("PUBLIC")).getAll();
	//
	// cache.query(new SqlFieldsQuery(
	// "INSERT INTO City(id, name, region) VALUES(?, ?, ?)").
	// setArgs(1L, "John", "Smith"));
	// SqlFieldsQuery qry = new SqlFieldsQuery("SELECT id,name,region FROM City");
	// qry.setSchema("PUBLIC");
	// // Executing the query.
	// cache.query(qry).getAll();
	// System.out.println(cache.query(qry).getAll().toString());
	// System.out.println("ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
	// }
	// public static void main(String[] args) throws SQLException,
	// ClassNotFoundException {
	// // TODO Auto-generated method stub
	// //连接远程单节点ignite
	// Class.forName("org.apache.ignite.IgniteJdbcDriver");
	// Connection conn =
	// DriverManager.getConnection("jdbc:ignite:thin://127.0.0.1:10800");
	// PreparedStatement ps = conn.prepareStatement("select s.*,i.* from staff s
	// join internetcafe i on s.ID=i.STAFFID"
	// +" union all "
	// +"select
	// s.*,p.TrackID,p.STAFFID,concat(concat(p.TAKEOFFNAME,','),p.FALLDOWNNAME)
	// FLIGHTADD,p.FLIGHTDATE from staff s left join plane p on s.ID=p.STAFFID");
	// long t1 = System.currentTimeMillis();
	// ResultSet res=ps.executeQuery();
	// long t2 = System.currentTimeMillis();
	// long t3=t2-t1;
	// float s=(float)t3/1000;
	// System.out.println("执行时间："+s+"秒");
	// }
}
