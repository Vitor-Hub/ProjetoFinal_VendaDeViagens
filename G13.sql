CREATE DATABASE  IF NOT EXISTS `adventurecity` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `adventurecity`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: adventurecity
-- ------------------------------------------------------
-- Server version	5.6.47-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(150) NOT NULL,
  `country` varchar(200) NOT NULL,
  `city` varchar(100) NOT NULL,
  `code` int(11) NOT NULL,
  `user` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'aaa','aaa','aaa',111,'pat');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creditcard`
--

DROP TABLE IF EXISTS `creditcard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `creditcard` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(100) NOT NULL,
  `card_number` varchar(200) NOT NULL,
  `card_name` varchar(100) NOT NULL,
  `cryptogram` int(11) NOT NULL,
  `month` varchar(20) NOT NULL,
  `year` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creditcard`
--

LOCK TABLES `creditcard` WRITE;
/*!40000 ALTER TABLE `creditcard` DISABLE KEYS */;
INSERT INTO `creditcard` VALUES (1,'pat','1111 1111 1111 1111','aaa',111,'May',2020);
/*!40000 ALTER TABLE `creditcard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activity_name` varchar(200) NOT NULL,
  `city` varchar(60) NOT NULL,
  `price` double NOT NULL,
  `description` text NOT NULL,
  `qty` int(11) DEFAULT NULL,
  `image_route1` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Sleepover at the zoo ','London ',100,'The appeal of a sleepover in (well, next to) the lion enclosure is obvious: it\'ll be like living in the real life \'Jungle Book\'. Hire a lodge, enjoy private guided tours around and get exclusive access to animal enclosures after hours. A two-course dinner and breakfast are included, so you won\'t have to worry about your rumbling stomach waking up the neighbours. \n',15,'image/london1.jpg'),(2,'The London Eye ','London ',30,'\"Step into your capsule and feel the exhilaration as you rise up over the water and come face to face with the Houses of Parliament and Big Ben. Soar above them, up to 135 meters on the world’s tallest cantilevered observation wheel. \n\nThere are mesmerizing 360-degree views of the whole city laid out before you. See the most famous landmarks including Buckingham Palace, St Paul’s Cathedral and the Tower of London and up to 40km out of the city to Windsor Castle on a clear day. Enjoy the gradual rotation and just stand and stare at the hustle and bustle of London life unfolding beneath you, the beautiful sunset over the city, or the thousands of twinkling lights after dark. \n\nAlso included with every ticket is the London Eye 4D Cinema Experience. A heartwarming must-see mini-movie with a few surprises - the perfect build up to your take-off. Enjoy an experience in one of the 32 high-tech glass capsules and enjoy discovering London from a different angle.\"\n',34,'image/london2.jpg'),(3,'London: Climb The Roof of The O2 Arena ','London ',40,'\"Meet your friendly instructors and get kitted out with climb suit, boots and harness. Become a true urban mountaineer. Ascend the incredible structure of the O2 Arena, an iconic London landmark, and cross the walkway suspended 52 meters in the air. Once at the top, pause to take in panoramic views over Greenwich, the Olympic Park, Tower Bridge, Big Ben, Canary Wharf and The Shard. \n\nClimb during the day and enjoy the clearest views for miles around, climb at sunset for a romantic experience, or opt for the twilight climb and marvel at the twinkling city lights below the twinkling stars. \n\nNervous? Don’t be. Experienced, professional guides will be with you every step of the way.\"\n',9,'image/london3.jpg'),(4,'See some of London’s most iconic sights to the sound of James Bond theme music ','London ',70,'Board a speedboat from Embankment Pier and get your adrenaline pumping to the sound of the Bond theme tune. Blast through Wapping and Canary Wharf up to the O2 Arena and back. Experience London in a fun, unique and memorable way\n',2,'image/london4.jpg '),(5,'The Parisian Catacombs ','Paris ',25,'It is an exceptional place to see in Paris. While being located underground it is not any less interesting. It is the city’s ossuary in which bones from several Parisian cemeteries were transferred at the end of the 18th century. About 6 million People are now resting in here among whom you can find different figures of the French Revolution such as Danton, Robespierre and Desmoulins.\n',27,'image/paris1.jpg '),(6,'Flight Simulator ','Paris',200,'You’ve dreamt about becoming an airline pilot? Here is your only chance to pilot an actual Boeing 737 (or nearly actual). In this simulation, you will be the captain, you will choose the destination and you will also go with a professional pilot.\n',27,'image/paris2.jpg '),(7,'Le Ballon de Paris / Ballon Generali ','Paris',55,'Located in the Parc André Citroën, rue de la Montagne de la Fage, here is an unforgettable experience in which you will get in a hot-air balloon and rise up to 150 metres above the roofs of Paris. It will give you a breathtaking view of the most beautiful city of the world.\n',17,'image/paris3.jpg '),(8,'Helicopter ride ','Paris',150,'Take a seat in the helicopter that will take you above the capital city and to Versailles. This journey will give a nice panorama on the capital and you will land with your eyes full of beautiful images.\n',10,'image/paris4.jpg '),(9,'Have dinner at Puerta57, inside the Santiago Bernabau Stadium ','Madrid',50,'This one’s for all the Real Madrid football fanatics out there! You’ll never go back to watching football games the same way again after dining at Puerta57. With an unparalleled view of the football field, you can dine in comfort and style while catching all the live action happening out there. Awesome or what?\n',30,'image/madrid1.jpg '),(10,'Learn To Dance the Flamenco ','Madrid',15,'\"It’s one thing to watch a flamenco show when you visit Madrid, but joining a dance class is even better! This soulful, passionate dance may look very serious but it’s a lot of fun to learn!\n\nFlamenco is a solo dance that originated from the Roma people in Spain. Dancers are usually accompanied by a singer and a guitar player. It’s characterized by hand clapping and intricate body movements! Learn how to elegantly sweep your arms and stomp your feet to the music!\"\n',6,'image/madrid2.jpg '),(11,'Madrid from above ','Madrid',10,'\"Visiting a new city is always a thrilling experience. But more often than not, we stay on the ground. So this is one is quite a new experience!\n\nBeing built in 1969, the Teleférico or Cable Car takes you from the north side of the city to Casa Campo.\n\nIt offers two stations. The motor station – Rosales and the tensor station – Casa de Campo. And it gives you access to stunning views of the city and a different perspective 627 and 651 meters above sea level perspectively.\n\nSo if you’re up for something different and relaxing to spend your time, ride the Cable Car. Not only do you enjoy the view of Madrid above, but you also miss the traffic in the city.\"\n',19,'image/madrid3.jpg '),(12,'The Museum of Alchemists and Magicians of Old Prague ','Prague',10,'PRAGUE IS A CITY STEEPED in history both known and otherwise, and the darker side of the Czech capital’s past is brought to light in evocative displays at The Museum of Alchemists and Magicians of Old Prague, which looks at some of the famous dabblers in the dark arts that have called the city home.\n',12,'image/prague1.jpg '),(13,'Olšany Cemetery ','Prague',10,'\"FOR A CEMETERY CREATED IN the hectic panic of a plague epidemic, Prague’s sprawling Olšany Cemetery is a beautifully planned public work.\n\nIn the 17th century it was considered unhygienic to bury the corpses of plague victims within city limits, so a large cemetery was designated in 1680 for this very purpose. When plague struck again a century later, Emperor Joseph II enacted a series of hygiene reforms and Olšany became the city’s official cemetery. It was continually used up until the 20th century, when a number of elaborate art nouveau grave monuments made the cemetery a place for sightseers, not just mourners.\"\n',11,'image/prague2.jpg '),(14,'Nuclear Bunker Tour','Prague',15,'\"If there is one thing you must do in Prague, it is this. We’ve spoken of our distaste for organised tours before, but it is impossible to visit a nuclear bunker in Prague independently. That was why we opted for this tour, and boy are we glad we did! Visiting a nuclear bunker in a decrepit part of Prague was definitely the highlight of our entire trip to Eastern Europe.\n\nThis ex-Soviet bunker, made during the Cold War, is located 5 stories under the ground. It is crammed with paraphernalia including gas masks, medical kits, and uniforms. The ambience is evocative of the paranoia and violence of the Cold War years and it is bound to send a chill down your spine.\"\n',5,'image/prague3.jpg ');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase`
