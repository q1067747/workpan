
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `file_folder`
-- ----------------------------
DROP TABLE IF EXISTS `file_folder`;
CREATE TABLE `file_folder` (
  `file_folder_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文件夹ID',
  `file_folder_name` varchar(255) DEFAULT NULL COMMENT '文件夹名称',
  `parent_folder_id` int(11) DEFAULT '0' COMMENT '父文件夹ID',
  `file_store_id` int(11) DEFAULT NULL COMMENT '所属文件仓库ID',
  `time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`file_folder_id`)
) ENGINE=InnoDB AUTO_INCREMENT=148 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `file_store`
-- ----------------------------
DROP TABLE IF EXISTS `file_store`;
CREATE TABLE `file_store` (
  `file_store_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文件仓库ID',
  `user_id` int(11) DEFAULT NULL COMMENT '主人ID',
  `current_size` int(11) DEFAULT '0' COMMENT '当前容量（单位KB）',
  `max_size` int(11) DEFAULT '1048576' COMMENT '最大容量（单位KB）',
  PRIMARY KEY (`file_store_id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `my_file`
-- ----------------------------
DROP TABLE IF EXISTS `my_file`;
CREATE TABLE `my_file` (
  `my_file_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文件ID',
  `my_file_name` varchar(255) DEFAULT NULL COMMENT '文件名',
  `file_store_id` int(11) DEFAULT NULL COMMENT '文件仓库ID',
  `my_file_path` varchar(255) DEFAULT '/' COMMENT '文件存储路径',
  `download_time` int(11) DEFAULT '0' COMMENT '下载次数',
  `upload_time` datetime DEFAULT NULL COMMENT '上传时间',
  `parent_folder_id` int(11) DEFAULT NULL COMMENT '父文件夹ID',
  `size` int(11) DEFAULT NULL COMMENT '文件大小',
  `type` int(11) DEFAULT NULL COMMENT '文件类型',
  `postfix` varchar(255) DEFAULT NULL COMMENT '文件后缀',
  PRIMARY KEY (`my_file_id`)
) ENGINE=InnoDB AUTO_INCREMENT=204 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `pwd` TINYBLOB DEFAULT NULL COMMENT '密码',
  `student_id` varchar(10) DEFAULT NULL comment '学号',
  `user_name` varchar(50) DEFAULT NULL COMMENT '姓名',
   `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `college_id` int(2) DEFAULT NULL COMMENT '学院ID',
  `major_id` int(3)  DEFAULT NULL COMMENT '专业ID',
  `file_store_id` int(11) DEFAULT NULL COMMENT '文件仓库ID',
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `task`
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `task_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '作业ID',
  `task_name` varchar(255) NOT NULL COMMENT '作业名称',
  `create_user_name` varchar(50) NOT NULL COMMENT '教师名',
  `create_user_id` int(11) NOT NULL COMMENT '教师id',
  `notice` varchar(255) NOT NULL COMMENT '作业备注',
  `dead_time` datetime DEFAULT NULL COMMENT '截止时间',
  PRIMARY KEY (`task_id`)
)ENGINE=InnoDB AUTO_INCREMENT=256 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Table structure for `task_user`
-- ----------------------------
DROP TABLE IF EXISTS `task_user`;
CREATE TABLE `task_user` (
	`task_id` int(11) NOT NULL COMMENT '作业ID',
	`user_id` int(11) NOT NULL COMMENT '主人ID',
    `my_file_id` int(11) NULL  COMMENT '文件ID'
)ENGINE=InnoDB  CHARSET=utf8;

DROP TABLE IF EXISTS `college`;
CREATE TABLE `college` (
  `college_id` int(2) NOT NULL COMMENT '学院ID',
  `college_name` varchar(255) DEFAULT NULL COMMENT '学院名称',
  PRIMARY KEY (`college_id`)
)ENGINE=InnoDB  CHARSET=utf8;


DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `major_id` int(3) NOT NULL COMMENT '专业ID',
  `college_id` int (2) NOT NULL COMMENT '学院ID',
  `major_name` varchar(255) NOT NULL COMMENT '专业名称',
  PRIMARY KEY (`major_id`)
)ENGINE=InnoDB CHARSET=utf8;
