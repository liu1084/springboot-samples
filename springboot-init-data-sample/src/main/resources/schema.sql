drop table if exists `pms_user`;
CREATE TABLE `pms_user` (
  `id` bigint(20)  NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL DEFAULT '',
  `email` varchar(50) NOT NULL DEFAULT '',
  `phone` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(300) NOT NULL DEFAULT '',
  `is_enabled` tinyint(1)  NOT NULL DEFAULT '1' COMMENT '0:不可用 1:可用',
  `type` tinyint(1) NOT NULL DEFAULT '1' COMMENT '1:个人用户，以手机为登录凭证 2:企业用户，以邮箱为登录凭证',
  `activated` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否激活（0-未激活，1-已激活）',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  PRIMARY KEY (`id`)
) ;
drop table if exists `pms_role`;
CREATE TABLE `pms_role` (
  `id` bigint(20)  NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  PRIMARY KEY (`id`)
);
drop table if exists `pms_user_role`;
CREATE TABLE `pms_user_role` (
  `id` bigint(20)  NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20)  NOT NULL,
  `role_id` bigint(20)  NOT NULL,
  PRIMARY KEY (`id`)
);
drop table if exists `pms_privilege`;
CREATE TABLE `pms_privilege` (
  `id` bigint(20)  NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `api` varchar(240) NOT NULL DEFAULT '' COMMENT '能到达的APi接口',
  `description` varchar(500) DEFAULT '' COMMENT '权限说明',
  PRIMARY KEY (`id`)
);
drop table if exists `pms_role_privilege`;
CREATE TABLE `pms_role_privilege` (
  `id` bigint(20)  NOT NULL AUTO_INCREMENT,
  `privilege_id` bigint(20)  NOT NULL,
  `role_id` bigint(20)  NOT NULL,
  PRIMARY KEY (`id`)
);