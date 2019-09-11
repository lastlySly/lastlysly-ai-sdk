package com.lastlysly.baiduapi.face.apirequest;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2019-09-11 15:15
 * 人脸识别 额外选项参数(非必选参数)
 **/
public class FaceOptionsParamEntity {

    /**
     * 包括age,beauty,expression,face_shape,gender,glasses,landmark,landmark72，landmark150，race,quality,eye_status,emotion,face_type信息
     * 逗号分隔. 默认只返回face_token、人脸框、概率和旋转角度
     */
    private String face_field;

    /**
     * 最多处理人脸的数目，默认值为1，仅检测图片中面积最大的那个人脸；最大值10，检测图片中面积最大的几张人脸。
     */
    private String max_face_num;

    /**
     * 人脸的类型
     * LIVE     表示生活照：通常为手机、相机拍摄的人像图片、或从网络获取的人像图片等
     * IDCARD   表示身份证芯片照：二代身份证内置芯片中的人像照片
     * WATERMARK    表示带水印证件照：一般为带水印的小图，如公安网小图
     * CERT 表示证件照片：如拍摄的身份证、工卡、护照、学生证等证件图片 默认LIVE
     */
    private String face_type;

    /**
     * 活体检测控制
     * NONE: 不进行控制
     * LOW:较低的活体要求(高通过率 低攻击拒绝率)
     * NORMAL: 一般的活体要求(平衡的攻击拒绝率, 通过率)
     * HIGH: 较高的活体要求(高攻击拒绝率 低通过率) 默认NONE
     */
    private String liveness_control;


    /**
     * 从指定的group中进行查找 用逗号分隔，上限20个
     */
    private String group_id_list;

    /**
     * 匹配阈值（设置阈值后，score低于此阈值的用户信息将不会返回） 最大100 最小0 默认80
     * 此阈值设置得越高，检索速度将会越快，推荐使用默认阈值80
     */
    private String match_threshold;

    /**
     * 图片质量控制 NONE: 不进行控制 LOW:较低的质量要求 NORMAL: 一般的质量要求 HIGH: 较高的质量要求 默认 NONE
     */
    private String quality_control;

    /**
     * 当需要对特定用户进行比对时，指定user_id进行比对。即人脸认证功能。
     */
    private String user_id;

    /**
     * 查找后返回的用户数量。返回相似度最高的几个用户，默认为1，最多返回50个。
     */
    private String max_user_num;

    /**
     * 操作方式 APPEND: 当user_id在库中已经存在时，对此user_id重复注册时，新注册的图片默认会追加到该user_id下,
     * REPLACE : 当对此user_id重复注册时,则会用新图替换库中该user_id下所有图片,默认使用APPEND
     */
    private String action_type;

    /**
     * 用户资料，长度限制256B
     */
    private String user_info;

    public String getUser_info() {
        return user_info;
    }

    public void setUser_info(String user_info) {
        this.user_info = user_info;
    }

    public String getAction_type() {
        return action_type;
    }

    public void setAction_type(String action_type) {
        this.action_type = action_type;
    }

    public String getGroup_id_list() {
        return group_id_list;
    }

    public void setGroup_id_list(String group_id_list) {
        this.group_id_list = group_id_list;
    }

    public String getMatch_threshold() {
        return match_threshold;
    }

    public void setMatch_threshold(String match_threshold) {
        this.match_threshold = match_threshold;
    }

    public String getQuality_control() {
        return quality_control;
    }

    public void setQuality_control(String quality_control) {
        this.quality_control = quality_control;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getMax_user_num() {
        return max_user_num;
    }

    public void setMax_user_num(String max_user_num) {
        this.max_user_num = max_user_num;
    }

    public String getFace_field() {
        return face_field;
    }

    public void setFace_field(String face_field) {
        this.face_field = face_field;
    }

    public String getMax_face_num() {
        return max_face_num;
    }

    public void setMax_face_num(String max_face_num) {
        this.max_face_num = max_face_num;
    }

    public String getFace_type() {
        return face_type;
    }

    public void setFace_type(String face_type) {
        this.face_type = face_type;
    }

    public String getLiveness_control() {
        return liveness_control;
    }

    public void setLiveness_control(String liveness_control) {
        this.liveness_control = liveness_control;
    }
}
