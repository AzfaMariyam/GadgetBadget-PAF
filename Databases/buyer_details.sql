-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2021 at 11:40 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `buyers`
--

-- --------------------------------------------------------

--
-- Table structure for table `buyer_details`
--

CREATE TABLE `buyer_details` (
  `BuyerID` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Gender` varchar(1) NOT NULL,
  `Address` text NOT NULL,
  `ContactNo` varchar(10) NOT NULL,
  `Email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `buyer_details`
--

INSERT INTO `buyer_details` (`BuyerID`, `Name`, `Gender`, `Address`, `ContactNo`, `Email`) VALUES
(5, 'Tharu', 'F', 'Ragama', '0774522236', 'tharu@gmail.com'),
(6, 'Sew', 'F', 'Kandy', '0774555778', 'sew@gmail.com'),
(7, 'Ruvi', 'F', 'Mathugama', '0715466235', 'ruvi@gmail.com'),
(8, 'Azfa', 'F', 'Dehiwala', '0715466445', 'azfa@gmail.com'),
(9, 'Priya', 'F', 'Colombo', '0715444545', 'priya@gmail.com'),
(10, 'Senith', 'M', 'Colombo', '0717784666', 'senith@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buyer_details`
--
ALTER TABLE `buyer_details`
  ADD PRIMARY KEY (`BuyerID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `buyer_details`
--
ALTER TABLE `buyer_details`
  MODIFY `BuyerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
