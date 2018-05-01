-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 23, 2017 at 06:48 PM
-- Server version: 5.1.41
-- PHP Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_emp_reorder`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_compute`
--

CREATE TABLE IF NOT EXISTS `tbl_compute` (
  `autoid` int(10) NOT NULL AUTO_INCREMENT,
  `employeeid` varchar(50) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `designation` varchar(200) DEFAULT NULL,
  `salary` varchar(100) DEFAULT NULL,
  `month` varchar(50) DEFAULT NULL,
  `year` varchar(100) NOT NULL,
  `totalday` int(11) DEFAULT NULL,
  `workingday` int(11) DEFAULT NULL,
  `performance` varchar(50) DEFAULT NULL,
  `presentdate` varchar(200) DEFAULT NULL,
  UNIQUE KEY `autoid` (`autoid`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `tbl_compute`
--

INSERT INTO `tbl_compute` (`autoid`, `employeeid`, `name`, `designation`, `salary`, `month`, `year`, `totalday`, `workingday`, `performance`, `presentdate`) VALUES
(1, 'emp-1', 'abir', 'Professor', '30000', 'April', '2017', 25, 4, 'Good', '26/04/2017'),
(2, 'emp-4', 'qqqq', 'zzzzz', 'zzzz', 'April', '2017', 25, 0, 'Bad', '26/04/2017'),
(3, 'emp-2', 'abiraaaaaaaaa', 'Assistant Professor', '25000', 'May', '2017', 27, 1, 'Bad', '25/05/2017'),
(4, 'emp-1', 'abir', 'Professor', '30000', 'May', '2017', 26, 1, 'Excellent', '26/05/2017'),
(6, 'emp-1', 'Nishcup Barua', 'Professor', '30000', 'June', '2017', 25, 2, 'Excellent', '23/06/2017');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_employee`
--

CREATE TABLE IF NOT EXISTS `tbl_employee` (
  `autoId` int(10) NOT NULL AUTO_INCREMENT,
  `employeeid` varchar(50) NOT NULL DEFAULT '',
  `name` varchar(255) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `address` text,
  `gender` varchar(50) DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `salary` varchar(100) DEFAULT NULL,
  `promotion` int(11) NOT NULL,
  `overtime` varchar(100) DEFAULT NULL,
  `datejoin` varchar(100) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employeeid`),
  UNIQUE KEY `autoId` (`autoId`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `tbl_employee`
--

INSERT INTO `tbl_employee` (`autoId`, `employeeid`, `name`, `mobile`, `email`, `address`, `gender`, `designation`, `salary`, `promotion`, `overtime`, `datejoin`, `image`) VALUES
(1, 'emp-1', 'Nishcup Barua', '134', 'pritombarua12@gmail.com', 'muradpur', 'Others', 'Professor', '30000', 2, '1000', '28/03/2017', 'D:#Emp_System#emp-1.jpg'),
(2, 'emp-2', 'Mr. Sikdar', '111111111111', 'klantop75@gmail.com', 'muradpur', 'Male', 'Assistant Professor', '25000', 2, 'aqqqqqqq', '23/03/2017', 'D:#Emp_System#emp-2.jpg'),
(4, 'emp-4', 'Mr. Rayhan', 'qqqq', 'adhar032@gmail.com', 'qqqqqqq', 'Male', 'zzzzz', 'zzzz', 3, 'zzzzz', '29/03/2017', 'D:#Emp_System#emp-4.jpg'),
(5, 'emp-5', 'w', 'w', 'sbikal17@gmail.com', 'w', 'Male', 'w', 'w', 2, 'w', '29/03/2017', 'D:#Emp_System#emp-5.jpg'),
(7, 'emp-7', 'asasas', 'asa', 'shopnilv880@gmail.com', 'asa', 'Others', 'sadafaef', 'asa', 3, 'sas', '02/04/2017', 'D:#Emp_System#emp-7.jpg'),
(6, 'emp-6', 'asasas', 'sasa', 'prottoynur@gmail.com', 'sasasa', 'Female', 'as', 'asa', 2, 'sa', '02/04/2017', 'D:#Emp_System#emp-6.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_login`
--

CREATE TABLE IF NOT EXISTS `tbl_login` (
  `autoid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `autoid` (`autoid`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `tbl_login`
--

INSERT INTO `tbl_login` (`autoid`, `username`, `password`) VALUES
(1, 'admin', '111'),
(2, 'operator', '123');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_present`
--

CREATE TABLE IF NOT EXISTS `tbl_present` (
  `autoid` int(10) NOT NULL AUTO_INCREMENT,
  `employeeid` varchar(50) DEFAULT NULL,
  `month` varchar(50) DEFAULT NULL,
  `presentdate` varchar(100) DEFAULT NULL,
  `present` varchar(100) DEFAULT NULL,
  UNIQUE KEY `autoid` (`autoid`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `tbl_present`
--

INSERT INTO `tbl_present` (`autoid`, `employeeid`, `month`, `presentdate`, `present`) VALUES
(1, 'emp-1', 'April', '26/04/2017', '20'),
(2, 'emp-4', 'April', '26/04/2017', '00'),
(3, 'emp-2', 'May', '25/05/2017', '10'),
(4, 'emp-1', 'May', '26/05/2017', '10'),
(5, 'emp-1', 'April', '27/04/2017', '20'),
(6, 'emp-1', 'June', '23/06/2017', '10');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_signin`
--

CREATE TABLE IF NOT EXISTS `tbl_signin` (
  `autoid` int(11) NOT NULL AUTO_INCREMENT,
  `employeeid` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `time` varchar(255) NOT NULL,
  `month` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  PRIMARY KEY (`autoid`),
  UNIQUE KEY `autoid` (`autoid`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `tbl_signin`
--

INSERT INTO `tbl_signin` (`autoid`, `employeeid`, `date`, `time`, `month`, `year`) VALUES
(1, 'emp-1', '22/06/2017', '10:56 AM', 6, 2017),
(2, 'emp-2', '22/06/2017', '10:56 AM', 6, 2017),
(3, 'emp-4', '22/06/2017', '10:56 AM', 6, 2017),
(4, 'emp-5', '22/06/2017', '10:56 AM', 6, 2017),
(5, 'emp-6', '22/06/2017', '10:56 AM', 6, 2017),
(6, 'emp-7', '22/06/2017', '10:57 AM', 6, 2017),
(7, 'emp-1', '23/06/2017', '11:02 AM', 6, 2017),
(8, 'emp-2', '23/06/2017', '11:03 AM', 6, 2017),
(9, 'emp-4', '23/06/2017', '12:03 PM', 6, 2017),
(10, 'emp-5', '23/06/2017', '12:04 PM', 6, 2017),
(11, 'emp-6', '23/06/2017', '10:04 AM', 6, 2017),
(12, 'emp-7', '23/06/2017', '10:04 AM', 6, 2017);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_signout`
--

CREATE TABLE IF NOT EXISTS `tbl_signout` (
  `autoid` int(11) NOT NULL AUTO_INCREMENT,
  `employeeid` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `entrytime` varchar(255) NOT NULL,
  `exittime` varchar(255) NOT NULL,
  `worktime` varchar(255) NOT NULL,
  `overtime` varchar(255) NOT NULL,
  `month` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  PRIMARY KEY (`autoid`),
  UNIQUE KEY `autoid` (`autoid`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `tbl_signout`
--

INSERT INTO `tbl_signout` (`autoid`, `employeeid`, `date`, `entrytime`, `exittime`, `worktime`, `overtime`, `month`, `year`) VALUES
(1, 'emp-1', '22/06/2017', '10:56 AM', '8:08 PM', '09:12', '02:12', 6, 2017),
(2, 'emp-2', '22/06/2017', '10:56 AM', '7:08 PM', '08:12', '01:12', 6, 2017),
(3, 'emp-4', '22/06/2017', '10:56 AM', '6:19 PM', '07:23', '00:23', 6, 2017),
(4, 'emp-5', '22/06/2017', '10:56 AM', '6:01 PM', '07:05', '00:05', 6, 2017),
(5, 'emp-6', '22/06/2017', '10:56 AM', '7:01 PM', '08:05', '01:05', 6, 2017),
(6, 'emp-7', '22/06/2017', '10:57 AM', '7:02 PM', '08:05', '01:05', 6, 2017),
(7, 'emp-1', '23/06/2017', '11:02 AM', '7:06 PM', '08:04', '01:04', 6, 2017),
(8, 'emp-2', '23/06/2017', '11:03 AM', '7:06 PM', '08:03', '01:03', 6, 2017),
(9, 'emp-4', '23/06/2017', '12:03 PM', '6:06 PM', '06:03', '00:00', 6, 2017),
(10, 'emp-5', '23/06/2017', '12:04 PM', '6:20 PM', '06:16', '00:00', 6, 2017),
(11, 'emp-6', '23/06/2017', '10:04 AM', '6:23 PM', '08:19', '01:19', 6, 2017),
(12, 'emp-7', '23/06/2017', '10:04 AM', '6:23 PM', '08:19', '01:19', 6, 2017);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
