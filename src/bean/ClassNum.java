package bean;

import java.io.Serializable;

public class ClassNum implements Serializable {
    /**
     * クラス番号: CLASS_NUM
     */
    private String classNum;

    /**
     * 学校コード: SCHOOL_CD
     */
    private String schoolCd;

    // ゲッター・セッター
    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public String getSchoolCd() {
        return schoolCd;
    }

    public void setSchoolCd(String schoolCd) {
        this.schoolCd = schoolCd;
    }
}
