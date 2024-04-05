# Este es el proyecto de BASE DE DATOS 2
> En este README añadiremos las tareas por hacer y las tareas realizadas.
> esto con el fin de llevar un control de las tareas realizadas y pendientes.


## Tareas por hacer
Sientete libre de añadir tareas por hacer en esta sección si consideras que hacen falta o si algo debe ser modificado.

- [ ] Aumentar los nombres de proveedores hasta los que sean necesarios
- [ ] Aumentar los nombres de farmacias hasta los que sean necesarios
> Recuerda que los generadores de tablas con referencias a otras deberan usar los registros generados por los generadores de las tablas referenciadas.
Ejemplo: Si se quiere crear la tabla Historial_Empleado se deberan crear primero los registros de la tabla Empleado y con esos registros generar los registros de la tabla Historial_Empleado.
- [ ] Crear generador de registros para la tabla Empleado
- [ ] Crear generador de registros para la tabla Factura
- [ ] Crear generador de registros para la tabla Puesto_Empleo
- [ ] Crear generador de registros para la tabla Historial_Empleado
- [ ] Crear generador de registros para la tabla Ticket
- [ ] Crear generador de registros para la tabla Devolucion
- [ ] Crear generador de registros para la tabla Venta
- [ ] Crear generador de registros para la tabla Control_Inventario
- [ ] Crear generador de registros para la tabla Registro_Reposicion
  </br>// Tareas por hacer para el proyecto principal (Frontend y Backend) aun por definir

## Tareas en proceso
> Añade aqui la tarea que estas realizando actualmente con un guion seguida por tu usuario de github o tu nombre.
> Ejemplo: - [ ] Hacer que el proyecto se vea cool - @usuario

- [ ] Crear el generador de numeros del sat - @neftaligc
- [ ] Crear generador de receta medica - @JFT-314
- [ ] Crear generador de registros para la tabla Lote - @JFT-314
- [ ] Crear generador de registros para la tabla Producto - @JFT-314
- [ ] Crear generador de registros para la tabla Inventario @anorak1221


## Tareas realizadas
- [x] Crear generador de nombres de personas y proveedores
- [x] Crear generador de fechas
- [x] Crear generador de emails
- [x] Crear generador de numeros telefonicos
- [x] Crear generador de codigos postales
- [x] Crear generador de RFCs
- [x] Separar el generador de fechas a una clase aparte - @neftaligc
- [x] Separar el generador de nombres de proveedores a una clase aparte - @neftaligc
- [x] Crear el generador de emails para proveedores (En la clase emailGenerator) - @neftaligc
- [x] Crear el generador de nombres de farmacias - @neftaligc
- [x] Crear generador de nombres de medicamentos - @JFT-314
- [x] Crear generador de descripciones de medicamentos - @JFT-314
- [x] Crear generador de IDs (tanto numericos como alfanumericos para claves primarias unicas y compuestas) - @JFT-314
- [X] Crear generador de metodos de pago - @JFT-314
- [X] Crear generador de horas - @cruzz9
- [x] Crear generador de registros para la tabla Categoria - @JFT-314
- [x] Crear generador de registros para la tabla Cliente @anorak1221
- [x] Crear generador de registros para la tabla Proveedor - @neftaligc
- [X] Crear generador de puestos de empleo - @cruzz9
- [X] Crear generador de precios de medicamentos - @cruzz9
- [X] Crear generador de salarios - @cruzz9
- [X] Crear interfaz grafica de login @anorak1221
- [X] Crear generador de registros para la tabla Farmacia @anorak1221


## Estructura del proyecto
  El proyecto tiene la siguiente estructura:
En la carpeta `src` se encuentran los archivos de código fuente.
donde `Java` es la carpeta que contiene los archivos de código fuente en Java.
se encotraran con las carpetas `DataGenerator` que servira para crear el programa
que genere los datos que poblaran las tablas de la base de datos.

En la carpeta `resources` se encuentran los archivos de recursos, ahi tambien se agregaran los
datos generados por los generadores para poblar las tablas.

