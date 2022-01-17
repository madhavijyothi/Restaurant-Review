CREATE TABLE user (
  
  id INTEGER (11) NOT NULL IDENTITY,
  firstName VARCHAR(30) NOT NULL,
  lastName VARCHAR(45),
  email VARCHAR(75) NOT NULL UNIQUE,
  password VARCHAR(128) NOT NULL,
  token VARCHAR(30) NOT NULL,
  PRIMARY KEY (id)
  
);

// if needed: drop table user IF EXISTS;

CREATE TABLE restaurant (
  
  id INTEGER (11) NOT NULL IDENTITY,
  logo VARCHAR(150),
  name VARCHAR(40) NOT NULL,
  address VARCHAR(120),
  phone VARCHAR(15),
  email VARCHAR(75),
  uri VARCHAR(75),
  PRIMARY KEY (id)
  
);

// if needed: drop table restaurant IF EXISTS;

CREATE TABLE review (
  
  id INTEGER (11) NOT NULL IDENTITY,
  createAt TIMESTAMP,
  userId INTEGER (11) NOT NULL,
  restaurantId INTEGER (11) NOT NULL,
  content VARCHAR(1000),
  rate smallint(1),
  
  PRIMARY KEY (id),
  FOREIGN KEY (userId) REFERENCES user(id),
  FOREIGN KEY (restaurantId) REFERENCES restaurant(id)
);