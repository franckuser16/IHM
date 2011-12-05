On souhaite réaliser un convertisseur de mesures entre les systèmes métrique et impérial. 

L'application fournie devra proposer un convertisseur de longueurs et un de volumes (les unités et les constantes de conversion sont données ci-dessous), mais devra pouvoir être étendue à d'autres mesures (surfaces, volumes, températures...) avec un coût de développement le plus faible possible et sans duplication de code (ou en tout cas le minimum).

En outre, elle devra être fournie avec 2 possibilités de visualisation (vues) différentes, l'une s'inspirant de celle demandée dans la Feuille n°5 (cf les captures d'écran ci-dessous), une autre laissée à votre imagination (un exemple d'une interface différente peut être vu ici. Mais vous avez toute latitude pour en créer une à votre convenance.

Enfin l'application devra permettre de choisir de contrôler chacune des vues, soit uniquement avec le clavier, soit uniquement avec la souris, soit avec les deux.

Pour réaliser tout ceci, un premier conseil : il faut bien découper l'application et en distinguer les différentes parties :

        les conversions proprement dites qui sont complètement indépendantes de l'interface graphique,
	les vues qui ne définissent que l'aspect visuel et en aucun cas les interactions avec l'utilisateur
	la gestion des interactions, avec d'une part les écouteurs d'événements appropriés et d'autre part une "spécialisation" des vues par ajout de la gestion des événements.

	Ce travail devra être réalisé à deux. Vous devrez rendre un rapport présentant l'architecture de votre programme et les explications nécessaires pour tout développeur souhaitant enrichir votre application. Vous fournirez également un manuel utilisateur et le code source. Vous vous partagerez l'écriture du code. Notamment, chacun de vous se chargera d'une vue différente et des contrôles associés.
