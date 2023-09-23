package com.mega.config.database;

import java.io.InputStream;
import java.util.Properties;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisUtils {

  private static JedisPool pool;
  private static Jedis jedis;

  public static void connect() {
    Properties properties = new Properties();
    try (InputStream input = JDBCUtils.class.getClassLoader().getResourceAsStream("jedis.properties")) {
      properties.load(input);

      pool = new JedisPool(properties.getProperty("jedis.url"),
          Integer.parseInt(properties.getProperty("jedis.port")));
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