package com.lastlysly.baiduapi.face.utils;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.face.MatchRequest;
import com.baidu.aip.util.Base64Util;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.lastlysly.baiduapi.face.apirequest.FaceOptionsParamEntity;
import com.lastlysly.baiduapi.face.apiresponse.*;
import com.lastlysly.utils.CustomFileUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2019-09-11 10:40
 * 百度人脸识别工具类
 **/
public class BaiduFaceRecognitionUtils {


    //private static final BASE64Decoder decoder = new BASE64Decoder();
    //需要修改为自己的
//    private static final String AppID = "*****";
//    private static final String APIKey = "*******";
//    private static final String SecretKey = "*******";

    private static ObjectMapper objectMapper = new ObjectMapper();

    private static Logger logger = LoggerFactory.getLogger(BaiduFaceRecognitionUtils.class);

    static AipFace client = null;
//    static {
//        client = new AipFace(AppID, APIKey, SecretKey);
//        // 可选：设置网络连接参数
//        client.setConnectionTimeoutInMillis(2000);
//        client.setSocketTimeoutInMillis(60000);
//    }

    public BaiduFaceRecognitionUtils(String AppID, String APIKey, String SecretKey){
//        if (client == null){
        client = new AipFace(AppID, APIKey, SecretKey);
//        }
    }
    public BaiduFaceRecognitionUtils(String AppID, String APIKey, String SecretKey,
                                     int connectionTimeoutInMillis,int socketTimeoutInMillis){
        client = new AipFace(AppID, APIKey, SecretKey);

        client.setConnectionTimeoutInMillis(connectionTimeoutInMillis);
        client.setSocketTimeoutInMillis(socketTimeoutInMillis);
        // 可选：设置网络连接参数
        //  client.setConnectionTimeoutInMillis(2000);
        //  client.setSocketTimeoutInMillis(60000);
    }

    /**
     * 人脸检测
     * @param file
     * @param faceOptionsParamEntity
     * @return
     * @throws IOException
     */
    public FaceDealCommonResponse<DetectFaceResult> detectFace(File file, FaceOptionsParamEntity faceOptionsParamEntity) throws IOException {
        return detectFace(CustomFileUtils.FileToByte(file), faceOptionsParamEntity);
    }

