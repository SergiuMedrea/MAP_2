-- Insert a new address for a user placing an order at a restaurant
INSERT INTO Addresses (street, postalCode, city, country) VALUES ('Strada Florilor', '12345', 'Orasul Mare', 'Romania');
-- Insert a new user tied to the address
INSERT INTO Users (addressID, firstName, lastName, phoneNumber) VALUES (1, 'Ana', 'Ionescu', '555-1234');
-- Insert a new order for the user at the restaurant
INSERT INTO Orders (userID, addressID, dateTime) VALUES (1, 1, NOW());
-- Insert items in the order
INSERT INTO OrderMenuItems (orderID, menuItemID, quantity) VALUES (1, 1, 2);


-- Insert a new address for a courier delivering an order
INSERT INTO Addresses (street, postalCode, city, country) VALUES ('Strada Mihai Viteazu', '67890', 'Orasul Mic', 'Romania');
-- Insert a new courier tied to the address
INSERT INTO Couriers (addressID, firstName, lastName, phoneNumber, vehicleType) VALUES (2, 'Mihai', 'Popescu', '555-5678', 'Bicicleta');
-- Insert a new order for the courier delivering
INSERT INTO Orders (courierID, addressID, dateTime) VALUES (2, 2, NOW());
-- Insert items in the orderl
INSERT INTO OrderMenuItems (orderID, menuItemID, quantity) VALUES (2, 3, 1);


-- Insert a new address for a restaurant, a menu category, a menu item, and a discount
INSERT INTO Addresses (street, postalCode, city, country) VALUES ('Bulevardul Unirii', '54321', 'Orasul Frumos', 'Romania');
INSERT INTO Restaurants (addressID, name) VALUES (3, 'Delicii Gustoase');
INSERT INTO Categories (name, description) VALUES ('Aperitive', 'Gustari delicioase');
INSERT INTO MenuItems (categoryID, storeID, name, description, price) VALUES (1, 3, 'Paine cu Usturoi', 'Paine proaspata cu usturoi', 5);
INSERT INTO Discounts (storeID, name, description, startDate, endDate, discountPercentage) VALUES (3, 'Ora Fericita', '50% reducere la aperitive', NOW(), DATE_ADD(NOW(), INTERVAL 7 DAY), 50);


-- Insert a new address for a grocery store, a menu category, a menu item, and a review
INSERT INTO Addresses (street, postalCode, city, country) VALUES ('Strada Plopilor', '98765', 'Orasul Alimentelor', 'Romania');
INSERT INTO GroceryStores (addressID, name) VALUES (4, 'Proaspat Mart');
INSERT INTO Categories (name, description) VALUES ('Fructe si Legume', 'Fructe si legume proaspete');
INSERT INTO MenuItems (categoryID, storeID, name, description, price) VALUES (2, 4, 'Banane', 'Coapte si gustoase', 2);
INSERT INTO Reviews (userID, storeID, rating, comment) VALUES (1, 4, 5, 'O selectie excelenta de produse proaspete!');


-- Insert a new address for a user making a payment, a user, an order, and a receipt
INSERT INTO Addresses (street, postalCode, city, country) VALUES ('Strada Fagilor', '13579', 'Orasul Linistit', 'Romania');
INSERT INTO Users (addressID, firstName, lastName, phoneNumber) VALUES (5, 'Alexandru', 'Dumitrescu', '555-9876');
INSERT INTO Orders (userID, addressID, dateTime) VALUES (3, 5, NOW());
INSERT INTO Receipts (orderID, userID, amount, paymentType, accountInformation) VALUES (3, 3, 20, 'Card de Credit', '**** **** **** 1234');
