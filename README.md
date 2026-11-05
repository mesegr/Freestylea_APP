# Freestylea

App de Android para practicar freestyle. Te da material al azar para improvisar: terminaciones de rima, temáticas o palabras que cambian cada pocos segundos.

<p align="center">
  <img src="img/free1.jpg" width="49%" alt="Menú principal de Freestylea">
  <img src="img/free2.jpg" width="49%" alt="Pantalla de temáticas">
  <img src="img/free3.jpg" width="49%" alt="Pantalla de palabras aleatorias">
  <img src="img/free4.jpg" width="49%" alt="Pantalla de terminaciones">
</p>

## Modos de práctica

- **Terminaciones:** sufijos de rima al azar (-ar, -ente, -illo...) para que construyas los versos a partir de ellos.
- **Temáticas:** un listado amplio de temas (animales, mitología, espacio...) para improvisar sobre ellos.
- **Palabras:** más de 800 palabras que van apareciendo cada cierto tiempo (10 segundos por defecto, configurable).

## Descarga

[Freestylea 1.0.0 (APK)](https://github.com/mesegr/Freestylea_APP/releases/download/V1.0.0/Download.Freestylea.apk)

Requiere Android 7.0 o superior. Al instalarlo, Android puede pedirte permiso para instalar apps de orígenes desconocidos.

## Tecnologías

- Kotlin y Jetpack Compose
- Corrutinas para el flujo temporizado de palabras
- minSdk 24, targetSdk 35

## Estructura

```
Freestylea_APP/app/src/main/java/com/example/freestylea_app/
├── MainActivity.kt / UIMainMenu.kt   # Entrada y menú principal
├── Terminaciones/                    # Generador y pantalla de terminaciones
├── themes/                           # Generador y pantalla de temáticas
├── words/                            # Palabras aleatorias con intervalo
└── ui/theme/                         # Tema de la app
```

## Cómo compilar

1. Instala una versión reciente de Android Studio.
2. Clona el repo: `git clone https://github.com/mesegr/Freestylea_APP.git`
3. Abre la carpeta `Freestylea_APP` con Android Studio y espera a que Gradle sincronice.
4. Pulsa **Run** con un emulador o un móvil conectado.

## Errores y sugerencias

Abre una [issue](https://github.com/mesegr/Freestylea_APP/issues) indicando qué pasó y cómo reproducirlo.
