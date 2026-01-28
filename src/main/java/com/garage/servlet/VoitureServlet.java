package com.garage.servlet;

import com.garage.dao.VoitureDAO;
import com.garage.model.Voiture;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/voitures")
public class VoitureServlet extends HttpServlet {

    private VoitureDAO dao = new VoitureDAO();

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) {
            // 1. Affichage de la liste
            request.setAttribute("voitures", dao.findAll());
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } else if (action.equals("edit")) {
            // 2. Affichage formulaire modification
            String immat = request.getParameter("immatriculation");
            request.setAttribute("voiture", dao.findById(immat));
            request.getRequestDispatcher("modifier.jsp").forward(request, response);

        } else if (action.equals("confirmDelete")) {
            // 3. Page de confirmation suppression
            String immat = request.getParameter("immatriculation");
            request.setAttribute("voiture", dao.findById(immat));
            request.getRequestDispatcher("confirmer_suppression.jsp").forward(request, response);
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action.equals("add")) {
            // 4. Ajout d’une voiture
            Voiture v = new Voiture(
                    request.getParameter("immatriculation"),
                    request.getParameter("marque"),
                    request.getParameter("modele"),
                    request.getParameter("etat")
            );
            dao.ajouter(v);

        } else if (action.equals("update")) {
            // 5. Modification d’une voiture
            Voiture v = new Voiture(
                    request.getParameter("immatriculation"),
                    request.getParameter("marque"),
                    request.getParameter("modele"),
                    request.getParameter("etat")
            );
            dao.modifier(v);

        } else if (action.equals("delete")) {
            // 6. Suppression d’une voiture
            String immat = request.getParameter("immatriculation");
            dao.supprimer(immat);
        }

        // Redirection vers la liste
        response.sendRedirect("voitures");
    }
}
