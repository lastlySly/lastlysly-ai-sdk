package com.lastlysly;

import com.lastlysly.baiduapi.face.apiresponse.*;
import com.lastlysly.demobuild.BaiduFaceBuild;

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
//        test3();
//        test4();
//        test5();
//        test6();
//        test7();
//        test8();
//        test9();
//        test10();
//        test11();
//        test12();
        test13();
    }

    /**
     * 人脸检测
     */
    public static void test1() {
        String filePath = "F:\\MyAllWorkProject\\xmgps\\百度人脸识别评估\\司机标准照片\\新建文件夹 (2)\\闽DTH132 1.jpg";
        File file = new File(filePath);
        try {
            FaceDealCommonResponse<DetectFaceResult> res = BaiduFaceBuild.getBaiduFaceRecognitionUtils().detectFace(file,null);
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
//        File file2 = new File("C:\\Users\\lastlySly\\Desktop\\test\\demobuild.jpeg");
        try {
            BaiduFaceBuild.getBaiduFaceRecognitionUtils().matchFace(file1,file2);
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
            FaceDealCommonResponse<SearchFaceResult> faceDealCommonResponse = BaiduFaceBuild.getBaiduFaceRecognitionUtils().searchFace(file,"test",null);
            System.out.println(faceDealCommonResponse.getError_msg());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 注册人脸
     */
    public static void test4(){
//        File file = new File("F:\\MyAllWorkProject\\xmgps\\百度人脸识别评估\\抓拍的车载照片\\抓拍\\闽DTH132潘新举\\闽DTH132_20180112091417_0_1_4905300.jpg");
        File file = new File("F:\\MyAllWorkProject\\xmgps\\百度人脸识别评估\\抓拍的车载照片\\抓拍\\闽DTH517(10CD00007C159D20)\\闽DTH517_20180112091419_0_1_4905308.jpg");
        try {
            FaceDealCommonResponse<AddOrUpdateFaceResult> faceDealCommonResponse = BaiduFaceBuild.getBaiduFaceRecognitionUtils().addUser(file,"1","test",null);
            System.out.println(faceDealCommonResponse.getError_msg());
            System.out.println(faceDealCommonResponse.getResult().getLocation());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 人脸更新
     */
    public static void test5(){
        File file = new File("F:\\MyAllWorkProject\\xmgps\\百度人脸识别评估\\抓拍的车载照片\\抓拍\\闽DTH172申新龙\\闽DTH172_20180112091419_0_1_4905341.jpg");
        try {
            FaceDealCommonResponse<AddOrUpdateFaceResult> faceDealCommonResponse = BaiduFaceBuild.getBaiduFaceRecognitionUtils().updateUser(file,"1","test",null);
            System.out.println(faceDealCommonResponse.getError_msg());
            System.out.println(faceDealCommonResponse.getResult().getLocation());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 人脸删除
     */
    public static void test6() {
        try {
            FaceDealNullResultResponse res = BaiduFaceBuild.getBaiduFaceRecognitionUtils().deleteUserFace("2d0f50601ac644b382233cfdf8e549ac","test2","371c8d479dd990dc8863baaa49d63491");
            System.out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 用户信息查询
     */
    public static void test7() {
        FaceDealCommonResponse<GetUserResult> res = null;
        try {
            res = BaiduFaceBuild.getBaiduFaceRecognitionUtils().getUserInfo("1","test");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(res);

    }

    /**
     * 获取用户人脸列表
     */
    public static void test8() {
        try {
            FaceDealCommonResponse<FaceGetlistResult> res = BaiduFaceBuild.getBaiduFaceRecognitionUtils()
                    .getUserFaceList("1","test");
            System.out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * 获取用户列表
     */
    public static void test9() {
        try {
            FaceDealCommonResponse<GroupUsersListResult> res = BaiduFaceBuild.getBaiduFaceRecognitionUtils()
                    .getGroupUsers("test","0","20");
            System.out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 复制用户
     */
    public static void test10() {

        FaceDealNullResultResponse res = null;
        try {
            res = BaiduFaceBuild.getBaiduFaceRecognitionUtils()
                    .userCopy("2d0f50601ac644b382233cfdf8e549ac","test","test2");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(res);
    }

    /**
     * 删除用户
     */
    public static void test11() {

        FaceDealNullResultResponse res = null;
        try {
            res = BaiduFaceBuild.getBaiduFaceRecognitionUtils()
                    .deleteUser("2d0f50601ac644b382233cfdf8e549ac","test2");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(res);
    }

    /**
     * 创建用户组
     */
    public static void test12() {

        FaceDealNullResultResponse res = null;
        try {
            res = BaiduFaceBuild.getBaiduFaceRecognitionUtils()
                    .addGroup("test3");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(res);
    }

    /**
     * 删除用户组
     */
    public static void test13() {

        FaceDealNullResultResponse res = null;
        try {
            res = BaiduFaceBuild.getBaiduFaceRecognitionUtils()
                    .deleteGroup("test3");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(res);
    }


}
