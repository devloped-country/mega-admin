package com.mega.biz.qr.model;

import com.mega.config.database.JedisUtils;

public class QrDAO {

  private final static String QR_KEY = "qr";
  private final static int QR_EXPIRED = 3000;

  public void insertQr(String hash) {
    JedisUtils.connect();
    JedisUtils.getJedis().set(QR_KEY, hash);
    JedisUtils.getJedis().expire(QR_KEY, QR_EXPIRED);
    JedisUtils.close();
  }
}
