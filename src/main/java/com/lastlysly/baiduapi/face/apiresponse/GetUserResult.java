package com.lastlysly.baiduapi.face.apiresponse;

import java.util.List;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2019-09-16 09:27
 * 用户信息查询result
 **/
public class GetUserResult {
    /**
     * 查询到的用户列表
     */
    private List<BaiduFaceDbUserCommonInfoEntity> user_list;

    public List<BaiduFaceDbUserCommonInfoEntity> getUser_list() {
        return user_list;
    }

    public void setUser_list(List<BaiduFaceDbUserCommonInfoEntity> user_list) {
        this.user_list = user_list;
    }

    @Override
    public String toString() {
        return "GetUserResult{" +
                "user_list=" + user_list +
                '}';
    }
}
