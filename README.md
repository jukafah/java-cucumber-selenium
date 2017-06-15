## java-cucumber

Test automation template for java-cucumber

**Resources**
- [Cucumber-JVM](https://cucumber.io/docs/reference/jvm)
- [Cucumber-JVM API](http://cucumber.github.io/api/cucumber/jvm/javadoc/)
- [Appium](http://appium.io/)
- [Appium client API](http://appium.github.io/java-client/)


### Setup

Install [Xcode](https://developer.apple.com/xcode/)
 - After installation, be sure to open and accept the license agreements
 - Ensure the Xcode command line tools are installed during the process

Install [IntelliJ](https://www.jetbrains.com/idea/download)
 - Install cucumber plugin
 - Preferences => Plugins => Cucumber for Java

Downlod [Appium Desktop](https://github.com/appium/appium-desktop).
 - This is what we will use to inspect the devices.

**Environment variables**

Open a terminal and proceed with the following:
```
$ open ~/.bash_profile
```

Set environment variables
```
export ANDROID_HOME=/path/to/android/sdk
export PATH=${PATH}:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools
export JAVA_HOME=$(/usr/libexec/java_home)
```

Save changes, close profile, close and reopen terminal.

**Homebrew**

```
$ ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
```

After installation:
```
$ brew doctor
Your system is ready to brew
```

**Node**
```
$ brew install node
```

**Git**
```
$ brew install git
```

**libimobiledevice - iOS**
```
$ brew install ilibmobiledevice
```

**carthage - iOS**
```
$ brew install carthage
```


**ios-deploy - iOS**
```
$ npm install -g ios-deploy
```
ios-deploy should be global.

### Usage

**Local**

Install dependencies (appium server)
```
$ npm install
```

Start Appium
```
$ ./node_modules/appium/build/lib/main.js
```

Running tests

**IntelliJ**

Create run configuration. This will allow you to run Scenarios by right clicking them and selecting run in IntelliJ.
- Run => Edit Configurations
- Create new Cucumber Java run configuration
    - Main class: cucumber.api.cli.Main
    - Glue: cucumber.steps cucumber.support
    - Feature or folder path: /path/to/features