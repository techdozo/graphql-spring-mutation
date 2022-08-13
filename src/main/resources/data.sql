INSERT INTO book (id, name, author, publisher, price) VALUES (1000,'Zero to One', 'Peter Thiel', 'Crown Business', 16.14);
INSERT INTO book (id, name, author, publisher, price) VALUES (1001, 'The Lean Startup', 'Eric Ries', 'VIKIN', 15.80);
INSERT INTO book (id, name, author, publisher, price) VALUES (1002,'Sapiens: A Brief History of Humankind','Yuval Noah Harari','Random House Uk', 18.75);
INSERT INTO book (id, name, author, publisher, price) VALUES (1003, 'Atomic Habits', 'James Clear', 'Avery', 11.98);
INSERT INTO book (id, name, author, publisher, price) VALUES (1004, 'The Subtle Art of Not Giving a F*ck', 'Mark Manson', 'Harper',12.99);

INSERT INTO rating (id, book_id, rating, comment, user_id) VALUES (1000,1000,5,  'The 4 minutes that will help you decide if this book is for you', 'Konstantinos Papakonstantinou');
INSERT INTO rating (id, book_id, rating, comment, user_id) VALUES (1001,1000,3,  'Is Peter Thiel the next robber baron?', 'Konstantinos Papakonstantinou');
INSERT INTO rating (id, book_id, rating, comment, user_id) VALUES (1002,1000,3,  'Simple-minded. Is it satire?   Poorly-reasoned? Historically-ignorant? Afraid of competition? IDK', 'Todd Holscher');
INSERT INTO rating (id, book_id, rating, comment, user_id) VALUES (1003,1002,5,  'The Intersubjective Realm', 'P. Schuyler');
INSERT INTO rating (id, book_id, rating, comment, user_id) VALUES (1004,1003,1,  'Don''t be fooled. This book is opinion masquerading as science.', 'Andrew Terhune');
INSERT INTO rating (id, book_id, rating, comment, user_id) VALUES (1005,1004,1,  'Pretentious and pompous opinions presented as facts', 'P. Daskaloff');