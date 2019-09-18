package com.lastlysly.baiduapi.face.apiresponse;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2019-09-16 11:21
 * 空result 输出
 **/
public class FaceDealNullResultResponse extends BaiduFaceApiCommonResponse {
    private Object result;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "FaceDealNullResultResponse{" +
                "result=" + result +
                '}';
    }
}
