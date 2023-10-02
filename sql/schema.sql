CREATE TABLE hotelandes_client
(
    id NUMBER(19) GENERATED ALWAYS AS IDENTITY PRIMARY KEY
);

CREATE TABLE hotelandes_user_role
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
    FOREIGN KEY (client_id) REFERENCES hotelandes_client (id)
);

CREATE TABLE hotelandes_client_account
(
    id              NUMBER(19) PRIMARY KEY,
    room_booking_id VARCHAR2(32 CHAR) NOT NULL,
    state           VARCHAR2(8 CHAR)  NOT NULL CHECK ( state in ('OPEN', 'CLOSE') ),
    FOREIGN KEY (room_booking_id) REFERENCES hotel_room_booking (id)
);

CREATE TABLE hotelandes_account_consumption
(
    id               NUMBER(19) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    account_id       NUMBER(19)        NOT NULL,
    consumption_date DATE              NOT NULL,
    description      VARCHAR2(64 CHAR) NOT NULL,
    cost             NUMBER(19, 4)     NOT NULL
);

COMMIT;
CREATE TABLE hotelandes_user
(
    id          NUMBER(19) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_type       VARCHAR2(2 CHAR)  NOT NULL,
    id_number     VARCHAR2(16 CHAR) NOT NULL,
    password     VARCHAR2(64 CHAR) NOT NULL,
    name         VARCHAR2(32 CHAR) NOT NULL,
    email        VARCHAR2(64 CHAR) NOT NULL UNIQUE,
    role_id      NUMBER(2)         NOT NULL,
    FOREIGN KEY (role_id) REFERENCES user_role (id)
);

CREATE TABLE hotelandes_sede
(
    id          NUMBER(19) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name        VARCHAR2(32 CHAR) NOT NULL,
    city        VARCHAR2(32 CHAR) NOT NULL,
    address     VARCHAR2(32 CHAR) NOT NULL,
    rating      NUMBER(19)
)

CREATE TABLE hotelandes_service
(
    id          NUMBER(19) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name        VARCHAR2(32 CHAR) NOT NULL,
    description VARCHAR2(64 CHAR) NOT NULL,
    opening_time DATE              NOT NULL,
    closing_time DATE              NOT NULL,
    hotel_id   NUMBER(19)        NOT NULL,
    FOREIGN KEY (hotel_id) REFERENCES hotelandes_sede (id)
);

DROP TABLE client PURGE;
DROP TABLE user_role PURGE;
DROP TABLE hotel_room_type PURGE;
DROP TABLE hotel_room PURGE;
DROP TABLE hotel_room_booking PURGE;
DROP TABLE user PURGE;
