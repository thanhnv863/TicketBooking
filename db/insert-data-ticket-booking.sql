USE ticket_booking;
INSERT INTO `ticket_booking`.`employee`
	(`code`,`name`,`email`,`password`,`address`,`phone_number`,`role`,`status`,`created_by`,`created_time`)
VALUES
("NV001", "Quan ly", "quanly@fpt.edu.vn", 12123, "Phu Tho", "0354678543", 1, 1, null, "2023-01-02 09:09:09");
-- 1.actor
INSERT INTO `ticket_booking`.`actor`
	(`name`,`birthday`,`status`,`created_by`,`created_time`)
VALUES ("Chris Hemsworth", "1983-08-11", 1, "NV001", "2023-01-01 12:15:12");
INSERT INTO `ticket_booking`.`actor`
	(`name`,`birthday`,`status`,`created_by`,`created_time`)
VALUES ("Jake Johnson", "1978-05-28", 1, "NV001", "2023-01-01 12:15:12");
INSERT INTO `ticket_booking`.`actor`
	(`name`,`birthday`,`status`,`created_by`,`created_time`)
VALUES ("Tom Holland", "1996-06-01", 1, "NV001", "2023-01-01 12:15:12");
INSERT INTO `ticket_booking`.`actor`
	(`name`,`birthday`,`status`,`created_by`,`created_time`)
VALUES ("Kirsten Dunst", "1982-04-30", 1, "NV001", "2023-01-01 12:15:12");
INSERT INTO `ticket_booking`.`actor`
	(`name`,`birthday`,`status`,`created_by`,`created_time`)
VALUES ("Anh Tu", "1993-10-03", 1, "NV001", "2023-01-01 12:15:12");
-- 2.chair_type
INSERT INTO `ticket_booking`.`chair_type`
	(`name`,`status`,`created_by`,`created_time`)
VALUES ("Thường", 1, "NV001", "2023-01-02 12:12:12");
INSERT INTO `ticket_booking`.`chair_type`
	(`name`,`status`,`created_by`,`created_time`)
VALUES ("VIP", 1, "NV001", "2023-01-02 12:12:12");
INSERT INTO `ticket_booking`.`chair_type`
	(`name`,`status`,`created_by`,`created_time`)
VALUES ("Đôi", 1, "NV001", "2023-01-02 12:12:12");

												-- 3. room
