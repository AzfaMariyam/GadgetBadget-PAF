-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 25, 2021 at 07:34 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.4.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `paymentgb`
--

-- --------------------------------------------------------

--
-- Table structure for table `carddetails`
--

CREATE TABLE `carddetails` (
  `cardDetID` int(11) NOT NULL,
  `cardType` varchar(20) CHARACTER SET latin1 NOT NULL,
  `cardNo` int(19) NOT NULL,
  `expMonth` int(2) NOT NULL,
  `expYear` int(2) NOT NULL,
  `securityCode` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `carddetails`
--

INSERT INTO `carddetails` (`cardDetID`, `cardType`, `cardNo`, `expMonth`, `expYear`, `securityCode`) VALUES
(1, 'Debit', 980000, 8, 25, 222),
(3, 'Debit', 1256789, 2, 21, 211),
(4, 'Debit', 89998900, 1, 26, 237),
(5, 'Debit', 764532200, 11, 26, 890),
(6, 'Credit', 20045453, 12, 24, 856);

-- --------------------------------------------------------

--
-- Table structure for table `shippingdetails`
--

CREATE TABLE `shippingdetails` (
  `shipmentID` int(11) NOT NULL,
  `firstName` varchar(20) CHARACTER SET latin1 NOT NULL,
  `lastName` varchar(30) CHARACTER SET latin1 NOT NULL,
  `address` varchar(100) CHARACTER SET latin1 NOT NULL,
  `city` varchar(25) CHARACTER SET latin1 NOT NULL,
  `country` varchar(25) CHARACTER SET latin1 NOT NULL,
  `zipcode` int(5) NOT NULL,
  `phoneno` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `shippingdetails`
--

INSERT INTO `shippingdetails` (`shipmentID`, `firstName`, `lastName`, `address`, `city`, `country`, `zipcode`, `phoneno`) VALUES
(2, 'Kamal', 'Perera', 'Flower Road', 'Colombo', 'Sri Lanka', 3445, 778909090),
(3, 'Anne', 'Brown', 'Dam Street', 'London', 'England', 3455, 775656777),
(4, 'Anjelina', 'Jolie', '1st Street', 'New York', 'USA', 8932, 853355780),
(5, 'Priyanka', 'Chopra', 'Flower Drive', 'Mumbai', 'India', 221, 997855780);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `carddetails`
--
ALTER TABLE `carddetails`
  ADD PRIMARY KEY (`cardDetID`);

--
-- Indexes for table `shippingdetails`
--
ALTER TABLE `shippingdetails`
  ADD PRIMARY KEY (`shipmentID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `carddetails`
--
ALTER TABLE `carddetails`
  MODIFY `cardDetID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `shippingdetails`
--
ALTER TABLE `shippingdetails`
  MODIFY `shipmentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
