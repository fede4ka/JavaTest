INSERT INTO usr  (username, password, active) VALUES ('user', 'password', TRUE),('Ivan', 'ivanpassword', TRUE);
INSERT INTO user_role(roles) VALUES ('USER'),('USER'),('USER');
INSERT INTO usr_info (name,lastname,age) VALUES ('Буратино','Богатый',20),('Иван','Петров',18);
INSERT INTO purchases(uid, pid, pdate) VALUES ( 1,1, '20191125'),(2,2, '20191201'),(1,3, '20191203');
INSERT INTO items( ig_id,name,price, count) VALUES (1,'Телевизор',150,1),(1,'Смартфон', 200, 1),(2,'Соковыжималка', 300, 1),
(3,'Смартфон', 400, 1),(3,'Смартфон', 500, 1),(3,'Смартфон', 600, 1), (2,'Телевизор',150,1),(1,'Телевизор',150,1);

