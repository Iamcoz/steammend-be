# change db
use steammend;


# drop
DROP TABLE IF EXISTS replies;
DROP TABLE IF EXISTS communities;
DROP TABLE IF EXISTS members;


# create
CREATE TABLE members(
	id VARCHAR(12) PRIMARY KEY,
	password VARCHAR(60) NOT NULL ,
	name VARCHAR(20) NOT NULL,
	nickname VARCHAR(8) NOT NULL,
	birthday DATE NOT NULL,
	steam_id VARCHAR(17) NOT NULL,
    created_at DATETIME DEFAULT NULL,
    updated_at DATETIME DEFAULT NULL,
	is_deleted TINYINT(1) NOT NULL DEFAULT 0
);


CREATE TABLE communities(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	member_id VARCHAR(12) NOT NULL,
	header VARCHAR(10) NOT NULL,
	title VARCHAR(100) NOT NULL,
	content TEXT NOT NULL,
    hit INT NOT NULL DEFAULT 0,
    created_at DATETIME DEFAULT NULL,
    updated_at DATETIME DEFAULT NULL,
	is_deleted TINYINT(1) NOT NULL DEFAULT 0
);
ALTER TABLE communities ADD CONSTRAINT FOREIGN KEY(member_id) REFERENCES members(id);


CREATE TABLE replies(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	community_id BIGINT NOT NULL,
	member_id VARCHAR(12) NOT NULL,
	content VARCHAR(300) NOT NULL,
	created_at DATETIME DEFAULT NULL,
    updated_at DATETIME DEFAULT NULL,
	is_deleted TINYINT(1) NOT NULL DEFAULT 0
);
ALTER TABLE replies ADD CONSTRAINT FOREIGN KEY(community_id) REFERENCES communities(id);
ALTER TABLE replies ADD CONSTRAINT FOREIGN KEY(member_id) REFERENCES members(id);


