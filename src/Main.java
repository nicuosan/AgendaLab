import java.util.Scanner;

public class Main {
    static String[] agendaPersoane = new String[2];
    //ariabila globala
    static int index;

    public static void main(String[] args) {
        int optiune = -1;
        do {
            // userul vede un meniu si alege ceva
            // daca a ales iesire se termina
            // daca a ales afisare se afiseaza
            // daca a ales stergere se sterge

            optiune = readIntConsole("Tasteaza:" +
                    " 1 pt afisare agenda, " +
                    " 2 pt adaugare nume in agenda, " +
                    " 3 pt a cauta in agenda, " +
                    " 4 pt a modifica un nume in agenda, " +
                    " 5 pt a sterge nume din agenda, " +
                    " 7 pt iesire");
            if (optiune == 1) afisare();
            else if (optiune == 2) {
                String numele = readStringConsole("Numele:");
                adaugare(numele);
            }
            else if (optiune == 3) {
                int n = cautare(readStringConsole("Ce sa caut: "));
                System.out.println(n >= 0 ? "gasit" : "nu gasit");

            }
            else if (optiune == 4){
                afisare();
                modificare(readStringConsole("Introdu vechiul nume: "), readStringConsole("Introdu noul nume: "));
                afisare();

            }
            else  if (optiune == 5){
                afisare();
                stergere(readStringConsole("Cauta un nume: "));
            }
        } while (optiune != 7);
    }

    public static void afisare() {
        System.out.println("---afisare---");
        for (int i = 0; i < agendaPersoane.length; i++) {
            if (agendaPersoane[i] != null) System.out.println(agendaPersoane[i]);
        }
    }

    public static void adaugare(String nume) {
        if (index < agendaPersoane.length) {
            agendaPersoane[index] = nume;
            index++;
        }
    }

    public static void modificare(String vechiulNume, String noulNUme) {
        int gasit = cautare(vechiulNume);
        if (gasit != -1) agendaPersoane[gasit] = noulNUme;
    }

    public static void stergere(String nume) {
        int gasit = cautare(nume);
        if (gasit != -1) {
            if (readStringConsole("Esti sigur ca vrei sa stergi yes/no: ").equals("yes"))
                agendaPersoane[gasit] = null;
        }
    }

    public static int cautare(String nume) {
        int indexFound = -1;
        for (int i = 0; i < agendaPersoane.length; i++) {
            if (nume.equals(agendaPersoane[i])) {
                indexFound = i;
                //break;
            }
        }
        return indexFound;
    }

    public static int readIntConsole(String label) {
        System.out.print(label);
        int input = new Scanner(System.in).nextInt();
        return input;
    }

    public static String readStringConsole(String label) {
        System.out.print(label);
        String input = new Scanner(System.in).nextLine();
        return input;
    }
}
