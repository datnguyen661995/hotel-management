INSERT INTO "hotel-management".hotel (rating,created_at,id,updated_at,address,city,country,created_by,name,updated_by) VALUES
(4,NULL,1,NULL,' Số 331 Nguyễn Văn Linh - quận Thanh Khê - Tp. Đà Nẵng','DA NANG','VIET NAM',NULL,'SAMDI HOTEL',NULL),
(4,NULL,2,NULL,'Số 186 Trần Phú, quận Hải Châu, Tp. Đà Nẵng','DA NANG','VIET NAM',NULL,'VAL SOLEIL HOTEL ',NULL),
(4,NULL,3,NULL,'92-94 Ly Tu Trong, Quận 1, TP. Hồ Chí Minh, Việt Nam ','HO CHI MINH','VIET NAM',NULL,'GK Central Hotel',NULL),
(4,NULL,4,NULL,'6-8 Ho Huan Nghiep, District 1 , Quận 1, TP. Hồ Chí Minh, Việt Nam','HO CHI MINH','VIET NAM',NULL,'The Myst Dong Khoi',NULL);

INSERT INTO "hotel-management".room (capacity,price,created_at,hotel_id,id,updated_at,availability,created_by,"type",is_delete,updated_by) VALUES
(1,150.00,NULL,1,2,NULL,'AVAILABLE',NULL,'SINGLE',false,NULL),
(1,100.00,NULL,1,1,NULL,'AVAILABLE',NULL,'SINGLE',false,NULL),
(2,200.00,NULL,1,3,NULL,'AVAILABLE',NULL,'DOUBLE',false,NULL),
(2,250.00,NULL,1,4,NULL,'AVAILABLE',NULL,'DOUBLE',false,NULL),
(4,300.00,NULL,1,5,NULL,'AVAILABLE',NULL,'TRIPLE',false,NULL),
(4,350.00,NULL,1,6,NULL,'AVAILABLE',NULL,'TRIPLE',false,NULL);