# change db
use steammend;


# drop
DROP TABLE IF EXISTS attachements;
DROP TABLE IF EXISTS replies;
DROP TABLE IF EXISTS communities;
DROP TABLE IF EXISTS members;


# create
CREATE TABLE members(
	id 			VARCHAR(20) PRIMARY KEY,
	password 	VARCHAR(500) NOT NULL ,
	name 		VARCHAR(20) NOT NULL,
	nickname 	VARCHAR(20) NOT NULL,
	birth 		DATE NOT NULL,
	steam_id 	VARCHAR(30) NOT NULL,
	is_state 	TINYINT(1) NOT NULL
);


CREATE TABLE communities(
	community_id	BIGINT AUTO_INCREMENT PRIMARY KEY,
	fk_member_id 		VARCHAR(20) NOT NULL,
	header 			VARCHAR(100) NOT NULL,
	title 			VARCHAR(500) NOT NULL,
	content 		TEXT NOT NULL,
    write_date 		TIMESTAMP DEFAULT NOW() NOT NULL,
    hit 			INT NOT NULL DEFAULT 0,
	is_state 		TINYINT(1) NOT NULL
);
ALTER TABLE communities ADD CONSTRAINT FOREIGN KEY(fk_mem_id) REFERENCES member(id) ON UPDATE CASCADE;


CREATE TABLE attachments(
	attachment_id 	BIGINT AUTO_INCREMENT PRIMARY KEY,
	fk_community_id BIGINT NOT NULL,
	origin_name 	VARCHAR(3000) NOT NULL,
	server_name 	VARCHAR(3000) NOT NULL,
	path 			VARCHAR(1000) NOT NULL
);
ALTER TABLE attachments ADD CONSTRAINT FOREIGN KEY(fk_community_id) REFERENCES communities(community_id) ON UPDATE CASCADE;


CREATE TABLE replies(
	reply_id		BIGINT AUTO_INCREMENT PRIMARY KEY,
	fk_community_id BIGINT NOT NULL,
	fk_member_id 	VARCHAR(20) NOT NULL,
	content 		VARCHAR(3000) NOT NULL,
	write_date 		TIMESTAMP DEFAULT NOW() NOT NULL,
	is_state 		TINYINT(1) NOT NULL
);
ALTER TABLE replies ADD CONSTRAINT FOREIGN KEY(fk_community_id) REFERENCES communities(community_id) ON UPDATE CASCADE;
ALTER TABLE replies ADD CONSTRAINT FOREIGN KEY(fk_member_id) REFERENCES members(id) ON UPDATE CASCADE;


