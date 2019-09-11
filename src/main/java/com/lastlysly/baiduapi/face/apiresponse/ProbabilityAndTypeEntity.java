package com.lastlysly.baiduapi.face.apiresponse;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2019-09-11 11:10
 * 置信度（概率，准确度...） 与类型
 **/
public class ProbabilityAndTypeEntity {
    /**
     * 置信度（概率，准确度...）
     */
    private Double probability;

    /**
     * 类型
     */
    private String type;

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ProbabilityAndTypeEntity{" +
                "probability=" + probability +
                ", type='" + type + '\'' +
                '}';
    }
}
