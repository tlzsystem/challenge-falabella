# Challenge Falabella

## How run

The project requires Maven to build.

```sh
mvn clean package
docker build --tag=challenge-server:latest .
docker run -p8080:8080 challenge-server
```

Then, you can navigate to http://localhost:8080/swagger-ui/index.html

## Arquitecture

This app is a spring boot basees application. It use MVVC pattern, Dependence Injection Pattern from Spring, DAO.
This app include the HATEOAS principes, and provide a Paginated Endpoint.
This app is builded with H2 database. In a real context, i prefer use PostgreSQL

## EndPoints

### GET BY SKU

Get a product by sku

```sh
localhost:8080/api/v1/products/{sku}}
```
### GET ALL

Get a list of products

```sh
localhost:8080/api/v1/products/
```

### GET ALL PAGINATED

Get a paginated list of products

```sh
localhost:8080/api/v1/products/list?page=0&size=5&sort=name,desc
```

### POST

Create a new product

```sh
localhost:8080/api/v1/products/list
```
```sh
{
    "sku": "FAL-10000009",
    "name": "Bicicleta Baltoro Aro 29",
    "brand": "JEEP",
    "size": "ST",
    "price": 100.000,
    "principalImage": "https://falabella.scene7.com/is/image/Falabella/881952283_77",
    "otherImages":[
        "https://falabella.scene7.com/is/image/Falabella/881952283_77",
        "https://falabella.scene7.com/is/image/Falabella/881952283_77",
        "https://falabella.scene7.com/is/image/Falabella/881952283_77"
    ]
}
```

### PUT

Edit or create a new product

```sh
localhost:8080/api/v1/products/list
```
```sh
{
    "sku": "FAL-10000009",
    "name": "Bicicleta Baltoro Aro 29",
    "brand": "JEEP",
    "size": "ST",
    "price": 100.000,
    "principalImage": "https://falabella.scene7.com/is/image/Falabella/881952283_77",
    "otherImages":[
        "https://falabella.scene7.com/is/image/Falabella/881952283_77",
        "https://falabella.scene7.com/is/image/Falabella/881952283_77",
        "https://falabella.scene7.com/is/image/Falabella/881952283_77"
    ]
}
```

### DELTE

Delete a product by sku

```sh
localhost:8080/api/v1/products/{sku}}

```

