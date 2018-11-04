ALTER TABLE activity_comment CHANGE COLUMN dynamic_info_comment_id activity_comment_id INT AUTO_INCREMENT;

ALTER TABLE activity_comment CHANGE COLUMN dynamic_info_id activity_id INT NOT NULL ;

ALTER TABLE activity_comment ALTER like_number DROP DEFAULT;

ALTER TABLE activity_comment ALTER like_number
SET DEFAULT '0';
