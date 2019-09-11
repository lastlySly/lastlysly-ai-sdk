package com.lastlysly.baiduapi.face.apiresponse;

import java.util.List;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2019-09-11 15:38
 * 人脸对比result
 **/
public class MatchFaceResult {
    /**
     * 人脸相似度得分
     */
    private Double score;

    /**
     * 人脸信息列表
     */
    private List<FaceInfoEntity> face_list;

    @Override
    public String toString() {
        return "MatchFaceResult{" +
                "score=" + score +
                ", face_list=" + face_list +
                '}';
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public List<FaceInfoEntity> getFace_list() {
        return face_list;
    }

    public void setFace_list(List<FaceInfoEntity> face_list) {
        this.face_list = face_list;
    }
}
