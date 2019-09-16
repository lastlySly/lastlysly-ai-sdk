package com.lastlysly.baiduapi.face.apiresponse;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2019-09-12 11:03
 * 注册人脸，更新人脸result
 **/
public class AddOrUpdateFaceResult {
    private String face_token;
    private FaceLocationEntity location;

    @Override
    public String toString() {
        return "AddOrUpdateFaceResult{" +
                "face_token='" + face_token + '\'' +
                ", location=" + location +
                '}';
    }

    public String getFace_token() {
        return face_token;
    }

    public void setFace_token(String face_token) {
        this.face_token = face_token;
    }

    public FaceLocationEntity getLocation() {
        return location;
    }

    public void setLocation(FaceLocationEntity location) {
        this.location = location;
    }
}
