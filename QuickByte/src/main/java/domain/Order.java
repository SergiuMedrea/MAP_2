package domain;

import java.sql.Timestamp;

public record Order(int orderID,
                    int userID,
                    int courierID,
                    int addressID,
                    Timestamp dateTime) {
}
