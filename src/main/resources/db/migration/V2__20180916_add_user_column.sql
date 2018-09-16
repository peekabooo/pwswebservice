ALTER TABLE `common_user`
  ADD COLUMN `password` varchar(50) NOT NULL
  AFTER `personal_information`;