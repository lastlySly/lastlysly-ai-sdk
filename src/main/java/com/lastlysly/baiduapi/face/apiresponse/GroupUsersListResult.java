package com.lastlysly.baiduapi.face.apiresponse;

import java.util.List;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2019-09-16 10:35
 * 组用户列表 result
 **/
public class GroupUsersListResult {
    /**
     * 用户ID列表
     */
    private List<String> user_id_list;

    public List<String> getUser_id_list() {
        return user_id_list;
    }

    public void setUser_id_list(List<String> user_id_list) {
        this.user_id_list = user_id_list;
    }

    @Override
    public String toString() {
        return "GroupUsersListResult{" +
                "user_id_list=" + user_id_list +
                '}';
    }
}
