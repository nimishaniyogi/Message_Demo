# Execution
- Run mvn install,
also if required
- clean install

- Execute the project as spring boot i.e. run the `MessageDemoApplciation` class or as `Spring Boot` APP


## APIs

- To post the message

sample example for the post message resource:

URI: `POST` => `localhost:8081/api/sendMessage`

Body: `{ "message": "Hello World"}`

Expected response : `200 OK` and `Published` in the body

- To Read the message in queue

URI: `GET` => `localhost:8081/api/getMessage`

Expected response: `200 OK` and `{ "message": "Hello World"` as a get result in the body based on the message availability
i.e. message can expire randomly between 10sec to 1 min based on the random seconds value generated in the class logic

### Note:
Due to time constraint I am not able to implement complete messages as a list
- My idea is to implement a message entity containing 

>> Create a message entity class i.e. a message object that contains 
>> `MessageId`, `TimeStamp` i.e. expiry timestamp calculated with current timestamp and expiry timestamp generated in the logic
>> and finally a `MessageContent` which contains our actual message

- Accordingly I want to take the list of message objects as post body inputs as defined above and pass the list through a loop and generate random expiry for each message and insert into the queue
- My `QosSettings -> SetTimeToLive(RandomTime)` will take care of the expiry time for each message
- Also calculate the expiry time of the message based on this `random expiry time in seconds between 10sec and 1min` + `current time stamp` = `TimeStamp` of message object i.e. `ExpiryTime` of the message Object from the queue 
while actually building the message object 

i.e. 

`getter and setter` for the message object that has
and accordingly build message object with the `setters`
also if needed we can use `getters` for additional functionality or to clearly
view each part of the message while we get the response in the `GET`
 


