package com.demo.redis;

import org.apache.log4j.Logger;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisJava {

	private static final Logger logger = Logger.getLogger(RedisJava.class);

	@Test
	public void r() {

		JedisPoolConfig config = new JedisPoolConfig();
		// 配置最大jedis实例数
		config.setMaxTotal(1);
		// 配置资源池最大闲置数
		config.setMaxIdle(200);
		// 等待可用连接的最大时间
		config.setMaxWaitMillis(1000);
		// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的
		config.setTestOnBorrow(true);

		String host = "localhost";

		int port = 6379;

		/*JedisPool pool = new JedisPool(config, host, port);

		for (int i = 0; i < 0; i++) {
			Jedis jedis = null;
			try {
				jedis = pool.getResource();
				// / ... do stuff here ... for example
				jedis.set("foo", "bar");
				String foobar = jedis.get("foo");

				logger.debug(foobar + i);
			} finally {
				// You have to close jedis object. If you don't close then
				// it doesn't release back to pool and you can't get a new
				// resource from pool.
				if (jedis != null) {
					jedis.close();
				}
			}
		}

		pool.close();*/

	}

	@Test
	public void t2() {

		final String key = "ff";

		final Jedis j = new Jedis("localhost", 6379,1000000000);

		boolean b=true;
		logger.debug("start");
		if(b)
		
		for (int i = 0; i < 20; i++) {

			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					logger.debug("22");
					String s = j.get(key);

					logger.debug(Thread.currentThread().getName()+":" + s);
					
				}

			}).start();

		}

		
		logger.debug("end");
		
		//String s = j.get(key);

		//logger.debug(Thread.currentThread().getName()+":"+s);
		
		/*try {
			Thread.sleep(10000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		
	}

}
