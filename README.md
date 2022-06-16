# About

A quick & simple Apache Camel example for decoupling logic between Rest controller and Service layer. 

# Demo levels

* At `/api/msg1` endpoint, we directly use `service` to fulfill request 
* At `/api/msg2` endpoint, we use Camel with `direct` Component for logic routing
* At `/api/msg3` endpoint, we hide Camel's details with `@Produce` & `@Consume` annotation
* At `/api/msg4` endpoint, we demo a chain of Camel routes

All the routing logic is inside `DemoRouteConfig` class.

# Test

Start the application, call rest APIs to see result:
* http://localhost:9999/api/msg1?name=Joe&age=1001111
* http://localhost:9999/api/msg2?name=Joe&age=1001111
* http://localhost:9999/api/msg3?name=Joe&age=1001111
* http://localhost:9999/api/msg4?name=Joe&age=1001111

# References
- https://tomd.xyz/camel-tutorial/
- https://stackoverflow.com/a/9636879
