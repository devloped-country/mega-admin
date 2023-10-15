package com.mega.config.database;

import java.io.InputStream;
import java.util.Properties;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtils {

  private static JedisPool pool;
  private static Jedis jedis;

  public static void connect() {
    Properties properties = new Properties();
    try (InputStream input = JDBCUtils.class.getClassLoader().getResourceAsStream("jedis.properties")) {
      properties.load(input);

//      pool = new JedisPool(jedisPoolConfig, properties.getProperty("jedis.url"),
//          Integer.parseInt(properties.getProperty("jedis.port")));
      JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
      pool = new JedisPool(jedisPoolConfig,"52.78.213.19", 6379, 3000, "mega");

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