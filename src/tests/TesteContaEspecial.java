/*Nome: Enzo Mikael - RM:558887*/
package tests;

import models.ContaComum;
import models.ContaEspecial;

public class TesteContaEspecial {
    public static void main(String[] args) {
        ContaEspecial ce = new ContaEspecial();
        ce.abrirConta(123, 1000);
        System.out.println(ce.sacarValor(1000));
        System.out.println("Saldo: " + ce.getSaldo());
    }
}
