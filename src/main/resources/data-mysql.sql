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