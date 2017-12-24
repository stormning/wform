
CREATE TABLE `T_FORM_FIELD`  (
  `FIELD_ID` varchar(32) NOT NULL,
  `MODULE_ID` varchar(32) NULL DEFAULT NULL,
  `NAME` varchar(64) NULL DEFAULT NULL,
  `DISPLAY` varchar(64) NULL DEFAULT NULL,
  `TYPE` varchar(63) NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NULL DEFAULT NULL,
  `CREATE_TIME` timestamp(0) NULL DEFAULT NULL,
  `STATUS` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`FIELD_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `T_FORM_FIELD` VALUES ('1', NULL, 'title', '标题', 'text', '2017-12-16 20:42:50', '2017-12-16 20:42:52', 1);
INSERT INTO `T_FORM_FIELD` VALUES ('2', NULL, 'note', '注释', 'text', '2017-12-16 20:43:44', '2017-12-16 20:43:47', 1);
INSERT INTO `T_FORM_FIELD` VALUES ('3', NULL, 'content', '内容', 'textarea', '2017-12-16 20:43:44', '2017-12-16 20:43:47', 1);

CREATE TABLE `T_FORM_FIELD_ATTRIBUTE`  (
  `FIELD_GROUP_ID` varchar(32) NULL DEFAULT NULL,
  `FIELD_NAME` varchar(64) NULL DEFAULT NULL,
  `ATTR_NAME` varchar(64) NULL DEFAULT NULL,
  `ATTR_VALUE` varchar(255) NULL DEFAULT NULL,
  `STATUS` int(1) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

CREATE TABLE `T_FORM_FIELD_GROUP`  (
  `GROUP_ID` varchar(32) NOT NULL,
  `NAME` varchar(64) NULL DEFAULT NULL,
  `FORM_PAGE_ID` varchar(32) NULL DEFAULT NULL,
  `IS_MANUAL` int(1) NULL DEFAULT NULL,
  `TABLE_NAME` varchar(30) NULL DEFAULT NULL,
  `DISPLAY_TYPE` int(1) NULL DEFAULT NULL,
  `EDITABLE` int(1) NULL DEFAULT NULL,
  `MAX_COLUMN_NUM` int(2) NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NULL DEFAULT NULL,
  `CREATE_TIME` timestamp(0) NULL DEFAULT NULL,
  `STATUS` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`GROUP_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `T_FORM_FIELD_GROUP` VALUES ('100101', 'first_group', '1001', 0, 't_auto_1001', 1, 1, 4, '2017-12-16 20:17:53', '2017-12-16 20:17:56', 1);

CREATE TABLE `T_FORM_FORMPAGE`  (
  `FORM_ID` varchar(32) NOT NULL,
  `FORM_NAME` varchar(100) NULL DEFAULT NULL,
  `FORM_TITLE` varchar(100) NULL DEFAULT NULL,
  `PAGE_TYPE` int(1) NULL DEFAULT NULL,
  `SUMMARY` varchar(255) NULL DEFAULT NULL,
  `MODULE_ID` varchar(32) NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NULL DEFAULT NULL,
  `CREATE_TIME` timestamp(0) NULL DEFAULT NULL,
  `STATUS` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`FORM_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `T_FORM_FORMPAGE` VALUES ('1001', 'first_page', ' 第一个页面', 1, '测试', NULL, '2017-12-16 20:14:52', '2017-12-16 20:14:54', 1);

CREATE TABLE `T_FORM_MODULE`  (
  `MODULE_ID` varchar(32) NOT NULL,
  `MODULE_NAME` varchar(100) NULL DEFAULT NULL,
  `SUMMARY` varchar(255) NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NULL DEFAULT NULL,
  `CREATE_TIME` timestamp(0) NULL DEFAULT NULL,
  `STATUS` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`MODULE_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

CREATE TABLE `T_R_FIELD_GROUP`  (
  `GROUP_ID` varchar(32) NULL DEFAULT NULL,
  `FIELD_ID` varchar(32) NULL DEFAULT NULL,
  `ROW_NUM` int(2) NULL DEFAULT NULL,
  `COLUMN_NUM` int(2) NULL DEFAULT NULL,
  `COLUMN_SPAN` int(2) NULL DEFAULT NULL,
  `EDITABLE` int(1) NULL DEFAULT NULL,
  `SIZE` int(2) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `T_R_FIELD_GROUP` VALUES ('100101', '1', 1, 1, 1, 1, 10);
INSERT INTO `T_R_FIELD_GROUP` VALUES ('100101', '2', 1, 2, 1, 1, 100);
INSERT INTO `T_R_FIELD_GROUP` VALUES ('100101', '3', 2, 1, 1, 1, 100);
