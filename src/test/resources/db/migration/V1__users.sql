CREATE TABLE users
(
    id SERIAL,
    name varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);