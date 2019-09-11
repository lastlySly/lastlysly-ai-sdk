package com.lastlysly.baiduapi.face.apiresponse;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2019-09-11 11:23
 * 人脸质量信息
 **/
public class QualityEntity {
    /**
     * 取值范围在[0~255], 表示脸部区域的光照程度 越大表示光照越好
     */
    private Double illumination;
    /**
     * 人脸模糊程度，范围[0~1]，0表示清晰，1表示模糊
     */
    private Double blur;
    /**
     * 人脸完整度，0或1, 0为人脸溢出图像边界，1为人脸都在图像边界内
     * int64
     */
    private Integer completeness;
    /**
     * 人脸各部分遮挡的概率，范围[0~1]，0表示完整，1表示不完整
     */
    private QualityOcclusionEntity occlusion;

    @Override
    public String toString() {
        return "QualityEntity{" +
                "illumination=" + illumination +
                ", blur=" + blur +
                ", completeness=" + completeness +
                ", occlusion=" + occlusion +
                '}';
    }

    public Double getIllumination() {
        return illumination;
    }

    public void setIllumination(Double illumination) {
        this.illumination = illumination;
    }

    public Double getBlur() {
        return blur;
    }

    public void setBlur(Double blur) {
        this.blur = blur;
    }

    public Integer getCompleteness() {
        return completeness;
    }

    public void setCompleteness(Integer completeness) {
        this.completeness = completeness;
    }

    public QualityOcclusionEntity getOcclusion() {
        return occlusion;
    }

    public void setOcclusion(QualityOcclusionEntity occlusion) {
        this.occlusion = occlusion;
    }
}
