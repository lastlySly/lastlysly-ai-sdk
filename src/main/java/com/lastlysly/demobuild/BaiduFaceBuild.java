package com.lastlysly.demobuild;

import com.lastlysly.baiduapi.face.utils.BaiduFaceRecognitionUtils;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2019-09-12 10:20
 *
 * 百度人脸识别工具构建 参考。可设置为单例模式。
 *
 **/
public class BaiduFaceBuild {

    //private static final BASE64Decoder decoder = new BASE64Decoder();
    //需要修改为自己的
    private static final String AppID = "*******";
    private static final String APIKey = "******************";
    private static final String SecretKey = "******************";


    public static BaiduFaceRecognitionUtils getBaiduFaceRecognitionUtils(){
        return new BaiduFaceRecognitionUtils(AppID,APIKey,SecretKey);
    }

}
