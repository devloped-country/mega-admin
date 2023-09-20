package com.mega.common.encrypt.sha256;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {
  public static String hash(String input) {
    try {
      // MessageDigest 인스턴스 생성 (SHA-256 선택)
      MessageDigest digest = MessageDigest.getInstance("SHA-256");

      // 입력 데이터를 바이트 배열로 변환
      byte[] encodedhash = digest.digest(input.getBytes(StandardCharsets.UTF_8));

      // 바이트 배열을 16진수 문자열로 변환
      StringBuilder hexString = new StringBuilder(2 * encodedhash.length);
      for (byte b : encodedhash) {
        String hex = Integer.toHexString(0xff & b);
        if (hex.length() == 1) {
          hexString.append('0');
        }
        hexString.append(hex);
      }

      // 16진수 해시값 반환
      return hexString.toString();
    } catch (NoSuchAlgorithmException e) {
      // 알고리즘을 찾지 못한 경우 처리
      e.printStackTrace();
      return null;
    }
  }
}
