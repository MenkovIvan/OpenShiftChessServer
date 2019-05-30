package servlets.game;

import database.CheckInformation;
import database.GetInformation;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/checkcolor")
public class servletCheckColor extends HttpServlet {
    public void init(ServletConfig servletConfig) {
        try {
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream os = resp.getOutputStream();
        System.out.println("servletCheckColor - start");
        String login = req.getParameter("login");
        System.out.println("  login: " + login);

        try {
            String color = GetInformation.getColor(CheckInformation.nameToId(login));
            System.out.println("  res = " + color);
            os.print(color);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("servletCheckColor - end");
    }
}

