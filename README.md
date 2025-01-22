# CORE-UI

Librería para pantallas reutilizables en proyectos Jetpack Compose.

## Instalación

1. Agrega el repositorio JitPack en `settings.gradle`:

```gradle
dependencyResolutionManagement {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

2. Agrega la dependencia en el archivo build.gradle de tu módulo:
```gradle
dependencies {
    implementation("com.github.LuzCampos:CoreUi:0.0.2")
}
```
## Uso

Pantalla de Presentación
```
PresentationScreen(
    title = "¡Bienvenido!",
    titleColor = Color.Black,
    description = "Texto de presentación.",
    textButton = "Click aqui",
    contentColorButton = Color.Black
    painter = painterResource(R.drawable.mi_imagen), // Opcional
    onClickButton = {}  
)
```

Pantalla Informativa 1 
```
OverviewScreen(
    title = "Pantalla 1",
    description = "Información general.",
    painter = painterResource(R.drawable.mi_imagen) // Opcional
)
```

Pantalla Informativa 2
```
OverviewAltScreen(
    title = "Pantalla 2",
    description = "Más detalles.",
    painter = painterResource(R.drawable.mi_imagen) // Opcional
)
```
Nota: Si no pasas un recurso de imagen (painter), se mostrará una imagen predeterminada incluida en la librería.

## Compatibilidad

- Kotlin: 1.7.0 o superior.
- Jetpack Compose: 1.3.0 o superior.
- Gradle Plugin: 7.3.0 o superior.

## Licencia
Este proyecto está bajo la licencia MIT.

