-- CRUD
-- CREATE
INSERT INTO hotel_room(name, room_type_id)
VALUES ('test room', 1);

-- READ
SELECT id, name, room_type_id
FROM hotel_room
WHERE id = 1;

SELECT id, name, room_type_id
FROM hotel_room;

-- UPDATE
UPDATE hotelandes_user_role
SET role        = 'TEST_ROLE_UPDATED',
    description = 'Test role was updated'
WHERE id = 1;

-- DELETE
DELETE
FROM hotelandes_user_role
WHERE id = 1;
