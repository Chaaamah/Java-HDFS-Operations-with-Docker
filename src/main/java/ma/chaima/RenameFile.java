package ma.chaima;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import java.io.IOException;

public class RenameFile {
    public static void main(String[] args) {
        try {
            Configuration conf = new Configuration();
            conf.set("fs.defaultFS", "hdfs://namenode:8020");
            FileSystem fs = FileSystem.get(conf);

            Path oldPath = new Path("/user/hadoop/appData/data.txt");
            Path newPath = new Path("/user/hadoop/appData/data_V1.txt");
            boolean success = fs.rename(oldPath, newPath);
            if (success) System.out.println("Fichier renomme avec succes !");
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
