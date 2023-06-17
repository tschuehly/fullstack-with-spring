rootProject.name = "rapid-fullstack-demo"

includeBuild("E:\\Programmieren\\supabase-security-spring-boot-starter"){
    dependencySubstitution {
        substitute(module("de.tschuehly:supabase-security-spring-boot-starter")).using(project(":"))
    }
}