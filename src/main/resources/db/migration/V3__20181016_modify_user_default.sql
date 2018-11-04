ALTER TABLE common_user ALTER nick_name DROP DEFAULT;

ALTER TABLE common_user ALTER real_name DROP DEFAULT;

ALTER TABLE common_user ALTER gender DROP DEFAULT;

ALTER TABLE common_user ALTER university DROP DEFAULT;

ALTER TABLE common_user ALTER department DROP DEFAULT;

ALTER TABLE common_user ALTER student_id DROP DEFAULT;

ALTER TABLE common_user ALTER point DROP DEFAULT;

ALTER TABLE common_user ALTER LEVEL DROP DEFAULT;

ALTER TABLE common_user ALTER nick_name
SET DEFAULT "";

ALTER TABLE common_user ALTER real_name
SET DEFAULT "";

ALTER TABLE common_user ALTER gender
SET DEFAULT '0';

ALTER TABLE common_user ALTER university
SET DEFAULT "";

ALTER TABLE common_user ALTER department
SET DEFAULT "";

ALTER TABLE common_user ALTER student_id
SET DEFAULT "";

ALTER TABLE common_user ALTER point
SET DEFAULT '0';

ALTER TABLE common_user ALTER LEVEL
SET DEFAULT '0.00';

