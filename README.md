Problem Statement

I own a multi-storey parking lot that can hold up to ‘n’ cars at any given point in time.Each slot is given a number starting at 1 increasing with increasing distance from the entry point in steps of one. I want to create an automated ticketing system that allows my customers to use my parking lot without human intervention.

When a car enters my parking lot, I want to have a ticket issued to the driver. The ticket issuing process includes us documenting the registration number (number plate) and the colour of the car and allocating an available parking slot to the car before actually handing over a ticket to the driver (we assume that our customers are nice enough to always park in the slots allocated to them). The customer should be allocated a parking slot which is nearest to the entry. At the exit the customer returns the ticket which then marks the slot they were using as being available.

Due to government regulation, the system should provide me with the ability to find out:

    Registration numbers of all cars of a particular colour.
    Slot number in which a car with a given registration number is parked.
    Slot numbers of all slots where a car of a particular colour is parked.

We interact with the system via a simple set of APIs which produce a specific output.
There are two types of users:

    The customers who want to park their cars
    The admin of the parking lot who can do the above three searches.

---------------------------------------------------------------------------
Back-end:

Framework: Springboot
DB: MySQL
--------------------------------------------------------------------------
APIs Description:

Get Parking availability

    URI: /api/parking
    Method: GET
    Response:

{
	"available": true //If parking slot available
	"slot": 2,
	"level": 3
}

Reserve Parking lot

    URI: /api/parking
    Method: POST
    Request Body:

{
	"registration": "KA-03-ZA-1111",
	"colour": "red",
	"slot": 2,
	"level": 3
}

    Response:

{
	"status": true
}

Free Parking lot

    URI: /api/parking
    Method: DELETE
    Request Body:

{
	"registration": "KA-03-ZA-1111"
}

    Response:

{
	"status": true
}

Search Parking lot
    
    1-Registration numbers of all cars of a particular colour.
    URI: /api/parking/_search{registrationNumber}

    2-Slot number in which a car with a given registration number is parked.
    URI: /api/parking/_search/getRegistration/{color}
    
    3-Slot numbers of all slots where a car of a particular colour is parked
    URI: /api/parking/_search/getSlot/{color}



********************************************************************************
