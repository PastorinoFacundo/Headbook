# Headbook

Headbook es una aplicacion web.

La carpeta "Headbook" contiene el projecto de la app, mientras que dentro de la carpeta "Headbook_Conf" se encuentran las variables de configuracion de la misma para la conexion a la base de datos y el id del usuario con el que se pretende ejecutar la app.

Los path disponibles actualmente son "/Headbook/home" y "/Headbook/post/new"

El archivo "Headbook-dataBase.sql" contiene el script necesario para la creacion de la base de datos, las tablas y algunos inserts para popularlas.

server runtime environment: apache tomcat 8.5
Es necesario configurar dentro de catalina.properties una variable "headbook.headbook.root.path" con la ruta de la carpeta "Headbook_Conf". Ej: headbook.headbook.root.path=/D:/git/Headbook/Headbook_Conf