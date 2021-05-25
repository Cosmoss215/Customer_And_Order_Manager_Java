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

## Amélioration possible
### Recherche numéro 1 : Order listing - Autocompletion
Cette recherche doit être améliorée. En effet l'autocomplétion ne permet pas de sélectionner un client ayant le même prénom ou nom qu'un autre client. Le premier client sera toujours sélectionné au détriment du bon client. Par manque de temps nous n'avons pas pu corriger cette erreur.

### Nouvelles normes SQL
Certaines normes MySQL que nous avons employées seront bientôt dépréciés. Cependant, dans le cadre de notre projet nous avons jugé bon de les laisser telles quelles.

Voici les changements qui seront auront lieu dans d'une future mise à jour :

* Le fait d'indiquer une taille à un entier sera supprimé dans une future mise à jour mais ne devrait pas impacter le script de notre projet. Plus tard il ne sera donc plus nécessaire d'indiquer cette taille d'entier.

* UTF8 est un alias pour UTF8MB3 mais une future mise à jour mettre UTF8 comme alias pour UTF8 MB4 ce qui n'aura aucun impact sur notre projet.

### Clean code
Le clean code est très important surtout dans un projet de cette ampleur. Nous pensons qu'il reste encore des factorisations de code à effectuer et probablement des éléments qui ont échappés à notre attention.

## Auto critique
Nous sommes certains qu'il reste encore beaucoup de choses à améliorer dans l'aspect réutilisabilité, voire efficacité du code. Cependant avec davantage de temps et de recul nous aurions pu y consacrer plus d'attention et d'énergie.