En la carpeta `ProyectoDB` Se ubicara el proyecto en si, esto incluye al frontend
y al backend.

## Nota super importante
> Recuerda siempre mantener tu repositorio local actualizado con el repositorio remoto.
> Para ello, antes de realizar un commit, un push o incluso antes de empezar a trabajar, siempre realiza un pull para traer los cambios del repositorio remoto.
> Ejemplo: `git pull origin {nombre de la rama a la que quieres hacer pull}`
> Si tienes alguna duda, pregunta a un proyect manager o en el grupo de whatsapp.

## Como agregar cambios al repositorio
1. Elige una tarea por hacer de la lista de tareas por hacer.
2. Modifica el archivo README.md y marca la tarea como en proceso.
3. Realiza un commit al archivo README.md con el mensaje "Iniciando tarea: [nombre de la tarea]"
4. Realiza los cambios necesarios en el código fuente.
5. Realiza un commit con el mensaje "Finalizando tarea: [nombre de la tarea]"
6. Realiza un push de tus cambios al repositorio.
7. Crea un pull request para que tus cambios sean revisados y aceptados.
8. Marca la tarea como realizada en el archivo README.md
9. Repite el proceso con otra tarea por hacer.
10. Si tienes alguna duda, pregunta a un proyect manager o a un compañero de equipo.

## Como realizar un commit al repositorio
1. Abre la terminal de comandos.
2. Ubicate en la carpeta del repositorio.
3. Escribe el comando `git add .` para agregar todos los cambios al commit.
4. Escribe el comando `git commit -m "Mensaje del commit"` para realizar el commit.
5. Escribe el comando `git pull` para traer los cambios del repositorio remoto.
6. Escribe el comando `git push` para subir tus cambios al repositorio remoto.
7. Si tienes alguna duda, pregunta a un proyect manager o a un compañero de equipo.

## Como realizar un pull request al repositorio
1. Abre la página del repositorio en github.
2. Haz clic en el botón "Pull requests".
3. Haz clic en el botón "New pull request".
4. Selecciona la rama de tu repositorio que quieres subir al repositorio principal.
5. Haz clic en el botón "Create pull request".
6. Escribe un mensaje explicando los cambios que realizaste.
7. Haz clic en el botón "Create pull request".
8. Espera a que tu pull request sea revisado y aceptado.
9. Si tienes alguna duda, pregunta a un proyect manager o a un compañero de equipo.

## Como clonar el repositorio en tu computadora
1. Abre la terminal de comandos.
2. Ubicate en la carpeta donde quieres clonar el repositorio.
3. Escribe el comando `git clone` seguido de la URL del repositorio o clave SSH.
4. Se habra clonado el repositorio en tu computadora.
5. Si tienes alguna duda, pregunta a un proyect manager o a un compañero de equipo.

## Como actualizar el repositorio en tu computadora
1. Abre la terminal de comandos.
2. Ubicate en la carpeta del repositorio.
3. Escribe el comando `git pull` para traer los cambios del repositorio remoto.
4. Si tienes alguna duda, pregunta a un proyect manager o a un compañero de equipo.

## Tengo un problema con git al realizar un commit o un push
1. Pregunta a un proyect manager o a un compañero de equipo.
2. Si no puedes resolver el problema, pide ayuda en el grupo de whatsapp.
3. Si el problema persiste, pide a alguien mas que realice el commit o el push por ti.

## Tengo un problema con el código fuente
1. Pregunta a un proyect manager o a un compañero de equipo.
2. Si no puedes resolver el problema, pide ayuda en el grupo de whatsapp.

## Tengo una duda sobre el proyecto
1. Pregunta a un proyect manager o realiza tu pregunta en el grupo de whatsapp.

## Tengo una sugerencia para mejorar el proyecto
1. Realiza tu sugerencia en el grupo de whatsapp.

## Tengo una queja sobre el proyecto
1. Realiza tu queja en el grupo de whatsapp.

## Tengo una duda sobre git
1. Pregunta a un proyect manager o a un compañero de equipo.
2. Si no puedes resolver la duda, pide ayuda en el grupo de whatsapp.


