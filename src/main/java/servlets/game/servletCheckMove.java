package servlets.game;

import database.CheckInformation;
import database.GetInformation;
import database.UpdateInformation;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/checkmove")
public class servletCheckMove  extends HttpServlet {
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
        String whoPlay = req.getParameter("whoplay");


        try {
            if( GetInformation.getPlay(CheckInformation.nameToId(login)) == 0 ||  GetInformation.getPlay(CheckInformation.nameToId(whoPlay)) == 0 ) {
                os.print("-1");
            }
            else
            if (GetInformation.getMove(CheckInformation.nameToId(whoPlay)).equals("-1")){
                os.print("-1");
            }
            else{
                String move = GetInformation.getMove(CheckInformation.nameToId(whoPlay));
                UpdateInformation.updateMove(whoPlay,"-1");
                os.print(move);
                System.out.println("servletCheckMove - start");
                System.out.println("  " + login + " get from " + whoPlay + "  move = " + move);
                System.out.println("servletCheckMove - end");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
