insert into departments(department_id, name, head_count)
values ('1048b354-c18f-4109-8282-2a85485bfa5a', 'human resources', 2);
insert into department_positions(department_id, title, code)
values (1, 'manager', 'hrm1');
insert into department_positions(department_id, title, code)
values (1, 'associate', 'hra1');
insert into employees(employee_id, first_name, last_name, email, salary, commission_rate, street_address, city,
                      province, country, postal_code, department_id, position_title)
values ('e5913a79-9b1e-4516-9ffd-06578e7af261', 'Vilma', 'Chawner', 'vchawner0@phoca.cz', 34000, 0.0,
        '8452 Anhalt Park', 'Chambly', 'Québec', 'Canada', 'J3L 5Y6', '1048b354-c18f-4109-8282-2a85485bfa5a',
        'manager');

insert into employee_phonenumbers(employee_id, type, number)
values (1, 'WORK', '515-555-5555');
insert into employee_phonenumbers(employee_id, type, number)
values (1, 'MOBILE', '514-555-4444');

insert into inventories (inventory_id, type)
values ('d846a5a7-2e1c-4c79-809c-4f3f471e826d', 'vehicles');
insert into inventories (inventory_id, type)
values ('3fe5c169-c1ef-42ea-9e5e-870f30ba9dd0', 'vehicles-luxury');
insert into vehicles (vin, inventory_id, status, usage_type, year, manufacturer, make, model, body_class, msrp, cost,
                      total_options_cost)
values ('JN8AS5MTXDW375966', 'd846a5a7-2e1c-4c79-809c-4f3f471e826d', 'AVAILABLE', 'NEW', 2013,
        'NISSAN MOTOR COMPANY, LTD', 'NISSAN', 'Rogue', 'Crossover Utility Vehicle (CUV)', 73536.64, 64330.65,
        15470.82);
insert into vehicles (vin, inventory_id, status, usage_type, year, manufacturer, make, model, body_class, msrp, cost,
                      total_options_cost)
values ('3VW507AT0FM145078', 'd846a5a7-2e1c-4c79-809c-4f3f471e826d', 'AVAILABLE', 'USED', 2015,
        'VOLKSWAGEN DE MEXICO SA DE CV', 'VOLKSWAGEN', 'Beetle', 'Convertible/Cabriolet', 56915.94, 51199.68, 00.00);
insert into vehicles (vin, inventory_id, status, usage_type, year, manufacturer, make, model, body_class, msrp, cost,
                      total_options_cost)
values ('2T1KU4EE5BC676204', 'd846a5a7-2e1c-4c79-809c-4f3f471e826d', 'SALE_PENDING', 'USED', 2011,
        'TOYOTA MOTOR MANUFACTURING CANADA', 'TOYOTA', 'Corolla Matrix', 'Sedan/Saloon', 65712.51, 60259.06, 00.00);
insert into vehicles (vin, inventory_id, status, usage_type, year, manufacturer, make, model, body_class, msrp, cost,
                      total_options_cost)
values ('5N1AR1NB3CC804298', '3fe5c169-c1ef-42ea-9e5e-870f30ba9dd0', 'SALE_PENDING', 'NEW', 2012,
        'NISSAN NORTH AMERICA, INC.', 'NISSAN', 'Pathfinder', 'Crossover Utility Vehicle (CUV)', 39112.98, 36915.15,
        1900.00);
insert into vehicles (vin, inventory_id, status, usage_type, year, manufacturer, make, model, body_class, msrp, cost,
                      total_options_cost)
values ('WAUDGAFL4EA518776', '3fe5c169-c1ef-42ea-9e5e-870f30ba9dd0', 'SOLD', 'NEW', 2014, 'AUDI AG', 'AUDI', 'S4',
        'Sedan/Saloon', 81384.04, 55761.93, 2900.00);
insert into vehicles (vin, inventory_id, status, usage_type, year, manufacturer, make, model, body_class, msrp, cost,
                      total_options_cost)
