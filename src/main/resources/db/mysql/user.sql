CREATE DATABASE IF NOT EXISTS cheapy;

ALTER DATABASE cheapy
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

CREATE USER 'cheapy'@'%' IDENTIFIED BY 'cheapy';
GRANT ALL PRIVILEGES ON cheapy.* TO 'cheapy'@'%';
