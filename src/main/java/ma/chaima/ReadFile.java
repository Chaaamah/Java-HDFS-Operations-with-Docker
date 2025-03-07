package ma.chaima;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.FSDataInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        try {
            Configuration conf = new Configuration();
            conf.set("fs.defaultFS", "hdfs://namenode:8020");
            FileSystem fs = FileSystem.get(conf);

            Path filePath = new Path("/user/hadoop/appData/data.txt");
            FSDataInputStream in = fs.open(filePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
