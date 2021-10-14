package com.whatsappbomber;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws AWTException, InterruptedException {
        Scanner buffer = new Scanner(System.in);
        Robot robot = new Robot();

        System.out.println("Enter your spam text");
        String message = buffer.nextLine();
        System.out.println("Enter how many times you want to spam");
        int times = buffer.nextInt();
        StringSelection selectedString = new StringSelection(message);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selectedString, null);
        System.out.println("Bombing starts in 2 seconds ...!");
        Thread.sleep(5000);
        for (int i = 0; i < times; i++) {
            Thread.sleep(5000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }
    }

    
}
