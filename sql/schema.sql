CREATE TABLE user_role
(
    id          NUMBER(2) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    role        VARCHAR(32 CHAR) NOT NULL,
    description VARCHAR(32 CHAR)
);

CREATE TABLE hotel_room_type
(
    id NUMBER(2) PRIMARY KEY,
    name VARCHAR2(16) NOT NULL,
    description VARCHAR2(32),
    cost_per_night NUMBER(10, 2) NOT NULL ,
    suggested_minimum_capacity NUMBER(2) NOT NULL,
    suggested_maximum_capacity NUMBER(2) NOT NULL
);

CREATE TABLE hotel_room
(
    id NUMBER(3) NOT NULL PRIMARY KEY,
    room_type_id NUMBER(2) NOT NULL,
    FOREIGN KEY(room_type_id) REFERENCES hotel_room_type(id)
);

DROP TABLE user_role PURGE;
DROP TABLE hotel_room_type PURGE;
DROP TABLE hotel_room PURGE;
