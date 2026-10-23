Entrega P3-P4 - Préstamo de material del aula maker

Aplicación con Spring Boot y Thymeleaf para ver el material del aula maker, abrir la ficha de cada recurso y mandar una solicitud de préstamo. El catálogo está en un array y las solicitudes no se guardan, solo se muestra el resumen.

Requisitos
Java 21
Maven
Dependencias: Spring Web, Thymeleaf y Validation
Cómo ejecutarlo

Desde la carpeta de src/main/jaca/com/example/entregap3p4:

Click derecho en EntregaP3P4Application.java y darle a run java

Despues abre http://localhost:8080 en el navegador.

Rutas
GET / muestra el catálogo con los materiales y un enlace a la ficha de cada uno.
GET /materiales/{codigo} muestra la ficha del material.
GET /solicitud/nueva muestra el formulario de préstamo.
POST /solicitudes recibe el formulario.

Ámbito de las variables

Propiedades del DTO: nombre, correo, material, unidades, fechaRecogida, fechaDevolucion, motivo y aceptaNormas.
Parámetros de los métodos: por ejemplo codigo, turno, solicitud, resultadoBinding y model. Solo existen dentro del método que los recibe.
Variables locales: material en la ficha y dias, diasUnidad y nombreMaterial al enviar la solicitud. Se crean dentro del método y desaparecen cuando termina.
MATERIALES es una constante de la clase (static final), la usan todos los métodos del controlador.
Lo que se mete en el modelo con model.addAttribute() se usa en la plantilla con ${}, por ejemplo el array materiales se recorre con th:each en el catálogo. El DTO llega a la vista como solicitud por el @ModelAttribute("solicitud"), por eso en el formulario se usa th:object="${solicitud}".

Comprobaciones
Estas son las pruebas que he hecho:

En / salen los tres materiales y los enlaces llevan a su ficha.
/materiales/MICRO?turno=tarde muestra el kit de microcontrolador con el turno tarde.
/materiales/x da un 404 con la página error/404.html.
Con un correo mal puesto, 0 unidades o un motivo corto salen los errores y el resto de datos se mantienen.
Cambiando el input de unidades a texto con F12 y escribiendo letras sale el mensaje de error de conversión y no se muestra el resumen.
Con la fecha de devolución anterior a la de recogida sale el error en la fecha de devolución.
Recogida y devolución el mismo día con 2 unidades: 1 día, 2 días-unidad y el mensaje de préstamo de un día.
Recogida el 22 y devolución el 25 con 3 unidades: 4 días, 12 días-unidad y el mensaje de varios días.
Escribiendo <b>hola</b> en el nombre se ve el texto tal cual en el resumen, no en negrita, porque se usa th:text.
Las plantillas error/4xx.html y error/5xx.html existen para el resto de errores.