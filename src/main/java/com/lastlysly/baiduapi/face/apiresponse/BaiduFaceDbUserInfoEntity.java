package com.lastlysly.baiduapi.face.apiresponse;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2019-09-11 16:16
 * 百度人脸库  用户信息搜索用户信息实体
 **/
public class BaiduFaceDbUserInfoEntity extends BaiduFaceDbUserCommonInfoEntity {

    /**
     * 用户的匹配得分
     */
    private String score;

    /**
     * 用户的user_id
     */
    private String user_id;

    @Override
    public String toString() {
        return "BaiduFaceDbUserInfoEntity{" +
                "score='" + score + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

}
