insert into positions(description)
    values ('Java developer');

insert into workstations(city, cep, name, description)
    values ('Lisboa', '1322343', 'Lisboa office central park', 'workstation of lisboa');

insert into employees(name, cpf, address, phone, salary, birthday, hiring_date, position_id)
    values ('Rafael', '3811.112.234-43', 'Rua 1 de maio, moscavide, lisboa', '913111333', 1000.00, '01/01/1989', '01/01/2021', 1);

insert into employee_workstation(fk_employee, fk_workstation)
	values (1, 1);



-- Position
--    private String description;
--    private List<Employee> employees;

-- Workstation
--    private String city;
--    private String cep;
--    private String name;
--    private String description;
--    private List<Employee> employee;

-- Employee
--    private String name;
--    private String cpf;
--    private String address;
--    private String phone;
--    private BigDecimal salary;
--    private LocalDate birthday;
--    private LocalDate hiringDate;
--    private Position position;
--    private List<Workstation> workstations;


