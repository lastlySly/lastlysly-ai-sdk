package com.lastlysly.baiduapi.face.apiresponse;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2019-09-11 11:13
 * 双眼状态（睁开/闭合）
 **/
public class EyeStatusEntity {
    /**
     * 左眼状态 [0,1]取值，越接近0闭合的可能性越大
     */
    private Double left_eye;

    /**
     * 右眼状态 [0,1]取值，越接近0闭合的可能性越大
     */
    private Double right_eye;

    public Double getLeft_eye() {
        return left_eye;
    }

    public void setLeft_eye(Double left_eye) {
        this.left_eye = left_eye;
    }

    public Double getRight_eye() {
        return right_eye;
    }

    public void setRight_eye(Double right_eye) {
        this.right_eye = right_eye;
    }

    @Override
    public String toString() {
        return "EyeStatusEntity{" +
                "left_eye=" + left_eye +
                ", right_eye=" + right_eye +
                '}';
    }
}
