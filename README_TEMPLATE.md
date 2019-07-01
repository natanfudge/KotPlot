# What is this?
A type-safe Kotlin library to display plots in a browser. It uses [Plotly.js](https://plot.ly/javascript/) internally. 
It is currently very early in development, but usable. 
# How do I add it to my project?
In `build.gradle`, add this:
```
repositories {
   //...
   jcenter()
}
```

On the JVM add:
```
dependencies {
    //...
    implementation "com.fudge:kotplot-jvm:$VERSION"
}
```
In Javascript:
```
dependencies {
    //...
    implementation "com.fudge:kotplot-js:$VERSION"
}
```
On the common part of a multiplatform project:
```
dependencies {
    //...
    implementation "com.fudge:kotplot:$VERSION"
}
```

# How do I use it?
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
