CREATE TABLE `account_record`
(
    `ID`           int(11) NOT NULL AUTO_INCREMENT,
    `account_name` varchar(20)  DEFAULT NULL,
    `account_type` varchar(10)  DEFAULT NULL,
    `content_type` varchar(30)  DEFAULT NULL,
    `note`         varchar(128) DEFAULT NULL,
    `amount`       double       DEFAULT NULL,
    `record_time`  datetime     DEFAULT NULL,
    PRIMARY KEY (`ID`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8;

INSERT INTO `account_record`
VALUES ('1', 'GCX', 'Spending', 'PAY_MEAL', 'lunch of today', '50', '2020-01-12 09:45:57');