package com.lastlysly.baiduapi.face.apiresponse;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2019-09-11 11:40
 * 人脸质量信息  人脸各部分遮挡的概率 范围[0~1]，0表示完整，1表示不完整
 **/
public class QualityOcclusionEntity {

    /**
     * 左眼遮挡比例，[0-1] ，1表示完全遮挡
     */
    private Double left_eye;
    /**
     * 右眼遮挡比例，[0-1] ， 1表示完全遮挡
     */
    private Double right_eye;
    /**
     * 鼻子遮挡比例，[0-1] ， 1表示完全遮挡
     */
    private Double nose;
    /**
     * 嘴巴遮挡比例，[0-1] ， 1表示完全遮挡
     */
    private Double mouth;
    /**
     * 右脸颊遮挡比例，[0-1] ， 1表示完全遮挡
     */
    private Double right_cheek;
    /**
     * 左脸颊遮挡比例，[0-1] ， 1表示完全遮挡
     */
    private Double left_cheek;
    /**
     * 下巴遮挡比例，，[0-1] ， 1表示完全遮挡
     */
    private Double chin_contour;

    @Override
    public String toString() {
        return "QualityOcclusionEntity{" +
                "left_eye=" + left_eye +
                ", right_eye=" + right_eye +
                ", nose=" + nose +
                ", mouth=" + mouth +
                ", right_cheek=" + right_cheek +
                ", left_cheek=" + left_cheek +
                ", chin_contour=" + chin_contour +
                '}';
    }

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

    public Double getNose() {
        return nose;
    }

    public void setNose(Double nose) {
        this.nose = nose;
    }

    public Double getMouth() {
        return mouth;
    }

    public void setMouth(Double mouth) {
        this.mouth = mouth;
    }

    public Double getRight_cheek() {
        return right_cheek;
    }

    public void setRight_cheek(Double right_cheek) {
        this.right_cheek = right_cheek;
    }

    public Double getLeft_cheek() {
        return left_cheek;
    }

    public void setLeft_cheek(Double left_cheek) {
        this.left_cheek = left_cheek;
    }

    public Double getChin_contour() {
        return chin_contour;
    }

    public void setChin_contour(Double chin_contour) {
        this.chin_contour = chin_contour;
    }
}
