# How-to release a new version?

* Find the new version number
  * The version number of the REXS API is based on Semantic Versioning (see https://semver.org/)
  * To test the release process, a suffix like `-alpha`, `-beta`, `-rc` (also possible with numbering, e.g.: `-rc1`) can be used
  * Example: `0.9.0` or `0.9.0-rc1` for a test run

* Set version number in POMs and commit

```
$ mvn versions:set -DnewVersion=0.9.0 -DgenerateBackupPoms=false
$ git add pom.xml
$ git commit -m '[release] prepare release rexs-api-java-0.9.0'
```

* Set a tag

```
$ git tag -a v0.9.0 -m 'release 0.9.0'
$ git push origin v0.9.0
```

* The tag automatically creates a release using GitHub actions and publishes it in Maven Central

* Set and commit version number for further development

```
$ mvn versions:set -DnewVersion=0.10.0-SNAPSHOT -DgenerateBackupPoms=false
$ git add pom.xml
$ git commit -m '[release] prepare for next development iteration'
$ git push origin master
```

* Delete test versions from Maven Central
  * Test versions do not need to remain in Maven Central unnecessarily and should be deleted
