# Adaptavist CLI

## First Steps:

### Step 1: Clone repository
To get started, clone the repository from GitHub using the following command:
```bash
git clone https://github.com/machopixel/diego-adaptavist.git
```

### Step 2: Build CLI
This project uses Gradle to automate some of the process.

Run the following command to create the Gradle Wrapper:
```bash
gradle wrapper
```

Run the following command to build the application Jar:
```bash
gradlew.bat bootJar
```

### Step 3: Run CLI
There is a shortcut to run the Jar, it will require to have Java as part of your path. To execute it, run the following command:
```bash
gradlew.bat bootJar
```

## Contributing:
This repo uses Spotless, please run the following command before creating a pull request:
```bash
gradlew.bat spotlessJavaApply
```

## Test:
To automatically run the test, please run the following command:
```bash
gradlew.bat test
```

## Debugging:
The application is configured to output bugging messages into the logs folder. Please see [logback.xml](src/main/resources/logback.xml) for configuration.

## Commands Supported
Currently, there is only one command supported.
- help
- count-words <file-path>

### Help
Will list available commands.
### count-words <file-path>
The path can be absolute or just a local file name. test.txt has been included to test functionality.
