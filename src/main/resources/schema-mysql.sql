USE
`cardealership-db`;

create table if not exists department_positions
(
    department_id
    INTEGER,
    title
    VARCHAR
(
    50
),
    code VARCHAR
(
    50
)
    );

create table if not exists departments
(
    id
    INTEGER
    NOT
    NULL
    AUTO_INCREMENT
    PRIMARY
    KEY,
    department_id
    VARCHAR
(
    36
),
    name VARCHAR
(
    50
),
    head_count INTEGER
    );

create table if not exists employee_phonenumbers
(
    employee_id
    INTEGER,
    type
    VARCHAR
(
    50
),
    number VARCHAR
(
    50
)
    );

create table if not exists employees
(
    id
    INTEGER
    NOT
    NULL
    AUTO_INCREMENT
    PRIMARY
    KEY,
    employee_id
    VARCHAR
(
    36
),
    first_name VARCHAR
(
    50
),
    last_name VARCHAR
(
    50
),
    email VARCHAR
(
    50
),
    salary DECIMAL
(
    19,
    4
),
    commission_rate DECIMAL
(
    3,
    1
),
    street_address VARCHAR
(
    50
),
    city VARCHAR
(
    50
),
    province VARCHAR
(
    50
),
    country VARCHAR
(
    50
),
    postal_code VARCHAR
(
    9
),
    department_id VARCHAR
(
    36
),
    position_title VARCHAR
(
    50
)
    );

create table if not exists inventories
(
    id
    INTEGER
    NOT
    NULL
    AUTO_INCREMENT
    PRIMARY
    KEY,
    inventory_id
    VARCHAR
(
    36
),
    type VARCHAR
(
    100
)
    );

create table if not exists vehicle_options
(
    vehicle_id
    INTEGER,
    name
    VARCHAR
(
    100
),
    description VARCHAR
(
    200
),
    cost DECIMAL
(
    19,
    2
)
    );

create table if not exists vehicles
(
    id
    INTEGER
    NOT
    NULL
    AUTO_INCREMENT
    PRIMARY
    KEY,
    vin
    VARCHAR
(
    50
) UNIQUE,
    inventory_id VARCHAR
(
    36
),
    status VARCHAR
(
    50
),
    usage_type VARCHAR
(
    50
),
    year INTEGER,
    manufacturer VARCHAR
(
    100
),
    make VARCHAR
(
    50
),
    model VARCHAR
(
    75
),
    body_class VARCHAR
(
    100
),
    msrp DECIMAL
(
    19,
    2
),
    cost DECIMAL
(
    19,
    2
),
    total_options_cost DECIMAL
(
    19,
    2
)
    );