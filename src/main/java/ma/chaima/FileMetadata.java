package ma.chaima;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.FileStatus;
import java.io.IOException;

public class FileMetadata {
    public static void main(String[] args) {
        try {
            Configuration conf = new Configuration();
            conf.set("fs.defaultFS", "hdfs://namenode:8020");
            FileSystem fs = FileSystem.get(conf);

            Path path = new Path("/user/hadoop/appData/test.txt");
            FileStatus status = fs.getFileStatus(path);
            System.out.println("Taille: " + status.getLen());
            System.out.println("Propriétaire: " + status.getOwner());
            System.out.println("Date de modification: " + status.getModificationTime());
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
