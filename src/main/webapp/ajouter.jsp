<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter une voiture</title>
</head>
<body>

<h2>Ajouter une voiture</h2>

<form method="post" action="voitures">
    <input type="hidden" name="action" value="add">

    Immatriculation :
    <input type="text" name="immatriculation" required><br><br>

    Marque :
    <input type="text" name="marque" required><br><br>

    Modèle :
    <input type="text" name="modele" required><br><br>

    État :
    <select name="etat">
        <option value="pris en charge">Pris en charge</option>
        <option value="en cours">En cours</option>
        <option value="terminé">Terminé</option>
    </select><br><br>

    <button type="submit">Ajouter</button>
</form>

<br>
<a href="voitures">⬅ Retour à la liste</a>

</body>
</html>