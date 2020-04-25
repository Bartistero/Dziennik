-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 25 Kwi 2020, 12:42
-- Wersja serwera: 10.4.11-MariaDB
-- Wersja PHP: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `students`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `marks`
--

CREATE TABLE `marks` (
  `ID` int(2) DEFAULT NULL,
  `Name` varchar(8) DEFAULT NULL,
  `Surrname` varchar(9) DEFAULT NULL,
  `spr1` text DEFAULT NULL,
  `spr2` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `marks`
--

INSERT INTO `marks` (`ID`, `Name`, `Surrname`, `spr1`, `spr2`) VALUES
(0, 'Rogan', 'Oneal', '2', '1'),
(1, 'Gisela', 'Duran', '2', '1'),
(2, 'Emmanuel', 'Ward', '2', '1'),
(3, 'Hall', 'Osborne', '2', '1'),
(4, 'Dylan', 'Mccall', '2', '1'),
(5, 'Justin', 'Ayers', '2', '1'),
(6, 'Germaine', 'Barry', '2', '1'),
(7, 'Ifeoma', 'Kirkland', '1', '1'),
(8, 'Charde', 'Mcdowell', '1', '1'),
(9, 'Giselle', 'Sheppard', '1', '1'),
(10, 'Thaddeus', 'Cardenas', '1', '1'),
(11, 'Acton', 'Kim', '1', '1'),
(12, 'Ava', 'Swanson', '1', '1'),
(13, 'April', 'Shepherd', '1', '1'),
(14, 'Ahmed', 'Lancaster', '1', '1'),
(15, 'Tanner', 'Wolfe', '1', '1'),
(16, 'Buffy', 'Poole', '4', '1'),
(17, 'Theodore', 'Anthony', '4', '1'),
(18, 'Herman', 'Gilbert', '4', '1'),
(19, 'Dillon', 'Manning', '6', '1'),
(20, 'Xaviera', 'Soto', '6', '1'),
(21, 'Thor', 'Berg', '5', '1'),
(22, 'Joel', 'Tyson', '5', '1'),
(23, 'Mannix', 'Estrada', '5', '1'),
(24, 'Harding', 'Richard', '5', '1'),
(25, 'Phillip', 'Ford', '1', '1'),
(26, 'Amir', 'Cervantes', '1', '1'),
(27, 'Cameron', 'Booth', '1', '1'),
(28, 'Willow', 'Wilcox', '1', '1'),
(29, 'Akeem', 'Simon', '1', '1');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `personaldata`
--

CREATE TABLE `personaldata` (
  `ID` int(11) NOT NULL,
  `Name` text NOT NULL,
  `Surrname` text NOT NULL,
  `Addres` text NOT NULL,
  `PESEL` text NOT NULL,
  `Tel` text NOT NULL,
  `eMail` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `personaldata`
--

INSERT INTO `personaldata` (`ID`, `Name`, `Surrname`, `Addres`, `PESEL`, `Tel`, `eMail`) VALUES
(0, 'Rogan', 'Oneal', '1172 West Northern Mariana Islands Blvd.', '308-86-9103', '986-080-5685', 'Desirae@dapibus.us'),
(1, 'Gisela', 'Duran', '71139  Korea Ln.', '852-39-5525', '307-376-3492', 'Lacota@arcu.net'),
(2, 'Emmanuel', 'Ward', '62237 North Andorra Blvd.', '205-25-4193', '811-316-2165', 'Odette@facilisis.net'),
(3, 'Hall', 'Osborne', '32032 South Suriname Ln.', '311-57-7292', '489-916-6739', 'Jelani@odio.org'),
(4, 'Dylan', 'Mccall', '92836 South Antigua and Barbuda Ln.', '441-58-1190', '679-295-7719', 'Ashton@montes.net'),
(5, 'Justin', 'Ayers', '45634 North Duquesne Ave.', '110-68-5480', '018-534-6845', 'Kirk@nec.us'),
(6, 'Germaine', 'Barry', '67918 East Turks and Caicos Islands Ave.', '384-24-0542', '931-116-2273', 'Sybil@viverra.edu'),
(7, 'Ifeoma', 'Kirkland', '83005  Flagstaff Way', '669-25-5083', '292-270-0166', 'Oleg@ridiculus.org'),
(8, 'Charde', 'Mcdowell', '82834 South Ecuador Ln.', '799-07-2871', '217-679-8341', 'Yen@rhoncus.org'),
(9, 'Giselle', 'Sheppard', '86063 West Dominican Republic Ct.', '792-51-8924', '584-420-8516', 'Reed@inceptos.net'),
(10, 'Thaddeus', 'Cardenas', '70396 North Virgin Islands, U.S. Ct.', '204-16-0730', '509-127-4461', 'Colton@interdum.gov'),
(11, 'Acton', 'Kim', '94309 West Cortland Ln.', '158-78-8891', '343-890-3637', 'Hoyt@lectus.us'),
(12, 'Ava', 'Swanson', '70132  American Samoa Ct.', '607-24-9765', '657-194-7954', 'Colorado@molestie.com'),
(13, 'April', 'Shepherd', '91723 North Holy See (Vatican City State) Ln.', '275-96-2784', '089-193-6489', 'Shelley@habitant.com'),
(14, 'Ahmed', 'Lancaster', '36549 North Grand Rapids Ln.', '465-20-9406', '887-081-3398', 'Alice@interdum.edu'),
(15, 'Tanner', 'Wolfe', '34063  Prescott Ln.', '066-93-2873', '650-868-6596', 'Doris@Aliquam.net'),
(16, 'Buffy', 'Poole', '59601 West Oklahoma City St.', '631-42-7947', '944-604-6472', 'Ina@eget.gov'),
(17, 'Theodore', 'Anthony', '51775  Argentina St.', '324-68-3411', '173-420-6219', 'Kiayada@sollicitudin.net'),
(18, 'Herman', 'Gilbert', '97683 West Bhutan St.', '656-10-8346', '057-528-0907', 'Elizabeth@in.net'),
(19, 'Dillon', 'Manning', '57889 North Senegal Ct.', '686-61-9217', '541-181-3086', 'Reece@Nulla.net'),
(20, 'Xaviera', 'Soto', '6471 West Benin St.', '221-70-6533', '599-217-7364', 'Quamar@augue.edu'),
(21, 'Thor', 'Berg', '61896 North Nepal Way', '394-34-2212', '016-217-9120', 'Echo@eget.org'),
(22, 'Joel', 'Tyson', '49609 North Cape Verde Way', '970-42-1861', '966-803-4607', 'Driscoll@dignissim.edu'),
(23, 'Mannix', 'Estrada', '19934  Bangladesh Blvd.', '755-98-4773', '197-286-9414', 'Dora@lorem.gov'),
(24, 'Harding', 'Richard', '33991 South Huntington Park Ave.', '847-27-6818', '097-810-8253', 'Hunter@amet.com'),
(25, 'Phillip', 'Ford', '57226 West Gabon Ct.', '937-89-1498', '701-940-0556', 'Patience@lacus.gov'),
(26, 'Amir', 'Cervantes', '2424 East Marshall Islands Way', '169-79-4755', '397-805-5017', 'Brynn@mi.com'),
(27, 'Cameron', 'Booth', '7008 South Costa Rica Way', '604-66-1716', '558-170-3887', 'Orla@fringilla.edu'),
(28, 'Willow', 'Wilcox', '58271 South Uruguay St.', '734-28-0628', '594-546-4433', 'Nolan@Morbi.us'),
(29, 'Akeem', 'Simon', '27604 West Germany Ave.', '811-81-7636', '289-341-2928', 'Jade@nec.com');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `present`
--

CREATE TABLE `present` (
  `Id` int(2) DEFAULT NULL,
  `Name` varchar(8) DEFAULT NULL,
  `Surrname` varchar(9) DEFAULT NULL,
  `23.04.2020` text DEFAULT NULL,
  `21.04.2020` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `present`
--

INSERT INTO `present` (`Id`, `Name`, `Surrname`, `23.04.2020`, `21.04.2020`) VALUES
(0, 'Rogan', 'Oneal', '+', '-'),
(1, 'Gisela', 'Duran', '+', '+'),
(2, 'Emmanuel', 'Ward', '+', '+'),
(3, 'Hall', 'Osborne', '+', '+'),
(4, 'Dylan', 'Mccall', '+', '-'),
(5, 'Justin', 'Ayers', '-', '-'),
(6, 'Germaine', 'Barry', '+', '-'),
(7, 'Ifeoma', 'Kirkland', '-', '-'),
(8, 'Charde', 'Mcdowell', '-', 'S'),
(9, 'Giselle', 'Sheppard', '-', 'S'),
(10, 'Thaddeus', 'Cardenas', 'S', 'S'),
(11, 'Acton', 'Kim', 'S', 'S'),
(12, 'Ava', 'Swanson', 'S', 'S'),
(13, 'April', 'Shepherd', 'S', 'S'),
(14, 'Ahmed', 'Lancaster', 'S', 'S'),
(15, 'Tanner', 'Wolfe', 'S', 'S'),
(16, 'Buffy', 'Poole', 'S', '+'),
(17, 'Theodore', 'Anthony', '+', '+'),
(18, 'Herman', 'Gilbert', '+', '+'),
(19, 'Dillon', 'Manning', '+', '+'),
(20, 'Xaviera', 'Soto', '+', '+'),
(21, 'Thor', 'Berg', 'S', '+'),
(22, 'Joel', 'Tyson', 'S', '+'),
(23, 'Mannix', 'Estrada', 'S', '-'),
(24, 'Harding', 'Richard', 'S', '-'),
(25, 'Phillip', 'Ford', '+', '-'),
(26, 'Amir', 'Cervantes', '+', '-'),
(27, 'Cameron', 'Booth', '+', '-'),
(28, 'Willow', 'Wilcox', '+', '-'),
(29, 'Akeem', 'Simon', '-', '-');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
