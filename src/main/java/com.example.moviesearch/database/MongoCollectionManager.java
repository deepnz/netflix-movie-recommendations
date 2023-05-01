import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.List;

public class MongoCollectionManager {
    private final MongoCollection<Document> collection;

    public MongoCollectionManager(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    public void insertOne(Document document) {
        collection.insertOne(document);
    }

    public void insertMany(List<Document> documents) {
        collection.insertMany(documents);
    }

    public void updateOne(Document filter, Document update) {
        collection.updateOne(filter, update);
    }

    public void deleteOne(Document filter) {
        collection.deleteOne(filter);
    }

    public List<Document> find(Document filter) {
        return collection.find(filter).into(new ArrayList<>());
    }

    public Document findOne(Document filter) {
        return collection.find(filter).first();
    }

    public boolean exists(Document filter) {
        return collection.countDocuments(filter) > 0;
    }

    public List<Document> findAll() {
        return collection.find().into(new ArrayList<>());
    }
}
