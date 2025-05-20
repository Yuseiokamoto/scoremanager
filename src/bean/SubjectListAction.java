package bean;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.SubjectDao;
import tool.Action;
import tool.DBConnectionManager;

public class SubjectListAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        School school = (School) session.getAttribute("school");

        // **Schoolがnullならデータベースから取得**
        try (Connection conn = DBConnectionManager.getConnection()) {
            if (conn == null) {
                throw new RuntimeException("Failed to establish database connection.");
            }

            SubjectDao dao = new SubjectDao(conn);

    		// 科目一覧取得

    		List<Subject> subjects = dao.filter(school);


            request.setAttribute("subjects", subjects);


        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "データ取得時にエラーが発生しました。");
        }

         return "subject_list.jsp"; // **その都度新しい検索結果を適用**
    }
}

