package bean;

import java.io.Serializable;

public class Subject implements Serializable {
    /**
     * 科目コード: CD (String)
     */
    private String cd;

    /**
     * 科目名: NAME (String)
     */
    private String name;

    /**
     * 学校コード: SCHOOL_CD (String)
     */
    private String schoolCd;

    // ゲッター・セッター
    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchoolCd() {
        return schoolCd;
    }

    public void setSchoolCd(String schoolCd) {
        this.schoolCd = schoolCd;
    }
}
