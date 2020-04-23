package cn.ignite.baseTest.ignite;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;

public class IgniteGetPut {
	public static void main(String[] args) {
		try (Ignite ignite = Ignition.start("examples/config/example-cache.xml")) {
			IgniteCache<Integer, String> cache = ignite.getOrCreateCache("myCacheName");

			// Store keys in cache (values will end up on different cache nodes).
			// example-ignite example-cache
			long startPutTime = System.currentTimeMillis();

			for (int i = 0; i < 1000000; i++) {
				cache.put(i, Integer.toString(i));
			}
			long endPutTime = System.currentTimeMillis();
			System.out.println("putTime:" + (endPutTime - startPutTime) + "ms");

			long startGetTime = System.currentTimeMillis();

			for (int i = 0; i < 1000000; i++) {
				cache.get(i);
				// System.out.println("Got [key=" + i + ", val=" + cache.get(i) + ']');
			}

			long endGetTime = System.currentTimeMillis();
			System.out.println("getTime:" + (endGetTime - startGetTime) + "ms");
		}
	}

}
