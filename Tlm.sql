-- --------------------------------------------------------
-- ����:                           127.0.0.1
-- �������汾:                        5.7.17-log - MySQL Community Server (GPL)
-- ����������ϵͳ:                      Win64
-- HeidiSQL �汾:                  8.2.0.4675
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- ���� huinong �����ݿ�ṹ
CREATE DATABASE IF NOT EXISTS `huinong` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `huinong`;


-- ����  �� huinong.consumption �ṹ
CREATE TABLE IF NOT EXISTS `consumption` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL DEFAULT '0',
  `moey` varchar(50) NOT NULL DEFAULT '0',
  `date` datetime NOT NULL,
  `commodityid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ���ڵ�����  huinong.consumption �����ݣ�~0 rows (��Լ)
/*!40000 ALTER TABLE `consumption` DISABLE KEYS */;
/*!40000 ALTER TABLE `consumption` ENABLE KEYS */;


-- ����  �� huinong.feedback �ṹ
CREATE TABLE IF NOT EXISTS `feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `text` varchar(500) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ���ڵ�����  huinong.feedback �����ݣ�~2 rows (��Լ)
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` (`id`, `name`, `title`, `time`, `text`, `status`) VALUES
	(2, '�����', 'app����bug', '2018-12-06 19:15:38', '���������Ϊ����', 0),
	(7, '�����', '���ڶԷ������в���', '2018-12-06 19:22:49', '�ҶԷ��������˲���', 0);
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;


-- ����  �� huinong.gift �ṹ
CREATE TABLE IF NOT EXISTS `gift` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imgurl` varchar(50) NOT NULL DEFAULT '0',
  `name` varchar(50) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ���ڵ�����  huinong.gift �����ݣ�~2 rows (��Լ)
/*!40000 ALTER TABLE `gift` DISABLE KEYS */;
INSERT INTO `gift` (`id`, `imgurl`, `name`, `score`, `num`) VALUES
	(1, 'riceCoker.png', '�緹��', 100, 7),
	(2, 'bedThree.png', '����������', 200, 19),
	(3, 'xiaomi.png', 'С���ֻ�', 999999, 1);
/*!40000 ALTER TABLE `gift` ENABLE KEYS */;


-- ����  �� huinong.news �ṹ
CREATE TABLE IF NOT EXISTS `news` (
  `imgname` varchar(50) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ���ڵ�����  huinong.news �����ݣ�~8 rows (��Լ)
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` (`imgname`, `title`, `url`) VALUES
	('iconnews', 'Ȩ������������ս���׸�����滮����', 'http://nxt.nongmintv.com/show.php?itemid=31779'),
	('iconnews', '�е���Ƿũ�񹤹�����ҵ���ϡ���������', 'http://nxt.nongmintv.com/show.php?itemid=31819'),
	('iconnews', '���𡰴�����Ҫ�ڰ������� ��è˫11��ũ��Ʒ���չʾ��̨', 'http://nxt.nongmintv.com/show.php?itemid=31806'),
	('iconnews', '2019��С������չ���ÿ���µ�3��', 'http://nxt.nongmintv.com/show.php?itemid=31816'),
	('iconnews', '��������������Ʒ���ںӱ���˶��', 'http://nxt.nongmintv.com/show.php?itemid=31815'),
	('iconnews', '̽Ѱ2.3�ڶ��߲˽ոѵĳ�·', 'http://nxt.nongmintv.com/show.php?itemid=31810'),
	('iconnews', '�ӱ�����ƶ��ͷ��ҵӦ����ƶ����100������', 'http://nxt.nongmintv.com/show.php?itemid=31805'),
	('iconnews', 'ƶ������ũ��Ʒ����զ�죿', 'http://nxt.nongmintv.com/show.php?itemid=31803');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;


-- ����  �� huinong.user �ṹ
CREATE TABLE IF NOT EXISTS `user` (
  `name` varchar(50) DEFAULT NULL,
  `passwd` varchar(50) DEFAULT NULL,
  `vip` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `money` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ���ڵ�����  huinong.user �����ݣ�~2 rows (��Լ)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`name`, `passwd`, `vip`, `score`, `money`) VALUES
	('������', '123456', 2, 500, 100),
	('�����', '123456', 2, 0, 200);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


-- ����  �� huinong.vipcode �ṹ
CREATE TABLE IF NOT EXISTS `vipcode` (
  `code` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ���ڵ�����  huinong.vipcode �����ݣ�~5 rows (��Լ)
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
