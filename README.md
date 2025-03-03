# client-service
Microservicio 1 que corresponde a Persona y Cliente

URL de GitHub:
https://github.com/nicodema/client-service

Se utilizo como base de datos H2, no tiene script ya que se creo la estructura desde la aplicacion y se ingreso Clientes de prueba

Para probar los servicios en POSTMAN:

- Obtener Cliente por Id persona:
GET - http://localhost:8081/api/clientes/1

- Consultar todos los clientes:
GET - http://localhost:8081/api/clientes

- Insertar un Cliente
POST - http://localhost:8081/api/clientes
JSON: 
{
    "nombre": "Juan Osorio",
    "genero": "Masculino",
    "edad": 29,
    "identificacion": "1005667",
    "direccion": "12 de junio",
    "telefono": "098254785",
    "contrasena": "1245",
    "estado": true
}

- Actualizar Cliente
PUT - http://localhost:8081/api/clientes/3
Json
{
    "nombre": "Juan Osorio",
    "genero": "Masculino",
    "edad": 29,
    "identificacion": "1005667",
    "direccion": "18 de junio",
    "telefono": "098254785",
    "contrasena": "1245",
    "estado": true
}

- Eliminar Cliente
PUT - http://localhost:8081/api/clientes/3



