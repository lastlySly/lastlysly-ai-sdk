package com.lastlysly.baiduapi.face.utils;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.face.MatchRequest;
import com.baidu.aip.util.Base64Util;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lastlysly.baiduapi.face.apirequest.FaceOptionsParamEntity;
import com.lastlysly.baiduapi.face.apiresponse.DetectFaceResult;
import com.lastlysly.baiduapi.face.apiresponse.FaceDealCommonResponse;
import com.lastlysly.baiduapi.face.apiresponse.MatchFaceResult;
import com.lastlysly.baiduapi.face.apiresponse.SearchFaceResult;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2019-09-11 10:40
 * 百度人脸识别工具类
 **/
public class BaiduFaceRecognitionUtils {


    //private static final BASE64Decoder decoder = new BASE64Decoder();
    //需要修改为自己的
    private static final String AppID = "*****";
    private static final String APIKey = "*******";
    private static final String SecretKey = "*******";

    private static ObjectMapper objectMapper = new ObjectMapper();

    private static Logger logger = LoggerFactory.getLogger(BaiduFaceRecognitionUtils.class);


    static AipFace client = null;
    static {
        client = new AipFace(AppID, APIKey, SecretKey);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
    }


    /**
     * 人脸检测
     * @param file
     * @param faceOptionsParamEntity
     * @return
     * @throws IOException
     */
    public static FaceDealCommonResponse<DetectFaceResult> detectFace(File file, FaceOptionsParamEntity faceOptionsParamEntity) throws IOException {
        return detectFace(FileToByte(file), faceOptionsParamEntity);
    }

    /**
     * 人脸检测
     * @param fileByte
     * @param faceOptionsParamEntity
     * @return
     * @throws IOException
     */
    public static FaceDealCommonResponse<DetectFaceResult> detectFace(byte[] fileByte, FaceOptionsParamEntity faceOptionsParamEntity) throws IOException {
        HashMap<String, String> options = new HashMap<String, String>();
        if (faceOptionsParamEntity != null){
            if (StringUtils.isNotBlank(faceOptionsParamEntity.getMax_face_num())){
                options.put("max_face_num", faceOptionsParamEntity.getMax_face_num());
            }
            if (!StringUtils.isNotBlank(faceOptionsParamEntity.getFace_field())){
//               options.put("face_field",
//                                 "age,beauty,expression,face_shape,gender,glasses,landmark,landmark72,landmark150,race,quality,eye_status,emotion,face_type");
                options.put("face_field",faceOptionsParamEntity.getFace_field());
            }
            if (StringUtils.isNotBlank(faceOptionsParamEntity.getFace_type())){
                options.put("face_type",faceOptionsParamEntity.getFace_type());
            }
            if (StringUtils.isNotBlank(faceOptionsParamEntity.getLiveness_control())){
                options.put("liveness_control",faceOptionsParamEntity.getLiveness_control());
            }
        }
        /**
         * 图片数据
         */
        String imgStr = Base64Util.encode(fileByte);
        String imageType = "BASE64";
        JSONObject res = client.detect(imgStr, imageType, options);
        /**
         * 反序列化泛型，显式构建
         */
        FaceDealCommonResponse<DetectFaceResult> faceDealCommonResponse =
                objectMapper.readValue(res.toString(),new TypeReference<FaceDealCommonResponse<DetectFaceResult>>(){});
        logger.info("========人脸检测 start==========");
        logger.info(faceDealCommonResponse.getError_msg());
        logger.info("========人脸检测 end==========");
        return faceDealCommonResponse;
    }



    /**
     * 人脸比对
     *
     * @param file1
     * @param file2
     * @return
     */
    public static FaceDealCommonResponse<MatchFaceResult> matchFace(File file1, File file2) throws IOException {
        return matchFace(FileToByte(file1), FileToByte(file2));
    }

