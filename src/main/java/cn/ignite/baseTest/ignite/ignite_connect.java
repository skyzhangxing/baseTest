package cn.ignite.baseTest.ignite;

import java.util.Arrays;
import java.util.List;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;

public class ignite_connect { /** Dummy cache name. */
    private static final String DUMMY_CACHE = "dummy_cache";

    /**
     * Executes example.
     *
     * @param args Command line arguments, none required.
     * @throws Exception If example execution failed.
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

   
            print("Cache query DDL example started.");
            
            
            TcpDiscoverySpi spi = new TcpDiscoverySpi();
    		TcpDiscoveryVmIpFinder ipFinder = new TcpDiscoveryVmIpFinder();
    		// 设置预定义IP地址，注意端口或者端口范围是可选的。
    		ipFinder.setAddresses(Arrays.asList("127.0.0.1:47500..47503"));
    		spi.setIpFinder(ipFinder);
    		IgniteConfiguration cfg = new IgniteConfiguration();
    		cfg.setDiscoverySpi(spi);
    		cfg.setClientMode(true);
    		Ignition.setClientMode(true);
    		// 启动集群
    		Ignite ignite = Ignition.start(cfg);
    		System.out.println("ignite node start........................................................");
            // Create dummy cache to act as an entry point for SQL queries (new SQL API which do not require this
            // will appear in future versions, JDBC and ODBC drivers do not require it already).
            CacheConfiguration<?, ?> cacheCfg = new CacheConfiguration<>(DUMMY_CACHE).setSqlSchema("PUBLIC");

            try (
                IgniteCache<?, ?> cache = ignite.getOrCreateCache(cacheCfg)
            ) {
            	List<List<?>> res = cache.query(new SqlFieldsQuery(
                        "SELECT c.id, c.name FROM City c")).getAll();

                print("Query results:");

                for (Object next : res)
                    System.out.println(">>>    " + next);
               // cache.query(new SqlFieldsQuery("drop table Person")).getAll();
               // cache.query(new SqlFieldsQuery("drop table City")).getAll();

                //print("Dropped database objects.");
            }
            finally {
                // Distributed cache can be removed from cluster only by #destroyCache() call.
                //ignite.destroyCache(DUMMY_CACHE);
            }

            print("Cache query DDL example finished.");
        }


    /**
     * Prints message.
     *
     * @param msg Message to print before all objects are printed.
     */
    private static void print(String msg) {
        System.out.println();
        System.out.println(">>> " + msg);
    }

}
