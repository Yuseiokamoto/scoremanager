package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Subject;

public class SubjectDao extends DAO {

    private Connection connection;

    public SubjectDao(Connection connection) {
        this.connection = connection;
    }

    // 科目コードで1件取得
    public Subject get(String code) throws SQLException {
        String sql = "SELECT * FROM subject WHERE cd = ?";
        Subject subject = null;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, code);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    subject = new Subject();
                    subject.setCd(rs.getString("cd"));
                    subject.setName(rs.getString("name"));
                    subject.setSchoolCd(rs.getString("school_cd"));
                }
            }
        }
        return subject;
    }

    // 学校コードに紐づく科目一覧を取得（★追加）
    public List<Subject> getBySchoolCd(String schoolCd) throws SQLException {
        String sql = "SELECT * FROM subject WHERE school_cd = ?";
        List<Subject> subjects = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, schoolCd);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Subject subject = new Subject();
                    subject.setCd(rs.getString("cd"));
                    subject.setName(rs.getString("name"));
                    subject.setSchoolCd(rs.getString("school_cd"));
                    subjects.add(subject);
                }
            }
        }
        return subjects;
    }

    // 登録
    public boolean save(Subject subject) throws SQLException {
        String sql = "INSERT INTO subject (cd, name, school_cd) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, subject.getCd());
            stmt.setString(2, subject.getName());
            stmt.setString(3, subject.getSchoolCd());
            return stmt.executeUpdate() > 0;
        }
    }

    // 更新
    public boolean update(Subject subject) throws SQLException {
        String sql = "UPDATE subject SET name = ?, school_cd = ? WHERE cd = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, subject.getName());
            stmt.setString(2, subject.getSchoolCd());
            stmt.setString(3, subject.getCd());
            return stmt.executeUpdate() > 0;
        }
    }

    // 削除
    public boolean delete(String code) throws SQLException {
        String sql = "DELETE FROM subject WHERE cd = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, code);
            return stmt.executeUpdate() > 0;
        }
    }
}
