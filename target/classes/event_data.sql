CREATE DATABASE IF NOT EXISTS coffee_house;

DROP TABLE IF EXISTS ch_events;

CREATE TABLE ch_events (
    event_id SERIAL PRIMARY KEY,
    order_id INT NOT NULL,
    client_id INT,
    employee_id INT NOT NULL,
    expected_time TIME,
    product_id INT,
    product_cost INT,
    reason VARCHAR(128),
    event_type VARCHAR(50),
    date_time TIMESTAMP NOT NULL
);