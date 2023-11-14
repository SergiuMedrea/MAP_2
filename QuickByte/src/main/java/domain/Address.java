package domain;

public record Address(Long addressID,
                      String street,
                      String postalCode,
                      String city,
                      String country) {
}
