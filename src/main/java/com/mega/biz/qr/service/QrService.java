package com.mega.biz.qr.service;

import com.google.zxing.WriterException;
import com.mega.biz.qr.model.QrDAO;
import com.mega.common.qr.QRUtils;
import com.mega.common.sha256.SHA256;
import java.io.IOException;
import java.util.Objects;

public class QrService {

  private final static int RANDOM_DIGIT = 1000000;
  private final static String QR_URL = "http://localhost:8080/qr/auth?qr=";
  private final static int QR_SIZE = 400;
  private final QrDAO dao = new QrDAO();

  public byte[] createQr() throws WriterException, IOException {

    String hash = SHA256.hash(String.valueOf((int) (Math.random() * RANDOM_DIGIT)));
    String url = QR_URL.concat(Objects.requireNonNull(hash));
    byte[] qrBytes = QRUtils.createQr(url, QR_SIZE, "PNG");

    dao.insertQr(hash);

    return qrBytes;
  }
}
