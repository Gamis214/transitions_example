# transitions example
Ejemplo de transitions dentro de una actividad y shared elements.

### Configuracion de Style.xml
```xml
<resources>
    <!-- Base application theme. -->
    <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
        <!-- Customize your theme here. -->
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>

        <!-- enable activity transitions -->
        <item name="android:windowActivityTransitions">true</item>
        <!-- enable window content transitions -->
        <item name="android:windowContentTransitions">true</item>

        <!-- specify enter and exit transitions -->
        <!--<item name="android:windowEnterTransition">@transition/changue_image_transform</item>
        <item name="android:windowExitTransition">@transition/changue_image_transform</item> -->

        <!-- if we don't specify reenter transition, by default exit transition is taken -->
        <!-- if we don't specify return transition, by default enter transition is taken -->

        <!-- specify shared element transitions -->
        <item name="android:windowSharedElementEnterTransition">@android:transition/move</item>
        <item name="android:windowSharedElementExitTransition">@android:transition/move</item>
    </style>
</resources>
```
### Generamos nuestras vistas
* Vista 1:
```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="10dp"
    android:id="@+id/groupView">

    <Button
        android:id="@+id/btn"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="CLICK ME"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        android:layout_marginTop="16dp" />

    <View
        android:layout_width="50dp"
        android:layout_height="50dp"
        android:background="@drawable/circulo"
        android:layout_marginTop="412dp"
        android:transitionName="circle"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        android:id="@+id/circle"
        app:layout_constraintBottom_toBottomOf="parent"
        android:layout_marginBottom="8dp" />

</android.support.constraint.ConstraintLayout>
```
* Vista 2:
```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="10dp"
    android:id="@+id/groupView">

    <View
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:background="@drawable/circulo"
        android:layout_marginTop="26dp"
        android:id="@+id/circle"
        android:transitionName="circle"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintRight_toRightOf="parent" />

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/lorem_in"
        app:layout_constraintBottom_toBottomOf="parent"
        android:layout_marginRight="-12dp"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintVertical_bias="0.349"
        android:layout_marginTop="8dp"
        app:layout_constraintTop_toBottomOf="@+id/circle"
        android:layout_marginLeft="8dp"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintHorizontal_bias="1.0" />

</android.support.constraint.ConstraintLayout>
```

* Ejecutamos el OnClick del boton utilizando las herramientas que nos proporcionan las versiones android 5.0
```java
Intent intent = new Intent(this,NextActivity.class);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this,
                new Pair<>(circle, ViewCompat.getTransitionName(circle))).toBundle());
```
