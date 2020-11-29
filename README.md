# spring-boot-credit-status-service

# Description

Here is the microservice where we are calling the other microservice to validate credit status by getting credit score. 

Client can hit the endpoint to make a new credit request with credentials. (/api/creditStatus)

Saved request into db and registered credit limit values based on the rules.

In the rules needed to spesified special condition for 500 limit. It was the missing one needed to be spesific. I assumed as a rejection case 
so 500 and lower credit scores are getting rejection.

Created unit test based on limit values.

Used Vonaged API service to send sms after saving record to the db. But the service is only allows the some spesific numbers for the system on Free Tier.
