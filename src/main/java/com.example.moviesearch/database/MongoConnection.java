public class MongoConnection {

    private MongoClient mongoClient;

    public MongoConnection(String host, int port) {
        mongoClient = new MongoClient(host, port);
    }

    public MongoClient getClient() {
        return mongoClient;
    }

    public void close() {
        mongoClient.close();
    }

}
