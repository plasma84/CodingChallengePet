CREATE DATABASE CourierManagementSystem;
USE CourierManagementSystem;
CREATE TABLE User (
    UserID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(255),
    Email VARCHAR(255) UNIQUE,
    Password VARCHAR(255),
    ContactNumber VARCHAR(20),
    Address TEXT
);
select * from user;
CREATE TABLE Courier (
    CourierID INT PRIMARY KEY AUTO_INCREMENT,
    SenderName VARCHAR(255),
    SenderAddress TEXT,
    ReceiverName VARCHAR(255),
    ReceiverAddress TEXT,
    Weight DECIMAL(5, 2),
    Status VARCHAR(50),
    TrackingNumber VARCHAR(20) UNIQUE,
    DeliveryDate DATE
);
CREATE TABLE CourierServices (
    ServiceID INT PRIMARY KEY AUTO_INCREMENT,
    ServiceName VARCHAR(100),
    Cost DECIMAL(8,2)
);
CREATE TABLE Employee (
    EmployeeID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(255),
    Email VARCHAR(255) UNIQUE,
    ContactNumber VARCHAR(20),
    Role VARCHAR(50),
    Salary DECIMAL(10,2)
);
CREATE TABLE Location (
    LocationID INT PRIMARY KEY AUTO_INCREMENT,
    LocationName VARCHAR(100),
    Address TEXT
);
CREATE TABLE Payment (
    PaymentID INT PRIMARY KEY AUTO_INCREMENT,
    CourierID INT,
    LocationID INT,
    Amount DECIMAL(10,2),
    PaymentDate DATE,
    FOREIGN KEY (CourierID) REFERENCES Courier(CourierID),
    FOREIGN KEY (LocationID) REFERENCES Location(LocationID)
);

-- SQL schema for the `pets` table
CREATE TABLE pets (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    breed VARCHAR(255) NOT NULL
);

