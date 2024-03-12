-- sample.users test data
INSERT INTO users (id, email, first_name, last_name, password, `role`)
VALUES(NEXT VALUE FOR users_seq, 'admin@mail.com', 'Fake', 'Admin', '$2a$10$56Ib0m0Yxp0OZQ/DlhqcUOBv8m.2UVhzYq3rwvt3uwTIE9b5/aTxW', 'ADMIN');
INSERT INTO users (id, email, first_name, last_name, password, `role`)
VALUES(NEXT VALUE FOR users_seq, 'user@mail.com', 'Fake', 'User', '$2a$10$CyPb8VnOOuhaRkVyAvVrhumHbmOgqISuTfgPM2Od3R085yOm8mf5S', 'USER');