CREATE TABLE IF NOT EXISTS Booking (

	id IDENTITY PRIMARY KEY,
	customerName	VARCHAR(200) not null,
	customerLastName	VARCHAR(200),
	tableSize		INT not null,
	bookingInitDate		TIMESTAMP not null,
	bookingEndDate		TIMESTAMP not null);
	
INSERT INTO Booking (customerName, customerLastName, tableSize, bookingInitDate, bookingEndDate) VALUES 
('Elliot', 'Elliot', 3, '2024-08-20 13:30:00','2024-08-20 15:30:00'),
('John', 'Elliot',2, '2024-08-20 13:45:00', '2024-08-20 15:45:00'),
('Jane', 'Elliot', 2, '2024-08-20 15:35:00', '2024-08-20 17:35:00'),
('Julian', 'Elliot', 4, '2024-08-23 17:00:00', '2024-08-23 19:00:00'),
('Samuel', 'Elliot', 8, '2024-08-23 19:30:00', '2024-08-23 21:30:00'),
('Natalie', 'Elliot', 5, '2024-08-28 16:45:00', '2024-08-28 18:45:00'),
('Kevin', 'Elliot', 4, '2024-08-31 18:15:00', '2024-08-31 20:15:00');

