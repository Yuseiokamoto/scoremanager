package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.ClassNum;

public class ClassNumDao extends DAO {

    private Connection connection;

    public ClassNumDao(Connection connection) {
        this.connection = connection;
    }

    // 指定された classNum と schoolCd に一致するクラスを取得
    public List<ClassNum> get(String classNum, String schoolCd) throws SQLException {
        String sql = "SELECT * FROM class_num WHERE class_number = ? AND school_code = ?";
        List<ClassNum> classNums = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, classNum);
            stmt.setString(2, schoolCd);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ClassNum cn = new ClassNum();
                    cn.setClassNum(rs.getString("class_number"));
                    cn.setSchoolCd(rs.getString("school_code"));
                    classNums.add(cn);
                }
            }
        }
        return classNums;
    }

    // 指定された学校のクラス番号一覧を取得
    public List<String> filter(String schoolCd) throws SQLException {
        String sql = "SELECT class_number FROM class_num WHERE school_code = ?";
        List<String> classNums = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, schoolCd);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    classNums.add(rs.getString("class_number"));
                }
            }
        }
        return classNums;
    }

    // クラス情報を登録
    public boolean save(ClassNum classNum) throws SQLException {
        String sql = "INSERT INTO class_num (class_number, school_code) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, classNum.getClassNum());
            stmt.setString(2, classNum.getSchoolCd());
            return stmt.executeUpdate() > 0;
        }
    }

    // クラス情報を更新
    public boolean save(ClassNum classNum, String newClassNum) throws SQLException {
        String sql = "UPDATE class_num SET class_number = ? WHERE class_number = ? AND school_code = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, newClassNum);
            stmt.setString(2, classNum.getClassNum());
            stmt.setString(3, classNum.getSchoolCd());
            return stmt.executeUpdate() > 0;
        }
    }
}
