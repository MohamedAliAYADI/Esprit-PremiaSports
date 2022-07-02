-- phpMyAdmin SQL Dump
-- version 4.9.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 02, 2022 at 02:30 PM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `premia_sports`
--

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pseudo` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `adress` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `civilite` varchar(255) DEFAULT NULL,
  `genre` int(11) DEFAULT NULL,
  `taille` int(11) DEFAULT NULL,
  `poids` int(11) DEFAULT NULL,
  `profession` varchar(255) DEFAULT NULL,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `client_ibfk_2` (`role`),
  KEY `client_ibfk_3` (`genre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`id`, `pseudo`, `password`, `nom`, `prenom`, `dob`, `email`, `adress`, `telephone`, `civilite`, `genre`, `taille`, `poids`, `profession`, `role`) VALUES
(1, 'test', 'test', NULL, NULL, NULL, 'slimen@gmail.com', NULL, NULL, NULL, 1, NULL, NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `coach`
--

DROP TABLE IF EXISTS `coach`;
CREATE TABLE IF NOT EXISTS `coach` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pseudo` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `adress` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `civilite` varchar(255) DEFAULT NULL,
  `genre` int(11) DEFAULT NULL,
  `taille` int(11) DEFAULT NULL,
  `poids` int(11) DEFAULT NULL,
  `profession` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `spec` varchar(255) DEFAULT NULL,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `coach_ibfk_1` (`role`),
  KEY `coach_ibfk_2` (`genre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `genre`
--

DROP TABLE IF EXISTS `genre`;
CREATE TABLE IF NOT EXISTS `genre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libele` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `genre`
--

INSERT INTO `genre` (`id`, `libele`) VALUES
(1, 'Homme'),
(2, 'Femme');

-- --------------------------------------------------------

--
-- Table structure for table `moderateur`
--

DROP TABLE IF EXISTS `moderateur`;
CREATE TABLE IF NOT EXISTS `moderateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pseudo` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `adress` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `civilite` varchar(255) DEFAULT NULL,
  `genre` int(11) DEFAULT NULL,
  `taille` int(11) DEFAULT NULL,
  `poids` int(11) DEFAULT NULL,
  `profession` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `moderateur_ibfk_1` (`role`),
  KEY `moderateur_ibfk_2` (`genre`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `moderateur`
--

INSERT INTO `moderateur` (`id`, `pseudo`, `password`, `nom`, `prenom`, `dob`, `email`, `adress`, `telephone`, `civilite`, `genre`, `taille`, `poids`, `profession`, `img`, `role`) VALUES
(1, 'qq', '123', 'scs', 'sxs', '2022-06-01', 'ouni.slimeno@gmail.com', 'sss', '0215', 'Mme', 2, 30, 210, NULL, NULL, 2),
(3, 'asus', '123', 'skie', 'sljc', '2013-07-10', 'slimen.ouni@esprit.tn', 'tunis', '123', 'M', 1, 123, 123, NULL, NULL, 2);

-- --------------------------------------------------------

--
-- Table structure for table `pclub`
--

DROP TABLE IF EXISTS `pclub`;
CREATE TABLE IF NOT EXISTS `pclub` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pseudo` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `dob` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `adress` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `civilite` varchar(255) DEFAULT NULL,
  `genre` int(11) DEFAULT NULL,
  `taille` int(11) DEFAULT NULL,
  `poids` int(11) DEFAULT NULL,
  `profession` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role` (`role`),
  KEY `genre` (`genre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pterrain`
--

DROP TABLE IF EXISTS `pterrain`;
CREATE TABLE IF NOT EXISTS `pterrain` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pseudo` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `adress` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `civilite` varchar(255) DEFAULT NULL,
  `genre` int(11) DEFAULT NULL,
  `taille` int(11) DEFAULT NULL,
  `poids` int(11) DEFAULT NULL,
  `profession` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role` (`role`),
  KEY `genre` (`genre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libele` varchar(40) NOT NULL,
  `description` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `libele`, `description`) VALUES
(1, 'Client', 'this is a breif description'),
(2, 'Moderateur', 'this is a breif description'),
(3, 'Propriétaire de club', 'this is a breif description'),
(4, 'propriétaire de complexe', 'this is a breif description'),
(5, 'Coach', 'this is a breif description');

-- --------------------------------------------------------

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
CREATE TABLE IF NOT EXISTS `test` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `test`
--

INSERT INTO `test` (`ID`, `TITLE`) VALUES
(1, 'test1');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL,
  `pseudo` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role` (`role`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `client_ibfk_2` FOREIGN KEY (`role`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `client_ibfk_3` FOREIGN KEY (`genre`) REFERENCES `genre` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `coach`
--
ALTER TABLE `coach`
  ADD CONSTRAINT `coach_ibfk_1` FOREIGN KEY (`role`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `coach_ibfk_2` FOREIGN KEY (`genre`) REFERENCES `genre` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `moderateur`
--
ALTER TABLE `moderateur`
  ADD CONSTRAINT `moderateur_ibfk_1` FOREIGN KEY (`role`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `moderateur_ibfk_2` FOREIGN KEY (`genre`) REFERENCES `genre` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `pclub`
--
ALTER TABLE `pclub`
  ADD CONSTRAINT `pclub_ibfk_1` FOREIGN KEY (`role`) REFERENCES `user` (`role`),
  ADD CONSTRAINT `pclub_ibfk_2` FOREIGN KEY (`genre`) REFERENCES `genre` (`id`);

--
-- Constraints for table `pterrain`
--
ALTER TABLE `pterrain`
  ADD CONSTRAINT `pterrain_ibfk_1` FOREIGN KEY (`role`) REFERENCES `user` (`role`),
  ADD CONSTRAINT `pterrain_ibfk_2` FOREIGN KEY (`genre`) REFERENCES `genre` (`id`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
