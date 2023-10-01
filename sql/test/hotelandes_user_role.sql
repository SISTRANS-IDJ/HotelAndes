-- CRUD
-- CREATE
INSERT INTO hotelandes_user_role (role,
                                  description)
VALUES ('TEST_ROLE',
        'This is a test role description');
-- READ
SELECT id,
       role,
       description
FROM hotelandes_user_role
WHERE id = 1;

SELECT id, role, description
FROM hotelandes_user_role;

-- UPDATE
UPDATE hotelandes_user_role
SET role        = 'TEST_ROLE_UPDATED',
    description = 'Test role was updated'
WHERE id = 1;

-- DELETE
DELETE
FROM hotelandes_user_role
WHERE id = 1;
