<div align="center">
  <a href="https://developer.android.com/jetpack/compose">
    <img src="https://tabris.com/wp-content/uploads/2021/06/jetpack-compose-icon_RGB.png" alt="Jetpack Compose logo" title="Jetpack Compose logo" width="200" height="200" />
  </a>
</div>

# Jetpack Compose Android template

To create you own repo, click on:

[![Use this template](https://user-images.githubusercontent.com/38083522/226207439-1195c8c4-e3e2-4db0-8f39-7277b08872be.png)](https://github.com/seve-andre/jetpack-compose-template/generate)

> [!IMPORTANT]
> [Here](https://github.com/seve-andre/jetpack-compose-template/wiki#instructions) you can find
> detailed instructions on how to turn the template into your own app

## What does it use?

- [Kotlin](https://kotlinlang.org/) as main language
- [Jetpack Compose](https://developer.android.com/jetpack/compose) as modern toolkit for native UI
- [Material 3 components for Jetpack Compose](https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary#top-level-functions)
  to build UI faster
- [Room](https://developer.android.com/training/data-storage/room) as local persistent DB
- [Ktor client](https://ktor.io/docs/client-create-new-application.html): for api calls
- [Proto Datastore](https://developer.android.com/topic/libraries/architecture/datastore?gclid=CjwKCAjwkYGVBhArEiwA4sZLuMMCRUnWZzzy-AwDePYTUTn3gO6-rrT8jGo7D-H2vztegIJ-zEsb8hoCtI8QAvD_BwE&gclsrc=aw.ds)
  as typesafe data storage solution with protocol buffers support
- [Detekt](https://detekt.dev/) for static code analysis and formatting
- [Timber](https://github.com/JakeWharton/timber) for logging
- [Eva icons](https://github.com/DevSrSouza/compose-icons/blob/master/eva-icons/DOCUMENTATION.md)
  for the icons to use throughout the whole app
- [Coil](https://coil-kt.github.io/coil/compose/) for image loading backed by Kotlin coroutines
- [Splashscreen API](https://developer.android.com/develop/ui/views/launch/splash-screen) to display
  a splashscreen at app launch
- [Per-app language preferences](https://developer.android.com/guide/topics/resources/app-languages)
  to use a language inside the app that is different from the system language

## What does it offer?

- ⚫ dark theme support
- 🇬🇧 🇮🇹 in-app language preference
- 🔒 encrypted datastore
- 🔭 linting and formatting on PR
- 🔧 custom snackbars

## Screenshots

<details>
  <summary><strong>Light/dark theme</strong></summary>
  <img src="./screenshots/home-light.png" alt="Light theme home screen screenshot" title="Home light" height="500" />
  <img src="./screenshots/home-dark.png" alt="Dark theme home screen screenshot" title="Home dark" height="500" />
</details>

<details>
  <summary><strong>Language and theme pickers</strong></summary>
  <img src="./screenshots/language-picker.png" alt="Language picker screenshot" title="Language picker" height="500" />
  <img src="./screenshots/theme-picker.png" alt="Theme picker screenshot" title="Theme picker" height="500" />
</details>

### Inspo

- [version catalog](https://github.com/seve-andre/jetpack-compose-template/blob/main/gradle/libs.versions.toml): [see inspo](https://developer.android.com/build/migrate-to-catalogs)
- [Result](https://github.com/seve-andre/jetpack-compose-template/blob/main/app/src/main/kotlin/com/mitch/template/util/Result.kt): [see inspo](https://github.com/android/nowinandroid/blob/main/core/common/src/main/kotlin/com/google/samples/apps/nowinandroid/core/result/Result.kt)
- [TemplateAppState](https://github.com/seve-andre/jetpack-compose-template/blob/main/app/src/main/kotlin/com/mitch/template/ui/TemplateAppState.kt): [see inspo](https://github.com/android/nowinandroid/blob/main/app/src/main/kotlin/com/google/samples/apps/nowinandroid/ui/NiaAppState.kt)
- [NetworkMonitor](https://github.com/seve-andre/jetpack-compose-template/blob/main/app/src/main/kotlin/com/mitch/template/util/network/NetworkMonitor.kt): [see inspo](https://github.com/android/nowinandroid/blob/main/core/data/src/main/kotlin/com/google/samples/apps/nowinandroid/core/data/util/NetworkMonitor.kt)
- [ConnectivityManagerNetworkMonitor](https://github.com/seve-andre/jetpack-compose-template/blob/main/app/src/main/kotlin/com/mitch/template/util/network/ConnectivityManagerNetworkMonitor.kt): [see inspo](https://github.com/android/nowinandroid/blob/main/core/data/src/main/kotlin/com/google/samples/apps/nowinandroid/core/data/util/ConnectivityManagerNetworkMonitor.kt)

### Useful features

If you wanna implement some of the following things (not included by this template), consider
searching
in [Now in Android repo](https://github.com/android/nowinandroid) first:

- [TimeZone](https://github.com/search?q=repo%3Aandroid%2Fnowinandroid+timezone&type=code)
- [Analytics](https://github.com/search?q=repo%3Aandroid%2Fnowinandroid+analytics&type=code) (e.g.
  based on app product flavor)
- [Notifications](https://github.com/search?q=repo%3Aandroid%2Fnowinandroid%20notifi&type=code)
- [Crashlytics](https://github.com/search?q=repo%3Aandroid%2Fnowinandroid+crashlytics&type=code)
- [Sync data between local database and server](https://github.com/search?q=repo%3Aandroid%2Fnowinandroid+sync+language%3AKotlin&type=code&l=Kotlin)
- [Dismissable Snackbar](https://github.com/seve-andre/android-utils/blob/main/app/src/main/kotlin/com/mitch/androidutils/utils/snackbars/dismissable/SwipeToDismissSnackbarHost.kt)
- [Show snackbars from anywhere](https://github.com/philipplackner/GlobalSnackbarsCompose/tree/master)

> [!NOTE]
> Feel free to contribute or reach out to me at [my email](mailto:andrea.severi.dev@gmail.com?subject=[GitHub]%20Jetpack%20Compose%20Android%20Template)
