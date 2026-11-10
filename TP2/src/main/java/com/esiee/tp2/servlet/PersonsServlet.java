package com.esiee.tp2.servlet;

import com.esiee.tp2.model.Datamodel;
import com.esiee.tp2.domain.Person;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/protected/persons")
public class PersonsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Récupération de la liste des personnes depuis le Datamodel
        List<Person> persons = Datamodel.getInstance().getPersons();

        // 2. Stockage de la liste dans l'attribut de requête
        request.setAttribute("persons", persons);

        // 3. Redirection interne vers la page JSP d'affichage
        request.getRequestDispatcher("/protected/persons.jsp").forward(request, response);
    }
}