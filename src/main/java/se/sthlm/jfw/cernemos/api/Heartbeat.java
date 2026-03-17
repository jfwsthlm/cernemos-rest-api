package se.sthlm.jfw.cernemos.api;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Heartbeat
{
    @Scheduled(fixedRate = 5000)
    public void runHeartbeat()
    {
        System.out.println("Heartbeat.");
    }
}
