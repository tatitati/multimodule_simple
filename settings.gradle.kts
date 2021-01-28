rootProject.name = "demo"


include("domain", "application")

project(":application").projectDir = file("subprojects/application")
project(":domain").projectDir = file("subprojects/domain")
