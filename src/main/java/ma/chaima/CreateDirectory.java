package ma.chaima;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

public class CreateDirectory {
    public static void main(String[] args) throws IOException {
        try {
            Configuration conf = new Configuration();
            conf.set("fs.defaultFS", "hdfs://namenode:8020");
            FileSystem fileSystem = FileSystem.get(conf);

            Path path = new Path("/user/hadoop/appData");
            if (fileSystem.exists(path)) {
                fileSystem.mkdirs(path);
                System.out.println("Directory created successfully");
            }else {
                System.out.println("Directory already exists");
            }
            fileSystem.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
