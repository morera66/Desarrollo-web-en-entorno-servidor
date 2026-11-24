# U4P3 - Actividades del centro cultural de Sevilla

Aplicación web con Spring Boot para ver y añadir las actividades de un centro cultural municipal de Sevilla (talleres, exposiciones, actividades para familias...). Las actividades se guardan en MariaDB, así que aunque se cierre la aplicación siguen ahí al volver a abrirla.

En la página principal sale el listado de todas las actividades y, debajo, un formulario para añadir una nueva.

## Dominio y atributos

La entidad principal es Actividad. Cada actividad es una fila de la tabla actividades.

- id (Long): identificador de la actividad, lo genera MariaDB solo.
- titulo (String): nombre de la actividad. Obligatorio, hasta 80 caracteres.
- descripcion (String): explicación de en qué consiste. Opcional, hasta 300 caracteres.
- fecha (LocalDate): día en que se hace. Obligatoria.
- duracionMinutos (Integer): cuánto dura. Obligatorio, entre 15 y 480 minutos.
- precio (BigDecimal): lo que cuesta, 0 si es gratuita. Obligatorio, entre 0 y 999,99.
- aforo (Integer): cuántas personas caben. Obligatorio, entre 1 y 200.
- inscripcionAbierta (Boolean): si todavía se puede apuntar la gente. Obligatorio.

El precio es BigDecimal y no double porque con double el dinero puede tener errores de redondeo.

## Base de datos

La base de datos se llama centro_cultural. MariaDB lo tengo en Docker (contenedor bbdd) y en mi ordenador escucha en el puerto 3336.

La base de datos hay que crearla vacía antes de arrancar la aplicación. Yo la creé desde HeidiSQL con:

    CREATE DATABASE centro_cultural CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

La tabla no hace falta crearla, la crea Hibernate sola a partir de la entidad porque en application.properties está puesto spring.jpa.hibernate.ddl-auto=update. Uso update y no create ni create-drop porque esos borrarían los datos cada vez que se reinicia.

La conexión está en src/main/resources/application.properties:

    spring.datasource.url=${DB_URL:jdbc:mariadb://localhost:3336/centro_cultural}
    spring.datasource.username=${DB_USERNAME:root}
    spring.datasource.password=${DB_PASSWORD:}

La contraseña no está escrita en el código. Se pasa con la variable de entorno DB_PASSWORD, así no se sube a Git. Si el puerto, la base o el usuario son otros, se pueden cambiar con DB_URL y DB_USERNAME.

En IntelliJ se pone en Run > Edit Configurations > Modify options > Environment variables, escribiendo DB_PASSWORD=tu_contraseña.

## Cómo iniciar la aplicación

1. Encender MariaDB. En mi caso, abrir Docker Desktop y darle a Start al contenedor bbdd, porque no arranca solo.
2. Comprobar que existe la base centro_cultural.
3. Ejecutar U4P3Application desde IntelliJ.
4. Abrir http://localhost:8080 en el navegador.

Hace falta Java 23 y MariaDB encendido. Si MariaDB está apagado la aplicación no arranca y da un error de conexión.

## Organización por capas

El código está separado igual que en el proyecto P3 de referencia, un paquete por capa:

- modelo (Actividad): la entidad. Dice cómo es la tabla y sus columnas.
- repositorio (ActividadRepositorio): el acceso a la base de datos. Hereda de JpaRepository, así que ya tiene findAll y save sin escribir SQL.
- servicio (ActividadServicio): los casos de uso, que son listar todas las actividades y registrar una nueva. Es el único que usa el repositorio.
- dto (ActividadFormulario): los datos que puede mandar el formulario con sus validaciones. No tiene id, así desde el navegador no se puede elegir ni pisar la clave primaria.
- controlador (ActividadControlador): recibe las peticiones. GET / muestra el listado y el formulario, y POST /actividades valida el formulario y, si está bien, le pide al servicio que lo guarde. Si hay errores vuelve a mostrar la página con lo que se había escrito.
- templates (actividades.html): la vista con Thymeleaf. Solo enseña los datos que le pasa el controlador.

El recorrido de una petición es: navegador, controlador, servicio, repositorio y MariaDB, y la respuesta vuelve hasta la vista.

## Por qué se separa la presentación de la lógica

Cada parte se encarga de una sola cosa. La vista solo se ocupa de cómo se ve, el controlador de la parte web, el servicio de lo que hace la aplicación y el repositorio de hablar con la base de datos.

Así, si quiero cambiar el diseño de la página no tengo que tocar nada de la base de datos, y si cambiara de base de datos no tendría que tocar la vista. También es más fácil encontrar dónde está un fallo y probar cada parte por separado. Por eso el controlador no usa el repositorio directamente, siempre pasa por el servicio.

Spring MVC recibe las peticiones y llama al controlador. El servicio tiene la lógica: por ejemplo, al registrar construye la entidad, quita los espacios del título y si la descripción viene vacía la guarda como null, y las operaciones van dentro de una transacción con @Transactional. Thymeleaf genera el HTML en el servidor con los datos del modelo: el listado con th:each, el formulario con th:object y th:field y los errores con th:errors.

## Tecnologías de acceso a datos

- MariaDB: la base de datos donde se guardan las actividades.
- MariaDB Driver (JDBC): lo que usa Java para conectarse a MariaDB.
- HikariCP: el pool de conexiones que trae Spring Boot, mantiene las conexiones abiertas para reutilizarlas.
- JPA: la forma estándar de Java de relacionar clases con tablas (@Entity, @Id, @Column...).
- Hibernate: la implementación de JPA. Convierte la entidad en tabla y los objetos en INSERT y SELECT.
- Spring Data JPA: crea solo la implementación del repositorio a partir de la interfaz.

Con spring.jpa.show-sql=true se puede ver en la consola el SQL que genera Hibernate.

## Patrón de diseño aplicado

El patrón principal es el patrón Repositorio. Se ve en ActividadRepositorio: el resto de la aplicación pide o guarda actividades a través de él sin saber cómo se hace por dentro ni escribir SQL. Si cambiara la forma de guardar los datos, solo cambiaría esa parte.

También se usa la inyección de dependencias por constructor. En ActividadServicio y en ActividadControlador no se hace new de lo que necesitan, Spring les pasa el repositorio y el servicio ya creados en el constructor. Así cada clase deja claro qué necesita y no depende de cómo se crean las otras.

Y en el controlador se usa POST/Redirect/GET: después de guardar se hace redirect:/ en vez de devolver la página, así si se recarga con F5 no se vuelve a enviar el formulario ni se guarda la actividad dos veces.

## Comprobaciones realizadas

- Al abrir http://localhost:8080 sale el listado y el formulario.
- Al enviar el formulario vacío salen los errores de los campos obligatorios.
- Con datos fuera de rango (duración de 5 minutos, aforo de 500) salen los errores y lo que había escrito se mantiene.
- Con datos correctos la actividad se guarda y aparece en el listado.
- Al recargar con F5 después de guardar no se duplica.
- La actividad sin descripción no muestra el párrafo vacío, y la que cuesta 0 sale como "Gratis".
- He parado la aplicación, la he vuelto a arrancar y las actividades siguen en el listado.
- En HeidiSQL, en la tabla actividades, se ven las filas guardadas.