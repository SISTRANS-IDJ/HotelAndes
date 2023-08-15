plugins {
    java
    application
    alias(libs.plugins.spotless)
    alias(libs.plugins.flyway)
}

group = "edu.uniandes"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    runtimeOnly(libs.postgresql.driver)
    implementation(libs.slf4j)
    implementation(libs.hikaricp.pool)
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
        vendor.set(JvmVendorSpec.ADOPTIUM)
    }
}

application {
    mainClass.set("edu.uniandes.hotel.Main")
    mainModule.set("edu.uniandes.hotel")
}

tasks.compileJava {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-Xlint:unchecked")
    options.compilerArgs.add("-Xlint:deprecation")
}

spotless {
    encoding("UTF-8")
    java {
        googleJavaFormat().reflowLongStrings()
        formatAnnotations()
    }
    kotlinGradle {

    }
}

flyway {
    url = "jdbc:postgresql://postgres:5432/hotel"
    user = "admin"
    password = "password"
}
