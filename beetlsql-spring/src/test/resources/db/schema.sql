-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person`
(
    `id`      int(11) NOT NULL AUTO_INCREMENT,
    `address` varchar(255) DEFAULT NULL,
    `create_user` int(11) DEFAULT NOT NULL,
    `create_time` datetime DEFAULT NOT NULL,
    `record_version` int(11) DEFAULT 0 NOT NULL,
    PRIMARY KEY (`id`)
);

COMMIT;
