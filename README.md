# Spring health down monitor

## Usage

```
        <dependency>
            <groupId>it.zlays</groupId>
            <artifactId>springhealthdownmonitor</artifactId>
            <version>1.0.0</version>
        </dependency>
```

## Custom properties

```
# Custom properties
health.save.db=true

health.schedule.active=true
health.schedule.fixed.delay=5000
health.schedule.initial.delay=5000

health.test.active=true
health.test.failure.percent:50
```

### Actuator

```
# Actuator
management.endpoints.web.exposure.include=*
management.endpoints.web.exposure.exclude=health
management.endpoint.health.group.custom.show-components=always
management.endpoint.health.show-details=always
```

### LOG

```
# LOG
logging.level.it.zlays.springhealthdownmonitor=DEBUG
```

## Deploy

```
mvn clean deploy -Dgpg.passphrase="myPassphrase" -Pci-cd
```