values ('SCFAB05D69G083403', 'd846a5a7-2e1c-4c79-809c-4f3f471e826d', 'SOLD', 'USED', 2009,
        'ASTON MARTIN LAGONDA LIMITED', 'ASTON MARTIN', 'DBS', 'Coupe', 96447.83, 90442.16, 00.00);
insert into vehicles (vin, inventory_id, status, usage_type, year, manufacturer, make, model, body_class, msrp, cost,
                      total_options_cost)
values ('1N6AF0KX3FN483814', '3fe5c169-c1ef-42ea-9e5e-870f30ba9dd0', 'SOLD', 'NEW', 2015, 'NISSAN NORTH AMERICA, INC.',
        'NISSAN', 'NV', 'Cargo Van', 87370.77, 76372.27, 10005.65);
insert into vehicles (vin, inventory_id, status, usage_type, year, manufacturer, make, model, body_class, msrp, cost,
                      total_options_cost)
values ('WBAYA8C50FG933061', '3fe5c169-c1ef-42ea-9e5e-870f30ba9dd0', 'AVAILABLE', 'USED', 2015, 'BMW AG', 'BMW',
        '750i / ALPINA B7', 'Sedan/Saloon', 44048.52, 42538.11, 00.00);
insert into vehicles (vin, inventory_id, status, usage_type, year, manufacturer, make, model, body_class, msrp, cost,
                      total_options_cost)
values ('4T1BF1FK5FU100601', '3fe5c169-c1ef-42ea-9e5e-870f30ba9dd0', 'AVAILABLE', 'NEW', 2015,
        'TOYOTA MOTOR MANUFACTURING, KENTUCKY, INC.', 'TOYOTA', 'Camry', 'Sedan/Saloon', 73319.16, 46483.09, 5950.00);
insert into vehicles (vin, inventory_id, status, usage_type, year, manufacturer, make, model, body_class, msrp, cost,
                      total_options_cost)
values ('JH4CL96808C431274', 'd846a5a7-2e1c-4c79-809c-4f3f471e826d', 'AVAILABLE', 'USED', 2008, 'HONDA MOTOR CO., LTD',
        'ACURA', 'TSX', 'Sedan/Saloon', 48970.84, 48097.54, 00.00);
insert into vehicle_options (vehicle_id, name, description, cost)
values (4, 'Driving Assistance Professional Package', "-inc: Active Cruise Control w/Stop & Go, Traffic Jam Assistant",
        1900.00);
insert into vehicle_options (vehicle_id, name, description, cost)
values (5, 'Primary Paint', 'Aventurin Red Metallic', 1950.00);
insert into vehicle_options (vehicle_id, name, description, cost)
values (5, 'Wheels', '-inc: Increased Top Speed Limiter, Tires: 275/40R22 Performance Non Run-Flat', 950.00);
insert into vehicle_options (vehicle_id, name, description, cost)
values (9, 'Sports Package', '-inc: Shadowline Exterior Trim, Aluminum Tetragon Trim, M Steering Wheel', 3050.00);
insert into vehicle_options (vehicle_id, name, description, cost)
values (9, 'Seat Trim', 'Black w/Blue Stitching, Vernasca Leather Upholstery', 1500.00);
insert into vehicle_options (vehicle_id, name, description, cost)
values (9, 'Premium Package',
        '-inc: Comfort Access Keyless Entry, Driver Lumbar Support, Live Cockpit Pro w/Navi, Heated Steering Wheel, Heated Front Seats',
        1400.00);
insert into vehicle_options (vehicle_id, name, description, cost)
values (1, 'Wheels', '-inc: Style 1023, Increased Top Speed Limiter, Tires: 275/40R22 Performance Non Run-Flat',
        1794.17);
insert into vehicle_options (vehicle_id, name, description, cost)
values (1, 'Seat Trim', 'Castanea Chestnut, Olive Leaf Tanned Perforated Leather Upholstery', 4038.33);
insert into vehicle_options (vehicle_id, name, description, cost)
values (1, 'Executive Package',
        '-inc: Active Cruise Control w/Stop & Go, Glass & Wood Controls, Soft-Close Automatic Doors, Traffic Jam Assistant, Active Lane',
        9638.32);