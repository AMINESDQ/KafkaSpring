
# TP : Projet Kafka avec Docker et Spring Cloud Streams

## Objectifs

- Mettre en place une architecture Kafka en utilisant Docker
- Créer des services producteur, consommateur et fournisseur de données Kafka
- Implémenter un service de traitement de flux de données en temps réel avec Kafka Streams
- Créer une application web pour afficher les résultats du traitement en temps réel

## Exercices

### Exercice 1 :

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
![create_topic](images/Docker-Container.png )

3. Testez le fonctionnement de Kafka avec les commandes `kafka-console-producer` et `kafka-console-consumer`.

  ![create_topic](images/create_topic.png)
  ![create_topic](images/consumer.png)
  ![create_topic](images/producer.png)
### Exercice  :  
# 1-Une application Web qui permet d'afficher les résultats du Stream Data Analytics en temps réel

![create_topic](images/PostmanSendMessagetoTopic.png)
![create_topic](images/StreamDataRead.png)

