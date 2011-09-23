/* 
 * File:   ReadSignals.c
 * Author: Tom Pepels
 *
 * Created on 23 september 2011
 */

#include <stdio.h>
#include "edflib.h"

void openEDFFile(char *path, int samples);

int main() {
    printf("Testing ECG.edf file on C: rootdir. \n");
    openEDFFile("C:\\ECG.edf", 10);
    return 1;
}

void openEDFFile(char *path, int samples) {

    struct edf_hdr_struct hdr;
    printf("Opening file returned: %d (0 is success!) \n", edfopen_file_readonly(path, &hdr, EDFLIB_DO_NOT_READ_ANNOTATIONS));
    printf("File has %d signals.\n", hdr.edfsignals);
    double buf[samples];
    
    printf("%d Samples read. \n", edfread_physical_samples(hdr.handle, 0, samples, buf));
    
    int i = 0;
    for(i = 0; i < samples; i++) {
        printf("Reading %d: %f\n", i, buf[i]);
    }
    
    printf("Closing file returned: %d (0 is success!)\n", edfclose_file(hdr.handle));
}