INSERT INTO User (Name, Email, Password, ContactNumber, Address) VALUES
('Madhu K', 'madhu.k@example.com', 'madhu123', '9876543210', '12 MG Road, Bengaluru'),
('Kavin Kaarthik', 'kavin.kaarthik@example.com', 'kavinpass', '8765432109', '45 T Nagar, Chennai'),
('Suryanarayanan G', 'suryanarayanan.g@example.com', 'surya789', '9988776655', '78 Gandhi Nagar, Coimbatore'),
('Sivaganesh N', 'sivaganesh.n@example.com', 'siva456', '8899001122', '23 RK Salai, Madurai'),
('Shardul Kulkarni', 'shardul.kulkarni@example.com', 'shardulpass', '9098765432', '56 FC Road, Pune'),
('Shantanu Agarkar', 'shantanu.agarkar@example.com', 'shantanupass', '7788996655', '34 JM Road, Mumbai'),
('Sai Vighnessh', 'sai.vighnessh@example.com', 'saivign123', '8877665544', '91 Velachery, Chennai'),
('Rohit Sharma', 'rohit.sharma@example.com', 'rohit321', '7654321987', '25 Bandra West, Mumbai'),
('Priya Iyer', 'priya.iyer@example.com', 'priya123', '9988112233', '14 Adyar, Chennai'),
('Ankit Verma', 'ankit.verma@example.com', 'ankit789', '9898776655', '78 Hazratganj, Lucknow');
INSERT INTO Courier (SenderName, SenderAddress, ReceiverName, ReceiverAddress, Weight, Status, TrackingNumber, DeliveryDate) VALUES
('Madhu K', '12 MG Road, Bengaluru', 'Kavin Kaarthik', '45 T Nagar, Chennai', 2.5, 'In Transit', 'TRK10001', '2025-03-20'),
('Suryanarayanan G', '78 Gandhi Nagar, Coimbatore', 'Sivaganesh N', '23 RK Salai, Madurai', 5.2, 'Delivered', 'TRK10002', '2025-03-18'),
('Shardul Kulkarni', '56 FC Road, Pune', 'Shantanu Agarkar', '34 JM Road, Mumbai', 3.8, 'Pending', 'TRK10003', '2025-03-22'),
('Sai Vighnessh', '91 Velachery, Chennai', 'Rohit Sharma', '25 Bandra West, Mumbai', 1.1, 'In Transit', 'TRK10004', '2025-03-21'),
('Priya Iyer', '14 Adyar, Chennai', 'Ankit Verma', '78 Hazratganj, Lucknow', 4.3, 'Shipped', 'TRK10005', '2025-03-19'),
('Kavin Kaarthik', '45 T Nagar, Chennai', 'Madhu K', '12 MG Road, Bengaluru', 6.0, 'Delivered', 'TRK10006', '2025-03-17'),
('Shantanu Agarkar', '34 JM Road, Mumbai', 'Shardul Kulkarni', '56 FC Road, Pune', 2.9, 'Pending', 'TRK10007', '2025-03-23'),
('Rohit Sharma', '25 Bandra West, Mumbai', 'Sai Vighnessh', '91 Velachery, Chennai', 3.5, 'In Transit', 'TRK10008', '2025-03-20'),
('Ankit Verma', '78 Hazratganj, Lucknow', 'Priya Iyer', '14 Adyar, Chennai', 5.7, 'Delivered', 'TRK10009', '2025-03-18'),
('Sivaganesh N', '23 RK Salai, Madurai', 'Suryanarayanan G', '78 Gandhi Nagar, Coimbatore', 4.1, 'Shipped', 'TRK10010', '2025-03-19');
INSERT INTO CourierServices (ServiceName, Cost) VALUES
('Standard Delivery', 99.00),
('Express Delivery', 199.00),
('Overnight Delivery', 299.00),
('International Shipping', 999.00),
('Same Day Delivery', 249.00);
INSERT INTO Employee (Name, Email, ContactNumber, Role, Salary) VALUES
('Ankit Deshmukh', 'ankit.deshmukh@example.com', '9823456789', 'Branch Manager', 85000.00),
('Meera Iyer', 'meera.iyer@example.com', '9812345678', 'Operations Manager', 72000.00),
('Rohit Patil', 'rohit.patil@example.com', '9898989898', 'Delivery Executive', 38000.00),
('Pooja Shah', 'pooja.shah@example.com', '9876567890', 'Quality Supervisor', 58000.00),
('Vikram Reddy', 'vikram.reddy@example.com', '9765432109', 'Logistics Coordinator', 45000.00);
INSERT INTO Location (LocationName, Address) VALUES
('Pune Warehouse', '123 Hinjewadi Phase 1 Rd'),
('Mumbai Distribution Center', '456 Andheri East St'),
('Chennai Logistics Hub', '789 OMR IT Expressway'),
('Delhi Head Office', '101 Connaught Place Blvd'),
('Bangalore Regional Hub', '202 Whitefield Main Rd');
INSERT INTO Payment (CourierID, LocationID, Amount, PaymentDate) VALUES
(1, 1, 499.00, '2025-03-20'),
(2, 2, 899.00, '2025-03-18'),
(3, 3, 299.00, '2025-03-22'),
(4, 4, 199.00, '2025-03-21'),
(5, 5, 649.00, '2025-03-19');
 SELECT * FROM User;
 SELECT * FROM Courier WHERE SenderName = 'shantanu agarkar';
 SELECT * FROM Courier;
 SELECT * FROM Courier WHERE TrackingNumber = 'TRK10007';
 SELECT * FROM courier WHERE CourierID = 1;
 SELECT * FROM Courier WHERE Status != 'Delivered';
 SELECT * FROM Courier WHERE Status = 'In Transit';
 SELECT SenderName, COUNT(*) AS TotalPackages FROM Courier GROUP BY SenderName;
 SELECT SenderName, AVG(DATEDIFF(DeliveryDate, NOW())) AS AvgDeliveryTime FROM Courier GROUP BY SenderName;
 SELECT * FROM Courier WHERE Weight BETWEEN 2 AND 5;
 SELECT * FROM Employee WHERE Name LIKE '%pooja%';
 ALTER TABLE Courier ADD COLUMN EmployeeID INT;
 ALTER TABLE Courier ADD FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID);
 select * from courier ;
 select * from Employee;
 UPDATE Courier