INSERT INTO `ticket_booking`.`room`
(`name`,`total_chair`,`status`,`created_by`,`updated_by`,`created_time`,`updated_time`)
VALUES('P001', 30, 1, 'NV001', null, '2023-01-01 12:12:12', null);
INSERT INTO `ticket_booking`.`room`
(`name`,`total_chair`,`status`,`created_by`,`updated_by`,`created_time`,`updated_time`)
VALUES('P002', 35, 1, 'NV001', null, '2023-01-01 12:12:12', null);
INSERT INTO `ticket_booking`.`room`
(`name`,`total_chair`,`status`,`created_by`,`updated_by`,`created_time`,`updated_time`)
VALUES('P003', 40, 1, 'NV001', null, '2023-01-01 12:12:12', null);
INSERT INTO `ticket_booking`.`room`
(`name`,`total_chair`,`status`,`created_by`,`updated_by`,`created_time`,`updated_time`)
VALUES('P004', 30, 1, 'NV001', null, '2023-01-01 12:12:12', null);
INSERT INTO `ticket_booking`.`room`
(`name`,`total_chair`,`status`,`created_by`,`updated_by`,`created_time`,`updated_time`)
VALUES('P005', 32, 1, 'NV001', null, '2023-01-01 12:12:12', null);
													
                                                    
                                                    -- 4.CHAIR
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (1 ,2 , "P001_B5", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (1 ,2 , "P001_B6", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (1 ,2 , "P001_B7", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (1 ,2 , "P001_B8", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (1 ,2 , "P001_B9", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (1 ,2 , "P001_B10", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (1 ,2 , "P001_C1", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (1 ,2 , "P001_C2", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (1 ,2 , "P001_C3", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (1 ,2 , "P001_C4", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (1 ,2 , "P001_C5", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (1 ,2 , "P001_C6", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (1 ,2 , "P001_C7", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (1 ,2 , "P001_C8", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (1 ,2 , "P001_C9", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (1 ,2 , "P001_C10", 10, 1, "NV001", "2023-01-01 01:01:01");
									-- 35 ghế phòng 2:
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,2 , "P002_A1", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,2 , "P002_A2", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,2 , "P002_A3", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,2 , "P002_A4", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,2 , "P002_A5", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,2 , "P002_A6", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,2 , "P002_A7", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,2 , "P002_A8", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,2 , "P002_A9", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,2 , "P002_A10", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,2 , "P002_B1", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,2 , "P002_B2", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,2 , "P002_B3", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,2 , "P002_B4", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,2 , "P002_B5", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,2 , "P002_B6", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,2 , "P002_B7", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,2 , "P002_B8", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,2 , "P002_B9", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,2 , "P002_B10", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,2 , "P002_C1", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,2 , "P002_C2", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,2 , "P002_C3", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,2 , "P002_C4", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,2 , "P002_C5", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,2 , "P002_C6", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,2 , "P002_C7", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,2 , "P002_C8", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,2 , "P002_C9", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,2 , "P002_C10", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,3 , "P002_D1", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,3 , "P002_D2", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,3 , "P002_D3", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,3 , "P002_D4", 10, 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`chair`
	(`id_room`,`id_chair_type`,`name`,`wait_time`,`status`,`created_by`,`created_time`)
VALUES (2 ,3 , "P002_D5", 10, 1, "NV001", "2023-01-01 01:01:01");
						
                        -- 5. customer
INSERT INTO `ticket_booking`.`customer`
	(`code`,`name`,`username`,`password`,`birthday`,`address`,`phone_number`,`status`,`created_by`,`created_time`)
VALUES("KH002", "Nguyen Thanh Tung", "tungnt", "121234", "2003-11-29", "Ha Noi", "0384910040", 1, "NV001", "2023-01-10 12:12:12");
INSERT INTO `ticket_booking`.`customer`
	(`code`,`name`,`username`,`password`,`birthday`,`address`,`phone_number`,`status`,`created_by`,`created_time`)
VALUES("KH004", "Bui Bich Phuong", "phuongbb", "phuongbb", "2003-11-28", "Ha Noi", "0384910042", 1, "NV001", "2023-01-10 12:12:12");
INSERT INTO `ticket_booking`.`customer`
	(`code`,`name`,`username`,`password`,`birthday`,`address`,`phone_number`,`status`,`created_by`,`created_time`)
VALUES("KH005", "Den", "den", "den", "2003-11-29", "Ha Noi", "0384910043", 1, "NV001", "2023-01-10 12:12:12");
INSERT INTO `ticket_booking`.`customer`
	(`code`,`name`,`username`,`password`,`birthday`,`address`,`phone_number`,`status`,`created_by`,`created_time`)
VALUES("KH006", "Mr Siro", "sadboiz", "sadboiz", "2003-11-29", "Ha Noi", "0384910044", 1, "NV001", "2023-01-10 12:12:12");
INSERT INTO `ticket_booking`.`customer`
	(`code`,`name`,`username`,`password`,`birthday`,`address`,`phone_number`,`status`,`created_by`,`created_time`)
VALUES("KH007", "Min", "minmin", "minmin", "2003-11-29", "Ha Noi", "0384910045", 1, "NV001", "2023-01-10 12:12:12");
INSERT INTO `ticket_booking`.`customer`
	(`code`,`name`,`username`,`password`,`birthday`,`address`,`phone_number`,`status`,`created_by`,`created_time`)
VALUES("KH008", "Hoang Thuy Linh", "linhht", "linhht", "2003-11-29", "Ha Noi", "0384910046", 1, "NV001", "2023-01-10 12:12:12");
INSERT INTO `ticket_booking`.`customer`
	(`code`,`name`,`username`,`password`,`birthday`,`address`,`phone_number`,`status`,`created_by`,`created_time`)
VALUES("KH009", "My Tam", "mytam", "mytam", "2003-11-29", "Ha Noi", "0384910047", 1, "NV001", "2023-01-10 12:12:12");
INSERT INTO `ticket_booking`.`customer`
	(`code`,`name`,`username`,`password`,`birthday`,`address`,`phone_number`,`status`,`created_by`,`created_time`)
VALUES("KH010", "Ha Anh Tuan", "tuanha", "tuanha", "2003-11-29", "Ha Noi", "0384910048", 1, "NV001", "2023-01-10 12:12:12");
INSERT INTO `ticket_booking`.`customer`
	(`code`,`name`,`username`,`password`,`birthday`,`address`,`phone_number`,`status`,`created_by`,`created_time`)
VALUES("KH003", "Truc Nhan", "trucnhan", "trucnhan", "2003-11-29", "Ha Noi", "0384910049", 1, "NV001", "2023-01-10 12:12:12");
						
								-- 6. directors
INSERT INTO `ticket_booking`.`directors`
	(`name`,`status`,`created_by`,`created_time`)
VALUES ("James Cameron", 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`directors`
	(`name`,`status`,`created_by`,`created_time`)
VALUES ("Quentin Tarantino", 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`directors`
	(`name`,`status`,`created_by`,`created_time`)
VALUES ("Clint Eastwood", 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`directors`
	(`name`,`status`,`created_by`,`created_time`)
VALUES ("Steven Spielberg", 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`directors`
	(`name`,`status`,`created_by`,`created_time`)
VALUES ("Woody Allen", 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`directors`
	(`name`,`status`,`created_by`,`created_time`)
VALUES ("Frank Capra", 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`directors`
	(`name`,`status`,`created_by`,`created_time`)
VALUES ("John Ford", 1, "NV001", "2023-01-01 01:01:01");
INSERT INTO `ticket_booking`.`directors`
	(`name`,`status`,`created_by`,`created_time`)
VALUES ("Alfred Hitcock", 1, "NV001", "2023-01-01 01:01:01");

										-- 7.employee
INSERT INTO `ticket_booking`.`employee`
	(`code`,`name`,`email`,`password`,`address`,`phone_number`,`role`,`status`,`created_by`,`created_time`)
VALUES
("NV002", "Bui Cong Tuan", "tuanbvph25878@fpt.edu.vn", 12123, "Phu Tho", "0354678542", 1, 1, "NV001", "2023-01-02 09:09:09");
INSERT INTO `ticket_booking`.`employee`
	(`code`,`name`,`email`,`password`,`address`,`phone_number`,`role`,`status`,`created_by`,`created_time`)
VALUES
("NV003", "Nguyen Van Thanh", "thanhnvph20218@fpt.edu.vn", 12123, "Phu Tho", "0354678544", 1, 1, "NV001", "2023-01-02 09:09:09");
INSERT INTO `ticket_booking`.`employee`
	(`code`,`name`,`email`,`password`,`address`,`phone_number`,`role`,`status`,`created_by`,`created_time`)
VALUES
("NV004", "Nguyen Duc Dung", "dungnd-h200697@fpt.edu.vn", 12123, "Phu Tho", "0354678545", 1, 1, "NV001", "2023-01-02 09:09:09");
INSERT INTO `ticket_booking`.`employee`
	(`code`,`name`,`email`,`password`,`address`,`phone_number`,`role`,`status`,`created_by`,`created_time`)
VALUES
("NV005", "Nguyen Thi Thuy Duong", "duongnttph25958@fpt.edu.vn", 12123, "Phu Tho", "0354678546", 1, 1, "NV001", "2023-01-02 09:09:09");
INSERT INTO `ticket_booking`.`employee`
	(`code`,`name`,`email`,`password`,`address`,`phone_number`,`role`,`status`,`created_by`,`created_time`)
VALUES
("NV006", "Pham Thanh Son", "sonptph25875@fpt.edu.vn", 12123, "Phu Tho", "0354678547", 1, 1, "NV001", "2023-01-02 09:09:09");

										-- 8. genre
INSERT INTO `ticket_booking`.`genre`
	(`name`,`status`,`created_by`,`created_time`)
VALUES ("Hanh Dong", 1, "NV001", "2023-01-01 12:12:12");
INSERT INTO `ticket_booking`.`genre`
	(`name`,`status`,`created_by`,`created_time`)
VALUES ("Tinh Cam", 1, "NV002", "2023-02-01 11:11:11");
INSERT INTO `ticket_booking`.`genre`
	(`name`,`status`,`created_by`,`created_time`)
VALUES ("Hoat Hinh", 1, "NV002", "2023-02-01 11:11:11");
INSERT INTO `ticket_booking`.`genre`
	(`name`,`status`,`created_by`,`created_time`)
VALUES ("Khoa hoc vien tuong", 1, "NV002", "2023-02-01 11:11:11");
INSERT INTO `ticket_booking`.`genre`
	(`name`,`status`,`created_by`,`created_time`)
VALUES ("Hai", 1, "NV002", "2023-02-01 11:11:11");
INSERT INTO `ticket_booking`.`genre`
	(`name`,`status`,`created_by`,`created_time`)
VALUES ("Kinh Di", 1, "NV002", "2023-02-01 11:11:11");

								-- 9. image

				-- 10. snack type
INSERT INTO `ticket_booking`.`snacks_type` (`id`, `name`, `status`, `created_by`, `created_time`) 
VALUES ('3', 'test', '0', '1', '2023-01-02 12:43:00');


				-- 11. snack
INSERT INTO `ticket_booking`.`snacks` (`id_snack_type`, `name`, `price`, `quantity`, `unit`, `status`, `created_by`, `created_time`)
 VALUES ('3', 'Bắp vị mặn', '59000', '1', '1', '0', 'NV001', '2023-01-02 12:43:00');

				-- 12. combo
INSERT INTO `ticket_booking`.`combo` (`name`, `start_date`, `end_date`, `price`, `status`, `created_by`, `created_time`) 
VALUES ('aaa', '2023-07-08 03:54:00', '2023-07-09 03:54:00', '421413', '0', 'NV001', '2023-07-08 03:57:43');

				-- 13. combo detail
INSERT INTO `ticket_booking`.`combo_detail` (`id_snacks`, `id_combo`, `quantity`) VALUES ('1', '1', '2');


				-- 14. directors
INSERT INTO `ticket_booking`.`directors` (`name`, `status`, `created_by`, `created_time`)
 VALUES ('Dung ', '1', 'NV001', '2023-07-10 12:00:00');


				-- 15. movie
INSERT INTO `ticket_booking`.`movie` (`id_director`, `name`, `premiere_date`, `age_limit`, `time`, `status` , `created_by`, `created_time`) 
VALUES ('1', 'The Flash', '2023-07-10', '21', '2', '1', 'NV001', '2023-07-10 12:00:00');


                 -- 16. showtime
INSERT INTO `ticket_booking`.`show_time` (`id_room`, `id_movie`, `time`, `status`, `created_by`, `created_time`)
 VALUES ('1', '1', '2023-07-11 12:00:00', '1', 'NV001', '2023-07-10 21:00:00');


				-- 17. orrder
INSERT INTO `ticket_booking`.`orders` (`id_customer`, `id_employee`, `code`, `order_date`, `time_order`, `total_amount`, `total_after_reduction`, `created_by`, `created_time`, `staus`)
 VALUES ('1', '1', '03456', '2023-07-08 23:59:28', '2023-07-08 23:59:28', '99999', '88888','NV001', '2023-07-08 23:59:28', '1');

					-- 18. salepaymen
INSERT INTO `ticket_booking`.`sale_payment` (`id_order`, `amount`, `payment_time`, `description`)
 VALUES ('1', '11000', '2023-07-08 12:49:00', 'Tiền mặt');



