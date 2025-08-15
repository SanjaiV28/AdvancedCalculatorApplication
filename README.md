# Advanced Calculator (Spring Boot)

Features
- Simple ops: add, subtract, multiply, divide, pow, mod
- Scientific ops: sqrt, abs, sin, cos, tan, asin, acos, atan, exp, ln, log10, deg2rad, rad2deg
- Expression evaluation via exp4j with variables
- REST API and simple web UI
- OpenAPI at /swagger-ui.html

Run
- Windows PowerShell:
```
./mvnw.cmd spring-boot:run
```
- Or build jar:
```
./mvnw.cmd -DskipTests package
java -jar target/advanced-calculator-0.0.1-SNAPSHOT.jar
```

API Examples
- POST /api/binary
```
{"op":"add","x":1,"y":2}
```
- POST /api/unary
```
{"op":"sqrt","x":9}
```
- POST /api/expr
```
{"expression":"sin(pi/2) + a^2","variables":{"a":3}}
``` 