SET EmployeeID = 1
WHERE CourierID IN (1, 6);

UPDATE Courier
SET EmployeeID = 2
WHERE CourierID IN (2, 7);

UPDATE Courier
SET EmployeeID = 3
WHERE CourierID IN (3, 8);

UPDATE Courier
SET EmployeeID = 4
WHERE CourierID IN (4, 9);

UPDATE Courier
SET EmployeeID = 5
WHERE CourierID IN (5, 10);
SELECT e.EmployeeID, e.Name, COUNT(c.CourierID) AS TotalCouriersHandled  
FROM Employee e  
LEFT JOIN Courier c ON e.EmployeeID = c.EmployeeID  
GROUP BY e.EmployeeID, e.Name  
ORDER BY TotalCouriersHandled DESC;
SELECT LocationID, SUM(Amount) AS TotalRevenue 
FROM Payment 
GROUP BY LocationID;
SELECT ReceiverAddress, COUNT(*) AS TotalDeliveredCouriers
FROM Courier
WHERE Status = 'Delivered'
GROUP BY ReceiverAddress;
SELECT SenderName, AVG(DATEDIFF(DeliveryDate, NOW())) AS AvgDeliveryTime 
FROM Courier 
GROUP BY SenderName 
ORDER BY AvgDeliveryTime DESC 
LIMIT 1;  
SELECT l.LocationID, l.LocationName, SUM(p.Amount) AS TotalPayments
FROM Location l
JOIN Payment p ON l.LocationID = p.LocationID
GROUP BY l.LocationID, l.LocationName
HAVING SUM(p.Amount) < 1000; 
SELECT LocationID, SUM(Amount) AS TotalPayments 
FROM Payment 
GROUP BY LocationID;
SELECT CourierID, SUM(Amount) AS TotalPayments 
FROM Payment 
WHERE LocationID = 3
GROUP BY CourierID 
HAVING TotalPayments > 10;

SELECT CourierID, SUM(Amount) AS TotalPayments 
FROM Payment 
WHERE PaymentDate > '2024-03-18' 
GROUP BY CourierID 
HAVING TotalPayments > 10;
SELECT LocationID, SUM(Amount) AS TotalReceived
FROM Payment 
WHERE PaymentDate < '2025-03-20' 
GROUP BY LocationID 
HAVING TotalReceived > 500;
select * from payment;
SELECT Payment.*, Courier.*
FROM Payment
INNER JOIN Courier ON Payment.CourierID = Courier.CourierID;
SELECT Payment.*, Location.*
FROM Payment
INNER JOIN Location ON Payment.LocationID = Location.LocationID;
SELECT Payment.*, Courier.*, Location.*
FROM Payment
INNER JOIN Courier ON Payment.CourierID = Courier.CourierID
INNER JOIN Location ON Payment.LocationID = Location.LocationID;
SELECT Payment.*, Courier.*
FROM Payment
LEFT JOIN Courier ON Payment.CourierID = Courier.CourierID;
SELECT Courier.CourierID, Courier.SenderName, SUM(Payment.Amount) AS TotalPayments
FROM Payment
INNER JOIN Courier ON Payment.CourierID = Courier.CourierID
GROUP BY Courier.CourierID, Courier.SenderName;
SELECT * FROM Payment
WHERE PaymentDate = '2025-3-20';
SELECT Payment.*, Courier.*
FROM Payment
LEFT JOIN Courier ON Payment.CourierID = Courier.CourierID;
SELECT Payment.*, Location.*
FROM Payment
LEFT JOIN Location ON Payment.LocationID = Location.LocationID;
SELECT Courier.CourierID, Courier.SenderName, SUM(Payment.Amount) AS TotalPayments 
FROM Payment
INNER JOIN Courier ON Payment.CourierID = Courier.CourierID
GROUP BY Courier.CourierID, Courier.SenderName;
SELECT * FROM Payment
SELECT Employee.*, Location.*
FROM Employee
CROSS JOIN Location;  


