package controller;

import domain.Review;

public class ReviewController extends EntityController<Review>{
    private static ReviewController instance = null;

    private ReviewController(){}

    public static ReviewController getInstance() {
        if (instance == null) {
            instance = new ReviewController();
        }

        return instance;
    }
}
