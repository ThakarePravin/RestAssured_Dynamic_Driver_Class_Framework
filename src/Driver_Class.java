import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import Common_Function_Package.Utility_common_function;

public class Driver_Class {

	public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, 
	InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		//public static void main(String[] args) {
			//Post_TC_1.execute();
			ArrayList<String> testcaserun=Utility_common_function.readdataexcel("Test_Runner","TestCaseNameToExecute");
			int count =testcaserun.size();
			System.out.println("Count Of TC :"+ count);
			for (int i=1;i<count;i++)
			{
			String testcasename=testcaserun.get(i);
			System.out.println("test case name :"+testcasename);
			
			// call the testcaseclass on runtime by using java.lang.reflect package
			Class<?> testclassname= Class.forName("Test_Class_Package."+testcasename);
			
			// call the execute method belonging to test class captured in variable testclassname by using java.lang.reflect.method class
			Method executemethod=testclassname.getDeclaredMethod("execute");
			
			// set the accessibility of method true 
			executemethod.setAccessible(true);
			
			// create the instance of testclass captured in variable name testclassname
			Object instanceoftestclass=testclassname.getDeclaredConstructor().newInstance();
			
			// execute the testclass captured in variable name testclass name
			executemethod.invoke(instanceoftestclass);
			}
	}
}
