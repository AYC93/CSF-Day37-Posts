drop database if exists wkshp37;

create database wkshp37;

use wkshp37;

create table image(
    post_id int auto_increment,
    comments mediumtext,
    media_type varchar(45),
    image mediumblob,


    primary key (post_id)
);

GRANT ALL PRIVILEGES ON wkshp37.* to 'fred'@'localhost';