delete from user;
delete from review;
delete from restaurant;

insert into user(id,first_name, last_name, email, password, token) values(1,'testFirstName', 'testLastName', 'test@test.ch', 'testpw', 'testToken');
insert into user(id,first_name, last_name, email, password, token) values(2,'testFirstName2', 'testLastName2', 'test2@test.ch', 'testpw2', 'testToken2');
insert into user(id,first_name, last_name, email, password, token) values(3,'testFirstName3', 'testLastName3', 'test3@test.ch', 'testpw3', 'testToken3');


insert into restaurant(id,logo, name, address, phone, email, uri) values(1,'testLogo', 'testRestaurantName', 'testAddress', '0123456789', 'testrestaurant@test.ch', 'testuri');
insert into restaurant(id,logo, name, address, phone, email, uri) values(2,'testLogo2', 'testRestaurantName2', 'testAddress2', '01234567892', 'testrestaurant2@test.ch', 'testuri2');
insert into restaurant(id,logo, name, address, phone, email, uri) values(3,'testLogo3', 'testRestaurantName3', 'testAddress3', '01234567893', 'testrestaurant3@test.ch', 'testuri3');

insert into review(id,create_at, user_id, restaurant_id, content, rate) values(1,{ts '2017-01-01 00:00:00.00'} , 1, 2, 'irgendwas text10..', 2);
insert into review(id,create_at, user_id, restaurant_id, content, rate) values(2,{ts '2017-01-01 00:00:00.00'} , 1, 2, 'irgendwas text2..', 2);
insert into review(id,create_at, user_id, restaurant_id, content, rate) values(3,{ts '2017-01-01 00:00:00.00'} , 2, 1, 'irgendwas text3..', 3);

