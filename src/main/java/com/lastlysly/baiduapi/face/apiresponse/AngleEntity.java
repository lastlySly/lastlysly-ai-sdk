package com.lastlysly.baiduapi.face.apiresponse;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2019-09-11 11:46
 * 姿态角度
 **/
public class AngleEntity {
    /**
     * 平面内旋转角[-180(逆时针), 180(顺时针)]
     */
    private Double roll;
    /**
     * 三维旋转之俯仰角度[-90(上), 90(下)]
     */
    private Double pitch;
    /**
     * 三维旋转之左右旋转角[-90(左), 90(右)]
     */
    private Double yaw;

    @Override
    public String toString() {
        return "AngleEntity{" +
                "roll=" + roll +
                ", pitch=" + pitch +
                ", yaw=" + yaw +
                '}';
    }

    public Double getRoll() {
        return roll;
    }

    public void setRoll(Double roll) {
        this.roll = roll;
    }

    public Double getPitch() {
        return pitch;
    }

    public void setPitch(Double pitch) {
        this.pitch = pitch;
    }

    public Double getYaw() {
        return yaw;
    }

    public void setYaw(Double yaw) {
        this.yaw = yaw;
    }
}
