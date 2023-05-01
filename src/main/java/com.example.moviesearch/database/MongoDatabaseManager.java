import com.mongodb.client.MongoDatabase;

public class MongoDatabaseManager {
    private final MongoDatabase database;

    public MongoDatabaseManager(MongoConnection mongoConnection, String databaseName) {
        this.database = mongoConnection.getClient().getDatabase(databaseName);
    }

    public MongoCollectionManager getCollection(String collectionName) {
        return new MongoCollectionManager(database.getCollection(collectionName));
    }

    public void createCollection(String collectionName) {
        database.createCollection(collectionName);
    }

    public void dropCollection(String collectionName) {
        database.getCollection(collectionName).drop();
    }
}
