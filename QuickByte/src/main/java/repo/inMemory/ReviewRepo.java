package repo.inMemory;

import domain.Review;

public class ReviewRepo extends InMemoryRepo<Review> {
    private static ReviewRepo instance = null;

    private ReviewRepo() {
    }

    public static ReviewRepo getInstance() {
        if (instance == null) {
            instance = new ReviewRepo();
        }

        return instance;
    }
}
