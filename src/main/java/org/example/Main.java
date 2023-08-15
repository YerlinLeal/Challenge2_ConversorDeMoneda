package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String[] options = {"Conversor de monedas", "Salir"};
        String[] conversionOptions = {"Conversor de Colones a Dólares", "Conversor de Dólares a Colones", "Salir"};
        String selectedOption;
        int number;
        double dollarValue = -1;
        boolean dollarValueCollected = false;
        CoinConverter cc;
        selectedOption = (String) JOptionPane.showInputDialog(null, "Seleccione una opción de conversión",
                "Menú", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        do {
            try {
                if (selectedOption.equals("Conversor de monedas")) {
                    if (!dollarValueCollected) {
                        dollarValue = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor del dolar hoy"));
                        dollarValueCollected = true;
                    }
                    cc = new CoinConverter(dollarValue);
                    selectedOption = (String) JOptionPane.showInputDialog(null, "Elija la moneda a la que deseas convertir tu dinero",
                            "Monedas", JOptionPane.QUESTION_MESSAGE, null, conversionOptions, conversionOptions[0]);
                    if (selectedOption.equals("Conversor de Colones a Dólares")) {
                        number = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la cantidad de dinero que deseas covertir"));
                        JOptionPane.showMessageDialog(null, "₡" + number + " son $" + cc.colonToDolar(number));
                    } else if (selectedOption.equals("Conversor de Dólares a Colones")) {
                        number = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la cantidad de dinero que deseas covertir"));
                        JOptionPane.showMessageDialog(null, "$" + number + " son ₡" + cc.dolarToColon(number));
                    }
                    if (!selectedOption.equals("Salir") && JOptionPane.showConfirmDialog(null, "¿Desea continuar?", "Conversor de monedas",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        selectedOption = "Conversor de monedas";
                    } else {
                        selectedOption = "Salir";
                    }
                } else {
                    selectedOption = "Salir";
                }
            } catch (NullPointerException e) {
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debes ingresar un valor numérico", "Error", JOptionPane.ERROR_MESSAGE);
                selectedOption = "Conversor de monedas";
            }
        } while (!selectedOption.equals("Salir"));
        JOptionPane.showMessageDialog(null, "Programa terminado");
    }
}