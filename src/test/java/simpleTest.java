import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @description: test
 * @author: liuchq
 * @create: 2022-08-28
 **/
public class simpleTest {
    public static void main(String[] args) {
        String[] arr = new String[] { "8DA7561A77AB4D88846E2005BB0C94CB", "1661617923", "179315147" };
        Arrays.sort(arr);
        // 数组拼接字符串并且sha1加密
        byte[] bytes = DigestUtils.sha1(StringUtils.join(arr, ""));
        String tmpStr = byteToStr(bytes);
        System.out.println(tmpStr);
    }


    /**
     * 将字节数组转换为十六进制字符
     * @author: liuchq
     * @date: 2022/8/28
     * @param byteArray
     * @return: java.lang.String
     */
    public static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    /**
     * 将字节转换为十六进制字符
     * @author: liuchq
     * @date: 2022/8/28
     * @param mByte
     * @return: java.lang.String
     */
    public static String byteToHexStr(byte mByte) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];

        String s = new String(tempArr);
        return s;
    }
}
