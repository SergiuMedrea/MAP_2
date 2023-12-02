create table Addresses
(
    addressID  int primary key AUTO_INCREMENT,
    street     varchar(64),
    postalCode varchar(64),
    city       varchar(64),
    country    varchar(64)
);

create table Categories
(
    categoryID  int primary key AUTO_INCREMENT,
    name        varchar(64),
    description varchar(128)
);

create table Users
(
    userID      int primary key AUTO_INCREMENT,
    addressID   int,
    firstName   varchar(64),
    lastName    varchar(64),
    phoneNumber varchar(64),
    foreign key (addressID) references Addresses (addressID)
);

create table Couriers
(
    userID      int primary key AUTO_INCREMENT,
    addressID   int,
    firstName   varchar(64),
    lastName    varchar(64),
    phoneNumber varchar(64),
    vehicleType varchar(64),
    foreign key (addressID) references Addresses (addressID)
);

create table Restaurants
(
    storeID int PRIMARY KEY AUTO_INCREMENT,
    addressID    int,
    name         varchar(64),
    foreign key (addressID) references Addresses (addressID)
);

create table GroceryStores
(
    storeID int PRIMARY KEY AUTO_INCREMENT,
    addressID    int,
    name         varchar(64),
    foreign key (addressID) references Addresses (addressID)
);

create table MenuItems
(
    menuItemID   int primary key AUTO_INCREMENT,
    categoryID   int,
    storeID int,
    name         varchar(64),
    description  varchar(128),
    price        int,
    foreign key (categoryID) references Categories (categoryID),
    foreign key (storeID) references Restaurants (storeID)
);

create table Orders
(
    orderID   int primary key AUTO_INCREMENT,
    userID    int,
    courierID int,
    addressID int,
    dateTime  datetime,
    foreign key (userID) references Users (userID),
    foreign key (courierID) references Couriers (userID),
    foreign key (addressID) references Addresses (addressID)
);

create table Discounts
(
    discountID         int primary key AUTO_INCREMENT,
    storeID       int,
    name               varchar(64),
    description        varchar(128),
    startDate          date,
    endDate            date,
    discountPercentage int,
    foreign key (storeID) references Restaurants (storeID)
);

create table OrderMenuItems
(
    orderID    int,
    menuItemID int,
    quantity   int,
    primary key (orderID, menuItemID),
    foreign key (orderID) references Orders (orderID),
    foreign key (menuItemID) references MenuItems (menuItemID)
);

create table Receipts
(
    orderID            int primary key,
    userID             int,
    amount             int,
    paymentType        varchar(64),
    accountInformation varchar(128),
    foreign key (orderID) references Orders (orderID),
    foreign key (userID) references Users (userID)
);

create table Reviews
(
    reviewID     int primary key AUTO_INCREMENT,
    userID       int,
    storeID int,
    rating       int,
    comment      varchar(128),
    foreign key (userID) references Users (userID),
    foreign key (storeID) references Restaurants (storeID)
);

delete from addresses;
delete from categories;
delete from couriers;
delete from discounts;
delete from grocerystores;
delete from menuitems;
delete from ordermenuitems;
delete from orders;
delete from receipts;
delete from restaurants;
delete from reviews;
delete from users;