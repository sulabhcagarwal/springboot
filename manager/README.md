# Shopping Manager

Shopping manager service manages cart.  
Overview:
* **Item Service**: is used to create/update/delete Items in the system
* **User Service**: is used to create/update/delete users in the system
* **Order Service**: to create order and add/update/delete items into the cart

## Prerequisite
* java 21+
* maven 3+

## Build

Use the package manager [maven](https://maven.apache.org/install.html) to build the project.

```bash
cd ~/manager
mvn clean install
```

## Run
Run the Order service

```bash
java -jar ~/manager/Order/target/Order-0.0.1-SNAPSHOT.jar
```

## Usage
Open [Order Service Swagger](http://localhost:9000/swagger-ui/index.html) on browser  
Service contain 4 URLs for creating/updating/deleting/query the cart items.