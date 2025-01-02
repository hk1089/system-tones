[![](https://jitpack.io/v/hk1089/system-tones.svg)](https://jitpack.io/#hk1089/system-tones)

# System Tones Library

The **System Tones Library** is a lightweight and efficient library for Android that allows developers to manage and play system ringtones, notification tones, and alarm tones effortlessly. It simplifies the integration of tone selection and playback functionality in Android apps.

---

## Key Features
- **Retrieve System Tones**: Fetch all available system ringtones, notification tones, or alarm tones with their titles and URIs.
- **Modern Dependency Management**: Easily integrate with your project using JitPack.

---

## Gradle Setup

### Step 1: Add JitPack Repository

Add the JitPack repository to your `dependencyResolutionManagement` block in `settings.gradle`:

```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

### Step 2: Add the Library Dependency

Add the library to your `build.gradle` file:

```gradle
dependencies {
    implementation 'com.github.hk1089:system-tones:1.0.3'
}
```

## Usage

### Fetch System Notification Tones

Retrieve all available notification tones with their titles and URIs:

```kotlin
val tones = NotificationClass.getAllSystemNotificationTones(context)
tones.forEach { (title, uri) ->
    println("Tone Title: $title, URI: $uri")
}
```

### Fetch System Ringtones

Retrieve all available ringtones with their titles and URIs:

```kotlin
val tones = RingClass.getAllSystemRingtones(context)
tones.forEach { (title, uri) ->
    println("Tone Title: $title, URI: $uri")
}
```

### Fetch System Alarm Tones

Retrieve all available alarm tones with their titles and URIs:

```kotlin
val tones = AlarmClass.getAllSystemAlarmTones(context)
tones.forEach { (title, uri) ->
    println("Tone Title: $title, URI: $uri")
}
```

## Benefits
- **Simplified Code**: Reduces boilerplate for tone management.
- **Customizable**: Support for ringtones, notifications, and alarms.
- **User-Friendly**: Minimal setup and seamless integration.

## Notes
- Compatible with Android API level 21+.
- Automatically manages tone resources to prevent memory leaks.
- Customizable to fit various app requirements.
