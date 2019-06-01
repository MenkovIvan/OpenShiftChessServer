package servlets.mainMenu;

import database.player.CheckInfPlayer;
import database.player.GetInfPlayer;
import database.player.UpdateInfPlayer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/checkupdate")
public class servletCheckUpdate extends HttpServlet {
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
        String login = req.getParameter("login");
        System.out.println("servletCheckUpdate - start");
        System.out.println("login: " + login);

        try {
            if (GetInfPlayer.getIInvite(CheckInfPlayer.nameToId(login))==0 &&  GetInfPlayer.getIInvite(GetInfPlayer.getMeInvite(CheckInfPlayer.nameToId(login)))==-1){
                os.print("1");
                System.out.println("  1");
            }
            else if (GetInfPlayer.getMeInvite(CheckInfPlayer.nameToId(login))==0 &&  GetInfPlayer.getIInvite(GetInfPlayer.getMeInvite(CheckInfPlayer.nameToId(login)))==-1){
                os.print("1");
                System.out.println("  1");
            }
            else os.print("0");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("servletCheckUpdate - end");
    }
}