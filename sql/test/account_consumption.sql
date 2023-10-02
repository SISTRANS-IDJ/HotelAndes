-- CRUD
-- CREATE
INSERT INTO hotelandes_account_consumption(account_id, service_id, consumption_date, description, cost)
VALUES (1, 1, TO_DATE('1990-12-12', 'yyyy-mm-dd'), 'test', 103.12);

-- READ
SELECT id, account_id, service_id, consumption_date, description, cost
FROM hotelandes_account_consumption
WHERE id = 1;

SELECT id, account_id, service_id, consumption_date, description, cost
FROM hotelandes_account_consumption;

-- UPDATE
UPDATE hotelandes_account_consumption
SET account_id       = 1,
    service_id       = 1,
    consumption_date = TO_DATE('1990-12-13', 'yyyy-mm-dd'),
    description      = 'test change',
    cost             = 3232.123
WHERE id = 1;

-- DELETE
DELETE
FROM hotelandes_account_consumption
WHERE id = 1;
