CREATE TABLE user_role
(
    id          NUMBER(3) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    role        VARCHAR(32 CHAR) NOT NULL,
    description VARCHAR(32 CHAR)
);
