<p align="center">
    <img align="center" src="./assets/icon.svg" height="150px">
</p>

<h1 align="center">Freenom4J</h1>
<h3 align="center">Freenom API wrapper for JVM languages.</h3>
<br>

<div align="center">

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]

</div>

## Documentation
Please refer to the [Wiki section][wiki-url].

## Installation
Replace VERSION with the latest version from [releases][releases-url].

### Maven
1. [Authenticate with GitHub Packages](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-apache-maven-registry#authenticating-to-github-packages)

2. Add repository
```xml
<repository>
  <url>https://maven.pkg.github.com/chocoearly44/freenom4j</url>
  <snapshots>
    <enabled>true</enabled>
  </snapshots>
</repository>
```

3. Add dependency
```xml
<dependency>
  <groupId>tk.thesuperlab</groupId>
  <artifactId>freenom4j</artifactId>
  <version>VERSION</version>
</dependency>
```

### Gradle
1. [Authenticate with GitHub Packages](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-apache-maven-registry#authenticating-to-github-packages)

2. Add repository
```groovy
repositories {
  maven {
    url = uri("https://maven.pkg.github.com/chocoearly44/freenom4j")
    credentials {
      username = System.getenv("USERNAME")
      password = System.getenv("TOKEN")
    }
  }
}
```

3. Add dependency
```groovy
dependencies {
  implementation 'tk.thesuperlab:freenom4j:VERSION'
}
```

## Bug reporting
If you encounter any bugs while using Freenom4J, please report them in the [Issues Section][issues-url].

## Support
You can receive additional support in a [Discussions Section][discussions-url].

[contributors-shield]: https://img.shields.io/github/contributors/chocoearly44/Freenom4J.svg?style=for-the-badge
[forks-shield]: https://img.shields.io/github/forks/chocoearly44/Freenom4J.svg?style=for-the-badge
[stars-shield]: https://img.shields.io/github/stars/chocoearly44/Freenom4J.svg?style=for-the-badge
[issues-shield]: https://img.shields.io/github/issues/chocoearly44/Freenom4J.svg?style=for-the-badge
[license-shield]: https://img.shields.io/github/license/chocoearly44/Freenom4J.svg?style=for-the-badge

[contributors-url]: https://github.com/chocoearly44/Freenom4J/graphs/contributors
[forks-url]: https://github.com/chocoearly44/Freenom4J/network/members
[stars-url]: https://github.com/chocoearly44/Freenom4J/stargazers
[issues-url]: https://github.com/chocoearly44/Freenom4J/issues
[license-url]: https://github.com/chocoearly44/Freenom4J/blob/master/LICENSE
[wiki-url]: https://github.com/chocoearly44/Freenom4J/wiki
[releases-url]: https://github.com/chocoearly44/Freenom4J/releases
[discussions-url]: https://github.com/chocoearly44/Freenom4J/discussions