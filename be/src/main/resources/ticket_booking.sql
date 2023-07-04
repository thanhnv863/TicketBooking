CREATE SCHEMA `ticket_booking` ;

CREATE TABLE `ticket_booking`.`actor` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(75) NOT NULL,
  `birthday` DATE NOT NULL,
  `status` INT NOT NULL,
  `created_by` BIGINT NOT NULL,
  `updated_by` BIGINT NULL,
  `created_time` TIME NOT NULL,
  `updated_time` TIME NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `ticket_booking`.`directors` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `status` INT NOT NULL,
  `created_by` BIGINT NOT NULL,
  `updated_by` BIGINT NULL,
  `created_time` TIME NOT NULL,
  `updated_time` TIME NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `ticket_booking`.`genre` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `status` INT NOT NULL,
  `created_by` BIGINT NOT NULL,
  `updated_by` BIGINT NULL,
  `created_time` TIME NOT NULL,
  `updated_time` TIME NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);
  
  CREATE TABLE `ticket_booking`.`movie` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `id_director` BIGINT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `premiere_date` DATE NOT NULL,
  `age_limit` INT NOT NULL,
  `time` TIME NOT NULL,
  `status` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE,
  INDEX `FK_M_D_idx` (`id_director` ASC) VISIBLE,
  CONSTRAINT `FK_M_D`
    FOREIGN KEY (`id_director`)
    REFERENCES `ticket_booking`.`directors` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
CREATE TABLE `ticket_booking`.`movie_genre` (
  `id_genre` BIGINT NOT NULL,
  `id_movie` BIGINT NOT NULL,
  PRIMARY KEY (`id_genre`, `id_movie`),
  INDEX `FK_MG_M_idx` (`id_movie` ASC) VISIBLE,
  CONSTRAINT `FK_MG_G`
    FOREIGN KEY (`id_genre`)
    REFERENCES `ticket_booking`.`genre` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_MG_M`
    FOREIGN KEY (`id_movie`)
    REFERENCES `ticket_booking`.`movie` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `ticket_booking`.`image` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `id_movie` BIGINT NOT NULL,
  `link` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_IMG_M_idx` (`id_movie` ASC) VISIBLE,
  CONSTRAINT `FK_IMG_M`
    FOREIGN KEY (`id_movie`)
    REFERENCES `ticket_booking`.`movie` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `ticket_booking`.`trailer` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `id_movie` BIGINT NOT NULL,
  `link` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_TL_M_idx` (`id_movie` ASC) VISIBLE,
  CONSTRAINT `FK_TL_M`
    FOREIGN KEY (`id_movie`)
    REFERENCES `ticket_booking`.`movie` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `ticket_booking`.`producer` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `status` INT NOT NULL,
  `created_by` BIGINT NOT NULL,
  `updated_by` BIGINT NULL,
  `created_time` TIME NOT NULL,
  `updated_time` TIME NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `ticket_booking`.`producer_movie` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `id_producer` BIGINT NOT NULL,
  `id_movie` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_PM_M_idx` (`id_movie` ASC) VISIBLE,
  INDEX `FK_PM_P_idx` (`id_producer` ASC) VISIBLE,
  CONSTRAINT `FK_PM_M`
    FOREIGN KEY (`id_movie`)
    REFERENCES `ticket_booking`.`movie` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_PM_P`
    FOREIGN KEY (`id_producer`)
    REFERENCES `ticket_booking`.`producer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
CREATE TABLE `ticket_booking`.`room` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `total_chair` DECIMAL NOT NULL,
  `status` INT NOT NULL,
  `created_by` BIGINT NOT NULL,
  `updated_by` BIGINT NULL,
  `created_time` TIME NOT NULL,
  `updated_time` TIME NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE);


