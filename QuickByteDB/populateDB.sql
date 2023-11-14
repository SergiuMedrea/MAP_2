INSERT INTO Addresses (street, postalCode, city, country)
VALUES ('Strada Florilor 23', '300123', 'București', 'România'),
       ('Bulevardul Unirii 45', '400456', 'Timișoara', 'România'),
       ('Aleea Frunzelor 12', '700789', 'Cluj-Napoca', 'România'),
       ('Piața Victoriei 8', '600987', 'Iași', 'România'),
       ('Calea Victoriei 34', '800234', 'Brașov', 'România');

INSERT INTO Categories (name, description)
VALUES ('Aperitive', 'Începeți masa cu aceste opțiuni delicioase'),
       ('Fel Principal', 'Feluri de mâncare delicioase pentru masa principală'),
       ('Deserturi', 'Bunătăți dulci pentru a vă satisface pofta'),
       ('Băuturi', 'Băuturi răcoritoare pentru orice ocazie'),
       ('Specialități', 'Creații speciale ale șefului pentru o experiență unică');

INSERT INTO Users (addressID, firstName, lastName, phoneNumber)
VALUES (1, 'Ana', 'Popescu', '0721-345-678'),
       (2, 'Andrei', 'Ionescu', '0733-987-654'),
       (3, 'Elena', 'Dumitru', '0766-111-222'),
       (4, 'Mihai', 'Georgescu', '0744-333-555'),
       (5, 'Ioana', 'Constantin', '0788-666-999');

INSERT INTO Couriers (addressID, firstName, lastName, phoneNumber, vehicleType)
VALUES (2, 'Radu', 'Vasilescu', '0721-888-111', 'Mașină'),
       (3, 'Larisa', 'Mihai', '0766-333-444', 'Bicicletă'),
       (1, 'Ștefan', 'Popa', '0744-555-777', 'Motocicletă'),
       (5, 'Cristina', 'Iacob', '0788-999-222', 'Scuter'),
       (4, 'Andrei', 'Dinu', '0733-222-555', 'Mașină');

INSERT INTO Restaurants (addressID, name)
VALUES (1, 'MC'),
       (2, 'Crispy Store'),
       (3, 'Cartofisserie'),
       (4, 'KFC'),
       (5, 'Spartan');

INSERT INTO MenuItems (categoryID, restaurantID, name, description, price)
VALUES (1, 1, 'Bruschetta', 'Paine prajita cu rosii, usturoi si busuioc', 15),
       (2, 2, 'Burger Sizzling', 'Chifla pufoasa, carne suculenta, sosuri speciale', 25),
       (3, 3, 'Tiramisu', 'Straturi de piscoturi insiropate cu cafea si crema de mascarpone', 18),
       (4, 4, 'Fresh de Portocale', 'Suc proaspat de portocale stoarse la comanda', 8),
       (5, 5, 'Specialitate Chef', 'Preparat special al sefului cu ingrediente deosebite', 30);

INSERT INTO Orders (userID, courierID, addressID, dateTime)
VALUES (1, 1, 1, '2023-11-14 12:30:00'),
       (2, 2, 2, '2023-11-14 13:45:00'),
       (3, 3, 3, '2023-11-14 18:00:00'),
       (4, 4, 4, '2023-11-14 20:15:00'),
       (5, 5, 5, '2023-11-14 21:30:00');

INSERT INTO Discounts (restaurantID, name, description, startDate, endDate, discountPercentage)
VALUES (1, 'Happy Hour', 'Reducere la toate băuturile', '2023-11-14', '2023-11-15', 20),
       (2, 'Săptămâna Burgerilor', 'Preț special la toate tipurile de burgeri', '2023-11-14', '2023-11-21', 15),
       (3, 'Dulciuri Delicioase', 'Reducere la toate deserturile', '2023-11-14', '2023-11-16', 10),
       (4, 'Comandă Dublă', 'Reducere pentru comenzi de minim 2 feluri de mâncare', '2023-11-14', '2023-11-17', 25),
       (5, 'Specialitatea Săptămânii', 'Preț special pentru preparatul săptămânii', '2023-11-14', '2023-11-15', 30);

INSERT INTO OrderMenuItems (orderID, menuItemID, quantity)
VALUES (1, 1, 2),
       (2, 2, 1),
       (3, 3, 3),
       (4, 4, 2),
       (5, 5, 1);

INSERT INTO Receipts (orderID, userID, amount, paymentType, accountInformation)
VALUES (1, 1, 50, 'Card', '**** **** **** 1234'),
       (2, 2, 25, 'Cash', null),
       (3, 3, 54, 'Card', '**** **** **** 5678'),
       (4, 4, 32, 'Cash', null),
       (5, 5, 30, 'Card', '**** **** **** 9012');

INSERT INTO Reviews (userID, restaurantID, rating, comment) VALUES
(1, 1, 4, 'Mâncare gustoasă, livrare promptă'),
(2, 2, 5, 'Burgerul este absolut delicios!'),
(3, 3, 3, 'Dulciurile sunt bune, dar prețurile sunt cam mari'),
(4, 4, 4, 'Am comandat de mai multe ori și sunt mulțumit'),
(5, 5, 5, 'Preparatele chef-ului sunt cu adevărat speciale!');

