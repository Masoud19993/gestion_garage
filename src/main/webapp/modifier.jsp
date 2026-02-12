<%@ page import="com.garage.model.Voiture" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier une voiture</title>
</head>
<body>

<h2>Modifier une voiture</h2>

<%
    Voiture v = (Voiture) request.getAttribute("voiture");
%>

<form method="post" action="voitures">
    <input type="hidden" name="action" value="update">

    Immatriculation :
    <input type="text" name="immatriculation"
           value="<%= v.getImmatriculation() %>" readonly><br><br>

    Marque :
    <input type="text" name="marque"
           value="<%= v.getMarque() %>"><br><br>

    Modèle :
    <input type="text" name="modele"
           value="<%= v.getModele() %>"><br><br>

    État :
    <select name="etat">
        <option <%= v.getEtat().equals("pris en charge") ? "selected" : "" %>>
            pris en charge
        </option>
        <option <%= v.getEtat().equals("en cours") ? "selected" : "" %>>
            en cours
        </option>
        <option <%= v.getEtat().equals("terminé") ? "selected" : "" %>>
            terminé
        </option>
    </select><br><br>

    <button type="submit">Enregistrer</button>
</form>

<br>
<a href="voitures">⬅ Annuler</a>

</body>
</html>
