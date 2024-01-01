create database carrented ;
use carrented;
CREATE TABLE rented_cars (
	car_id int primary key auto_increment,
    car_num VARCHAR(50) ,
    model VARCHAR(100),
    rented_by_name VARCHAR(100),
    rented_by_email VARCHAR(100),
    rented_by_id_proof VARCHAR(100), -- New column for customer ID proof
    rental_date TIMESTAMP,
    return_date TIMESTAMP,
    cost_total double
);
CREATE TABLE available_cars (
    car_num VARCHAR(50) PRIMARY KEY,
    model VARCHAR(100),
    available BOOLEAN
);

INSERT INTO available_cars (car_num, model, available)
VALUES
  ('ABC123', 'Toyota Camry', true),
  ('XYZ789', 'Honda Accord', true),
  ('DEF456', 'Ford Mustang', true),
  ('GHI789', 'Chevrolet Malibu', true),
  ('JKL012', 'Nissan Altima', true);

update rented_cars set return_date= now() where car_num='ABC123' and rented_by_name = 'sid';
select * from rented_cars;
select * from available_cars;

