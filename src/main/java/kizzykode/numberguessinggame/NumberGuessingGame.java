/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package kizzykode.numberguessinggame;

/**
 *
 * @author Kizzy
 */
import javax.swing.*;


public class NumberGuessingGame {
      public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameUI gameUI = new GameUI();
            gameUI.initialize();
        });
    }
    }

