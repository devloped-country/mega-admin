package com.mega.common.qr;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class QRUtils {

    public static byte[] createQr(String url, int size, String type) throws WriterException, IOException {
      BitMatrix matrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, size, size);

      try (ByteArrayOutputStream out = new ByteArrayOutputStream();) {
        MatrixToImageWriter.writeToStream(matrix, type, out);
        return out.toByteArray();
      }
    }
}
