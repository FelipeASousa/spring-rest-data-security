-- sample.users definition
CREATE OR REPLACE SEQUENCE `users_seq` start with 1 minvalue 1 maxvalue 9223372036854775806 increment by 1 nocache nocycle ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `users` (
    `id` bigint(20) NOT NULL,
    `email` varchar(255) DEFAULT NULL,
    `first_name` varchar(255) DEFAULT NULL,
    `last_name` varchar(255) DEFAULT NULL,
    `password` varchar(255) DEFAULT NULL,
    `role` enum('ADMIN','USER') DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- sample.tokens definition
CREATE OR REPLACE SEQUENCE `tokens_seq` start with 1 minvalue 1 maxvalue 9223372036854775806 increment by 1 nocache nocycle ENGINE=InnoDB;

-- sample.tokens definition

CREATE TABLE `tokens` (
    `expired` bit(1) NOT NULL,
    `revoked` bit(1) NOT NULL,
    `id` bigint(20) NOT NULL,
    `user_id` bigint(20) DEFAULT NULL,
    `token` varchar(255) DEFAULT NULL,
    `token_type` enum('BEARER') DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_token_token` (`token`),
    KEY `fk_token_user_id` (`user_id`),
    CONSTRAINT `fk_token_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;