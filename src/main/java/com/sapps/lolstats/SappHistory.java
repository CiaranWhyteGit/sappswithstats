package com.sapps.lolstats;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "SappHistory", urlPatterns = {"/SappHistory"})
public class SappHistory extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Sapp mordo = new Sapp("mordo");
            PrintWriter out = response.getWriter();

            response.setContentType("text/html;charset=UTF-8");
            out.println("<p>"+mordo.summoner_name+" "+mordo.summonerId +"</p>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Sapp mordo = new Sapp("mordo");
            PrintWriter out = response.getWriter();
            out.println("<p>"+mordo.summoner_name+" "+mordo.summonerId +"</p>");
            out.println("<div>"+mordo.recentGameStats.lastTenGames+"</div>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
