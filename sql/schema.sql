CREATE TABLE client
(
    id NUMBER(19) GENERATED ALWAYS AS IDENTITY PRIMARY KEY
);

CREATE TABLE user_role
(
    id          NUMBER(2) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    role        VARCHAR(32 CHAR) NOT NULL,
    description VARCHAR(32 CHAR)
);

CREATE TABLE hotel_room_type
(
    id                         NUMBER(2) PRIMARY KEY,
    name                       VARCHAR2(16 CHAR) NOT NULL,
    description                VARCHAR2(32 CHAR),
    cost_per_night             NUMBER(10, 2)     NOT NULL,
    suggested_minimum_capacity NUMBER(2)         NOT NULL,
    suggested_maximum_capacity NUMBER(2)         NOT NULL
);

CREATE TABLE hotel_room
(
    id           NUMBER(10) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name         VARCHAR2(16 CHAR) NOT NULL UNIQUE,
    room_type_id NUMBER(2)         NOT NULL,
    FOREIGN KEY (room_type_id) REFERENCES hotel_room_type (id)
);

CREATE TABLE hotel_room_booking
(
    id                  VARCHAR2(32 CHAR) PRIMARY KEY,
    client_id           NUMBER(19),
    hotel_room_id       NUMBER(10) NOT NULL,
    check_in            DATE       NOT NULL,
    check_out           DATE       NOT NULL,
    capacity            NUMBER(1)  NOT NULL,
    consumption_plan_id NUMBER(3),
    FOREIGN KEY (hotel_room_id) REFERENCES hotel_room (id),
    FOREIGN KEY (client_id) REFERENCES client (id)
);

DROP TABLE client PURGE;
DROP TABLE user_role PURGE;
DROP TABLE hotel_room_type PURGE;
DROP TABLE hotel_room PURGE;
DROP TABLE hotel_room_booking PURGE;
