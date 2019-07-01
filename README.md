# What is this?
A type-safe kotlin library to display plots in a browser. It uses [Plotly.js](https://plot.ly/javascript/) internally. 
It is currently very early in development, but usable. 
# How do I add it to my project?
In `build.gradle`, add this:
```
repositories {
   //...
    maven { url "https://dl.bintray.com/natanfudge/kotplot"}
}
```

On the JVM add:
```
dependencies {
    //...
    implementation "com.fudge:kotplot-jvm:0.4"
}
```
In Javascript:
```
dependencies {
    //...
    implementation "com.fudge:kotplot-js:0.4"
}
```
On the common part of a multiplatform project:
```
dependencies {
    //...
    implementation "com.fudge:kotplot:0.4"
}
```
# How do I use this?
First create a plot:
```
val points = listOf(Point(0, 0), Point(1, 1), Point(2, 2))

val plot = KotPlot.plot {
    scatterTrace(points)
}
```

On the JVM you can just show it on your browser:
```
plot.show()
```
In Javascript that doesn't make much sense, so what you can do is **TODO**
