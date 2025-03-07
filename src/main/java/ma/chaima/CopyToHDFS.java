package ma.chaima;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocalFileSystem;
import org.apache.hadoop.fs.Path;

public class CopyToHDFS {
    public static void main(String[] args) {
        try {
            Configuration conf = new Configuration();
            conf.set("fs.defaultFS", "hdfs://namenode:8020");

            FileSystem hdfs = FileSystem.get(conf);

            LocalFileSystem localFS = FileSystem.getLocal(conf);

            Path localPath = new Path("file:///test.txt");
            Path hdfsPath = new Path("/user/hadoop/appData/test.txt");

            if (localFS.exists(localPath)) {
                hdfs.copyFromLocalFile(true, true, localPath, hdfsPath);
                System.out.println("Copie réussie vers HDFS !");
            } else {
                System.err.println("Fichier local introuvable: " + localPath);
            }

            hdfs.close();
            localFS.close();
        } catch (Exception e) {
            System.err.println("Erreur critique:");
            e.printStackTrace();
        }
    }
}