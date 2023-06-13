# PalmBooking

PalmBooking es un sistema de reservas de hoteles, que permite a los usuarios buscar y reservar habitaciones. Este proyecto se ha desarrollado utilizando tecnología Back-End como: Spring Boot, MySQL (Local), PostgreSQL (Producción), JPA, Web, Security. Y lenguaje de programacion: Java.

## Instalación

Para instalar y ejecutar PalmBooking en tu equipo local, sigue los siguientes pasos:

1. Clona o Descarga el repositorio de GitHub en tu equipo local.
2. Las dependencias ya estaran incorporadas en el `` .pom ``
3. Crea un archivo .env.local con las variables de entorno necesarias $SQL_URL, $SQL_USER, $SQL_PASSWORD y agrega los datos necesarios en tu equipo local.
4. Ejecuta la aplicación con el IDE que estes usando. De lo contrario, levantar con Docker(Proximamente) o ejecutando desde la terminal ubicado en `` /PalmBooking/Back-End/palmbooking `` ->`` mvn package `` -> `` java -jar target/palmbooking-0.0.1-SNAPSHOT.jar. ``

## Licencia

Este proyecto se distribuye bajo la licencia MIT.

## Estado del proyecto

El proyecto está en fase de desarrollo.

## Autores

- Victor José Rangel: Desarrollador Back-End ([@VictorRoe](https://github.com/VictorRoe))

## Documentación adicional

* Esquema de la base de datos PalmBooking [Link aqui](https://drive.google.com/file/d/1PHd5_5hHSNCF50Od9svrL5GkL_6banWl/view?usp=sharing)
* Para obtener más información sobre cómo utilizar las APIs en el proyecto PalmBooking, consulta la documentación en línea con el endpoint con la app inicializada ``` /doc/swagger-ui/index.html#/ ``` 
<p align="center">
   <img src="./logo.png" alt="logo" with=40px height=100x>
</p>