CREATE TABLE `ticket_booking`.`chair_type` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `status` INT NOT NULL,
  `created_by` BIGINT NOT NULL,
  `updated_by` BIGINT NULL,
  `created_time` VARCHAR(45) NOT NULL,
  `updated_time` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `ticket_booking`.`chair` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `id_room` BIGINT NOT NULL,
  `id_chair_type` BIGINT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `wait_time` INT NOT NULL,
  `status` INT NOT NULL,
  `created_by` BIGINT NOT NULL,
  `updated_by` BIGINT NULL,
  `created_time` TIME NOT NULL,
  `updated_time` TIME NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_C_R_idx` (`id_room` ASC) VISIBLE,
  INDEX `FK_C_CT_idx` (`id_chair_type` ASC) VISIBLE,
  CONSTRAINT `FK_C_R`
    FOREIGN KEY (`id_room`)
    REFERENCES `ticket_booking`.`room` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_C_CT`
    FOREIGN KEY (`id_chair_type`)
    REFERENCES `ticket_booking`.`chair_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `ticket_booking`.`type_ticket` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `status` INT NOT NULL,
  `created_by` BIGINT NOT NULL,
  `updated_by` BIGINT NULL,
  `created_time` TIME NOT NULL,
  `updated_time` TIME NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE,
  UNIQUE INDEX `type_UNIQUE` (`type` ASC) VISIBLE,


CREATE TABLE `ticket_booking`.`ticket_price` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `id_type_ticket` BIGINT NOT NULL,
  `id_type_chair` BIGINT NOT NULL,
  `price` DECIMAL NOT NULL,
  `created_by` BIGINT NOT NULL,
  `updated_by` BIGINT NULL,
  `created_time` TIME NOT NULL,
  `updated_time` TIME NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_TP_TT_idx` (`id_type_ticket` ASC) VISIBLE,
  INDEX `FK_TC_idx` (`id_type_chair` ASC) VISIBLE,
  CONSTRAINT `FK_TP_TT`
    FOREIGN KEY (`id_type_ticket`)
    REFERENCES `ticket_booking`.`type_ticket` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_TC`
    FOREIGN KEY (`id_type_chair`)
    REFERENCES `ticket_booking`.`chair_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    
