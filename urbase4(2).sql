-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Lun 23 Janvier 2017 à 09:17
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `urbase4`
--

DELIMITER $$
--
-- Procédures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `example` ()  NO SQL
SELECT * from lot$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `example2` (IN `a` VARCHAR(233), IN `b` VARCHAR(233))  NO SQL
IF     a = "" THEN 
   -- SELECT * FROM lot;
   set @lot.lib_lot="DD";
    END IF$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `cession`
--

CREATE TABLE `cession` (
  `id_cession` int(11) NOT NULL,
  `date_attribution` date NOT NULL,
  `date_acte` date NOT NULL,
  `n_acte` int(11) NOT NULL,
  `id_lot` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `cession`
--

INSERT INTO `cession` (`id_cession`, `date_attribution`, `date_acte`, `n_acte`, `id_lot`) VALUES
(1, '2017-01-10', '2017-01-03', 2, NULL),
(2, '2017-01-02', '2017-01-10', 3, 2),
(3, '2017-01-10', '2017-01-03', 22, NULL),
(4, '2017-01-10', '2017-01-03', 2, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `concession`
--

CREATE TABLE `concession` (
  `id_consession` int(11) NOT NULL,
  `date_resolution` date NOT NULL,
  `date_remise` date NOT NULL,
  `id_lot` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `concession`
--

INSERT INTO `concession` (`id_consession`, `date_resolution`, `date_remise`, `id_lot`) VALUES
(1, '2017-01-04', '2017-01-11', 2),
(2, '2017-01-18', '2017-01-18', NULL);

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `gg`
-- (Voir ci-dessous la vue réelle)
--
CREATE TABLE `gg` (
`lib_w` varchar(30)
,`lib_zi` varchar(30)
,`nom_invst` varchar(30)
,`lib_lot` varchar(30)
);

-- --------------------------------------------------------

--
-- Structure de la table `investisseur`
--

CREATE TABLE `investisseur` (
  `id_invst` int(11) NOT NULL,
  `cod_invst` varchar(30) NOT NULL,
  `nom_invst` varchar(30) NOT NULL,
  `activite` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `investisseur`
--

INSERT INTO `investisseur` (`id_invst`, `cod_invst`, `nom_invst`, `activite`) VALUES
(1, 'A001', 'AMINE', 'URBA'),
(2, 'A0133', 'HAROUN', 'FINANCE'),
(3, 'AZ1111', 'KARIME', 'FINANCE'),
(4, 'A0133', 'HAROUN', 'FINANCE'),
(14, 'A0133', 'f', 'FINANCE'),
(15, 'A0133', 'aaazzz', 'FINANCE'),
(16, 'AZ1111', 'KARIME', 'FINANCE'),
(17, 'f', 'HAROUN', 'FINANCE'),
(18, '1', '2017-01-04', '');

-- --------------------------------------------------------

--
-- Structure de la table `lot`
--

CREATE TABLE `lot` (
  `id_lot` int(11) NOT NULL,
  `cod_lot` varchar(30) NOT NULL,
  `lib_lot` varchar(30) NOT NULL,
  `sup_lot` varchar(30) NOT NULL,
  `state_lot` varchar(30) DEFAULT 'LIBRE',
  `id_zi` int(11) DEFAULT NULL,
  `id_invst` int(11) DEFAULT NULL,
  `type_lot` tinyint(1) DEFAULT NULL,
  `pris_vent` double DEFAULT NULL,
  `situation_physique` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `lot`
--

INSERT INTO `lot` (`id_lot`, `cod_lot`, `lib_lot`, `sup_lot`, `state_lot`, `id_zi`, `id_invst`, `type_lot`, `pris_vent`, `situation_physique`) VALUES
(1, 'AZ0145', 'LOT', 'x1', 'RESERVER', 1, 1, 1, 0, ''),
(2, 'A224', 'LOT2', 'x1', 'RESERVER', NULL, 1, 0, 0, ''),
(3, 'Z333', 'LOT3', 'x1', 'RESERVER', NULL, 1, 0, 0, ''),
(4, 'AZZ33', 'LOT53', '555', 'RESERVER', NULL, 1, 0, 0, ''),
(6, 'R444', 'LOT8', '1234', 'LIBRE', 1, 3, 0, 0, ''),
(7, 'A44444', 'LO9', '12333', 'RESERVER', 19, 17, 0, 0, ''),
(9, 'ZE22', 'LOT62', '333', 'RESERVER', 1, 1, 0, 0, '');

--
-- Déclencheurs `lot`
--
DELIMITER $$
CREATE TRIGGER `RESERVER` BEFORE UPDATE ON `lot` FOR EACH ROW SET new.state_lot = "RESERVER"
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `nbr_lot` BEFORE UPDATE ON `lot` FOR EACH ROW if (new.id_zi<>old.id_zi) then
    
UPDATE zone_ind  SET nbr_lot =nbr_lot+1 where id_zi = NEW.id_zi;

  
    end if
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `permis_loture`
--

CREATE TABLE `permis_loture` (
  `id_pl` int(11) NOT NULL,
  `n_pl` int(11) NOT NULL,
  `date_arret` date NOT NULL,
  `date_publication` date NOT NULL,
  `n_publication` int(11) NOT NULL,
  `volume` int(11) NOT NULL,
  `plan_dossier1` varchar(30) DEFAULT NULL,
  `plan_dossier2` varchar(30) DEFAULT NULL,
  `plan_dossier3` varchar(30) DEFAULT NULL,
  `plan_dossier4` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `permis_loture`
--

INSERT INTO `permis_loture` (`id_pl`, `n_pl`, `date_arret`, `date_publication`, `n_publication`, `volume`, `plan_dossier1`, `plan_dossier2`, `plan_dossier3`, `plan_dossier4`) VALUES
(1, 1, '2017-01-04', '2017-01-24', 11, 22, '', '', '', ''),
(2, 3, '2017-01-04', '2017-01-24', 11, 22, NULL, NULL, NULL, NULL),
(4, 223, '2017-01-13', '2017-01-24', 11, 22, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `test`
-- (Voir ci-dessous la vue réelle)
--
CREATE TABLE `test` (
`lib_w` varchar(30)
,`lib_zi` varchar(30)
,`nom_invst` varchar(30)
,`lib_lot` varchar(30)
);

-- --------------------------------------------------------

--
-- Structure de la table `wilya`
--

CREATE TABLE `wilya` (
  `id_w` int(11) NOT NULL,
  `code_w` int(11) NOT NULL,
  `lib_w` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `wilya`
--

INSERT INTO `wilya` (`id_w`, `code_w`, `lib_w`) VALUES
(1, 19, 'SETIF');

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `x`
-- (Voir ci-dessous la vue réelle)
--
CREATE TABLE `x` (
`lib_lot` varchar(30)
,`nom_invst` varchar(30)
);

-- --------------------------------------------------------

--
-- Structure de la table `zone_ind`
--

CREATE TABLE `zone_ind` (
  `id_zi` int(11) NOT NULL,
  `code_zi` varchar(30) NOT NULL,
  `lib_zi` varchar(30) NOT NULL,
  `sup_zi` varchar(30) NOT NULL,
  `id_w` int(11) DEFAULT NULL,
  `date_Creation` date DEFAULT NULL,
  `nbr_lot` int(11) DEFAULT '0',
  `OBSERVATION` varchar(50) NOT NULL,
  `nbr_lotS` int(11) NOT NULL,
  `nbr_lotC` int(11) NOT NULL,
  `Sup_Cess` double NOT NULL,
  `Sup_VS` double NOT NULL,
  `n_pl` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `zone_ind`
--

INSERT INTO `zone_ind` (`id_zi`, `code_zi`, `lib_zi`, `sup_zi`, `id_w`, `date_Creation`, `nbr_lot`, `OBSERVATION`, `nbr_lotS`, `nbr_lotC`, `Sup_Cess`, `Sup_VS`, `n_pl`) VALUES
(1, 'A014', 'EXTENSION', '1233M', 1, NULL, 6, '', 0, 0, 0, 0, 1),
(12, 'r0121', 'elilma', '1235', 1, '2017-01-10', 5, 'amine', 0, 0, 0, 0, NULL),
(19, 'r0121', 'elilma', '1235', 1, '2017-01-02', 6, 'ffffddf', 0, 0, 0, 0, NULL),
(22, 'r0121', 'elilmaA', '1235', 1, '2017-01-24', 5, '', 0, 0, 0, 0, NULL);

-- --------------------------------------------------------

--
-- Structure de la vue `gg`
--
DROP TABLE IF EXISTS `gg`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `gg`  AS  select `wilya`.`lib_w` AS `lib_w`,`zone_ind`.`lib_zi` AS `lib_zi`,`investisseur`.`nom_invst` AS `nom_invst`,`lot`.`lib_lot` AS `lib_lot` from (((`investisseur` join `lot`) join `wilya`) join `zone_ind`) where ((`wilya`.`id_w` = `zone_ind`.`id_w`) and (`zone_ind`.`id_zi` = `lot`.`id_zi`) and (`investisseur`.`id_invst` = `lot`.`id_invst`)) ;

-- --------------------------------------------------------

--
-- Structure de la vue `test`
--
DROP TABLE IF EXISTS `test`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `test`  AS  select `wilya`.`lib_w` AS `lib_w`,`zone_ind`.`lib_zi` AS `lib_zi`,`investisseur`.`nom_invst` AS `nom_invst`,`lot`.`lib_lot` AS `lib_lot` from (((`investisseur` join `lot`) join `wilya`) join `zone_ind`) where ((`wilya`.`id_w` = `zone_ind`.`id_w`) and (`zone_ind`.`id_zi` = `lot`.`id_zi`) and (`investisseur`.`id_invst` = `lot`.`id_invst`)) ;

-- --------------------------------------------------------

--
-- Structure de la vue `x`
--
DROP TABLE IF EXISTS `x`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `x`  AS  select `lot`.`lib_lot` AS `lib_lot`,`investisseur`.`nom_invst` AS `nom_invst` from (`lot` join `investisseur`) where (`lot`.`id_invst` = `investisseur`.`id_invst`) ;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `cession`
--
ALTER TABLE `cession`
  ADD PRIMARY KEY (`id_cession`),
  ADD KEY `id_lot` (`id_lot`);

--
-- Index pour la table `concession`
--
ALTER TABLE `concession`
  ADD PRIMARY KEY (`id_consession`),
  ADD KEY `id_lot` (`id_lot`);

--
-- Index pour la table `investisseur`
--
ALTER TABLE `investisseur`
  ADD PRIMARY KEY (`id_invst`);

--
-- Index pour la table `lot`
--
ALTER TABLE `lot`
  ADD PRIMARY KEY (`id_lot`),
  ADD KEY `id_zi` (`id_zi`),
  ADD KEY `id_invst` (`id_invst`);

--
-- Index pour la table `permis_loture`
--
ALTER TABLE `permis_loture`
  ADD PRIMARY KEY (`id_pl`);

--
-- Index pour la table `wilya`
--
ALTER TABLE `wilya`
  ADD PRIMARY KEY (`id_w`);

--
-- Index pour la table `zone_ind`
--
ALTER TABLE `zone_ind`
  ADD PRIMARY KEY (`id_zi`),
  ADD KEY `id_w` (`id_w`),
  ADD KEY `n_pl` (`n_pl`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `cession`
--
ALTER TABLE `cession`
  MODIFY `id_cession` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `concession`
--
ALTER TABLE `concession`
  MODIFY `id_consession` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `investisseur`
--
ALTER TABLE `investisseur`
  MODIFY `id_invst` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT pour la table `lot`
--
ALTER TABLE `lot`
  MODIFY `id_lot` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT pour la table `permis_loture`
--
ALTER TABLE `permis_loture`
  MODIFY `id_pl` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `zone_ind`
--
ALTER TABLE `zone_ind`
  MODIFY `id_zi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `cession`
--
ALTER TABLE `cession`
  ADD CONSTRAINT `cession_lot` FOREIGN KEY (`id_lot`) REFERENCES `lot` (`id_lot`) ON DELETE SET NULL ON UPDATE SET NULL;

--
-- Contraintes pour la table `concession`
--
ALTER TABLE `concession`
  ADD CONSTRAINT `concession_lot` FOREIGN KEY (`id_lot`) REFERENCES `lot` (`id_lot`) ON DELETE SET NULL ON UPDATE SET NULL;

--
-- Contraintes pour la table `lot`
--
ALTER TABLE `lot`
  ADD CONSTRAINT `lot_invst` FOREIGN KEY (`id_invst`) REFERENCES `investisseur` (`id_invst`) ON DELETE SET NULL ON UPDATE SET NULL,
  ADD CONSTRAINT `lot_zone` FOREIGN KEY (`id_zi`) REFERENCES `zone_ind` (`id_zi`) ON DELETE SET NULL ON UPDATE SET NULL;

--
-- Contraintes pour la table `zone_ind`
--
ALTER TABLE `zone_ind`
  ADD CONSTRAINT `wilaya_zone` FOREIGN KEY (`id_w`) REFERENCES `wilya` (`id_w`) ON DELETE SET NULL ON UPDATE SET NULL,
  ADD CONSTRAINT `zone_pl` FOREIGN KEY (`n_pl`) REFERENCES `permis_loture` (`id_pl`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
