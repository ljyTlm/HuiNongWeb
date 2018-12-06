-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.17-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  8.2.0.4675
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 huinong 的数据库结构
CREATE DATABASE IF NOT EXISTS `huinong` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `huinong`;


-- 导出  表 huinong.consumption 结构
CREATE TABLE IF NOT EXISTS `consumption` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL DEFAULT '0',
  `moey` varchar(50) NOT NULL DEFAULT '0',
  `date` datetime NOT NULL,
  `commodityid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  huinong.consumption 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `consumption` DISABLE KEYS */;
/*!40000 ALTER TABLE `consumption` ENABLE KEYS */;


-- 导出  表 huinong.feedback 结构
CREATE TABLE IF NOT EXISTS `feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `text` varchar(500) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- 正在导出表  huinong.feedback 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` (`id`, `name`, `title`, `time`, `text`, `status`) VALUES
	(2, '李金玉', 'app存在bug', '2018-12-06 19:15:38', '侧边栏服务为开放', 0),
	(7, '李金玉', '我在对反馈进行测试', '2018-12-06 19:22:49', '我对反馈进行了测试', 0);
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;


-- 导出  表 huinong.gift 结构
CREATE TABLE IF NOT EXISTS `gift` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imgurl` varchar(50) NOT NULL DEFAULT '0',
  `name` varchar(50) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  huinong.gift 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `gift` DISABLE KEYS */;
INSERT INTO `gift` (`id`, `imgurl`, `name`, `score`, `num`) VALUES
	(1, 'riceCoker.png', '电饭锅', 100, 7),
	(2, 'bedThree.png', '床上三件套', 200, 19),
	(3, 'xiaomi.png', '小米手机', 999999, 1);
/*!40000 ALTER TABLE `gift` ENABLE KEYS */;


-- 导出  表 huinong.news 结构
CREATE TABLE IF NOT EXISTS `news` (
  `imgname` varchar(50) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- 正在导出表  huinong.news 的数据：~8 rows (大约)
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` (`imgname`, `title`, `url`) VALUES
	('iconnews', '权威解读乡村振兴战略首个五年规划亮点', 'http://nxt.nongmintv.com/show.php?itemid=31779'),
	('iconnews', '承德拖欠农民工工资企业将上“黑名单”', 'http://nxt.nongmintv.com/show.php?itemid=31819'),
	('iconnews', '章丘“葱王”要在阿里拍卖 天猫双11成农产品最佳展示舞台', 'http://nxt.nongmintv.com/show.php?itemid=31806'),
	('iconnews', '2019年小麦最低收购价每斤下调3分', 'http://nxt.nongmintv.com/show.php?itemid=31816'),
	('iconnews', '京津冀联审玉米新品种在河北结硕果', 'http://nxt.nongmintv.com/show.php?itemid=31815'),
	('iconnews', '探寻2.3亿吨蔬菜秸秆的出路', 'http://nxt.nongmintv.com/show.php?itemid=31810'),
	('iconnews', '河北：扶贫龙头企业应带动贫困户100户以上', 'http://nxt.nongmintv.com/show.php?itemid=31805'),
	('iconnews', '贫困地区农产品滞销咋办？', 'http://nxt.nongmintv.com/show.php?itemid=31803');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;


-- 导出  表 huinong.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `name` varchar(50) DEFAULT NULL,
  `passwd` varchar(50) DEFAULT NULL,
  `vip` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `money` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  huinong.user 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`name`, `passwd`, `vip`, `score`, `money`) VALUES
	('罗翔泽', '123456', 2, 500, 100),
	('李金玉', '123456', 2, 0, 200);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


-- 导出  表 huinong.vipcode 结构
CREATE TABLE IF NOT EXISTS `vipcode` (
  `code` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  huinong.vipcode 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `vipcode` DISABLE KEYS */;
INSERT INTO `vipcode` (`code`) VALUES
	('code1'),
	('code2'),
	('code3'),
	('code4'),
	('code5');
/*!40000 ALTER TABLE `vipcode` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
