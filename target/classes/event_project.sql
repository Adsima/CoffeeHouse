--Created event
INSERT INTO ch_events (order_id, client_id,
employee_id, expected_time, product_id,
product_cost, date_time)
VALUES (?, ?, ?, ?, ?, ?, ?);

--Cancelled event
INSERT INTO ch_events (order_id, employee_id, reason, date_time)
VALUES(?, ?, ?, ?);

--Started event
INSERT INTO ch_events (order_id, employee_id, date_time)
VALUES(?, ?, ?);

--Ready event
INSERT INTO ch_events (order_id, employee_id, date_time)
VALUES(?, ?, ?);

--Completed event
INSERT INTO ch_events (order_id, employee_id, date_time)
VALUES(?, ?, ?);