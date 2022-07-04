insert into author (id, name) values (1, 'George R.R. Martin');
insert into author (id, name) values (2, 'Andrzej Sapkowski');
insert into author (id, name) values (3, 'Agatha Christie');
insert into author (id, name) values (4, 'Stephen King');

insert into genre (id, name) values (1, 'Fantasy');
insert into genre (id, name) values (2, 'Crime');
insert into genre (id, name) values (3, 'Horror');


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

insert into users (login, password, email, cash, logged) values
                    ('login', 'pass', 'mail', 30, false)
