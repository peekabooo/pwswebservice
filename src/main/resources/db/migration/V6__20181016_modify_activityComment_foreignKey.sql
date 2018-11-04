ALTER TABLE `activity_comment`
DROP FOREIGN KEY `activity_comment_ibfk_1`;
ALTER TABLE `activity_comment`
ADD CONSTRAINT `activity_comment_ibfk_1` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`activity_id`) ON DELETE CASCADE ON UPDATE RESTRICT;
