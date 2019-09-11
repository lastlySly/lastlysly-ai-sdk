package com.lastlysly;

import com.lastlysly.baiduapi.face.apiresponse.DetectFaceResult;
import com.lastlysly.baiduapi.face.apiresponse.FaceDealCommonResponse;
import com.lastlysly.baiduapi.face.apiresponse.SearchFaceResult;
import com.lastlysly.baiduapi.face.utils.BaiduFaceRecognitionUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2019-09-11 17:15
 **/
public class TestDemo {
    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    /**
     * 人脸检测
     */
    public static void test1() {
        String filePath = "F:\\MyAllWorkProject\\xmgps\\百度人脸识别评估\\司机标准照片\\新建文件夹 (2)\\闽DTH132 1.jpg";
        File file = new File(filePath);
        try {
            FaceDealCommonResponse<DetectFaceResult> res = BaiduFaceRecognitionUtils.detectFace(file,null);
            System.out.println("===========11111111111111111111111=========");
            System.out.println(res.getResult().getFace_num());
            System.out.println(res.getResult().getFace_list().get(0).getAge());
            System.out.println(res.getResult().getFace_list().get(0).getFace_token());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(res);
    }

    /**
     * 人脸对比
     */
    public static void test2(){
        File file1 = new File("F:\\MyAllWorkProject\\xmgps\\百度人脸识别评估\\抓拍的车载照片\\抓拍\\闽DTH132潘新举\\闽DTH132_20180112091417_0_1_4905300.jpg");
        File file2 = new File("F:\\MyAllWorkProject\\xmgps\\百度人脸识别评估\\司机标准照片\\新建文件夹 (2)\\闽DTH132 1.jpg");
//        File file2 = new File("C:\\Users\\lastlySly\\Desktop\\test\\demo.jpeg");
        try {
            BaiduFaceRecognitionUtils.matchFace(file1,file2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 人脸搜索
     */
    public static void test3(){
        File file = new File("F:\\MyAllWorkProject\\xmgps\\百度人脸识别评估\\test2\\闽DTH132潘新举\\闽DTH132_20180112091417_0_1_4905300.jpg");
        try {
            FaceDealCommonResponse<SearchFaceResult> faceDealCommonResponse = BaiduFaceRecognitionUtils.searchFace(file,"test",null);
            System.out.println(faceDealCommonResponse.getError_msg());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
