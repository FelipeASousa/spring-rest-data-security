-- sample.members test data

INSERT INTO members (id, group_id, age, name) VALUES(NEXT VALUE FOR members_seq, 1, 17, 'Member 1 GRP 1');
INSERT INTO members (id, group_id, age, name) VALUES(NEXT VALUE FOR members_seq, 1, 21, 'Member 2 GRP 1');
INSERT INTO members (id, group_id, age, name) VALUES(NEXT VALUE FOR members_seq, 1, 45, 'Member 3 GRP 1');

INSERT INTO members (id, group_id, age, name) VALUES(NEXT VALUE FOR members_seq, 2, 19, 'Member 1 GRP 2');
INSERT INTO members (id, group_id, age, name) VALUES(NEXT VALUE FOR members_seq, 2, 65, 'Member 2 GRP 2');

INSERT INTO members (id, group_id, age, name) VALUES(NEXT VALUE FOR members_seq, 3, 23, 'Member 1 GRP 3');
INSERT INTO members (id, group_id, age, name) VALUES(NEXT VALUE FOR members_seq, 3, 44, 'Member 2 GRP 3');