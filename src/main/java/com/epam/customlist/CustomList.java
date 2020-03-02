package com.epam.customlist;
import com.epam.customlist.collection.*;
import org.apache.logging.log4j.*;
/**
 * Hello world!
 *
 */
public class CustomList 
{
	private static final Logger logger=LogManager.getLogger(CustomList.class);
    public static void main( String[] args )
    {
        MyList<Integer> testList=new MyList<Integer>();
        testList.add(10);
        testList.add(11);
        testList.add(12);
        logger.info(testList.toString());
        testList.set(0, 13);
        testList.set(2, 14);
        testList.set(5, 15);
        logger.info(testList.toString());
        logger.info(testList.remove(0));
        logger.info(testList.remove(4));
        logger.info(testList.remove(2));
    }
}
