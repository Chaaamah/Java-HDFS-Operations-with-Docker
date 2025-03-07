package ma.chaima;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.FileStatus;
import java.io.IOException;

public class ListFiles {
    public static void main(String[] args) {
        try {
            Configuration conf = new Configuration();
            conf.set("fs.defaultFS", "hdfs://namenode:8020");
            FileSystem fs = FileSystem.get(conf);

            FileStatus[] status = fs.listStatus(new Path("/user/hadoop/appData"));
            for (FileStatus s : status) {
                System.out.println(s.getPath().toString());
            }
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}