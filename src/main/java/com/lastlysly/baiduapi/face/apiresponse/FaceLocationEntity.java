package com.lastlysly.baiduapi.face.apiresponse;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2019-09-11 11:56
 * 人脸在图片中的位置
 **/
public class FaceLocationEntity {
    /**
     * 人脸区域离上边界的距离
     */
    private Double top;
    /**
     * 人脸区域离左边界的距离
     */
    private Double left;
    /**
     * 人脸框相对于竖直方向的顺时针旋转角，[-180,180]
     */
    private Integer rotation;
    /**
     * 人脸区域的宽度
     */
    private Double width;
    /**
     * 人脸区域的高度
     */
    private Double height;

    @Override
    public String toString() {
        return "FaceLocationEntity{" +
                "top=" + top +
                ", left=" + left +
                ", rotation=" + rotation +
                ", width=" + width +
                ", height=" + height +
                '}';
    }

    public Double getTop() {
        return top;
    }

    public void setTop(Double top) {
        this.top = top;
    }

    public Double getLeft() {
        return left;
    }

    public void setLeft(Double left) {
        this.left = left;
    }

    public Integer getRotation() {
        return rotation;
    }

    public void setRotation(Integer rotation) {
        this.rotation = rotation;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
}
