# change db
use steammend;


# drop
DROP TABLE IF EXISTS attachments;
DROP TABLE IF EXISTS replies;
DROP TABLE IF EXISTS communities;
DROP TABLE IF EXISTS members;


# create
CREATE TABLE members(
	id VARCHAR(20) PRIMARY KEY,
	password VARCHAR(60) NOT NULL ,
	name VARCHAR(20) NOT NULL,
	nickname VARCHAR(20) NOT NULL,
	birth DATE NOT NULL,
	steam_id VARCHAR(17) NOT NULL,
	is_state TINYINT(1) NOT NULL DEFAULT 1
);


CREATE TABLE communities(
	community_id BIGINT AUTO_INCREMENT PRIMARY KEY,
	member_id VARCHAR(20) NOT NULL,
	header VARCHAR(100) NOT NULL,
	title VARCHAR(500) NOT NULL,
	content TEXT NOT NULL,
    write_date DATETIME DEFAULT NULL,
    hit INT NOT NULL DEFAULT 0,
	is_state TINYINT(1) NOT NULL DEFAULT 1
);
ALTER TABLE communities ADD CONSTRAINT FOREIGN KEY(member_id) REFERENCES members(id);


CREATE TABLE attachments(
	attachment_id BIGINT AUTO_INCREMENT PRIMARY KEY,
	community_id BIGINT NOT NULL,
	origin_name VARCHAR(3000) NOT NULL,
	server_name VARCHAR(3000) NOT NULL,
	path VARCHAR(1000) NOT NULL
);
ALTER TABLE attachments ADD CONSTRAINT FOREIGN KEY(community_id) REFERENCES communities(community_id);


CREATE TABLE replies(
	reply_id BIGINT AUTO_INCREMENT PRIMARY KEY,
	community_id BIGINT NOT NULL,
	member_id VARCHAR(20) NOT NULL,
	content VARCHAR(3000) NOT NULL,
	write_date DATETIME DEFAULT NULL,
	is_state TINYINT(1) NOT NULL DEFAULT 1
);
ALTER TABLE replies ADD CONSTRAINT FOREIGN KEY(community_id) REFERENCES communities(community_id);
ALTER TABLE replies ADD CONSTRAINT FOREIGN KEY(member_id) REFERENCES members(id);


