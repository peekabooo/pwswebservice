ALTER TABLE dynamic_info_comment CHANGE COLUMN  activity_comment_id dynamic_info_comment_id INT AUTO_INCREMENT;

ALTER TABLE dynamic_info_comment CHANGE COLUMN  activity_id dynamic_info_id INT NOT NULL ;

ALTER TABLE dynamic_info_comment ALTER like_number DROP DEFAULT;

ALTER TABLE dynamic_info_comment ALTER like_number
  SET DEFAULT '0';

