# Restaurant Booking API

This is a REST service for managing restaurant bookings. Its built using Java, Mu Server and H2 in-memory database.
The API allows to query bookings for a specific day and insert new bookings.

ENDPOINTS

Query Bookings
- URL: /bookings
- Method: GET
- Query Parameters:
		bookingDate = YYYY-MM-DD (Required)
- Example: 
		GET /bookings?bookingDate=2024-08-26		
		
Create Booking 
- URL: /booking
- Method: POST
- Query Parameters:
		JSON Object with booking Details (all Required)
- Example: 
		POST /booking
		
{
  "customerName": "Jane Doe",
  "bookingInitDate": "2024-08-26T15:30:00",
  "tableSize": 5
}		