package com.lastlysly.baiduapi.face.apiresponse;

import java.util.List;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2019-09-16 10:16
 * 获取用户人脸列表 result
 **/
public class FaceGetlistResult {
    /**
     * 人脸列表
     */
    private List<FaceInfoEntity> face_list;

    @Override
    public String toString() {
        return "FaceGetlistResult{" +
                "face_list=" + face_list +
                '}';
    }

    public List<FaceInfoEntity> getFace_list() {
        return face_list;
    }

    public void setFace_list(List<FaceInfoEntity> face_list) {
        this.face_list = face_list;
    }
}
