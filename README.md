# rickandmortyapiConsumer
consumer services of rick and morty

## Instalacion

Descomprimir el .Zip ingresar a la carpeta Target 

Ejecutar JAR

```bash
java -jar code_challenge-0.0.1-SNAPSHOT
```

## Consumo servicios 

Request

```json
Method = GET
Url = localhost:8081/api/planets
Content-Type = application/json

```

Response 


```json
Method = GET
Body = 
[
    {
        "Earth (C-137)": [
            {
                "name": "Beth Smith",
                "status": "Alive",
                "gender": "Female",
                "episodesCount": 7
            },
            {
                "name": "Bill",
                "status": "Alive",
                "gender": "Male",
                "episodesCount": 1
            }
        ]
    }
]

```





