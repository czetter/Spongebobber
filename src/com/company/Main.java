package com.company;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import com.company.UI.Window;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class Main implements NativeKeyListener {
    boolean ctrlPressed = false;

    public static void main(String[] args) {
        Window window = new Window();

        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new Main());
    }


    public static String spongebobber(String input) {
        String ret = "";
        input.toLowerCase();
        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0) {
                char toUpper = Character.toUpperCase(input.charAt(i));
                ret += toUpper;
            } else {
                ret += input.charAt(i);
            }
        }
        return ret;
    }

    public static String getClipboard() {
        String data = null;
        try {
            data = (String) Toolkit.getDefaultToolkit()
                    .getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return data;
    }

    public static void setClipboard(String data) {
        StringSelection selection = new StringSelection(data);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
    }

    public void nativeKeyPressed(NativeKeyEvent e) {
        if (e.getKeyCode() == NativeKeyEvent.VC_CONTROL) {
            setClipboard(spongebobber(getClipboard()));
        }

    }

    public void nativeKeyReleased(NativeKeyEvent e) {
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
    }
}
