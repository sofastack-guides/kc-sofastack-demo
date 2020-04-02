# ==========================
# balance db
CREATE DATABASE balance_db;
USE balance_db;
DROP TABLE IF EXISTS `balance_tb`;
CREATE TABLE `balance_tb`
(
    `id`        int(11) NOT NULL AUTO_INCREMENT,
    `user_name` varchar(255)   DEFAULT NULL,
    `balance`   decimal(16, 2) DEFAULT 0.00,
    PRIMARY KEY (`id`),
    UNIQUE KEY (`user_name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# ==========================
# stock db
CREATE database stock_db;
USE stock_db;
DROP TABLE IF EXISTS `stock_tb`;
CREATE TABLE `stock_tb`
(
    `id`           int(11) NOT NULL AUTO_INCREMENT,
    `product_code` varchar(255)   DEFAULT NULL,
    `name`         varchar(255)   DEFAULT NULL,
    `description`  text,
    `price`        decimal(10, 2) DEFAULT 0.00,
    `count`        int(11)        DEFAULT 0,
    `user_name`    varchar(255)   DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY (`id`, `user_name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `order_tb`;
CREATE TABLE `order_tb`
(
    `id`           int(11) NOT NULL AUTO_INCREMENT,
    `user_name`    varchar(255) DEFAULT NULL,
    `product_code` varchar(255) DEFAULT NULL,
    `count`        int(11)      DEFAULT 0,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;