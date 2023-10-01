-- CRUD
-- CREATE
INSERT INTO hotel_room_booking(id, client_id, hotel_room_id, check_in, check_out, capacity, consumption_plan_id)
VALUES ('Here goes an UUIDv4', 1, 1, NULL, NULL, 1, 1);

-- READ
SELECT id,
       client_id,
       room_booking_id,
       check_in,
       check_out,
       capacity,
       consumption_plan_id
FROM hotel_room_booking
WHERE id = 1;

SELECT id,
       client_id,
       hotel_room_id,
       check_in,
       check_out,
       capacity,
       consumption_plan_id
FROM hotel_room_booking;

-- UPDATE
UPDATE
    hotel_room_booking
SET client_id           = 1,
    room_booking_id     = 1,
    check_in            = NULL,
    check_out           = NULL,
    capacity            = 40,
    consumption_plan_id = 1
WHERE id = 1;

-- DELETE
DELETE
FROM hotel_room_booking
WHERE id = 1;
