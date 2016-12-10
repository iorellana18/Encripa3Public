package main;

import Interfaces.Server;
import java.util.StringTokenizer;

    // Se usa patron singleton y aqui se crea la vista del servidor
public class Main {
    public static void main(String[] args) {
        Server.getInstance();
    }
}
