package Subject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SubjectDao;

public class Subject_Error extends HttpServlet {

    private SubjectDao subjectDAO = new SubjectDao(null); // DAOは適宜初期化してください

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String code = request.getParameter("code");
        String name = request.getParameter("name");
        boolean hasError = false;

        // エラー保持用
        Map<String, String> errors = new HashMap<>();

        // 空チェック
        if (code == null || code.trim().isEmpty()) {
            errors.put("fieldError_code", "このフィールド値を入力してください。");
            hasError = true;
        } else if (code.length() != 3) {
            errors.put("fieldError_code", "科目コードは三文字で入力してください。");
            hasError = true;
        } else if (subjectDAO.existsCode(code)) {
            errors.put("fieldError_code", "科目コードが重複しています。");
            hasError = true;
        }

        if (name == null || name.trim().isEmpty()) {
            errors.put("fieldError_name", "科目名を入力してください。");
            hasError = true;
        }

        if (hasError) {
            // エラー情報をリクエストスコープにセット
            for (Map.Entry<String, String> entry : errors.entrySet()) {
                request.setAttribute(entry.getKey(), entry.getValue());
            }
            // 入力値保持用
            request.setAttribute("code", code);
            request.setAttribute("name", name);
            // 元の登録画面に戻す
            request.getRequestDispatcher("/subject/Subject_register.jsp").forward(request, response);
            return;
        }

        // エラーなしの場合の処理（登録処理など）
        // ここに登録ロジックを追加してください

        // 登録完了後の画面遷移など
        response.sendRedirect(request.getContextPath() + "/subject/Subject_list.jsp");
    }
}
