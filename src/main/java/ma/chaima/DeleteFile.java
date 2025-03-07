package ma.chaima;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import java.io.IOException;

public class DeleteFile {
    public static void main(String[] args) {
        try {
            Configuration conf = new Configuration();
            conf.set("fs.defaultFS", "hdfs://namenode:8020");
            FileSystem fs = FileSystem.get(conf);

            Path path = new Path("/user/hadoop/appData/data_V1.txt");

            // Vérifier si le fichier existe avant suppression
            if (fs.exists(path)) {
                boolean success = fs.delete(path, false);
                if (success) {
                    System.out.println("Fichier supprime avec succes !");
                } else {
                    System.err.println("La suppression a echoue.");
                }
            } else {
                System.err.println("Le fichier n'existe pas : " + path);
            }

            fs.close();
        } catch (IOException e) {
            System.err.println("Erreur lors de la suppression :");
            e.printStackTrace();
        }
    }
}