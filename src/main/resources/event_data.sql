CREATE DATABASE IF NOT EXISTS coffee_house;

DROP TABLE IF EXISTS ch_events;

CREATE TABLE ch_events (
    id BIGSERIAL PRIMARY KEY,
    order_id BIGINT REFERENCES ch_orders (id),
    client_id BIGINT,
    employee_id BIGINT NOT NULL,
    expected_time TIMESTAMP,
    product_id BIGINT,
    price DECIMAL,
    reason VARCHAR(128),
    event_type VARCHAR(50),
    date_time TIMESTAMP NOT NULL
);