--

DROP TABLE IF EXISTS `purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(60) NOT NULL,
  `product_name` varchar(200) NOT NULL,
  `date_purchase` date NOT NULL,
  `image_route` varchar(100) DEFAULT NULL,
  `city` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase`
--

LOCK TABLES `purchase` WRITE;
/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
INSERT INTO `purchase` VALUES (8,'pat','Sleepover at the zoo ','2020-05-04','image/london1.jpg','London'),(9,'pat','Madrid from above ','2020-05-04','image/madrid3.jpg ','Madrid'),(10,'pat','Sleepover at the zoo ','2020-05-04','image/london1.jpg','London'),(11,'pat','Have dinner at Puerta57, inside the Santiago Bernabau Stadium ','2020-05-04','image/madrid1.jpg ','Madrid'),(12,'pat','The Parisian Catacombs ','2020-05-04','image/paris1.jpg ','Paris'),(13,'pat','Sleepover at the zoo ','2020-05-05','image/london1.jpg','London'),(15,'pat','The Parisian Catacombs ','2020-05-05','image/paris1.jpg ','Paris'),(18,'pat','Le Ballon de Paris / Ballon Generali ','2020-05-05','image/paris3.jpg ','Paris'),(19,'pat','Helicopter ride ','2020-05-09','image/paris4.jpg ','Paris'),(20,'pat','Helicopter ride ','2020-05-09','image/paris4.jpg ','Paris'),(21,'pat','The Parisian Catacombs ','2020-05-09','image/paris1.jpg ','Paris '),(22,'pat','Sleepover at the zoo ','2020-05-09','image/london1.jpg','London '),(23,'pat','London: Climb The Roof of The O2 Arena ','2020-05-09','image/london3.jpg','London ');
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(60) NOT NULL,
  `email` varchar(60) NOT NULL,
  `password` varchar(60) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'pat','pat@comillas.es','pat'),(2,'admin','admin@comillas.es','admin'),(3,'otro','otro@comillas.es','otro'),(8,'bbb','clementgody@yahoo.fr','aaa');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-10 18:45:36
