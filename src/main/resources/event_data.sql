CREATE DATABASE IF NOT EXISTS coffee_house;

DROP TABLE IF EXISTS ch_events;
DROP TABLE IF EXISTS ch_orders;

CREATE TABLE ch_events (
    id BIGSERIAL PRIMARY KEY,
    order_id BIGINT REFERENCES ch_orders (id),
    client_id BIGINT,
    employee_id BIGINT NOT NULL,
    expected_time TIME,
    product_id BIGINT,
    price DECIMAL,
    reason VARCHAR(128),
    event_type VARCHAR(50),
    date_time TIMESTAMP NOT NULL
);

CREATE TABLE ch_orders (
    id BIGSERIAL PRIMARY KEY,
    order_status VARCHAR(50) NOT NULL,
    order_time TIMESTAMP NOT NULL
);

