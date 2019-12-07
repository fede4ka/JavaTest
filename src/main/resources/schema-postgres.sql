--DROP TABLE IF EXISTS usr,user_role,usr_info,purchases,items;
CREATE TABLE IF NOT EXISTS usr (id  SERIAL,username VARCHAR NOT NULL UNIQUE, password VARCHAR , active BOOLEAN, PRIMARY KEY(id));
CREATE TABLE IF NOT EXISTS user_role (user_id SERIAL, roles VARCHAR );
CREATE TABLE IF NOT EXISTS usr_info (user_info_id SERIAL,name VARCHAR,lastname VARCHAR,age INT, FOREIGN KEY (user_info_id) REFERENCES usr(id));
CREATE TABLE IF NOT EXISTS purchases (id SERIAL, uid INT, pid INT, pdate Date, PRIMARY KEY(pid) );
CREATE TABLE IF NOT EXISTS items (id SERIAL , ig_id INT, name VARCHAR, price double precision, count INT, FOREIGN KEY (ig_id) REFERENCES purchases(pid));

