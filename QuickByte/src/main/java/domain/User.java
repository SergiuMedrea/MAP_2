package domain;

public record User(int userID,
                   int addressID,
                   String firstName,
                   String lastName,
                   String phoneNumber) {
}
