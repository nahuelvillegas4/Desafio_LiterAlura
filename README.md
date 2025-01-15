Este proyecto es una aplicación en Java que permite interactuar con una base de datos de libros, autores e idiomas, proporcionando diferentes funcionalidades para realizar consultas, almacenar datos y analizar información literaria.

## Tecnologías utilizadas

- **Java**: Lenguaje principal del proyecto.
- **Spring Data JPA**: Para la gestión de repositorios y consultas a la base de datos.
- **Hibernate**: Como implementación de JPA.
- **PostgreSQL**: Base de datos utilizada.
- **API externa**: Para obtener información de libros mediante peticiones HTTP.

## Características principales

La aplicación cuenta con las siguientes funcionalidades, accesibles mediante un menú interactivo:

1. **Buscar libro por título**:
   - Permite realizar una búsqueda en una API externa y almacenar la información del libro encontrado en la base de datos.

2. **Mostrar libros consultados**:
   - Recupera y muestra todos los libros previamente almacenados en la base de datos.

3. **Mostrar autores de los libros consultados**:
   - Lista los autores relacionados con los libros almacenados en la base de datos.

4. **Mostrar autores vivos en un año determinado**:
   - Permite consultar los autores que estaban vivos durante un año específico.

5. **Mostrar cantidad de libros por idioma**:
   - Genera un reporte que indica la cantidad de libros almacenados agrupados por idioma.

6. **Salir**:
   - Finaliza la aplicación.

## Cómo ejecutar el proyecto

1. **Configuración previa**:
   - Asegúrate de tener Java y PostgreSQL instalados.
   - Configura las variables de entorno necesarias:
     - `DB_HOST`: Dirección del servidor de la base de datos.
     - `DB_USER`: Usuario de la base de datos.
     - `DB_PASSWORD`: Contraseña del usuario de la base de datos.

2. **Configuración de la base de datos**:
   - Crea la base de datos PostgreSQL con el nombre especificado en el archivo `application.properties` (por defecto `alura_libros`).
   - Asegúrate de que la tabla y las relaciones sean consistentes con las entidades definidas en el proyecto.

3. **Ejecución**:
   - Compila y ejecuta el proyecto desde tu IDE o desde la línea de comandos usando Maven o Gradle.
   - El programa iniciará en modo interactivo y mostrará el menú principal.

## Estructura del proyecto

- **`Principal`**:
  Clase principal que contiene la lógica del menú y las interacciones con el usuario.
- **Repositorios**:
  - `LibroRepository`: Maneja las operaciones relacionadas con la entidad `Libro`.
  - `AutorRepository`: Maneja las operaciones relacionadas con la entidad `Autor`.
  - `IdiomaRepository`: Maneja las operaciones relacionadas con la entidad `Idioma`.
- **Servicios**:
  - `LibroService`: Contiene la lógica para procesar y almacenar libros.
- **API externa**:
  - Se utiliza para obtener información de libros mediante una URL base configurable.

## Ejemplo de uso

Un usuario puede buscar un libro introduciendo su título. La aplicación consultará una API externa, almacenará el libro encontrado en la base de datos y mostrará sus detalles junto con la lista de autores. Además, puede consultar la cantidad de libros por idioma y los autores vivos en un periodo determinado.

## Contribución
Si deseas contribuir a este proyecto:
1. Realiza un fork del repositorio.
2. Crea una rama para tu función o corrección: `git checkout -b nueva-funcion`.
3. Envía tus cambios mediante un pull request.

## Licencia
Este proyecto está bajo una licencia de código abierto. Puedes utilizarlo y modificarlo según tus necesidades.
