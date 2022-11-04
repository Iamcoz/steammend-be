# change db
use steammend;


# drop
DROP TABLE IF EXISTS attachments;
DROP TABLE IF EXISTS replies;
DROP TABLE IF EXISTS communities;
DROP TABLE IF EXISTS members;


# create
CREATE TABLE members(
	id VARCHAR(12) PRIMARY KEY,
<<<<<<< HEAD
	password VARCHAR(240) NOT NULL ,
	name VARCHAR(20) NOT NULL,
	nickname VARCHAR(8) NOT NULL,
	birthday DATE NOT NULL,
	steam_id VARCHAR(50) NOT NULL,
=======
	password VARCHAR(60) NOT NULL ,
	name VARCHAR(20) NOT NULL,
	nickname VARCHAR(8) NOT NULL,
	birthday DATE NOT NULL,
	steam_id VARCHAR(17) NOT NULL,
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
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
<<<<<<< HEAD
    created_at DATETIME DEFAULT NULL,
    updated_at DATETIME DEFAULT NULL,
	is_deleted TINYINT(1) NOT NULL DEFAULT 0
);
=======
	is_deleted TINYINT(1) NOT NULL DEFAULT 1,
    created_at DATETIME DEFAULT NULL,
    updated_at DATETIME DEFAULT NULL
);

>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
ALTER TABLE communities ADD CONSTRAINT FOREIGN KEY(member_id) REFERENCES members(id);


CREATE TABLE attachments(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	community_id BIGINT NOT NULL,
<<<<<<< HEAD
    original_name VARCHAR(150) NOT NULL,
    upload_name VARCHAR(50) NOT NULL,
	upload_path VARCHAR(150) NOT NULL,
    created_at DATETIME DEFAULT NULL,
    updated_at DATETIME DEFAULT NULL,
    is_deleted TINYINT(1) NOT NULL DEFAULT 0
=======
	path VARCHAR(1000) NOT NULL,
    is_deleted TINYINT(1) NOT NULL DEFAULT 1,
    created_at DATETIME DEFAULT NULL,
    updated_at DATETIME DEFAULT NULL
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
);
ALTER TABLE attachments ADD CONSTRAINT FOREIGN KEY(community_id) REFERENCES communities(id);


CREATE TABLE replies(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
<<<<<<< HEAD
	community_id BIGINT NOT NULL,
	member_id VARCHAR(12) NOT NULL,
	content VARCHAR(300) NOT NULL,
	created_at DATETIME DEFAULT NULL,
    updated_at DATETIME DEFAULT NULL,
	is_deleted TINYINT(1) NOT NULL DEFAULT 0
=======
	member_id VARCHAR(12) NOT NULL,
	community_id BIGINT NOT NULL,
	content VARCHAR(300) NOT NULL,
	is_deleted TINYINT(1) NOT NULL DEFAULT 1,
    created_at DATETIME DEFAULT NULL,
    updated_at DATETIME DEFAULT NULL
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
);
ALTER TABLE replies ADD CONSTRAINT FOREIGN KEY(community_id) REFERENCES communities(id);
ALTER TABLE replies ADD CONSTRAINT FOREIGN KEY(member_id) REFERENCES members(id);


