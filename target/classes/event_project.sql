--Add an order
INSERT INTO ch_order (id, order_status, order_time)
VALUES (?, ?, ?);

--Registered event
INSERT INTO ch_events (id, client_id,
employee_id, expected_time, product_id,
price, date_time)
VALUES (?, ?, ?, ?, ?, ?, ?);

--Cancelled event
INSERT INTO ch_events (id, employee_id, reason, date_time)
VALUES(?, ?, ?, ?);

--Started event
INSERT INTO ch_events (id, employee_id, date_time)
VALUES(?, ?, ?);

--Ready event
INSERT INTO ch_events (id, employee_id, date_time)
VALUES(?, ?, ?);

--Completed event
INSERT INTO ch_events (id, employee_id, date_time)
VALUES(?, ?, ?);