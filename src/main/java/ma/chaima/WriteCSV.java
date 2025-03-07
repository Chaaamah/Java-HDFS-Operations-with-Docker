package ma.chaima;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.FSDataOutputStream;
import java.io.IOException;

public class WriteCSV {
    public static void main(String[] args) {
        try {
            Configuration conf = new Configuration();
            conf.set("fs.defaultFS", "hdfs://namenode:8020");
            FileSystem fs = FileSystem.get(conf);

            String csvData = "ID,Nom,Prix\n1,Ordinateur,1200\n2,Souris,25\n3,Clavier,50";
            Path csvPath = new Path("/user/hadoop/appData/products.csv");
            FSDataOutputStream out = fs.create(csvPath);
            out.writeBytes(csvData);
            out.close();
            System.out.println("Fichier CSV est cree avec succes !");
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
