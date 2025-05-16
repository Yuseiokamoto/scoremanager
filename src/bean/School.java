package bean;

import java.io.Serializable;

public class School implements Serializable {
    /**
     * 学校コード: SCHOOL_CD
     */
    private String schoolCd;

    /**
     * 学校名: SCHOOL_NAME
     */
    private String schoolName;

    // ゲッター・セッター
    public String getSchoolCd() {
        return schoolCd;
    }

    public void setSchoolCd(String schoolCd) {
        this.schoolCd = schoolCd;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