    /**
     * 人脸检测
     * @param fileByte
     * @param faceOptionsParamEntity
     * @return
     * @throws IOException
     */
    public FaceDealCommonResponse<DetectFaceResult> detectFace(byte[] fileByte, FaceOptionsParamEntity faceOptionsParamEntity) throws IOException {
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
    public FaceDealCommonResponse<MatchFaceResult> matchFace(File file1, File file2) throws IOException {
        return matchFace(CustomFileUtils.FileToByte(file1), CustomFileUtils.FileToByte(file2));
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
    public FaceDealCommonResponse<MatchFaceResult> matchFace(byte[] arg0, byte[] arg1) throws IOException {
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
    public FaceDealCommonResponse<SearchFaceResult> searchFace(File file, String groupIdList,
                                                                      FaceOptionsParamEntity faceOptionsParamEntity) throws IOException {

        return searchFace(CustomFileUtils.FileToByte(file), groupIdList,faceOptionsParamEntity);
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
    public FaceDealCommonResponse<SearchFaceResult> searchFace(byte[] arg0, String groupIdList,
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
     * 人脸注册
     * @param file
     * @param userId
     * @param groupId
     * @param faceOptionsParamEntity
     * @return
     * @throws IOException
     */
    public FaceDealCommonResponse<AddOrUpdateFaceResult> addUser(File file, String userId,
                                             String groupId,FaceOptionsParamEntity faceOptionsParamEntity) throws IOException {

        return addUser(CustomFileUtils.FileToByte(file), userId, groupId,faceOptionsParamEntity);
    }

    /**
     * 人脸注册
     * @param arg0
     * @param userId
     * @param groupId
     * @param faceOptionsParamEntity
     * @return
     * @throws IOException
     */
    public FaceDealCommonResponse<AddOrUpdateFaceResult> addUser(byte[] arg0, String userId,
                                             String groupId,FaceOptionsParamEntity faceOptionsParamEntity)
            throws IOException {
        String imgStr = Base64Util.encode(arg0);
        String imageType = "BASE64";
        HashMap<String, String> options = new HashMap<String, String>();
        if (faceOptionsParamEntity != null){
            if (StringUtils.isNotBlank(faceOptionsParamEntity.getLiveness_control())) {
                options.put("liveness_control", faceOptionsParamEntity.getLiveness_control());
            }
            if (StringUtils.isNotBlank(faceOptionsParamEntity.getAction_type())) {
                options.put("action_type", faceOptionsParamEntity.getAction_type());
            }
            if (StringUtils.isNotBlank(faceOptionsParamEntity.getQuality_control())) {
                options.put("quality_control", faceOptionsParamEntity.getQuality_control());
            }
            if (StringUtils.isNotBlank(faceOptionsParamEntity.getUser_info())) {
                options.put("user_info", faceOptionsParamEntity.getUser_info());
            }
        }
        JSONObject res = client.addUser(imgStr, imageType, groupId, userId,options);
        System.out.println(res.toString(2));
        /**
         * 反序列化泛型，显式构建
         */
        FaceDealCommonResponse<AddOrUpdateFaceResult> faceDealCommonResponse = objectMapper.readValue(res.toString(),
                new TypeReference<FaceDealCommonResponse<AddOrUpdateFaceResult>>(){});

        logger.info("========人脸注册 start==========");
        logger.info(faceDealCommonResponse.getError_msg());
        logger.info("========人脸注册 end==========");
        return faceDealCommonResponse;
    }


    /**
     * 人脸更新
     * @param file
     * @param userId
     * @param groupId
     * @param faceOptionsParamEntity
     * @return
     * @throws IOException
     */
    public FaceDealCommonResponse<AddOrUpdateFaceResult> updateUser(File file, String userId,
                                                                 String groupId,FaceOptionsParamEntity faceOptionsParamEntity) throws IOException {

        return updateUser(CustomFileUtils.FileToByte(file), userId, groupId,faceOptionsParamEntity);
    }

    /**
     * 人脸更新
     * @param arg0
     * @param userId
     * @param groupId
     * @param faceOptionsParamEntity
     * @return
     * @throws IOException
     */
    public FaceDealCommonResponse<AddOrUpdateFaceResult> updateUser(byte[] arg0, String userId,
                                                                 String groupId,FaceOptionsParamEntity faceOptionsParamEntity)
            throws IOException {
        String imgStr = Base64Util.encode(arg0);
        String imageType = "BASE64";
        HashMap<String, String> options = new HashMap<String, String>();
        if (faceOptionsParamEntity != null){
            if (StringUtils.isNotBlank(faceOptionsParamEntity.getLiveness_control())) {
                options.put("liveness_control", faceOptionsParamEntity.getLiveness_control());
            }
            if (StringUtils.isNotBlank(faceOptionsParamEntity.getUser_info())) {
                options.put("user_info", faceOptionsParamEntity.getUser_info());
            }
            if (StringUtils.isNotBlank(faceOptionsParamEntity.getQuality_control())) {
                options.put("quality_control", faceOptionsParamEntity.getQuality_control());
            }
            if (StringUtils.isNotBlank(faceOptionsParamEntity.getAction_type())) {
                options.put("action_type", faceOptionsParamEntity.getAction_type());
            }

        }
        JSONObject res = client.updateUser(imgStr, imageType, groupId, userId,options);
        /**
         * 反序列化泛型，显式构建
         */
        FaceDealCommonResponse<AddOrUpdateFaceResult> faceDealCommonResponse = objectMapper.readValue(res.toString(),
                new TypeReference<FaceDealCommonResponse<AddOrUpdateFaceResult>>(){});

        logger.info("========人脸更新 start==========");
        logger.info(faceDealCommonResponse.getError_msg());
        logger.info("========人脸更新 end==========");
        return faceDealCommonResponse;
    }



    /**
     * 删除用户人脸信息
     *
     * @param userId
     * @param groupId
     * @param faceToken
     * @return
     */
    public FaceDealNullResultResponse deleteUserFace(String userId, String groupId,
                                        String faceToken) throws IOException {
        HashMap<String, String> options = new HashMap<String, String>();
        // 人脸删除
        JSONObject res = client.faceDelete(userId, groupId, faceToken, options);

        FaceDealNullResultResponse faceDealNullResultResponse = objectMapper.readValue(res.toString(),
                FaceDealNullResultResponse.class);
        logger.info("========人脸删除 start==========");
        logger.info(faceDealNullResultResponse.getError_msg());
        logger.info("========人脸删除 end==========");
        return faceDealNullResultResponse;
    }

    /**
     * 查询用户信息
     *
     * @param userId
     * @param groupId
     * @return
     */
    public FaceDealCommonResponse<GetUserResult> getUserInfo(String userId, String groupId) throws IOException {
        HashMap<String, String> options = Maps.newHashMap();
        // 用户信息查询
        JSONObject res = client.getUser(userId, groupId, options);

        /**
         * 反序列化泛型，显式构建
         */
        FaceDealCommonResponse<GetUserResult> faceDealCommonResponse = objectMapper.readValue(res.toString(),
                new TypeReference<FaceDealCommonResponse<GetUserResult>>(){});
        logger.info("========查询用户信息 start==========");
        logger.info(faceDealCommonResponse.getError_msg());
        logger.info("========查询用户信息 end==========");
        return faceDealCommonResponse;
    }

    /**
     * 获取用户人脸列表
     *
     * @param userId
     * @param groupId
     * @return
     */
    public FaceDealCommonResponse<FaceGetlistResult> getUserFaceList(String userId, String groupId) throws IOException {
        HashMap<String, String> options = Maps.newHashMap();
        // 获取用户人脸列表
        JSONObject res = client.faceGetlist(userId, groupId, options);
        /**
         * 反序列化泛型，显式构建
         */
        FaceDealCommonResponse<FaceGetlistResult> faceDealCommonResponse = objectMapper.readValue(res.toString(),
                new TypeReference<FaceDealCommonResponse<FaceGetlistResult>>(){});
        logger.info("========获取用户人脸列表 start==========");
        logger.info(faceDealCommonResponse.getError_msg());
        logger.info("========获取用户人脸列表 end==========");
        return faceDealCommonResponse;
    }


    /**
     * 获取一组用户
     * @param groupId 用户组id（由数字、字母、下划线组成），长度限制128B
     * @param start 默认值0，起始序号
     * @param returnNum 返回数量，默认值100，最大值1000
     * @return
     */
    public FaceDealCommonResponse<GroupUsersListResult> getGroupUsers(String groupId,String start, String returnNum) throws IOException {
        HashMap<String, String> options = Maps.newHashMap();

        if (returnNum != null) {
            options.put("length", returnNum);
        }
        if (start != null){
            options.put("start", start);
        }
        // 获取用户列表
        JSONObject res = client.getGroupUsers(groupId, options);
        /**
         * 反序列化泛型，显式构建
         */
        FaceDealCommonResponse<GroupUsersListResult> faceDealCommonResponse = objectMapper.readValue(res.toString(),
                new TypeReference<FaceDealCommonResponse<GroupUsersListResult>>(){});
        logger.info("========获取一组用户 start==========");
        logger.info(faceDealCommonResponse.getError_msg());
        logger.info("========获取一组用户 end==========");
        return faceDealCommonResponse;
    }

    /**
     * 组用户复制
     *
     * @param userId
     * @param srcGroupId
     * @param dstGroupId
     * @return
     */
    public FaceDealNullResultResponse userCopy(String userId, String srcGroupId,
                                  String dstGroupId) throws IOException {
        HashMap<String, String> options = Maps.newHashMap();
        options.put("src_group_id", srcGroupId);
        options.put("dst_group_id", dstGroupId);
        // 复制用户
        JSONObject res = client.userCopy(userId, options);
        FaceDealNullResultResponse faceDealNullResultResponse = objectMapper.readValue(res.toString(),
                FaceDealNullResultResponse.class);
        logger.info("========组用户复制 start==========");
        logger.info(faceDealNullResultResponse.getError_msg());
        logger.info("========组用户复制 end==========");
        return faceDealNullResultResponse;
    }

    /**
     * 删除用户
     *
     * @param userId
     * @param groupId
     * @return
     */
    public FaceDealNullResultResponse deleteUser(String userId, String groupId) throws IOException {
        HashMap<String, String> options = Maps.newHashMap();
        // 删除用户
        JSONObject res = client.deleteUser(groupId, userId, options);
        FaceDealNullResultResponse faceDealNullResultResponse = objectMapper.readValue(res.toString(),
                FaceDealNullResultResponse.class);
        logger.info("========删除用户 start==========");
        logger.info(faceDealNullResultResponse.getError_msg());
        logger.info("========删除用户 end==========");
        return faceDealNullResultResponse;
    }

    /**
     * 创建用户组
     *
     * @param groupId
     * @return
     */
    public FaceDealNullResultResponse addGroup(String groupId) throws IOException {
        HashMap<String, String> options = Maps.newHashMap();
        // 创建用户组
        JSONObject res = client.groupAdd(groupId, options);
        FaceDealNullResultResponse faceDealNullResultResponse = objectMapper.readValue(res.toString(),
                FaceDealNullResultResponse.class);
        logger.info("========创建用户组 start==========");
        logger.info(faceDealNullResultResponse.getError_msg());
        logger.info("========创建用户组 end==========");
        return faceDealNullResultResponse;
    }


    /**
     * 删除用户组
     *
     * @param groupId
     * @return
     */
    public FaceDealNullResultResponse deleteGroup(String groupId) throws IOException {
        HashMap<String, String> options = Maps.newHashMap();
        // 创建用户组
        JSONObject res = client.groupDelete(groupId, options);
        FaceDealNullResultResponse faceDealNullResultResponse = objectMapper.readValue(res.toString(),
                FaceDealNullResultResponse.class);
        logger.info("========删除用户组 start==========");
        logger.info(faceDealNullResultResponse.getError_msg());
        logger.info("========删除用户组 end==========");
        return faceDealNullResultResponse;
    }


}
