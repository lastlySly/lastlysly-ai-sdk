package com.lastlysly.utils;

import java.io.*;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2019-09-12 08:29
 **/
public class CustomFileUtils {


    /**
     * 文件转字节
     * @param file
     * @return
     * @throws IOException
     */
    public static byte[] FileToByte(File file) throws IOException {
        // 将数据转为流
        @SuppressWarnings("resource")
        InputStream content = new FileInputStream(file);
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        while ((rc = content.read(buff, 0, 100)) > 0) {
            swapStream.write(buff, 0, rc);
        }
        // 获得二进制数组
        return swapStream.toByteArray();
    }

}
