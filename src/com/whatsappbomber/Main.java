package com.whatsappbomber;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws AWTException, InterruptedException {
        final int interval = 2000;
        Scanner buffer = new Scanner(System.in);
        System.out.println("Enter your spam text");
        String message = buffer.nextLine();
        System.out.println("Enter how many times you want to spam");
        int times = buffer.nextInt();
        buffer.close();
        System.out.println("Bombing starts in a moment ...!");
        Bomb(message, times, interval);
    }

    private static void Bomb(String message, int times, int interval) throws InterruptedException, AWTException {
        Robot robot = new Robot();
        StringSelection selectedString = new StringSelection(message);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selectedString, null);
        Thread.sleep(interval);
        for (int i = 0; i < times; i++) {
            Thread.sleep(interval);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }
    }
}
