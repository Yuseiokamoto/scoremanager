package bean;

import java.io.Serializable;

public class User implements Serializable {

    /**
     * 認証済みフラグ:boolean true:認証済み
     */
    private boolean isAuthenticated;

    /**
     * ユーザーID
     */
    private String id;

    /**
     * ユーザー名
     */
    private String name;

    /**
     * 学校コード
     */
    private String schoolCd;

    // --- ゲッター・セッター ---
    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public void setAuthenticated(boolean isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
