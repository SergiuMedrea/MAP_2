package domain;

public record Restaurant(int restaurantID,
                         int addressID,
                         String name) implements Identifiable<Integer>{
    @Override
    public Integer getId() {
        return restaurantID;
    }
}
