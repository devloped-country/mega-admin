package com.mega.config.database;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisUtils {
  private static JedisPool pool;
  private static Jedis jedis;

  public static void connect() {
    try {
      pool = new JedisPool("mega.6abnjx.clustercfg.apn2.cache.amazonaws.com", 6379);
      jedis = pool.getResource();
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
