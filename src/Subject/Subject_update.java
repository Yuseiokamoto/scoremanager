package Subject;

import java.io.IOException;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import DAO.SubjectDao;
import bean.Subject;

@WebServlet("/main/subject_update")
public class Subject_update extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // DB接続を取得する
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

    // GET: 更新フォーム表示
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("code");

        if (code == null || code.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Code is missing");
            return;
        }

        try (Connection conn = getConnection()) {
            SubjectDao dao = new SubjectDao(conn);
            Subject subject = dao.get(code);
            if (subject == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Subject not found");
                return;
            }
            request.setAttribute("subject", subject);
            RequestDispatcher rd = request.getRequestDispatcher("/main/subject_update.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Error retrieving subject", e);
        }
    }

    // POST: 更新処理・完了画面
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String code = request.getParameter("code");
        String name = request.getParameter("name");

        // 入力値のバリデーション
        if (code == null || code.isEmpty() || name == null || name.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing code or name");
            return;
        }

        // schoolCd にデフォルト値を設定
        String schoolCd = "DEF";  // 必ず3文字の値を設定

        Subject subject = new Subject(); // 外に出してスコープを広げる

        try (Connection conn = getConnection()) {
            SubjectDao dao = new SubjectDao(conn);

            subject.setCd(code);
            subject.setName(name);
            subject.setSchoolCd(schoolCd); // SCHOOL_CD にデフォルト値を設定

            // 常に新規追加（既存データの有無を確認しない）
            dao.save(subject);

            // 結果画面に転送
            request.setAttribute("subject", subject);
            RequestDispatcher rd = request.getRequestDispatcher("/main/subject_result.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            throw new ServletException("Error processing the request", e);
        }
    }
}
