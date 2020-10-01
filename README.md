# demobug ValidationService

## 
This project illustrates a potential bug when using Smallrye GraphQL.

Packaging in native mode:
> mvn package -Pnative

fails with the following error:
>com.oracle.graal.pointsto.constraints.UnsupportedFeatureException: Class initialization of io.smallrye.graphql.cdi.validation.ValidationService failed
> ...
> Caused by: java.lang.NoClassDefFoundError: Could not initialize class io.smallrye.graphql.cdi.validation.ValidationService

Setting the following property in application.properties solves the pb:
> quarkus.native.additional-build-args= --initialize-at-run-time=io.smallrye.graphql.cdi.validation.ValidationService

But the consequences of this workaround are unclear. Is there a risk in production in terms of robustness or performance?

Anyway I guess this kind of workaround should not be required.

== Environmennt

* macOS 10.13.6
* OpenJDK 11.0.7
* GraalVM CE 20.20.0
* Maven 3.6.3