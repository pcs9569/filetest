-- ● 가게 관리용 store table
CREATE TABLE store (
                       sto_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '가게ID',
                       sto_name VARCHAR(45) NOT NULL COMMENT '이름',
                       sto_picture VARCHAR(45) DEFAULT NULL COMMENT '사진',
                       sto_detail_option VARCHAR(45) DEFAULT NULL COMMENT '상세 옵션',
                       sto_lat DOUBLE NOT NULL COMMENT '위치(위도)',
                       sto_lon DOUBLE NOT NULL COMMENT '위치(경도)',
                       sto_register_date TIMESTAMP NOT NULL DEFAULT NOW() COMMENT '등록일',
                       sto_mod_date DATETIME NULL COMMENT '수정일'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE store COMMENT '가게';



-- ● 회원 관리용 user table
CREATE TABLE user
(
    `u_email`  VARCHAR(45)    NOT NULL    COMMENT 'SNS(회원계정)',
    `u_name`   VARCHAR(45)    NOT NULL    COMMENT '이름',
    `u_pw`     VARCHAR(45)    NOT NULL    COMMENT '비밀번호',
    `u_date`   TIMESTAMP      NOT NULL  DEFAULT NOW()   COMMENT '가입일',
    `u_level`  INT            NOT NULL  DEFAULT 1 COMMENT '회원등급',
    PRIMARY KEY (u_email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE user COMMENT '회원';



-- ● 리뷰 관리용 review table
CREATE TABLE review
(
    `rev_id`        INT            NOT NULL    AUTO_INCREMENT COMMENT '리뷰ID',
    `sto_id`        INT            NOT NULL    COMMENT '가게ID',
    `u_email`       VARCHAR(45)    NULL        COMMENT 'SNS(회원계정)',
    `rev_content`   TEXT           NOT NULL    COMMENT '리뷰내용',
    `rev_reg_date`  TIMESTAMP      NOT NULL  DEFAULT NOW()   COMMENT '등록일',
    `rev_mod_date`  DATETIME       NULL        COMMENT '수정일',
    PRIMARY KEY (rev_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE review COMMENT '리뷰';

ALTER TABLE review
    ADD CONSTRAINT FK_review_sto_id_store_sto_id FOREIGN KEY (sto_id)
        REFERENCES store (sto_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE review
    ADD CONSTRAINT FK_review_u_email_user_u_email FOREIGN KEY (u_email)
        REFERENCES user (u_email) ON DELETE RESTRICT ON UPDATE RESTRICT;



-- ● 음식 관리용 food table
CREATE TABLE food
(
    `food_id`  INT            NOT NULL    AUTO_INCREMENT COMMENT '음식ID',
    `sto_id`   INT            NOT NULL    COMMENT '가게ID',
    `food`     VARCHAR(45)    NOT NULL    COMMENT '음식',
    PRIMARY KEY (food_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE food COMMENT '음식';

ALTER TABLE food
    ADD CONSTRAINT FK_food_sto_id_store_sto_id FOREIGN KEY (sto_id)
        REFERENCES store (sto_id) ON DELETE RESTRICT ON UPDATE RESTRICT;



-- ● 신고 관리용 notify table
CREATE TABLE notify
(
    `noti_id`        INT            NOT NULL    AUTO_INCREMENT COMMENT '신고ID',
    `sto_id`         INT            NOT NULL    COMMENT '가게ID',
    `u_email`        VARCHAR(45)    NOT NULL    COMMENT 'SNS(회원계정)',
    `noti_content`   TEXT           NOT NULL    COMMENT '신고내용',
    `noti_reg_date`  TIMESTAMP      NOT NULL  DEFAULT NOW()   COMMENT '등록일',
    `noti_type`      TINYINT        NOT NULL    COMMENT '신고유형',
    PRIMARY KEY (noti_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE notify COMMENT '신고';

ALTER TABLE notify
    ADD CONSTRAINT FK_notify_sto_id_store_sto_id FOREIGN KEY (sto_id)
        REFERENCES store (sto_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE notify
    ADD CONSTRAINT FK_notify_u_email_user_u_email FOREIGN KEY (u_email)
        REFERENCES user (u_email) ON DELETE RESTRICT ON UPDATE RESTRICT;


-- ● 좋아요 관리용 like table
CREATE TABLE like
(
    `like_id`  INT            NOT NULL    AUTO_INCREMENT COMMENT '좋아요ID',
    `sto_id`   INT            NOT NULL    COMMENT '가게ID',
    `u_email`  VARCHAR(45)    NOT NULL    COMMENT 'SNS(회원계정)',
    `like`     TINYINT        NOT NULL    COMMENT '좋아요',
    PRIMARY KEY (like_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE like COMMENT '좋아요';

ALTER TABLE like
    ADD CONSTRAINT FK_like_sto_id_store_sto_id FOREIGN KEY (sto_id)
        REFERENCES store (sto_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE like
    ADD CONSTRAINT FK_like_u_email_user_u_email FOREIGN KEY (u_email)
        REFERENCES user (u_email) ON DELETE RESTRICT ON UPDATE RESTRICT;


-- ● 별점 관리용 star table
CREATE TABLE star
(
    `star_id`  INT            NOT NULL    AUTO_INCREMENT COMMENT '별점ID',
    `sto_id`   INT            NOT NULL    COMMENT '가게ID',
    `u_email`  VARCHAR(45)    NOT NULL    COMMENT 'SNS(회원계정)',
    `star`     INT            NOT NULL    COMMENT '별점',
    PRIMARY KEY (star_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE star COMMENT '별점';

ALTER TABLE star
    ADD CONSTRAINT FK_star_sto_id_store_sto_id FOREIGN KEY (sto_id)
        REFERENCES store (sto_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE star
    ADD CONSTRAINT FK_star_u_email_user_u_email FOREIGN KEY (u_email)
        REFERENCES user (u_email) ON DELETE RESTRICT ON UPDATE RESTRICT;