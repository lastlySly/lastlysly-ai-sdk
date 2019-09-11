package com.lastlysly.baiduapi.face.apiresponse;

import java.util.List;
import java.util.Map;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2019-09-11 11:07
 * 人脸检测人脸列表
 **/
public class DetectFaceResultFaceInfo extends FaceInfoEntity {

    /**
     * 表情，当 face_field包含expression时返回
     */
    private ProbabilityAndTypeEntity expression;

    /**
     * 脸型，当face_field包含face_shape时返回
     */
    private ProbabilityAndTypeEntity face_shape;

    /**
     * 美丑打分，范围0-100，越大表示越美。当face_fields包含beauty时返回
     */
    private Double beauty;

    /**
     * 性别
     */
    private ProbabilityAndTypeEntity gender;

    /**
     * 人种 face_field包含race时返回
     */
    private ProbabilityAndTypeEntity race;

    /**
     * 双眼状态（睁开/闭合） face_field包含eye_status时返回
     */
    private EyeStatusEntity eye_status;

    /**
     * 人脸置信度，范围【0~1】，代表这是一张人脸的概率，0最小、1最大。
     */
    private Double face_probability;

    /**
     * 人脸质量信息
     */
    private QualityEntity quality;

    /**
     * 是否带眼镜，face_field包含glasses时返回
     */
    private ProbabilityAndTypeEntity glasses;

    /**
     * 情绪 face_field包含emotion时返回
     */
    private ProbabilityAndTypeEntity emotion;

    /**
     * 72个特征点位置 face_field包含landmark72时返回
     */
    private List<PointPositionXyEntity> landmark72;

    /**
     * 150个特征点位置 face_field包含landmark150时返回
     */
    private Map landmark150;

    /**
     * 姿态角度
     */
    private AngleEntity angle;

    /**
     * 人脸在图片中的位置
     */
    private FaceLocationEntity location;

    /**
     * 4个关键点位置，左眼中心、右眼中心、鼻尖、嘴中心。face_field包含landmark时返回
     */
    private List<PointPositionXyEntity> landmark;

    /**
     * 年龄
     */
    private Integer age;

    /**
     *真实人脸/卡通人脸 face_field包含face_type时返回
     */
    private ProbabilityAndTypeEntity face_type;

    @Override
    public String toString() {
        return "DetectFaceResultFaceInfo{" +
                "expression=" + expression +
                ", face_shape=" + face_shape +
                ", beauty=" + beauty +
                ", gender=" + gender +
                ", race=" + race +
                ", eye_status=" + eye_status +
                ", face_probability=" + face_probability +
                ", quality=" + quality +
                ", glasses=" + glasses +
                ", emotion=" + emotion +
                ", landmark72=" + landmark72 +
                ", landmark150=" + landmark150 +
                ", angle=" + angle +
                ", location=" + location +
                ", landmark=" + landmark +
                ", age=" + age +
                ", face_type=" + face_type +
                '}';
    }

    public ProbabilityAndTypeEntity getFace_type() {
        return face_type;
    }

    public void setFace_type(ProbabilityAndTypeEntity face_type) {
        this.face_type = face_type;
    }

    public ProbabilityAndTypeEntity getExpression() {
        return expression;
    }

    public void setExpression(ProbabilityAndTypeEntity expression) {
        this.expression = expression;
    }

    public ProbabilityAndTypeEntity getFace_shape() {
        return face_shape;
    }

    public void setFace_shape(ProbabilityAndTypeEntity face_shape) {
        this.face_shape = face_shape;
    }

    public Double getBeauty() {
        return beauty;
    }

    public void setBeauty(Double beauty) {
        this.beauty = beauty;
    }

    public ProbabilityAndTypeEntity getGender() {
        return gender;
    }

    public void setGender(ProbabilityAndTypeEntity gender) {
        this.gender = gender;
    }

    public ProbabilityAndTypeEntity getRace() {
        return race;
    }

    public void setRace(ProbabilityAndTypeEntity race) {
        this.race = race;
    }

    public EyeStatusEntity getEye_status() {
        return eye_status;
    }

    public void setEye_status(EyeStatusEntity eye_status) {
        this.eye_status = eye_status;
    }

    public Double getFace_probability() {
        return face_probability;
    }

    public void setFace_probability(Double face_probability) {
        this.face_probability = face_probability;
    }

    public QualityEntity getQuality() {
        return quality;
    }

    public void setQuality(QualityEntity quality) {
        this.quality = quality;
    }

    public ProbabilityAndTypeEntity getGlasses() {
        return glasses;
    }

    public void setGlasses(ProbabilityAndTypeEntity glasses) {
        this.glasses = glasses;
    }

    public ProbabilityAndTypeEntity getEmotion() {
        return emotion;
    }

    public void setEmotion(ProbabilityAndTypeEntity emotion) {
        this.emotion = emotion;
    }

    public List<PointPositionXyEntity> getLandmark72() {
        return landmark72;
    }

    public void setLandmark72(List<PointPositionXyEntity> landmark72) {
        this.landmark72 = landmark72;
    }

    public Map getLandmark150() {
        return landmark150;
    }

    public void setLandmark150(Map landmark150) {
        this.landmark150 = landmark150;
    }

    public AngleEntity getAngle() {
        return angle;
    }

    public void setAngle(AngleEntity angle) {
        this.angle = angle;
    }

    public FaceLocationEntity getLocation() {
        return location;
    }

    public void setLocation(FaceLocationEntity location) {
        this.location = location;
    }

    public List<PointPositionXyEntity> getLandmark() {
        return landmark;
    }

    public void setLandmark(List<PointPositionXyEntity> landmark) {
        this.landmark = landmark;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
