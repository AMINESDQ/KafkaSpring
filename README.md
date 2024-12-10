
# TP : Projet Kafka avec Docker et Spring Cloud Streams

## Objectifs

- Mettre en place une architecture Kafka en utilisant Docker
- Créer des services producteur, consommateur et fournisseur de données Kafka
- Implémenter un service de traitement de flux de données en temps réel avec Kafka Streams
- Créer une application web pour afficher les résultats du traitement en temps réel

## Exercices

### Exercice 1 : Configuration Docker

1. Créez le fichier `docker-compose.yml` pour démarrer les conteneurs Zookeeper et Kafka.

```yaml
version: "3"
networks:
  myNetwork:

services:

  zookeeper:
    image: 'bitnami/zookeeper:latest'
    ports:
      - '2181:2181'
    environment:
      - ALLOW_ANONYMOUS_LOGIN=yes
    networks:
      - myNetwork

  kafka:
    image: 'bitnami/kafka:latest'
    user: root
    ports:
      - '9092:9092'
    environment:
      - KAFKA_BROKER_ID=1
      - KAFKA_LISTENERS=PLAINTEXT://:9092
      - KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://127.0.0.1:9092
      - KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181
      - ALLOW_PLAINTEXT_LISTENER=yes
    volumes:
      - ./Kafka:/bitnami/kafka
    networks:
      - myNetwork
    depends_on:
      - zookeeper
```

2. Démarrez les conteneurs Docker :

```bash
docker-compose up -d
```

3. Testez le fonctionnement de Kafka avec les commandes `kafka-console-producer` et `kafka-console-consumer`.

### Exercice 2 : Service Producer Kafka

Créez un service REST qui produit des données dans un topic Kafka. Utilisez l'image `consumer.png` comme guide.

1. Définissez un contrôleur REST qui expose un endpoint pour publier des messages dans un topic Kafka.
2. Utilisez les bibliothèques Spring Cloud Streams et Kafka Streams pour interagir avec Kafka.
3. Testez votre service en envoyant des requêtes HTTP et vérifiez que les messages sont bien consommés par le topic Kafka.

### Exercice 3 : Service Consumer Kafka

Créez un service qui consomme les données du topic Kafka. Utilisez l'image `create_topic.png` comme guide.

1. Implémentez un service qui écoute les messages du topic Kafka et les affiche dans les logs.
2. Assurez-vous que le service démarre correctement et consomme les messages produits par le service producteur.

### Exercice 4 : Service Supplier Kafka

Créez un service qui fournit des données à publier dans le topic Kafka. Utilisez l'image `producer.png` comme guide.

1. Implémentez un service qui génère aléatoirement des données et les envoie dans le topic Kafka.
2. Vérifiez que les messages générés sont bien consommés par le service consommateur.

### Exercice 5 : Service de Data Analytics Real Time Stream Processing

Créez un service qui traite en temps réel les données du topic Kafka. Utilisez l'image `StreamDataRead.png` comme guide.

1. Implémentez un service qui consomme les messages du topic Kafka et effectue des analyses en temps réel.
2. Affichez les résultats des analyses dans les logs.

### Exercice 6 : Application Web

Créez une application web qui affiche en temps réel les résultats du traitement de flux de données. Utilisez les images `PostmanSendMessagetoTopic.png` et `Docker-Container.png` comme guides.

1. Créez une application web qui se connecte aux services Kafka et affiche les résultats des analyses en temps réel.
2. Utilisez les bibliothèques Spring Cloud Streams et Kafka Streams pour interagir avec les services Kafka.
3. Testez votre application web en envoyant des messages dans le topic Kafka et vérifiez que les résultats s'affichent correctement.

## Bonus

- Ajoutez des tests unitaires et d'intégration pour vos services Kafka.
- Mettez en place des alertes et des métriques pour surveiller votre architecture Kafka.
- Implémentez des fonctionnalités avancées comme la réplication, le partitionnement ou la gestion des offsets.

N'hésitez pas à me contacter si vous avez d'autres questions !
