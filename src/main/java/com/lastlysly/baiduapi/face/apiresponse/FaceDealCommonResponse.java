package com.lastlysly.baiduapi.face.apiresponse;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2019-09-11 10:42
 * 百度人脸识别人脸操作 api输出
 **/
public class FaceDealCommonResponse<T> extends BaiduFaceApiCommonResponse {
    /**
     * 结果
     */
    private T result;

    @Override
    public String toString() {
        return "FaceDealCommonResponse{" +
                "result=" + result +
                '}';
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

}
