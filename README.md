# Gestion de fichiers HDFS avec Java

Ce projet permet d'interagir avec HDFS en utilisant Java pour effectuer diverses opérations comme la création de répertoires, la gestion des fichiers et la récupération de métadonnées.

## Prérequis

- Avoir Docker et Docker Compose installés sur votre machine.
- Avoir Java installé et configuré.
- Cloner ce dépôt Git.

## Installation

1. Exécuter le fichier `docker-compose.yaml` pour déployer l'environnement Hadoop :
   ```sh
   docker-compose up -d
   ```
2. Compiler et générer les fichiers `.jar` pour chaque application Java :
   ```sh
   mvn clean package
   ```

## Fonctionnalités

Les fonctionnalités suivantes sont implémentées en Java pour interagir avec HDFS :

1. **Créer un répertoire dans HDFS**
   - `/user/hadoop/appData` s'il n'existe pas.
2. **Lister tous les fichiers et répertoires**
   - Afficher le contenu du répertoire `/user/hadoop/appData`.
3. **Créer et écrire un fichier dans HDFS**
   - `data.txt` contenant le texte : "Bienvenue sur HDFS avec Java.".
4. **Lire et afficher le contenu d’un fichier**
   - `/user/hadoop/appData/data.txt`.
5. **Copier un fichier local vers HDFS**
   - Copier `test.txt` depuis le système local vers `/user/hadoop/appData/test.txt`.
6. **Télécharger un fichier depuis HDFS**
   - Télécharger `/user/hadoop/appData/test.txt` vers le système local.
7. **Renommer un fichier dans HDFS**
   - Renommer `/user/hadoop/appData/data.txt` en `/user/hadoop/appData/data_v1.txt`.
8. **Supprimer un fichier dans HDFS**
   - Supprimer `/user/hadoop/appData/data_v1.txt`.
9. **Récupérer les métadonnées d’un fichier**
   - Métadonnées du fichier `/user/hadoop/appData/test.txt`.
10. **Vérifier l’espace disponible dans HDFS**
    - Afficher l’espace disque disponible.
11. **Déplacer un fichier vers un sous-répertoire**
    - Déplacer `/user/hadoop/appData/test.txt` vers `/user/hadoop/archive/`.
12. **Écrire un fichier CSV dans HDFS**
    - Un fichier `products.csv` contenant une liste de produits (ID, Nom, Prix) est écrit dans `/user/hadoop/appData/`.
13. **Lire un fichier CSV depuis HDFS**
    - Lire et afficher ligne par ligne le fichier `/user/hadoop/appData/products.csv`.

## Exécution

Chaque fonctionnalité est implémentée sous forme d'application Java. Pour exécuter une application, utilisez la commande suivante :
```sh
java -jar jars/<nom-de-l'application>.jar
```
