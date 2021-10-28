***VERSION***
PROJECT SDK: JAVA_1.8.0_202
CHROME BRWOSER: 95.0.4638.54 (Official Build) (64-bit)


***EXECUTION***
"mvn clean install -DskipTests" - so it will update dependencies without running the tests.
After that, the tests should run. If not, there may be conflicts between the dependency versions and it will need further investigation.
