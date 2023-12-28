insert into author (id, name) values (1, 'George R.R. Martin');
insert into author (id, name) values (2, 'Andrzej Sapkowski');
insert into author (id, name) values (3, 'Agatha Christie');
insert into author (id, name) values (4, 'Stephen King');
insert into author (id, name) values (5, 'J.K. Rowling');
insert into author (id, name) values (6, 'J.R.R. Tolkien');
insert into author (id, name) values (7, 'Dan Brown');

insert into genre (id, name) values (1, 'Fantasy');
insert into genre (id, name) values (2, 'Crime');
insert into genre (id, name) values (3, 'Horror');
insert into genre (id, name) values (4, 'Comedy');
insert into genre (id, name) values (5, 'Adventure');
insert into genre (id, name) values (6, 'Mystery');
insert into genre (id, name) values (7, 'Thriller');


insert into books (title, price, count, author_id, genre_id) values
                    ('Game Of Thrones', 40, 20, 1, 1);
insert into books (title, price, count, author_id, genre_id) values
    ('The Witcher', 25, 20, 2, 1);
insert into books (title, price, count, author_id, genre_id) values
    ('Storm of Swords', 45, 20, 1, 1);
insert into books (title, price, count, author_id, genre_id) values
    ('And Then There Were None', 15, 20, 3, 2);
insert into books (title, price, count, author_id, genre_id) values
    ('It', 30, 20, 4, 3);
insert into books (title, price, count, author_id, genre_id) values
    ('Harry Potter and the Sorcerer''s Stone', 35, 15, 5, 5);
insert into books (title, price, count, author_id, genre_id) values
    ('The Fellowship of the Ring', 28, 18, 6, 5);
insert into books (title, price, count, author_id, genre_id) values
    ('The Da Vinci Code', 20, 25, 7, 7);
insert into books (title, price, count, author_id, genre_id) values
    ('The Hobbit', 30, 22, 6, 5);
insert into books (title, price, count, author_id, genre_id) values
    ('Angels & Demons', 18, 30, 7, 7);

insert into users (login, password, email, cash, logged) values
                    ('login', 'pass', 'mail', 30, false)
