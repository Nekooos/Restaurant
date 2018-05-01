-- Insert role --
insert into role (name) values ('ROLE_USER')

--Insert two users --
insert into user (username, enabled, password) values ('user', true, 'password', 1)
insert into user (username, enabled, password) values ('user2', true, 'password', 2)