# PokemonMatch

Toutes vos classes doivent être dans le package fr.uge.jee.springmvc.pokematch.

Cet exercice est une sorte de mini projet. On veut réaliser une application web qui permet à un visiteur de rentrer son nom et son prénom et qui va lui afficher (sur la même page) son pokémon fétiche. Pour trouver le pokémon fétiche de l'utilisateur on cherchera le pokémon dont le hashcode du nom est le plus proche en valeur absolue du hashcode du nom+prénom du visiteur.

L'application récupèrera au démarrage la liste de tous les pokémons sur l'excellente API rest https://pokeapi.co/api/v2/.

Pendant le développement de votre application, ne récupérer que les 40 premiers pokemons de manière à ne pas surcharger l'API.

La classe WebClient utilise un buffer de taille fixe pour lire les réponses HTTP. Si la réponse ne tient pas dans le buffer, vous obtiendrez une exception. Pour éviter ce problème, on peut configurer le WebClient à sa création:

@Bean
WebClient getWebClient(WebClient.Builder defaultBuilder) {
    return defaultBuilder.exchangeStrategies(ExchangeStrategies.builder()
            .codecs(configurer -> configurer
                    .defaultCodecs()
                    .maxInMemorySize(16 * 1024 * 1024)).build()).build();
}
SpringBoot possède un bean de type WebClient.Builder qui est déjà pré-configuré. Et l'on rajoute notre agrandissement du buffer de réception à cette configuration.

Réalisez cette application. On vous demande de vérifier que les noms et prénoms entrés par l'utilisateur ne comporte que des lettres minuscules ou majuscules.

On veut maintenant que le site affiche les 10 pokémons qui ont été le plus souvent désignés comme pokémon fétiche sur tous les visiteurs du serveur. La valeur 10 est un constante de l'application qui doit pouvoir être modifiée dans un fichier de propriétés.

Pensez bien à rendre vos classe thread-safe quand c'est nécessaire.

Faites évoluer l'application.

On veut enfin que le site affiche l'image du pokémon fétiche. On utilisera l'image dont le url se trouve dans le champ front_default du champ sprites des informations détaillées du pokémon. Les pokémons qui n'ont pas cette image seront ignorés.

Faites évoluer l'application.

Idéalement, on voudrait que les images soient servies aux clients par notre site et pas par le site de l'API Pokémon. On va donc faire un cache des images. On ne veut pas télécharger toutes les images au démarrage. Quand un client nous demande une image pour la première fois, on l'a télécharge et on la stocke en mémoire. La prochaine fois qu'un client demande cette image, on lui renvoie l'image stockée en mémoire.

Faites évoluer l'application.

Bonus Il y a plusieurs endroits où l'on peut rendre notre code efficace d'un point de vue algorithmique. La recherche du Pokémon fétiche peut se faire en O(ln(n)) où n est le nombre total de pokémons. L'incrément du nombre de fois qu'un Pokémon a été choisi comme Pokémon fétiche peut se faire en O(1) et le calcul du N Pokémons les plus choisis peut se faire en O(N) mais ce n'est pas facile.

Bonus La récupération des informations détaillées des pokémons est assez longue. En effet, on demande les informations les unes après les autres. On peut tirer partie du fait que WebClient est non-bloquant pour demander plusieurs images en même temps. L'idée est de créer un Flux à partir de toutes les requêtes grâce à Flux.merge.
