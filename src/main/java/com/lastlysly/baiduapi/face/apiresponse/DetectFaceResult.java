package com.lastlysly.baiduapi.face.apiresponse;

import java.util.List;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2019-09-11 11:05
 * 人脸检测result
 **/
public class DetectFaceResult {
    /**
     * 人脸数
     */
    private Integer face_num;
    /**
     * 人脸列表
     */
    private List<DetectFaceResultFaceInfo> face_list;

    @Override
    public String toString() {
        return "DetectFaceResult{" +
                "face_num=" + face_num +
                ", face_list=" + face_list +
                '}';
    }

    public Integer getFace_num() {
        return face_num;
    }

    public void setFace_num(Integer face_num) {
        this.face_num = face_num;
    }

    public List<DetectFaceResultFaceInfo> getFace_list() {
        return face_list;
    }

    public void setFace_list(List<DetectFaceResultFaceInfo> face_list) {
        this.face_list = face_list;
    }
}
