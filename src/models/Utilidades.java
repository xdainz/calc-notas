package models;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public class Utilidades {
    static File data = new File("src/db/data.txt");
    static ArrayList<String> rawData = new ArrayList<>();
    public static ArrayList<Asignatura> asignaturas = new ArrayList<>();

    public static double redondearNota(double n){
        BigDecimal m = new BigDecimal(n).setScale(1, RoundingMode.HALF_UP);

        return m.doubleValue();
    }

    public static void checkData() throws Exception {

        if (!data.createNewFile()) {
            leerData();
        }
    }

    static void leerData() throws Exception {
        Scanner reader = new Scanner(data);

        while (reader.hasNextLine()){
           rawData.add(reader.nextLine());
        }
        parseData();
    }

    static void parseData() throws Exception {
        Asignatura holder = null;

       for (int i = 0; i <= (rawData.size() - 1); i++){
           if (rawData.get(i).equals("Asignatura")){
              Asignatura a = new Asignatura(rawData.get(i+1));
              holder = a;
              asignaturas.add(holder);
           }
           else if (rawData.get(i).equals("Nota")){
               Nota n = new Nota(Integer.parseInt(rawData.get(i+1)), Double.parseDouble(rawData.get(i+2)));
               holder.addNota(n);
           }
       }
    }

    public static void writeData() throws IOException {
        StringBuilder sb = new StringBuilder();
        FileWriter fw = new FileWriter(data);
        for (Asignatura a : asignaturas){
            sb.append("Asignatura\n");
            sb.append(a.getNombre());
            sb.append("\n");
            for (Nota n : a.getNotas()){
                sb.append("Nota\n");
                sb.append(String.valueOf(n.getPonderacion()));
                sb.append("\n");
                sb.append(String.valueOf(n.getNota()));
                sb.append("\n");
            }
        }
        fw.write(sb.toString());
        fw.close();

    }
}
