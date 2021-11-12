
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.*;

public class RuntestTest 
{
    @Test
    public void runTestTest()
    {
        String out = TestRunner.runTest('f', "Addition", 100000, 5);
        String[] lines = out.split("\n");
        
        assertTrue("data type wrong",lines[0].equals("f"));
        assertTrue("Operation wrong",lines[1].equals("a"));
        assertTrue("negative Performance error", Double.parseDouble(lines[2]) > 0);
            
    }
}