CREATE TABLE `ticket_booking`.`show_time` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `id_room` BIGINT NOT NULL,
  `id_movie` BIGINT NOT NULL,
  `time` TIME NOT NULL,
  `status` INT NOT NULL,
  `created_by` BIGINT NOT NULL,
  `updated_by` BIGINT NULL,
  `created_time` TIME NOT NULL,
  `updated_time` TIME NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_ST_R_idx` (`id_room` ASC) VISIBLE,
  INDEX `FK_ST_M_idx` (`id_movie` ASC) VISIBLE,
  CONSTRAINT `FK_ST_R`
    FOREIGN KEY (`id_room`)
    REFERENCES `ticket_booking`.`room` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_ST_M`
    FOREIGN KEY (`id_movie`)
    REFERENCES `ticket_booking`.`movie` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `ticket_booking`.`ticket` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `id_ticket_price` BIGINT NOT NULL,
  `id_chair` BIGINT NOT NULL,
  `id_type_ticket` BIGINT NOT NULL,
  `id_show_time` BIGINT NOT NULL,
  `code` VARCHAR(45) NOT NULL,
  `status` INT NOT NULL,
  `created_by` BIGINT NOT NULL,
  `updated_by` BIGINT NULL,
  `created_time` TIME NOT NULL,
  `updated_time` TIME NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `status_UNIQUE` (`status` ASC) VISIBLE,
  INDEX `FK_T_TP_idx` (`id_ticket_price` ASC) VISIBLE,
  INDEX `FK_T_C_idx` (`id_chair` ASC) VISIBLE,
  INDEX `FK_T_TT_idx` (`id_type_ticket` ASC) VISIBLE,
  INDEX `FK_T_ST_idx` (`id_show_time` ASC) VISIBLE,
  CONSTRAINT `FK_T_TP`
    FOREIGN KEY (`id_ticket_price`)
    REFERENCES `ticket_booking`.`ticket_price` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_T_C`
    FOREIGN KEY (`id_chair`)
    REFERENCES `ticket_booking`.`chair` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_T_TT`
    FOREIGN KEY (`id_type_ticket`)
    REFERENCES `ticket_booking`.`type_ticket` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_T_ST`
    FOREIGN KEY (`id_show_time`)
    REFERENCES `ticket_booking`.`show_time` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `ticket_booking`.`customer` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `birthday` DATE NOT NULL,
  `address` VARCHAR(145) NOT NULL,
  `phone_number` INT NOT NULL,
  `status` INT NOT NULL,
  `created_by` BIGINT NOT NULL,
  `updated_by` BIGINT NULL,
  `created_time` TIME NOT NULL,
  `updated_time` TIME NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  UNIQUE INDEX `password_UNIQUE` (`password` ASC) VISIBLE,
  UNIQUE INDEX `code_UNIQUE` (`code` ASC) VISIBLE);


CREATE TABLE `ticket_booking`.`employee` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `address` VARCHAR(145) NOT NULL,
  `phone_number` INT NOT NULL,
  `role` INT NOT NULL,
  `status` INT NOT NULL,
  `created_by` BIGINT NOT NULL,
  `updated_by` BIGINT NULL,
  `created_time` TIME NOT NULL,
  `updated_time` TIME NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `code_UNIQUE` (`code` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE);
  
  
CREATE TABLE `ticket_booking`.`snacks_type` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `status` INT NOT NULL,
  `created_by` BIGINT NOT NULL,
  `updated_by` BIGINT NULL,
  `created_time` TIME NOT NULL,
  `updated_time` TIME NULL,
  PRIMARY KEY (`id`));



CREATE TABLE `ticket_booking`.`snacks` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `id_snack_type` BIGINT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `price` DECIMAL NOT NULL,
  `quantity` BIGINT NOT NULL,
  `unit` INT NOT NULL,
  `status` INT NOT NULL,
  `created_by` BIGINT NOT NULL,
  `updated_by` BIGINT NULL,
  `created_time` VARCHAR(45) NOT NULL,
  `updated_time` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_snack_type_UNIQUE` (`id_snack_type` ASC) VISIBLE,
  CONSTRAINT `FK_S_ST`
    FOREIGN KEY (`id_snack_type`)
    REFERENCES `ticket_booking`.`snacks_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `ticket_booking`.`combo` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NOT NULL,
  `price` DECIMAL NOT NULL,
  `status` BIGINT NOT NULL,
  `created_by` VARCHAR(45) NOT NULL,
  `updated_by` BIGINT NULL,
  `created_time` TIME NOT NULL,
  `updated_time` TIME NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE);


CREATE TABLE `ticket_booking`.`order` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `id_customer` BIGINT NOT NULL,
  `id_employee` BIGINT NOT NULL,
  `code` VARCHAR(45) NOT NULL,
  `order_date` DATE NOT NULL,
  `time_order` TIME NOT NULL,
  `total_amount` DECIMAL NOT NULL,
  `total_after_reduction` DECIMAL NOT NULL,
  `updated_by` BIGINT NULL,
  `created_by` BIGINT NOT NULL,
  `updated_time` TIME NULL,
  `created_time` TIME NOT NULL,
  `staus` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_O_C_idx` (`id_customer` ASC) VISIBLE,
  CONSTRAINT `FK_O_C`
    FOREIGN KEY (`id_customer`)
    REFERENCES `ticket_booking`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_O_E`
    FOREIGN KEY (`id_employee`)
    REFERENCES `ticket_booking`.`employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `ticket_booking`.`order_ticket` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `id_order` BIGINT NOT NULL,
  `id_ticket` BIGINT NOT NULL,
  `price` DECIMAL NOT NULL,
  `note` VARCHAR(145) NULL,
  `status` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_OT_O_idx` (`id_order` ASC) VISIBLE,
  INDEX `FK_OT_T_idx` (`id_ticket` ASC) VISIBLE,
  CONSTRAINT `FK_OT_O`
    FOREIGN KEY (`id_order`)
    REFERENCES `ticket_booking`.`order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_OT_T`
    FOREIGN KEY (`id_ticket`)
    REFERENCES `ticket_booking`.`ticket` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `ticket_booking`.`order_snack` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `id_order` BIGINT NOT NULL,
  `id_snack` BIGINT NOT NULL,
  `id_combo` BIGINT NOT NULL,
  `price` DECIMAL NOT NULL,
  `quantity` BIGINT NOT NULL,
  `note` VARCHAR(145) NULL,
  `status` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_OS_O_idx` (`id_order` ASC) VISIBLE,
  INDEX `FK_OS_S_idx` (`id_snack` ASC) VISIBLE,
  INDEX `FK_OS_C_idx` (`id_combo` ASC) VISIBLE,
  CONSTRAINT `FK_OS_O`
    FOREIGN KEY (`id_order`)
    REFERENCES `ticket_booking`.`order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_OS_S`
    FOREIGN KEY (`id_snack`)
    REFERENCES `ticket_booking`.`snacks` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_OS_C`
    FOREIGN KEY (`id_combo`)
    REFERENCES `ticket_booking`.`combo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
