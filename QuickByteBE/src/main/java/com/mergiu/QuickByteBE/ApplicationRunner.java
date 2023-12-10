package com.mergiu.QuickByteBE;

import com.mergiu.QuickByteBE.ui.MainUI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements CommandLineRunner {

    private final MainUI mainUI;

    public ApplicationRunner(MainUI mainUI) {
        this.mainUI = mainUI;
    }

    @Override
    public void run(String... args) throws Exception {
        mainUI.run();
    }
}