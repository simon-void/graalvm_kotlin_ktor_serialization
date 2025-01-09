# graalvm_kotlin_ktor_serialization

a minimal http server written in Kotlin & Ktor, compiled to native using GraalVM. It's meant to be the Ktor version
of my project [native-spring-echo-kotlin](https://github.com/simon-void/native-spring-echo-kotlin) using a similar setup
but with Spring Boot.

## Status

working

## How to compile to native

### Preconditions

- make sure GraalVm is installed (`sdk install java 23.0.1-graalce`) and the default JDK by checking that `native-image` is available as a command. (of course this assumes that [sdk is installed](https://sdkman.io/install))
- make sure gcc is installed (`sudo apt-get install gcc`)
- on Ubuntu install libz-dev (`sudo apt-get install libz-dev`), if not on Ubuntu check the link in the troubleshooting section

### Compile Source
Compile to native by executing:
```
./gradlew nativeCompile
```

You should now be able to execute the native binary:
```
./build/native/nativeCompile/graalvm_kotlin_ktor_serialization
```

### Run the native binary
Now you can invoke the echo-server with a GET [http://localhost:8080/](http://localhost:8080/), e.g. with curl:
```
curl http://localhost:8080/
```
This should return: "GraalVM-Ktor-Serialisation-Demo"

## Troubleshooting

- if you get a BUILD FAILED with
```
/usr/bin/ld: cannot find -lz: No such file or directory
collect2: error: ld returned 1 exit status
```
check out this [StackOverflow](https://stackoverflow.com/questions/3373995/usr-bin-ld-cannot-find-lz)

**TLDR**: on Ubuntu do `sudo apt-get install libz-dev`