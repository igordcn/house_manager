CREATE TABLE Bank(
    id uuid NOT NULL,
    "name" varchar(50) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE Category(
    id uuid NOT NULL,
    "name" varchar(50) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE Destination(
    id uuid NOT NULL,
    "name" varchar(50) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE Origin(
    id uuid NOT NULL,
    "name" varchar(50) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE Income(
    id uuid NOT NULL,
    "name" varchar(50) NOT NULL,
    amount numeric(11, 2) NOT NULL,
    "date" date NOT NULL,
    origin_id uuid NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(origin_id) REFERENCES Origin(id)
);

CREATE TABLE Expense(
    id uuid NOT NULL,
    "name" varchar(50) NOT NULL,
    amount numeric(11, 2) NOT NULL,
    "date" date NOT NULL,
    destination_id uuid NOT NULL,
    bank_id uuid NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(destination_id) REFERENCES Destination(id),
    FOREIGN KEY(bank_id) REFERENCES Bank(id)
);

CREATE TABLE Expense_Category(
    expense_id uuid NOT NULL,
    category_id uuid NOT NULL,
    FOREIGN KEY(category_id) REFERENCES Category(id),
    FOREIGN KEY(expense_id) REFERENCES Expense(id)
);
