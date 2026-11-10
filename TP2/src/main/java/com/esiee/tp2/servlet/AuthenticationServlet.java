package com.esiee.tp2.servlet;

import com.esiee.tp2.domain.Person;
import com.esiee.tp2.model.Datamodel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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

            response.sendRedirect(request.getContextPath() + "/protected/persons.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/non_authorized.jsp");
        }
    }
}
