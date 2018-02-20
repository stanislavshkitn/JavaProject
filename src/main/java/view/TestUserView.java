package view;

import database.TestUserDB;
import model.TestUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class TestUserView extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<TestUser> userList = TestUserDB.getAllTestUser();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/test.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String first_name = new String(request.getParameter("first_name")
                .getBytes("ISO-8859-1"),"utf-8");
        String last_name = new String(request.getParameter("last_name")
                .getBytes("ISO-8859-1"),"utf-8");
        int age = Integer.parseInt(request.getParameter("age"));
        String number = request.getParameter("number");
        int group = Integer.parseInt(request.getParameter("group"));
        boolean submit = request.getParameter("submit") != null;
        if (submit){
            TestUser user = new TestUser();
            user.setFirst_name(first_name);
            user.setLast_name(last_name);
            user.setAge(age);
            user.setNumber(number);
            user.setGroup(group);
            TestUserDB.createToDB(user);
        }
        ArrayList<TestUser> userList = TestUserDB.getAllTestUser();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/test.jsp").forward(request, response);
    }
}
