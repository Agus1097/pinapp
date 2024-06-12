# PinAPP - Challenge

Esta es una aplicación que permite crear un cliente, obtener su KPI y listar todos los clientes agregando su fecha probable de muerte.

## Endpoints

### Crear Cliente

**Endpoint:** `http://18.119.113.226/crearcliente`

**Método:** `POST`

**Descripción:** Este endpoint permite crear un nuevo cliente.

**Request:**
```json
{
  "nombre": "Nombre del Cliente",
  "apellido": "Apellido del Cliente",
  "fecha_nacimiento": "1990-01-01"
}
```

**Response:**
```json
{
  "nombre": "Nombre del Cliente",
  "apellido": "Apellido del Cliente",
  "edad": 34,
  "fecha_nacimiento": "1990-01-01"
}
```

### Obtener KPI de Clientes

**Endpoint:** `http://18.119.113.226/kpideclientes`

**Método:** `GET`

**Descripción:** Este endpoint permite obtener la edad promedio y la desviación estandar poblacional.

**Request:**

**Response:**
```json
{
  "edad_promedio": 10,
  "desviacion_estadar": 0.99
}
```

### Listar Clientes con su fecha probable de muerte

**Endpoint:** `http://18.119.113.226/listclientes`

**Método:** `GET`

**Descripción:** Este endpoint permite obtener todos los cliente agregando su fecha probable de muerte.

**Request:**

**Response:**
```json
[
    {
        "cliente": {
            "nombre": "Nombre del Cliente",
            "apellido": "Apellido del Cliente",
            "edad": 34,
            "fecha_nacimiento": "1990-01-01"
        },
        "fecha_probable_de_muerte": "2070-01-01"
    }
]
```
