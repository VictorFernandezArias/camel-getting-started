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
   Se generará un archivo `output/pokemon.json` con la información del Pokémon.

## Ejecutar con Podman

1. Construye la imagen:
   ```bash
   podman build -t camel-poke .
   ```
2. Ejecuta el contenedor (montando un volumen para recuperar el archivo de salida):
   ```bash
   podman run --rm -v $(pwd)/output:/app/output camel-poke
   ```
   El archivo `output/pokemon.json` quedará disponible en tu máquina.
