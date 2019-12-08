use java4web;

DROP TABLE IF EXISTS appointments, doctors, specialities, citizens, users;

CREATE TABLE `users` (
	`id` bigint(10) unsigned NOT NULL,
	`first_name` varchar(255) NOT NULL,
	`last_name` varchar(255) NOT NULL,
	`email` varchar(255) NOT NULL,
	`username` varchar(255) NOT NULL,
	`password` varchar(255) NOT NULL,
	`user_type` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `citizens` (
	`id` bigint(10) unsigned NOT NULL,
	`ssn` varchar(11) NOT NULL,
	`mobile_number` varchar(255) NOT NULL,
	`user_id` bigint(10) unsigned NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);

CREATE TABLE `specialities` (
	`id` bigint(10) unsigned NOT NULL,
	`name` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `doctors` (
	`id` bigint(10) unsigned NOT NULL,
	`speciality_id` bigint(10) unsigned NOT NULL,
	`user_id` bigint(10) unsigned NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`speciality_id`) REFERENCES `specialities` (`id`),
	FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);

CREATE TABLE `appointments` (
	`id` bigint(10) unsigned NOT NULL,
	`date` date DEFAULT NULL,
	`citizen_id` bigint(10) unsigned NOT NULL REFERENCES `citizen` (`id`),
	`doctor_id` bigint(10) unsigned NOT NULL REFERENCES `doctor` (`id`),
	`description` varchar(255),
	`notes` varchar(255),
	PRIMARY KEY (`id`),
	FOREIGN KEY (`citizen_id`) REFERENCES `citizens` (`id`),
	FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`)
);