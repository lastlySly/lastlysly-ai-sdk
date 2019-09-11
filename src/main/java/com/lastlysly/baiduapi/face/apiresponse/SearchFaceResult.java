package com.lastlysly.baiduapi.face.apiresponse;

import java.util.List;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2019-09-11 16:11
 * 人脸搜索result
 **/
public class SearchFaceResult {
    /**
     * 人脸标志
     */
    private String face_token;

    /**
     * 匹配的用户信息列表
     */
    private List<BaiduFaceDbUserInfoEntity> user_list;

    @Override
    public String toString() {
        return "SearchFaceResult{" +
                "face_token='" + face_token + '\'' +
                ", user_list=" + user_list +
                '}';
    }

    public String getFace_token() {
        return face_token;
    }

    public void setFace_token(String face_token) {
        this.face_token = face_token;
    }

    public List<BaiduFaceDbUserInfoEntity> getUser_list() {
        return user_list;
    }

    public void setUser_list(List<BaiduFaceDbUserInfoEntity> user_list) {
        this.user_list = user_list;
    }
}
