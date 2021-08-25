package edu.pucmm.eict;

import com.pusher.pushnotifications.PushNotifications;
import edu.pucmm.eict.util.PushNotification;
import io.javalin.Javalin;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        Javalin app = Javalin.create(config ->{
            config.addStaticFiles("/public"); //desde la carpeta de resources

        }).start(3000);


        app.get("/", ctx -> {
            // some code
            ctx.render("/public/templates/index.html");
        });

        TimeUnit.SECONDS.sleep(10);

        PushNotification.sendPushNotification("Se ha detectado una posible caída!","Informacion:");
    }


}
