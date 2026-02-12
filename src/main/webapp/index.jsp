<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.garage.model.Voiture" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des voitures</title>
</head>
<body>

<h2>Liste des voitures</h2>

<a href="ajouter.jsp">➕ Ajouter une voiture</a>
<br><br>

<table border="1" cellpadding="5">
    <tr>
        <th>Immatriculation</th>
        <th>Marque</th>
        <th>Modèle</th>
        <th>État</th>
        <th>Actions</th>
    </tr>

<%
    // Récupération de l'attribut envoyé par la Servlet
    List<Voiture> voitures = (List<Voiture>) request.getAttribute("voitures");

    // Sécurité : on vérifie que la liste n'est PAS null
    if (voitures != null && !voitures.isEmpty()) {
        for (Voiture v : voitures) {
%>
    <tr>
        <td><%= v.getImmatriculation() %></td>
        <td><%= v.getMarque() %></td>
        <td><%= v.getModele() %></td>
        <td><%= v.getEtat() %></td>
        <td>
            <a href="voitures?action=edit&immatriculation=<%= v.getImmatriculation() %>">
                Modifier
            </a>
            |
            <a href="voitures?action=confirmDelete&immatriculation=<%= v.getImmatriculation() %>">
                Supprimer
            </a>
        </td>
    </tr>
<%
        }
    } else {
%>
    <tr>
        <td colspan="5"><em>Aucune voiture enregistrée.</em></td>
    </tr>
<%
    }
%>

</table>

</body>
</html>
