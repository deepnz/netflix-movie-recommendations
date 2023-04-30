public interface SearchQueryRepository extends MongoRepository<SearchQuery, String> {
    List<SearchQuery> findByUser(User user);
    List<SearchQuery> findByUserAndTagsContaining(User user, String tag);
    List<SearchQuery> findByUserAndTimestampBetween(User user, Date startDate, Date endDate);
    List<SearchQuery> findDistinctByTagsIn(List<String> tags);
}
