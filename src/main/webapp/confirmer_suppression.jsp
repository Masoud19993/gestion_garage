<%@ page import="com.garage.model.Voiture" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Confirmation de suppression</title>
</head>
<body>

<%
    Voiture v = (Voiture) request.getAttribute("voiture");
%>

<h2>Confirmation de suppression</h2>

<p>
    Voulez-vous vraiment supprimer la voiture :
</p>

<ul>
    <li><strong>Immatriculation :</strong> <%= v.getImmatriculation() %></li>
    <li><strong>Marque :</strong> <%= v.getMarque() %></li>
    <li><strong>Modèle :</strong> <%= v.getModele() %></li>
</ul>

<form method="post" action="voitures">
    <input type="hidden" name="action" value="delete">
    <input type="hidden" name="immatriculation"
           value="<%= v.getImmatriculation() %>">

    <button type="submit">Oui, supprimer</button>
</form>

<br>
<a href="voitures">❌ Annuler</a>

</body>
</html>