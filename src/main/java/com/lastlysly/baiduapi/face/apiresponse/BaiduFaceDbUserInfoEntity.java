package com.lastlysly.baiduapi.face.apiresponse;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2019-09-11 16:16
 * 百度人脸库  用户信息搜索用户信息实体
 **/
public class BaiduFaceDbUserInfoEntity {

    /**
     * 用户的匹配得分
     */
    private String score;
    /**
     * 用户所属的group_id
     */
    private String group_id;

    /**
     * 用户的user_id
     */
    private String user_id;

    /**
     * 注册用户时携带的user_info
     */
    private String user_info;

    @Override
    public String toString() {
        return "BaiduFaceDbUserInfoEntity{" +
                "score='" + score + '\'' +
                ", group_id='" + group_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", user_info='" + user_info + '\'' +
                '}';
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_info() {
        return user_info;
    }

    public void setUser_info(String user_info) {
        this.user_info = user_info;
    }
}
