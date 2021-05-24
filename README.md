# Projet Java 2021 - Order and Invoice Manager

Ce projet java s'inscrit dans le cadre de nos études d'informatique de gestion à l'Henallux de namur.

## Fonctionnalité
Ce projet comportera toutes les fonctionnalités citée et expliquée ci-dessous.

* Les opérations CRUD (Create, read, update, delete) sur un client. Celle-ci seront disponible dans la fenêtre Customer List et permettrons à l'utilisateur (CTRL C): 
 * De créer un client via un formulaire demandant toutes les informations nécessaires à la bonne création du client dans la base de données. Les valeurs non obligatoires seront indiquées par un *.
 * D'éditer un client en le sélectionnant dans le tableau et ensuite en appuyant sur le bouton "Update". Toutes les informations seront mises à jour dans la base de données.
 * Supprimer un client, en sélectionnant le client dans le tableau et en cliquant sur le bouton "Delete".

* Effectué une recherche sur les commandes d'un client en particulier. (Recherche numéro 1 - Order listing) - ALT O
* Effectué une recherche sur les clients venant d'un pays sélectionner (Recherche numéro 2 - Customer by country). ALT C
* Effectué une recherche sur un produit donné et les clients l'ayant commandé (Recherche 3 - by product). ALT P
* Une liste de tous les produits (CTRL P)
* Des statistiques globales sur les commandes avec (ALT S) : 
  * Le profit générer par la compagnie
  * Le prix maximum d'une commande
  * Le prix moyen d'une commande,
* des statistiques sur un produit données en entrée (champ product wording).
  * La représentativité d'un produit par rapport aux autres (son nombre de commandes divisé par le total des commandes x 100).
  * Le montant total de ce produit commandé.

## Le thread
Un thread a été créé pour répondre aux contraintes du projet. Celui-ci est une image PNG se déplaçant de gauche à droite dans la fenêtre.

## Amélioration 
### Recherche numéro 1 : Order listing - Autocompletion
Cette recherche doit être améliorée. En effet l'autocomplétion ne permet pas de sélectionner un client ayant le même prénom ou nom qu'un autre client. Le premier client sera toujours sélectionné au détriment du bon client. Par manque de temps nous n'avons pas pu corriger cette erreur.

## Comment utiliser le programme
![image](https://user-images.githubusercontent.com/48365113/119388930-37792000-bccb-11eb-9b60-bc4c4fd6e394.png)

Le menu est composé de trois menus comportements chacun des items. Chaque item dirige vers une fenêtre qui sera expliquée plus loin.
* File
 * Exit : Contiens un raccourci pour quitter la fenêtre
*	Search
  *	Search 1 Order listing -> ALT O
  *	Search 2 Customer by country -> ALT C
  *	Search 3 By product -> ALT P
*	Navigate
  *	Customer list -> CTRL C
  *	Create Order -> CTRL O (cette fenêtre est là à titre d'exemple)
  *	Product list -> CTRL P
  *	Statistics -> ALT S

