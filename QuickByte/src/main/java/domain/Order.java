package domain;

import java.sql.Date;

public record Order(Long orderID, Date date, Long userID, Long courierID, Long addressID) {
}
