-- Insert data into customers table
INSERT INTO customers (name, email) VALUES
                                        ('Mr SpiderMan', 'spiderman@example.com'),
                                        ('Mr SuperMan', 'superman@example.com'),
                                        ('Mr IronMan', 'ironman@example.com'),
                                        ('Mr Hulk', 'hulk@example.com'),
                                        ('Mr Captain', 'captain@example.com');

-- Insert data into items table
INSERT INTO items (name, price) VALUES
                                    ('Item1', 19.99),
                                    ('Item2', 29.99),
                                    ('Item3', 39.99),
                                    ('Item4', 49.99),
                                    ('Item5', 59.99),
                                    ('Item6', 69.99),
                                    ('Item7', 79.99),
                                    ('Item8', 89.99),
                                    ('Item9', 99.99),
                                    ('Item10', 109.99);

-- Insert data into sales table
INSERT INTO sales (item_id, quantity, sale_date) VALUES
                                                     (1, 5, CURRENT_DATE),
                                                     (2, 3, CURRENT_DATE),
                                                     (3, 7, CURRENT_DATE - INTERVAL '1 day'),
                                                     (4, 2, CURRENT_DATE - INTERVAL '1 day'),
                                                     (5, 4, CURRENT_DATE - INTERVAL '2 days'),
                                                     (6, 6, CURRENT_DATE - INTERVAL '3 days'),
                                                     (7, 1, CURRENT_DATE - INTERVAL '4 days'),
                                                     (8, 3, CURRENT_DATE - INTERVAL '5 days'),
                                                     (9, 2, CURRENT_DATE - INTERVAL '6 days'),
                                                     (10, 5, CURRENT_DATE - INTERVAL '7 days'),
                                                     (1, 4, CURRENT_DATE - INTERVAL '8 days'),
                                                     (2, 2, CURRENT_DATE - INTERVAL '9 days'),
                                                     (3, 6, CURRENT_DATE - INTERVAL '10 days'),
                                                     (4, 3, CURRENT_DATE - INTERVAL '11 days'),
                                                     (5, 5, CURRENT_DATE - INTERVAL '12 days');

-- Insert data into wishlists table
INSERT INTO wishlists (customer_id, item_id) VALUES
                                                 (1, 1),
                                                 (1, 2),
                                                 (2, 3),
                                                 (2, 4),
                                                 (3, 5),
                                                 (3, 6),
                                                 (4, 7),
                                                 (4, 8),
                                                 (5, 9),
                                                 (5, 10),
                                                 (1, 3),
                                                 (2, 5),
                                                 (3, 7),
                                                 (4, 9),
                                                 (5, 1);

-- Additional data for diverse sales over time
INSERT INTO sales (item_id, quantity, sale_date) VALUES
                                                     (1, 7, CURRENT_DATE - INTERVAL '13 days'),
                                                     (2, 5, CURRENT_DATE - INTERVAL '14 days'),
                                                     (3, 9, CURRENT_DATE - INTERVAL '15 days'),
                                                     (4, 2, CURRENT_DATE - INTERVAL '16 days'),
                                                     (5, 6, CURRENT_DATE - INTERVAL '17 days'),
                                                     (6, 4, CURRENT_DATE - INTERVAL '18 days'),
                                                     (7, 8, CURRENT_DATE - INTERVAL '19 days'),
                                                     (8, 1, CURRENT_DATE - INTERVAL '20 days'),
                                                     (9, 3, CURRENT_DATE - INTERVAL '21 days'),
                                                     (10, 7, CURRENT_DATE - INTERVAL '22 days');

-- Additional sales for the last month
INSERT INTO sales (item_id, quantity, sale_date) VALUES
                                                     (1, 2, CURRENT_DATE - INTERVAL '23 days'),
                                                     (2, 4, CURRENT_DATE - INTERVAL '24 days'),
                                                     (3, 3, CURRENT_DATE - INTERVAL '25 days'),
                                                     (4, 5, CURRENT_DATE - INTERVAL '26 days'),
                                                     (5, 7, CURRENT_DATE - INTERVAL '27 days'),
                                                     (6, 9, CURRENT_DATE - INTERVAL '28 days'),
                                                     (7, 3, CURRENT_DATE - INTERVAL '29 days'),
                                                     (8, 2, CURRENT_DATE - INTERVAL '30 days'),
                                                     (9, 4, CURRENT_DATE - INTERVAL '31 days'),
                                                     (10, 1, CURRENT_DATE - INTERVAL '32 days');
