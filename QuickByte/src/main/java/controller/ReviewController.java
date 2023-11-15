package controller;

import domain.Review;
import repo.inMemory.InMemoryRepo;

public class ReviewController extends EntityController<Review>{
    public ReviewController(InMemoryRepo<Review> repository) {
        super(repository);
    }
}
