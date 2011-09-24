package Signals.Tester;

import Signals.Reader;

/**
 * Test class for the native EDF reader
 * @author Tom Pepels - 24 september 2011
 */
public class ReaderTester {

    public static void main(String args[]) {
        if (Reader.openEDFFile("C:\\ECG.edf") == 0) {
            System.out.println("Open file successful");
        }
        
        if (Reader.noOfSignals() > -1) {
            System.out.println("File has " + Reader.noOfSignals() + " signals.");
        } else {
            System.out.println("Reading number of signals failed.");
        }

        if (Reader.closeEDFFile() == 0) {
            System.out.println("Close file successful");
        }
        
        if (Reader.noOfSignals() == -1) {
            System.out.println("This should fail :)");
        } else {
            System.out.println("This should have failed.");
        }
    }
}
