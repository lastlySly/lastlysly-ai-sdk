package com.lastlysly.baiduapi.face.apiresponse;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2019-09-16 09:29
 * 百度人脸库  索用户信息通用实体
 **/
public class BaiduFaceDbUserCommonInfoEntity {
    /**
     * 用户所属的group_id
     */
    private String group_id;
    /**
     * 注册用户时携带的user_info
     */
    private String user_info;

    @Override
    public String toString() {
        return "BaiduFaceDbUserCommonInfoEntity{" +
                "group_id='" + group_id + '\'' +
                ", user_info='" + user_info + '\'' +
                '}';
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getUser_info() {
        return user_info;
    }

    public void setUser_info(String user_info) {
        this.user_info = user_info;
    }
}
