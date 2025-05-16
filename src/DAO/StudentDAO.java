package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;

public class StudentDAO extends DAO {

    // 1件取得（学生番号で）
    public Student get(String no) throws Exception {
        Student student = null;
        Connection con = getConnection();

        String sql = "SELECT * FROM student WHERE no = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, no);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    student = mapResultSetToStudent(rs);
                }
            }
        } finally {
            con.close();
        }

        return student;
    }

    // 全件取得
    public List<Student> getAll() throws Exception {
        List<Student> list = new ArrayList<>();
        Connection con = getConnection();

        String sql = "SELECT * FROM student";
        try (PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Student student = mapResultSetToStudent(rs);
                list.add(student);
            }
        } finally {
            con.close();
        }

        return list;
    }

    // 新規追加
    public boolean insert(Student student) throws Exception {
        Connection con = getConnection();

        String sql = "INSERT INTO student (no, name, ent_year, class_num, is_attend, school_cd) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, student.getNo());
            stmt.setString(2, student.getName());
            stmt.setInt(3, student.getEntYear());
            stmt.setString(4, student.getClassNum());
            stmt.setBoolean(5, student.isAttend());
            stmt.setString(6, student.getSchool() != null ? student.getSchool().getCd() : null);
            return stmt.executeUpdate() > 0;
        } finally {
            con.close();
        }
    }

    // 更新
    public boolean update(Student student) throws Exception {
        Connection con = getConnection();

        String sql = "UPDATE student SET name = ?, ent_year = ?, class_num = ?, is_attend = ?, school_cd = ? WHERE no = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getEntYear());
            stmt.setString(3, student.getClassNum());
            stmt.setBoolean(4, student.isAttend());
            stmt.setString(5, student.getSchool() != null ? student.getSchool().getCd() : null);
            stmt.setString(6, student.getNo());
            return stmt.executeUpdate() > 0;
        } finally {
            con.close();
        }
    }

    // 削除
    public boolean delete(String no) throws Exception {
        Connection con = getConnection();

        String sql = "DELETE FROM student WHERE no = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, no);
            return stmt.executeUpdate() > 0;
        } finally {
            con.close();
        }
    }

    // 結果セットからStudentインスタンスを作成
    private Student mapResultSetToStudent(ResultSet rs) throws SQLException {
        Student student = new Student();
        student.setNo(rs.getString("no"));
        student.setName(rs.getString("name"));
        student.setEntYear(rs.getInt("ent_year"));
        student.setClassNum(rs.getString("class_num"));
        student.setAttend(rs.getBoolean("is_attend"));

        // Schoolは簡易的にセット（必要ならSchoolDAOで取得）
        School school = new School();
        school.setCd(rs.getString("school_cd"));  // 学校コードをschool_cdに合わせる
        school.setName(rs.getString("school_name")); // 学校名をschool_nameに合わせる（仮に設定）

        student.setSchool(school);

        return student;
    }

    public List<Student> findAll() {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    public Student findById(int id) {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }
}
