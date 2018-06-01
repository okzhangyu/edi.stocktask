package org.edi.stocktask.util;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;



public class MD5Util {
    /**
     * MAC�㷨��ѡ���¶����㷨
     *
     * <pre>
     * HmacMD5
     * HmacSHA1
     * HmacSHA256
     * HmacSHA384
     * HmacSHA512
     * </pre>
     */
    public static final String KEY_MAC = "HmacMD5";


    public static byte[] encryptHMAC(byte[] data, String key) throws Exception {

        SecretKey secretKey = new SecretKeySpec(key.getBytes(),KEY_MAC);
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        mac.init(secretKey);

        return mac.doFinal(data);

    }


    public static String byteArrayToHexString(byte[] b) {
       StringBuffer sb = new StringBuffer(b.length * 2);
       for (int i = 0; i < b.length; i++) {
         int v = b[i] & 0xff;
         if (v < 16) {
           sb.append('0');
         }
         sb.append(Integer.toHexString(v));
       }
       return sb.toString();
     }

}