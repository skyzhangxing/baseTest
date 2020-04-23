package cn.ignite.baseTest.ignite;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;

public class Threads {
	public static void main(String[] args) throws Exception {
		Ignite ignite = Ignition.start("examples/config/example-cache.xml");
		IgniteCache<Integer, String> cache = ignite.getOrCreateCache("myCacheName");

		Thread t1 = new Thread(() -> {
			System.out.println("t1:start new thread!");
			long startPutTime = System.currentTimeMillis();

			for (int i = 0; i < 1000000; i++) {
				cache.put(i, Integer.toString(i));
				//System.out.println(i);
			}
			long endPutTime = System.currentTimeMillis();
			System.out.println("putTime:" + (endPutTime - startPutTime) + "ms");
		});
	

		Thread t2 = new Thread(() -> {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("t2:start new thread!");
			long startGetTime = System.currentTimeMillis();

			for (int i = 0; i < 1000000; i++) {
				cache.get(i);
				// System.out.println("Got [key=" + i + ", val=" + cache.get(i) + ']');
				//System.out.println(cache.get(i));
				if(i>999900) {
					System.out.println(cache.get(i));
				}
			}
			long endGetTime = System.currentTimeMillis();
			System.out.println("getTime:" + (endGetTime - startGetTime) + "ms");
		});
		t1.start();
		t2.start();
	}
}