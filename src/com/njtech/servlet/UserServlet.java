package com.njtech.servlet;

import com.njtech.entity.User;
import com.njtech.service.UserService;
import com.njtech.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @autor jianz
 * @create 2021-01-06 14:15
 * @desc 用户简历的服务类
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/servlet/UserServlet.do"})
public class UserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    /**
     * 如果不设编码，会出现乱码
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("add".equals(action)) {
            this.add(req, resp);
        } else if ("remove".equals(action)) {
            String sid = req.getParameter("id");
            if (sid.isEmpty()) return;
            Integer id = Integer.parseInt(sid);
            this.doRemove(req, resp, id);
        } else if ("query".equals(action)) {
            String sid = req.getParameter("id");
            if (sid.isEmpty()) return;
            Integer id = Integer.parseInt(sid);
            this.queryUser(req, resp, id);
        } else if ("doAdd".equals(action)) {
            this.doAdd(req, resp);
        } else if ("list".equals(action)) {
            this.queryList(req, resp);
        } else if ("modify".equals(action)) {
            String sid = req.getParameter("id");
            if (sid.isEmpty()) return;
            Integer id = Integer.parseInt(sid);
            this.modify(req, resp, id);
        } else if ("doModify".equals(action)) {
            this.doModify(req, resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String action = req.getParameter("action");
        if ("add".equals(action)) {
            this.add(req, resp);
        } else if ("remove".equals(action)) {
            String sid = req.getParameter("id");
            if (sid.isEmpty()) return;
            Integer id = Integer.parseInt(sid);
            this.doRemove(req, resp, id);
        } else if ("query".equals(action)) {
            String sid = req.getParameter("id");
            if (sid.isEmpty()) return;
            Integer id = Integer.parseInt(sid);
            this.queryUser(req, resp, id);
        } else if ("doAdd".equals(action)) {
            this.doAdd(req, resp);
        } else if ("list".equals(action)) {
            this.queryList(req, resp);
        } else if ("modify".equals(action)) {
            String sid = req.getParameter("id");
            if (sid.isEmpty()) return;
            Integer id = Integer.parseInt(sid);
            this.modify(req, resp, id);
        } else if ("doModify".equals(action)) {
            this.doModify(req, resp);
        }
    }

    /**
     * 处理修改简历信息的请求
     *
     * @param req
     * @param resp
     * @param id
     */
    private void modify(HttpServletRequest req, HttpServletResponse resp, Integer id) {
        User user = null;
        try {
            user = this.userService.queryUser(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("user", user);
        resp.setContentType("text/html;charset=utf-8");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/modifyResume.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 修改简历信息
     *
     * @param req
     * @param resp
     */
    private void doModify(HttpServletRequest req, HttpServletResponse resp) {
        User user = new User();
        String sid = req.getParameter("user.id");
        Integer id = Integer.parseInt(sid);
        user.setId(id);
        user.setUsername(req.getParameter("user.username"));
        user.setJob(req.getParameter("user.job"));
        user.setSkillInfo(req.getParameter("user.skillInfo"));
        user.setSchool(req.getParameter("user.school"));
        user.setMajor(req.getParameter("user.major"));
        user.setEducation(req.getParameter("user.education"));
        user.setEmail(req.getParameter("user.email"));
        user.setSelfEvaluation(req.getParameter("user.selfEvaluation"));
        user.setWorkExperience(req.getParameter("user.workExperience"));
        user.setCourseInfo(req.getParameter("user.courseInfo"));
        user.setCellphone(req.getParameter("user.cellphone"));
        user.setAddress(req.getParameter("user.address"));
        user.setEduDate(req.getParameter("user.eduDate"));
        String fileName = req.getParameter("user.photo");
        // 图片名后缀去掉的部分
        String fileNameWithoutSuffix = fileName.substring(0, fileName.lastIndexOf("."));
        user.setPhoto(fileNameWithoutSuffix);
        try {
            this.userService.modify(user);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        try {
            resp.sendRedirect(req.getContextPath() + "/servlet/UserServlet.do?action=list");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 删除用户简历的处理
     */
    private void doRemove(HttpServletRequest req, HttpServletResponse resp, Integer id) {
        try {
            this.userService.remove(id);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        try {
            resp.sendRedirect(req.getContextPath() + "/servlet/UserServlet.do?action=list");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 调取新简历信息填写页面
     *
     * @param req
     * @param resp
     */
    private void add(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html;charset=utf-8");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/addResume.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 新增用户简历的处理
     */
    private void doAdd(HttpServletRequest req, HttpServletResponse resp) {
        User user = new User();
        user.setUsername(req.getParameter("user.username"));
        user.setJob(req.getParameter("user.job"));
        user.setSkillInfo(req.getParameter("user.skillInfo"));
        user.setSchool(req.getParameter("user.school"));
        user.setMajor(req.getParameter("user.major"));
        user.setEducation(req.getParameter("user.education"));
        user.setEmail(req.getParameter("user.email"));
        user.setSelfEvaluation(req.getParameter("user.selfEvaluation"));
        user.setWorkExperience(req.getParameter("user.workExperience"));
        user.setCourseInfo(req.getParameter("user.courseInfo"));
        user.setCellphone(req.getParameter("user.cellphone"));
        user.setAddress(req.getParameter("user.address"));
        user.setEduDate(req.getParameter("user.eduDate"));
        String fileName = req.getParameter("user.photo");
        // 图片名后缀去掉的部分
        String fileNameWithoutSuffix = fileName.substring(0, fileName.lastIndexOf("."));
        user.setPhoto(fileNameWithoutSuffix);
        System.out.println(user);
        try {
            userService.add(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 查询全部简历信息
     *
     * @param req
     * @param resp
     */
    private void queryList(HttpServletRequest req, HttpServletResponse resp) {
        List<User> users = null;
        try {
            users = this.userService.queryList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("users", users);
        resp.setContentType("text/html;charset=utf-8");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/listResume.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 查询用户简历信息
     *
     * @param request
     * @param resp
     * @param id
     */
    private void queryUser(HttpServletRequest request, HttpServletResponse resp, Integer id) {
        resp.setContentType("text/html;charset=utf-8");
        User user = null;
        try {
            user = this.userService.queryUser(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("user", user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/resume.jsp");
        try {
            requestDispatcher.forward(request, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据id查询用户简历，通过println输出
     *
     * @param req
     * @param resp
     * @param id
     */
    private void queryUser_(HttpServletRequest req, HttpServletResponse resp, Integer id) {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = null;
        try {
            User user = this.userService.queryUser(id);
            System.out.println(user);
            writer = resp.getWriter();
            writer.println("<html>");
            writer.println("<body>");
            writer.println("<h1>");
            writer.println(user.getUsername());
            writer.println("</h1>");
            writer.println("</body>");
            writer.println("</html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
