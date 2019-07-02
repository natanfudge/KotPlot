tasks.register("generateTests"){
    group = "scripts"
    description = "Produces a greeting"
    doLast{
        println("Hello, World!")
    }
}