SELECT * FROM book;
SELECT * FROM publisher;

SELECT *
FROM book
JOIN publisher ON (bk_pub_no = pub_no);

SELECT * FROM book WHERE bk_title = ? AND bk_author = ?;
SELECT * FROM book;

INSERT INTO book(bk_title, bk_author) VALUES(?, ?);

SELECT * FROM rent;

SELECT * FROM rent WHERE rent_book_no = 2;

SELECT * FROM book;

SELECT * FROM rent;

DELETE FROM book WHERE bk_no = ?;

SELECT * FROM member;

SELECT * FROM member WHERE member_id = ? AND member_pwd = ?;

INSERT INTO member(member_id, member_pwd, member_name) VALUES(?, ?, ?);









