package com.esiee.tp2.servlet;

import com.esiee.tp2.domain.Person;
import com.esiee.tp2.model.Datamodel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/authenticate")
public class AuthenticationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Datamodel datamodel = Datamodel.getInstance();
        List<Person> persons = datamodel.getPersons();

        boolean authenticated = false;

        if (login != null && password != null) {
            for (Person p : persons) {
                if (login.equals(p.getLogin()) && password.equals(p.getPassword())) {
                    authenticated = true;
                    break;
                }
            }
        }

        if (authenticated) {
            HttpSession session = request.getSession(true);
            session.setAttribute("login", login);

            response.sendRedirect(request.getContextPath() + "/protected/success_authentication.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/bad_credentials.jsp");
        }
    }
}
