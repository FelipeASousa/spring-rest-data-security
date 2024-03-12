-- sample.members definition

CREATE OR REPLACE SEQUENCE `members_seq` start with 1 minvalue 1 maxvalue 9223372036854775806 increment by 1 nocache nocycle ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `members` (
    `age` int(11) DEFAULT NULL,
    `group_id` bigint(20) NOT NULL,
    `id` bigint(20) NOT NULL,
    `name` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `fk_members_group` (`group_id`),
    CONSTRAINT `fk_members_group` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;