package builders

@DslMarker
annotation class BuilderMarker

@BuilderMarker
abstract class Builder<T> {
    internal abstract fun build(): T
}