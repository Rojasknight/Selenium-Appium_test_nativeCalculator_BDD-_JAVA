# Automatización para Android con Appium

Ejemplo básico de una prueba funcional automatizada usando Appium y TestNG. La aplicación automatizada fue [Shake Calc](https://play.google.com/store/apps/details?id=de.underflow.calc).

## Prerequisitos

* Tener instalado Eclipse y el plugin de TestNG.
* Tener instalado Appium.
* Tener configuradas las variables de entorno JAVA_HOME y ANDROID_HOME.

## Correr el proyecto

```
* Clonar el repositorio.
* Abrir Eclipse y dar clic en File y luego en Import.
* Importar el proyecto como un Maven Project.
* Iniciar Appium en el host 127.0.0.1 y el puerto 4723.
* Instalar [Shake Calc](https://play.google.com/store/apps/details?id=de.underflow.calc) en el dispositivo a usar
* Habilitar la depuración USB del dispositivo
* Actualizar el serial del dispositivo en el código fuente, este se obtiene corriendo el comando adb devices.
* Ejecutar la clase principal con TestNG.
```
