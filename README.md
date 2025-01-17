//Create a User

```curl --location 'localhost:8080/api/user/add-user' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 3,
    "name": "John Doe",
    "email": "john.doe3@example.com",
    "password": "12345",
    "userType": "EMPLOYEE",
    "subscribedSince": "2025-01-17T00:00:00.000Z"
}'


//calculate the billing amount after discount by passing the billing details as below

curl --location 'localhost:8080/api/calculate' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic am9obi5kb2UzQGV4YW1wbGUuY29tOjEyMzQ1' \
--data-raw '{
  "items": [
    {
      "name": "Apple",
      "category": "GROCERIES",
      "price": 1.5
    },
    {
      "name": "Laptop",
      "category": "ELECTRONICS",
      "price": 1200.0
    }
  ],
  "userEmail": "john.doe3@example.com",
  "originalCurrency": "INR",
  "targetCurrency": "USD"
}'
