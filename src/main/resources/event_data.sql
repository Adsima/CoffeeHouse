DROP TABLE IF EXISTS ch_events;

CREATE TABLE ch_events (
    event_id SERIAL PRIMARY KEY,
    employee_id INT NOT NULL,
    client_id INT,
    product_id INT,
    product_cost INT,
    expected_time TIME,
    reason VARCHAR(128),
    event_type VARCHAR(50),
    order_id INT NOT NULL,
    time TIMESTAMP NOT NULL
);