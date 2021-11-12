import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Writer;
import java.nio.file.Path;


public class TestRunner 
{
    public static String runTest(char dt, String testtype, int iter, int trials)
    {
       
        String[] args = new String[5];
        args[0] = "StressTest";//"C:\\Users\\Justin\\Desktop\\Fall 21\\CS projects\\CS3354Project\\benchmarker\\cs3354Project\\src\\StressTest";
        args[1] ="" + dt;
        args[2] = testtype;
        args[3] ="" + iter;
        args[4] ="" + trials;

        String pwd = System.getProperty("user.dir");
       
        try 
        {
        File f = new File("test.txt");
        FileWriter w= new FileWriter(f);
        w.append("d");
        w.close();

        String h = f.getAbsolutePath();

        Process p = Runtime.getRuntime().exec(args,null,new File(pwd));
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        StringBuilder s = new  StringBuilder();
        String l;
        while((l = r.readLine()) != null)
        {
                s.append(l + "\n");
        }
        return s.toString();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "ERROR";
        }
    
    }
}
