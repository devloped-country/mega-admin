package com.mega.config.database;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisUtils {

  private static JedisPool pool;
  private static Jedis jedis;

  public static void connect() {
    try {
      pool = new JedisPool("localhost", 6379);
      jedis = pool.getResource();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static Jedis getJedis() {
    return jedis;
  }

  public static void close() {
    if(jedis != null) {
      jedis.close();
    }

    pool.close();
  }
}