WHERE PaymentDate BETWEEN '2024-03-18' AND '2025-03-22';
SELECT Courier.*, CourierServices.*
FROM Courier
LEFT JOIN CourierServices ON Courier.CourierID = CourierServices.ServiceID;
SELECT Employee.*, Payment.*
FROM Employee
LEFT JOIN Payment ON Employee.EmployeeID = Payment.CourierID;
SELECT User.*, CourierServices.*
FROM User
CROSS JOIN CourierServices;

SELECT Employee.*, Location.*
FROM Employee
CROSS JOIN Location;  
SELECT Courier.CourierID, Courier.SenderName, Courier.SenderAddress
FROM Courier;
SELECT Courier.CourierID, Courier.ReceiverName, Courier.ReceiverAddress
FROM Courier;
SELECT Courier.*, CourierServices.*
FROM Courier
LEFT JOIN CourierServices ON Courier.CourierID = CourierServices.ServiceID;
SELECT Employee.EmployeeID, Employee.Name, COUNT(Courier.CourierID) AS AssignedCouriers
FROM Employee
LEFT JOIN Courier ON Employee.EmployeeID = Courier.CourierID
GROUP BY Employee.EmployeeID, Employee.Name;
SELECT Location.LocationID, Location.LocationName, SUM(Payment.Amount) AS TotalAmountReceived
FROM Payment
INNER JOIN Location ON Payment.LocationID = Location.LocationID
GROUP BY Location.LocationID, Location.LocationName;
SELECT SenderName, COUNT(*) AS TotalCouriers
FROM Courier
GROUP BY SenderName;
SELECT Role, GROUP_CONCAT(Name) AS Employees
FROM Employee
GROUP BY Role;
SELECT Courier.SenderAddress, SUM(Payment.Amount) AS TotalPayments
FROM Payment
INNER JOIN Courier ON Payment.CourierID = Courier.CourierID
GROUP BY Courier.SenderAddress;
SELECT SenderAddress, COUNT(*) AS TotalCouriers
FROM Courier
GROUP BY SenderAddress;
SELECT Employee.EmployeeID, Employee.Name, COUNT(Courier.CourierID) AS DeliveredCouriers
FROM Employee
LEFT JOIN Courier ON Employee.EmployeeID = Courier.EmployeeID
WHERE Courier.Status = 'Delivered'  
GROUP BY Employee.EmployeeID, Employee.Name;
SELECT Payment.*, CourierServices.*
FROM Payment
INNER JOIN CourierServices ON Payment.CourierID = CourierServices.ServiceID
WHERE Payment.Amount > CourierServices.Cost;
SELECT * FROM Courier 
WHERE Weight > (SELECT AVG(Weight) FROM Courier);
SELECT Name, Salary 
FROM Employee 
WHERE Salary > (SELECT AVG(Salary) FROM Employee); 
SELECT SUM(Cost) AS TotalCost 
FROM CourierServices 
WHERE Cost < (SELECT MAX(Cost) FROM CourierServices);
SELECT * 
FROM Courier 
WHERE CourierID IN (SELECT DISTINCT CourierID FROM Payment);
SELECT LocationID, LocationName, Address 
FROM Location 
WHERE LocationID IN (
    SELECT LocationID 
    FROM Payment 
    WHERE Amount = (SELECT MAX(Amount) FROM Payment)
);
SELECT * 
FROM Courier 
WHERE Weight > ALL (
    SELECT Weight 
    FROM Courier 
    WHERE SenderName = 'shantanu Agarkar'
);














