package Signals;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.xvolks.jnative.JNative;
import org.xvolks.jnative.Type;
import org.xvolks.jnative.exceptions.NativeException;

/**
 *
 * @author Tom Pepels - 23 sept 2011
 */
public class Reader {

    private static JNative openEDFFile;
    private static JNative closeEDFFile;
    private static JNative noOfSignals;
    private static JNative readSamples;
    private static JNative signalName;
    
    /**
     * Opens an EDF file for reading.
     * @param filePath Path to the EDF File to open for reading.
     * @return 0 on success, else check edflib.h
     */
    public static int openEDFFile(String filePath) {
        try {
            openEDFFile = new JNative("ReadSignals.dll", "openEDFFile");
            openEDFFile.setRetVal(Type.INT);
            openEDFFile.setParameter(0, filePath);
            openEDFFile.invoke();
            return openEDFFile.getRetValAsInt();
        } catch (Exception ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    /**
     * Closes the currently opened EDF file
     * @return 0 if success, else check edflib.h
     */
    public static int closeEDFFile() {
        try {
            closeEDFFile = new JNative("ReadSignals.dll", "closeEDFFile");
            closeEDFFile.setRetVal(Type.INT);
            closeEDFFile.invoke();
            return closeEDFFile.getRetValAsInt();
        } catch (Exception ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    /**
     * Returns the number of signals in the currently opened EDF file.
     * @return -1 on fail, otherwise the amount of signals in the file.
     */
    public static int noOfSignals() {
        try {
            noOfSignals = new JNative("ReadSignals.dll", "noOfSignals");
            noOfSignals.setRetVal(Type.INT);
            noOfSignals.invoke();
            return noOfSignals.getRetValAsInt();            
        } catch (Exception ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    
}