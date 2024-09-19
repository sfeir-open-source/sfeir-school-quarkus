<!-- .slide: class="with-code" -->

# Simple Quarkus logger

```Java[3,7]
package com.example;

import io.quarkus.logging.Log;

class MyService {
    public void doSomething() {
        Log.info("Simple!");
        Log.infof("Hello %s !", "Toto");
    }
}
```

Notes:

##==##

<!-- .slide: class="with-code" -->

# Simple Quarkus logger

```Java[2,5,8]
package com.example;
import org.jboss.logging.Logger;

public class MyService {
    private static final Logger log = Logger.getLogger(MyService.class);

    public void doSomething() {
        log.info("It works!");
    }
}
```
