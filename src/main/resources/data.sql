BEGIN;
DELETE FROM loans;
ALTER SEQUENCE loans_id_seq RESTART WITH 1;
DELETE FROM books;
ALTER SEQUENCE books_id_seq RESTART WITH 1;
DELETE FROM authors;
ALTER SEQUENCE authors_id_seq RESTART WITH 1;
DELETE FROM members;
ALTER SEQUENCE members_id_seq RESTART WITH 1;

INSERT INTO authors (name) VALUES
    ('J.R.R. Tolkien'),
    ('George Orwell'),
    ('Jane Austen'),
    ('Isaac Asimov'),
    ('Han Jisung');
INSERT INTO books (title, isbn, total_copies, available_copies, author_id) VALUES
    ('The Hobbit', '9780007458424', 5, 3, 1),
    ('The Lord of the Rings', '9780261102385', 4, 4, 1),
    ('1984', '9780451524935', 6, 5, 2),
    ('Animal Farm', '9780451526342', 5, 5, 2),
    ('Pride and Prejudice', '9780141439518', 3, 2, 3),
    ('Foundation', '9780553293357', 4, 3, 4);
INSERT INTO members (name, email, is_active) VALUES
    ('Alice Johnson', 'alice@example.com', TRUE),
    ('Bob Smith', 'bob@example.com', TRUE),
    ('Charlie Brown', 'charlie@example.com', TRUE);
INSERT INTO loans (book_id, member_id, loan_date, due_date, loan_status) VALUES
    (1, 1, '2024-11-05 15:00:00', '2024-12-05 15:00:00', 'BORROWED');
COMMIT;

