package ma.chaima;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FsStatus;
import java.io.IOException;

public class FreeSpace {
    public static void main(String[] args) {
        try {
            Configuration conf = new Configuration();
            conf.set("fs.defaultFS", "hdfs://namenode:8020");
            FileSystem fs = FileSystem.get(conf);

            FsStatus status = fs.getStatus();
            System.out.println("Espace total: " + status.getCapacity());
            System.out.println("Espace utilisé: " + status.getUsed());
            System.out.println("Espace disponible: " + status.getRemaining());
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}