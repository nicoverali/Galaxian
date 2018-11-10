# Galaxian
Juego shooter en 2D realizado como proyecto de Tecnologías de Programación en la Universidad Nacional del Sur.
Se inspira en el clasico juego Galaxian, intendando darle un cambio moderno.

## Para docentes
Hacer clone de la branch feature-oleada (Es la branch por defecto/principal del respositorio)

### Integrantes 
* Nicolás Zuccala
* Carlos Canavides
* Nicolás Vera

## Guia de inicio

### Prerequisitos

El juego esta desarrollado utilizando la librería [LibGDX](https://libgdx.badlogicgames.com/), esta hace
uso de [Gradle](https://gradle.org/), una herramienta para automatizar la construcción del proyecto.
A su vez nosotros mismos hacemos uso de Gradle para administrar las dependencias de nuestro proyecto.

**No es necesario descargar Gradle** para utilizar el código; una característica llamada Gradle Wrapper
lo descargará automáticamente.

### Instalación
Por el momento no disponemos de una versión ejecutable del juego, se debe clonar el respositorio:

```
git clone https://github.com/nicoverali/Galaxian.git
``` 
En él habrá tres carpetas 
```
./Documentacion # Contiene diagramas e información del proyecto
./GTAViceCity # Ejercicio del proyecto, independiente del juego
./Proyecto # Codigo fuente del juego
```

Se debe importar la carpeta _Proyecto_ con algún IDE que sea compatible con Gradle:
* [IntelliJ IDEA](#Importar-con-IntelliJ-IDEA)
* [Eclipse](#Importar-con-Eclipse)

## Importar en IDE

### Importar con Intellij IDEA

* Abrir Intellij IDEA
* Elegir la opción _Open_
* Buscar la carpeta _Proyecto_ y abrir el archivo `build.gradle`

  ![Imgur](https://i.imgur.com/PiVrT2D.png)
* Seleccionar _Open as project_
* En la casilla _Gradle JVM_ seleccionar la ruta a la carpeta de **JDK**
* Presionar _OK_
* En caso de que se pregunte si se desea abrir el proyecto ya existente o eliminarlo e importar nuevamente el proyecto, seleccionar _Open existing project_
* Gradle empezará a construir el proyecto, **esto puede demorar un tiempo**
* Hay que agregar la configuración de ejecución, ir a la pestaña _Run_ -> _Edit configurations_
* Presionar el botón _+_ -> _Gradle_
* La configuración debe ser la siguiente (el nombre puede ser cualquiera):

  ![Imgur](https://i.imgur.com/PBHpspD.png)
  
La aplicación ya debe estar lista para ser ejectutada

### Importar con Eclipse

* Abrir Eclipse
* Ir a _File_ -> _Import_
* Seleccionar la opción _Gradle_ -> _Existing Gradle Project_, luego _Next_
* Especificar como ruta del proyecto la dirección a la carpeta _Proyecto_, de manera tal que la ruta sea `...\Galaxian\Proyecto`. Presionar _Next_
* Presionar nuevamente _Next_ en la ventana _Import Options_
* Se comenzará a configurar el proyecto
* La estructura del proyecto debería ser la siguiente:
  
  ![Imgur](https://i.imgur.com/V04rgKH.png)
* Gradle empezará a construir el proyecto, **esto puede demorar un tiempo**
* Una vez finalizado, hay que especificar la configuración de ejecución
* Ir a _Run_ -> _Run Configurations..._
* Doble click en _Gradle Project_
* La configuración debe ser la siguiente (el nombre puede ser cualquiera):

  ![Imgur](https://i.imgur.com/NzdG5Qe.png)
* _Apply_ -> _Run_

El juego deberia ejecutarse
