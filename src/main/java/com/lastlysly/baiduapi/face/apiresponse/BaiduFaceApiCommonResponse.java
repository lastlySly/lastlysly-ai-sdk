package com.lastlysly.baiduapi.face.apiresponse;

import java.sql.Timestamp;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2019-09-11 16:55
 * 百度人脸识别api输出
 **/
public class BaiduFaceApiCommonResponse {

    /**
     * 日志id
     */
    private Long log_id;

    private Timestamp timestamp;

    private Integer error_code;

    private Integer cached;

    private String error_msg;

    @Override
    public String toString() {
        return "BaiduFaceApiCommonResponse{" +
                "log_id=" + log_id +
                ", timestamp=" + timestamp +
                ", error_code=" + error_code +
                ", cached=" + cached +
                ", error_msg='" + error_msg + '\'' +
                '}';
    }

    public Long getLog_id() {
        return log_id;
    }

    public void setLog_id(Long log_id) {
        this.log_id = log_id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getError_code() {
        return error_code;
    }

    public void setError_code(Integer error_code) {
        this.error_code = error_code;
    }

    public Integer getCached() {
        return cached;
    }

    public void setCached(Integer cached) {
        this.cached = cached;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }
}
