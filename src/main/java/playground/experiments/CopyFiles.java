package playground.experiments;

import java.io.*;

public class CopyFiles {

    // Find what's wrong with this code

    private static void copyFiles(File file1, File file2) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(file1))) {

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file2))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                }
            }

        }
    }


    public static void main(String[] args) throws Exception {
        File file1 = new File("beans.xml");
        File file2 = new File("beans2.xml");
        //
        //        if (!file2.exists()) file2.createNewFile();
        //
        copyFiles(file1, file2);
    }
}
