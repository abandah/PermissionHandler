# ErrorHandler
[![Release](https://jitpack.io/v/abandah/ErrorHandler.svg?style=flat-square)](https://jitpack.io/#abandah/ErrorHandler)

> Error handling library for Android and Java

Encapsulate error handling logic into objects that adhere to configurable defaults. Then pass them around as parameters or inject them via Web Service. 


Building with JitPack
=====

If you are using Gradle to get a GitHub project into your build, you will need to:

**Step 1.** Add the JitPack maven repository to the list of repositories:

```
gradle
   allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }

    }
}
```

**Step 2.**  Add the dependency information:

```
dependencies {
    implementation 'com.github.abandah:PermissionHandler:0.0.1'
}
```

**Step 3.**  Caller 

```
     Perm.With(this).withPermission(Manifest.permission.ACCESS_COARSE_LOCATION).Run(101);
```
Or just use preexisting Methods if it is available yet
```
     Perm.With(this).ACCESS_COARSE_LOCATION().Run(101);

```
**Step 4.**  Make Activity or Fragment extends PermissionListener and over ride the methods 

```
............ implements PermissionListener {
@Override
    public void onPermissionGranted(int index) {

    }

    @Override
    public void onPermissionDenied(int index) {

    }

    @Override
    public void onPermissionRationaleShouldBeShown(int index) {

    }
}
        
```
Preexisting Methods
=====
1- ACCESS_COARSE_LOCATION()
