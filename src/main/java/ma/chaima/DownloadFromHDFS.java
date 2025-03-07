package ma.chaima;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import java.io.IOException;

public class DownloadFromHDFS {
    public static void main(String[] args) {
        try {
            Configuration conf = new Configuration();
            conf.set("fs.defaultFS", "hdfs://namenode:8020");
            FileSystem fs = FileSystem.get(conf);

            Path src = new Path("/user/hadoop/appData/test.txt");
            Path dst = new Path("test_local_file.txt"); // Destination locale
            fs.copyToLocalFile(src, dst);
            System.out.println("Fichier telecharge avec succes !");
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