    /**
     * 人脸对比
     *
     * @param arg0
     *            人脸1
     * @param arg1
     *            人脸2
     * @return
     */
    public static FaceDealCommonResponse<MatchFaceResult> matchFace(byte[] arg0, byte[] arg1) throws IOException {
        String imgStr1 = Base64Util.encode(arg0);
        String imgStr2 = Base64Util.encode(arg1);
        MatchRequest req1 = new MatchRequest(imgStr1, "BASE64");
        MatchRequest req2 = new MatchRequest(imgStr2, "BASE64");
        ArrayList<MatchRequest> requests = new ArrayList<MatchRequest>();
        requests.add(req1);
        requests.add(req2);
        JSONObject res = client.match(requests);
        /**
         * 反序列化泛型，显式构建
         */
        FaceDealCommonResponse<MatchFaceResult> faceDealCommonResponse =
                objectMapper.readValue(res.toString(),new TypeReference<FaceDealCommonResponse<MatchFaceResult>>(){});
        logger.info("========人脸对比 start==========");
        logger.info(faceDealCommonResponse.getError_msg());
        logger.info("========人脸对比 end==========");
        return faceDealCommonResponse;
    }





    /**
     *
     * 人脸搜索(userId 传null 为 1：N人脸搜索)
     *      1：N人脸搜索：也称为1：N识别，在指定人脸集合中，找到最相似的人脸；
     *      1：N人脸认证：基于uid维度的1：N识别，由于uid已经锁定固定数量的人脸，所以检索范围更聚焦；
     * @param file
     * @param groupIdList
     * @param faceOptionsParamEntity
     * @return
     * @throws IOException
     */
    public static FaceDealCommonResponse<SearchFaceResult> searchFace(File file, String groupIdList,
                                                                      FaceOptionsParamEntity faceOptionsParamEntity) throws IOException {

        return searchFace(FileToByte(file), groupIdList,faceOptionsParamEntity);
    }

    /**
     *
     * 人脸搜索(userId 传null 为 1：N人脸搜索)
     *      1：N人脸搜索：也称为1：N识别，在指定人脸集合中，找到最相似的人脸；
     *      1：N人脸认证：基于uid维度的1：N识别，由于uid已经锁定固定数量的人脸，所以检索范围更聚焦；
     * @param arg0
     * @param groupIdList
     * @param faceOptionsParamEntity
     * @return
     * @throws IOException
     */
    public static FaceDealCommonResponse<SearchFaceResult> searchFace(byte[] arg0, String groupIdList,
                                                                      FaceOptionsParamEntity faceOptionsParamEntity)
            throws IOException {

        String imgStr = Base64Util.encode(arg0);
        String imageType = "BASE64";
        HashMap<String, String> options = new HashMap<String, String>();
        if (faceOptionsParamEntity != null){
            /**
             * 当需要对特定用户进行比对时，指定user_id进行比对。即人脸认证功能。
             */
            if (StringUtils.isNotBlank(faceOptionsParamEntity.getUser_id())) {
                options.put("user_id", faceOptionsParamEntity.getUser_id());
            }
            /**
             * 最多处理人脸的数目
             * 默认值为1(仅检测图片中面积最大的那个人脸) 最大值10
             */
            if (StringUtils.isNotBlank(faceOptionsParamEntity.getMax_face_num())) {
                options.put("max_face_num", faceOptionsParamEntity.getMax_face_num());
            }
            /**
             * 查找后返回的用户数量。返回相似度最高的几个用户，默认为1，最多返回50个。
             */
            if (StringUtils.isNotBlank(faceOptionsParamEntity.getMax_user_num())) {
                options.put("max_user_num", faceOptionsParamEntity.getMax_user_num());
            }

            if (StringUtils.isNotBlank(faceOptionsParamEntity.getLiveness_control())) {
                options.put("liveness_control", faceOptionsParamEntity.getLiveness_control());
            }

            if (StringUtils.isNotBlank(faceOptionsParamEntity.getQuality_control())) {
                options.put("quality_control", faceOptionsParamEntity.getQuality_control());
            }

            if (StringUtils.isNotBlank(faceOptionsParamEntity.getMatch_threshold())) {
                options.put("match_threshold", faceOptionsParamEntity.getMatch_threshold());
            }
        }

        JSONObject res = client.search(imgStr, imageType, groupIdList, options);
        /**
         * 反序列化泛型，显式构建
         */
        FaceDealCommonResponse<SearchFaceResult> faceDealCommonResponse = objectMapper.readValue(res.toString(),
                new TypeReference<FaceDealCommonResponse<SearchFaceResult>>(){});

        logger.info("========人脸搜索 start==========");
        logger.info(faceDealCommonResponse.getError_msg());
        logger.info("========人脸搜索 end==========");

        return faceDealCommonResponse;
    }


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
