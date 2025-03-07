package ma.chaima;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.FSDataOutputStream;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args) {
        try {
            Configuration conf = new Configuration();
            conf.set("fs.defaultFS", "hdfs://namenode:8020");
            FileSystem fs = FileSystem.get(conf);

            Path filePath = new Path("/user/hadoop/appData/data.txt");
            FSDataOutputStream out = fs.create(filePath);
            out.writeBytes("Bienvenue sur HDFS avec Java.");
            out.close();
            System.out.println("Fichier cree avec succes !");
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
