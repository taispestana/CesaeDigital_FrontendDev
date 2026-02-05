-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: laraflix
-- ------------------------------------------------------
-- Server version	8.0.44

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
-- Table structure for table `cache`
--

DROP TABLE IF EXISTS `cache`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cache` (
  `key` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `value` mediumtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `expiration` int NOT NULL,
  PRIMARY KEY (`key`),
  KEY `cache_expiration_index` (`expiration`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cache`
--

LOCK TABLES `cache` WRITE;
/*!40000 ALTER TABLE `cache` DISABLE KEYS */;
INSERT INTO `cache` VALUES ('laraflix-cache-test@example.com|127.0.0.1','i:1;',1769974912),('laraflix-cache-test@example.com|127.0.0.1:timer','i:1769974912;',1769974912);
/*!40000 ALTER TABLE `cache` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cache_locks`
--

DROP TABLE IF EXISTS `cache_locks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cache_locks` (
  `key` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `owner` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `expiration` int NOT NULL,
  PRIMARY KEY (`key`),
  KEY `cache_locks_expiration_index` (`expiration`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cache_locks`
--

LOCK TABLES `cache_locks` WRITE;
/*!40000 ALTER TABLE `cache_locks` DISABLE KEYS */;
/*!40000 ALTER TABLE `cache_locks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `image` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Ação','https://images.unsplash.com/photo-1594909122845-11baa439b7bf?auto=format&fit=crop&w=800&q=80','2026-01-29 10:15:28','2026-01-29 10:15:28'),(2,'Ficção Científica','https://images.unsplash.com/photo-1534447677768-be436bb09401?auto=format&fit=crop&w=800&q=80','2026-01-29 10:15:28','2026-01-29 10:15:28'),(3,'Drama','https://images.unsplash.com/photo-1485846234645-a62644f84728?auto=format&fit=crop&w=800&q=80','2026-01-29 10:15:28','2026-01-29 10:15:28'),(4,'Clássicos','https://images.unsplash.com/photo-1478720568477-152d9b164e26?auto=format&fit=crop&w=800&q=80','2026-01-29 10:15:28','2026-01-29 10:15:28');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `failed_jobs`
--

DROP TABLE IF EXISTS `failed_jobs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `failed_jobs` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `connection` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `queue` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `payload` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `exception` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `failed_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `failed_jobs_uuid_unique` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `failed_jobs`
--

LOCK TABLES `failed_jobs` WRITE;
/*!40000 ALTER TABLE `failed_jobs` DISABLE KEYS */;
/*!40000 ALTER TABLE `failed_jobs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_batches`
--

DROP TABLE IF EXISTS `job_batches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job_batches` (
  `id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `total_jobs` int NOT NULL,
  `pending_jobs` int NOT NULL,
  `failed_jobs` int NOT NULL,
  `failed_job_ids` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `options` mediumtext COLLATE utf8mb4_unicode_ci,
  `cancelled_at` int DEFAULT NULL,
  `created_at` int NOT NULL,
  `finished_at` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_batches`
--

LOCK TABLES `job_batches` WRITE;
/*!40000 ALTER TABLE `job_batches` DISABLE KEYS */;
/*!40000 ALTER TABLE `job_batches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobs`
--

DROP TABLE IF EXISTS `jobs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jobs` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `queue` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `payload` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `attempts` tinyint unsigned NOT NULL,
  `reserved_at` int unsigned DEFAULT NULL,
  `available_at` int unsigned NOT NULL,
  `created_at` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `jobs_queue_index` (`queue`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobs`
--

LOCK TABLES `jobs` WRITE;
/*!40000 ALTER TABLE `jobs` DISABLE KEYS */;
/*!40000 ALTER TABLE `jobs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `migrations`
--

DROP TABLE IF EXISTS `migrations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `migrations` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `migration` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `migrations`
--

LOCK TABLES `migrations` WRITE;
/*!40000 ALTER TABLE `migrations` DISABLE KEYS */;
INSERT INTO `migrations` VALUES (1,'0001_01_01_000000_create_users_table',1),(2,'0001_01_01_000001_create_cache_table',1),(3,'0001_01_01_000002_create_jobs_table',1),(4,'2026_01_21_114746_create_categories_table',1),(5,'2026_01_21_114815_create_movies_table',1),(6,'2026_01_21_115857_add_role_to_users_table',1),(7,'2026_01_27_201548_add_detailed_fields_to_movies_table',1),(8,'2026_01_30_182926_create_movie_user_table',2),(9,'2026_02_01_200506_add_profile_photo_path_to_users_table',3);
/*!40000 ALTER TABLE `migrations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_user`
--

DROP TABLE IF EXISTS `movie_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_user` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint unsigned NOT NULL,
  `movie_id` bigint unsigned NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `movie_user_user_id_movie_id_unique` (`user_id`,`movie_id`),
  KEY `movie_user_movie_id_foreign` (`movie_id`),
  CONSTRAINT `movie_user_movie_id_foreign` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`) ON DELETE CASCADE,
  CONSTRAINT `movie_user_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_user`
--

LOCK TABLES `movie_user` WRITE;
/*!40000 ALTER TABLE `movie_user` DISABLE KEYS */;
INSERT INTO `movie_user` VALUES (1,2,2,NULL,NULL),(3,2,8,NULL,NULL),(5,2,11,NULL,NULL),(7,2,21,NULL,NULL),(8,2,23,NULL,NULL),(9,2,26,NULL,NULL),(10,2,20,NULL,NULL),(13,8,3,NULL,NULL),(14,2,3,NULL,NULL);
/*!40000 ALTER TABLE `movie_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movies` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `category_id` bigint unsigned NOT NULL,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `synopsis` text COLLATE utf8mb4_unicode_ci,
  `rating` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `imdb_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `image` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `poster_url` text COLLATE utf8mb4_unicode_ci,
  `release_date` date NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `movies_imdb_id_unique` (`imdb_id`),
  KEY `movies_category_id_foreign` (`category_id`),
  CONSTRAINT `movies_category_id_foreign` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (1,1,'Gladiator','Maximus is a powerful Roman general, loved by the people and the aging Emperor, Marcus Aurelius. Before his death, the Emperor chooses Maximus to be his heir over his own son, Commodus, and a power struggle leaves Maximus and his family condemned to death. The powerful general is unable to save his family, and his loss of will allows him to get captured and put into the Gladiator games until he dies. The only desire that fuels him now is the chance to rise to the top so that he will be able to look into the eyes of the man who will feel his revenge.','8.5','tt0172495',NULL,'https://m.media-amazon.com/images/M/MV5BYWQ4YmNjYjEtOWE1Zi00Y2U4LWI4NTAtMTU0MjkxNWQ1ZmJiXkEyXkFqcGc@._V1_SX300.jpg','2017-01-29','2026-01-29 10:15:28','2026-01-29 10:17:14'),(2,1,'The Dark Knight','Set within a year after the events of Batman Begins (2005), Batman, Lieutenant James Gordon, and new District Attorney Harvey Dent successfully begin to round up the criminals that plague Gotham City, until a mysterious and sadistic criminal mastermind known only as \"The Joker\" appears in Gotham, creating a new wave of chaos. Batman\'s struggle against The Joker becomes deeply personal, forcing him to \"confront everything he believes\" and improve his technology to stop him. A love triangle develops between Bruce Wayne, Dent, and Rachel Dawes.','9.1','tt0468569',NULL,'https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_SX300.jpg','2005-01-29','2026-01-29 10:15:28','2026-01-29 10:17:14'),(3,1,'John Wick','With the untimely death of his beloved wife still bitter in his mouth, John Wick, the expert former assassin, receives one final gift from her--a precious keepsake to help John find a new meaning in life now that she is gone. But when the arrogant Russian mob prince, Iosef Tarasov, and his men pay Wick a rather unwelcome visit to rob him of his prized 1969 Mustang and his wife\'s present, the legendary hitman will be forced to unearth his meticulously concealed identity. Blind with revenge, John will immediately unleash a carefully orchestrated maelstrom of destruction against the sophisticated kingpin, Viggo Tarasov, and his family, who are fully aware of his lethal capacity. Now, only blood can quench the boogeyman\'s thirst for retribution.','7.5','tt2911666',NULL,'https://m.media-amazon.com/images/M/MV5BMTU2NjA1ODgzMF5BMl5BanBnXkFtZTgwMTM2MTI4MjE@._V1_SX300.jpg','2002-01-29','2026-01-29 10:15:28','2026-01-29 10:17:15'),(4,1,'Mad Max: Fury Road','An apocalyptic story set in the furthest reaches of our planet, in a stark desert landscape where humanity is broken, and almost everyone is crazed fighting for the necessities of life. Within this world exist two rebels on the run who just might be able to restore order. There\'s Max, a man of action and a man of few words, who seeks peace of mind following the loss of his wife and child in the aftermath of the chaos. And Furiosa, a woman of action and a woman who believes her path to survival may be achieved if she can make it across the desert back to her childhood homeland.','8.1','tt1392190',NULL,'https://m.media-amazon.com/images/M/MV5BZDRkODJhOTgtOTc1OC00NTgzLTk4NjItNDgxZDY4YjlmNDY2XkEyXkFqcGc@._V1_SX300.jpg','2019-01-29','2026-01-29 10:15:28','2026-01-29 10:17:15'),(5,2,'Inception','Dom Cobb is a skilled thief, the absolute best in the dangerous art of extraction, stealing valuable secrets from deep within the subconscious during the dream state, when the mind is at its most vulnerable. Cobb\'s rare ability has made him a coveted player in this treacherous new world of corporate espionage, but it has also made him an international fugitive and cost him everything he has ever loved. Now Cobb is being offered a chance at redemption. One last job could give him his life back but only if he can accomplish the impossible, inception. Instead of the perfect heist, Cobb and his team of specialists have to pull off the reverse: their task is not to steal an idea, but to plant one. If they succeed, it could be the perfect crime. But no amount of careful planning or expertise can prepare the team for the dangerous enemy that seems to predict their every move. An enemy that only Cobb could have seen coming.','8.8','tt1375666',NULL,'https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg','2002-01-29','2026-01-29 10:15:28','2026-01-29 10:17:16'),(6,2,'The Matrix','Thomas A. Anderson is a man living two lives. By day he is an average computer programmer and by night a hacker known as Neo. Neo has always questioned his reality, but the truth is far beyond his imagination. Neo finds himself targeted by the police when he is contacted by Morpheus, a legendary computer hacker branded a terrorist by the government. As a rebel against the machines, Neo must confront the agents: super-powerful computer programs devoted to stopping Neo and the entire human rebellion.','8.7','tt0133093',NULL,'https://m.media-amazon.com/images/M/MV5BN2NmN2VhMTQtMDNiOS00NDlhLTliMjgtODE2ZTY0ODQyNDRhXkEyXkFqcGc@._V1_SX300.jpg','2017-01-29','2026-01-29 10:15:28','2026-01-29 10:17:16'),(7,1,'Die Hard','NYPD cop John McClane goes on a Christmas vacation to visit his wife Holly in Los Angeles where she works for the Nakatomi Corporation. While they are at the Nakatomi headquarters for a Christmas party, a group of robbers led by Hans Gruber take control of the building and hold everyone hostage, with the exception of John, while they plan to perform a lucrative heist. Unable to escape and with no immediate police response, John is forced to take matters into his own hands.','8.2','tt0095016',NULL,'https://m.media-amazon.com/images/M/MV5BMGNlYmM1NmQtYWExMS00NmRjLTg5ZmEtMmYyYzJkMzljYWMxXkEyXkFqcGc@._V1_SX300.jpg','2015-01-29','2026-01-29 10:15:28','2026-01-29 10:17:15'),(8,1,'Top Gun: Maverick','The story involves Maverick confronting his past while training a group of younger Top Gun graduates, including the son of his deceased best friend, for a dangerous mission.','8.2','tt1745960',NULL,'https://m.media-amazon.com/images/M/MV5BMDBkZDNjMWEtOTdmMi00NmExLTg5MmMtNTFlYTJlNWY5YTdmXkEyXkFqcGc@._V1_SX300.jpg','2007-01-29','2026-01-29 10:15:28','2026-01-29 10:17:15'),(9,1,'Extraction','In an underworld of weapons dealers and traffickers, a young boy becomes the pawn in a war between notorious drug lords. Trapped by kidnappers inside one of the world\'s most impenetrable cities, his rescue beckons the unparalleled skill of a mercenary named Tyler Rake, but Rake is a broken man with nothing to lose, harboring a death wish that makes an already deadly mission near impossible.','6.8','tt8936646',NULL,'https://m.media-amazon.com/images/M/MV5BNDBhMmI3OWYtZTA2Ny00Y2RjLTliMWQtYWY5MGIwN2RlZGFjXkEyXkFqcGc@._V1_SX300.jpg','2020-01-29','2026-01-29 10:15:28','2026-01-29 10:17:16'),(10,1,'The Batman','When a sadistic serial killer begins murdering key political figures in Gotham, the Batman is forced to investigate the city\'s hidden corruption and question his family\'s involvement.','7.8','tt1877830',NULL,'https://m.media-amazon.com/images/M/MV5BMmU5NGJlMzAtMGNmOC00YjJjLTgyMzUtNjAyYmE4Njg5YWMyXkEyXkFqcGc@._V1_SX300.jpg','2012-01-29','2026-01-29 10:15:28','2026-01-29 10:17:16'),(11,2,'Interstellar','Earth\'s future has been riddled by disasters, famines, and droughts. There is only one way to ensure mankind\'s survival: Interstellar travel. A newly discovered wormhole in the far reaches of our solar system allows a team of astronauts to go where no man has gone before, a planet that may have the right environment to sustain human life.','8.7','tt0816692',NULL,'https://m.media-amazon.com/images/M/MV5BYzdjMDAxZGItMjI2My00ODA1LTlkNzItOWFjMDU5ZDJlYWY3XkEyXkFqcGc@._V1_SX300.jpg','2017-01-29','2026-01-29 10:15:28','2026-01-29 10:17:16'),(12,2,'Blade Runner 2049','Thirty years after the events of Blade Runner (1982), a new Blade Runner, L.A.P.D. Officer \"K\" (Ryan Gosling), unearths a long-buried secret that has the potential to plunge what\'s left of society into chaos. K\'s discovery leads him on a quest to find Rick Deckard (Harrison Ford), a former L.A.P.D. Blade Runner, who has been missing for thirty years.','8.0','tt1856101',NULL,'https://m.media-amazon.com/images/M/MV5BNzA1Njg4NzYxOV5BMl5BanBnXkFtZTgwODk5NjU3MzI@._V1_SX300.jpg','1998-01-29','2026-01-29 10:15:28','2026-01-29 10:17:17'),(13,2,'Dune','In the distant year of 10191, all the planets of the known Universe are under the control of Padishah Emperor Shaddam IV and the most important commodity in the Universe is a substance called the spice \"MELANGE\" which is said to have the power of extending life, expanding the consciousness and even to \"fold space\" ; being able to travel to any distance without physically moving. This spice \"MELANGE\" is said to only be produced in the desert planet of Arrakis, where the FREMEN people have the prophecy of a man who will lead them to true freedom. This \"desert planet\"of Arrakis is also known as DUNE. A secret report of the space \"GUILD\" talks about some circumstances and plans that could jeopardize the production of \"SPICE\" with four planets involved: ARRAKIS, CALADAN, GIEDI PRIME and KAITAIN, a world at least visually very alike to Earth and house of the Emperor of the known Universe. The \"GUILD\" sends a third stage navigator to KAITAIN to ask details from the Emperor and to demand him the killing of young Paul Atreides, son of the Duke Leto Atreides of CALADAN.','6.3','tt0087182',NULL,'https://m.media-amazon.com/images/M/MV5BMGJlMGM3NDAtOWNhMy00MWExLWI2MzEtMDQ0ZDIzZDY5ZmQ2XkEyXkFqcGc@._V1_SX300.jpg','2017-01-29','2026-01-29 10:15:28','2026-01-29 10:17:17'),(14,2,'The Martian','During a manned mission to Mars, Astronaut Mark Watney is presumed dead after a fierce storm and left behind by his crew. But Watney has survived and finds himself stranded and alone on the hostile planet. With only meager supplies, he must draw upon his ingenuity, wit and spirit to subsist and find a way to signal to Earth that he is alive. Millions of miles away, NASA and a team of international scientists work tirelessly to bring \"the Martian\" home, while his crewmates concurrently plot a daring, if not impossible, rescue mission. As these stories of incredible bravery unfold, the world comes together to root for Watney\'s safe return.','8.0','tt3659388',NULL,'https://m.media-amazon.com/images/M/MV5BMTc2MTQ3MDA1Nl5BMl5BanBnXkFtZTgwODA3OTI4NjE@._V1_SX300.jpg','2013-01-29','2026-01-29 10:15:28','2026-01-29 10:17:17'),(15,2,'Arrival','Linguistics professor Louise Banks leads an elite team of investigators when gigantic spaceships touchdown in 12 locations around the world. As nations teeter on the verge of global war, Banks and her crew must race against time to find a way to communicate with the extraterrestrial visitors. Hoping to unravel the mystery, she takes a chance that could threaten her life and quite possibly all of mankind.','7.9','tt2543164',NULL,'https://m.media-amazon.com/images/M/MV5BMTExMzU0ODcxNDheQTJeQWpwZ15BbWU4MDE1OTI4MzAy._V1_SX300.jpg','2002-01-29','2026-01-29 10:15:28','2026-01-29 10:17:17'),(16,2,'Gravity','Dr. Ryan Stone (Sandra Bullock) is a brilliant medical engineer on her first shuttle mission, with veteran astronaut Matt Kowalski (George Clooney) in command of his last flight before retiring. But on a seemingly routine spacewalk, disaster strikes. The shuttle is destroyed, leaving Stone and Kowalsky completely alone - tethered to nothing but each other and spiraling out into the blackness.','7.7','tt1454468',NULL,'https://m.media-amazon.com/images/M/MV5BNjE5MzYwMzYxMF5BMl5BanBnXkFtZTcwOTk4MTk0OQ@@._V1_SX300.jpg','2018-01-29','2026-01-29 10:15:28','2026-01-29 10:17:18'),(17,2,'Tenet','In a twilight world of international espionage, an unnamed CIA operative, known as The Protagonist, is recruited by a mysterious organization called Tenet to participate in a global assignment that unfolds beyond real time. The mission: prevent Andrei Sator, a renegade Russian oligarch with precognition abilities, from starting World War III. The Protagonist will soon master the art of \"time inversion\" as a way of countering the threat that is to come.','7.3','tt6723592',NULL,'https://m.media-amazon.com/images/M/MV5BNTIzNDIxMzktMzlkMi00MmUyLWFmMjQtZDgwMjBmOGJmNTI3XkEyXkFqcGc@._V1_SX300.jpg','2005-01-29','2026-01-29 10:15:28','2026-01-29 10:17:18'),(18,2,'Avatar','When his brother is killed in a robbery, paraplegic Marine Jake Sully decides to take his place in a mission on the distant world of Pandora. There he learns of greedy corporate figurehead Parker Selfridge\'s intentions of driving off the native humanoid \"Na\'vi\" in order to mine for the precious material scattered throughout their rich woodland. In exchange for the spinal surgery that will fix his legs, Jake gathers knowledge, of the Indigenous Race and their Culture, for the cooperating military unit spearheaded by gung-ho Colonel Quaritch, while simultaneously attempting to infiltrate the Na\'vi people with the use of an \"avatar\" identity. While Jake begins to bond with the native tribe and quickly falls in love with the beautiful alien Neytiri, the restless Colonel moves forward with his ruthless extermination tactics, forcing the soldier to take a stand - and fight back in an epic battle for the fate of Pandora.','7.9','tt0499549',NULL,'https://m.media-amazon.com/images/M/MV5BMDEzMmQwZjctZWU2My00MWNlLWE0NjItMDJlYTRlNGJiZjcyXkEyXkFqcGc@._V1_SX300.jpg','1998-01-29','2026-01-29 10:15:28','2026-01-29 10:17:18'),(19,3,'The Shawshank Redemption','Chronicles the experiences of a formerly successful banker as a prisoner in the gloomy jailhouse of Shawshank after being found guilty of a crime he did not commit. The film portrays the man\'s unique way of dealing with his new, torturous life; along the way he befriends a number of fellow prisoners, most notably a wise long-term inmate named Red.','9.3','tt0111161',NULL,'https://m.media-amazon.com/images/M/MV5BMDAyY2FhYjctNDc5OS00MDNlLThiMGUtY2UxYWVkNGY2ZjljXkEyXkFqcGc@._V1_SX300.jpg','1999-01-29','2026-01-29 10:15:28','2026-01-29 10:17:18'),(20,3,'Forrest Gump','Forrest Gump is a simple man with a low I.Q. but good intentions. He is running through childhood with his best and only friend Jenny. His \'mama\' teaches him the ways of life and leaves him to choose his destiny. Forrest joins the army for service in Vietnam, finding new friends called Dan and Bubba, he wins medals, creates a famous shrimp fishing fleet, inspires people to jog, starts a ping-pong craze, creates the smiley, writes bumper stickers and songs, donates to people and meets the president several times. However, this is all irrelevant to Forrest who can only think of his childhood sweetheart Jenny Curran, who has messed up her life. Although in the end all he wants to prove is that anyone can love anyone.','8.8','tt0109830',NULL,'https://m.media-amazon.com/images/M/MV5BNDYwNzVjMTItZmU5YS00YjQ5LTljYjgtMjY2NDVmYWMyNWFmXkEyXkFqcGc@._V1_SX300.jpg','2012-01-29','2026-01-29 10:15:28','2026-01-29 10:17:18'),(21,3,'Parasite','The Kims - mother and father Chung-sook and Ki-taek, and their young adult offspring, son Ki-woo and daughter Ki-jung - are a poor family living in a shabby and cramped half basement apartment in a busy lower working class commercial district of Seoul. Without even knowing it, they, especially Mr. and Mrs. Kim, literally smell of poverty. Often as a collective, they perpetrate minor scams to get by, and even when they have jobs, they do the minimum work required. Ki-woo is the one who has dreams of getting out of poverty by one day going to university. Despite not having that university education, Ki-woo is chosen by his university student friend Min, who is leaving to go to school, to take over his tutoring job to Park Da-hye, who Min plans to date once he returns to Seoul and she herself is in university. The Parks are a wealthy family who for four years have lived in their modernistic house designed by and the former residence of famed architect Namgoong. While Mr. and Mrs. Park are all about status, Mrs. Park has a flighty, simpleminded mentality and temperament, which Min tells Ki-woo to feel comfortable in lying to her about his education to get the job. In getting the job, Ki-woo further learns that Mrs. Park is looking for an art therapist for the Parks\' adolescent son, Da-song, Ki-woo quickly recommending his professional art therapist friend \"Jessica\", really Ki-jung who he knows can pull off the scam in being the easiest liar of the four Kims. In Ki-woo also falling for Da-hye, he begins to envision himself in that house, and thus the Kims as a collective start a plan for all the Kims, like Ki-jung using assumed names, to replace existing servants in the Parks\' employ in orchestrating reasons for them to be fired. The most difficult to get rid of may be Moon-gwang, the Parks\' housekeeper who literally came with the house - she Namgoong\'s housekeeper when he lived there - and thus knows all the little nooks and crannies of it better than the Parks themselves. The question then becomes how far the Kims can take this scam in their quest to become their version of the Parks.','8.5','tt6751668',NULL,'https://m.media-amazon.com/images/M/MV5BYjk1Y2U4MjQtY2ZiNS00OWQyLWI3MmYtZWUwNmRjYWRiNWNhXkEyXkFqcGc@._V1_SX300.jpg','2007-01-29','2026-01-29 10:15:28','2026-01-29 10:17:19'),(22,3,'The Green Mile','Death Row guards at a penitentiary, in the 1930\'s, have a moral dilemma with their job when they discover one of their prisoners, a convicted murderer, has a special gift.','8.6','tt0120689',NULL,'https://m.media-amazon.com/images/M/MV5BMTUxMzQyNjA5MF5BMl5BanBnXkFtZTYwOTU2NTY3._V1_SX300.jpg','2006-01-29','2026-01-29 10:15:28','2026-01-29 10:17:19'),(23,3,'The Whale','A reclusive, morbidly obese English teacher attempts to reconnect with his estranged teenage daughter.','7.6','tt13833688',NULL,'https://m.media-amazon.com/images/M/MV5BYmNhOWMyNTYtNTljNC00NTU3LWFiYmQtMDBhOGU5NWFhNGU5XkEyXkFqcGc@._V1_SX300.jpg','2012-01-29','2026-01-29 10:15:28','2026-01-29 10:17:19'),(24,3,'The Fabelmans','Growing up in post-World War II era Arizona, young Sammy Fabelman aspires to become a filmmaker as he reaches adolescence, but soon discovers a shattering family secret and explores how the power of films can help him see the truth.','7.5','tt14208870',NULL,'https://m.media-amazon.com/images/M/MV5BNDY5OWY4ZWYtYTM3OC00Zjg5LWFlYzYtYWI5ZGM1MDcxYzY4XkEyXkFqcGc@._V1_SX300.jpg','1999-01-29','2026-01-29 10:15:28','2026-01-29 10:17:19'),(25,3,'Aftersun','Sophie reflects on the shared joy and private melancholy of a holiday she took with her father twenty years earlier. Memories real and imagined fill the gaps between as she tries to reconcile the father she knew with the man she d...','7.6','tt19770238',NULL,'https://m.media-amazon.com/images/M/MV5BZWU5Y2MyZjQtNGVjYi00ZDRkLTk1MGYtYmNlMzI0MTFmNDU2XkEyXkFqcGc@._V1_SX300.jpg','1997-01-29','2026-01-29 10:15:28','2026-01-29 10:17:20'),(26,3,'Everything Everywhere All at Once','A middle-aged Chinese immigrant is swept up into an insane adventure in which she alone can save existence by exploring other universes and connecting with the lives she could have led.','7.7','tt6710474',NULL,'https://m.media-amazon.com/images/M/MV5BOWNmMzAzZmQtNDQ1NC00Nzk5LTkyMmUtNGI2N2NkOWM4MzEyXkEyXkFqcGc@._V1_SX300.jpg','2011-01-29','2026-01-29 10:15:28','2026-01-29 10:17:20'),(27,3,'The Menu','A young couple travels to a remote island to eat at an exclusive restaurant where the chef has prepared a lavish menu, with some shocking surprises.','7.2','tt9764362',NULL,'https://m.media-amazon.com/images/M/MV5BN2Q0YWE1MjktODJlMi00NTRiLWI2ZTctZTAxNjkyODVjM2EyXkEyXkFqcGc@._V1_SX300.jpg','2022-01-29','2026-01-29 10:15:28','2026-01-29 10:17:20'),(28,3,'The Banshees of Inisherin','Two lifelong friends find themselves at an impasse when one abruptly ends their relationship, with alarming consequences for both of them.','7.7','tt11813216',NULL,'https://m.media-amazon.com/images/M/MV5BOTkzMWI4OTEtMTk0MS00MTUxLWI4NTYtYmRiNWM4Zjc1MGRhXkEyXkFqcGc@._V1_SX300.jpg','2005-01-29','2026-01-29 10:15:28','2026-01-29 10:17:20'),(29,4,'The Godfather','The Godfather \"Don\" Vito Corleone is the head of the Corleone mafia family in New York. He is at the event of his daughter\'s wedding. Michael, Vito\'s youngest son and a decorated WW II Marine is also present at the wedding. Michael seems to be uninterested in being a part of the family business. Vito is a powerful man, and is kind to all those who give him respect but is ruthless against those who do not. But when a powerful and treacherous rival wants to sell drugs and needs the Don\'s influence for the same, Vito refuses to do it. What follows is a clash between Vito\'s fading old values and the new ways which may cause Michael to do the thing he was most reluctant in doing and wage a mob war against all the other mafia families which could tear the Corleone family apart.','9.2','tt0068646',NULL,'https://m.media-amazon.com/images/M/MV5BNGEwYjgwOGQtYjg5ZS00Njc1LTk2ZGEtM2QwZWQ2NjdhZTE5XkEyXkFqcGc@._V1_SX300.jpg','2014-01-29','2026-01-29 10:15:28','2026-01-29 10:17:20'),(30,4,'Pulp Fiction','Jules Winnfield (Samuel L. Jackson) and Vincent Vega (John Travolta) are two hit men who are out to retrieve a suitcase stolen from their employer, mob boss Marsellus Wallace (Ving Rhames). Wallace has also asked Vincent to take his wife Mia (Uma Thurman) out a few days later when Wallace himself will be out of town. Butch Coolidge (Bruce Willis) is an aging boxer who is paid by Wallace to lose his fight. The lives of these seemingly unrelated people are woven together comprising of a series of funny, bizarre and uncalled-for incidents.','8.8','tt0110912',NULL,'https://m.media-amazon.com/images/M/MV5BYTViYTE3ZGQtNDBlMC00ZTAyLTkyODMtZGRiZDg0MjA2YThkXkEyXkFqcGc@._V1_SX300.jpg','2023-01-29','2026-01-29 10:15:28','2026-01-29 10:17:21'),(31,4,'Schindler\'s List','Oskar Schindler is a vain and greedy German businessman who becomes an unlikely humanitarian amid the barbaric German Nazi reign when he feels compelled to turn his factory into a refuge for Jews. Based on the true story of Oskar Schindler who managed to save about 1100 Jews from being gassed at the Auschwitz concentration camp, it is a testament to the good in all of us.','9.0','tt0108052',NULL,'https://m.media-amazon.com/images/M/MV5BNjM1ZDQxYWUtMzQyZS00MTE1LWJmZGYtNGUyNTdlYjM3ZmVmXkEyXkFqcGc@._V1_SX300.jpg','2004-01-29','2026-01-29 10:15:28','2026-01-29 10:17:21'),(32,4,'Citizen Kane','A group of reporters are trying to decipher the last word ever spoken by Charles Foster Kane, the millionaire newspaper tycoon: \"Rosebud\". The film begins with a news reel detailing Kane\'s life for the masses, and then from there, we are shown flashbacks from Kane\'s life. As the reporters investigate further, the viewers see a display of a fascinating man\'s rise to fame, and how he eventually fell off the top of the world.','8.2','tt0033467',NULL,'https://m.media-amazon.com/images/M/MV5BYjk1ZDJlMmUtOWQ0Zi00MDM5LTk1OGYtODczNjFmMGYwZGVkXkEyXkFqcGc@._V1_SX300.jpg','2020-01-29','2026-01-29 10:15:28','2026-01-29 10:17:21'),(33,4,'Casablanca','The story of Rick Blaine, a cynical world-weary ex-patriate who runs a nightclub in Casablanca, Morocco during the early stages of WWII. Despite the pressure he constantly receives from the local authorities, Rick\'s cafe has become a kind of haven for refugees seeking to obtain illicit letters that will help them escape to America. But when Ilsa, a former lover of Rick\'s, and her husband, show up to his cafe one day, Rick faces a tough challenge which will bring up unforeseen complications, heartbreak and ultimately an excruciating decision to make.','8.5','tt0034583',NULL,'https://m.media-amazon.com/images/M/MV5BNWEzN2U1YTYtYTQyMS00NTVkLWE2NGQtZWFlMmM0MDNjMmRiXkEyXkFqcGc@._V1_SX300.jpg','1998-01-29','2026-01-29 10:15:28','2026-01-29 10:17:21'),(34,4,'Psycho','Phoenix office worker Marion Crane is fed up with the way life has treated her. She has to meet her lover Sam in lunch breaks, and they cannot get married because Sam has to give most of his money away in alimony. One Friday, Marion is trusted to bank forty thousand dollars by her employer. Seeing the opportunity to take the money and start a new life, Marion leaves town and heads towards Sam\'s California store. Tired after the long drive and caught in a storm, she gets off the main highway and pulls into the Bates Motel. The motel is managed by a quiet young man called Norman who seems to be dominated by his mother.','8.5','tt0054215',NULL,'https://m.media-amazon.com/images/M/MV5BYjZhMzFiZjItODA3ZC00MmRhLWIzMGYtMmVjOWUwYTA3MTRjXkEyXkFqcGc@._V1_SX300.jpg','1996-01-29','2026-01-29 10:15:28','2026-01-29 10:17:22'),(35,4,'12 Angry Men','The defense and the prosecution have rested, and the jury is filing into the jury room to decide if a young man is guilty or innocent of murdering his father. What begins as an open-and-shut case of murder soon becomes a detective story that presents a succession of clues creating doubt, and a mini-drama of each of the jurors\' prejudices and preconceptions about the trial, the accused, AND each other. Based on the play, all of the action takes place on the stage of the jury room.','9.0','tt0050083',NULL,'https://m.media-amazon.com/images/M/MV5BYjE4NzdmOTYtYjc5Yi00YzBiLWEzNDEtNTgxZGQ2MWVkN2NiXkEyXkFqcGc@._V1_SX300.jpg','1997-01-29','2026-01-29 10:15:28','2026-01-29 10:17:22'),(36,4,'The Wizard of Oz','When a tornado rips through Kansas, Dorothy Gale and her dog, Toto, are whisked away in their house to the magical Land of Oz. They follow the Yellow Brick Road toward the Emerald City to meet the Wizard, and on the way they meet a Scarecrow who wants a brain, a Tin Man who wants a heart, and a Cowardly Lion who wants courage. The Wizard asks them to bring him the Wicked Witch of the West\'s broom to earn his help.','8.1','tt0032138',NULL,'https://m.media-amazon.com/images/M/MV5BYWRmY2I0MGItYTQ0OC00NWZmLWIwMDktYjJlNDc0MzVhMmViXkEyXkFqcGc@._V1_SX300.jpg','2016-01-29','2026-01-29 10:15:28','2026-01-29 10:17:22'),(37,4,'Singin\' in the Rain','1927 Hollywood. Monumental Pictures\' biggest stars, glamorous on-screen couple Lina Lamont and Don Lockwood, are also an off-screen couple if the trade papers and gossip columns are to be believed. Both perpetuate the public perception if only to please their adoring fans and bring people into the movie theaters. In reality, Don barely tolerates her, while Lina, despite thinking Don beneath her, simplemindedly believes what she sees on screen in order to bolster her own stardom and sense of self-importance. R.F. Simpson, Monumental\'s head, dismisses what he thinks is a flash in the pan: talking pictures. It isn\'t until The Jazz Singer (1927) becomes a bona fide hit which results in all the movie theaters installing sound equipment that R.F. knows Monumental, most specifically in the form of Don and Lina, have to jump on the talking picture bandwagon, despite no one at the studio knowing anything about the technology. Musician Cosmo Brown, Don\'s best friend, gets hired as Monumental\'s ideas man and musical director. And by this time, Don has secretly started dating Kathy Selden, a chorus girl who is trying to make it big in pictures herself. Don and Kathy\'s relationship is despite their less than friendly initial meeting. Cosmo and Kathy help Don, who had worked his way up through the movie ranks to stardom, try make the leap to talking picture stardom, with Kathy following along the way. However, they have to overcome the technological issues. But the bigger problem is Lina, who will do anything to ensure she also makes the successful leap into talking pictures, despite her own inabilities and at anyone and everyone else\'s expense if they get in her way, especially Kathy as Don\'s off screen girlfriend and possibly his new talking picture leading lady.','8.3','tt0045152',NULL,'https://m.media-amazon.com/images/M/MV5BMGQzZDFjZWUtZDU4ZS00ZjM3LTgyYmItYjA3YmIwYzRkZWY3XkEyXkFqcGc@._V1_SX300.jpg','1998-01-29','2026-01-29 10:15:28','2026-01-29 10:17:22'),(38,4,'Sunset Blvd.','N/A','5.2','tt2256853',NULL,'N/A','2015-01-29','2026-01-29 10:15:28','2026-01-29 10:17:22');
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `password_reset_tokens`
--

DROP TABLE IF EXISTS `password_reset_tokens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `password_reset_tokens` (
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `token` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `password_reset_tokens`
--

LOCK TABLES `password_reset_tokens` WRITE;
/*!40000 ALTER TABLE `password_reset_tokens` DISABLE KEYS */;
/*!40000 ALTER TABLE `password_reset_tokens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sessions`
--

DROP TABLE IF EXISTS `sessions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sessions` (
  `id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_id` bigint unsigned DEFAULT NULL,
  `ip_address` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_agent` text COLLATE utf8mb4_unicode_ci,
  `payload` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_activity` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `sessions_user_id_index` (`user_id`),
  KEY `sessions_last_activity_index` (`last_activity`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sessions`
--

LOCK TABLES `sessions` WRITE;
/*!40000 ALTER TABLE `sessions` DISABLE KEYS */;
/*!40000 ALTER TABLE `sessions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email_verified_at` timestamp NULL DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `remember_token` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `role` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'user',
  `profile_photo_path` varchar(2048) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_email_unique` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Test User','test@example.com','2026-01-29 10:15:27','$2y$12$1rdBCISZBC7kF6vgkf26EeDv3E1qHglImHyvQCbJtfWCwSm8pYpm.','fr5VQjiJAp','2026-01-29 10:15:28','2026-02-01 20:07:39','user','profile-photos/SdvjNHj9gitf2HL1jscArsVEoZQ6TgHs4wODP45D.png'),(2,'TAIS PESTANA','teste@teste.com',NULL,'$2y$12$53aDf.usDPDhe6WVJSD7JO3oqZzEdXS6qE9BL4W2v8zk6U7SumW3C',NULL,'2026-01-29 10:17:14','2026-02-01 20:07:53','admin','profile-photos/dwyYcU372j87qbdFPXO1O7qWpK4hbJDuYFjBpkgX.png'),(3,'teste teste','macau@teste.com',NULL,'$2y$12$n7tP7CpynNR15ruJropFDu8IE8CXnbG7cXNqWGd9v7L3YmI2/UGS2',NULL,'2026-01-30 19:45:55','2026-01-30 19:45:55','user',NULL),(4,'user','user@gmail.com',NULL,'$2y$12$JOccA2TwERd/HAw.xr0AQeWRzBov/AsrCN6fNTgBRiXPlaPbqfV42',NULL,'2026-02-01 19:13:43','2026-02-01 19:13:43','user',NULL),(6,'macausantos','macausantos@gmail.com',NULL,'$2y$12$eWl/HeU14b94FKr.weidL.rBnnZqZ8xbNSSNuVg0TVAtGk6NthL2K',NULL,'2026-02-01 20:10:45','2026-02-01 20:11:01','user','profile-photos/n23wrVwEgQzLg3OYiIaCkmY13DT7v4v0YY4Ln14T.png'),(8,'vania maia','vania@gmail.com',NULL,'$2y$12$4Q4Kzle1V/i0FDeT1zTI/eXyVbOmGzBKt2lH/1umtNdFtw.R2lM9u',NULL,'2026-02-01 21:35:18','2026-02-01 21:35:18','user',NULL),(9,'sara','sara@gmail.com',NULL,'$2y$12$Ox5KumFMXQ7OV/m1W5uAJeiMzqr3YkdLoVycMtGTmdHXGOZhSR5Bm',NULL,'2026-02-01 22:20:07','2026-02-01 22:20:07','user',NULL),(10,'claudia','claudia@gmail.com',NULL,'$2y$12$75kIXEh.H1dEvRxo.aEDmejaBOAeLd0v2PPyXtP71XhlNypXvOKDO',NULL,'2026-02-01 22:25:57','2026-02-01 22:25:57','user','profile-photos/zuHS83onPEnQXksAOD8U58dgNLT7exc5v0eixoaD.png');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-02-01 22:33:24
