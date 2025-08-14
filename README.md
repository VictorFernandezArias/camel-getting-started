# camel-getting-started

Ejemplo sencillo con Apache Camel que consulta la [PokeAPI](https://pokeapi.co/) y guarda la respuesta en un archivo.

## Ejecutar localmente

1. Compila el proyecto:
   ```bash
   mvn package
   ```
2. Ejecuta la aplicación:
   ```bash
   java -jar target/camel-getting-started-1.0-SNAPSHOT.jar
   ```
   Se ejecutara el springboot con la ruta camel

3. Explota el servicio:
   ```bash
   curl -X POST http://localhost:8080/users -H "Content-Type: application/json" -d '{"name":"Victor","age":32}'
   ```
   Se ...

## Ejecutar con Podman

1. Construye la imagen:
   ```bash
   podman build -t camel-user-app .
   ```
2. Ejecuta el contenedor (montando un volumen para recuperar el archivo de salida):
   ```bash
   podman run --rm localhost/camel-user-app -p 8080:8080