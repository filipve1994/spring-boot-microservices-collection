# explanation

Every folder contains an application.yml file with the configuration for that specific application.
The application.yml file in the root folder (=> here config folder) contains the global configuration that applies to all applications.

Additionally to that, we can have profile-specific configuration in both the root folder and the application-specific folders.
In the screenshot above you can see that the discovery-service has configuration specific for the container profile.
However, in the root folder there is also a file called application-container.yml that will apply to all applications using the container profile.


-----------------------


The Spring Cloud Config Server module will locate the requested configurations in the following pattern according to the request path parameters:
```
/{application}/{profile}[/{label}]
/{application}.yaml
/{application}-{profile}.yaml
/{label}/{application}-{profile}.yaml
/{application}.properties
/{application}-{profile}.properties
/{label}/{application}-{profile}.propertiesPlaceholder 
**_{application}_** will map to **_spring.application.name_** on the client-side properties. 
```

The placeholder **_{profile}_** will map to _**spring.profiles.active**_, a comma separated list on the client-side properties.
Placeholder **_{label}_** will map to the _git_ label at the server-side and is default to master **_{label}_** is an optional parameter.