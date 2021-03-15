ALTER TABLE book DROP FOREIGN KEY FK_book_reader;
ALTER TABLE reader DROP FOREIGN KEY FK_reader_book;

DROP TABLE category; 
DROP TABLE reader_likes;
DROP TABLE book; 
DROP TABLE reader;


CREATE TABLE category
(id BIGINT NOT NULL AUTO_INCREMENT 
,name VARCHAR(50) NOT NULL
,PRIMARY KEY (id));

CREATE TABLE book (
id BIGINT NOT NULL AUTO_INCREMENT
, title VARCHAR(50) NOT NULL
, author VARCHAR(50) NOT NULL
, year INT
, isbn VARCHAR(25)
, price BIGINT
, categoryid BIGINT
, PRIMARY KEY (id)
);

CREATE TABLE reader
(id BIGINT NOT NULL AUTO_INCREMENT 
, name VARCHAR(350) NOT NULL
, PRIMARY KEY (id));

CREATE TABLE reader_likes
(reader_id BIGINT NOT NULL
, book_id BIGINT NOT NULL
, PRIMARY KEY (reader_id, book_id)
, FOREIGN KEY (reader_id) REFERENCES reader(id)
, FOREIGN KEY (book_id) REFERENCES book(id));


INSERT INTO category (name) VALUES ('Dekkari'), ('Novelli'), ('Dokumentti');

INSERT INTO book (title, author, year, price, categoryid) 
VALUES ('Kasvoton kuolema', 'Hennig Mankell', 1989, 12, 1), 
('Riian verikoirat','Hennig Mankell', 1990, 13, 1);

INSERT INTO reader (name) 
VALUES ("Pertti"), ("Rane"), ("Eini"), ("Heikki"), ("Pentti");


INSERT INTO reader_likes (reader_id, book_id) 
VALUES (1,1), (1,2), (3,1), (4,2);

SELECT * FROM book;
SELECT * FROM category;
SELECT * FROM reader;
SELECT * FROM reader_likes;

