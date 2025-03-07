package ma.chaima;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import java.io.IOException;

public class MoveFile {
    public static void main(String[] args) {
        try {
            Configuration conf = new Configuration();
            conf.set("fs.defaultFS", "hdfs://namenode:8020");
            FileSystem fs = FileSystem.get(conf);

            // Créer le répertoire de destination si nécessaire
            Path destDir = new Path("/user/hadoop/archive");
            if (!fs.exists(destDir)) {
                fs.mkdirs(destDir);
            }

            Path src = new Path("/user/hadoop/appData/test.txt");
            Path dst = new Path("/user/hadoop/archive/test.txt");
            boolean success = fs.rename(src, dst);
            if (success) System.out.println("Fichier deplace avec succes !");
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
