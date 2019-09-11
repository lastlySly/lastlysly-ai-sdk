package com.lastlysly.baiduapi.face.apiresponse;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2019-09-11 15:42
 * 人脸基本信息
 **/
public class FaceInfoEntity {
    /**
     * 人脸图片的唯一标识，调用人脸检测接口时，会为每个人脸图片赋予一个唯一的FACE_TOKEN，同一张图片多次检测得到的FACE_TOKEN是同一个。
     */
    private String face_token;

    public String getFace_token() {
        return face_token;
    }

    public void setFace_token(String face_token) {
        this.face_token = face_token;
    }

    @Override
    public String toString() {
        return "FaceInfoEntity{" +
                "face_token='" + face_token + '\'' +
                '}';
    }
}