## Comment utiliser le programme
### Le menu
![image](https://user-images.githubusercontent.com/48365113/119388930-37792000-bccb-11eb-9b60-bc4c4fd6e394.png)

Le menu est composé de trois menus comportements chacun des items. Chaque item dirige vers une fenêtre qui sera expliquée plus loin.
* File
  * Exit : Contiens un raccourci pour quitter la fenêtre
* Search
  * Search 1 Order listing -> ALT O
  * Search 2 Customer by country -> ALT C
  * Search 3 By product -> ALT P
* Navigate
  * Customer list -> CTRL C
  * Create Order -> CTRL O (cette fenêtre est là à titre d'exemple)
  * Product list -> CTRL P
  * Statistics -> ALT S

### Search 1 Order listing
![image](https://user-images.githubusercontent.com/48365113/119389393-dd2c8f00-bccb-11eb-8fa0-5a661270f0f9.png)

Cette fenêtre, accessible via le menu (ALT O) permet d'afficher les commandes par client entre deux dates données ou simplement toutes les commandes de ce client si nous ne mentionnons pas de date. 
Il faut donc fournir un nom de client et des dates, mais celles-ci sont optionnelles. 
Vous pouvez utilise la fenêtre "Customer list (CTRL C dans le menu) pour voir tous les noms de client. 

### Search 2 Customer by country
![image](https://user-images.githubusercontent.com/48365113/119389526-0816e300-bccc-11eb-88eb-3eae03fa3670.png)

Cette fenêtre permet d'afficher tous les clients pour un pays donné. Il y aura plusieurs pays disponibles dans le combo box. Lors de la sélection, la table est "refresh" pour afficher les clients pour le nouveau pays sélectionné.

### Search 3 by product
![image](https://user-images.githubusercontent.com/48365113/119389598-241a8480-bccc-11eb-85fc-7f855a6f8415.png)

Cette fenêtre permet d'afficher les commandes ou ce produit se retrouve, le nom du client de la commande en question, la quantité commandée et le moyen de payement utiliser. 

### Customer list
![image](https://user-images.githubusercontent.com/48365113/119389682-401e2600-bccc-11eb-8cc6-61a796f52bba.png)

Cette fenêtre est sans doute la plus **importante**. Elle permet d'effectuer toutes les opérations **CRUD** sur les clients.
Le bouton refresh permettra de refresh la table après l'ajout d'un client.
Pour supprimer un client, il suffit de le sélectionner dans la table et ensuite de cliquer sur "Delete customer"
L'ajout et l'édition d'un client enverront vers une fenêtre de formulaire permettant d'effectuer la tâche demandée.
Note : Le champ customer name et nickname n'ont pas été implémenter par manque de temps. Ils ne sont donc pas opérationnels. 

### Le formulaire
![image](https://user-images.githubusercontent.com/48365113/119389807-680d8980-bccc-11eb-9994-455c8034e03e.png)

Chaque champ suivi d'une *étoile* est un champ **obligatoire**. Une fois ceux-ci remplis (et correctement remplis) le client pourra être créé. 
Si un ou plusieurs champs ne répondent pas aux l'exigence. Alors les champs seront mis en rouge et expliqueront pourquoi la donnée entrée n'est pas bonne. 
Si l'on passe le curseur sur un champ à remplir, une petite indication montre la bonne manière de remplir le champ.
La fenêtre pou l'édition d'un client est sensiblement la même, les champs seront simplement près remplis des données du client et prête à être modifié. 
Un message de confirmation demandera à l'utilisateur s'il veut effectuer l'opération. Ce contrôle évitera tout malentendu. 
#### Le formulaire rempli
![image](https://user-images.githubusercontent.com/48365113/119509008-89c04c80-bd70-11eb-8624-79a757d8cb83.png)
![image](https://user-images.githubusercontent.com/48365113/119509160-ad839280-bd70-11eb-8da8-ebb84c7c2ce7.png)

### Product list
![image](https://user-images.githubusercontent.com/48365113/119389992-aacf6180-bccc-11eb-8b5f-069c47c9f443.png)

Cette fenêtre est un simple affichage de tous les produits de l'entreprise. Elle sera utile pour obtenir toutes les informations que l'utilisateur jugera nécessaires pour les opérations sur le produit.

### Statistics
![image](https://user-images.githubusercontent.com/48365113/119390101-d5b9b580-bccc-11eb-850d-c4329e51dc7c.png)

Cette fenêtre correspond à la tâche métier. Elle affichera des statistiques élémentaires sur l'entreprise avec par exemple "Company profit" qui correspond au chiffre d'affaires (et non au bénéfice" de l'entreprise).
En sélectionnant un produit en en cliquant sur "Search" nous obtiendrons la représentativité de ce produit sur l'ensemble des achats ainsi que son prix total de ventes cumulé.


## Feedback
Un premier feedback à été données par notre professeur le 18/05/2021. Voici les modifications commentés.

* Vérification sur l'iban dans le formulaire :
  * Cette vérification oblige l'utilisateur à rentré un iban correcte composé de 3 ou 4 chiffres après le code du pays et la clef de contrpole (certains pays sont composé de 4 chiffres après la cléf, la belgique elle est composé de 3 chiffres).
* Registration date :
  * Lors de la création d'un client, il faut indiqué la date de création du client. Maintenant si la date est supérieure à celle du jour alors un message d'erreur apparait et empêche la continuité du formulaire.
* Sélection de plusieurs lignes dans un jTable :
  * Il n'est désormais plus possible de sélectionner plusieurs lignes dans la table customerList. Ainsi lors de la suppression d'un client, seul le client sélectionné sera supprimé après confirmation.
* Affiché une confirmation avant la suppression d'un client :
  * Une confirmation lors de la suppression d'un client a été implémentée pour éviter les erreurs.
* Autocomplete pour la recherche 3 :
  * Nous avons finalement opté pour proposé à l'utilisateur une JComboBox avec les produits disponibles pour leur sélection.
* SQL n'accepte pas les '
  * Nous n'avons malheureusement pas eu le temps de ce penché sur ce problème. En effet lorsque l'on introduit, par exemple, Rue de l'eau ne peut pas être ajouté, car une ' est dedans et que la nous utilisons un PreparedStatement qui empêche les injections et donc supprime-les '. 
