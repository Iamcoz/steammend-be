# change db
use steammend;


# drop
DROP TABLE IF EXISTS attache;
DROP TABLE IF EXISTS reply;
DROP TABLE IF EXISTS community;
DROP TABLE IF EXISTS community_kind;
DROP TABLE IF EXISTS member;


# create
CREATE TABLE member(
mem_id VARCHAR(20) PRIMARY KEY,
mem_pass VARCHAR(20) NOT NULL,
mem_name VARCHAR(20) NOT NULL,
mem_nickname VARCHAR(20) NOT NULL,
mem_state CHAR(1) NOT NULL
);


CREATE TABLE community_kind(
commu_kind_no INT AUTO_INCREMENT PRIMARY KEY,
commu_kind_name VARCHAR(100) NOT NULL
);


CREATE TABLE community(
commu_no INT AUTO_INCREMENT PRIMARY KEY,
mem_id VARCHAR(20) NOT NULL,
commu_kind_no INT NOT NULL,
commu_header VARCHAR(100) NOT NULL,
commu_title VARCHAR(500) NOT NULL,
commu_content TEXT NOT NULL,
commu_hit INT NOT NULL DEFAULT 0,
commu_state CHAR(1) NOT NULL
);
ALTER TABLE community ADD CONSTRAINT FOREIGN KEY(mem_id) REFERENCES member(mem_id) ON UPDATE CASCADE;
ALTER TABLE community ADD CONSTRAINT FOREIGN KEY(commu_kind_no) REFERENCES community_kind(commu_kind_no) ON UPDATE CASCADE;


CREATE TABLE attache(
atch_no INT AUTO_INCREMENT PRIMARY KEY,
commu_no INT NOT NULL,
atch_origin_name VARCHAR(3000) NOT NULL,
atch_server_name VARCHAR(3000) NOT NULL,
atch_path VARCHAR(1000) NOT NULL
);
ALTER TABLE attache ADD CONSTRAINT FOREIGN KEY(commu_no) REFERENCES community(commu_no) ON UPDATE CASCADE;


CREATE TABLE reply(
reply_no INT AUTO_INCREMENT PRIMARY KEY,
commu_no INT NOT NULL,
mem_id VARCHAR(20) NOT NULL,
reply_content VARCHAR(3000) NOT NULL,
reply_date VARCHAR(20) NOT NULL,
reply_state CHAR(1) NOT NULL
);
ALTER TABLE reply ADD CONSTRAINT FOREIGN KEY(commu_no) REFERENCES community(commu_no) ON UPDATE CASCADE;
ALTER TABLE reply ADD CONSTRAINT FOREIGN KEY(mem_id) REFERENCES member(mem_id) ON UPDATE CASCADE;


