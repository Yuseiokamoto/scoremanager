package Subject;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import DAO.SubjectDao;
import bean.Subject;
import bean.User;

@WebServlet("/main/subject_list")
public class Subject_list extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // DB接続を取得
    private Connection getConnection() throws Exception {
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            DataSource ds = (DataSource) envCtx.lookup("jdbc/mond");
            return ds.getConnection();
        } catch (Exception e) {
            throw new ServletException("Database connection error", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (Connection conn = getConnection()) {
            // セッションからログインユーザー取得
            HttpSession session = request.getSession(false);
            if (session == null || session.getAttribute("user") == null) {
                response.sendRedirect(request.getContextPath() + "/login.jsp");
                return;
            }

            User user = (User) session.getAttribute("user");
            String schoolCd = user.getSchoolCd();

            // DAOからその学校に紐づく科目を取得
            SubjectDao subjectDao = new SubjectDao(conn);
            List<Subject> subjectList = subjectDao.getBySchoolCd(schoolCd);

            // リクエストスコープにセット
            request.setAttribute("subject_list", subjectList);

            // JSPにフォワード
            RequestDispatcher rd = request.getRequestDispatcher("/scoremanager/main/subject_list.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    "科目一覧の取得中にエラーが発生しました: " + e.getMessage());
        }
    }
}
