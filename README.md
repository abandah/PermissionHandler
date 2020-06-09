# PermissionHandler
[![Release](https://jitpack.io/v/abandah/PermissionHandler.svg?style=flat-square)](https://jitpack.io/#abandah/PermissionHandler)

> Permission handling library for Android and Java



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
    implementation 'com.github.abandah:PermissionHandler:0.0.2'
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
2- ACCESS_COARSE_LOCATION
3- ACCESS_FINE_LOCATION
4- ADD_VOICEMAIL
5- BODY_SENSORS
6- CALL_PHONE
7- CAMERA
8- GET_ACCOUNTS
9- PROCESS_OUTGOING_CALLS
10- READ_CALENDAR
11- READ_CALL_LOG
12- READ_CELL_BROADCASTS
13- READ_CONTACTS
14- READ_EXTERNAL_STORAGE
15- READ_PHONE_STATE
16- READ_SMS
17- RECEIVE_MMS
18- RECEIVE_SMS
19- RECEIVE_WAP_PUSH
20- RECORD_AUDIO
21- SEND_SMS
22- USE_SIP
23- WRITE_CALENDAR
24- WRITE_CALL_LOG
25- WRITE_CONTACTS
26- WRITE_EXTERNAL_STORAGE
