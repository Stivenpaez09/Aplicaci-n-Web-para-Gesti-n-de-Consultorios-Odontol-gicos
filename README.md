Aplicación Web para Gestión de Consultorios Odontológicos

Este proyecto es una aplicación web diseñada para la gestión integral de un consultorio odontológico. Fue desarrollada utilizando Java 15 (JDK 15.0.2) y sigue un enfoque orientado a objetos combinado con las mejores prácticas en persistencia de datos y arquitectura web.

Características principales
  Gestión CRUD para:
  - Usuarios del sistema.
  - Odontólogos y sus especialidades.
  - Pacientes, incluyendo el registro de sus datos personales y asignación de turnos.
  Asignación de citas (turnos) con horarios definidos previamente en la base de datos.
  Implementación de persistencia utilizando EclipseLink como proveedor JPA, lo que permite la interacción eficiente con bases de datos relacionales (MySQL).
  Uso de Servlets Java para manejar las operaciones HTTP (GET, POST), garantizando la comunicación efectiva entre los formularios web y las bases de datos.
  Modelo de datos altamente normalizado, con relaciones bien definidas para entidades clave como Paciente, Odontólogo, Turno, Responsable, entre otros (ver diagrama de clases adjunto).

Tecnologías y herramientas utilizadas
  Java 15 (JDK 15.0.2)
  Maven como herramienta de gestión de dependencias y construcción del proyecto.
  EclipseLink como implementación JPA para operaciones CRUD.
  MySQL como sistema de gestión de bases de datos relacional.
  Servlets Java para manejar la lógica del lado del servidor.
  Librerías utilizadas (definidas en pom.xml):
  - mysql-connector-java (v8.0.30): Conexión con la base de datos MySQL.
  - org.eclipse.persistence (v2.7.12 y 9.4.0): Componentes JPA y MOXy para persistencia y modelado de datos.
  - javax.javaee-web-api (v7.0): Proporciona soporte para tecnologías Java EE, incluyendo Servlets y JSP.
  - Otros componentes de EclipseLink, como ASM, Antlr, y MOXy, para extender las capacidades de JPA.

Modelo de datos
  El modelo de datos del proyecto se centra en una jerarquía bien estructurada, con la entidad principal Persona que se extiende hacia roles específicos como Paciente, Odontólogo, Responsable y Secretario. Además, se incluyen entidades auxiliares como Turno y Horario para gestionar las citas. Este diseño facilita la escalabilidad y el mantenimiento del sistema.

Funcionalidades implementadas
  Registro de Usuarios: Permite agregar, actualizar, eliminar y listar usuarios del sistema.
  Gestión de Odontólogos: Administra la información de los odontólogos y sus especialidades.
  Gestión de Pacientes: Maneja la información personal de los pacientes, incluyendo datos médicos como tipo de sangre y cobertura de obra social.
  Asignación de Turnos: Sistema robusto para asignar horarios específicos a pacientes con un odontólogo determinado.
  Seguridad y roles: Manejo de roles básicos en el sistema, definidos en la entidad Usuario.
  
Detalles técnicos
  Persistencia: Uso extensivo de JPA para mapear las clases Java al esquema de la base de datos relacional. Las operaciones CRUD están optimizadas para garantizar la integridad y consistencia de los datos.
  Arquitectura: La aplicación sigue un patrón MVC (Modelo-Vista-Controlador), donde los Servlets funcionan como controladores para procesar las solicitudes y enviar las respuestas a las vistas JSP.
  Base de datos:
  - La base de datos está diseñada en MySQL, con relaciones uno a uno y uno a muchos.
  - Se incluyen restricciones y claves foráneas para garantizar la integridad referencial.
  - Captura del modelo de datos

Cómo ejecutar
  Clonar el repositorio: git clone https://github.com/Stivenpaez09/Aplicaci-n-Web-para-Gesti-n-de-Consultorios-Odontol-gicos
  Importar el proyecto en tu IDE favorito (Netbeans o IntelliJ IDEA).
  Configurar la base de datos MySQL y actualizar el archivo persistence.xml con tus credenciales.
  Ejecutar el servidor y acceder a la aplicación desde el navegador.
